package okhttp3.a.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: compiled from: JdkWithJettyBootPlatform.java */
/* JADX INFO: loaded from: classes5.dex */
class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f23099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f23100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f23101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f23102f;
    private final Class<?> g;

    /* JADX INFO: compiled from: JdkWithJettyBootPlatform.java */
    private static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f23103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f23104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f23105c;

        a(List<String> list) {
            this.f23103a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.a.e.f23114b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f23104b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f23103a;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f23105c = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.f23103a.contains(list.get(i))) {
                    String str = (String) list.get(i);
                    this.f23105c = str;
                    return str;
                }
            }
            String str2 = this.f23103a.get(0);
            this.f23105c = str2;
            return str2;
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f23099c = method;
        this.f23100d = method2;
        this.f23101e = method3;
        this.f23102f = cls;
        this.g = cls2;
    }

    public static f e() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.a.b.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f23099c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f23102f, this.g}, new a(f.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // okhttp3.a.b.f
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f23100d.invoke(null, sSLSocket));
            if (!aVar.f23104b && aVar.f23105c == null) {
                f.a().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.f23104b) {
                return null;
            }
            return aVar.f23105c;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to get selected protocol", (Exception) e2);
        }
    }

    @Override // okhttp3.a.b.f
    public void a(SSLSocket sSLSocket) {
        try {
            this.f23101e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to remove alpn", (Exception) e2);
        }
    }
}
