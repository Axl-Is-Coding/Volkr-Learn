package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: ExtendedFloatingActionButton.java */
/* JADX INFO: loaded from: classes2.dex */
class e implements ExtendedFloatingActionButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExtendedFloatingActionButton f13400a;

    e(ExtendedFloatingActionButton extendedFloatingActionButton) {
        this.f13400a = extendedFloatingActionButton;
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e
    public int getHeight() {
        return this.f13400a.getMeasuredHeight();
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e
    public int getWidth() {
        return this.f13400a.getMeasuredWidth();
    }
}
