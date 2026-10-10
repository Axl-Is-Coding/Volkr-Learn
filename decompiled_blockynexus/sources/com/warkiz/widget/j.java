package com.warkiz.widget;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: compiled from: SizeUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {
    public static int a(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
