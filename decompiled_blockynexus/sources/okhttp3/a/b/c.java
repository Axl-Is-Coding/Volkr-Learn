package okhttp3.a.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: compiled from: Jdk9Platform.java */
/* JADX INFO: loaded from: classes5.dex */
final class c extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Method f23097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Method f23098d;

    c(Method method, Method method2) {
        this.f23097c = method;
        this.f23098d = method2;
    }

    public static c e() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.a.b.f
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listA = f.a(list);
            this.f23097c.invoke(sSLParameters, listA.toArray(new String[listA.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // okhttp3.a.b.f
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f23098d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw okhttp3.a.e.a("unable to get selected protocols", (Exception) e2);
        }
    }
}
