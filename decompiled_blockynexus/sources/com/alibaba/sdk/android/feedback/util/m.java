package com.alibaba.sdk.android.feedback.util;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f3728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f3729b;

    m(boolean z, Context context) {
        this.f3728a = z;
        this.f3729b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3728a) {
            k.e(this.f3729b);
        } else {
            k.f(this.f3729b);
        }
    }
}
