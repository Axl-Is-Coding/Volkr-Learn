package com.ironsource.sdk.controller;

import android.os.Build;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ia, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2400ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StringBuilder f15287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController f15288c;

    RunnableC2400ia(WebController webController, String str, StringBuilder sb) {
        this.f15288c = webController;
        this.f15286a = str;
        this.f15287b = sb;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ironsource.sdk.utils.f.c(this.f15288c.TAG, this.f15286a);
        try {
            if (this.f15288c.isKitkatAndAbove != null) {
                if (this.f15288c.isKitkatAndAbove.booleanValue()) {
                    this.f15288c.evaluateJavascriptKitKat(this.f15287b.toString());
                } else {
                    this.f15288c.loadUrl(this.f15286a);
                }
            } else if (Build.VERSION.SDK_INT >= 19) {
                try {
                    try {
                        this.f15288c.evaluateJavascriptKitKat(this.f15287b.toString());
                        this.f15288c.isKitkatAndAbove = true;
                    } catch (NoSuchMethodError e2) {
                        com.ironsource.sdk.utils.f.b(this.f15288c.TAG, "evaluateJavascrip NoSuchMethodError: SDK version=" + Build.VERSION.SDK_INT + " " + e2);
                        this.f15288c.loadUrl(this.f15286a);
                        this.f15288c.isKitkatAndAbove = false;
                    }
                } catch (Throwable th) {
                    com.ironsource.sdk.utils.f.b(this.f15288c.TAG, "evaluateJavascrip Exception: SDK version=" + Build.VERSION.SDK_INT + " " + th);
                    this.f15288c.loadUrl(this.f15286a);
                    this.f15288c.isKitkatAndAbove = false;
                }
            } else {
                this.f15288c.loadUrl(this.f15286a);
                this.f15288c.isKitkatAndAbove = false;
            }
        } catch (Throwable th2) {
            com.ironsource.sdk.utils.f.b(this.f15288c.TAG, "injectJavascript: " + th2.toString());
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=injectJavaScript");
        }
    }
}
