package com.example.blutspendekompabilitaetsapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Rule @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkCompatibility() {
        onView(withId(R.id.spinner_blood_type)).perform(click())
        onView(withText("A+")).perform(click())
        onView(withId(R.id.btn_check)).perform(click())
        onView(withId(R.id.tv_result)).check(matches(withText("Kompatible Blutgruppen: A+, A-, O+, O-")))
    }
}
