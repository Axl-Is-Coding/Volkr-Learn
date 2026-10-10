package androidx.fragment.app;

import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Fragment.java */
/* JADX INFO: loaded from: classes.dex */
class C0330h extends AbstractC0332j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f1506a;

    C0330h(Fragment fragment) {
        this.f1506a = fragment;
    }

    @Override // androidx.fragment.app.AbstractC0332j
    public View a(int i) {
        View view = this.f1506a.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + this + " does not have a view");
    }

    @Override // androidx.fragment.app.AbstractC0332j
    public boolean a() {
        return this.f1506a.mView != null;
    }
}
