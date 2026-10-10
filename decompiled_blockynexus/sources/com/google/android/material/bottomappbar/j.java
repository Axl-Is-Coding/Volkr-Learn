package com.google.android.material.bottomappbar;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomAppBar.Behavior f13187a;

    j(BottomAppBar.Behavior behavior) {
        this.f13187a = behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        BottomAppBar bottomAppBar = (BottomAppBar) this.f13187a.f13170f.get();
        if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
            view.removeOnLayoutChangeListener(this);
            return;
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        floatingActionButton.getMeasuredContentRect(this.f13187a.f13169e);
        int iHeight = this.f13187a.f13169e.height();
        bottomAppBar.setFabDiameter(iHeight);
        CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
        if (this.f13187a.g == 0) {
            ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
        }
    }
}
