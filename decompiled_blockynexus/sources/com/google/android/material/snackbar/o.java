package com.google.android.material.snackbar;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements BaseTransientBottomBar.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13605a;

    o(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13605a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
    public void onViewAttachedToWindow(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f13605a.g.getRootWindowInsets()) == null) {
            return;
        }
        this.f13605a.q = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        this.f13605a.z();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.c
    public void onViewDetachedFromWindow(View view) {
        if (this.f13605a.k()) {
            BaseTransientBottomBar.f13578a.post(new n(this));
        }
    }
}
