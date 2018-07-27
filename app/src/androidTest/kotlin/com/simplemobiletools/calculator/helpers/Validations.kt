package com.simplemobiletools.calculator.helpers

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers

fun verifyIsTextDisplayed(elementId: Int, text: String) {
    onView(withId(elementId)).check(matches(withText(text)))
}

fun verifyIsTextDisplayed(elementId: Int, resourceId: Int) {
    onView(withId(elementId)).check(matches(withText(resourceId)))
}

fun verifyIsElementDisplayed(elementId: Int, shouldBeDisplayed: Boolean = true) {
    when (shouldBeDisplayed) {
        true -> onView(withId(elementId)).check(matches(isDisplayed()))
        else -> onView(withId(elementId)).check(matches(Matchers.not(isDisplayed())))
    }
}