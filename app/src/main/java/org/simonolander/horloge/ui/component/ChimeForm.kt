package org.simonolander.horloge.ui.component

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.simonolander.horloge.model.Beat
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.model.Sound
import org.simonolander.horloge.model.Sounds
import org.simonolander.horloge.ui.theme.HorlogeTheme
import java.util.UUID
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Composable
fun ChimeForm(chime: Chime?, onSave: (Chime) -> Unit, onDelete: () -> Unit) {
    var name by remember { mutableStateOf(chime?.name ?: "") }
    var beats by remember { mutableStateOf(chime?.beats ?: emptyList()) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Chime", style = MaterialTheme.typography.headlineLarge)
            Row {
                IconButton(onClick = { showDeleteDialog = true }, enabled = chime != null) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete chime")
                }
                IconButton(onClick = {
                    val id = chime?.id ?: Chime.randomId()
                    onSave(Chime(id, name, beats))
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Save chime")
                }
            }
        }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
        )

        BeatList(beats = beats, onChange = { beats = it })
    }

    if (showDeleteDialog) {
        val dismiss = { showDeleteDialog = false }
        AlertDialog(
            onDismissRequest = dismiss,
            confirmButton = {
                TextButton(onClick = {
                    onDelete()
                    dismiss()
                }) { Text("Delete") }
            },
            dismissButton = { TextButton(onClick = dismiss) { Text("Cancel") } },
            icon = { Icon(imageVector = Icons.Default.Delete, contentDescription = "Dialog icon") },
            text = { Text(text = "Are you sure that you want to delete the chime?") },
        )
    }
}

@Composable
fun BeatList(beats: List<Beat>, onChange: (List<Beat>) -> Unit) {
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Beats", style = MaterialTheme.typography.headlineMedium)
            IconButton(onClick = {
                val list = beats.toMutableList()
                val topBeat = list.firstOrNull()
                list.add(0, Beat(
                    id = Beat.randomId(),
                    sound = topBeat?.sound ?: Sounds.ALL.first(),
                    period = topBeat?.period ?: 10.seconds,
                    delay = topBeat?.delay ?: 0.seconds,
                ))
                onChange(list)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add beat")
            }
        }
        if (beats.isEmpty()) {
            Text(text = "No beats", style = MaterialTheme.typography.bodyLarge)
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            for ((index, beat) in beats.withIndex()) {
                BeatView(beat) {
                    val list = beats.toMutableList()
                    if (it != null) {
                        list[index] = it
                    } else {
                        list.removeAt(index)
                    }
                    onChange(list)
                }
            }
        }
    }
}

@Composable
fun BeatView(beat: Beat, onChange: (Beat?) -> Unit) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    val sounds = Sounds.ALL
    Card {
        Column(Modifier.padding(4.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = beat.period.inWholeMilliseconds.toString(),
                label = { Text("Period (ms)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    onChange(beat.copy(period = toLong(it).milliseconds))
                })

            TextField(modifier = Modifier.fillMaxWidth(),
                value = beat.delay.inWholeMilliseconds.toString(),
                label = { Text("Delay (ms)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = {
                    onChange(beat.copy(delay = toLong(it).milliseconds))
                })

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it },
            ) {
                TextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    readOnly = true,
                    value = beat.sound.name,
                    onValueChange = {},
                    label = { Text("Sound") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    sounds.forEach { sound ->
                        DropdownMenuItem(text = { Text(sound.name) },
                            onClick = {
                                expanded = false
                                onChange(beat.copy(sound = sound))
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            trailingIcon = {
                                IconButton(onClick = {
                                    MediaPlayer.create(context, sound.resourceId).apply {
                                        setOnCompletionListener {
                                            reset()
                                            release()
                                        }
                                        start()
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Listen to beat"
                                    )
                                }
                            })
                    }
                }
            }

            Row {
                IconButton(onClick = { onChange(null) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete beat")
                }
                IconButton(onClick = {
                    MediaPlayer.create(context, beat.sound.resourceId).apply {
                        setOnCompletionListener {
                            reset()
                            release()
                        }
                        start()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow, contentDescription = "Listen to beat"
                    )
                }
            }
        }
    }
}

private fun toLong(string: String): Long {
    return string.filter { it.isDigit() }.takeIf { it.isNotEmpty() }?.toLong() ?: 0
}

@Preview
@Composable
fun ChimeFormPreview() {
    val context = LocalContext.current
    fun toast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
    Surface(Modifier.padding(16.dp)) {
        HorlogeTheme {
            ChimeForm(
                chime = null,
                onSave = { toast("Saved") },
                onDelete = { toast("Deleted") },
            )
        }
    }
}