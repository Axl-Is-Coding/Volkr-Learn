package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.ha;
import java.util.Map;

/* JADX INFO: compiled from: TextScale.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends Transition {
    private void d(ha haVar) {
        View view = haVar.f2247b;
        if (view instanceof TextView) {
            haVar.f2246a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        if (haVar == null || haVar2 == null || !(haVar.f2247b instanceof TextView)) {
            return null;
        }
        View view = haVar2.f2247b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = haVar.f2246a;
        Map<String, Object> map2 = haVar2.f2246a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new q(this, textView));
        return valueAnimatorOfFloat;
    }
}
