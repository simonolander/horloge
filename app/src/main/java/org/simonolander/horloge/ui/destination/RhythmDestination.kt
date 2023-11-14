package org.simonolander.horloge.ui.destination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.model.Rhythm
import org.simonolander.horloge.ui.component.RhythmForm

@Composable
fun RhythmDestination(
    rhythm: Rhythm?,
    onSave: (Rhythm) -> Unit,
    onDelete: () -> Unit,
) {
    Column(modifier = Modifier.padding(10.dp)) {
        RhythmForm(rhythm = rhythm, onSave = onSave, onDelete = onDelete)
    }
}