package com.google.android.material.g;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: ExpandableWidgetHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13420b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13421c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f13419a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.f13419a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f13419a);
        }
    }

    public boolean a(boolean z) {
        if (this.f13420b == z) {
            return false;
        }
        this.f13420b = z;
        d();
        return true;
    }

    public boolean b() {
        return this.f13420b;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f13420b);
        bundle.putInt("expandedComponentIdHint", this.f13421c);
        return bundle;
    }

    public void a(Bundle bundle) {
        this.f13420b = bundle.getBoolean("expanded", false);
        this.f13421c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f13420b) {
            d();
        }
    }

    public void a(int i) {
        this.f13421c = i;
    }

    public int a() {
        return this.f13421c;
    }
}
