package org.simonolander.horloge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import org.simonolander.horloge.HorlogeService.Companion.createStartIntent
import org.simonolander.horloge.HorlogeService.Companion.createStopIntent
import org.simonolander.horloge.infrastructure.db.ChimeRepository
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.ui.destination.ChimeDestination
import org.simonolander.horloge.ui.destination.CreditsDestination
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
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold { paddingValues ->
                        NavHost(modifier = Modifier.padding(paddingValues), navController = navController, startDestination = "home") {
                            composable("home") {
                                HomeDestination(
                                    chimes = chimes,
                                    onStartChimeClick = ::startChime,
                                    onStopChimeClick = ::stopChime,
                                    onAddChimeClick = { navController.navigate("chime/${Chime.randomId()}") },
                                    onEditChimeClick = { navController.navigate("chime/${it.id}") },
                                    onCreditsClick = { navController.navigate("credits") },
                                )
                            }

                            composable(
                                "chime/{chimeId}",
                                arguments =
                                    listOf(
                                        navArgument("chimeId") {
                                            type = NavType.StringType
                                        },
                                    ),
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

                            composable("credits") {
                                CreditsDestination()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun startChime(chime: Chime) {
        startForegroundService(createStartIntent(this, chime))
    }

    private fun stopChime() {
        stopService(createStopIntent(this))
    }
}
