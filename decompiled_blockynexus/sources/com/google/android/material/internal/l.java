package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ScrimInsetsFrameLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements androidx.core.view.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrimInsetsFrameLayout f13466a;

    l(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.f13466a = scrimInsetsFrameLayout;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.f13466a;
        if (scrimInsetsFrameLayout.insets == null) {
            scrimInsetsFrameLayout.insets = new Rect();
        }
        this.f13466a.insets.set(j.c(), j.e(), j.d(), j.b());
        this.f13466a.onInsetsChanged(j);
        this.f13466a.setWillNotDraw(!j.f() || this.f13466a.insetForeground == null);
        ViewCompat.G(this.f13466a);
        return j.a();
    }
}
