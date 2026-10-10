package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;

/* JADX INFO: renamed from: androidx.transition.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeTransform.java */
/* JADX INFO: loaded from: classes.dex */
class C0401s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Matrix f2291b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f2292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Matrix f2293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ View f2294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ChangeTransform.c f2295f;
    final /* synthetic */ ChangeTransform.b g;
    final /* synthetic */ ChangeTransform h;

    C0401s(ChangeTransform changeTransform, boolean z, Matrix matrix, View view, ChangeTransform.c cVar, ChangeTransform.b bVar) {
        this.h = changeTransform;
        this.f2292c = z;
        this.f2293d = matrix;
        this.f2294e = view;
        this.f2295f = cVar;
        this.g = bVar;
    }

    private void a(Matrix matrix) {
        this.f2291b.set(matrix);
        this.f2294e.setTag(R.id.transition_transform, this.f2291b);
        this.f2295f.a(this.f2294e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f2290a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f2290a) {
            if (this.f2292c && this.h.O) {
                a(this.f2293d);
            } else {
                this.f2294e.setTag(R.id.transition_transform, null);
                this.f2294e.setTag(R.id.parent_matrix, null);
            }
        }
        va.a(this.f2294e, (Matrix) null);
        this.f2295f.a(this.f2294e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        a(this.g.a());
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        ChangeTransform.f(this.f2294e);
    }
}
