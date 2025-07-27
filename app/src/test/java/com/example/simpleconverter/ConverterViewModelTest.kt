package com.example.simpleconverter

import com.example.simpleconverter.model.TemperatureUnit
import com.example.simpleconverter.repo.TemperatureRepository
import com.example.simpleconverter.viewmodel.ConverterViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterViewModelTest {
    private val repo = mockk<TemperatureRepository>()
    private val vm = ConverterViewModel(repo)

    @Test fun viewModelConverts() = runBlocking {
        every { repo.convert(1.0, TemperatureUnit.CELSIUS, TemperatureUnit.KELVIN) } returns 274.15
        vm.onInputChange("1")
        vm.onToChange(TemperatureUnit.KELVIN)
        val state = vm.uiState.first()
        assertEquals("274.15", state.result)
    }
}
2.2 UI Tests (Compose)
kotlin
// androidTest/ConverterScreenTest.kt
package com.example.simpleconverter

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.simpleconverter.ui.ConverterScreen
import org.junit.Rule

class ConverterScreenTest {
    @get:Rule val rule = createComposeRule()

    @Test fun inputUpdatesResult() {
        val vm = ConverterViewModel(TemperatureRepository())
        rule.setContent { ConverterScreen(vm) }

        rule.onNodeWithText("Value").performTextInput("100")
        rule.onNodeWithText("Result: 373.15").assertExists()
    }
}