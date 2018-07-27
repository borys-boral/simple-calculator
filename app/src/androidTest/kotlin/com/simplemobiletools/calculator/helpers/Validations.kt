package com.simplemobiletools.calculator.helpers

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers

fun verifyDescription(elementId: Int, resourceId: Int) {
    onView(ViewMatchers.withId(elementId)).check(ViewAssertions.matches(ViewMatchers.withText(resourceId)))
}

fun verifyIsElementDisplay(elementId: Int, shouldBeDisplayed: Boolean = true) {
    when (shouldBeDisplayed) {
        true -> onView(ViewMatchers.withId(elementId)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        else -> onView(ViewMatchers.withId(elementId)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
    }
}