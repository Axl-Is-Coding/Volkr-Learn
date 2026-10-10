package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* JADX INFO: compiled from: TranslationAnimationCreator.java */
/* JADX INFO: loaded from: classes.dex */
class ja {

    /* JADX INFO: compiled from: TranslationAnimationCreator.java */
    private static class a extends AnimatorListenerAdapter implements Transition.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f2255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f2256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f2258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f2259e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f2260f;
        private float g;
        private final float h;
        private final float i;

        a(View view, View view2, int i, int i2, float f2, float f3) {
            this.f2256b = view;
            this.f2255a = view2;
            this.f2257c = i - Math.round(this.f2256b.getTranslationX());
            this.f2258d = i2 - Math.round(this.f2256b.getTranslationY());
            this.h = f2;
            this.i = f3;
            this.f2259e = (int[]) this.f2255a.getTag(R.id.transition_position);
            if (this.f2259e != null) {
                this.f2255a.setTag(R.id.transition_position, null);
            }
        }

        @Override // androidx.transition.Transition.c
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.c
        public void d(Transition transition) {
            this.f2256b.setTranslationX(this.h);
            this.f2256b.setTranslationY(this.i);
            transition.b(this);
        }

        @Override // androidx.transition.Transition.c
        public void e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f2259e == null) {
                this.f2259e = new int[2];
            }
            this.f2259e[0] = Math.round(this.f2257c + this.f2256b.getTranslationX());
            this.f2259e[1] = Math.round(this.f2258d + this.f2256b.getTranslationY());
            this.f2255a.setTag(R.id.transition_position, this.f2259e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f2260f = this.f2256b.getTranslationX();
            this.g = this.f2256b.getTranslationY();
            this.f2256b.setTranslationX(this.h);
            this.f2256b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f2256b.setTranslationX(this.f2260f);
            this.f2256b.setTranslationY(this.g);
        }
    }

    static Animator a(View view, ha haVar, int i, int i2, float f2, float f3, float f4, float f5, TimeInterpolator timeInterpolator, Transition transition) {
        float f6;
        float f7;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) haVar.f2247b.getTag(R.id.transition_position)) != null) {
            f6 = (r4[0] - i) + translationX;
            f7 = (r4[1] - i2) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int iRound = i + Math.round(f6 - translationX);
        int iRound2 = i2 + Math.round(f7 - translationY);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f6, f4), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f7, f5));
        a aVar = new a(view, haVar.f2247b, iRound, iRound2, translationX, translationY);
        transition.a(aVar);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        C0376a.a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
