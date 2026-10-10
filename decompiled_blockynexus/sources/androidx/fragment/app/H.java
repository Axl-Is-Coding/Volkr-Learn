package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f1444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f1445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f1446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Fragment f1447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f1448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ArrayList f1449f;
    final /* synthetic */ ArrayList g;
    final /* synthetic */ Object h;

    H(Object obj, U u, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f1444a = obj;
        this.f1445b = u;
        this.f1446c = view;
        this.f1447d = fragment;
        this.f1448e = arrayList;
        this.f1449f = arrayList2;
        this.g = arrayList3;
        this.h = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.f1444a;
        if (obj != null) {
            this.f1445b.b(obj, this.f1446c);
            this.f1449f.addAll(K.a(this.f1445b, this.f1444a, this.f1447d, (ArrayList<View>) this.f1448e, this.f1446c));
        }
        if (this.g != null) {
            if (this.h != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1446c);
                this.f1445b.a(this.h, this.g, arrayList);
            }
            this.g.clear();
            this.g.add(this.f1446c);
        }
    }
}
