package com.bakikocak.adapter_view_test;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void selectAnItem_shouldDisplayTextView(){
        //onData should be used when we test an adapterView
        onData(withData(4)).
                inAdapterView(withId(R.id.listview))
                .perform(click());

        onView(withId(R.id.tv_selected_item))
                .check(matches((isDisplayed())))
                .check(matches(withText("4")));

    }

    // Custom matcher to check the item with the data specified.
    private Matcher<Object> withData(final int i) {
        return new BoundedMatcher<Object,Item>(Item.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with the value " + i);
            }

            @Override
            protected boolean matchesSafely(Item item) {
                return item.toString().equals(String.valueOf(i));
            }
        };
    }
}
