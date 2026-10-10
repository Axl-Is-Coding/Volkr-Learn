package okhttp3.internal.http2;

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
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f23323a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.a.e.a("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f23324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final b f23325c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f23327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f23328f;
    int g;
    boolean h;
    private final ScheduledExecutorService i;
    private final ExecutorService j;
    final PushObserver k;
    private boolean l;
    long n;
    final Socket r;
    final p s;
    final d t;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map<Integer, o> f23326d = new LinkedHashMap();
    long m = 0;
    s o = new s();
    final s p = new s();
    boolean q = false;
    final Set<Integer> u = new LinkedHashSet();

    /* JADX INFO: compiled from: Http2Connection.java */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23335a = new k();

        public void a(j jVar) {
        }

        public abstract void a(o oVar) throws IOException;
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    final class c extends okhttp3.a.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f23336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f23337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f23338d;

        c(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", j.this.f23327e, Integer.valueOf(i), Integer.valueOf(i2));
            this.f23336b = z;
            this.f23337c = i;
            this.f23338d = i2;
        }

        @Override // okhttp3.a.b
        public void a() {
            j.this.a(this.f23336b, this.f23337c, this.f23338d);
        }
    }

    j(a aVar) {
        this.k = aVar.f23334f;
        boolean z = aVar.g;
        this.f23324b = z;
        this.f23325c = aVar.f23333e;
        this.g = z ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        if (aVar.g) {
            this.o.a(7, 16777216);
        }
        this.f23327e = aVar.f23330b;
        this.i = new ScheduledThreadPoolExecutor(1, okhttp3.a.e.a(okhttp3.a.e.a("OkHttp %s Writer", this.f23327e), false));
        if (aVar.h != 0) {
            ScheduledExecutorService scheduledExecutorService = this.i;
            c cVar = new c(false, 0, 0);
            int i = aVar.h;
            scheduledExecutorService.scheduleAtFixedRate(cVar, i, i, TimeUnit.MILLISECONDS);
        }
        this.j = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.a.e.a(okhttp3.a.e.a("OkHttp %s Push Observer", this.f23327e), true));
        this.p.a(7, 65535);
        this.p.a(5, 16384);
        this.n = this.p.c();
        this.r = aVar.f23329a;
        this.s = new p(aVar.f23332d, this.f23324b);
        this.t = new d(new Http2Reader(aVar.f23331c, this.f23324b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    boolean b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    synchronized o c(int i) {
        o oVarRemove;
        oVarRemove = this.f23326d.remove(Integer.valueOf(i));
        notifyAll();
        return oVarRemove;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public synchronized boolean d() {
        return this.h;
    }

    public void flush() throws IOException {
        this.s.flush();
    }

    public synchronized int g() {
        return this.p.b(Integer.MAX_VALUE);
    }

    public void n() throws IOException {
        a(true);
    }

    synchronized o a(int i) {
        return this.f23326d.get(Integer.valueOf(i));
    }

    synchronized void b(long j) {
        this.m += j;
        if (this.m >= this.o.c() / 2) {
            a(0, this.m);
            this.m = 0L;
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Socket f23329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f23330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        BufferedSource f23331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        BufferedSink f23332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        b f23333e = b.f23335a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        PushObserver f23334f = PushObserver.CANCEL;
        boolean g;
        int h;

        public a(boolean z) {
            this.g = z;
        }

        public a a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f23329a = socket;
            this.f23330b = str;
            this.f23331c = bufferedSource;
            this.f23332d = bufferedSink;
            return this;
        }

        public a a(b bVar) {
            this.f23333e = bVar;
            return this;
        }

        public a a(int i) {
            this.h = i;
            return this;
        }

        public j a() {
            return new j(this);
        }
    }

    public o a(List<Header> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    void c(int i, ErrorCode errorCode) {
        try {
            this.i.execute(new okhttp3.internal.http2.d(this, "OkHttp %s stream %d", new Object[]{this.f23327e, Integer.valueOf(i)}, i, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void a(int i, boolean z, Buffer buffer, long j) throws IOException {
        int iMin;
        long j2;
        if (j == 0) {
            this.s.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (this.n <= 0) {
                    try {
                        if (this.f23326d.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, this.n), this.s.maxDataLength());
                j2 = iMin;
                this.n -= j2;
            }
            j -= j2;
            this.s.data(z && j == 0, i, buffer, iMin);
        }
    }

    private o b(int i, List<Header> list, boolean z) throws IOException {
        int i2;
        o oVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.s) {
            synchronized (this) {
                if (this.g > 1073741823) {
                    a(ErrorCode.REFUSED_STREAM);
                }
                if (!this.h) {
                    i2 = this.g;
                    this.g += 2;
                    oVar = new o(i2, this, z3, false, null);
                    z2 = !z || this.n == 0 || oVar.f23348b == 0;
                    if (oVar.g()) {
                        this.f23326d.put(Integer.valueOf(i2), oVar);
                    }
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            if (i == 0) {
                this.s.a(z3, i2, i, list);
            } else if (!this.f23324b) {
                this.s.pushPromise(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.s.flush();
        }
        return oVar;
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class d extends okhttp3.a.b implements Http2Reader.Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Http2Reader f23340b;

        d(Http2Reader http2Reader) {
            super("OkHttp %s", j.this.f23327e);
            this.f23340b = http2Reader;
        }

        @Override // okhttp3.a.b
        protected void a() throws Throwable {
            ErrorCode errorCode;
            j jVar;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.f23340b.a(this);
                    while (this.f23340b.a(false, (Http2Reader.Handler) this)) {
                    }
                    errorCode = ErrorCode.NO_ERROR;
                    try {
                        errorCode2 = ErrorCode.CANCEL;
                        jVar = j.this;
                    } catch (IOException unused) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        jVar = j.this;
                    }
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                try {
                    j.this.a(errorCode, errorCode2);
                } catch (IOException unused4) {
                }
                okhttp3.a.e.a(this.f23340b);
                throw th;
            }
            jVar.a(errorCode, errorCode2);
            okhttp3.a.e.a(this.f23340b);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (j.this.b(i)) {
                j.this.a(i, bufferedSource, i2, z);
                return;
            }
            o oVarA = j.this.a(i);
            if (oVarA == null) {
                j.this.c(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                j.this.b(j);
                bufferedSource.skip(j);
                return;
            }
            oVarA.a(bufferedSource, i2);
            if (z) {
                oVarA.i();
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            o[] oVarArr;
            byteString.size();
            synchronized (j.this) {
                oVarArr = (o[]) j.this.f23326d.values().toArray(new o[j.this.f23326d.size()]);
                j.this.h = true;
            }
            for (o oVar : oVarArr) {
                if (oVar.c() > i && oVar.f()) {
                    oVar.c(ErrorCode.REFUSED_STREAM);
                    j.this.c(oVar.c());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<Header> list) {
            if (j.this.b(i)) {
                j.this.a(i, list, z);
                return;
            }
            synchronized (j.this) {
                o oVarA = j.this.a(i);
                if (oVarA != null) {
                    oVarA.a(list);
                    if (z) {
                        oVarA.i();
                        return;
                    }
                    return;
                }
                if (j.this.h) {
                    return;
                }
                if (i <= j.this.f23328f) {
                    return;
                }
                if (i % 2 == j.this.g % 2) {
                    return;
                }
                o oVar = new o(i, j.this, false, z, okhttp3.a.e.b(list));
                j.this.f23328f = i;
                j.this.f23326d.put(Integer.valueOf(i), oVar);
                j.f23323a.execute(new l(this, "OkHttp %s stream %d", new Object[]{j.this.f23327e, Integer.valueOf(i)}, oVar));
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                try {
                    j.this.i.execute(j.this.new c(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (j.this) {
                    j.this.l = false;
                    j.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            j.this.a(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (j.this.b(i)) {
                j.this.a(i, errorCode);
                return;
            }
            o oVarC = j.this.c(i);
            if (oVarC != null) {
                oVarC.c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z, s sVar) {
            o[] oVarArr;
            long j;
            int i;
            synchronized (j.this) {
                int iC = j.this.p.c();
                if (z) {
                    j.this.p.a();
                }
                j.this.p.a(sVar);
                a(sVar);
                int iC2 = j.this.p.c();
                oVarArr = null;
                if (iC2 == -1 || iC2 == iC) {
                    j = 0;
                } else {
                    j = iC2 - iC;
                    if (!j.this.q) {
                        j.this.q = true;
                    }
                    if (!j.this.f23326d.isEmpty()) {
                        oVarArr = (o[]) j.this.f23326d.values().toArray(new o[j.this.f23326d.size()]);
                    }
                }
                j.f23323a.execute(new m(this, "OkHttp %s settings", j.this.f23327e));
            }
            if (oVarArr == null || j == 0) {
                return;
            }
            for (o oVar : oVarArr) {
                synchronized (oVar) {
                    oVar.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (j.this) {
                    j.this.n += j;
                    j.this.notifyAll();
                }
                return;
            }
            o oVarA = j.this.a(i);
            if (oVarA != null) {
                synchronized (oVarA) {
                    oVarA.a(j);
                }
            }
        }

        private void a(s sVar) {
            try {
                j.this.i.execute(new n(this, "OkHttp %s ACK Settings", new Object[]{j.this.f23327e}, sVar));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(int i, long j) {
        try {
            this.i.execute(new e(this, "OkHttp Window Update %s stream %d", new Object[]{this.f23327e, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.l;
                this.l = true;
            }
            if (z2) {
                o();
                return;
            }
        }
        try {
            this.s.ping(z, i, i2);
        } catch (IOException unused) {
            o();
        }
    }

    void b(int i, ErrorCode errorCode) throws IOException {
        this.s.a(i, errorCode);
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.s) {
            synchronized (this) {
                if (this.h) {
                    return;
                }
                this.h = true;
                this.s.a(this.f23328f, errorCode, okhttp3.a.e.f23113a);
            }
        }
    }

    void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        o[] oVarArr = null;
        try {
            a(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f23326d.isEmpty()) {
                oVarArr = (o[]) this.f23326d.values().toArray(new o[this.f23326d.size()]);
                this.f23326d.clear();
            }
        }
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                try {
                    oVar.a(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.s.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.r.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.i.shutdown();
        this.j.shutdown();
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.s.connectionPreface();
            this.s.b(this.o);
            if (this.o.c() != 65535) {
                this.s.windowUpdate(0, r6 - 65535);
            }
        }
        new Thread(this.t).start();
    }

    void a(int i, List<Header> list) {
        synchronized (this) {
            if (this.u.contains(Integer.valueOf(i))) {
                c(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.u.add(Integer.valueOf(i));
            try {
                a(new f(this, "OkHttp %s Push Request[%s]", new Object[]{this.f23327e, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(int i, List<Header> list, boolean z) {
        try {
            a(new g(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f23327e, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            a(new h(this, "OkHttp %s Push Data[%s]", new Object[]{this.f23327e, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    void a(int i, ErrorCode errorCode) {
        a(new i(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f23327e, Integer.valueOf(i)}, i, errorCode));
    }

    private synchronized void a(okhttp3.a.b bVar) {
        if (!d()) {
            this.j.execute(bVar);
        }
    }
}
