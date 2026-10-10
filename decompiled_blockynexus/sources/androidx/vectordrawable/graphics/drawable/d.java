package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnimatedVectorDrawableCompat f2337a;

    d(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.f2337a = animatedVectorDrawableCompat;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ArrayList arrayList = new ArrayList(this.f2337a.f2322f);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat.AnimationCallback) arrayList.get(i)).a(this.f2337a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ArrayList arrayList = new ArrayList(this.f2337a.f2322f);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animatable2Compat.AnimationCallback) arrayList.get(i)).b(this.f2337a);
        }
    }
}
