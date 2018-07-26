package com.simplemobiletools.calculator.activities

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.helpers.SettingsHelper
import com.simplemobiletools.calculator.pageobjects.SettingsActivityPage
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SettingsActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule<SettingsActivity>(SettingsActivity::class.java,
            true, false)

    @After
    fun cleanUp() {
        activityRule.finishActivity()
        SettingsHelper().setUpDefaultSettings()
    }

    @Test
    fun settings_ActivityShouldContainAllRequiredSettingsOptions() {
        SettingsHelper().setUpDefaultSettings()
        activityRule.launchActivity(Intent())

        SettingsActivityPage().apply {
            verifyCustomizeColorsSetting(R.string.customize_colors)
            verifyCustomizeWidgetColorsSetting(R.string.customize_widget_colors)
            verifyUseEnglishSetting(R.string.use_english_language)
            verifyAvoidWhatsNewSetting(R.string.avoid_whats_new)
            verifyVibrateSetting(R.string.vibrate_on_button_press)
            verifyPreventPhoneSleepingSetting(R.string.prevent_phone_from_sleeping)
        }
    }

    @Test
    fun settings_WhenWasUseEnglishToggledEqualsFalse_UseEnglishSettingShouldNotBeDisplayed() {
        SettingsHelper().setUpDefaultSettings().wasUseEnglishToggled = false
        activityRule.launchActivity(Intent())

        SettingsActivityPage().apply {
            verifyCustomizeColorsSetting(R.string.customize_colors)
            verifyCustomizeWidgetColorsSetting(R.string.customize_widget_colors)
            verifyUseEnglishSetting(R.string.use_english_language, false)
            verifyAvoidWhatsNewSetting(R.string.avoid_whats_new)
            verifyVibrateSetting(R.string.vibrate_on_button_press)
            verifyPreventPhoneSleepingSetting(R.string.prevent_phone_from_sleeping)
        }
    }
}