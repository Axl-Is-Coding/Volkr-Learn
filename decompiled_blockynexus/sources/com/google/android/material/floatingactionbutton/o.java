package com.google.android.material.floatingactionbutton;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl f13418a;

    o(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.f13418a = floatingActionButtonImpl;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f13418a.p();
        return true;
    }
}
