package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: NavigationView.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements MenuBuilder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NavigationView f13576a;

    a(NavigationView navigationView) {
        this.f13576a = navigationView;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public void a(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        NavigationView.a aVar = this.f13576a.listener;
        return aVar != null && aVar.a(menuItem);
    }
}
