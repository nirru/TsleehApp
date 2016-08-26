package com.oxilo.tsleehapp.uiView;

import android.content.Context;

/**
 * Created by ericbasendra on 24/08/16.
 */
public class ScreenDensity {

    public static int setMarginWithDensity(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return 80;
        }
        if (density >= 3.0) {
            return 65;
        }
        if (density >= 2.0) {
            return 32;
        }
        if (density >= 1.5) {
            return 30;
        }
        if (density >= 1.0) {
            return 25;
        }
        return 16;
    }
}
