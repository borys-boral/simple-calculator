package com.simplemobiletools.calculator.activities

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.simplemobiletools.calculator.extensions.config
import com.simplemobiletools.calculator.pageobjects.MainActivityPage
import com.simplemobiletools.commons.activities.AboutActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java,
            true, false)

    @Before
    fun initialize() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        context.config.avoidWhatsNew = true
        activityRule.launchActivity(Intent())
    }

    @Test
    fun addition_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performAdditionOperation(1, 2)
            verifyResult("3")
            verifyFormula("1+2")
        }
    }

    @Test
    fun subtraction_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performSubtractionOperation(1, 2)
            verifyResult("-1")
            verifyFormula("1-2")
        }
    }

    @Test
    fun multiplication_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performMultiplicationOperation(9, 8)
            verifyResult("72")
            verifyFormula("9*8")
        }
    }

    @Test
    fun division_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performDivisionOperation(7, 2)
            verifyResult("3.5")
            verifyFormula("7/2")
        }
    }

    /*
        In my opinion division by zero should return information about error instead of 0
    */
    @Test
    fun divisionByZero_ShouldDisplaysErrorMessage() {
        MainActivityPage().apply {
            performDivisionOperation(8, 0)
            verifyResult("Can't divide by 0")
            verifyFormula("8/0")
        }
    }

    @Test
    fun exponentiation_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performExponentiationOperation(8, 2)
            verifyResult("64")
            verifyFormula("8^2")
        }
    }

    @Test
    fun root_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performRootOperation(9)
            verifyResult("3")
            verifyFormula("√9")
        }
    }

    @Test
    fun percent_ShouldDisplayCorrectResult() {
        MainActivityPage().apply {
            performPercentOperation(3, 8)
            verifyResult("0.24")
            verifyFormula("3%8")
        }
    }

    @Test
    fun whenClearButtonWasClicked_LastDigitInResultTextViewShouldBeRemoved() {
        MainActivityPage().apply {
            performAdditionOperation(9, 9)
            clickClearButton()
            verifyResult("1")
            verifyFormula("9+9")
        }
    }

    @Test
    fun whenClearButtonWasClickedAndResultContainsOnlyOneDigit_ResultShouldBeEqualZero() {
        MainActivityPage().apply {
            performAdditionOperation(1, 2)
            clickClearButton()
            verifyResult("0")
            verifyFormula("1+2")
        }
    }

    @Test
    fun whenClearButtonWasPressedLong_AllDataInResultAndFormulaTextViewsShouldBeRemoved() {
        MainActivityPage().apply {
            performAdditionOperation(1, 2)
            clickClearButton(true)
            verifyResult("0")
            verifyFormula("")
        }
    }

    @Test
    fun whenUserSelectSettingsMenuItem_SettingsActivityShouldBeDisplayed() {
        Intents.init()
        MainActivityPage().goToSettings()
        intended(hasComponent(SettingsActivity::class.java.name))
        Intents.release()
    }

    @Test
    fun whenUserSelectAboutMenuItem_AboutActivityShouldBeDisplayed() {
        Intents.init()
        MainActivityPage().goToAbout()
        intended(hasComponent(AboutActivity::class.java.name))
        Intents.release()
    }
}