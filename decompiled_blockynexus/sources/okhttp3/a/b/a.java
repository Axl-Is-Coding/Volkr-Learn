package okhttp3.a.b;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: compiled from: AndroidPlatform.java */
/* JADX INFO: loaded from: classes5.dex */
class a extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f23086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e<Socket> f23087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e<Socket> f23088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e<Socket> f23089f;
    private final e<Socket> g;
    private final c h = c.a();

    /* JADX INFO: renamed from: okhttp3.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class C0250a extends okhttp3.internal.tls.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f23090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f23091b;

        C0250a(Object obj, Method method) {
            this.f23090a = obj;
            this.f23091b = method;
        }

        @Override // okhttp3.internal.tls.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f23091b.invoke(this.f23090a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0250a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class b implements TrustRootIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f23092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f23093b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f23093b = method;
            this.f23092a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f23092a.equals(bVar.f23092a) && this.f23093b.equals(bVar.f23093b);
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f23093b.invoke(this.f23092a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw okhttp3.a.e.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.f23092a.hashCode() + (this.f23093b.hashCode() * 31);
        }
    }

    a(Class<?> cls, e<Socket> eVar, e<Socket> eVar2, e<Socket> eVar3, e<Socket> eVar4) {
        this.f23086c = cls;
        this.f23087d = eVar;
        this.f23088e = eVar2;
        this.f23089f = eVar3;
        this.g = eVar4;
    }

    public static f e() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (f()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private static boolean f() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // okhttp3.a.b.f
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (!okhttp3.a.e.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e3;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // okhttp3.a.b.f
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        e<Socket> eVar = this.f23089f;
        if (eVar == null || !eVar.a(sSLSocket) || (bArr = (byte[]) this.f23089f.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, okhttp3.a.e.j);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    @Override // okhttp3.a.b.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLContext c() {
        /*
            r3 = this;
            r0 = 1
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r2 = 16
            if (r1 < r2) goto Le
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> Lf
            r2 = 22
            if (r1 >= r2) goto Le
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L18
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L18
            return r0
        L18:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L1f
            return r0
        L1f:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No TLS provider"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.a.b.a.c():javax.net.ssl.SSLContext");
    }

    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f23094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f23095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f23096c;

        c(Method method, Method method2, Method method3) {
            this.f23094a = method;
            this.f23095b = method2;
            this.f23096c = method3;
        }

        Object a(String str) {
            Method method = this.f23094a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f23095b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f23096c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        static c a() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    @Override // okhttp3.a.b.f
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw okhttp3.a.e.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw okhttp3.a.e.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw okhttp3.a.e.a("unable to determine cleartext support", e);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    @Override // okhttp3.a.b.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f23087d.c(sSLSocket, true);
            this.f23088e.c(sSLSocket, str);
        }
        e<Socket> eVar = this.g;
        if (eVar == null || !eVar.a(sSLSocket)) {
            return;
        }
        this.g.d(sSLSocket, f.b(list));
    }

    @Override // okhttp3.a.b.f
    public TrustRootIndex b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // okhttp3.a.b.f
    public void a(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // okhttp3.a.b.f
    public Object a(String str) {
        return this.h.a(str);
    }

    @Override // okhttp3.a.b.f
    public void a(String str, Object obj) {
        if (this.h.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    private boolean a(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    @Override // okhttp3.a.b.f
    public okhttp3.internal.tls.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0250a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }
}
