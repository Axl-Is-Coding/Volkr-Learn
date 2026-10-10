package com.alibaba.sdk.android.feedback.xblink.c;

import com.alibaba.sdk.android.feedback.xblink.webview.t;
import java.net.HttpURLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3786a = "HttpConnector";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3787b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f3788c = null;

    static {
        System.setProperty("http.keepAlive", "false");
    }

    private void a(HttpURLConnection httpURLConnection, h hVar) {
        int iH = hVar.h() + 1;
        httpURLConnection.setConnectTimeout(hVar.e() * iH);
        httpURLConnection.setReadTimeout(hVar.f() * iH);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("Host", hVar.a().getHost());
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String strA = t.a(httpURLConnection.getURL().toString());
        if (strA != null) {
            httpURLConnection.setRequestProperty("Cookie", strA);
        }
        Map mapD = hVar.d();
        if (mapD != null) {
            for (Map.Entry entry : mapD.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        httpURLConnection.setUseCaches(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x04fd: MOVE (r11 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:274:0x04fb */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03f9 A[Catch: all -> 0x04fa, TryCatch #18 {all -> 0x04fa, blocks: (B:131:0x02bf, B:132:0x02c3, B:134:0x02ca, B:136:0x02d1, B:139:0x02d5, B:140:0x02e3, B:142:0x02ee, B:215:0x03f1, B:217:0x03f9, B:218:0x0410, B:219:0x042c, B:262:0x04db, B:264:0x04df, B:265:0x04e7, B:269:0x04ef, B:271:0x04f3, B:272:0x04f9), top: B:307:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0438 A[Catch: all -> 0x04cc, TryCatch #33 {all -> 0x04cc, blocks: (B:223:0x0434, B:225:0x0438, B:226:0x0440, B:251:0x04bf, B:254:0x04c2, B:255:0x04cb), top: B:320:0x0434, inners: #30 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04df A[Catch: all -> 0x04fa, TryCatch #18 {all -> 0x04fa, blocks: (B:131:0x02bf, B:132:0x02c3, B:134:0x02ca, B:136:0x02d1, B:139:0x02d5, B:140:0x02e3, B:142:0x02ee, B:215:0x03f1, B:217:0x03f9, B:218:0x0410, B:219:0x042c, B:262:0x04db, B:264:0x04df, B:265:0x04e7, B:269:0x04ef, B:271:0x04f3, B:272:0x04f9), top: B:307:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04f3 A[Catch: all -> 0x04fa, TryCatch #18 {all -> 0x04fa, blocks: (B:131:0x02bf, B:132:0x02c3, B:134:0x02ca, B:136:0x02d1, B:139:0x02d5, B:140:0x02e3, B:142:0x02ee, B:215:0x03f1, B:217:0x03f9, B:218:0x0410, B:219:0x042c, B:262:0x04db, B:264:0x04df, B:265:0x04e7, B:269:0x04ef, B:271:0x04f3, B:272:0x04f9), top: B:307:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x051f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x053b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0503 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:? A[Catch: all -> 0x04fa, SYNTHETIC, TryCatch #18 {all -> 0x04fa, blocks: (B:131:0x02bf, B:132:0x02c3, B:134:0x02ca, B:136:0x02d1, B:139:0x02d5, B:140:0x02e3, B:142:0x02ee, B:215:0x03f1, B:217:0x03f9, B:218:0x0410, B:219:0x042c, B:262:0x04db, B:264:0x04df, B:265:0x04e7, B:269:0x04ef, B:271:0x04f3, B:272:0x04f9), top: B:307:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:349:? A[Catch: all -> 0x04fa, SYNTHETIC, TRY_LEAVE, TryCatch #18 {all -> 0x04fa, blocks: (B:131:0x02bf, B:132:0x02c3, B:134:0x02ca, B:136:0x02d1, B:139:0x02d5, B:140:0x02e3, B:142:0x02ee, B:215:0x03f1, B:217:0x03f9, B:218:0x0410, B:219:0x042c, B:262:0x04db, B:264:0x04df, B:265:0x04e7, B:269:0x04ef, B:271:0x04f3, B:272:0x04f9), top: B:307:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:350:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v7, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.alibaba.sdk.android.feedback.xblink.c.c] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.sdk.android.feedback.xblink.c.i b(com.alibaba.sdk.android.feedback.xblink.c.h r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.c.c.b(com.alibaba.sdk.android.feedback.xblink.c.h):com.alibaba.sdk.android.feedback.xblink.c.i");
    }

    public i a(h hVar) {
        return a(hVar, (b) null);
    }

    public i a(h hVar, b bVar) {
        String str;
        StringBuilder sb;
        if (hVar == null) {
            throw new NullPointerException("Http connect error, request is null");
        }
        this.f3788c = bVar;
        int i = 0;
        this.f3787b = 0;
        int iH = hVar.h();
        while (i < iH) {
            try {
                return b(hVar);
            } catch (d e2) {
                e = e2;
                str = f3786a;
                sb = new StringBuilder();
                sb.append(e);
                sb.append("");
                com.alibaba.sdk.android.feedback.xblink.i.g.b(str, sb.toString());
                return new i();
            } catch (e e3) {
                e = e3;
                str = f3786a;
                sb = new StringBuilder();
                sb.append(e);
                sb.append("");
                com.alibaba.sdk.android.feedback.xblink.i.g.b(str, sb.toString());
                return new i();
            } catch (f e4) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b(f3786a, e4 + "");
                if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a(f3786a, "retryTime: " + i);
                }
                i++;
                try {
                    Thread.sleep(i * 2 * 1000);
                } catch (InterruptedException unused) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.b(f3786a, "HttpConnector retry Sleep has been interrupted, go ahead");
                }
            } catch (g e5) {
                e = e5;
                str = f3786a;
                sb = new StringBuilder();
                sb.append(e);
                sb.append("");
                com.alibaba.sdk.android.feedback.xblink.i.g.b(str, sb.toString());
                return new i();
            }
        }
        return new i();
    }
}
