package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class C0358h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView.w f1982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f1983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f1984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f1985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ C0361k f1987f;

    C0358h(C0361k c0361k, RecyclerView.w wVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1987f = c0361k;
        this.f1982a = wVar;
        this.f1983b = i;
        this.f1984c = view;
        this.f1985d = i2;
        this.f1986e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.f1983b != 0) {
            this.f1984c.setTranslationX(WheelView.DividerConfig.FILL);
        }
        if (this.f1985d != 0) {
            this.f1984c.setTranslationY(WheelView.DividerConfig.FILL);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1986e.setListener(null);
        this.f1987f.j(this.f1982a);
        this.f1987f.q.remove(this.f1982a);
        this.f1987f.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1987f.k(this.f1982a);
    }
}
