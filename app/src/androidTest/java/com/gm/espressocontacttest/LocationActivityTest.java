package com.gm.espressocontacttest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.gm.espressocontacttest.service.LocationService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static android.content.Context.LOCATION_SERVICE;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
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

    public LocationService service;
    protected LocationManager locationManager;

    boolean isBound = false;
    double longitude, latitude;

    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LocationService.LocalBinder binder = (LocationService.LocalBinder) iBinder;
            service = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Test
    public void testWithBoundService() throws TimeoutException {
        Intent serviceIntent =
                new Intent(InstrumentationRegistry.getTargetContext(), LocationService.class);

//        IBinder binder = mServiceTestRule.bindService(serviceIntent);

        mServiceTestRule.bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

//        LocationService service = ((LocationService.LocalBinder) binder).getService();

        if (isBound) {
//            service.showSettingsAlert();
            if (service.canGetLocation()) {
                longitude = service.getLongitude();
                latitude = service.getLatitude();
                assertThat(service.getLatitude(), is(any(Double.class)));
//            assertThat(service.getLatitude(), is(80.121218));

                System.out.println("latitude :" + latitude + "\n" + "longitude :" + longitude);

            }
        }
//        onView(withText("80.1212185")).inRoot(withDecorView(not(is(activityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
        System.out.println("latitude :" + latitude + "\n" + "longitude :" + longitude);
        System.out.println("Helloooooo This is test :)");
        Log.e("HAHAHAHHA", "Helloooooo This is test :)");

    }

}
