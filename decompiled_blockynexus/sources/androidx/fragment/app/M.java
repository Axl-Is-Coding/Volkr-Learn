package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransitionCompat21.java */
/* JADX INFO: loaded from: classes.dex */
class M implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f1473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f1474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ P f1475c;

    M(P p, View view, ArrayList arrayList) {
        this.f1475c = p;
        this.f1473a = view;
        this.f1474b = arrayList;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f1473a.setVisibility(8);
        int size = this.f1474b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f1474b.get(i)).setVisibility(0);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
    }
}
