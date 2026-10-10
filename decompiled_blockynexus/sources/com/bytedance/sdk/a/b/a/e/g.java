package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.b.a.e.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f5059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b f5060c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f5062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5063f;
    int g;
    boolean h;
    final m i;
    long k;
    final Socket o;
    final j p;
    final c q;
    private final ExecutorService t;
    private Map<Integer, l> u;
    private int v;
    static final /* synthetic */ boolean s = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ExecutorService f5058a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map<Integer, i> f5061d = new LinkedHashMap();
    long j = 0;
    n l = new n();
    final n m = new n();
    boolean n = false;
    final Set<Integer> r = new LinkedHashSet();

    /* JADX INFO: compiled from: Http2Connection.java */
    public static abstract class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f5096f = new b() { // from class: com.bytedance.sdk.a.b.a.e.g.b.1
            @Override // com.bytedance.sdk.a.b.a.e.g.b
            public void a(i iVar) throws IOException {
                iVar.a(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
            }
        };

        public void a(g gVar) {
        }

        public abstract void a(i iVar) throws IOException;
    }

    g(a aVar) {
        this.i = aVar.f5095f;
        boolean z = aVar.g;
        this.f5059b = z;
        this.f5060c = aVar.f5094e;
        this.g = z ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        this.v = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.l.a(7, 16777216);
        }
        this.f5062e = aVar.f5091b;
        this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.a("OkHttp %s Push Observer", this.f5062e), true));
        this.m.a(7, 65535);
        this.m.a(5, 16384);
        this.k = this.m.d();
        this.o = aVar.f5090a;
        this.p = new j(aVar.f5093d, this.f5059b);
        this.q = new c(new h(aVar.f5092c, this.f5059b));
    }

    synchronized i a(int i) {
        return this.f5061d.get(Integer.valueOf(i));
    }

    synchronized i b(int i) {
        i iVarRemove;
        iVarRemove = this.f5061d.remove(Integer.valueOf(i));
        notifyAll();
        return iVarRemove;
    }

    synchronized l c(int i) {
        return this.u != null ? this.u.remove(Integer.valueOf(i)) : null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(com.bytedance.sdk.a.b.a.e.b.NO_ERROR, com.bytedance.sdk.a.b.a.e.b.CANCEL);
    }

    public synchronized boolean d() {
        return this.h;
    }

    boolean d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public synchronized int a() {
        return this.m.c(Integer.MAX_VALUE);
    }

    public void c() throws IOException {
        a(true);
    }

    public i a(List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    void c(final int i, final com.bytedance.sdk.a.b.a.e.b bVar) {
        this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.7
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                g.this.i.a(i, bVar);
                synchronized (g.this) {
                    g.this.r.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Socket f5090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.bytedance.sdk.a.a.e f5092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.bytedance.sdk.a.a.d f5093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        b f5094e = b.f5096f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        m f5095f = m.f5149a;
        boolean g;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
            this.f5090a = socket;
            this.f5091b = str;
            this.f5092c = eVar;
            this.f5093d = dVar;
            return this;
        }

        public a a(b bVar) {
            this.f5094e = bVar;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    private i b(int i, List<com.bytedance.sdk.a.b.a.e.c> list, boolean z) throws IOException {
        int i2;
        i iVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.p) {
            synchronized (this) {
                if (!this.h) {
                    i2 = this.g;
                    this.g += 2;
                    iVar = new i(i2, this, z3, false, list);
                    z2 = !z || this.k == 0 || iVar.f5116b == 0;
                    if (iVar.b()) {
                        this.f5061d.put(Integer.valueOf(i2), iVar);
                    }
                } else {
                    throw new com.bytedance.sdk.a.b.a.e.a();
                }
            }
            if (i == 0) {
                this.p.a(z3, i2, i, list);
            } else if (!this.f5059b) {
                this.p.a(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.p.b();
        }
        return iVar;
    }

    public void a(int i, boolean z, com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
        int iMin;
        long j2;
        if (j == 0) {
            this.p.a(z, i, cVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.k <= 0) {
                    try {
                        if (this.f5061d.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, this.k), this.p.c());
                j2 = iMin;
                this.k -= j2;
            }
            j -= j2;
            this.p.a(z && j == 0, i, cVar, iMin);
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class c extends com.bytedance.sdk.a.b.a.b implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f5097a;

        c(h hVar) {
            super("OkHttp %s", g.this.f5062e);
            this.f5097a = hVar;
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a() {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
            if (g.this.d(i)) {
                g.this.a(i, eVar, i2, z);
                return;
            }
            i iVarA = g.this.a(i);
            if (iVarA == null) {
                g.this.a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.h(i2);
            } else {
                iVarA.a(eVar, i2);
                if (z) {
                    iVarA.i();
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() throws Throwable {
            com.bytedance.sdk.a.b.a.e.b bVar;
            g gVar;
            com.bytedance.sdk.a.b.a.e.b bVar2 = com.bytedance.sdk.a.b.a.e.b.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.f5097a.a(this);
                    while (this.f5097a.a(false, (h.b) this)) {
                    }
                    bVar = com.bytedance.sdk.a.b.a.e.b.NO_ERROR;
                    try {
                        bVar2 = com.bytedance.sdk.a.b.a.e.b.CANCEL;
                        gVar = g.this;
                    } catch (IOException unused) {
                        bVar = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                        bVar2 = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                        gVar = g.this;
                    }
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                try {
                    g.this.a(bVar, bVar2);
                } catch (IOException unused4) {
                }
                com.bytedance.sdk.a.b.a.c.a(this.f5097a);
                throw th;
            }
            gVar.a(bVar, bVar2);
            com.bytedance.sdk.a.b.a.c.a(this.f5097a);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2, List<com.bytedance.sdk.a.b.a.e.c> list) {
            if (g.this.d(i)) {
                g.this.a(i, list, z);
                return;
            }
            synchronized (g.this) {
                i iVarA = g.this.a(i);
                if (iVarA == null) {
                    if (g.this.h) {
                        return;
                    }
                    if (i <= g.this.f5063f) {
                        return;
                    }
                    if (i % 2 == g.this.g % 2) {
                        return;
                    }
                    final i iVar = new i(i, g.this, false, z, list);
                    g.this.f5063f = i;
                    g.this.f5061d.put(Integer.valueOf(i), iVar);
                    g.f5058a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{g.this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.1
                        @Override // com.bytedance.sdk.a.b.a.b
                        public void b() {
                            try {
                                g.this.f5060c.a(iVar);
                            } catch (IOException e2) {
                                com.bytedance.sdk.a.b.a.g.e.b().a(4, "Http2Connection.Listener failure for " + g.this.f5062e, e2);
                                try {
                                    iVar.a(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                iVarA.a(list);
                if (z) {
                    iVarA.i();
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            if (g.this.d(i)) {
                g.this.c(i, bVar);
                return;
            }
            i iVarB = g.this.b(i);
            if (iVarB != null) {
                iVarB.c(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j;
            int i;
            synchronized (g.this) {
                int iD = g.this.m.d();
                if (z) {
                    g.this.m.a();
                }
                g.this.m.a(nVar);
                a(nVar);
                int iD2 = g.this.m.d();
                iVarArr = null;
                if (iD2 == -1 || iD2 == iD) {
                    j = 0;
                } else {
                    j = iD2 - iD;
                    if (!g.this.n) {
                        g.this.a(j);
                        g.this.n = true;
                    }
                    if (!g.this.f5061d.isEmpty()) {
                        iVarArr = (i[]) g.this.f5061d.values().toArray(new i[g.this.f5061d.size()]);
                    }
                }
                g.f5058a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s settings", g.this.f5062e) { // from class: com.bytedance.sdk.a.b.a.e.g.c.2
                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        g gVar = g.this;
                        gVar.f5060c.a(gVar);
                    }
                });
            }
            if (iVarArr == null || j == 0) {
                return;
            }
            for (i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.a(j);
                }
            }
        }

        private void a(final n nVar) {
            g.f5058a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.f5062e}) { // from class: com.bytedance.sdk.a.b.a.e.g.c.3
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        g.this.p.a(nVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(boolean z, int i, int i2) {
            if (z) {
                l lVarC = g.this.c(i);
                if (lVarC != null) {
                    lVarC.b();
                    return;
                }
                return;
            }
            g.this.a(true, i, i2, (l) null);
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar) {
            i[] iVarArr;
            fVar.g();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.f5061d.values().toArray(new i[g.this.f5061d.size()]);
                g.this.h = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.a() > i && iVar.c()) {
                    iVar.c(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
                    g.this.b(iVar.a());
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (g.this) {
                    g.this.k += j;
                    g.this.notifyAll();
                }
                return;
            }
            i iVarA = g.this.a(i);
            if (iVarA != null) {
                synchronized (iVarA) {
                    iVarA.a(j);
                }
            }
        }

        @Override // com.bytedance.sdk.a.b.a.e.h.b
        public void a(int i, int i2, List<com.bytedance.sdk.a.b.a.e.c> list) {
            g.this.a(i2, list);
        }
    }

    void a(long j) {
        this.k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void a(final int i, final com.bytedance.sdk.a.b.a.e.b bVar) {
        f5058a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s stream %d", new Object[]{this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.1
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(i, bVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    void a(final int i, final long j) {
        f5058a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.2
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.p.a(i, j);
                } catch (IOException unused) {
                }
            }
        });
    }

    void a(final boolean z, final int i, final int i2, final l lVar) {
        f5058a.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.f5062e, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.a.b.a.e.g.3
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                try {
                    g.this.b(z, i, i2, lVar);
                } catch (IOException unused) {
                }
            }
        });
    }

    void b(int i, com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        this.p.a(i, bVar);
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        synchronized (this.p) {
            synchronized (this) {
                if (this.h) {
                    return;
                }
                this.h = true;
                this.p.a(this.f5063f, bVar, com.bytedance.sdk.a.b.a.c.f4964a);
            }
        }
    }

    void b(boolean z, int i, int i2, l lVar) throws IOException {
        synchronized (this.p) {
            if (lVar != null) {
                lVar.a();
                this.p.a(z, i, i2);
            } else {
                this.p.a(z, i, i2);
            }
        }
    }

    public void b() throws IOException {
        this.p.b();
    }

    void a(com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.b.a.e.b bVar2) throws IOException {
        i[] iVarArr;
        if (!s && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        l[] lVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f5061d.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (i[]) this.f5061d.values().toArray(new i[this.f5061d.size()]);
                this.f5061d.clear();
            }
            if (this.u != null) {
                l[] lVarArr2 = (l[]) this.u.values().toArray(new l[this.u.size()]);
                this.u = null;
                lVarArr = lVarArr2;
            }
        }
        if (iVarArr != null) {
            IOException iOException = e;
            for (i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (iOException != null) {
                        iOException = e3;
                    }
                }
            }
            e = iOException;
        }
        if (lVarArr != null) {
            for (l lVar : lVarArr) {
                lVar.c();
            }
        }
        try {
            this.p.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.o.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.p.a();
            this.p.b(this.l);
            if (this.l.d() != 65535) {
                this.p.a(0, r6 - 65535);
            }
        }
        new Thread(this.q).start();
    }

    void a(final int i, final List<com.bytedance.sdk.a.b.a.e.c> list) {
        synchronized (this) {
            if (this.r.contains(Integer.valueOf(i))) {
                a(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
            } else {
                this.r.add(Integer.valueOf(i));
                this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.4
                    @Override // com.bytedance.sdk.a.b.a.b
                    public void b() {
                        if (g.this.i.a(i, list)) {
                            try {
                                g.this.p.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                                synchronized (g.this) {
                                    g.this.r.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    void a(final int i, final List<com.bytedance.sdk.a.b.a.e.c> list, final boolean z) {
        this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.5
            @Override // com.bytedance.sdk.a.b.a.b
            public void b() {
                boolean zA = g.this.i.a(i, list, z);
                if (zA) {
                    try {
                        g.this.p.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (zA || z) {
                    synchronized (g.this) {
                        g.this.r.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    void a(final int i, com.bytedance.sdk.a.a.e eVar, final int i2, final boolean z) throws IOException {
        final com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        long j = i2;
        eVar.a(j);
        eVar.a(cVar, j);
        if (cVar.b() == j) {
            this.t.execute(new com.bytedance.sdk.a.b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.f5062e, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.a.b.a.e.g.6
                @Override // com.bytedance.sdk.a.b.a.b
                public void b() {
                    try {
                        boolean zA = g.this.i.a(i, cVar, i2, z);
                        if (zA) {
                            g.this.p.a(i, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                        }
                        if (zA || z) {
                            synchronized (g.this) {
                                g.this.r.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(cVar.b() + " != " + i2);
    }
}
