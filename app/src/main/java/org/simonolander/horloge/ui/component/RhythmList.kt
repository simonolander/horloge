package org.simonolander.horloge.ui.component

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.model.Rhythm
import org.simonolander.horloge.ui.theme.HorlogeTheme

@Composable
fun RhythmList(
    rhythms: List<Rhythm>,
    onAddClick: () -> Unit,
    onPlayClick: (Rhythm) -> Unit,
    onEditClick: (Rhythm) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Chimes", style = MaterialTheme.typography.headlineLarge)
            IconButton(onClick = { onAddClick() }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add chime")
            }
        }
        if (rhythms.isEmpty()) {
            Text(text = "No chimes", style = MaterialTheme.typography.bodyLarge)
        }
        for (rhythm in rhythms) {
            RhythmView(
                rhythm = rhythm,
                onPlayClick = { onPlayClick(rhythm) },
                onEditClick = { onEditClick(rhythm) },
            )
        }
    }
}

@Composable
fun RhythmView(rhythm: Rhythm, onPlayClick: () -> Unit, onEditClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth(), onClick = onEditClick) {
        Box(Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.align(Alignment.TopEnd)) {
                IconButton(onClick = onPlayClick) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Play chime")
                }
            }
            Column(Modifier.padding(10.dp)) {
                Text(text = "Name", style = MaterialTheme.typography.labelLarge)
                Text(text = rhythm.name, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Beats", style = MaterialTheme.typography.labelLarge)
                Text(text = rhythm.beats.size.toString(), style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Preview
@Composable
fun RhythmListPreview() {
    val context = LocalContext.current
    val rhythms = listOf(
        Rhythm(
            id = "550e8400-e29b-41d4-a716-446655440000", name = "Pop and lock", beats = listOf()
        ),
        Rhythm(
            id = "123e4567-e89b-12d3-a456-426614174001", name = "Heartbeat", beats = listOf()
        ),
        Rhythm(
            id = "7c3d1fba-476f-4f97-8205-9217c7f0ac17", name = "Rainfall", beats = listOf()
        ),
        Rhythm(
            id = "f47ac10b-58cc-4372-a567-0e02b2c3d479", name = "Ocean waves", beats = listOf()
        ),
    )
    val toast = fun(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
    Surface(Modifier.padding(16.dp)) {
        HorlogeTheme {
            RhythmList(
                rhythms = rhythms,
                onAddClick = { toast("Add") },
                onPlayClick = { toast("Play ${it.name}") },
                onEditClick = { toast("Edit ${it.name}") },
            )
        }
    }
}