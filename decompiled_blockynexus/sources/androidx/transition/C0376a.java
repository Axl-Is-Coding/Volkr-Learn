package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.transition.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
class C0376a {

    /* JADX INFO: renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatorUtils.java */
    interface InterfaceC0035a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0035a) {
                    ((InterfaceC0035a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }

    static void a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0035a) {
                    ((InterfaceC0035a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }
}
