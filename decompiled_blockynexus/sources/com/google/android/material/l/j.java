package com.google.android.material.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.v;

/* JADX INFO: compiled from: MaterialShapeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    static d a(int i) {
        return i != 0 ? i != 1 ? a() : new e() : new l();
    }

    static f b() {
        return new f();
    }

    static d a() {
        return new l();
    }

    public static void a(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            ((i) background).b(f2);
        }
    }

    public static void a(View view) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            a(view, (i) background);
        }
    }

    public static void a(View view, i iVar) {
        if (iVar.r()) {
            iVar.d(v.a(view));
        }
    }
}
