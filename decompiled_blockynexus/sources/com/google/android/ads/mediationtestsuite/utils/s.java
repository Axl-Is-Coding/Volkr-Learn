package com.google.android.ads.mediationtestsuite.utils;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: compiled from: UIUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    public static void a(Menu menu, int i) {
        for (int i2 = 0; i2 < menu.size(); i2++) {
            MenuItem item = menu.getItem(i2);
            Drawable icon = item.getIcon();
            if (icon != null) {
                Drawable drawableI = androidx.core.graphics.drawable.a.i(icon);
                icon.mutate();
                androidx.core.graphics.drawable.a.b(drawableI, i);
                item.setIcon(icon);
            }
        }
    }
}
