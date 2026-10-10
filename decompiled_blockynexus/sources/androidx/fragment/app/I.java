package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f1450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fragment f1451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f1452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ a.a.b f1453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ View f1454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ U f1455f;
    final /* synthetic */ Rect g;

    I(Fragment fragment, Fragment fragment2, boolean z, a.a.b bVar, View view, U u, Rect rect) {
        this.f1450a = fragment;
        this.f1451b = fragment2;
        this.f1452c = z;
        this.f1453d = bVar;
        this.f1454e = view;
        this.f1455f = u;
        this.g = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        K.a(this.f1450a, this.f1451b, this.f1452c, (a.a.b<String, View>) this.f1453d, false);
        View view = this.f1454e;
        if (view != null) {
            this.f1455f.a(view, this.g);
        }
    }
}
