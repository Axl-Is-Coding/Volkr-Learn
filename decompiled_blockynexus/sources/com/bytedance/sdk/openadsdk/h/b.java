package com.bytedance.sdk.openadsdk.h;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.h;
import com.bytedance.sdk.openadsdk.h.i;
import com.bytedance.sdk.openadsdk.h.l;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: compiled from: DownloadTask.java */
/* JADX INFO: loaded from: classes.dex */
class b extends com.bytedance.sdk.openadsdk.h.a {
    final Object m;
    final Object n;
    private final int o;
    private final InterfaceC0089b p;
    private volatile h.a q;
    private volatile com.bytedance.sdk.openadsdk.h.c.b r;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadTask.java */
    public interface InterfaceC0089b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.f6847d, aVar.f6848e);
        this.o = aVar.g;
        this.p = aVar.i;
        this.m = this;
        this.g = aVar.f6844a;
        this.h = aVar.f6845b;
        this.f6823f = aVar.f6849f;
        this.j = aVar.f6846c;
        this.i = aVar.h;
        this.n = aVar.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ca, code lost:
    
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cf, code lost:
    
        if (com.bytedance.sdk.openadsdk.h.e.f6890c == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d1, code lost:
    
        android.util.Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d8, code lost:
    
        com.bytedance.sdk.openadsdk.h.g.d.a(r6.d());
        r4.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e2, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.bytedance.sdk.openadsdk.h.l.a r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.b.a(com.bytedance.sdk.openadsdk.h.l$a):void");
    }

    private boolean j() throws VAdError, com.bytedance.sdk.openadsdk.h.c.a {
        while (this.j.a()) {
            e();
            l.a aVarB = this.j.b();
            try {
                a(aVarB);
                return true;
            } catch (com.bytedance.sdk.openadsdk.h.c.b e2) {
                this.r = e2;
                if (e.f6890c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (com.bytedance.sdk.openadsdk.h.c.c e3) {
                aVarB.a();
                a(Boolean.valueOf(g()), this.g, e3);
            } catch (h.a e4) {
                this.q = e4;
                a(Boolean.valueOf(g()), this.g, e4);
                return false;
            } catch (IOException e5) {
                if (e5 instanceof SocketTimeoutException) {
                    aVarB.b();
                }
                if (!b()) {
                    a(Boolean.valueOf(g()), this.g, e5);
                } else if (e.f6890c) {
                    if ("Canceled".equalsIgnoreCase(e5.getMessage())) {
                        Log.w("TAG_PROXY_DownloadTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(e5));
                    }
                }
            } catch (Throwable th) {
                if (e.f6890c) {
                    Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
                }
                return false;
            }
        }
        return false;
    }

    h.a h() {
        return this.q;
    }

    com.bytedance.sdk.openadsdk.h.c.b i() {
        return this.r;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6818a.a(this.h);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (com.bytedance.sdk.adnet.err.a e2) {
            e2.printStackTrace();
        } catch (VAdError e3) {
            e3.printStackTrace();
        } catch (com.bytedance.sdk.openadsdk.h.c.a e4) {
            if (e.f6890c) {
                Log.w("TAG_PROXY_DownloadTask", Log.getStackTraceString(e4));
            }
        } catch (Throwable th) {
            if (e.f6890c) {
                Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString(th));
            }
        }
        this.f6821d.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.f6818a.b(this.h);
        InterfaceC0089b interfaceC0089b = this.p;
        if (interfaceC0089b != null) {
            interfaceC0089b.a(this);
        }
    }

    /* JADX INFO: compiled from: DownloadTask.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        l f6846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.h.a.a f6847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.bytedance.sdk.openadsdk.h.b.c f6848e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        List<i.b> f6849f;
        int g;
        i h;
        InterfaceC0089b i;
        Object j;

        a() {
        }

        a a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.f6844a = str;
            return this;
        }

        a b(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.f6845b = str;
            return this;
        }

        a a(l lVar) {
            if (lVar != null) {
                this.f6846c = lVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        a a(com.bytedance.sdk.openadsdk.h.a.a aVar) {
            if (aVar != null) {
                this.f6847d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        a a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
            if (cVar != null) {
                this.f6848e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        a a(List<i.b> list) {
            this.f6849f = list;
            return this;
        }

        a a(int i) {
            this.g = i;
            return this;
        }

        a a(InterfaceC0089b interfaceC0089b) {
            this.i = interfaceC0089b;
            return this;
        }

        a a(i iVar) {
            this.h = iVar;
            return this;
        }

        a a(Object obj) {
            this.j = obj;
            return this;
        }

        b a() {
            if (this.f6847d != null && this.f6848e != null && !TextUtils.isEmpty(this.f6844a) && !TextUtils.isEmpty(this.f6845b) && this.f6846c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
