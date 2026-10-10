package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: OnBackPressedCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f189b = new CopyOnWriteArrayList<>();

    public c(boolean z) {
        this.f188a = z;
    }

    public abstract void a();

    public final void a(boolean z) {
        this.f188a = z;
    }

    public final boolean b() {
        return this.f188a;
    }

    public final void c() {
        Iterator<a> it = this.f189b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void a(a aVar) {
        this.f189b.add(aVar);
    }

    void b(a aVar) {
        this.f189b.remove(aVar);
    }
}
