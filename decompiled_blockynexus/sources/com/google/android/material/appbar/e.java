package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.J;
import androidx.core.view.r;

/* JADX INFO: compiled from: CollapsingToolbarLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CollapsingToolbarLayout f13130a;

    e(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f13130a = collapsingToolbarLayout;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        return this.f13130a.onWindowInsetChanged(j);
    }
}
