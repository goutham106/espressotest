package com.gm.espressocontacttest;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.gm.espressocontacttest.service.LocationService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/25/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LocationActivityTest {
    @Rule
    public ActivityTestRule<LocationActivity> activityRule = new ActivityTestRule<>(LocationActivity.class, true, true);

    @Rule
    public ServiceTestRule mServiceTestRule = new ServiceTestRule();

    @Test
    public void testWithBoundService() throws TimeoutException {
        Intent serviceIntent =
                new Intent(InstrumentationRegistry.getTargetContext(), LocationService.class);

        IBinder binder = mServiceTestRule.bindService(serviceIntent);

        LocationService service = ((LocationService.LocalBinder) binder).getService();


        if (service.canGetLocation()) {


            double longitude = service.getLongitude();
            double latitude = service.getLatitude();
            assertThat(service.getLatitude(), is(any(Double.class)));

        }

        onView(withText("80.2245451")).inRoot(withDecorView(not(is(activityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }

}
