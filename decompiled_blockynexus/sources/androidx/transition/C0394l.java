package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.transition.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0394l extends C0379ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f2267a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewGroup f2268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ChangeBounds f2269c;

    C0394l(ChangeBounds changeBounds, ViewGroup viewGroup) {
        this.f2269c = changeBounds;
        this.f2268b = viewGroup;
    }

    @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
    public void a(Transition transition) {
        na.a(this.f2268b, true);
    }

    @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
    public void c(Transition transition) {
        na.a(this.f2268b, false);
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        if (!this.f2267a) {
            na.a(this.f2268b, false);
        }
        transition.b(this);
    }

    @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
    public void e(Transition transition) {
        na.a(this.f2268b, false);
        this.f2267a = true;
    }
}
