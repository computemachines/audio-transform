package com.computemachines.audiotransform;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

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

    @Test
    public void startRecording_FabShowsFragment() {
        onView(withId(R.id.microphone_layout)).check(doesNotExist());
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.microphone_layout)).check(matches(isDisplayed()));
    }
}
