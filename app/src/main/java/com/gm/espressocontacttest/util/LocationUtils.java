package com.gm.espressocontacttest.util;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/25/17.
 */

public final class LocationUtils {

    // Debugging tag for the application
    public static final String APPTAG = "Location Mock Tester";

    // Create an empty string for initializing strings
    public static final String EMPTY_STRING = new String();

    // Conversion factor for boot time
    public static final long NANOSECONDS_PER_MILLISECOND = 1000000;

    // Conversion factor for time values
    public static final long MILLISECONDS_PER_SECOND = 1000;

    // Conversion factor for time values
    public static final long NANOSECONDS_PER_SECOND =
            NANOSECONDS_PER_MILLISECOND * MILLISECONDS_PER_SECOND;

    /*
     * Action values sent by Intent from the main activity to the service
     */
    // Request a one-time test
    public static final String ACTION_START_ONCE =
            "com.example.android.mocklocation.ACTION_START_ONCE";

    // Request continuous testing
    public static final String ACTION_START_CONTINUOUS =
            "com.example.android.mocklocation.ACTION_START_CONTINUOUS";

    // Stop a continuous test
    public static final String ACTION_STOP_TEST =
            "com.example.android.mocklocation.ACTION_STOP_TEST";

    /*
     * Extended data keys for the broadcast Intent sent from the service to the main activity.
     * Key1 is the base connection message.
     * Key2 is extra data or error codes.
     */
    public static final String KEY_EXTRA_CODE1 =
            "com.example.android.mocklocation.KEY_EXTRA_CODE1";

    public static final String KEY_EXTRA_CODE2 =
            "com.example.android.mocklocation.KEY_EXTRA_CODE2";

    /*
     * Codes for communicating status back to the main activity
     */

    // The location client is disconnected
    public static final int CODE_DISCONNECTED = 0;

    // The location client is connected
    public static final int CODE_CONNECTED = 1;

    // The client failed to connect to Location Services
    public static final int CODE_CONNECTION_FAILED = -1;

    // Report in the broadcast Intent that the test finished
    public static final int CODE_TEST_FINISHED = 3;

    /*
     * Report in the broadcast Intent that the activity requested the start to a test, but a
     * test is already underway
     *
     */
    public static final int CODE_IN_TEST = -2;

    // The test was interrupted by clicking "Stop testing"
    public static final int CODE_TEST_STOPPED = -3;

    // The name used for all mock locations
    public static final String LOCATION_PROVIDER = "fused";

    // An array of latitudes for constructing test data
    public static final double[] WAYPOINTS_LAT = {
            37.377166,
            37.380866,
            37.381224,
            37.382008,
            37.385486,
            37.387021,
            37.384847,
            37.385461};

    // An array of longitudes for constructing test data
    public static final double[] WAYPOINTS_LNG = {
            -122.086966,
            -122.086945,
            -122.086344,
            -122.086151,
            -122.083941,
            -122.083104,
            -122.078683,
            -122.078265};

    // An array of accuracy values for constructing test data
    public static final float[] WAYPOINTS_ACCURACY = {
            3.0f,
            3.12f,
            3.5f,
            3.7f,
            3.12f,
            3.0f,
            3.12f,
            3.7f
    };

    // Mark the broadcast Intent with an action
    public static final String ACTION_SERVICE_MESSAGE =
            "com.example.android.mocklocation.ACTION_SERVICE_MESSAGE";

    /*
     * Key for extended data in the Activity's outgoing Intent that records the type of test
     * requested.
     */
    public static final String EXTRA_TEST_ACTION =
            "com.example.android.mocklocation.EXTRA_TEST_ACTION";

    /*
     * Key for extended data in the Activity's outgoing Intent that records the requested pause
     * value.
     */
    public static final String EXTRA_PAUSE_VALUE =
            "com.example.android.mocklocation.EXTRA_PAUSE_VALUE";

    /*
     * Key for extended data in the Activity's outgoing Intent that records the requested interval
     * for mock locations sent to Location Services.
     */
    public static final String EXTRA_SEND_INTERVAL =
            "com.example.android.mocklocation.EXTRA_SEND_INTERVAL";
}

