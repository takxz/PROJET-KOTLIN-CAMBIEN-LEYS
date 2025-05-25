package com.example.openapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.openapplication.data.predefinedActionsByAxe
import com.example.openapplication.viewmodel.OpenViewModel

@Composable
fun AddActionScreen(viewModel: OpenViewModel) {
    var selectedAxe by remember { mutableStateOf("") }
    var selectedAction by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var justificatifUri by remember { mutableStateOf<String?>(null) }

    val axes = predefinedActionsByAxe.keys.toList()
    val actionsForSelectedAxe = predefinedActionsByAxe[selectedAxe] ?: emptyList()


    Column(modifier = Modifier.padding(16.dp)) {
        Text("Ajouter une Action", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        DropdownMenuAxe(axes, selectedAxe) { axe ->
            selectedAxe = axe
            selectedAction = predefinedActionsByAxe[axe]?.firstOrNull() ?: ""
        }

        Spacer(Modifier.height(8.dp))

        if (selectedAxe.isNotEmpty()) {
            DropdownMenuAction(actionsForSelectedAxe, selectedAction) { action ->
                selectedAction = action
            }
        }

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { justificatifUri = "file://dummy" }) {
            Text("Uploader un justificatif")
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedAxe.isNotEmpty() && selectedAction.isNotEmpty()) {
                    viewModel.addAction(selectedAxe, selectedAction, description, justificatifUri)
                    selectedAxe = ""
                    selectedAction = ""
                    description = ""
                    justificatifUri = null
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Valider")
        }
    }
}

@Composable
fun DropdownMenuAxe(options: List<String>, selected: String, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Text(if (selected.isEmpty()) "Choisir un axe" else selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    onSelect(option)
                    expanded = false
                }, text = { Text(option) })
            }
        }
    }
}

@Composable
fun DropdownMenuAction(options: List<String>, selected: String, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Text(if (selected.isEmpty()) "Choisir une action" else selected)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    onSelect(option)
                    expanded = false
                }, text = { Text(option) })
            }
        }
    }
}
