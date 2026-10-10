package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* JADX INFO: compiled from: FragmentTransitionCompat21.java */
/* JADX INFO: loaded from: classes.dex */
class L extends Transition.EpicenterCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rect f1471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ P f1472b;

    L(P p, Rect rect) {
        this.f1472b = p;
        this.f1471a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        return this.f1471a;
    }
}
