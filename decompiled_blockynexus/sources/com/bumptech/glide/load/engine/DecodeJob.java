package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.e.a.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.InterfaceC0497g;
import com.bumptech.glide.load.engine.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DecodeJob<R> implements InterfaceC0497g.a, Runnable, Comparable<DecodeJob<?>>, d.c {
    private DataSource A;
    private com.bumptech.glide.load.data.d<?> B;
    private volatile InterfaceC0497g C;
    private volatile boolean D;
    private volatile boolean E;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f4423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.core.f.e<DecodeJob<?>> f4424e;
    private com.bumptech.glide.f h;
    private com.bumptech.glide.load.h i;
    private Priority j;
    private u k;
    private int l;
    private int m;
    private p n;
    private com.bumptech.glide.load.l o;
    private a<R> p;
    private int q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.h x;
    private com.bumptech.glide.load.h y;
    private Object z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0498h<R> f4420a = new C0498h<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Throwable> f4421b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.e.a.g f4422c = com.bumptech.glide.e.a.g.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c<?> f4425f = new c<>();
    private final e g = new e();

    /* JADX INFO: Access modifiers changed from: private */
    enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    interface a<R> {
        void a(C<R> c2, DataSource dataSource);

        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);
    }

    private final class b<Z> implements j.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DataSource f4426a;

        b(DataSource dataSource) {
            this.f4426a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.j.a
        public C<Z> a(C<Z> c2) {
            return DecodeJob.this.a(this.f4426a, c2);
        }
    }

    interface d {
        com.bumptech.glide.load.engine.b.a a();
    }

    DecodeJob(d dVar, androidx.core.f.e<DecodeJob<?>> eVar) {
        this.f4423d = dVar;
        this.f4424e = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(C<R> c2, DataSource dataSource) {
        if (c2 instanceof x) {
            ((x) c2).initialize();
        }
        B b2 = 0;
        if (this.f4425f.b()) {
            c2 = B.a(c2);
            b2 = c2;
        }
        a((C) c2, dataSource);
        this.r = Stage.ENCODE;
        try {
            if (this.f4425f.b()) {
                this.f4425f.a(this.f4423d, this.o);
            }
            i();
        } finally {
            if (b2 != 0) {
                b2.c();
            }
        }
    }

    private void e() {
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        C<R> cA = null;
        try {
            cA = a(this.B, this.z, this.A);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.f4421b.add(e2);
        }
        if (cA != null) {
            b(cA, this.A);
        } else {
            o();
        }
    }

    private InterfaceC0497g f() {
        int i = i.f4574b[this.r.ordinal()];
        if (i == 1) {
            return new D(this.f4420a, this);
        }
        if (i == 2) {
            return new C0494d(this.f4420a, this);
        }
        if (i == 3) {
            return new H(this.f4420a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private int g() {
        return this.j.ordinal();
    }

    private void h() {
        q();
        this.p.a(new GlideException("Failed to load resource", new ArrayList(this.f4421b)));
        m();
    }

    private void i() {
        if (this.g.a()) {
            n();
        }
    }

    private void m() {
        if (this.g.b()) {
            n();
        }
    }

    private void n() {
        this.g.c();
        this.f4425f.a();
        this.f4420a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f4421b.clear();
        this.f4424e.a(this);
    }

    private void o() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.e.h.a();
        boolean zA = false;
        while (!this.E && this.C != null && !(zA = this.C.a())) {
            this.r = a(this.r);
            this.C = f();
            if (this.r == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.r == Stage.FINISHED || this.E) && !zA) {
            h();
        }
    }

    private void p() {
        int i = i.f4573a[this.s.ordinal()];
        if (i == 1) {
            this.r = a(Stage.INITIALIZE);
            this.C = f();
            o();
        } else if (i == 2) {
            o();
        } else {
            if (i == 3) {
                e();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void q() {
        Throwable th;
        this.f4422c.b();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f4421b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f4421b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    DecodeJob<R> a(com.bumptech.glide.f fVar, Object obj, u uVar, com.bumptech.glide.load.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, p pVar, Map<Class<?>, com.bumptech.glide.load.o<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.l lVar, a<R> aVar, int i3) {
        this.f4420a.a(fVar, obj, hVar, i, i2, pVar, cls, cls2, priority, lVar, map, z, z2, this.f4423d);
        this.h = fVar;
        this.i = hVar;
        this.j = priority;
        this.k = uVar;
        this.l = i;
        this.m = i2;
        this.n = pVar;
        this.u = z3;
        this.o = lVar;
        this.p = aVar;
        this.q = i3;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g.a
    public void c() {
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((DecodeJob<?>) this);
    }

    boolean d() {
        Stage stageA = a(Stage.INITIALIZE);
        return stageA == Stage.RESOURCE_CACHE || stageA == Stage.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.e.a.e.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.load.data.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    h();
                    return;
                }
                p();
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.e.a.e.a();
            } catch (CallbackException e2) {
                throw e2;
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r, th);
                }
                if (this.r != Stage.ENCODE) {
                    this.f4421b.add(th);
                    h();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } finally {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.e.a.e.a();
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4433c;

        e() {
        }

        synchronized boolean a(boolean z) {
            this.f4431a = true;
            return b(z);
        }

        synchronized boolean b() {
            this.f4433c = true;
            return b(false);
        }

        synchronized void c() {
            this.f4432b = false;
            this.f4431a = false;
            this.f4433c = false;
        }

        private boolean b(boolean z) {
            return (this.f4433c || z || this.f4432b) && this.f4431a;
        }

        synchronized boolean a() {
            this.f4432b = true;
            return b(false);
        }
    }

    private static class c<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.h f4428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.n<Z> f4429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private B<Z> f4430c;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.h hVar, com.bumptech.glide.load.n<X> nVar, B<X> b2) {
            this.f4428a = hVar;
            this.f4429b = nVar;
            this.f4430c = b2;
        }

        boolean b() {
            return this.f4430c != null;
        }

        void a(d dVar, com.bumptech.glide.load.l lVar) {
            com.bumptech.glide.e.a.e.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f4428a, new C0496f(this.f4429b, this.f4430c, lVar));
            } finally {
                this.f4430c.c();
                com.bumptech.glide.e.a.e.a();
            }
        }

        void a() {
            this.f4428a = null;
            this.f4429b = null;
            this.f4430c = null;
        }
    }

    @Override // com.bumptech.glide.e.a.d.c
    public com.bumptech.glide.e.a.g b() {
        return this.f4422c;
    }

    void a(boolean z) {
        if (this.g.a(z)) {
            n();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DecodeJob<?> decodeJob) {
        int iG = g() - decodeJob.g();
        return iG == 0 ? this.q - decodeJob.q : iG;
    }

    public void a() {
        this.E = true;
        InterfaceC0497g interfaceC0497g = this.C;
        if (interfaceC0497g != null) {
            interfaceC0497g.cancel();
        }
    }

    private void a(C<R> c2, DataSource dataSource) {
        q();
        this.p.a(c2, dataSource);
    }

    private Stage a(Stage stage) {
        int i = i.f4574b[stage.ordinal()];
        if (i == 1) {
            if (this.n.a()) {
                return Stage.DATA_CACHE;
            }
            return a(Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return Stage.FINISHED;
        }
        if (i == 5) {
            if (this.n.b()) {
                return Stage.RESOURCE_CACHE;
            }
            return a(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g.a
    public void a(com.bumptech.glide.load.h hVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.h hVar2) {
        this.x = hVar;
        this.z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.y = hVar2;
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.DECODE_DATA;
            this.p.a((DecodeJob<?>) this);
        } else {
            com.bumptech.glide.e.a.e.a("DecodeJob.decodeFromRetrievedData");
            try {
                e();
            } finally {
                com.bumptech.glide.e.a.e.a();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0497g.a
    public void a(com.bumptech.glide.load.h hVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(hVar, dataSource, dVar.a());
        this.f4421b.add(glideException);
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((DecodeJob<?>) this);
        } else {
            o();
        }
    }

    private <Data> C<R> a(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long jA = com.bumptech.glide.e.h.a();
            C<R> cA = a(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + cA, jA);
            }
            return cA;
        } finally {
            dVar.b();
        }
    }

    private <Data> C<R> a(Data data, DataSource dataSource) throws GlideException {
        return a(data, dataSource, this.f4420a.a((Class) data.getClass()));
    }

    private com.bumptech.glide.load.l a(DataSource dataSource) {
        com.bumptech.glide.load.l lVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return lVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f4420a.o();
        Boolean bool = (Boolean) lVar.a(com.bumptech.glide.load.resource.bitmap.m.f4683e);
        if (bool != null && (!bool.booleanValue() || z)) {
            return lVar;
        }
        com.bumptech.glide.load.l lVar2 = new com.bumptech.glide.load.l();
        lVar2.a(this.o);
        lVar2.a(com.bumptech.glide.load.resource.bitmap.m.f4683e, Boolean.valueOf(z));
        return lVar2;
    }

    private <Data, ResourceType> C<R> a(Data data, DataSource dataSource, z<Data, ResourceType, R> zVar) throws GlideException {
        com.bumptech.glide.load.l lVarA = a(dataSource);
        com.bumptech.glide.load.data.e<Data> eVarB = this.h.f().b(data);
        try {
            return zVar.a(eVarB, lVarA, this.l, this.m, new b(dataSource));
        } finally {
            eVarB.b();
        }
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.e.h.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    <Z> C<Z> a(DataSource dataSource, C<Z> c2) {
        C<Z> cTransform;
        com.bumptech.glide.load.o<Z> oVar;
        EncodeStrategy encodeStrategyA;
        com.bumptech.glide.load.h c0495e;
        Class<?> cls = c2.get().getClass();
        com.bumptech.glide.load.n<Z> nVarA = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.o<Z> oVarB = this.f4420a.b(cls);
            oVar = oVarB;
            cTransform = oVarB.transform(this.h, c2, this.l, this.m);
        } else {
            cTransform = c2;
            oVar = null;
        }
        if (!c2.equals(cTransform)) {
            c2.recycle();
        }
        if (this.f4420a.b((C<?>) cTransform)) {
            nVarA = this.f4420a.a((C) cTransform);
            encodeStrategyA = nVarA.a(this.o);
        } else {
            encodeStrategyA = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.n nVar = nVarA;
        if (!this.n.a(!this.f4420a.a(this.x), dataSource, encodeStrategyA)) {
            return cTransform;
        }
        if (nVar != null) {
            int i = i.f4575c[encodeStrategyA.ordinal()];
            if (i == 1) {
                c0495e = new C0495e(this.x, this.i);
            } else if (i == 2) {
                c0495e = new E(this.f4420a.b(), this.x, this.i, this.l, this.m, oVar, cls, this.o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyA);
            }
            B bA = B.a(cTransform);
            this.f4425f.a(c0495e, nVar, bA);
            return bA;
        }
        throw new Registry.NoResultEncoderAvailableException(cTransform.get().getClass());
    }
}
