package com.gm.recyclerdetailtest.helper;

import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewFinder;
import android.support.test.espresso.util.HumanReadables;
import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

import static android.support.test.internal.util.Checks.checkNotNull;

/**
 * Perform one or more view actions on a descendant view. Useful when interacting with a recycler
 * view associated with cards with buttons or toggles
 */
/* package */ final class DescendantViewAction implements ViewAction {

    private final Matcher<View> viewMatcher;
    private final ViewAction viewAction;

    DescendantViewAction(Matcher<View> viewMatcher, ViewAction viewAction) {
        this.viewMatcher = viewMatcher;
        this.viewAction = viewAction;
    }

    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return new StringDescription()
                .appendText("Perform action ")
                .appendText(viewAction != null ? viewAction.getDescription() : "null")
                .appendText(" on descendant view ")
                .appendDescriptionOf(viewMatcher)
                .toString();
    }

    @Override
    public void perform(UiController uiController, View view) {

        checkNotNull(viewAction);

        ViewFinder viewFinder = ViewFinderHelper.buildViewFinder(viewMatcher, view);

        View descendantView = viewFinder.getView();

        if (descendantView == null) {
            throw new PerformException.Builder()
                    .withActionDescription(getDescription())
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(new RuntimeException("Descendant view not found"))
                    .build();
        }

        try {
            viewAction.perform(uiController, descendantView);
        }
        catch (Throwable t) {
            throw new PerformException.Builder()
                    .withActionDescription(getDescription())
                    .withViewDescription(HumanReadables.describe(descendantView))
                    .withCause(t)
                    .build();
        }
    }
}
