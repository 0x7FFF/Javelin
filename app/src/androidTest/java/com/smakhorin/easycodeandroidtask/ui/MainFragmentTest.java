package com.smakhorin.easycodeandroidtask.ui;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.smakhorin.easycodeandroidtask.MainActivity;
import com.smakhorin.easycodeandroidtask.R;
import com.smakhorin.easycodeandroidtask.RecyclerViewIdlingResource;
import com.smakhorin.easycodeandroidtask.main.presentation.MainFragment;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainFragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    RecyclerViewIdlingResource idlingResource;

    @Before
    public void setUp() {
        final MainFragment[] mainFragment = new MainFragment[1];

        activityRule.getScenario().onActivity(
            activity -> mainFragment[0] = (MainFragment) activity.getSupportFragmentManager().findFragmentById(R.id.container)
        );

        RecyclerViewIdlingResource idlingResource = new RecyclerViewIdlingResource(mainFragment[0].getRecyclerView());
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(idlingResource);
    }

    @Test
    public void testRecyclerViewItemClickCall() {
        onView(withText("Call")).perform(click());

        onView(withText("Information")).check(matches(isDisplayed()));

        onView(withText("OK")).check(matches(isDisplayed()));

        onView(withText("OK")).perform(click());
    }

    @Test
    public void testRecyclerViewItemClickChat() {
        onView(withText("Chat")).perform(click());

        onView(withText("Information")).check(matches(isDisplayed()));

        onView(withText("OK")).check(matches(isDisplayed()));

        onView(withText("OK")).perform(click());
    }

    @Test
    public void testOpenWebViewOnClick() {
        int position = 4;
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));

        onView(withId(R.id.webView)).check(matches(isDisplayed()));
    }

}

