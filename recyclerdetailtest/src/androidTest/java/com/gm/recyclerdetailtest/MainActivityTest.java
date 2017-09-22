package com.gm.recyclerdetailtest;

import android.support.test.espresso.FailureHandler;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.gm.recyclerdetailtest.activity.MainActivity;
import com.gm.recyclerdetailtest.helper.DescendantViewActions;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.gm.recyclerdetailtest.helper.ViewVisibleCheckAssertions.isVisible;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/13/17.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void testRecyclerAction() throws Exception {
        // By default you could only test direct actions on a recycler view. For example
        // you could "click" the view, navigate to another activity and verify conditions.

        // Chaining several RecyclerViewActions together.
        onView(withId(R.id.recyclerView)).perform(

                // First position the recycler view. Necessary to allow the layout
                // manager perform the scroll operation
                scrollToPosition(15),

                // Click the item to trigger navigation to detail view
                actionOnItemAtPosition(15, click())
        );

        /*// Check detail view
        onView(withId(R.id.favoriteStatus)).check(matches(withText(R.string.unfavorite)));
      //
        // return to main activity
        pressBack();*/
    }

//    @Test
//    public void testFavoriteToggle() throws Exception {
//        // More advanced test case testing toggling the favorite status on a particular row
//
//        // Chaining several actions together on the recycler view
//        onView(withId(R.id.recyclerView)).perform(
//
//                // First position the recycler view
//                scrollToPosition(25),
//
//                // Using the check view action, you can now test conditions of the view at position 25
//                actionOnItemAtPosition(25, DescendantViewActions.checkViewAction(matches(isCompletelyDisplayed()))),
//
//                // With the descendant actions provided, you can check the status of a descendant view using
//                // a standard check. Just provide way to find the descendant view and how you want to validate
//                // the view.
//                actionOnItemAtPosition(25, DescendantViewActions.checkDescendantViewAction(
//                        withId(R.id.favoriteButton), matches(withContentDescription(R.string.favorite)))),
//
//                // Or perform an action on a descendant view.
//                actionOnItemAtPosition(25,
//                        DescendantViewActions.performDescendantAction(withId(R.id.favoriteButton), click())),
//
//                // Then check to see the status change
//                actionOnItemAtPosition(25, DescendantViewActions.checkDescendantViewAction(
//                        withId(R.id.favoriteButton), matches(withContentDescription(R.string.unfavorite))))
//
//                // and non-existence of a view
////                actionOnItemAtPosition(25, DescendantViewActions.checkDescendantViewAction(withId(R.id.favoriteStatus), doesNotExist()))
//
//        );
//    }

    @Test
    public void testCheckDialogDisplayed() {

        onView(withId(R.id.recyclerView)).perform(

                // First position the recycler view
                scrollToPosition(25),

                // Using the check view action, you can now test conditions of the view at position 25
                actionOnItemAtPosition(25, DescendantViewActions.checkViewAction(matches(isCompletelyDisplayed()))),

                // With the descendant actions provided, you can check the status of a descendant view using
                // a standard check. Just provide way to find the descendant view and how you want to validate
                // the view.
                actionOnItemAtPosition(25, DescendantViewActions.checkDescendantViewAction(
                        withId(R.id.favoriteButton), matches(withContentDescription(R.string.favorite)))),

                // Or perform an action on a descendant view.
                actionOnItemAtPosition(25,
                        DescendantViewActions.performDescendantAction(withId(R.id.favoriteButton), click()))


        );

        // Check the dialog title text is displayed
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()));
    }
    @Test
    public void testClickOkButton() {

        onView(withId(R.id.recyclerView)).perform(

                scrollToPosition(25),

                actionOnItemAtPosition(25, DescendantViewActions.checkViewAction(matches(isCompletelyDisplayed()))),

                actionOnItemAtPosition(25, DescendantViewActions.checkDescendantViewAction(
                        withId(R.id.favoriteButton), matches(withContentDescription(R.string.favorite)))),

                actionOnItemAtPosition(25,
                        DescendantViewActions.performDescendantAction(withId(R.id.favoriteButton), click()))

        );

        // android.R.id.button1 = positive button
        onView(withId(android.R.id.button1)).perform(click());

    }

    @Test
    public void testClickCancelButton() {
        onView(withId(R.id.recyclerView)).perform(

                scrollToPosition(25),

                actionOnItemAtPosition(25, DescendantViewActions.checkViewAction(matches(isCompletelyDisplayed()))),

                actionOnItemAtPosition(25, DescendantViewActions.checkDescendantViewAction(
                        withId(R.id.favoriteButton), matches(withContentDescription(R.string.favorite)))),

                actionOnItemAtPosition(25,
                        DescendantViewActions.performDescendantAction(withId(R.id.favoriteButton), click()))


        );
        // android.R.id.button2 = negative button
        onView(withId(android.R.id.button2)).perform(click());

        //onView(allOf(withId(R.id.favoriteButton), withText("sushil"))).check(matches(isDisplayed()));

//        onView(withId(R.id.favoriteStatus)).check(matches(withText("Sushil"))).perform(click());


//        onView(withId(R.id.favoriteButton)).check(isVisible());


    }



}