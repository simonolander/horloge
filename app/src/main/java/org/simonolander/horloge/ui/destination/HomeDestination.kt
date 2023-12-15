package org.simonolander.horloge.ui.destination

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.infrastructure.db.chime.ChimeQueries
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.ui.component.ChimeList
import org.simonolander.horloge.ui.theme.HorlogeTheme
import org.simonolander.horloge.util.toaster

@Composable
fun HomeDestination(
    chimes: List<Chime>,
    onStartChimeClick: (Chime) -> Unit,
    onStopChimeClick: () -> Unit,
    onAddChimeClick: () -> Unit,
    onEditChimeClick: (Chime) -> Unit,
    onCreditsClick: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onStopChimeClick
        ) {
            Text(text = "Stop")
        }
        ChimeList(
            chimes = chimes,
            onAddClick = onAddChimeClick,
            onPlayClick = onStartChimeClick,
            onEditClick = onEditChimeClick,
        )
        Button(modifier = Modifier.fillMaxWidth(), onClick = onCreditsClick) {
            Text(text = "Credits")
        }
    }
}

@Preview
@Composable
fun HomeDestinationPreview() {
    val toast = toaster(LocalContext.current)
    Surface(Modifier.padding(10.dp)) {
        HorlogeTheme {
            HomeDestination(
                chimes = emptyList(),
                onStartChimeClick = {toast("Start chime")},
                onStopChimeClick = {toast("Stop chime")},
                onAddChimeClick = {toast("Add chime")},
                onEditChimeClick = {toast("Edit chime")},
                onCreditsClick = {toast("Credits")},
            )
        }
    }
}