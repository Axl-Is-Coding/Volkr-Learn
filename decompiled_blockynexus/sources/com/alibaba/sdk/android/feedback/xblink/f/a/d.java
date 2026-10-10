package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.alibaba.sdk.android.feedback.xblink.f.a {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x0019, B:6:0x001f, B:7:0x0025, B:10:0x0034, B:11:0x0038, B:13:0x003c, B:17:0x004c, B:19:0x0053, B:16:0x0049), top: B:31:0x0001, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.alibaba.sdk.android.feedback.xblink.f.m r6 = new com.alibaba.sdk.android.feedback.xblink.f.m     // Catch: java.lang.Throwable -> L58
            r6.<init>()     // Catch: java.lang.Throwable -> L58
            android.content.Context r0 = r4.f3802a     // Catch: java.lang.Throwable -> L58
            java.util.Map r0 = com.alibaba.sdk.android.feedback.util.i.a(r0)     // Catch: java.lang.Throwable -> L58
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L58
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L58
        L19:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L58
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> L58
            java.lang.Object r3 = r2.getKey()     // Catch: org.json.JSONException -> L33 java.lang.Throwable -> L58
            java.lang.String r3 = (java.lang.String) r3     // Catch: org.json.JSONException -> L33 java.lang.Throwable -> L58
            java.lang.Object r2 = r2.getValue()     // Catch: org.json.JSONException -> L33 java.lang.Throwable -> L58
            r1.put(r3, r2)     // Catch: org.json.JSONException -> L33 java.lang.Throwable -> L58
            goto L19
        L33:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L58
            goto L19
        L38:
            org.json.JSONObject r0 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L4c
            java.lang.String r0 = "feedback_message_attri"
            org.json.JSONObject r2 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo     // Catch: org.json.JSONException -> L48 java.lang.Throwable -> L58
            java.lang.String r2 = r2.toString()     // Catch: org.json.JSONException -> L48 java.lang.Throwable -> L58
            r1.put(r0, r2)     // Catch: org.json.JSONException -> L48 java.lang.Throwable -> L58
            goto L4c
        L48:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L58
        L4c:
            java.lang.String r0 = "data"
            r6.a(r0, r1)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L56
            r5.a(r6)     // Catch: java.lang.Throwable -> L58
        L56:
            monitor-exit(r4)
            return
        L58:
            r5 = move-exception
            monitor-exit(r4)
            goto L5c
        L5b:
            throw r5
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.d.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"getInfo".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
