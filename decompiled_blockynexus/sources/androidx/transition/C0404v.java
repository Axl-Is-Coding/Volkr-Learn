package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: renamed from: androidx.transition.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FloatArrayEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
class C0404v implements TypeEvaluator<float[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f2299a;

    C0404v(float[] fArr) {
        this.f2299a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f2299a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f3 = fArr[i];
            fArr3[i] = f3 + ((fArr2[i] - f3) * f2);
        }
        return fArr3;
    }
}
