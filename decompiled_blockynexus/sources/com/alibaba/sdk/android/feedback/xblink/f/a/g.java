package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.content.SharedPreferences;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends com.alibaba.sdk.android.feedback.xblink.f.a {
    private void b(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        String string = com.alibaba.sdk.android.feedback.a.b.n().getSharedPreferences("ywPrefsTools", 0).getString("getHistoryStatus", "0");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, string);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        mVar.a("data", jSONObject);
        if (bVar != null) {
            bVar.a(mVar);
        }
    }

    private void c(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        try {
            int iIntValue = ((Integer) new JSONObject(str).getJSONObject("data").get(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)).intValue();
            SharedPreferences.Editor editorEdit = com.alibaba.sdk.android.feedback.a.b.n().getSharedPreferences("ywPrefsTools", 0).edit();
            editorEdit.putString("getHistoryStatus", String.valueOf(iIntValue));
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        mVar.a("code", "0");
        try {
            JSONObject jSONObject = new JSONObject(com.alibaba.sdk.android.feedback.a.a.a());
            mVar.a("data", jSONObject);
            com.alibaba.sdk.android.feedback.xblink.i.g.c("WXFeedBack", "ui conf:" + jSONObject);
            if (bVar != null) {
                bVar.a(mVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00be A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:4:0x000b, B:5:0x005e, B:7:0x0064, B:8:0x006a, B:11:0x0079, B:12:0x007d, B:14:0x0081, B:18:0x008d, B:20:0x0091, B:24:0x009d, B:26:0x00be, B:17:0x008a, B:23:0x009a), top: B:34:0x0001, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.alibaba.sdk.android.feedback.xblink.f.m r6 = new com.alibaba.sdk.android.feedback.xblink.f.m     // Catch: java.lang.Throwable -> Lc3
            r6.<init>()     // Catch: java.lang.Throwable -> Lc3
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc3
            r0.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = "openIMId"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.g()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "credential"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.h()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "appkey"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.d()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "deviceId"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.f()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "version"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.i()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "contactInfo"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.j()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "isAudioEnabled"
            r2 = 1
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.String r1 = "customizeId"
            java.lang.String r2 = com.alibaba.sdk.android.feedback.a.b.p()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            android.content.Context r1 = r4.f3802a     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.util.Map r1 = com.alibaba.sdk.android.feedback.util.i.a(r1)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.util.Set r1 = r1.entrySet()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.util.Iterator r1 = r1.iterator()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
        L5e:
            boolean r2 = r1.hasNext()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            if (r2 == 0) goto L7d
            java.lang.Object r2 = r1.next()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            java.lang.Object r3 = r2.getKey()     // Catch: org.json.JSONException -> L78 java.lang.Throwable -> Lc3
            java.lang.String r3 = (java.lang.String) r3     // Catch: org.json.JSONException -> L78 java.lang.Throwable -> Lc3
            java.lang.Object r2 = r2.getValue()     // Catch: org.json.JSONException -> L78 java.lang.Throwable -> Lc3
            r0.put(r3, r2)     // Catch: org.json.JSONException -> L78 java.lang.Throwable -> Lc3
            goto L5e
        L78:
            r2 = move-exception
            r2.printStackTrace()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            goto L5e
        L7d:
            org.json.JSONObject r1 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            if (r1 == 0) goto L8d
            java.lang.String r1 = "feedback_message_attri"
            org.json.JSONObject r2 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo     // Catch: org.json.JSONException -> L89 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L89 java.lang.Throwable -> Lc3
            goto L8d
        L89:
            r1 = move-exception
            r1.printStackTrace()     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
        L8d:
            org.json.JSONObject r1 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            if (r1 == 0) goto L9d
            java.lang.String r1 = "extInfo"
            org.json.JSONObject r2 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            r0.put(r1, r2)     // Catch: org.json.JSONException -> L99 java.lang.Throwable -> Lc3
            goto L9d
        L99:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lc3
        L9d:
            java.lang.String r1 = "data"
            r6.a(r1, r0)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = "WXFeedBack"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r2.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "customInfoJsonObj:"
            r2.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc3
            r2.append(r0)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> Lc3
            com.alibaba.sdk.android.feedback.xblink.i.g.c(r1, r0)     // Catch: java.lang.Throwable -> Lc3
            if (r5 == 0) goto Lc1
            r5.a(r6)     // Catch: java.lang.Throwable -> Lc3
        Lc1:
            monitor-exit(r4)
            return
        Lc3:
            r5 = move-exception
            monitor-exit(r4)
            goto Lc7
        Lc6:
            throw r5
        Lc7:
            goto Lc6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.g.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if ("customInfo".equals(str)) {
            a(bVar, str2);
            return true;
        }
        if ("getConf".equals(str)) {
            d(bVar, str2);
            return true;
        }
        if ("getPrevStatus".equals(str)) {
            b(bVar, str2);
            return true;
        }
        if (!"setPrevStatus".equals(str)) {
            return false;
        }
        c(bVar, str2);
        return true;
    }
}
