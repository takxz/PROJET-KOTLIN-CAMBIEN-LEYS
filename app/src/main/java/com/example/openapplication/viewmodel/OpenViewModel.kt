package com.example.openapplication.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.openapplication.data.Action

class OpenViewModel : ViewModel() {
    private val _userActions = mutableStateListOf<Action>()
    val userActions: List<Action> = _userActions

    fun addAction(axe: String, nom: String, description: String, justificatifUri: String?) {
        val newAction = Action(axe = axe, nom = nom, description = description, justificatifUri = justificatifUri)
        _userActions.add(newAction)
    }
}
