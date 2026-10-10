package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.AbstractC0483z;
import c.t.m.g.C0412b;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.util.HashMap;

/* JADX INFO: renamed from: c.t.m.g.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0465t extends AbstractC0483z {
    static /* synthetic */ boolean a(C0465t c0465t, boolean z) {
        c0465t.f3453b.a(z, c0465t.f3452a);
        return z;
    }

    @Override // c.t.m.g.AbstractC0483z
    public final boolean a(byte[] bArr, int i, boolean z, Object obj, AbstractC0483z.a aVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f3453b = aVar;
        this.f3452a = obj;
        HashMap map = new HashMap();
        map.put("B-Length", String.valueOf(i));
        map.put("HLReportCmd", z ? "realtime_speed" : "hllog");
        C0448n c0448nA = C0448n.a("https://up-hl.3g.qq.com/upreport", map, bArr, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, C0455pa.d());
        c0448nA.q = false;
        c0448nA.A = "event";
        try {
            C0412b.a.f3093a.f3092a.execute(new RunnableC0468u(this, c0448nA, jElapsedRealtime));
            return true;
        } catch (Throwable unused) {
            this.f3453b.a(false, this.f3452a);
            return false;
        }
    }
}
