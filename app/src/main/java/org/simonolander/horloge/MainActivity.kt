package org.simonolander.horloge

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.simonolander.horloge.model.Beat
import org.simonolander.horloge.model.Rhythm
import org.simonolander.horloge.model.Sound
import org.simonolander.horloge.ui.destination.HomeDestination
import org.simonolander.horloge.ui.destination.RhythmDestination
import org.simonolander.horloge.ui.theme.HorlogeTheme
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val rhythms = remember { mutableStateListOf<Rhythm>(
                Rhythm(Rhythm.randomId(), "Pling plong", listOf(
                    Beat(Sound.D_2, 4.seconds, 0.seconds),
                    Beat(Sound.A_2, 5.seconds, 3.seconds),
                ))
            ) }
            HorlogeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeDestination(rhythms = rhythms,
                                onStartRhythm = { startRhythm(it) },
                                onStopRhythm = { stopRhythm() },
                                onAddRhythm = {
                                    navController.navigate("rhythm/${Rhythm.randomId()}")
                                },
                                onEditRhythm = {
                                    navController.navigate("rhythm/${it.id}")
                                })
                        }
                        composable(
                            "rhythm/{rhythmId}",
                            arguments = listOf(navArgument("rhythmId") {
                                type = NavType.StringType
                            }),
                        ) { backStackEntry ->
                            val rhythmId = backStackEntry.arguments?.getString("rhythmId")
                            val rhythm = rhythms.find { it.id == rhythmId }
                            RhythmDestination(
                                rhythm = rhythm,
                                onSave = { newRhythm ->
                                    val index = rhythms.indexOfFirst { it.id == rhythmId }
                                    if (index != -1) {
                                        rhythms[index] = newRhythm
                                    } else {
                                        rhythms.add(0, newRhythm)
                                    }
                                    navController.popBackStack("home", false)
                                },
                            )
                        }
                    }
                }
            }
        }
    }

    private fun startRhythm(rhythm: Rhythm) {
        val intent = Intent(this, HorlogeService::class.java)
        intent.putExtra(
            HorlogeService.BEATS_KEY, rhythm.beats.toTypedArray()
        )
        startForegroundService(intent)
    }

    private fun stopRhythm() {
        stopService(Intent(this, HorlogeService::class.java))
    }
}