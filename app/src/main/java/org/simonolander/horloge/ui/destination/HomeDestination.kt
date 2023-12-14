package org.simonolander.horloge.ui.destination

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.ui.component.ChimeList

@Composable
fun HomeDestination(
    chimes: List<Chime>,
    onStartRhythm: (Chime) -> Unit,
    onStopRhythm: () -> Unit,
    onAddRhythm: () -> Unit,
    onEditRhythm: (Chime) -> Unit,
) {
    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onStopRhythm
        ) {
            Text(text = "Stop")
        }
        ChimeList(
            chimes = chimes,
            onAddClick = onAddRhythm,
            onPlayClick = onStartRhythm,
            onEditClick = onEditRhythm
        )
    }
}