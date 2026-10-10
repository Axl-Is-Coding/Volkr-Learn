package com.google.android.material.b;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.b.b;
import com.google.android.material.internal.k;

/* JADX INFO: compiled from: BadgeUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f13151a;

    static {
        f13151a = Build.VERSION.SDK_INT < 18;
    }

    public static void a(Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }

    public static void b(b bVar, View view, FrameLayout frameLayout) {
        if (bVar == null) {
            return;
        }
        if (f13151a) {
            frameLayout.setForeground(null);
        } else {
            view.getOverlay().remove(bVar);
        }
    }

    public static void c(b bVar, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        (f13151a ? frameLayout : view).getDrawingRect(rect);
        bVar.setBounds(rect);
        bVar.a(view, frameLayout);
    }

    public static void a(b bVar, View view, FrameLayout frameLayout) {
        c(bVar, view, frameLayout);
        if (f13151a) {
            frameLayout.setForeground(bVar);
        } else {
            view.getOverlay().add(bVar);
        }
    }

    public static k a(SparseArray<b> sparseArray) {
        k kVar = new k();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            b bVarValueAt = sparseArray.valueAt(i);
            if (bVarValueAt != null) {
                kVar.put(iKeyAt, bVarValueAt.e());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return kVar;
    }

    public static SparseArray<b> a(Context context, k kVar) {
        SparseArray<b> sparseArray = new SparseArray<>(kVar.size());
        for (int i = 0; i < kVar.size(); i++) {
            int iKeyAt = kVar.keyAt(i);
            b.a aVar = (b.a) kVar.valueAt(i);
            if (aVar != null) {
                sparseArray.put(iKeyAt, b.a(context, aVar));
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }
}
