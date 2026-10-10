package com.google.android.material.bottomnavigation;

import android.view.View;

/* JADX INFO: compiled from: BottomNavigationItemView.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomNavigationItemView f13201a;

    a(BottomNavigationItemView bottomNavigationItemView) {
        this.f13201a = bottomNavigationItemView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f13201a.icon.getVisibility() == 0) {
            BottomNavigationItemView bottomNavigationItemView = this.f13201a;
            bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
        }
    }
}
