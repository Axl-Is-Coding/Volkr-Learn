package com.ironsource.sdk.service;

import android.app.Activity;

/* JADX INFO: compiled from: TokenService.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f15413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f15414b;

    f(g gVar, Activity activity) {
        this.f15414b = gVar;
        this.f15413a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15414b.a(b.a(this.f15413a));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
