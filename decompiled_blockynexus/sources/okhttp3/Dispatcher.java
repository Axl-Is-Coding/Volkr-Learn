package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.B;

/* JADX INFO: loaded from: classes5.dex */
public final class Dispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f23022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f23023d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23020a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23021b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<B.a> f23024e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Deque<B.a> f23025f = new ArrayDeque();
    private final Deque<B> g = new ArrayDeque();

    private boolean c() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<B.a> it = this.f23024e.iterator();
            while (it.hasNext()) {
                B.a next = it.next();
                if (this.f23025f.size() >= this.f23020a) {
                    break;
                }
                if (c(next) < this.f23021b) {
                    it.remove();
                    arrayList.add(next);
                    this.f23025f.add(next);
                }
            }
            z = b() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((B.a) arrayList.get(i)).a(a());
        }
        return z;
    }

    public synchronized ExecutorService a() {
        if (this.f23023d == null) {
            this.f23023d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.a.e.a("OkHttp Dispatcher", false));
        }
        return this.f23023d;
    }

    void b(B.a aVar) {
        a(this.f23025f, aVar);
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.f23022c = runnable;
    }

    void b(B b2) {
        a(this.g, b2);
    }

    public synchronized int b() {
        return this.f23025f.size() + this.g.size();
    }

    void a(B.a aVar) {
        synchronized (this) {
            this.f23024e.add(aVar);
        }
        c();
    }

    synchronized void a(B b2) {
        this.g.add(b2);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f23022c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int c(B.a aVar) {
        int i = 0;
        for (B.a aVar2 : this.f23025f) {
            if (!aVar2.b().f23004f && aVar2.c().equals(aVar.c())) {
                i++;
            }
        }
        return i;
    }
}
