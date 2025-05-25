package com.example.openapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.openapplication.data.predefinedActionsByAxe
import com.example.openapplication.viewmodel.OpenViewModel

@Composable
fun ActionsScreen(viewModel: OpenViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Liste des actions OPEN par axe", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        predefinedActionsByAxe.forEach { (axe, actions) ->
            var expanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = axe, style = MaterialTheme.typography.titleMedium)
                        TextButton(onClick = { expanded = !expanded }) {
                            Text(if (expanded) "Masquer" else "Voir")
                        }
                    }

                    if (expanded) {
                        actions.forEach { action ->
                            Text(
                                text = "- $action",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
