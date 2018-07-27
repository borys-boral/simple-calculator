package com.simplemobiletools.calculator.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.helpers.verifyIsElementDisplayed
import com.simplemobiletools.calculator.helpers.verifyIsTextDisplayed

class SettingsActivityPage {

    private val labelCustomizeColors = R.id.settings_customize_colors_label
    private val holderCustomizeColors = R.id.settings_customize_colors_holder
    private val labelCustomizeWidgetColors = R.id.settings_customize_widget_colors_label
    private val holderCustomizeWidgetColors = R.id.settings_customize_widget_colors_holder
    private val useEnglish = R.id.settings_use_english
    private val holderUseEnglish = R.id.settings_use_english_holder
    private val avoidWhatsNew = R.id.settings_avoid_whats_new
    private val holderAvoidWhatsNew = R.id.settings_avoid_whats_new_holder
    private val vibrate = R.id.settings_vibrate
    private val holderVibrate = R.id.settings_vibrate_holder
    private val preventPhoneSleeping = R.id.settings_prevent_phone_from_sleeping
    private val holderPreventPhoneSleeping = R.id.settings_prevent_phone_from_sleeping_holder

    fun verifyCustomizeColorsSetting(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizeColors, resourceId)
        verifyIsElementDisplayed(labelCustomizeColors)
    }

    fun verifyCustomizeWidgetColorsSetting(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizeWidgetColors, resourceId)
        verifyIsElementDisplayed(labelCustomizeWidgetColors)
    }

    fun verifyUseEnglishSetting(resourceId: Int, shouldBeDisplayed: Boolean = true) {
        verifyIsTextDisplayed(useEnglish, resourceId)
        verifyIsElementDisplayed(useEnglish, shouldBeDisplayed)
    }

    fun verifyAvoidWhatsNewSetting(resourceId: Int) {
        verifyIsTextDisplayed(avoidWhatsNew, resourceId)
    }

    fun verifyVibrateSetting(resourceId: Int) {
        verifyIsTextDisplayed(vibrate, resourceId)
    }

    fun verifyPreventPhoneSleepingSetting(resourceId: Int) {
        verifyIsTextDisplayed(preventPhoneSleeping, resourceId)
    }

    fun goToCustomizeColors() {
        onView(withId(holderCustomizeColors)).perform(click())
    }

    fun goToCustomizeWidgetColors() {
        onView(withId(holderCustomizeWidgetColors)).perform(click())
    }

    fun clickUseEnglish() {
        onView(withId(holderUseEnglish)).perform(click())
    }

    fun clickAvoidWhatsNew() {
        onView(withId(holderAvoidWhatsNew)).perform(click())
    }

    fun clickVibrate() {
        onView(withId(holderVibrate)).perform(click())
    }

    fun clickPreventPhoneSleeping() {
        onView(withId(holderPreventPhoneSleeping)).perform(click())
    }
}