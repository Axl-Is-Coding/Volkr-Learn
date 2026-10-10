package okhttp3;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.H;
import okhttp3.u;

/* JADX INFO: compiled from: OkHttpClient.java */
/* JADX INFO: loaded from: classes5.dex */
class y extends okhttp3.a.a {
    y() {
    }

    @Override // okhttp3.a.a
    public void a(u.a aVar, String str) {
        aVar.a(str);
    }

    @Override // okhttp3.a.a
    public void b(C2947l c2947l, okhttp3.internal.connection.d dVar) {
        c2947l.b(dVar);
    }

    @Override // okhttp3.a.a
    public void a(u.a aVar, String str, String str2) {
        aVar.b(str, str2);
    }

    @Override // okhttp3.a.a
    public boolean a(C2947l c2947l, okhttp3.internal.connection.d dVar) {
        return c2947l.a(dVar);
    }

    @Override // okhttp3.a.a
    public okhttp3.internal.connection.d a(C2947l c2947l, C2936a c2936a, okhttp3.internal.connection.g gVar, K k) {
        return c2947l.a(c2936a, gVar, k);
    }

    @Override // okhttp3.a.a
    public boolean a(C2936a c2936a, C2936a c2936a2) {
        return c2936a.a(c2936a2);
    }

    @Override // okhttp3.a.a
    public Socket a(C2947l c2947l, C2936a c2936a, okhttp3.internal.connection.g gVar) {
        return c2947l.a(c2936a, gVar);
    }

    @Override // okhttp3.a.a
    public okhttp3.internal.connection.e a(C2947l c2947l) {
        return c2947l.f23436f;
    }

    @Override // okhttp3.a.a
    public int a(H.a aVar) {
        return aVar.f23041c;
    }

    @Override // okhttp3.a.a
    public void a(m mVar, SSLSocket sSLSocket, boolean z) {
        mVar.a(sSLSocket, z);
    }

    @Override // okhttp3.a.a
    public okhttp3.internal.connection.g a(Call call) {
        return ((B) call).c();
    }

    @Override // okhttp3.a.a
    public IOException a(Call call, IOException iOException) {
        return ((B) call).a(iOException);
    }

    @Override // okhttp3.a.a
    public Call a(z zVar, C c2) {
        return B.a(zVar, c2, true);
    }
}
