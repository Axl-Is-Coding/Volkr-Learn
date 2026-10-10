package com.google.android.material.snackbar;

import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13608a;

    r(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13608a = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar.SnackbarBaseLayout snackbarBaseLayout = this.f13608a.g;
        if (snackbarBaseLayout == null) {
            return;
        }
        snackbarBaseLayout.setVisibility(0);
        if (this.f13608a.g.getAnimationMode() == 1) {
            this.f13608a.x();
        } else {
            this.f13608a.y();
        }
    }
}
