package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.E;

/* JADX INFO: compiled from: SmoothCalendarLayoutManager.java */
/* JADX INFO: loaded from: classes2.dex */
class A extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f13273a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    A(B b2, Context context) {
        super(context);
        this.f13273a = b2;
    }

    @Override // androidx.recyclerview.widget.E
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }
}
