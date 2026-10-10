package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.J;
import androidx.core.view.r;

/* JADX INFO: compiled from: AppBarLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppBarLayout f13124a;

    a(AppBarLayout appBarLayout) {
        this.f13124a = appBarLayout;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        return this.f13124a.onWindowInsetChanged(j);
    }
}
