package androidx.transition;

import android.graphics.Rect;
import androidx.transition.Transition;

/* JADX INFO: renamed from: androidx.transition.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
class C0405w extends Transition.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rect f2303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f2304b;

    C0405w(A a2, Rect rect) {
        this.f2304b = a2;
        this.f2303a = rect;
    }

    @Override // androidx.transition.Transition.b
    public Rect a(Transition transition) {
        return this.f2303a;
    }
}
