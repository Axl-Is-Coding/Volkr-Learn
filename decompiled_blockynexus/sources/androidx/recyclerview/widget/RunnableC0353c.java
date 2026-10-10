package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0361k;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.recyclerview.widget.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0353c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f1954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0361k f1955b;

    RunnableC0353c(C0361k c0361k, ArrayList arrayList) {
        this.f1955b = c0361k;
        this.f1954a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (C0361k.b bVar : this.f1954a) {
            this.f1955b.b(bVar.f2002a, bVar.f2003b, bVar.f2004c, bVar.f2005d, bVar.f2006e);
        }
        this.f1954a.clear();
        this.f1955b.n.remove(this.f1954a);
    }
}
