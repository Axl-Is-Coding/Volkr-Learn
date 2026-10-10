package com.google.android.material.tabs;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: TabLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f13645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TabLayout.TabView f13646b;

    d(TabLayout.TabView tabView, View view) {
        this.f13646b = tabView;
        this.f13645a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f13645a.getVisibility() == 0) {
            this.f13646b.tryUpdateBadgeDrawableBounds(this.f13645a);
        }
    }
}
