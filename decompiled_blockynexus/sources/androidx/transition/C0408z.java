package androidx.transition;

import android.graphics.Rect;
import androidx.transition.Transition;

/* JADX INFO: renamed from: androidx.transition.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
class C0408z extends Transition.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rect f2315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f2316b;

    C0408z(A a2, Rect rect) {
        this.f2316b = a2;
        this.f2315a = rect;
    }

    @Override // androidx.transition.Transition.b
    public Rect a(Transition transition) {
        Rect rect = this.f2315a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f2315a;
    }
}
