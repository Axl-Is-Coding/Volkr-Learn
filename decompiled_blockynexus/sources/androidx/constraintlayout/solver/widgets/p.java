package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: ResolutionNode.java */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashSet<p> f869a = new HashSet<>(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f870b = 0;

    public void a(p pVar) {
        this.f869a.add(pVar);
    }

    public void b() {
        this.f870b = 0;
        Iterator<p> it = this.f869a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f870b == 1;
    }

    public void d() {
        this.f870b = 0;
        this.f869a.clear();
    }

    public void e() {
    }

    public void a() {
        this.f870b = 1;
        Iterator<p> it = this.f869a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}
