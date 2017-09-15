package com.gm.recyclerdetailtest.helper;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.view.View;

import org.hamcrest.Matcher;

/**
 * {@link ViewAction}s to interact with descendant view. For example when working with a
 * RecyclerView composed of cards, each card may have actions that could be performed. The current
 * RecyclerViewActions in espresso contrib only lets you perform an action on the top level view
 * for each item in the RecyclerView.
 * <p>
 * This class provides a few additional actions so that a test could "check" the state the specific
 * view at position XX in a recycler view or one of its descendants. It also provides the capability
 * to perform an action on a descendant view. While this class is designed to fill the gap
 * missing with RecyclerViews, there is no dependencies on the Recycler view and these actions
 * could be performed on any view that has descendants.
 * </p>
 */
public final class DescendantViewActions {

    /**
     * Perform an action on a descendant view.
     *
     * @param viewMatcher used to select the descendant view in the hierarchy
     * @param viewAction the action to perform against the descendant view
     * @return A ViewAction object that should be performed on the parent view
     */
    public static ViewAction performDescendantAction(Matcher<View> viewMatcher, ViewAction viewAction) {
        return ViewActions.actionWithAssertions(new DescendantViewAction(viewMatcher, viewAction));
    }

    /**
     * Perform a check against a view that only allows actions such as a view found by
     * RecyclerViewActions
     *
     * @param viewAssertion the assertion to check.
     * @return The ViewAction to perform
     */
    public static ViewAction checkViewAction(ViewAssertion viewAssertion) {
        return ViewActions.actionWithAssertions(new CheckAssertionAction(viewAssertion));
    }

    /**
     * Perform a check against a descendant view where the root only allows actions such
     * a view found by RecyclerView actions
     *
     * @param viewMatcher   used to select the descendant view in the hierarchy
     * @param viewAssertion the assertion to check
     * @return A ViewAction to be performed on the parent view
     */
    public static ViewAction checkDescendantViewAction(Matcher<View> viewMatcher, ViewAssertion viewAssertion) {
        return ViewActions.actionWithAssertions(new CheckDescendantViewAction(viewMatcher, viewAssertion));
    }
}
