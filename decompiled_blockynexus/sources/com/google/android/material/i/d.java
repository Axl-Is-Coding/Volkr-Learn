package com.google.android.material.i;

import android.graphics.Typeface;
import androidx.core.content.a.h;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f13425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f13426b;

    d(f fVar, h hVar) {
        this.f13426b = fVar;
        this.f13425a = hVar;
    }

    @Override // androidx.core.content.a.h.a
    public void a(Typeface typeface) {
        f fVar = this.f13426b;
        fVar.o = Typeface.create(typeface, fVar.f13434e);
        this.f13426b.n = true;
        this.f13425a.a(this.f13426b.o, false);
    }

    @Override // androidx.core.content.a.h.a
    public void a(int i) {
        this.f13426b.n = true;
        this.f13425a.a(i);
    }
}
