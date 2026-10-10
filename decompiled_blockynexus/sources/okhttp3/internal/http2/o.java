package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.http2.Header;
import okhttp3.u;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: Http2Stream.java */
/* JADX INFO: loaded from: classes5.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f23348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f23349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final j f23350d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Header.Listener f23352f;
    private boolean g;
    private final b h;
    final a i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f23347a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<u> f23351e = new ArrayDeque();
    final c j = new c();
    final c k = new c();
    ErrorCode l = null;

    /* JADX INFO: compiled from: Http2Stream.java */
    final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Buffer f23353a = new Buffer();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f23354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f23355c;

        a() {
        }

        private void a(boolean z) throws IOException {
            long jMin;
            synchronized (o.this) {
                o.this.k.enter();
                while (o.this.f23348b <= 0 && !this.f23355c && !this.f23354b && o.this.l == null) {
                    try {
                        o.this.k();
                    } finally {
                    }
                }
                o.this.k.exitAndThrowIfTimedOut();
                o.this.b();
                jMin = Math.min(o.this.f23348b, this.f23353a.size());
                o.this.f23348b -= jMin;
            }
            o.this.k.enter();
            try {
                o.this.f23350d.a(o.this.f23349c, z && jMin == this.f23353a.size(), this.f23353a, jMin);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (o.this) {
                if (this.f23354b) {
                    return;
                }
                if (!o.this.i.f23355c) {
                    if (this.f23353a.size() > 0) {
                        while (this.f23353a.size() > 0) {
                            a(true);
                        }
                    } else {
                        o oVar = o.this;
                        oVar.f23350d.a(oVar.f23349c, true, (Buffer) null, 0L);
                    }
                }
                synchronized (o.this) {
                    this.f23354b = true;
                }
                o.this.f23350d.flush();
                o.this.a();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (o.this) {
                o.this.b();
            }
            while (this.f23353a.size() > 0) {
                a(false);
                o.this.f23350d.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return o.this.k;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            this.f23353a.write(buffer, j);
            while (this.f23353a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
        }
    }

    /* JADX INFO: compiled from: Http2Stream.java */
    private final class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Buffer f23357a = new Buffer();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Buffer f23358b = new Buffer();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f23359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f23360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f23361e;

        b(long j) {
            this.f23359c = j;
        }

        private void a(long j) {
            o.this.f23350d.b(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            ArrayList arrayList;
            Header.Listener listener;
            synchronized (o.this) {
                this.f23360d = true;
                size = this.f23358b.size();
                this.f23358b.clear();
                arrayList = null;
                if (o.this.f23351e.isEmpty() || o.this.f23352f == null) {
                    listener = null;
                } else {
                    arrayList = new ArrayList(o.this.f23351e);
                    o.this.f23351e.clear();
                    listener = o.this.f23352f;
                }
                o.this.notifyAll();
            }
            if (size > 0) {
                a(size);
            }
            o.this.a();
            if (listener != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    listener.onHeaders((u) it.next());
                }
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            ErrorCode errorCode;
            long j2;
            u uVar;
            Header.Listener listener;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                synchronized (o.this) {
                    o.this.j.enter();
                    try {
                        errorCode = o.this.l != null ? o.this.l : null;
                        if (this.f23360d) {
                            throw new IOException("stream closed");
                        }
                        if (o.this.f23351e.isEmpty() || o.this.f23352f == null) {
                            if (this.f23358b.size() > 0) {
                                j2 = this.f23358b.read(buffer, Math.min(j, this.f23358b.size()));
                                o.this.f23347a += j2;
                                if (errorCode == null && o.this.f23347a >= o.this.f23350d.o.c() / 2) {
                                    o.this.f23350d.a(o.this.f23349c, o.this.f23347a);
                                    o.this.f23347a = 0L;
                                }
                            } else if (this.f23361e || errorCode != null) {
                                j2 = -1;
                            } else {
                                o.this.k();
                                o.this.j.exitAndThrowIfTimedOut();
                            }
                            uVar = null;
                            listener = null;
                        } else {
                            uVar = (u) o.this.f23351e.removeFirst();
                            listener = o.this.f23352f;
                            j2 = -1;
                        }
                        if (uVar == null || listener == null) {
                            break;
                        }
                        listener.onHeaders(uVar);
                    } finally {
                    }
                }
            }
            if (j2 != -1) {
                a(j2);
                return j2;
            }
            if (errorCode == null) {
                return -1L;
            }
            throw new StreamResetException(errorCode);
        }

        @Override // okio.Source
        public Timeout timeout() {
            return o.this.j;
        }

        void a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (o.this) {
                    z = this.f23361e;
                    z2 = true;
                    z3 = this.f23358b.size() + j > this.f23359c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    o.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long j2 = bufferedSource.read(this.f23357a, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (o.this) {
                    if (this.f23358b.size() != 0) {
                        z2 = false;
                    }
                    this.f23358b.writeAll(this.f23357a);
                    if (z2) {
                        o.this.notifyAll();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: Http2Stream.java */
    class c extends AsyncTimeout {
        c() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            o.this.b(ErrorCode.CANCEL);
        }
    }

    o(int i, j jVar, boolean z, boolean z2, u uVar) {
        if (jVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f23349c = i;
        this.f23350d = jVar;
        this.f23348b = jVar.p.c();
        this.h = new b(jVar.o.c());
        this.i = new a();
        this.h.f23361e = z2;
        this.i.f23355c = z;
        if (uVar != null) {
            this.f23351e.add(uVar);
        }
        if (f() && uVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!f() && uVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public int c() {
        return this.f23349c;
    }

    public Sink d() {
        synchronized (this) {
            if (!this.g && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.i;
    }

    public Source e() {
        return this.h;
    }

    public boolean f() {
        return this.f23350d.f23324b == ((this.f23349c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.l != null) {
            return false;
        }
        if ((this.h.f23361e || this.h.f23360d) && (this.i.f23355c || this.i.f23354b)) {
            if (this.g) {
                return false;
            }
        }
        return true;
    }

    public Timeout h() {
        return this.j;
    }

    void i() {
        boolean zG;
        synchronized (this) {
            this.h.f23361e = true;
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.f23350d.c(this.f23349c);
    }

    public synchronized u j() throws IOException {
        this.j.enter();
        while (this.f23351e.isEmpty() && this.l == null) {
            try {
                k();
            } catch (Throwable th) {
                this.j.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.j.exitAndThrowIfTimedOut();
        if (this.f23351e.isEmpty()) {
            throw new StreamResetException(this.l);
        }
        return this.f23351e.removeFirst();
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Timeout l() {
        return this.k;
    }

    public void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.f23350d.b(this.f23349c, errorCode);
        }
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.f23350d.c(this.f23349c, errorCode);
        }
    }

    synchronized void c(ErrorCode errorCode) {
        if (this.l == null) {
            this.l = errorCode;
            notifyAll();
        }
    }

    void a(List<Header> list) {
        boolean zG;
        synchronized (this) {
            this.g = true;
            this.f23351e.add(okhttp3.a.e.b(list));
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.f23350d.c(this.f23349c);
    }

    void b() throws IOException {
        a aVar = this.i;
        if (!aVar.f23354b) {
            if (!aVar.f23355c) {
                ErrorCode errorCode = this.l;
                if (errorCode != null) {
                    throw new StreamResetException(errorCode);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    private boolean d(ErrorCode errorCode) {
        synchronized (this) {
            if (this.l != null) {
                return false;
            }
            if (this.h.f23361e && this.i.f23355c) {
                return false;
            }
            this.l = errorCode;
            notifyAll();
            this.f23350d.c(this.f23349c);
            return true;
        }
    }

    void a(BufferedSource bufferedSource, int i) throws IOException {
        this.h.a(bufferedSource, i);
    }

    void a() throws IOException {
        boolean z;
        boolean zG;
        synchronized (this) {
            z = !this.h.f23361e && this.h.f23360d && (this.i.f23355c || this.i.f23354b);
            zG = g();
        }
        if (z) {
            a(ErrorCode.CANCEL);
        } else {
            if (zG) {
                return;
            }
            this.f23350d.c(this.f23349c);
        }
    }

    void a(long j) {
        this.f23348b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
