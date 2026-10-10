package com.bytedance.sdk.openadsdk.h;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.b;
import com.bytedance.sdk.openadsdk.h.h;
import com.bytedance.sdk.openadsdk.h.i;
import com.bytedance.sdk.openadsdk.h.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: ProxyTask.java */
/* JADX INFO: loaded from: classes.dex */
class g extends com.bytedance.sdk.openadsdk.h.a {
    private final Socket m;
    private final c n;
    private final ExecutorService o;
    private final d p;
    private volatile com.bytedance.sdk.openadsdk.h.b q;
    private volatile boolean r;

    /* JADX INFO: compiled from: ProxyTask.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OutputStream f6939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6941c;

        b(OutputStream outputStream, int i) {
            this.f6939a = outputStream;
            this.f6940b = i;
        }

        boolean a() {
            return this.f6941c;
        }

        void b(byte[] bArr, int i, int i2) throws com.bytedance.sdk.openadsdk.h.c.d {
            try {
                this.f6939a.write(bArr, i, i2);
                this.f6940b += i2;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.h.c.d(e2);
            }
        }

        void a(byte[] bArr, int i, int i2) throws com.bytedance.sdk.openadsdk.h.c.d {
            if (this.f6941c) {
                return;
            }
            try {
                this.f6939a.write(bArr, i, i2);
                this.f6941c = true;
            } catch (IOException e2) {
                throw new com.bytedance.sdk.openadsdk.h.c.d(e2);
            }
        }

        int b() {
            return this.f6940b;
        }
    }

    /* JADX INFO: compiled from: ProxyTask.java */
    public interface c {
        void a(g gVar);

        void b(g gVar);
    }

    g(a aVar) {
        super(aVar.f6934a, aVar.f6935b);
        this.r = true;
        this.o = aVar.f6936c;
        this.m = aVar.f6937d;
        this.n = aVar.f6938e;
        this.p = d.c();
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
    }

    private void b(b bVar, l.a aVar) throws IOException, com.bytedance.sdk.openadsdk.h.c.d, VAdError {
        byte[] bArrA = a(this.f6819b.a(this.h, this.i.f6957c.f6958a), bVar, aVar);
        if (bArrA == null) {
            return;
        }
        bVar.a(bArrA, 0, bArrA.length);
    }

