package com.example.simpleconverter.repo

import com.example.simpleconverter.model.TemperatureUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TemperatureRepository @Inject constructor() {
    fun convert(
        value: Double,
        from: TemperatureUnit,
        to: TemperatureUnit
    ): Double {
        // normalize to Kelvin
        val kelvin = when (from) {
            TemperatureUnit.CELSIUS -> value + 273.15
            TemperatureUnit.FAHRENHEIT -> (value + 459.67) * 5 / 9
            TemperatureUnit.KELVIN -> value
        }
        // convert Kelvin to target
        return when (to) {
            TemperatureUnit.CELSIUS -> kelvin - 273.15
            TemperatureUnit.FAHRENHEIT -> kelvin * 9 / 5 - 459.67
            TemperatureUnit.KELVIN -> kelvin
        }
    }
}