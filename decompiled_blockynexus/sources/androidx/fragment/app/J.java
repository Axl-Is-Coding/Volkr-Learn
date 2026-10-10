package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.K;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f1456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a.a.b f1457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f1458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ K.a f1459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f1460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ View f1461f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ Fragment h;
    final /* synthetic */ boolean i;
    final /* synthetic */ ArrayList j;
    final /* synthetic */ Object k;
    final /* synthetic */ Rect l;

    J(U u, a.a.b bVar, Object obj, K.a aVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f1456a = u;
        this.f1457b = bVar;
        this.f1458c = obj;
        this.f1459d = aVar;
        this.f1460e = arrayList;
        this.f1461f = view;
        this.g = fragment;
        this.h = fragment2;
        this.i = z;
        this.j = arrayList2;
        this.k = obj2;
        this.l = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a.b<String, View> bVarA = K.a(this.f1456a, (a.a.b<String, String>) this.f1457b, this.f1458c, this.f1459d);
        if (bVarA != null) {
            this.f1460e.addAll(bVarA.values());
            this.f1460e.add(this.f1461f);
        }
        K.a(this.g, this.h, this.i, bVarA, false);
        Object obj = this.f1458c;
        if (obj != null) {
            this.f1456a.b(obj, this.j, this.f1460e);
            View viewA = K.a(bVarA, this.f1459d, this.k, this.i);
            if (viewA != null) {
                this.f1456a.a(viewA, this.l);
            }
        }
    }
}
