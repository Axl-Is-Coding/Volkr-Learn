package com.ironsource.mediationsdk;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdapterUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2315d {
    public static boolean a(Activity activity) {
        if (activity == null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "AdapterUtils isLargeScreen - activity is null", 3);
            return false;
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        float f2 = displayMetrics.heightPixels;
        float f3 = displayMetrics.density;
        return f2 / f3 > 720.0f && ((float) displayMetrics.widthPixels) / f3 >= 728.0f;
    }

    public static int a(Activity activity, int i) {
        if (activity == null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "AdapterUtils dpToPixels - activity is null, returning dpSize", 3);
            return i;
        }
        return (int) TypedValue.applyDimension(1, i, activity.getResources().getDisplayMetrics());
    }
}
