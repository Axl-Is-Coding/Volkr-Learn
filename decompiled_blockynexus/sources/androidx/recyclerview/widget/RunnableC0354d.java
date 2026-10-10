package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0361k;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0354d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0361k f1958b;

    RunnableC0354d(C0361k c0361k, ArrayList arrayList) {
        this.f1958b = c0361k;
        this.f1957a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1957a.iterator();
        while (it.hasNext()) {
            this.f1958b.a((C0361k.a) it.next());
        }
        this.f1957a.clear();
        this.f1958b.o.remove(this.f1957a);
    }
}
