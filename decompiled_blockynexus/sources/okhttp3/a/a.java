package okhttp3.a;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.C;
import okhttp3.C2936a;
import okhttp3.C2947l;
import okhttp3.Call;
import okhttp3.H;
import okhttp3.K;
import okhttp3.internal.connection.g;
import okhttp3.m;
import okhttp3.u;
import okhttp3.z;

/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f23061a;

    public abstract int a(H.a aVar);

    public abstract IOException a(Call call, IOException iOException);

    public abstract Socket a(C2947l c2947l, C2936a c2936a, g gVar);

    public abstract Call a(z zVar, C c2);

    public abstract okhttp3.internal.connection.d a(C2947l c2947l, C2936a c2936a, g gVar, K k);

    public abstract okhttp3.internal.connection.e a(C2947l c2947l);

    public abstract g a(Call call);

    public abstract void a(m mVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(u.a aVar, String str);

    public abstract void a(u.a aVar, String str, String str2);

    public abstract boolean a(C2936a c2936a, C2936a c2936a2);

    public abstract boolean a(C2947l c2947l, okhttp3.internal.connection.d dVar);

    public abstract void b(C2947l c2947l, okhttp3.internal.connection.d dVar);
}
