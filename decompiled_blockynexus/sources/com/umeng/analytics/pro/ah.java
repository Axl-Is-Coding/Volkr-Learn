package com.umeng.analytics.pro;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpPostThread.java */
/* JADX INFO: loaded from: classes5.dex */
public class ah implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20631a = "https://ucc.umeng.com/v1/fetch";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20632b = "https://pslog.umeng.com/ablog";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20634d;

    public ah(String str, JSONObject jSONObject) {
        this.f20633c = str;
        this.f20634d = jSONObject.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[Catch: all -> 0x003c, Exception -> 0x003e, TryCatch #2 {Exception -> 0x003e, blocks: (B:2:0x0000, B:10:0x0024, B:12:0x002a, B:13:0x0034, B:6:0x0017), top: B:19:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[Catch: all -> 0x003c, Exception -> 0x003e, TRY_LEAVE, TryCatch #2 {Exception -> 0x003e, blocks: (B:2:0x0000, B:10:0x0024, B:12:0x002a, B:13:0x0034, B:6:0x0017), top: B:19:0x0000 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f20633c     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r1 = r5.f20634d     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r0 = com.umeng.analytics.pro.ag.a(r0, r1)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r1 = -1
            java.lang.String r2 = r5.f20633c     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = "https://ucc.umeng.com/v1/fetch"
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3 = 0
            if (r2 == 0) goto L17
            r1 = 1
        L15:
            r2 = r0
            goto L24
        L17:
            java.lang.String r2 = r5.f20633c     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r4 = "https://pslog.umeng.com/ablog"
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r2 == 0) goto L23
            r1 = 2
            goto L15
        L23:
            r2 = r3
        L24:
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r0 == 0) goto L34
            com.umeng.cconfig.UMRemoteConfig r0 = com.umeng.cconfig.UMRemoteConfig.getInstance()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = r5.f20634d     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r0.handlerMessage(r1, r2, r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L3e
        L34:
            com.umeng.cconfig.UMRemoteConfig r0 = com.umeng.cconfig.UMRemoteConfig.getInstance()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r0.handlerMessage(r1, r2, r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L3e
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ah.run():void");
    }

    public ah(String str, JSONArray jSONArray) {
        this.f20633c = str;
        this.f20634d = jSONArray.toString();
    }

    public ah(String str, String str2) {
        this.f20633c = str;
        this.f20634d = str2;
    }
}
