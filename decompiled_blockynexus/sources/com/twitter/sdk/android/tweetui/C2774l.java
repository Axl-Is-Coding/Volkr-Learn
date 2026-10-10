package com.twitter.sdk.android.tweetui;

import android.graphics.Color;

/* JADX INFO: renamed from: com.twitter.sdk.android.tweetui.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ColorUtils.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2774l {
    static int a(double d2, int i, int i2) {
        int iRed = Color.red(i2);
        int iRed2 = Color.red(i);
        int iGreen = Color.green(i2);
        int iGreen2 = Color.green(i);
        int iBlue = Color.blue(i2);
        int iBlue2 = Color.blue(i);
        double d3 = 1.0d - d2;
        double d4 = iRed;
        Double.isNaN(d4);
        double d5 = iRed2;
        Double.isNaN(d5);
        int i3 = (int) ((d4 * d3) + (d5 * d2));
        double d6 = iGreen;
        Double.isNaN(d6);
        double d7 = iGreen2;
        Double.isNaN(d7);
        double d8 = iBlue;
        Double.isNaN(d8);
        double d9 = iBlue2;
        Double.isNaN(d9);
        return Color.rgb(i3, (int) ((d6 * d3) + (d7 * d2)), (int) ((d3 * d8) + (d2 * d9)));
    }

    static boolean a(int i) {
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        double d2 = iRed;
        Double.isNaN(d2);
        double d3 = iGreen;
        Double.isNaN(d3);
        double d4 = (d2 * 0.21d) + (d3 * 0.72d);
        double d5 = iBlue;
        Double.isNaN(d5);
        return d4 + (d5 * 0.07d) > 128.0d;
    }
}
