package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: FragmentViewLifecycleOwner.java */
/* JADX INFO: loaded from: classes.dex */
class V implements androidx.lifecycle.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.lifecycle.i f1496a = null;

    V() {
    }

    void a() {
        if (this.f1496a == null) {
            this.f1496a = new androidx.lifecycle.i(this);
        }
    }

    boolean b() {
        return this.f1496a != null;
    }

    @Override // androidx.lifecycle.g
    public Lifecycle getLifecycle() {
        a();
        return this.f1496a;
    }

    void a(Lifecycle.Event event) {
        this.f1496a.b(event);
    }
}
