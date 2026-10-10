package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.C2936a;
import okhttp3.C2947l;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.K;
import okhttp3.internal.connection.f;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.z;

/* JADX INFO: compiled from: StreamAllocation.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2936a f23226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f.a f23227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private K f23228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2947l f23229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Call f23230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EventListener f23231f;
    private final Object g;
    private final f h;
    private int i;
    private d j;
    private boolean k;
    private boolean l;
    private boolean m;
    private HttpCodec n;

    /* JADX INFO: compiled from: StreamAllocation.java */
    public static final class a extends WeakReference<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f23232a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f23232a = obj;
        }
    }

    public g(C2947l c2947l, C2936a c2936a, Call call, EventListener eventListener, Object obj) {
        this.f23229d = c2947l;
        this.f23226a = c2936a;
        this.f23230e = call;
        this.f23231f = eventListener;
        this.h = new f(c2936a, i(), call, eventListener);
        this.g = obj;
    }

    private Socket h() {
        d dVar = this.j;
        if (dVar == null || !dVar.k) {
            return null;
        }
        return a(false, false, true);
    }

    private e i() {
        return okhttp3.a.a.f23061a.a(this.f23229d);
    }

    public HttpCodec a(z zVar, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec httpCodecA = a(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), zVar.s(), zVar.y(), z).a(zVar, chain, this);
            synchronized (this.f23229d) {
                this.n = httpCodecA;
            }
            return httpCodecA;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    public HttpCodec b() {
        HttpCodec httpCodec;
        synchronized (this.f23229d) {
            httpCodec = this.n;
        }
        return httpCodec;
    }

    public synchronized d c() {
        return this.j;
    }

    public boolean d() {
        f.a aVar;
        return this.f23228c != null || ((aVar = this.f23227b) != null && aVar.b()) || this.h.a();
    }

    public void e() {
        d dVar;
        Socket socketA;
        synchronized (this.f23229d) {
            dVar = this.j;
            socketA = a(true, false, false);
            if (this.j != null) {
                dVar = null;
            }
        }
        okhttp3.a.e.a(socketA);
        if (dVar != null) {
            this.f23231f.b(this.f23230e, dVar);
        }
    }

    public void f() {
        d dVar;
        Socket socketA;
        synchronized (this.f23229d) {
            dVar = this.j;
            socketA = a(false, true, false);
            if (this.j != null) {
                dVar = null;
            }
        }
        okhttp3.a.e.a(socketA);
        if (dVar != null) {
            okhttp3.a.a.f23061a.a(this.f23230e, (IOException) null);
            this.f23231f.b(this.f23230e, dVar);
            this.f23231f.a(this.f23230e);
        }
    }

    public K g() {
        return this.f23228c;
    }

    public String toString() {
        d dVarC = c();
        return dVarC != null ? dVarC.toString() : this.f23226a.toString();
    }

    private void b(d dVar) {
        int size = dVar.n.size();
        for (int i = 0; i < size; i++) {
            if (dVar.n.get(i).get() == this) {
                dVar.n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private d a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            d dVarA = a(i, i2, i3, i4, z);
            synchronized (this.f23229d) {
                if (dVarA.l == 0) {
                    return dVarA;
                }
                if (dVarA.a(z2)) {
                    return dVarA;
                }
                e();
            }
        }
    }

    private d a(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        Socket socketH;
        Socket socketA;
        d dVar;
        d dVar2;
        d dVar3;
        K kC;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.f23229d) {
            if (!this.l) {
                if (this.n == null) {
                    if (!this.m) {
                        d dVar4 = this.j;
                        socketH = h();
                        socketA = null;
                        if (this.j != null) {
                            dVar2 = this.j;
                            dVar = null;
                        } else {
                            dVar = dVar4;
                            dVar2 = null;
                        }
                        if (!this.k) {
                            dVar = null;
                        }
                        if (dVar2 == null) {
                            okhttp3.a.a.f23061a.a(this.f23229d, this.f23226a, this, null);
                            if (this.j != null) {
                                dVar3 = this.j;
                                kC = null;
                                z2 = true;
                            } else {
                                kC = this.f23228c;
                                dVar3 = dVar2;
                            }
                        } else {
                            dVar3 = dVar2;
                            kC = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        okhttp3.a.e.a(socketH);
        if (dVar != null) {
            this.f23231f.b(this.f23230e, dVar);
        }
        if (z2) {
            this.f23231f.a(this.f23230e, dVar3);
        }
        if (dVar3 != null) {
            return dVar3;
        }
        if (kC != null || ((aVar = this.f23227b) != null && aVar.b())) {
            z3 = false;
        } else {
            this.f23227b = this.h.b();
            z3 = true;
        }
        synchronized (this.f23229d) {
            if (this.m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<K> listA = this.f23227b.a();
                int size = listA.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    K k = listA.get(i5);
                    okhttp3.a.a.f23061a.a(this.f23229d, this.f23226a, this, k);
                    if (this.j != null) {
                        dVar3 = this.j;
                        this.f23228c = k;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (kC == null) {
                    kC = this.f23227b.c();
                }
                this.f23228c = kC;
                this.i = 0;
                dVar3 = new d(this.f23229d, kC);
                a(dVar3, false);
            }
        }
        if (z2) {
            this.f23231f.a(this.f23230e, dVar3);
            return dVar3;
        }
        dVar3.a(i, i2, i3, i4, z, this.f23230e, this.f23231f);
        i().a(dVar3.route());
        synchronized (this.f23229d) {
            this.k = true;
            okhttp3.a.a.f23061a.b(this.f23229d, dVar3);
            if (dVar3.b()) {
                socketA = okhttp3.a.a.f23061a.a(this.f23229d, this.f23226a, this);
                dVar3 = this.j;
            }
        }
        okhttp3.a.e.a(socketA);
        this.f23231f.a(this.f23230e, dVar3);
        return dVar3;
    }

    public void a(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        d dVar;
        Socket socketA;
        boolean z2;
        this.f23231f.b(this.f23230e, j);
        synchronized (this.f23229d) {
            if (httpCodec != null) {
                if (httpCodec == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    dVar = this.j;
                    socketA = a(z, false, true);
                    if (this.j != null) {
                        dVar = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + httpCodec);
        }
        okhttp3.a.e.a(socketA);
        if (dVar != null) {
            this.f23231f.b(this.f23230e, dVar);
        }
        if (iOException != null) {
            this.f23231f.a(this.f23230e, okhttp3.a.a.f23061a.a(this.f23230e, iOException));
        } else if (z2) {
            okhttp3.a.a.f23061a.a(this.f23230e, (IOException) null);
            this.f23231f.a(this.f23230e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket a(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            r0 = 0
            if (r4 == 0) goto L5
            r1.n = r0
        L5:
            r4 = 1
            if (r3 == 0) goto La
            r1.l = r4
        La:
            okhttp3.internal.connection.d r3 = r1.j
            if (r3 == 0) goto L4e
            if (r2 == 0) goto L12
            r3.k = r4
        L12:
            okhttp3.internal.http.HttpCodec r2 = r1.n
            if (r2 != 0) goto L4e
            boolean r2 = r1.l
            if (r2 != 0) goto L20
            okhttp3.internal.connection.d r2 = r1.j
            boolean r2 = r2.k
            if (r2 == 0) goto L4e
        L20:
            okhttp3.internal.connection.d r2 = r1.j
            r1.b(r2)
            okhttp3.internal.connection.d r2 = r1.j
            java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.g>> r2 = r2.n
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L4a
            okhttp3.internal.connection.d r2 = r1.j
            long r3 = java.lang.System.nanoTime()
            r2.o = r3
            okhttp3.a.a r2 = okhttp3.a.a.f23061a
            okhttp3.l r3 = r1.f23229d
            okhttp3.internal.connection.d r4 = r1.j
            boolean r2 = r2.a(r3, r4)
            if (r2 == 0) goto L4a
            okhttp3.internal.connection.d r2 = r1.j
            java.net.Socket r2 = r2.socket()
            goto L4b
        L4a:
            r2 = r0
        L4b:
            r1.j = r0
            goto L4f
        L4e:
            r2 = r0
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.g.a(boolean, boolean, boolean):java.net.Socket");
    }

    public void a() {
        HttpCodec httpCodec;
        d dVar;
        synchronized (this.f23229d) {
            this.m = true;
            httpCodec = this.n;
            dVar = this.j;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (dVar != null) {
            dVar.a();
        }
    }

    public void a(IOException iOException) {
        boolean z;
        d dVar;
        Socket socketA;
        synchronized (this.f23229d) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.i++;
                    if (this.i > 1) {
                        this.f23228c = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.f23228c = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.j != null && (!this.j.b() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.j.l == 0) {
                        if (this.f23228c != null && iOException != null) {
                            this.h.a(this.f23228c, iOException);
                        }
                        this.f23228c = null;
                    }
                    z = true;
                }
                z = false;
            }
            dVar = this.j;
            socketA = a(z, false, true);
            if (this.j != null || !this.k) {
                dVar = null;
            }
        }
        okhttp3.a.e.a(socketA);
        if (dVar != null) {
            this.f23231f.b(this.f23230e, dVar);
        }
    }

    public void a(d dVar, boolean z) {
        if (this.j == null) {
            this.j = dVar;
            this.k = z;
            dVar.n.add(new a(this, this.g));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket a(d dVar) {
        if (this.n == null && this.j.n.size() == 1) {
            Reference<g> reference = this.j.n.get(0);
            Socket socketA = a(true, false, false);
            this.j = dVar;
            dVar.n.add(reference);
            return socketA;
        }
        throw new IllegalStateException();
    }
}
