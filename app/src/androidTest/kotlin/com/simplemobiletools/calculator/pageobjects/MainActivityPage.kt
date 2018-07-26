package com.simplemobiletools.calculator.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.longClick
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.simplemobiletools.calculator.R

class MainActivityPage {

    private val buttonZero = R.id.btn_0
    private val buttonOne = R.id.btn_1
    private val buttonTwo = R.id.btn_2
    private val buttonThree = R.id.btn_3
    private val buttonFour = R.id.btn_4
    private val buttonFive = R.id.btn_5
    private val buttonSix = R.id.btn_6
    private val buttonSeven = R.id.btn_7
    private val buttonEight = R.id.btn_8
    private val buttonNine = R.id.btn_9

    private val buttonPlus = R.id.btn_plus
    private val buttonMinus = R.id.btn_minus
    private val buttonMultiply = R.id.btn_multiply
    private val buttonDivide = R.id.btn_divide
    private val buttonPower = R.id.btn_power
    private val buttonRoot = R.id.btn_root
    private val buttonPercent = R.id.btn_percent

    private val buttonEquals = R.id.btn_equals
    private val textViewResult = R.id.result
    private val textViewFormula = R.id.formula
    private val buttonClear = R.id.btn_clear

    fun performAdditionOperation(firstDigit: Int, secondDigit: Int) {
        performOperation(firstDigit, secondDigit, buttonPlus)
    }

    fun performSubtractionOperation(firstDigit: Int, secondDigit: Int) {
        performOperation(firstDigit, secondDigit, buttonMinus)
    }

    fun performMultiplicationOperation(firstDigit: Int, secondDigit: Int) {
        performOperation(firstDigit, secondDigit, buttonMultiply)
    }

    fun performDivisionOperation(firstDigit: Int, secondDigit: Int) {
        performOperation(firstDigit, secondDigit, buttonDivide)
    }

    fun performExponentiationOperation(firstDigit: Int, secondDigit: Int) {
        performOperation(firstDigit, secondDigit, buttonPower)
    }

    fun performRootOperation(digit: Int) {
        performOperation(digit, buttonRoot)
    }

    fun performPercentOperation(firstDigit: Int, secondDigit: Int) {
        performOperation(firstDigit, secondDigit, buttonPercent)
    }

    fun clickClearButton(isLongClick: Boolean = false) {
        when (isLongClick) {
            true -> clear(::longClick)
            else -> clear(::click)
        }
    }

    private fun clear(clickFunction: () -> ViewAction) {
        onView(withId(buttonClear)).perform(clickFunction())
    }

    fun verifyResult(expectedResult: String) {
        onView(withId(textViewResult)).check(matches(withText(expectedResult)))
    }

    fun verifyFormula(expectedResult: String) {
        onView(withId(textViewFormula)).check(matches(withText(expectedResult)))
    }

    fun goToSettings() {
        openContextualActionModeOverflowMenu()
        onView(withText("Settings")).perform(click())
    }

    fun goToAbout() {
        openContextualActionModeOverflowMenu()
        onView(withText("About")).perform(click())
    }

    private fun performOperation(firstDigit: Int, secondDigit: Int, operation: Int) {
        onView(withId(mapDigitToButton(firstDigit))).perform(click())
        onView(withId(operation)).perform(click())
        onView(withId(mapDigitToButton(secondDigit))).perform(click())
        onView(withId(buttonEquals)).perform(click())
    }

    private fun performOperation(digit: Int, operation: Int) {
        onView(withId(mapDigitToButton(digit))).perform(click())
        onView(withId(operation)).perform(click())
        onView(withId(buttonEquals)).perform(click())
    }

    private fun mapDigitToButton(digit: Int): Int {
        return when (digit) {
            1 -> buttonOne
            2 -> buttonTwo
            3 -> buttonThree
            4 -> buttonFour
            5 -> buttonFive
            6 -> buttonSix
            7 -> buttonSeven
            8 -> buttonEight
            9 -> buttonNine
            else -> buttonZero
        }
    }
}