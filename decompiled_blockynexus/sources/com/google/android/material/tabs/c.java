package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: TabLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TabLayout.e f13644b;

    c(TabLayout.e eVar, int i) {
        this.f13644b = eVar;
        this.f13643a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        TabLayout.e eVar = this.f13644b;
        eVar.f13624d = this.f13643a;
        eVar.f13625e = WheelView.DividerConfig.FILL;
    }
}
