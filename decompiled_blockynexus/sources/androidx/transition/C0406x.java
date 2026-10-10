package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.transition.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
class C0406x implements Transition.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f2306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f2307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f2308c;

    C0406x(A a2, View view, ArrayList arrayList) {
        this.f2308c = a2;
        this.f2306a = view;
        this.f2307b = arrayList;
    }

    @Override // androidx.transition.Transition.c
    public void a(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void b(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void c(Transition transition) {
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        transition.b(this);
        this.f2306a.setVisibility(8);
        int size = this.f2307b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f2307b.get(i)).setVisibility(0);
        }
    }

    @Override // androidx.transition.Transition.c
    public void e(Transition transition) {
    }
}
