package com.google.android.material.floatingactionbutton;

import android.graphics.Matrix;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends com.google.android.material.a.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl f13415d;

    m(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.f13415d = floatingActionButtonImpl;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        this.f13415d.z = f2;
        return super.evaluate(f2, matrix, matrix2);
    }
}
