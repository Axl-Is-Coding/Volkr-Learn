package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: NavigationMenu.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends MenuBuilder {
    public g(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i, i2, i3, charSequence);
        i iVar = new i(e(), this, menuItemImpl);
        menuItemImpl.a(iVar);
        return iVar;
    }
}
