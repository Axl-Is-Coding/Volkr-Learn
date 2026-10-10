package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.da, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SecureMessagingInterface.java */
/* JADX INFO: loaded from: classes2.dex */
class C2390da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2392ea f15271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15272b = false;

    C2390da(C2392ea c2392ea) {
        this.f15271a = c2392ea;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.f15272b) {
            return "";
        }
        this.f15272b = true;
        return this.f15271a.b();
    }
}
