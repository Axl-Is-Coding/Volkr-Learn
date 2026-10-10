package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: BottomNavigationMenu.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends MenuBuilder {
    public b(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        if (size() + 1 > 5) {
            throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        }
        s();
        MenuItem menuItemA = super.a(i, i2, i3, charSequence);
        if (menuItemA instanceof MenuItemImpl) {
            ((MenuItemImpl) menuItemA).c(true);
        }
        r();
        return menuItemA;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
