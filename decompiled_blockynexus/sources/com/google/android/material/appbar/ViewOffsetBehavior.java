package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f13121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13123c;

    public ViewOffsetBehavior() {
        this.f13122b = 0;
        this.f13123c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, v, i);
        if (this.f13121a == null) {
            this.f13121a = new g(v);
        }
        this.f13121a.d();
        this.f13121a.a();
        int i2 = this.f13122b;
        if (i2 != 0) {
            this.f13121a.b(i2);
            this.f13122b = 0;
        }
        int i3 = this.f13123c;
        if (i3 == 0) {
            return true;
        }
        this.f13121a.a(i3);
        this.f13123c = 0;
        return true;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    public int b() {
        g gVar = this.f13121a;
        if (gVar != null) {
            return gVar.c();
        }
        return 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13122b = 0;
        this.f13123c = 0;
    }

    public boolean a(int i) {
        g gVar = this.f13121a;
        if (gVar != null) {
            return gVar.b(i);
        }
        this.f13122b = i;
        return false;
    }
}
