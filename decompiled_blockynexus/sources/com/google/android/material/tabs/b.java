package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: TabLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f13639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f13640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f13641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ TabLayout.e f13642e;

    b(TabLayout.e eVar, int i, int i2, int i3, int i4) {
        this.f13642e = eVar;
        this.f13638a = i;
        this.f13639b = i2;
        this.f13640c = i3;
        this.f13641d = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.f13642e.b(com.google.android.material.a.a.a(this.f13638a, this.f13639b, animatedFraction), com.google.android.material.a.a.a(this.f13640c, this.f13641d, animatedFraction));
    }
}
