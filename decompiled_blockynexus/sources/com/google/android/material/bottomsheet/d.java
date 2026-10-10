package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.e;

/* JADX INFO: compiled from: BottomSheetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements androidx.core.view.accessibility.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f13229b;

    d(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.f13229b = bottomSheetBehavior;
        this.f13228a = i;
    }

    @Override // androidx.core.view.accessibility.e
    public boolean a(View view, e.a aVar) {
        this.f13229b.e(this.f13228a);
        return true;
    }
}
