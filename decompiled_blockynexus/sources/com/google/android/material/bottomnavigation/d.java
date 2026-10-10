package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;

/* JADX INFO: compiled from: BottomNavigationView.java */
/* JADX INFO: loaded from: classes2.dex */
class d implements MenuBuilder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomNavigationView f13202a;

    d(BottomNavigationView bottomNavigationView) {
        this.f13202a = bottomNavigationView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public void a(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f13202a.reselectedListener == null || menuItem.getItemId() != this.f13202a.getSelectedItemId()) {
            return (this.f13202a.selectedListener == null || this.f13202a.selectedListener.a(menuItem)) ? false : true;
        }
        this.f13202a.reselectedListener.a(menuItem);
        return true;
    }
}
