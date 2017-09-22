package com.gm.espressocontacttest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void testRecyclerAction() throws Exception {

        onView(withId(R.id.rv_contact_list)).perform(
                scrollToPosition(MainActivity.SELECT_POSITION),
                actionOnItemAtPosition(MainActivity.SELECT_POSITION, click())
        );

    }

    @Test
    public void testRecyclerActionWithToast() throws Exception {

        onView(withId(R.id.rv_contact_list)).perform(
                scrollToPosition(MainActivity.SELECT_POSITION),
                actionOnItemAtPosition(MainActivity.SELECT_POSITION, click())
        );

        onView(withText(MainActivity.MATCH_CONTACT_NAME_IN_TOAST))
                .inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));


        /*onView(allOf(withId(<Textviewid>), withText(<match text eg. sushil>))
    .check(matches(isDisplayed()));*/


    }

}
