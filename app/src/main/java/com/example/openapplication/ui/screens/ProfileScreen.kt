package com.example.openapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource
import com.example.openapplication.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openapplication.viewmodel.OpenViewModel

@Composable
fun ProfileScreen(viewModel: OpenViewModel) {
    val actions = viewModel.userActions
    val grouped = actions.groupBy { it.axe }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Mon Profil",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource( id = R.drawable.image),
                    contentDescription = "Photo de profil",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Thibault Corentin",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Promo : 2INFO",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = "mail : j.oeufpauchet@myges.fr",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
        Text(
            text = "Total des actions : ${actions.size}",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        grouped.forEach { (axe, list) ->
            var expanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                onClick = { expanded = !expanded }
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = axe,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "${list.size} action(s)",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    if (expanded) {
                        Spacer(modifier = Modifier.height(8.dp))
                        list.forEach { action ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Text(
                                    text = "• ${action.nom}",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                if (action.description.isNotEmpty()) {
                                    Text(
                                        text = "   ${action.description}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
