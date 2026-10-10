package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: Jdk9Platform.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Method f5167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Method f5168b;

    b(Method method, Method method2) {
        this.f5167a = method;
        this.f5168b = method2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listA = e.a(list);
            this.f5167a.invoke(sSLParameters, listA.toArray(new String[listA.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5168b.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to get selected protocols", (Exception) e2);
        }
    }

    public static b a() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
