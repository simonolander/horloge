package org.simonolander.horloge.ui.destination

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.ui.theme.HorlogeTheme

@Composable
fun CreditsDestination() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(text = "Credits", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Application", style = MaterialTheme.typography.headlineSmall)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = "Artwork and development", style = MaterialTheme.typography.labelLarge)
                Text(text = "Simon Olander", style = MaterialTheme.typography.bodyLarge)
            }
            IconButton(onClick = { uriHandler.openUri("https://www.simonolander.com") }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Navigate to website"
                )
            }
        }
        Text(text = "Music and sounds", style = MaterialTheme.typography.headlineSmall)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = "Nylon guitar strings", style = MaterialTheme.typography.labelLarge)
                Text(text = "Kyster", style = MaterialTheme.typography.bodyLarge)
            }
            IconButton(onClick = { uriHandler.openUri("https://freesound.org/people/Kyster/packs/7398") }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Navigate to website"
                )
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = "Bells and gongs", style = MaterialTheme.typography.labelLarge)
                Text(text = "Benboncan", style = MaterialTheme.typography.bodyLarge)
            }
            IconButton(onClick = { uriHandler.openUri("https://freesound.org/people/Benboncan/packs/4023") }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Navigate to website"
                )
            }
        }
    }
}

@Preview
@Composable
fun CreditsDestinationPreview() {
    Surface(Modifier.padding(10.dp)) {
        HorlogeTheme {
            CreditsDestination()
        }
    }
}