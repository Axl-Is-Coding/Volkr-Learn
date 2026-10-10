package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public class Ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Ga f2907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f2908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f2909c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f2910d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Ma f2911e = Ma.f2962a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Timer f2912f = null;

    /* JADX INFO: compiled from: TL */
    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f2913a = new JSONObject();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Ha f2914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Ja f2915c;

        public a() {
            this.f2914b = null;
            this.f2915c = null;
            this.f2914b = Ha.a();
            this.f2915c = Ja.a();
        }

        private JSONObject a() {
            if (Ga.this.f2911e == null) {
                return this.f2913a;
            }
            String strReplace = Ga.this.f2909c ? "https://cc.map.qq.com/?get_c3" : "https://cc.map.qq.com/?get_c3".replace("https:", "http:");
            "cc_url:".concat(String.valueOf(strReplace));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cc_version", this.f2914b.e("cc_version"));
                jSONObject.put("m_module", Ha.f2918a);
                jSONObject.put("m_channel", Ha.f2919b);
                jSONObject.put("m_version", Ha.f2920c);
                jSONObject.put("imei", C0411ab.a());
                String strA = Va.a(jSONObject.toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
                "req:".concat(String.valueOf(strA));
                Bundle bundleA = Ga.this.f2911e.a(strReplace, strA.getBytes(), null);
                String string = bundleA.getString("msg_suc", "");
                if (TextUtils.isEmpty(string)) {
                    String string2 = bundleA.getString("msg_fail", "");
                    StringBuilder sb = new StringBuilder("net work error! res = [");
                    sb.append(string2);
                    sb.append("]");
                    return this.f2913a;
                }
                "res:".concat(String.valueOf(string));
                String string3 = this.f2913a.toString();
                if (!string3.equals(string)) {
                    string3 = Va.b(string, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
                }
                return TextUtils.isEmpty(string3) ? this.f2913a : new JSONObject(string3);
            } catch (Throwable th) {
                C0458qa.a(th.getMessage(), th);
                return this.f2913a;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x013a A[Catch: Throwable -> 0x0140, TRY_LEAVE, TryCatch #2 {Throwable -> 0x0140, blocks: (B:3:0x0008, B:5:0x001f, B:51:0x0104, B:53:0x010b, B:54:0x010d, B:63:0x0125, B:65:0x012c, B:66:0x0131, B:60:0x011b, B:62:0x0122, B:67:0x0132, B:69:0x013a, B:7:0x0027, B:8:0x002c, B:10:0x003c, B:47:0x00e5, B:49:0x00f5, B:50:0x00ff, B:13:0x0055, B:15:0x005b, B:17:0x0063, B:18:0x0069, B:22:0x007b, B:24:0x0083, B:25:0x0085, B:26:0x008d, B:28:0x0093, B:29:0x0099, B:31:0x00a1, B:34:0x00a8, B:37:0x00b1, B:38:0x00b5, B:39:0x00bc, B:45:0x00db, B:46:0x00e2, B:59:0x0114), top: B:78:0x0008, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        @Override // java.util.TimerTask, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 329
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.Ga.a.run():void");
        }
    }

    private Ga() {
        Context context = f2908b;
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long e() {
        long jC = Ha.a().c("cc_req_interval");
        if (jC > 86400000) {
            jC = 86400000;
        }
        if (jC < 3600000) {
            return 3600000L;
        }
        return jC;
    }

    public static void a(HashMap<String, String> map) {
        Ha.a(map);
    }

    public final synchronized void b() {
        if (this.f2910d) {
            return;
        }
        this.f2910d = true;
        this.f2912f = new Timer("th_CC_Timer");
        a(true);
    }

    public final synchronized void c() {
        if (this.f2910d) {
            this.f2910d = false;
            try {
                Ha.a().h.clear();
                a(0L);
                if (this.f2912f != null) {
                    Timer timer = this.f2912f;
                    this.f2912f = null;
                    timer.schedule(new Fa(this, timer), 100L);
                }
            } catch (Throwable th) {
                C0458qa.a("shutdown error.", th);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && context.getApplicationContext() != null) {
            Context applicationContext = context.getApplicationContext();
            f2908b = applicationContext;
            C0458qa.a(applicationContext);
            Ja.a(str);
            Ha.a(str, str2);
            new Ea("th_CC_init").start();
            return;
        }
        throw new NullPointerException("context cannot be null!");
    }

    public static void a(String str) {
        Ha.a(str);
    }

    public static synchronized Ga a() {
        if (f2907a == null) {
            synchronized (Ga.class) {
                if (f2907a == null) {
                    f2907a = new Ga();
                }
            }
        }
        return f2907a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        long jE;
        try {
            int iB = Ha.a().b("cc_version");
            if (iB == -1) {
                jE = z ? 5000L : 10800000L;
            } else {
                jE = e();
            }
            StringBuilder sb = new StringBuilder("schedule : first[");
            sb.append(z);
            sb.append("],locVer[");
            sb.append(iB);
            sb.append("],delayTime[");
            sb.append(jE);
            sb.append("]");
            a(jE);
        } catch (Throwable unused) {
        }
    }

    private void a(long j) {
        Timer timer = this.f2912f;
        if (timer != null) {
            a aVar = new a();
            if (j < 0) {
                j = 0;
            }
            timer.schedule(aVar, j);
        }
    }
}
