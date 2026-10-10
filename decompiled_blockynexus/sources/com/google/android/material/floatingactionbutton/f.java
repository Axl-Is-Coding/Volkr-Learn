package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: ExtendedFloatingActionButton.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements ExtendedFloatingActionButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExtendedFloatingActionButton f13401a;

    f(ExtendedFloatingActionButton extendedFloatingActionButton) {
        this.f13401a = extendedFloatingActionButton;
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e
    public int getHeight() {
        return this.f13401a.getCollapsedSize();
    }

    @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e
    public int getWidth() {
        return this.f13401a.getCollapsedSize();
    }
}
