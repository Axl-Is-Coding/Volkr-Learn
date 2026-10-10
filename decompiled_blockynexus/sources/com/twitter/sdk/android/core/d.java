package com.twitter.sdk.android.core;

import android.util.Log;

/* JADX INFO: compiled from: DefaultLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f20119a;

    public d(int i) {
        this.f20119a = i;
    }

    public boolean a(String str, int i) {
        return this.f20119a <= i;
    }

    public void b(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.i
    public void d(String str, String str2) {
        a(str, str2, null);
    }

    @Override // com.twitter.sdk.android.core.i
    public void e(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    @Override // com.twitter.sdk.android.core.i
    public void w(String str, String str2) {
        b(str, str2, null);
    }

    public void a(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public d() {
        this.f20119a = 4;
    }

    @Override // com.twitter.sdk.android.core.i
    public void e(String str, String str2) {
        e(str, str2, null);
    }
}
