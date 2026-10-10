package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: ExpandableBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f13710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f13711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.android.material.g.b f13712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ExpandableBehavior f13713d;

    a(ExpandableBehavior expandableBehavior, View view, int i, com.google.android.material.g.b bVar) {
        this.f13713d = expandableBehavior;
        this.f13710a = view;
        this.f13711b = i;
        this.f13712c = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f13710a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f13713d.f13700a == this.f13711b) {
            ExpandableBehavior expandableBehavior = this.f13713d;
            com.google.android.material.g.b bVar = this.f13712c;
            expandableBehavior.a((View) bVar, this.f13710a, bVar.isExpanded(), false);
        }
        return false;
    }
}
