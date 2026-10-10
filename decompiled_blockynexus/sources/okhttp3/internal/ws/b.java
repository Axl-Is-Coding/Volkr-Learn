package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.H;
import okhttp3.internal.connection.g;
import okhttp3.internal.ws.c;

/* JADX INFO: compiled from: RealWebSocket.java */
/* JADX INFO: loaded from: classes5.dex */
class b implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f23395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f23396b;

    b(c cVar, C c2) {
        this.f23396b = cVar;
        this.f23395a = c2;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.f23396b.a(iOException, (H) null);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, H h) {
        try {
            this.f23396b.a(h);
            g gVarA = okhttp3.a.a.f23061a.a(call);
            gVarA.e();
            c.e eVarA = gVarA.c().a(gVarA);
            try {
                this.f23396b.f23399c.a(this.f23396b, h);
                this.f23396b.a("OkHttp WebSocket " + this.f23395a.g().n(), eVarA);
                gVarA.c().socket().setSoTimeout(0);
                this.f23396b.a();
            } catch (Exception e2) {
                this.f23396b.a(e2, (H) null);
            }
        } catch (ProtocolException e3) {
            this.f23396b.a(e3, h);
            okhttp3.a.e.a(h);
        }
    }
}
