package com.simplemobiletools.calculator.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
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

    fun performAdditionOperation(firstDigit: Int, secondDigit: Int) {
        onView(withId(mapDigitToButton(firstDigit))).perform(click())
        onView(withId(R.id.btn_plus)).perform(click())
        onView(withId(mapDigitToButton(secondDigit))).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())

    }

    fun performSubtractionOperation(firstDigit: Int, secondDigit: Int) {
        onView(withId(mapDigitToButton(firstDigit))).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(mapDigitToButton(secondDigit))).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())

    }

    fun checkResult(expectedResult: String) {
        onView(withId(R.id.result)).check(matches(withText(expectedResult)))
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