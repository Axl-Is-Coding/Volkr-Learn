package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f13081a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f13082b = new androidx.interpolator.a.a.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f13083c = new androidx.interpolator.a.a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f13084d = new androidx.interpolator.a.a.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f13085e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i, int i2, float f2) {
        return i + Math.round(f2 * (i2 - i));
    }
}
