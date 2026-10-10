package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0361k;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class C0359i extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0361k.a f1988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f1990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0361k f1991d;

    C0359i(C0361k c0361k, C0361k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1991d = c0361k;
        this.f1988a = aVar;
        this.f1989b = viewPropertyAnimator;
        this.f1990c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1989b.setListener(null);
        this.f1990c.setAlpha(1.0f);
        this.f1990c.setTranslationX(WheelView.DividerConfig.FILL);
        this.f1990c.setTranslationY(WheelView.DividerConfig.FILL);
        this.f1991d.a(this.f1988a.f1996a, true);
        this.f1991d.s.remove(this.f1988a.f1996a);
        this.f1991d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1991d.b(this.f1988a.f1996a, true);
    }
}
