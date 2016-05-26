package com.computemachines.audiotransform;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Test the MicrophoneDialog
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class FinderNewRecording {
    @Rule
    public ActivityTestRule<FinderActivity> mFinderRule = new ActivityTestRule<>(FinderActivity.class);

    @Before
    public void startRecording_FabShowsFragment() {
        ViewInteraction fragmentView = onView(withId(R.id.microphone_layout));

        fragmentView.check(doesNotExist());
        onView(withId(R.id.fab)).perform(click());
        fragmentView.check(matches(isDisplayed()));
    }

    @Test
    public void startRecording_pressBack() {
        Espresso.pressBack();
    }
    @Test
    public void startRecording_pressCancel() {
        onView(withId(R.id.microphone_cancel)).perform(click());
    }

    @After
    public void startRecording_fragmentIsDismissed() {
        onView(withId(R.id.microphone_layout)).check(doesNotExist());
    }
}
