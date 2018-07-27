package com.simplemobiletools.calculator.activities

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.helpers.SettingsHelper
import com.simplemobiletools.calculator.pageobjects.CustomizationActivityPage
import com.simplemobiletools.commons.activities.CustomizationActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CustomizationActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule<CustomizationActivity>(CustomizationActivity::class.java,
            true, false)

    @Before
    fun initialize() {
        SettingsHelper().setUpDefaultSettings()
        activityRule.launchActivity(Intent())
    }

    @Test
    fun customizeColors_ActivityShouldContainAllRequiredSettingsOptions() {
        CustomizationActivityPage().apply {
            verifyThemeCustomization(R.string.theme)
            verifyCustomizationTextColor(R.string.text_color)
            verifyCustomizationBackgroundColor(R.string.background_color)
            verifyCustomizationPrimaryColor(R.string.primary_color)
            verifyCustomizationAppIconColor(R.string.app_icon_color)
            verifyApplyToAll(R.string.apply_to_all_apps)
        }
    }

    @Test
    fun customizeColors_WhenApplyToAllAppsButtonWasClicked_PurchaseDialogShouldBeDisplayed() {
        CustomizationActivityPage().apply {
            clickApplyToAll()
            verifyPurchaseDialog()
        }
    }
}