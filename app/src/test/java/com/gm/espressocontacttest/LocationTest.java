package com.gm.espressocontacttest;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.gm.espressocontacttest.service.LocationService;

import static android.content.Context.LOCATION_SERVICE;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/26/17.
 */
public class LocationTest extends ServiceTestCase<LocationService> {

    double latitude, longitude;
    LocationManager locationManager;
    Location loc;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60;

    public LocationTest() {
        super(LocationService.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this
     * test doesn't pass, the test case was not set up properly and it might
     * explain any and all failures in other tests.  This is not guaranteed
     * to run before other tests, as junit uses reflection to find the tests.
     */
    @SmallTest
    public void testPreconditions() {
    }

    /**
     * Test basic startup/shutdown of Service
     */
    @SmallTest
    public void testStartable() {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(), LocationService.class);
        startService(startIntent);
    }

    /**
     * Test binding to service
     */
//    @MediumTest
//    public void testBindable() {
//        Intent startIntent = new Intent();
//        startIntent.setClass(getContext(), LocationService.class);
//        IBinder binder = bindService(startIntent);
//
////        LocationService service = ((LocationService.LocalBinder) binder).getService();
//        getService().onBind(startIntent);
//
//        if (getService().canGetLocation()) {
//            latitude = getService().getLatitude();
//            longitude = getService().getLongitude();
//            assertThat(getService().getLatitude(), is(any(Double.class)));
//            System.out.println("latitude :" + latitude + "\n" + "longitude :" + longitude);
//        }
//        System.out.println("latitude :" + latitude + "\n" + "longitude :" + longitude);
//
//    }

    @MediumTest
    public void testLocation(){
        locationManager = (LocationManager) getApplication().getSystemService(LOCATION_SERVICE);

        if(locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER)){

            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) this);
            if (locationManager != null) {
                loc = locationManager
                        .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (loc != null) {
                    latitude = loc.getLatitude();
                    longitude = loc.getLongitude();
                }
            }

        }

                System.out.println("latitude :" + latitude + "\n" + "longitude :" + longitude);


    }

}
