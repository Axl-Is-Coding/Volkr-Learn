package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements BaseTransientBottomBar.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13606a;

    p(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13606a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.d
    public void a(View view, int i, int i2, int i3, int i4) {
        this.f13606a.g.setOnLayoutChangeListener(null);
        this.f13606a.w();
    }
}
