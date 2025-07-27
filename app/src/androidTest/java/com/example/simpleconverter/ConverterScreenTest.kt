package com.example.simpleconverter

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.simpleconverter.ui.ConverterScreen
import com.example.simpleconverter.viewmodel.ConverterViewModel
import org.junit.Rule
import org.junit.Test

class ConverterScreenTest {
    @get:Rule val rule = createComposeRule()

    @Test fun inputUpdatesResult() {
        val vm = ConverterViewModel(TemperatureRepository())
        rule.setContent { ConverterScreen(vm) }

        rule.onNodeWithText("Value").performTextInput("100")
        rule.onNodeWithText("Result: 373.15").assertExists()
    }
}