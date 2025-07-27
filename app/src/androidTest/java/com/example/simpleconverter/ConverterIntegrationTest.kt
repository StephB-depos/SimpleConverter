package com.example.simpleconverter

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ConverterIntegrationTest {
    @get:Rule val hiltRule = HiltAndroidRule(this)

    @Before fun init() = hiltRule.inject()

    @Test fun repoInjected() {
        // If app starts without crash, DI works
    }
}