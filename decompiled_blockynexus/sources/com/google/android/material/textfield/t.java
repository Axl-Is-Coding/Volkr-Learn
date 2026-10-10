package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f13683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f13684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f13685c;

    t(TextInputLayout textInputLayout) {
        this.f13683a = textInputLayout;
        this.f13684b = textInputLayout.getContext();
        this.f13685c = textInputLayout.getEndIconView();
    }

    abstract void a();

    boolean a(int i) {
        return true;
    }

    boolean b() {
        return false;
    }
}
