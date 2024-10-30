package com.kryptforge.stokal.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kryptforge.stokal.data.entities.Action
import com.kryptforge.stokal.ui.viewmodel.ActionViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.LaunchedEffect

@Composable
fun HomeScreen(actionViewModel: ActionViewModel = viewModel()) {
    val coroutineScope = rememberCoroutineScope()
    var actionList by remember { mutableStateOf<List<Action>>(emptyList()) }

    // Use LaunchedEffect to load actions when the screen is first composed
    LaunchedEffect(Unit) {
        actionList =
            actionViewModel.getAllActions()!! // Método que você deve implementar no seu ViewModel
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            coroutineScope.launch {
                actionViewModel.insert(Action(name = "Test Action 2", description = "Sample", type = "Type A", createdAt = System.currentTimeMillis()))
                actionList = actionViewModel.getAllActions()!! // Atualiza a lista após a inserção
            }
        }) {
            Text("Add and Get Action")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exibir todas as ações carregadas
        actionList.forEach { action ->
            Text("Action: ${action.name}, Description: ${action.description}")
        }
    }
}
