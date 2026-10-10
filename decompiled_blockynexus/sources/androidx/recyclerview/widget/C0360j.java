package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0361k;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class C0360j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0361k.a f1992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f1994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0361k f1995d;

    C0360j(C0361k c0361k, C0361k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1995d = c0361k;
        this.f1992a = aVar;
        this.f1993b = viewPropertyAnimator;
        this.f1994c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1993b.setListener(null);
        this.f1994c.setAlpha(1.0f);
        this.f1994c.setTranslationX(WheelView.DividerConfig.FILL);
        this.f1994c.setTranslationY(WheelView.DividerConfig.FILL);
        this.f1995d.a(this.f1992a.f1997b, false);
        this.f1995d.s.remove(this.f1992a.f1997b);
        this.f1995d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1995d.b(this.f1992a.f1997b, false);
    }
}
