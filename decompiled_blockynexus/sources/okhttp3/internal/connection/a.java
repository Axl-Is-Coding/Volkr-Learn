package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.z;

/* JADX INFO: compiled from: ConnectInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f23205a;

    public a(z zVar) {
        this.f23205a = zVar;
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        okhttp3.internal.http.g gVar = (okhttp3.internal.http.g) chain;
        C cRequest = gVar.request();
        g gVarC = gVar.c();
        return gVar.a(cRequest, gVarC, gVarC.a(this.f23205a, chain, !cRequest.e().equals("GET")), gVarC.c());
    }
}
