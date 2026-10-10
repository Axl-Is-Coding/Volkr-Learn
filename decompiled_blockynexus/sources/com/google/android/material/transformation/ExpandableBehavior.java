package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13700a;

    public ExpandableBehavior() {
        this.f13700a = 0;
    }

    protected abstract boolean a(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        com.google.android.material.g.b bVar = (com.google.android.material.g.b) view2;
        if (!a(bVar.isExpanded())) {
            return false;
        }
        this.f13700a = bVar.isExpanded() ? 1 : 2;
        return a((View) bVar, view, bVar.isExpanded(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected com.google.android.material.g.b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view2 = dependencies.get(i);
            if (a(coordinatorLayout, view, view2)) {
                return (com.google.android.material.g.b) view2;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        com.google.android.material.g.b bVarE;
        if (ViewCompat.C(view) || (bVarE = e(coordinatorLayout, view)) == null || !a(bVarE.isExpanded())) {
            return false;
        }
        this.f13700a = bVarE.isExpanded() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(this, view, this.f13700a, bVarE));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13700a = 0;
    }

    private boolean a(boolean z) {
        if (!z) {
            return this.f13700a == 1;
        }
        int i = this.f13700a;
        return i == 0 || i == 2;
    }
}
