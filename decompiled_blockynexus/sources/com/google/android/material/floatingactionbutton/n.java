package com.google.android.material.floatingactionbutton;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements TypeEvaluator<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    FloatEvaluator f13416a = new FloatEvaluator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl f13417b;

    n(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.f13417b = floatingActionButtonImpl;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f2, Float f3, Float f4) {
        float fFloatValue = this.f13416a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
        if (fFloatValue < 0.1f) {
            fFloatValue = WheelView.DividerConfig.FILL;
        }
        return Float.valueOf(fFloatValue);
    }
}
