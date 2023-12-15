package org.simonolander.horloge.ui.destination

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import org.koin.compose.koinInject
import org.simonolander.horloge.infrastructure.db.chime.ChimeQueries
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.ui.component.ChimeList

@Composable
fun HomeDestination(
    chimes: List<Chime>,
    onStartChimeClick: (Chime) -> Unit,
    onStopChimeClick: () -> Unit,
    onAddChimeClick: () -> Unit,
    onEditChimeClick: (Chime) -> Unit,
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
    }
}