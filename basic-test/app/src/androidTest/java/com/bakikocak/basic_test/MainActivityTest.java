package com.bakikocak.basic_test;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    /**
     * A JUnit {@link Rule @Rule} to launch your activity under test. This is a replacement
     * for {@link ActivityInstrumentationTestCase2}.
     * <p>
     * Rules are interceptors which are executed for each test method and will run before
     * any of your setup code in the {@link Before @Before} method.
     * <p>
     * {@link ActivityTestRule} will create and launch of the activity for you and also expose
     * the activity under test. To get a reference to the activity you can use
     * the {@link ActivityTestRule#getActivity()} method.
     */
    @Rule public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onButtonClick_shouldShowTextView(){
        //Check if textview was invisible
        onView(withId(R.id.tv_message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        //Perform click on the button
        onView(withId(R.id.main_button)).perform(click());
        //Check if textview was visible
        onView(withId(R.id.tv_message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void onButtonClick_shouldShowTheMessage(){
        //Check if textview's text was empty
        onView(withId(R.id.tv_message)).check(matches(withText("")));
        //Perform click on the button
        onView(withId(R.id.main_button)).perform(click());
        //Check if textview's text is set
        onView(withId(R.id.tv_message)).check(matches(withText(R.string.messageText)));
    }
}
