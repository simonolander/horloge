package org.simonolander.horloge

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.model.Rhythm
import org.simonolander.horloge.ui.component.RhythmList
import org.simonolander.horloge.ui.theme.HorlogeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rhythms = remember { mutableStateListOf<Rhythm>() }
            HorlogeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.padding(10.dp)) {
                        Button(modifier = Modifier.fillMaxWidth(), onClick = {
                            stopService(
                                Intent(
                                    this@MainActivity, HorlogeService::class.java
                                )
                            )
                        }) {
                            Text(text = "Stop")
                        }
                        RhythmList(
                            rhythms = rhythms,
                            onAddClick = { rhythms.add(Rhythm.Empty) },
                            onPlayClick = {
                                val intent = Intent(this@MainActivity, HorlogeService::class.java)
                                intent.putExtra(
                                    HorlogeService.BEATS_KEY,
                                    it.beats.toTypedArray()
                                )
                                startForegroundService(intent)
                            },
                            onEditClick = {}
                        )
                    }
                }
            }
        }
    }
}