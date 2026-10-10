package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class u implements View.OnAttachStateChangeListener {
    u() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        ViewCompat.H(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
