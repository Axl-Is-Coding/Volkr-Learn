package com.bytedance.sdk.a.b.a.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Http2Stream.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    static final /* synthetic */ boolean i = !i.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f5116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f5117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f5118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a f5119e;
    private final List<com.bytedance.sdk.a.b.a.e.c> j;
    private List<com.bytedance.sdk.a.b.a.e.c> k;
    private boolean l;
    private final b m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f5115a = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final c f5120f = new c();
    final c g = new c();
    com.bytedance.sdk.a.b.a.e.b h = null;

    /* JADX INFO: compiled from: Http2Stream.java */
    class c extends com.bytedance.sdk.a.a.a {
        c() {
        }

        @Override // com.bytedance.sdk.a.a.a
        protected void a_() {
            i.this.b(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        }

        @Override // com.bytedance.sdk.a.a.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void h() throws IOException {
            if (b()) {
                throw b((IOException) null);
            }
        }
    }

    i(int i2, g gVar, boolean z, boolean z2, List<com.bytedance.sdk.a.b.a.e.c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f5117c = i2;
        this.f5118d = gVar;
        this.f5116b = gVar.m.d();
        this.m = new b(gVar.l.d());
        this.f5119e = new a();
        this.m.f5128b = z2;
        this.f5119e.f5123b = z;
        this.j = list;
    }

    public int a() {
        return this.f5117c;
    }

    public synchronized boolean b() {
        if (this.h != null) {
            return false;
        }
        if ((this.m.f5128b || this.m.f5127a) && (this.f5119e.f5123b || this.f5119e.f5122a)) {
            if (this.l) {
                return false;
            }
        }
        return true;
    }

    public boolean c() {
        return this.f5118d.f5059b == ((this.f5117c & 1) == 1);
    }

    public synchronized List<com.bytedance.sdk.a.b.a.e.c> d() throws IOException {
        List<com.bytedance.sdk.a.b.a.e.c> list;
        if (!c()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f5120f.a();
        while (this.k == null && this.h == null) {
            try {
                l();
            } catch (Throwable th) {
                this.f5120f.h();
                throw th;
            }
        }
        this.f5120f.h();
        list = this.k;
        if (list == null) {
            throw new o(this.h);
        }
        this.k = null;
        return list;
    }

    public t e() {
        return this.f5120f;
    }

    public t f() {
        return this.g;
    }

    public s g() {
        return this.m;
    }

    public r h() {
        synchronized (this) {
            if (!this.l && !c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f5119e;
    }

    void i() {
        boolean zB;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.f5128b = true;
            zB = b();
            notifyAll();
        }
        if (zB) {
            return;
        }
        this.f5118d.b(this.f5117c);
    }

    void j() throws IOException {
        boolean z;
        boolean zB;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.m.f5128b && this.m.f5127a && (this.f5119e.f5123b || this.f5119e.f5122a);
            zB = b();
        }
        if (z) {
            a(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else {
            if (zB) {
                return;
            }
            this.f5118d.b(this.f5117c);
        }
    }

    void k() throws IOException {
        a aVar = this.f5119e;
        if (aVar.f5122a) {
            throw new IOException("stream closed");
        }
        if (aVar.f5123b) {
            throw new IOException("stream finished");
        }
        com.bytedance.sdk.a.b.a.e.b bVar = this.h;
        if (bVar != null) {
            throw new o(bVar);
        }
    }

    void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public void a(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (d(bVar)) {
            this.f5118d.b(this.f5117c, bVar);
        }
    }

    synchronized void c(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.h == null) {
            this.h = bVar;
            notifyAll();
        }
    }

    void a(List<com.bytedance.sdk.a.b.a.e.c> list) {
        boolean zB;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zB = true;
            this.l = true;
            if (this.k == null) {
                this.k = list;
                zB = b();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.k = arrayList;
            }
        }
        if (zB) {
            return;
        }
        this.f5118d.b(this.f5117c);
    }

    public void b(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (d(bVar)) {
            this.f5118d.a(this.f5117c, bVar);
        }
    }

    private boolean d(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if (this.m.f5128b && this.f5119e.f5123b) {
                return false;
            }
            this.h = bVar;
            notifyAll();
            this.f5118d.b(this.f5117c);
            return true;
        }
    }

    /* JADX INFO: compiled from: Http2Stream.java */
    final class a implements r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f5121c = !i.class.desiredAssertionStatus();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5123b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f5125e = new com.bytedance.sdk.a.a.c();

        a() {
        }

        private void a(boolean z) throws IOException {
            long jMin;
            synchronized (i.this) {
                i.this.g.a();
                while (i.this.f5116b <= 0 && !this.f5123b && !this.f5122a && i.this.h == null) {
                    try {
                        i.this.l();
                    } finally {
                    }
                }
                i.this.g.h();
                i.this.k();
                jMin = Math.min(i.this.f5116b, this.f5125e.b());
                i.this.f5116b -= jMin;
            }
            i.this.g.a();
            try {
                i.this.f5118d.a(i.this.f5117c, z && jMin == this.f5125e.b(), this.f5125e, jMin);
            } finally {
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (!f5121c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f5125e.a_(cVar, j);
            while (this.f5125e.b() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f5121c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.f5122a) {
                    return;
                }
                if (!i.this.f5119e.f5123b) {
                    if (this.f5125e.b() > 0) {
                        while (this.f5125e.b() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f5118d.a(iVar.f5117c, true, (com.bytedance.sdk.a.a.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f5122a = true;
                }
                i.this.f5118d.b();
                i.this.j();
            }
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (!f5121c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.k();
            }
            while (this.f5125e.b() > 0) {
                a(false);
                i.this.f5118d.b();
            }
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return i.this.g;
        }
    }

    void a(com.bytedance.sdk.a.a.e eVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(eVar, i2);
    }

    /* JADX INFO: compiled from: Http2Stream.java */
    private final class b implements s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f5126c = !i.class.desiredAssertionStatus();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5128b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f5130e = new com.bytedance.sdk.a.a.c();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.bytedance.sdk.a.a.c f5131f = new com.bytedance.sdk.a.a.c();
        private final long g;

        b(long j) {
            this.g = j;
        }

        private void b() throws IOException {
            i.this.f5120f.a();
            while (this.f5131f.b() == 0 && !this.f5128b && !this.f5127a && i.this.h == null) {
                try {
                    i.this.l();
                } finally {
                    i.this.f5120f.h();
                }
            }
        }

        private void c() throws IOException {
            if (this.f5127a) {
                throw new IOException("stream closed");
            }
            com.bytedance.sdk.a.b.a.e.b bVar = i.this.h;
            if (bVar != null) {
                throw new o(bVar);
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            synchronized (i.this) {
                b();
                c();
                if (this.f5131f.b() == 0) {
                    return -1L;
                }
                long jA = this.f5131f.a(cVar, Math.min(j, this.f5131f.b()));
                i.this.f5115a += jA;
                if (i.this.f5115a >= i.this.f5118d.l.d() / 2) {
                    i.this.f5118d.a(i.this.f5117c, i.this.f5115a);
                    i.this.f5115a = 0L;
                }
                synchronized (i.this.f5118d) {
                    i.this.f5118d.j += jA;
                    if (i.this.f5118d.j >= i.this.f5118d.l.d() / 2) {
                        i.this.f5118d.a(0, i.this.f5118d.j);
                        i.this.f5118d.j = 0L;
                    }
                }
                return jA;
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f5127a = true;
                this.f5131f.r();
                i.this.notifyAll();
            }
            i.this.j();
        }

        void a(com.bytedance.sdk.a.a.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!f5126c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (i.this) {
                    z = this.f5128b;
                    z2 = true;
                    z3 = this.f5131f.b() + j > this.g;
                }
                if (z3) {
                    eVar.h(j);
                    i.this.b(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.h(j);
                    return;
                }
                long jA = eVar.a(this.f5130e, j);
                if (jA != -1) {
                    j -= jA;
                    synchronized (i.this) {
                        if (this.f5131f.b() != 0) {
                            z2 = false;
                        }
                        this.f5131f.a(this.f5130e);
                        if (z2) {
                            i.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return i.this.f5120f;
        }
    }

    void a(long j) {
        this.f5116b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
