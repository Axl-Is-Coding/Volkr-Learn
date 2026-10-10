package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {

    private static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f2169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2170b = false;

        a(View view) {
            this.f2169a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            va.a(this.f2169a, 1.0f);
            if (this.f2170b) {
                this.f2169a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.y(this.f2169a) && this.f2169a.getLayerType() == 0) {
                this.f2170b = true;
                this.f2169a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i) {
        a(i);
    }

    private Animator a(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        va.a(view, f2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, va.f2301b, f3);
        objectAnimatorOfFloat.addListener(new a(view));
        a(new C0403u(this, view));
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.Visibility
    public Animator b(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        va.e(view);
        return a(view, a(haVar, 1.0f), WheelView.DividerConfig.FILL);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void c(ha haVar) {
        super.c(haVar);
        haVar.f2246a.put("android:fade:transitionAlpha", Float.valueOf(va.c(haVar.f2247b)));
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.f2218f);
        a(androidx.core.content.a.i.b(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, q()));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Visibility
    public Animator a(ViewGroup viewGroup, View view, ha haVar, ha haVar2) {
        float f2 = WheelView.DividerConfig.FILL;
        float fA = a(haVar, WheelView.DividerConfig.FILL);
        if (fA != 1.0f) {
            f2 = fA;
        }
        return a(view, f2, 1.0f);
    }

    private static float a(ha haVar, float f2) {
        Float f3;
        return (haVar == null || (f3 = (Float) haVar.f2246a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }
}
