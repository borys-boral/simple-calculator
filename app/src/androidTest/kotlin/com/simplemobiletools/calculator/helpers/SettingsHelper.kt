package com.simplemobiletools.calculator.helpers

import android.content.Context
import android.support.test.InstrumentationRegistry
import com.simplemobiletools.calculator.extensions.config

class SettingsHelper(
        private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext) {

    fun getConfiguration() : Config = context.config

    fun setUpDefaultSettings(): Config {
        return context.config.apply {
            useEnglish = true
            wasUseEnglishToggled = true
            avoidWhatsNew = true
            vibrateOnButtonPress = true
            preventPhoneFromSleeping = true
        }
    }
}