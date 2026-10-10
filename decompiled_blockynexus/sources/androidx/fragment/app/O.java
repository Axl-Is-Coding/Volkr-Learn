package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* JADX INFO: compiled from: FragmentTransitionCompat21.java */
/* JADX INFO: loaded from: classes.dex */
class O extends Transition.EpicenterCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rect f1482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ P f1483b;

    O(P p, Rect rect) {
        this.f1483b = p;
        this.f1482a = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f1482a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f1482a;
    }
}
