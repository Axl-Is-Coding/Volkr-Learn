package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* JADX INFO: compiled from: NavigationSubMenu.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends SubMenuBuilder {
    public i(Context context, g gVar, MenuItemImpl menuItemImpl) {
        super(context, gVar, menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void b(boolean z) {
        super.b(z);
        ((MenuBuilder) t()).b(z);
    }
}
