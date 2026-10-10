package com.google.android.material.snackbar;

import android.view.View;
import androidx.core.view.J;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements androidx.core.view.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13601a;

    k(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13601a = baseTransientBottomBar;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        this.f13601a.n = j.b();
        this.f13601a.o = j.c();
        this.f13601a.p = j.d();
        this.f13601a.z();
        return j;
    }
}
