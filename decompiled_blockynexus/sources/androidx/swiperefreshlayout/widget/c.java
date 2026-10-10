package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.d;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d.a f2093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f2094b;

    c(d dVar, d.a aVar) {
        this.f2094b = dVar;
        this.f2093a = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f2094b.a(1.0f, this.f2093a, true);
        this.f2093a.l();
        this.f2093a.j();
        d dVar = this.f2094b;
        if (!dVar.i) {
            dVar.h += 1.0f;
            return;
        }
        dVar.i = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        this.f2093a.a(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2094b.h = WheelView.DividerConfig.FILL;
    }
}
