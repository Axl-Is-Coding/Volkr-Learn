package com.ironsource.mediationsdk.sdk;

import android.text.TextUtils;

/* JADX INFO: compiled from: ListenersWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenersWrapper f14972b;

    D(ListenersWrapper listenersWrapper, String str) {
        this.f14972b = listenersWrapper;
        this.f14971a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f14971a)) {
            return;
        }
        this.f14972b.f14987d.a(this.f14971a);
    }
}
