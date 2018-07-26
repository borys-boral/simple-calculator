package com.simplemobiletools.calculator.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.simplemobiletools.calculator.R
import org.hamcrest.Matchers.not

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
        verifySettingDescription(labelCustomizeColors, resourceId)
        verifyIsSettingDisplay(labelCustomizeColors)
    }

    fun verifyCustomizeWidgetColorsSetting(resourceId: Int) {
        verifySettingDescription(labelCustomizeWidgetColors, resourceId)
        verifyIsSettingDisplay(labelCustomizeWidgetColors)
    }

    fun verifyUseEnglishSetting(resourceId: Int, shouldBeDisplayed: Boolean = true) {
        verifySettingDescription(useEnglish, resourceId)
        verifyIsSettingDisplay(useEnglish, shouldBeDisplayed)
    }

    fun verifyAvoidWhatsNewSetting(resourceId: Int) {
        verifySettingDescription(avoidWhatsNew, resourceId)
    }

    fun verifyVibrateSetting(resourceId: Int) {
        verifySettingDescription(vibrate, resourceId)
    }

    fun verifyPreventPhoneSleepingSetting(resourceId: Int) {
        verifySettingDescription(preventPhoneSleeping, resourceId)
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

    private fun verifySettingDescription(elementId: Int, resourceId: Int) {
        onView(withId(elementId)).check(matches(withText(resourceId)))
    }

    private fun verifyIsSettingDisplay(elementId: Int, shouldBeDisplayed: Boolean = true) {
        when (shouldBeDisplayed) {
            true -> onView(withId(elementId)).check(matches(isDisplayed()))
            else -> onView(withId(elementId)).check(matches(not(isDisplayed())))
        }
    }
}