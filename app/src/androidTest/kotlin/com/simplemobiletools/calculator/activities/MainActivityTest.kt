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
            checkResult("3")
        }
    }

    @Test
    fun subtraction() {
        MainActivityPage().apply {
            performSubtractionOperation(1, 2)
            checkResult("-1")
        }
    }
}