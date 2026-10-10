package com.ironsource.sdk.controller;

import android.view.View;
import com.umeng.analytics.pro.m;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class ViewOnSystemUiVisibilityChangeListenerC2391e implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ControllerActivity f15273a;

    ViewOnSystemUiVisibilityChangeListenerC2391e(ControllerActivity controllerActivity) {
        this.f15273a = controllerActivity;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        if ((i & m.a.f20900b) == 0) {
            this.f15273a.j.removeCallbacks(this.f15273a.k);
            this.f15273a.j.postDelayed(this.f15273a.k, 500L);
        }
    }
}
