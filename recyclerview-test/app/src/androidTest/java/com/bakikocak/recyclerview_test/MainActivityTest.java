package com.bakikocak.recyclerview_test;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void selectAnItem_shouldDisplayTextView(){

        //Instead of using onData as we do on any regular adapterView, onView does the trick for recyclerViews
        //When index 5 is clicked, textView will be updated with "Rome" value.
        onView(withId(R.id.rv_main))
                .perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));

        onView(withId(R.id.tv_selected_item))
                .check(matches(withText("Rome")));
    }
}
