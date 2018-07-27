package com.simplemobiletools.calculator.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.helpers.verifyIsElementDisplayed
import com.simplemobiletools.calculator.helpers.verifyIsTextDisplayed

class CustomizationActivityPage {

    private val holderCustomizationTheme = R.id.customization_theme_holder
    private val labelCustomizationTheme = R.id.customization_theme_label
    private val customizationTheme = R.id.customization_theme
    private val holderCustomizationTextColor = R.id.customization_text_color_holder
    private val labelCustomizationTextColor = R.id.customization_text_color_label
    private val customizationTextColor = R.id.customization_text_color
    private val holderCustomizationBackgroundColor = R.id.customization_background_color_holder
    private val labelCustomizationBackgroundColor = R.id.customization_background_color_label
    private val customizationBackgroundColor = R.id.customization_background_color
    private val holderCustomizationPrimaryColor = R.id.customization_primary_color_holder
    private val labelCustomizationPrimaryColor = R.id.customization_primary_color_label
    private val customizationPrimaryColor = R.id.customization_primary_color
    private val holderCustomizationAppIconColor = R.id.customization_app_icon_color_holder
    private val labelCustomizationAppIconColor = R.id.customization_app_icon_color_label
    private val customizationAppIconColor = R.id.customization_app_icon_color

    private val holderApplyToAll = R.id.apply_to_all_holder
    private val applyToAll = R.id.apply_to_all

    private val dialogPurchaseThankYou = R.id.purchase_thank_you

    fun verifyThemeCustomization(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizationTheme, resourceId)
        verifyIsElementDisplayed(labelCustomizationTheme)
    }

    fun verifyCustomizationTextColor(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizationTextColor, resourceId)
        verifyIsElementDisplayed(labelCustomizationTextColor)
    }

    fun verifyCustomizationBackgroundColor(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizationBackgroundColor, resourceId)
        verifyIsElementDisplayed(labelCustomizationBackgroundColor)
    }

    fun verifyCustomizationPrimaryColor(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizationPrimaryColor, resourceId)
        verifyIsElementDisplayed(labelCustomizationPrimaryColor)
    }

    fun verifyCustomizationAppIconColor(resourceId: Int) {
        verifyIsTextDisplayed(labelCustomizationAppIconColor, resourceId)
        verifyIsElementDisplayed(labelCustomizationAppIconColor)
    }

    fun verifyApplyToAll(resourceId: Int) {
        verifyIsTextDisplayed(applyToAll, resourceId)
        verifyIsElementDisplayed(applyToAll)
    }

    fun clickApplyToAll() {
        onView(withId(holderApplyToAll)).perform(click())
    }

    fun verifyPurchaseDialog() {
        verifyIsDialogDisplayed()
    }

    private fun verifyIsDialogDisplayed() {
        onView(withId(dialogPurchaseThankYou))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
    }
}