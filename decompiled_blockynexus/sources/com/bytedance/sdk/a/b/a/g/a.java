package com.bytedance.sdk.a.b.a.g;

import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
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

/* JADX INFO: compiled from: AndroidPlatform.java */
/* JADX INFO: loaded from: classes.dex */
class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f5154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<Socket> f5155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d<Socket> f5156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<Socket> f5157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d<Socket> f5158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f5159f = c.a();

    /* JADX INFO: renamed from: com.bytedance.sdk.a.b.a.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class C0067a extends com.bytedance.sdk.a.b.a.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f5160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f5161b;

        C0067a(Object obj, Method method) {
            this.f5160a = obj;
            this.f5161b = method;
        }

        @Override // com.bytedance.sdk.a.b.a.i.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f5161b.invoke(this.f5160a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0067a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f5162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f5163b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f5163b = method;
            this.f5162a = x509TrustManager;
        }

        @Override // com.bytedance.sdk.a.b.a.i.f
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5163b.invoke(this.f5162a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw com.bytedance.sdk.a.b.a.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5162a.equals(bVar.f5162a) && this.f5163b.equals(bVar.f5163b);
        }

        public int hashCode() {
            return this.f5162a.hashCode() + (this.f5163b.hashCode() * 31);
        }
    }

    a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f5154a = cls;
        this.f5155b = dVar;
        this.f5156c = dVar2;
        this.f5157d = dVar3;
        this.f5158e = dVar4;
    }

    private static boolean c() {
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

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (!com.bytedance.sdk.a.b.a.c.a(e2)) {
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

    @Override // com.bytedance.sdk.a.b.a.g.e
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e);
        }
    }

    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f5164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f5165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f5166c;

        c(Method method, Method method2, Method method3) {
            this.f5164a = method;
            this.f5165b = method2;
            this.f5166c = method3;
        }

        Object a(String str) {
            Method method = this.f5164a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f5165b.invoke(objInvoke, str);
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
                this.f5166c.invoke(obj, new Object[0]);
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

    private boolean b(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public f b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.f5155b.b(sSLSocket, true);
            this.f5156c.b(sSLSocket, str);
        }
        d<Socket> dVar = this.f5158e;
        if (dVar == null || !dVar.a(sSLSocket)) {
            return;
        }
        this.f5158e.d(sSLSocket, e.b(list));
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.f5157d;
        if (dVar == null || !dVar.a(sSLSocket) || (bArr = (byte[]) this.f5157d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.a.b.a.c.f4968e);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
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

    @Override // com.bytedance.sdk.a.b.a.g.e
    public Object a(String str) {
        return this.f5159f.a(str);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(String str, Object obj) {
        if (this.f5159f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    private boolean a(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0067a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            if (c()) {
                d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                dVar = dVar5;
            } else {
                dVar = null;
                dVar2 = null;
            }
            return new a(cls2, dVar3, dVar4, dVar, dVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
