package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.g;

/* JADX INFO: renamed from: okhttp3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConnectionPool.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2947l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f23431a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.a.e.a("OkHttp ConnectionPool", true));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f23433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f23434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<okhttp3.internal.connection.d> f23435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final okhttp3.internal.connection.e f23436f;
    boolean g;

    public C2947l() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    okhttp3.internal.connection.d a(C2936a c2936a, okhttp3.internal.connection.g gVar, K k) {
        for (okhttp3.internal.connection.d dVar : this.f23435e) {
            if (dVar.a(c2936a, k)) {
                gVar.a(dVar, true);
                return dVar;
            }
        }
        return null;
    }

    void b(okhttp3.internal.connection.d dVar) {
        if (!this.g) {
            this.g = true;
            f23431a.execute(this.f23434d);
        }
        this.f23435e.add(dVar);
    }

    public C2947l(int i, long j, TimeUnit timeUnit) {
        this.f23434d = new RunnableC2946k(this);
        this.f23435e = new ArrayDeque();
        this.f23436f = new okhttp3.internal.connection.e();
        this.f23432b = i;
        this.f23433c = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    Socket a(C2936a c2936a, okhttp3.internal.connection.g gVar) {
        for (okhttp3.internal.connection.d dVar : this.f23435e) {
            if (dVar.a(c2936a, null) && dVar.b() && dVar != gVar.c()) {
                return gVar.a(dVar);
            }
        }
        return null;
    }

    boolean a(okhttp3.internal.connection.d dVar) {
        if (!dVar.k && this.f23432b != 0) {
            notifyAll();
            return false;
        }
        this.f23435e.remove(dVar);
        return true;
    }

    long a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            okhttp3.internal.connection.d dVar = null;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.connection.d dVar2 : this.f23435e) {
                if (a(dVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - dVar2.o;
                    if (j3 > j2) {
                        dVar = dVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f23433c && i <= this.f23432b) {
                if (i > 0) {
                    return this.f23433c - j2;
                }
                if (i2 > 0) {
                    return this.f23433c;
                }
                this.g = false;
                return -1L;
            }
            this.f23435e.remove(dVar);
            okhttp3.a.e.a(dVar.socket());
            return 0L;
        }
    }

    private int a(okhttp3.internal.connection.d dVar, long j) {
        List<Reference<okhttp3.internal.connection.g>> list = dVar.n;
        int i = 0;
        while (i < list.size()) {
            Reference<okhttp3.internal.connection.g> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                okhttp3.a.b.f.a().a("A connection to " + dVar.route().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f23232a);
                list.remove(i);
                dVar.k = true;
                if (list.isEmpty()) {
                    dVar.o = j - this.f23433c;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
