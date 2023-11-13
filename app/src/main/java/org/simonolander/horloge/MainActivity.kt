package org.simonolander.horloge

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.simonolander.horloge.model.Beat
import org.simonolander.horloge.ui.theme.HorlogeTheme
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HorlogeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Android")
                        Button(modifier = Modifier.fillMaxWidth(), onClick = {
                            val intent = Intent(this@MainActivity, HorlogeService::class.java)
                            intent.putExtra(
                                HorlogeService.BEATS_KEY,
                                arrayOf(Beat(4.seconds, R.raw.cello_pluck))
                            )
                            startForegroundService(intent)
                        }) {
                            Text(text = "Start")
                        }
                        Button(modifier = Modifier.fillMaxWidth(), onClick = {
                            stopService(Intent(this@MainActivity, HorlogeService::class.java))
                        }) {
                            Text(text = "Stop")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HorlogeTheme {
        Greeting("Android")
    }
}