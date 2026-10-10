package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.X;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: renamed from: c.t.m.g.ea, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0422ea implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ X f3144a;

    RunnableC0422ea(X x) {
        this.f3144a = x;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        try {
            try {
                O o = new O();
                Iterator it = this.f3144a.f3044f.values().iterator();
                while (it.hasNext()) {
                    ((T) it.next()).a(o);
                }
                byte[] bArrA = o.a();
                if (!C0455pa.a(bArrA)) {
                    String strD = C0455pa.d();
                    C0434ia.d().f();
                    C0448n c0448nA = C0448n.a("https://yun-hl.3g.qq.com/halleycloud", null, bArrA, 15000, strD);
                    c0448nA.u = X.f3039a;
                    c0448nA.A = "platform";
                    C0457q c0457qA = c0448nA.a();
                    int i2 = c0457qA.f3344a;
                    try {
                        try {
                            if (c0457qA.f3344a == 0 && c0457qA.f3346c == 200 && !C0455pa.a(c0457qA.f3347d)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(new String(c0457qA.f3347d));
                                    qc.e();
                                    Iterator it2 = this.f3144a.f3044f.values().iterator();
                                    while (it2.hasNext()) {
                                        ((T) it2.next()).a(jSONObject);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            c0448nA.k = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            c0448nA.a(false);
                            i = i2;
                        } catch (Throwable th2) {
                            th = th2;
                            i = i2;
                            X.a aVarA = this.f3144a.a(qc.b());
                            aVarA.f3045a = SystemClock.elapsedRealtime();
                            aVarA.f3046b = i;
                            X.e(this.f3144a);
                            this.f3144a.f3043e.removeCallbacks(this.f3144a.i);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i = i2;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        X.a aVarA2 = this.f3144a.a(qc.b());
        aVarA2.f3045a = SystemClock.elapsedRealtime();
        aVarA2.f3046b = i;
        X.e(this.f3144a);
        this.f3144a.f3043e.removeCallbacks(this.f3144a.i);
    }
}
