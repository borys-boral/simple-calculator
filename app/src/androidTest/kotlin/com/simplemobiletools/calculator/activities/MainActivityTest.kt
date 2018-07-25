package com.simplemobiletools.calculator.activities

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.simplemobiletools.calculator.pageobjects.MainActivityPage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun addition() {
        MainActivityPage().apply {
            performAdditionOperation(1, 2)
            verifyResult("3")
            verifyFormula("1+2")
        }
    }

    @Test
    fun subtraction() {
        MainActivityPage().apply {
            performSubtractionOperation(1, 2)
            verifyResult("-1")
            verifyFormula("1-2")
        }
    }

    @Test
    fun multiplication() {
        MainActivityPage().apply {
            performMultiplicationOperation(9, 8)
            verifyResult("72")
            verifyFormula("9*8")
        }
    }

    @Test
    fun division() {
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
    fun exponentiation() {
        MainActivityPage().apply {
            performExponentiationOperation(8, 2)
            verifyResult("64")
            verifyFormula("8^2")
        }
    }

    @Test
    fun root() {
        MainActivityPage().apply {
            performRootOperation(9)
            verifyResult("3")
            verifyFormula("√9")
        }
    }

    @Test
    fun percent() {
        MainActivityPage().apply {
            performPercentOperation(3, 8)
            verifyResult("0.24")
            verifyFormula("3%8")
        }
    }

    @Test
    fun toolbarMenuShouldContainSettingsAndAboutItems() {
        val mainActivityPage = MainActivityPage()
        mainActivityPage.clickToolbarMenu()
    }
}