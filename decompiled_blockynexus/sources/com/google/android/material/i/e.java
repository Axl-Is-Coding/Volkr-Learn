package com.google.android.material.i;

import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextPaint f13427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f13428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ f f13429c;

    e(f fVar, TextPaint textPaint, h hVar) {
        this.f13429c = fVar;
        this.f13427a = textPaint;
        this.f13428b = hVar;
    }

    @Override // com.google.android.material.i.h
    public void a(Typeface typeface, boolean z) {
        this.f13429c.a(this.f13427a, typeface);
        this.f13428b.a(typeface, z);
    }

    @Override // com.google.android.material.i.h
    public void a(int i) {
        this.f13428b.a(i);
    }
}
