package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes2.dex */
public class AppBarBehavior extends AppBarLayout.Behavior {
    public AppBarBehavior() {
    }

    public AppBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        super.a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        a(i4, appBarLayout, view, i5);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        super.a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        a(i2, appBarLayout, view, i3);
    }

    private void a(int i, AppBarLayout appBarLayout, View view, int i2) {
        if (i2 == 1) {
            int iB = b();
            if ((i >= 0 || iB != 0) && (i <= 0 || iB != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.h(view, 1);
        }
    }
}
