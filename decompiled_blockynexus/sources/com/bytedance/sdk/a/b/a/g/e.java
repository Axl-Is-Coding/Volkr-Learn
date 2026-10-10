package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f5180a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f5181b = Logger.getLogger(v.class.getName());

    public static e b() {
        return f5180a;
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    static byte[] b(List<w> list) {
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                cVar.i(wVar.toString().length());
                cVar.b(wVar.toString());
            }
        }
        return cVar.q();
    }

    public void a(int i, String str, Throwable th) {
        f5181b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f5181b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w wVar = list.get(i);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public f b(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.b(x509TrustManager.getAcceptedIssuers());
    }

    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.a(b(x509TrustManager));
    }

    private static e a() {
        e eVarA = a.a();
        if (eVarA != null) {
            return eVarA;
        }
        b bVarA = b.a();
        if (bVarA != null) {
            return bVarA;
        }
        e eVarA2 = c.a();
        return eVarA2 != null ? eVarA2 : new e();
    }
}
