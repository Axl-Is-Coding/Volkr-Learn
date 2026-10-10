package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: MatrixEvaluator.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f13091a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f13092b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f13093c = new Matrix();

    public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f13091a);
        matrix2.getValues(this.f13092b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f13092b;
            float f3 = fArr[i];
            float[] fArr2 = this.f13091a;
            fArr[i] = fArr2[i] + ((f3 - fArr2[i]) * f2);
        }
        this.f13093c.setValues(this.f13092b);
        return this.f13093c;
    }
}
