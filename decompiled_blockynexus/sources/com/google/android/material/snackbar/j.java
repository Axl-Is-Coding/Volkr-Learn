package com.google.android.material.snackbar;

import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13600a;

    j(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13600a = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iR;
        BaseTransientBottomBar baseTransientBottomBar = this.f13600a;
        if (baseTransientBottomBar.g == null || baseTransientBottomBar.f13583f == null || (iR = (this.f13600a.r() - this.f13600a.t()) + ((int) this.f13600a.g.getTranslationY())) >= this.f13600a.q) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f13600a.g.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(BaseTransientBottomBar.f13581d, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
            return;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += this.f13600a.q - iR;
        this.f13600a.g.requestLayout();
    }
}
