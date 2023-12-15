package org.simonolander.horloge

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.compose.koinInject
import org.simonolander.horloge.infrastructure.db.ChimeRepository
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.ui.destination.ChimeDestination
import org.simonolander.horloge.ui.destination.HomeDestination
import org.simonolander.horloge.ui.theme.HorlogeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val repository: ChimeRepository = koinInject()
            val chimeFlow = remember { repository.getChimes() }
            val chimes by chimeFlow.collectAsState(initial = emptyList())
            HorlogeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {

                        composable("home") {
                            HomeDestination(
                                chimes = chimes,
                                onStartChimeClick = ::startChime,
                                onStopChimeClick = ::stopChime,
                                onAddChimeClick = { navController.navigate("chime/${Chime.randomId()}") },
                                onEditChimeClick = { navController.navigate("chime/${it.id}") },
                            )
                        }

                        composable(
                            "chime/{chimeId}",
                            arguments = listOf(navArgument("chimeId") {
                                type = NavType.StringType
                            }),
                        ) { backStackEntry ->
                            val chimeId = backStackEntry.arguments?.getString("chimeId")
                            val chime = chimes.find { it.id == chimeId }
                            ChimeDestination(
                                chime = chime,
                                onSave = { newChime ->
                                    repository.saveChime(newChime)
                                    navController.popBackStack("home", false)
                                },
                                onDelete = {
                                    if (chimeId != null) {
                                        repository.deleteChime(chimeId)
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

    private fun startChime(chime: Chime) {
        val intent = Intent(this, HorlogeService::class.java)
        intent.putExtra(
            HorlogeService.BEATS_KEY, chime.beats.toTypedArray()
        )
        startForegroundService(intent)
    }

    private fun stopChime() {
        stopService(Intent(this, HorlogeService::class.java))
    }
}