package com.example.simpleconverter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.simpleconverter.model.TemperatureUnit
import com.example.simpleconverter.repo.TemperatureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

data class ConverterUiState(
    val fromUnit: TemperatureUnit = TemperatureUnit.CELSIUS,
    val toUnit: TemperatureUnit = TemperatureUnit.FAHRENHEIT,
    val input: String = "",
    val result: String = ""
)

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val repo: TemperatureRepository
) : ViewModel() {
    private val _ui = MutableStateFlow(ConverterUiState())
    val uiState: StateFlow<ConverterUiState> = _ui.asStateFlow()

    fun onFromChange(unit: TemperatureUnit) = update { it.copy(fromUnit = unit) }
    fun onToChange(unit: TemperatureUnit)   = update { it.copy(toUnit = unit) }
    fun onInputChange(input: String)        = update { it.copy(input = input) }

    private fun update(transform: (ConverterUiState) -> ConverterUiState) {
        _ui.update(transform)
        recalc()
    }

    private fun recalc() {
        val state = _ui.value
        val v = state.input.toDoubleOrNull() ?: return
        val conv = repo.convert(v, state.fromUnit, state.toUnit)
        _ui.update { it.copy(result = "%.2f".format(conv)) }
    }
}