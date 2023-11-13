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
import org.simonolander.horloge.ui.theme.HorlogeTheme

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
                            startService(Intent(this@MainActivity, HorlogeService::class.java))
                        }) {
                            Text(text = "Launch service")
                        }
                        Button(modifier = Modifier.fillMaxWidth(), onClick = {
                            startForegroundService(Intent(this@MainActivity, HorlogeService::class.java))
                        }) {
                            Text(text = "Launch foreground service")
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