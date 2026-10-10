package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* JADX INFO: compiled from: MotionStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
interface q {
    void a();

    void a(Animator.AnimatorListener animatorListener);

    void a(com.google.android.material.a.h hVar);

    void a(ExtendedFloatingActionButton.c cVar);

    com.google.android.material.a.h b();

    void b(Animator.AnimatorListener animatorListener);

    boolean c();

    void d();

    int e();

    AnimatorSet f();

    List<Animator.AnimatorListener> g();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);
}
