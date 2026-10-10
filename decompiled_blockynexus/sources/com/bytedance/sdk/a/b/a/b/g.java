package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.b.f;
import com.bytedance.sdk.a.b.a.e.o;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: compiled from: StreamAllocation.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f4957d = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.sdk.a.b.a f4958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.sdk.a.b.e f4959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f4960c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f.a f4961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ac f4962f;
    private final j g;
    private final Object h;
    private final f i;
    private int j;
    private c k;
    private boolean l;
    private boolean m;
    private boolean n;
    private com.bytedance.sdk.a.b.a.c.c o;

    /* JADX INFO: compiled from: StreamAllocation.java */
    public static final class a extends WeakReference<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4963a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f4963a = obj;
        }
    }

    public g(j jVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.e eVar, p pVar, Object obj) {
        this.g = jVar;
        this.f4958a = aVar;
        this.f4959b = eVar;
        this.f4960c = pVar;
        this.i = new f(aVar, g(), eVar, pVar);
        this.h = obj;
    }

    private Socket f() {
        if (!f4957d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        c cVar = this.k;
        if (cVar == null || !cVar.f4941a) {
            return null;
        }
        return a(false, false, true);
    }

    private d g() {
        return com.bytedance.sdk.a.b.a.a.f4904a.a(this.g);
    }

    public com.bytedance.sdk.a.b.a.c.c a(v vVar, t.a aVar, boolean z) {
        try {
            com.bytedance.sdk.a.b.a.c.c cVarA = a(aVar.b(), aVar.c(), aVar.d(), vVar.r(), z).a(vVar, aVar, this);
            synchronized (this.g) {
                this.o = cVarA;
            }
            return cVarA;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public synchronized c b() {
        return this.k;
    }

    public void c() {
        c cVar;
        Socket socketA;
        synchronized (this.g) {
            cVar = this.k;
            socketA = a(false, true, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socketA);
        if (cVar != null) {
            this.f4960c.b(this.f4959b, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket socketA;
        synchronized (this.g) {
            cVar = this.k;
            socketA = a(true, false, false);
            if (this.k != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socketA);
        if (cVar != null) {
            this.f4960c.b(this.f4959b, cVar);
        }
    }

    public boolean e() {
        f.a aVar;
        return this.f4962f != null || ((aVar = this.f4961e) != null && aVar.a()) || this.i.a();
    }

    public String toString() {
        c cVarB = b();
        return cVarB != null ? cVarB.toString() : this.f4958a.toString();
    }

    private void b(c cVar) {
        int size = cVar.f4944d.size();
        for (int i = 0; i < size; i++) {
            if (cVar.f4944d.get(i).get() == this) {
                cVar.f4944d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private c a(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        while (true) {
            c cVarA = a(i, i2, i3, z);
            synchronized (this.g) {
                if (cVarA.f4942b == 0) {
                    return cVarA;
                }
                if (cVarA.a(z2)) {
                    return cVarA;
                }
                d();
            }
        }
    }

    private c a(int i, int i2, int i3, boolean z) throws Throwable {
        Socket socketF;
        Socket socketA;
        c cVar;
        c cVar2;
        c cVar3;
        ac acVarB;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.g) {
            if (!this.m) {
                if (this.o == null) {
                    if (!this.n) {
                        c cVar4 = this.k;
                        socketF = f();
                        socketA = null;
                        if (this.k != null) {
                            cVar2 = this.k;
                            cVar = null;
                        } else {
                            cVar = cVar4;
                            cVar2 = null;
                        }
                        if (!this.l) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            com.bytedance.sdk.a.b.a.a.f4904a.a(this.g, this.f4958a, this, null);
                            if (this.k != null) {
                                cVar3 = this.k;
                                acVarB = null;
                                z2 = true;
                            } else {
                                acVarB = this.f4962f;
                                cVar3 = cVar2;
                            }
                        } else {
                            cVar3 = cVar2;
                            acVarB = null;
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
        com.bytedance.sdk.a.b.a.c.a(socketF);
        if (cVar != null) {
            this.f4960c.b(this.f4959b, cVar);
        }
        if (z2) {
            this.f4960c.a(this.f4959b, cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        if (acVarB != null || ((aVar = this.f4961e) != null && aVar.a())) {
            z3 = false;
        } else {
            this.f4961e = this.i.b();
            z3 = true;
        }
        synchronized (this.g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ac> listC = this.f4961e.c();
                int size = listC.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    ac acVar = listC.get(i4);
                    com.bytedance.sdk.a.b.a.a.f4904a.a(this.g, this.f4958a, this, acVar);
                    if (this.k != null) {
                        cVar3 = this.k;
                        this.f4962f = acVar;
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (!z2) {
                if (acVarB == null) {
                    acVarB = this.f4961e.b();
                }
                this.f4962f = acVarB;
                this.j = 0;
                cVar3 = new c(this.g, acVarB);
                a(cVar3, false);
            }
        }
        if (z2) {
            this.f4960c.a(this.f4959b, cVar3);
            return cVar3;
        }
        cVar3.a(i, i2, i3, z, this.f4959b, this.f4960c);
        g().b(cVar3.a());
        synchronized (this.g) {
            this.l = true;
            com.bytedance.sdk.a.b.a.a.f4904a.b(this.g, cVar3);
            if (cVar3.d()) {
                socketA = com.bytedance.sdk.a.b.a.a.f4904a.a(this.g, this.f4958a, this);
                cVar3 = this.k;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socketA);
        this.f4960c.a(this.f4959b, cVar3);
        return cVar3;
    }

    public void a(boolean z, com.bytedance.sdk.a.b.a.c.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket socketA;
        boolean z2;
        this.f4960c.b(this.f4959b, j);
        synchronized (this.g) {
            if (cVar != null) {
                if (cVar == this.o) {
                    if (!z) {
                        this.k.f4942b++;
                    }
                    cVar2 = this.k;
                    socketA = a(z, false, true);
                    if (this.k != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(socketA);
        if (cVar2 != null) {
            this.f4960c.b(this.f4959b, cVar2);
        }
        if (iOException != null) {
            this.f4960c.a(this.f4959b, iOException);
        } else if (z2) {
            this.f4960c.g(this.f4959b);
        }
    }

    public com.bytedance.sdk.a.b.a.c.c a() {
        com.bytedance.sdk.a.b.a.c.c cVar;
        synchronized (this.g) {
            cVar = this.o;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.Socket a(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = com.bytedance.sdk.a.b.a.b.g.f4957d
            if (r0 != 0) goto L13
            com.bytedance.sdk.a.b.j r0 = r1.g
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto Ld
            goto L13
        Ld:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L13:
            r0 = 0
            if (r4 == 0) goto L18
            r1.o = r0
        L18:
            r4 = 1
            if (r3 == 0) goto L1d
            r1.m = r4
        L1d:
            com.bytedance.sdk.a.b.a.b.c r3 = r1.k
            if (r3 == 0) goto L61
            if (r2 == 0) goto L25
            r3.f4941a = r4
        L25:
            com.bytedance.sdk.a.b.a.c.c r2 = r1.o
            if (r2 != 0) goto L61
            boolean r2 = r1.m
            if (r2 != 0) goto L33
            com.bytedance.sdk.a.b.a.b.c r2 = r1.k
            boolean r2 = r2.f4941a
            if (r2 == 0) goto L61
        L33:
            com.bytedance.sdk.a.b.a.b.c r2 = r1.k
            r1.b(r2)
            com.bytedance.sdk.a.b.a.b.c r2 = r1.k
            java.util.List<java.lang.ref.Reference<com.bytedance.sdk.a.b.a.b.g>> r2 = r2.f4944d
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5d
            com.bytedance.sdk.a.b.a.b.c r2 = r1.k
            long r3 = java.lang.System.nanoTime()
            r2.f4945e = r3
            com.bytedance.sdk.a.b.a.a r2 = com.bytedance.sdk.a.b.a.a.f4904a
            com.bytedance.sdk.a.b.j r3 = r1.g
            com.bytedance.sdk.a.b.a.b.c r4 = r1.k
            boolean r2 = r2.a(r3, r4)
            if (r2 == 0) goto L5d
            com.bytedance.sdk.a.b.a.b.c r2 = r1.k
            java.net.Socket r2 = r2.b()
            goto L5e
        L5d:
            r2 = r0
        L5e:
            r1.k = r0
            goto L62
        L61:
            r2 = r0
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.b.g.a(boolean, boolean, boolean):java.net.Socket");
    }

    public void a(IOException iOException) {
        boolean z;
        c cVar;
        Socket socketA;
        synchronized (this.g) {
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.f5152a == com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.f5152a != com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM || this.j > 1) {
                    this.f4962f = null;
                    z = true;
                }
                z = false;
            } else {
                if (this.k != null && (!this.k.d() || (iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                    if (this.k.f4942b == 0) {
                        if (this.f4962f != null && iOException != null) {
                            this.i.a(this.f4962f, iOException);
                        }
                        this.f4962f = null;
                    }
                    z = true;
                }
                z = false;
            }
            cVar = this.k;
            socketA = a(z, false, true);
            if (this.k != null || !this.l) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socketA);
        if (cVar != null) {
            this.f4960c.b(this.f4959b, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!f4957d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.k == null) {
            this.k = cVar;
            this.l = z;
            cVar.f4944d.add(new a(this, this.h));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (!f4957d && !Thread.holdsLock(this.g)) {
            throw new AssertionError();
        }
        if (this.o == null && this.k.f4944d.size() == 1) {
            Reference<g> reference = this.k.f4944d.get(0);
            Socket socketA = a(true, false, false);
            this.k = cVar;
            cVar.f4944d.add(reference);
            return socketA;
        }
        throw new IllegalStateException();
    }
}
