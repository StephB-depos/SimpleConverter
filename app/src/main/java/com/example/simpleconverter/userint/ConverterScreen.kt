package com.example.simpleconverter.userint

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpleconverter.model.TemperatureUnit
import com.example.simpleconverter.viewmodel.ConverterViewModel

@Composable
fun ConverterScreen(vm: ConverterViewModel) {
    val state by vm.uiState.collectAsState()
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TemperatureUnit.values().forEach { unit ->
                Button(
                    onClick = { vm.onFromChange(unit) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (state.fromUnit == unit) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.secondary
                    )
                ) { Text("From ${unit.name}") }
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TemperatureUnit.values().forEach { unit ->
                Button(
                    onClick = { vm.onToChange(unit) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (state.toUnit == unit) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.secondary
                    )
                ) { Text("To ${unit.name}") }
            }
        }
        OutlinedTextField(
            value = state.input,
            onValueChange = vm::onInputChange,
            label = { Text("Value") },
            modifier = Modifier.fillMaxWidth()
        )
        Text("Result: ${state.result}", style = MaterialTheme.typography.headlineSmall)
    }
}