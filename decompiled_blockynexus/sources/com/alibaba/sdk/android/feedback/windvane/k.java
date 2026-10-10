package com.alibaba.sdk.android.feedback.windvane;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.alibaba.sdk.android.feedback.xblink.f.m;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3749a = 3001;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3750b = 3002;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3751c = "k";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f3752d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f3754f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f3753e = null;
    private boolean g = false;

    public k(Activity activity, View view) {
        this.f3752d = activity;
        this.f3754f = view;
    }

    public void a(int i, int i2, Intent intent) {
        new m();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(f3751c, "WXPageAction take bar scan callback,requestCode: " + i + ";resultCode: " + i2);
    }

    public boolean a() {
        return this.g;
    }

    public void b() {
        if (this.f3753e != null) {
            m mVar = new m();
            mVar.a();
            com.alibaba.sdk.android.feedback.xblink.f.c.a(this.f3753e, "WXPageAction.onBack", mVar.b());
        }
    }
}