    private void c(b bVar, l.a aVar) throws Throwable {
        if (this.r) {
            File fileC = this.f6818a.c(this.h);
            long length = fileC.length();
            com.bytedance.sdk.openadsdk.h.b.a aVarA = this.f6819b.a(this.h, this.i.f6957c.f6958a);
            int iB = bVar.b();
            long j = length - ((long) iB);
            int i = (int) j;
            int i2 = aVarA == null ? -1 : aVarA.f6852c;
            if (length > bVar.b()) {
                if (e.f6890c) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j);
                }
                a(true, i, i2, (int) length, iB);
                a(aVarA, fileC, bVar, aVar);
                return;
            }
            a(false, i, i2, (int) length, iB);
        } else {
            a(false, 0, 0, 0, bVar.b());
        }
        d(bVar, aVar);
    }

    private void d(b bVar, l.a aVar) throws Throwable {
        String strA;
        h hVar;
        i();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iB = bVar.b();
        com.bytedance.sdk.openadsdk.h.e.a aVarA = a(aVar, iB, this.i.f6957c.f6962e, "GET");
        if (aVarA == null) {
            return;
        }
        h hVar2 = null;
        int i = 0;
        try {
            strA = com.bytedance.sdk.openadsdk.h.g.d.a(aVarA, false, true);
        } catch (Throwable th) {
            th = th;
        }
        if (strA != null) {
            throw new com.bytedance.sdk.openadsdk.h.c.c(strA + ", rawKey: " + this.g + ", url: " + aVar);
        }
        com.bytedance.sdk.openadsdk.h.b.a aVarA2 = this.f6819b.a(this.h, f());
        int iA = com.bytedance.sdk.openadsdk.h.g.d.a(aVarA);
        if (aVarA2 != null && aVarA2.f6852c != iA) {
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + aVarA2.f6852c + ", " + iA + ", key: " + this.h);
            }
            throw new com.bytedance.sdk.openadsdk.h.c.b("Content-Length not match, old length: " + aVarA2.f6852c + ", new length: " + iA + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + aVarA2.f6854e);
        }
        if (!bVar.a()) {
            String strA2 = com.bytedance.sdk.openadsdk.h.g.d.a(aVarA, iB);
            e();
            byte[] bytes = strA2.getBytes(com.bytedance.sdk.openadsdk.h.g.d.f6950a);
            bVar.a(bytes, 0, bytes.length);
        }
        e();
        File fileD = this.f6818a.d(this.h);
        if (!this.r || fileD == null || fileD.length() < bVar.b()) {
            if (e.f6890c) {
                Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + fileD.length() + ", from: " + bVar.b());
            }
            hVar = null;
        } else {
            com.bytedance.sdk.openadsdk.h.g.d.a(aVarA, this.f6819b, this.h, this.i.f6957c.f6958a);
            try {
                hVar = new h(fileD, "rwd");
            } catch (h.a e2) {
                e = e2;
            }
            try {
                try {
                    hVar.a(bVar.b());
                } catch (h.a e3) {
                    e = e3;
                    e.printStackTrace();
                    hVar = null;
                }
                if (e.f6890c) {
                    Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + fileD.length() + ", from: " + bVar.b());
                }
            } catch (Throwable th2) {
                th = th2;
                hVar2 = hVar;
            }
        }
        com.bytedance.sdk.openadsdk.h.b.a aVarA3 = this.f6819b.a(this.h, f());
        int i2 = aVarA3 == null ? 0 : aVarA3.f6852c;
        byte[] bArr = new byte[8192];
        InputStream inputStreamD = aVarA.d();
        h hVar3 = hVar;
        int i3 = 0;
        while (true) {
            try {
                int i4 = inputStreamD.read(bArr);
                if (i4 < 0) {
                    break;
                }
                e();
                if (i4 > 0) {
                    bVar.b(bArr, 0, i4);
                    i3 += i4;
                    if (hVar3 != null) {
                        try {
                            hVar3.a(bArr, 0, i4);
                        } catch (Throwable th3) {
                            hVar3.a();
                            try {
                                if (e.f6890c) {
                                    Log.e("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th3));
                                }
                                hVar3 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                i = i3;
                            }
                        }
                    }
                    a(i2, bVar.b());
                }
                e();
            } catch (Throwable th5) {
                th = th5;
                i = i3;
                hVar2 = hVar3;
            }
            th = th5;
            i = i3;
            hVar2 = hVar3;
            com.bytedance.sdk.openadsdk.h.g.d.a(aVarA.d());
            if (hVar2 != null) {
                hVar2.a();
            }
            this.f6820c.addAndGet(i);
            this.f6821d.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
            throw th;
        }
        if (e.f6890c) {
            Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
        }
        c();
        com.bytedance.sdk.openadsdk.h.g.d.a(aVarA.d());
        if (hVar3 != null) {
            hVar3.a();
        }
        this.f6820c.addAndGet(i3);
        this.f6821d.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
    }

    private b h() {
        try {
            this.i = i.a(this.m.getInputStream());
            OutputStream outputStream = this.m.getOutputStream();
            com.bytedance.sdk.openadsdk.h.a.a aVar = this.i.f6957c.f6958a == 1 ? e.f6888a : e.f6889b;
            if (aVar == null) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.f6818a = aVar;
            this.g = this.i.f6957c.f6959b;
            this.h = this.i.f6957c.f6960c;
            this.j = new l(this.i.f6957c.g);
            this.f6823f = this.i.f6956b;
            if (e.f6890c) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.i.toString());
            }
            return new b(outputStream, this.i.f6957c.f6961d);
        } catch (i.d e2) {
            com.bytedance.sdk.openadsdk.h.g.d.a(this.m);
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.f6818a == null ? null : Boolean.valueOf(g()), this.g, e2);
            return null;
        } catch (IOException e3) {
            com.bytedance.sdk.openadsdk.h.g.d.a(this.m);
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
            a(this.f6818a == null ? null : Boolean.valueOf(g()), this.g, e3);
            return null;
        }
    }

    private void i() {
        com.bytedance.sdk.openadsdk.h.b bVar = this.q;
        this.q = null;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.openadsdk.h.b.a aVarA;
        b bVarH = h();
        if (bVarH == null) {
            return;
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(this);
        }
        this.f6818a.a(this.h);
        if (e.h != 0 && ((aVarA = this.f6819b.a(this.h, this.i.f6957c.f6958a)) == null || this.f6818a.c(this.h).length() < aVarA.f6852c)) {
            this.p.a(g(), this.h);
        }
        try {
            a(bVarH);
        } catch (VAdError e2) {
            e2.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.h.c.a e3) {
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
        } catch (Throwable th) {
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.f6818a.b(this.h);
        this.p.a(g(), null);
        a();
        com.bytedance.sdk.openadsdk.h.g.d.a(this.m);
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }

    /* JADX INFO: compiled from: ProxyTask.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.h.a.a f6934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.h.b.c f6935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ExecutorService f6936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Socket f6937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f6938e;

        a() {
        }

        a a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.f6935b = cVar;
            return this;
        }

        a a(ExecutorService executorService) {
            if (executorService != null) {
                this.f6936c = executorService;
                return this;
            }
            throw new IllegalArgumentException("executor == null");
        }

        a a(Socket socket) {
            if (socket != null) {
                this.f6937d = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        a a(c cVar) {
            this.f6938e = cVar;
            return this;
        }

        g a() {
            if (this.f6935b != null && this.f6936c != null && this.f6937d != null) {
                return new g(this);
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean a(b bVar) throws Throwable {
        while (this.j.a()) {
            e();
            l.a aVarB = this.j.b();
            try {
                a(bVar, aVarB);
                return true;
            } catch (com.bytedance.sdk.adnet.err.a e2) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
            } catch (com.bytedance.sdk.openadsdk.h.c.b e3) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.h.c.c e4) {
                aVarB.a();
                a(Boolean.valueOf(g()), this.g, e4);
            } catch (com.bytedance.sdk.openadsdk.h.c.d e5) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return true;
            } catch (h.a e6) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                }
                this.r = false;
                a(Boolean.valueOf(g()), this.g, e6);
            } catch (IOException e7) {
                if (e7 instanceof SocketTimeoutException) {
                    aVarB.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e7);
                } else if (e.f6890c) {
                    if ("Canceled".equalsIgnoreCase(e7.getMessage())) {
                        Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                    }
                }
            } catch (Exception e8) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e8));
                }
            }
        }
        return false;
    }

    private void a(b bVar, l.a aVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.i.f6955a.f6966a)) {
            b(bVar, aVar);
        } else {
            c(bVar, aVar);
        }
    }

    private byte[] a(com.bytedance.sdk.openadsdk.h.b.a aVar, b bVar, l.a aVar2) throws IOException, VAdError {
        if (aVar != null) {
            if (e.f6890c) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bytedance.sdk.openadsdk.h.g.d.a(aVar, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.h.g.d.f6950a);
        }
        com.bytedance.sdk.openadsdk.h.e.a aVarA = a(aVar2, 0, -1, "HEAD");
        if (aVarA == null) {
            return null;
        }
        try {
            String strA = com.bytedance.sdk.openadsdk.h.g.d.a(aVarA, false, false);
            if (strA == null) {
                com.bytedance.sdk.openadsdk.h.b.a aVarA2 = com.bytedance.sdk.openadsdk.h.g.d.a(aVarA, this.f6819b, this.h, this.i.f6957c.f6958a);
                if (e.f6890c) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                return com.bytedance.sdk.openadsdk.h.g.d.a(aVarA2, bVar.b()).getBytes(com.bytedance.sdk.openadsdk.h.g.d.f6950a);
            }
            throw new com.bytedance.sdk.openadsdk.h.c.c(strA + ", rawKey: " + this.g + ", url: " + aVar2);
        } finally {
            com.bytedance.sdk.openadsdk.h.g.d.a(aVarA.d());
        }
    }

    private void a(com.bytedance.sdk.openadsdk.h.b.a aVar, File file, b bVar, l.a aVar2) throws Throwable {
        Future<?> futureSubmit;
        h hVar;
        com.bytedance.sdk.openadsdk.h.b bVar2;
        if (!bVar.a()) {
            byte[] bArrA = a(aVar, bVar, aVar2);
            e();
            if (bArrA == null) {
                return;
            } else {
                bVar.a(bArrA, 0, bArrA.length);
            }
        }
        if (aVar == null && (aVar = this.f6819b.a(this.h, this.i.f6957c.f6958a)) == null) {
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((com.bytedance.sdk.openadsdk.h.b.a) null, bVar, aVar2);
            aVar = this.f6819b.a(this.h, this.i.f6957c.f6958a);
            if (aVar == null) {
                throw new com.bytedance.sdk.openadsdk.h.c.c("failed to get header, rawKey: " + this.g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.f6852c || !((bVar2 = this.q) == null || bVar2.b() || bVar2.d())) {
            futureSubmit = null;
        } else {
            com.bytedance.sdk.openadsdk.h.b bVarA = new b.a().a(this.f6818a).a(this.f6819b).a(this.g).b(this.h).a(new l(aVar2.f6979a)).a(this.f6823f).a(this.i).a(new b.InterfaceC0089b() { // from class: com.bytedance.sdk.openadsdk.h.g.1
                @Override // com.bytedance.sdk.openadsdk.h.b.InterfaceC0089b
                public void a(com.bytedance.sdk.openadsdk.h.b bVar3) {
                    g.this.f6820c.addAndGet(bVar3.f6820c.get());
                    g.this.f6821d.addAndGet(bVar3.f6821d.get());
                    synchronized (bVar3.m) {
                        bVar3.m.notifyAll();
                    }
                    if (bVar3.d()) {
                        g.this.p.a(g.this.g(), null);
                    }
                }
            }).a();
            this.q = bVarA;
            futureSubmit = this.o.submit(bVarA);
            if (e.f6890c) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            hVar = new h(file, "r");
            try {
                hVar.a(bVar.b());
                int iMin = this.i.f6957c.f6962e > 0 ? Math.min(aVar.f6852c, this.i.f6957c.f6962e) : aVar.f6852c;
                while (bVar.b() < iMin) {
                    e();
                    int iA = hVar.a(bArr);
                    if (iA <= 0) {
                        com.bytedance.sdk.openadsdk.h.b bVar3 = this.q;
                        if (bVar3 != null) {
                            com.bytedance.sdk.openadsdk.h.c.b bVarI = bVar3.i();
                            if (bVarI == null) {
                                h.a aVarH = bVar3.h();
                                if (aVarH != null) {
                                    throw aVarH;
                                }
                            } else {
                                throw bVarI;
                            }
                        }
                        if (bVar3 != null && !bVar3.b() && !bVar3.d()) {
                            e();
                            synchronized (bVar3.m) {
                                try {
                                    bVar3.m.wait(1000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (e.f6890c) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bytedance.sdk.openadsdk.h.c.c("illegal state download task has finished, rawKey: " + this.g + ", url: " + aVar2);
                    }
                    bVar.b(bArr, 0, iA);
                    e();
                }
                if (e.f6890c) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + bVar.b() + ", " + iMin);
                }
                c();
                hVar.a();
                if (futureSubmit != null) {
                    try {
                        futureSubmit.get();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                    hVar.a();
                }
                if (futureSubmit != null) {
                    try {
                        futureSubmit.get();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            hVar = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a
    public void a() {
        super.a();
        i();
    }
}
