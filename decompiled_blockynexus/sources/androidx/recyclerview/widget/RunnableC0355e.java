package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0355e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0361k f1960b;

    RunnableC0355e(C0361k c0361k, ArrayList arrayList) {
        this.f1960b = c0361k;
        this.f1959a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1959a.iterator();
        while (it.hasNext()) {
            this.f1960b.t((RecyclerView.w) it.next());
        }
        this.f1959a.clear();
        this.f1960b.m.remove(this.f1959a);
    }
}
