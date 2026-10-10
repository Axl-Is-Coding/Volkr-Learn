package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13137f = true;
    private boolean g = true;

    public g(View view) {
        this.f13132a = view;
    }

    void a() {
        View view = this.f13132a;
        ViewCompat.c(view, this.f13135d - (view.getTop() - this.f13133b));
        View view2 = this.f13132a;
        ViewCompat.b(view2, this.f13136e - (view2.getLeft() - this.f13134c));
    }

    public boolean b(int i) {
        if (!this.f13137f || this.f13135d == i) {
            return false;
        }
        this.f13135d = i;
        a();
        return true;
    }

    public int c() {
        return this.f13135d;
    }

    void d() {
        this.f13133b = this.f13132a.getTop();
        this.f13134c = this.f13132a.getLeft();
    }

    public boolean a(int i) {
        if (!this.g || this.f13136e == i) {
            return false;
        }
        this.f13136e = i;
        a();
        return true;
    }

    public int b() {
        return this.f13133b;
    }
}
