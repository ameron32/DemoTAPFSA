package com.ameron32.tap.fsa.demotapfsa;

import android.app.Activity;

/**
 * Created by klemeilleur on 2/22/16.
 */
public class Util {

    public static String makeClassName(String packageName) {
        return makeClassName(packageName, "MainActivity");
    }

    public static String makeClassName(String packageName, String className) {
        return "com.ameron32.tap.fsa.demotapfsa." + packageName + "." + className;
    }
}
