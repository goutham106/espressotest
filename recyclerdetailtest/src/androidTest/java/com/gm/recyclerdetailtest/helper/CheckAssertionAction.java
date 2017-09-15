package com.gm.recyclerdetailtest.helper;

import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.util.HumanReadables;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.internal.util.Checks.checkNotNull;

/**
 * An action that wraps a check assertion against a view. This class exists to cover
 * cases where the only option is to perform an action, but not a check() such as with
 * RecyclerViewActions
 */
public final class CheckAssertionAction implements ViewAction {

    private final ViewAssertion viewAssertion;

    public CheckAssertionAction(ViewAssertion viewAssertion) {
        this.viewAssertion = viewAssertion;
    }

    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Check assertion ";
    }

    @Override
    public void perform(UiController uiController, View view) {
        checkNotNull(viewAssertion);
        try {
            viewAssertion.check(view, null);
        }
        catch (Throwable e) {
            throw new PerformException.Builder()
                    .withActionDescription(getDescription())
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(e)
                    .build();
        }
    }
}
