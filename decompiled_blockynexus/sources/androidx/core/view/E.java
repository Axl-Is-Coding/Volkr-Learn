package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
class E implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f1198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f1199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f1200c;

    E(F f2, I i, View view) {
        this.f1200c = f2;
        this.f1198a = i;
        this.f1199b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1198a.a(this.f1199b);
    }
}
