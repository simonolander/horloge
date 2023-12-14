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
import org.simonolander.horloge.model.Chime
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
            val chimes = remember {
                mutableStateListOf(
                    Chime(
                        Chime.randomId(), "Pling plong", listOf(
                            Beat(Sound.D_2, 5.seconds, 0.seconds),
                            Beat(Sound.A_2, 4.seconds, 3.seconds),
                        )
                    )
                )
            }
            HorlogeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            HomeDestination(
                                chimes = chimes,
                                onStartRhythm = { startRhythm(it) },
                                onStopRhythm = { stopRhythm() },
                                onAddRhythm = {
                                    navController.navigate("chime/${Chime.randomId()}")
                                },
                                onEditRhythm = {
                                    navController.navigate("chime/${it.id}")
                                })
                        }
                        composable(
                            "chime/{chimeId}",
                            arguments = listOf(navArgument("chimeId") {
                                type = NavType.StringType
                            }),
                        ) { backStackEntry ->
                            val chimeId = backStackEntry.arguments?.getString("chimeId")
                            val chime = chimes.find { it.id == chimeId }
                            RhythmDestination(
                                chime = chime,
                                onSave = { newRhythm ->
                                    val index = chimes.indexOfFirst { it.id == chimeId }
                                    if (index != -1) {
                                        chimes[index] = newRhythm
                                    } else {
                                        chimes.add(0, newRhythm)
                                    }
                                    navController.popBackStack("home", false)
                                },
                                onDelete = {
                                    chimes.removeIf {
                                        it.id == chimeId
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

    private fun startRhythm(chime: Chime) {
        val intent = Intent(this, HorlogeService::class.java)
        intent.putExtra(
            HorlogeService.BEATS_KEY, chime.beats.toTypedArray()
        )
        startForegroundService(intent)
    }

    private fun stopRhythm() {
        stopService(Intent(this, HorlogeService::class.java))
    }
}