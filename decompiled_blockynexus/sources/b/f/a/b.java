package b.f.a;

import android.util.Pair;
import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: EventsTracker.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f2594b;

    b(c cVar, String str) {
        this.f2594b = cVar;
        this.f2593a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.f.c.d dVar = new b.f.c.d();
            ArrayList<Pair<String, String>> arrayListD = this.f2594b.f2596b.d();
            if (GrpcUtil.HTTP_METHOD.equals(this.f2594b.f2596b.e())) {
                dVar = b.f.c.c.b(this.f2594b.f2596b.b(), this.f2593a, arrayListD);
            } else if ("GET".equals(this.f2594b.f2596b.e())) {
                dVar = b.f.c.c.a(this.f2594b.f2596b.b(), this.f2593a, arrayListD);
            }
            this.f2594b.a("response status code: " + dVar.f2621a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
