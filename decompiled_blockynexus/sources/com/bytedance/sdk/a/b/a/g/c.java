package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: JdkWithJettyBootPlatform.java */
/* JADX INFO: loaded from: classes.dex */
class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f5169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f5170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f5171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f5172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f5173e;

    /* JADX INFO: compiled from: JdkWithJettyBootPlatform.java */
    private static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<String> f5176c;

        a(List<String> list) {
            this.f5176c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.a.b.a.c.f4965b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5174a = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f5176c;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f5175b = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.f5176c.contains(list.get(i))) {
                    String str = (String) list.get(i);
                    this.f5175b = str;
                    return str;
                }
            }
            String str2 = this.f5176c.get(0);
            this.f5175b = str2;
            return str2;
        }
    }

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5169a = method;
        this.f5170b = method2;
        this.f5171c = method3;
        this.f5172d = cls;
        this.f5173e = cls2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f5169a.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f5172d, this.f5173e}, new a(e.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void b(SSLSocket sSLSocket) {
        try {
            this.f5171c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to remove alpn", (Exception) e2);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f5170b.invoke(null, sSLSocket));
            if (!aVar.f5174a && aVar.f5175b == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.f5174a) {
                return null;
            }
            return aVar.f5175b;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to get selected protocol", (Exception) e2);
        }
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
