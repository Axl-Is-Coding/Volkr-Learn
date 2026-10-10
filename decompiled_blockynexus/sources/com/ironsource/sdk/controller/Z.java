package com.ironsource.sdk.controller;

import android.view.View;
import com.umeng.analytics.pro.m;

/* JADX INFO: compiled from: OpenUrlActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class Z implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OpenUrlActivity f15252a;

    Z(OpenUrlActivity openUrlActivity) {
        this.f15252a = openUrlActivity;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        if ((i & m.a.f20900b) == 0) {
            this.f15252a.i.removeCallbacks(this.f15252a.k);
            this.f15252a.i.postDelayed(this.f15252a.k, 500L);
        }
    }
}
