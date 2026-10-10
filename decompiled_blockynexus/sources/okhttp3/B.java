package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import okio.AsyncTimeout;
import okio.Timeout;

/* JADX INFO: compiled from: RealCall.java */
/* JADX INFO: loaded from: classes5.dex */
final class B implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z f22999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final okhttp3.internal.http.j f23000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AsyncTimeout f23001c = new A(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EventListener f23002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final C f23003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f23004f;
    private boolean g;

    private B(z zVar, C c2, boolean z) {
        this.f22999a = zVar;
        this.f23003e = c2;
        this.f23004f = z;
        this.f23000b = new okhttp3.internal.http.j(zVar, z);
        this.f23001c.timeout(zVar.c(), TimeUnit.MILLISECONDS);
    }

    private void e() {
        this.f23000b.a(okhttp3.a.b.f.a().a("response.body().close()"));
    }

    String b() {
        return this.f23003e.g().n();
    }

    okhttp3.internal.connection.g c() {
        return this.f23000b.c();
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.f23000b.a();
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.f23004f ? "web socket" : "call");
        sb.append(" to ");
        sb.append(b());
        return sb.toString();
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        e();
        this.f23002d.b(this);
        this.f22999a.i().a(new a(callback));
    }

    @Override // okhttp3.Call
    public H execute() throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        e();
        this.f23001c.enter();
        this.f23002d.b(this);
        try {
            try {
                this.f22999a.i().a(this);
                H hA = a();
                if (hA != null) {
                    return hA;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                IOException iOExceptionA = a(e2);
                this.f23002d.a(this, iOExceptionA);
                throw iOExceptionA;
            }
        } finally {
            this.f22999a.i().b(this);
        }
        this.f22999a.i().b(this);
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.f23000b.b();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.g;
    }

    @Override // okhttp3.Call
    public C request() {
        return this.f23003e;
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.f23001c;
    }

    static B a(z zVar, C c2, boolean z) {
        B b2 = new B(zVar, c2, z);
        b2.f23002d = zVar.k().create(b2);
        return b2;
    }

    @Override // okhttp3.Call
    public B clone() {
        return a(this.f22999a, this.f23003e, this.f23004f);
    }

    IOException a(IOException iOException) {
        if (!this.f23001c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: compiled from: RealCall.java */
    final class a extends okhttp3.a.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callback f23005b;

        a(Callback callback) {
            super("OkHttp %s", B.this.b());
            this.f23005b = callback;
        }

        void a(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    B.this.f23002d.a(B.this, interruptedIOException);
                    this.f23005b.onFailure(B.this, interruptedIOException);
                    B.this.f22999a.i().b(this);
                }
            } catch (Throwable th) {
                B.this.f22999a.i().b(this);
                throw th;
            }
        }

        B b() {
            return B.this;
        }

        String c() {
            return B.this.f23003e.g().g();
        }

        @Override // okhttp3.a.b
        protected void a() {
            IOException e2;
            H hA;
            B.this.f23001c.enter();
            boolean z = true;
            try {
                try {
                    hA = B.this.a();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (B.this.f23000b.b()) {
                        this.f23005b.onFailure(B.this, new IOException("Canceled"));
                    } else {
                        this.f23005b.onResponse(B.this, hA);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    IOException iOExceptionA = B.this.a(e2);
                    if (!z) {
                        B.this.f23002d.a(B.this, iOExceptionA);
                        this.f23005b.onFailure(B.this, iOExceptionA);
                    } else {
                        okhttp3.a.b.f.a().a(4, "Callback failure for " + B.this.d(), iOExceptionA);
                    }
                }
            } finally {
                B.this.f22999a.i().b(this);
            }
        }
    }

    H a() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f22999a.o());
        arrayList.add(this.f23000b);
        arrayList.add(new okhttp3.internal.http.a(this.f22999a.h()));
        arrayList.add(new okhttp3.internal.cache.b(this.f22999a.p()));
        arrayList.add(new okhttp3.internal.connection.a(this.f22999a));
        if (!this.f23004f) {
            arrayList.addAll(this.f22999a.q());
        }
        arrayList.add(new okhttp3.internal.http.b(this.f23004f));
        return new okhttp3.internal.http.g(arrayList, null, null, null, 0, this.f23003e, this, this.f23002d, this.f22999a.e(), this.f22999a.x(), this.f22999a.B()).proceed(this.f23003e);
    }
}
