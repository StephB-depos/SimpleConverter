package com.example.simpleconverter

import com.example.simpleconverter.model.TemperatureUnit
import com.example.simpleconverter.repo.TemperatureRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class TemperatureRepositoryTest {
    private val repo = TemperatureRepository()

    @Test fun celsiusToFahrenheit() {
        val result = repo.convert(0.0, TemperatureUnit.CELSIUS, TemperatureUnit.FAHRENHEIT)
        assertEquals(32.0, result, 0.1)
    }
}