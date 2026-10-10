package com.scwang.smartrefresh.layout.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.a.i;

/* JADX INFO: compiled from: DesignUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static void a(View view, i iVar, com.scwang.smartrefresh.layout.b.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.b().setEnableNestedScroll(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.b) new a(aVar));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
