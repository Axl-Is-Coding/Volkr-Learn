package okhttp3.internal.ws;

import java.io.IOException;
import okhttp3.H;

/* JADX INFO: compiled from: RealWebSocket.java */
/* JADX INFO: loaded from: classes5.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f23394a;

    a(c cVar) {
        this.f23394a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        do {
            try {
            } catch (IOException e2) {
                this.f23394a.a(e2, (H) null);
                return;
            }
        } while (this.f23394a.b());
    }
}
