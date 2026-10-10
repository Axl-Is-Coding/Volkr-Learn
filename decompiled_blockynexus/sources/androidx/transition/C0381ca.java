package androidx.transition;

import androidx.transition.C0383da;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.transition.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TransitionManager.java */
/* JADX INFO: loaded from: classes.dex */
class C0381ca extends C0379ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.a.b f2230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0383da.a f2231b;

    C0381ca(C0383da.a aVar, a.a.b bVar) {
        this.f2231b = aVar;
        this.f2230a = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        ((ArrayList) this.f2230a.get(this.f2231b.f2237b)).remove(transition);
        transition.b(this);
    }
}
