package com.google.android.material.bottomsheet;

import android.view.View;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f13223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f13224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f13225c;

    a(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.f13225c = bottomSheetBehavior;
        this.f13223a = view;
        this.f13224b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13225c.a(this.f13223a, this.f13224b);
    }
}
