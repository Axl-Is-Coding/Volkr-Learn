package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f1485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ArrayList f1486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f1487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f1488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ U f1489f;

    Q(U u, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1489f = u;
        this.f1484a = i;
        this.f1485b = arrayList;
        this.f1486c = arrayList2;
        this.f1487d = arrayList3;
        this.f1488e = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f1484a; i++) {
            ViewCompat.a((View) this.f1485b.get(i), (String) this.f1486c.get(i));
            ViewCompat.a((View) this.f1487d.get(i), (String) this.f1488e.get(i));
        }
    }
}
