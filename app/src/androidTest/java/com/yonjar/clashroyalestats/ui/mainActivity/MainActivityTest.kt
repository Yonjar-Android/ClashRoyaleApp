package com.yonjar.clashroyalestats.ui.mainActivity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yonjar.clashroyalestats.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun when_user_navigates_to_mainInfoFragment_then_navigates_to_cardsFragment() {

        val textToAdd = "#8YCLLVCG"
        onView(withId(R.id.edTag)).perform(typeText(textToAdd))

        onView(withId(R.id.btnEnter)).perform(click())

        Thread.sleep(1000)
        onView(withId(R.id.cardsFragment2)).perform(click())
    }

    @Test
    fun when_user_navigates_to_mainInfoFragment_then_navigates_to_cardsFragment_and_views_firstCardDetail() {
        val textToAdd = "#8YCLLVCG"
        onView(withId(R.id.edTag)).perform(typeText(textToAdd))
        onView(withId(R.id.btnEnter)).perform(click())

        Thread.sleep(1000)

        onView(withId(R.id.cardsFragment2)).perform(click())

        onView(withId(R.id.rvCards)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }

    @Test
    fun when_user_navigates_to_mainInfoFragment_then_navigates_to_badges_and_views_firstBadgeDetail() {
        val textToAdd = "#8YCLLVCG"
        onView(withId(R.id.edTag)).perform(typeText(textToAdd))
        onView(withId(R.id.btnEnter)).perform(click())

        Thread.sleep(1000)

        onView(withId(R.id.badgesFragment2)).perform(click())

        onView(withId(R.id.rvBadges)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }
}