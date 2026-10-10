package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: androidx.transition.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0393k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f2262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Rect f2263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f2264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f2265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f2266f;
    final /* synthetic */ int g;
    final /* synthetic */ ChangeBounds h;

    C0393k(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.h = changeBounds;
        this.f2262b = view;
        this.f2263c = rect;
        this.f2264d = i;
        this.f2265e = i2;
        this.f2266f = i3;
        this.g = i4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f2261a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f2261a) {
            return;
        }
        ViewCompat.a(this.f2262b, this.f2263c);
        va.a(this.f2262b, this.f2264d, this.f2265e, this.f2266f, this.g);
    }
}
