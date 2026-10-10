package com.ta.utdid2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.ta.utdid2.b.a.d;
import com.ta.utdid2.b.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AidRequester.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    private static final String TAG = "com.ta.utdid2.a.b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f19332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f96a = new Object();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    private static String b(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        try {
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        sb.append("http://hydra.alibaba.com/");
        sb.append(str);
        sb.append("/get_aid/");
        sb.append("?");
        sb.append("auth[token]=");
        sb.append(str2);
        sb.append("&type=");
        sb.append("utdid");
        sb.append("&id=");
        sb.append(str3);
        sb.append("&aid=");
        sb.append(str4);
        return sb.toString();
    }

    /* JADX INFO: compiled from: AidRequester.java */
    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.ut.device.a f19333a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f97a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        HttpPost f98a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        String f99b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f19335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f19336d;

        public a(HttpPost httpPost) {
            this.f97a = "";
            this.f19336d = "";
            this.f98a = httpPost;
        }

        public String b() {
            return this.f97a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x006b, code lost:
        
            android.util.Log.e(com.ta.utdid2.a.b.TAG, r0.toString());
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.b.a.run():void");
        }

        public a(HttpPost httpPost, com.ut.device.a aVar, String str, String str2, String str3) {
            this.f97a = "";
            this.f19336d = "";
            this.f98a = httpPost;
            this.f19333a = aVar;
            this.f99b = str;
            this.f19335c = str2;
            this.f19336d = str3;
        }
    }

    public static synchronized b a(Context context) {
        if (f19332a == null) {
            f19332a = new b(context);
        }
        return f19332a;
    }

    public void a(String str, String str2, String str3, String str4, com.ut.device.a aVar) {
        String strB = b(str, str2, str3, str4);
        if (d.f19354e) {
            Log.d(TAG, "url:" + strB + "; len:" + strB.length());
        }
        new a(new HttpPost(strB), aVar, str4, str, str2).start();
    }

    public String a(String str, String str2, String str3, String str4) {
        String strB = b(str, str2, str3, str4);
        int i = f.b(this.mContext) ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : 1000;
        if (d.f19354e) {
            Log.d(TAG, "url:" + strB + "; timeout:" + i);
        }
        a aVar = new a(new HttpPost(strB));
        aVar.start();
        try {
            synchronized (this.f96a) {
                this.f96a.wait(i);
            }
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
        }
        String strB2 = aVar.b();
        if (d.f19354e) {
            Log.d(TAG, "mLine:" + strB2);
        }
        return a(strB2, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!jSONObject2.has("action") || !jSONObject2.has("aid")) {
                    return str2;
                }
                String string = jSONObject2.getString("action");
                return (string.equalsIgnoreCase("new") || string.equalsIgnoreCase("changed")) ? jSONObject2.getString("aid") : str2;
            }
            if (!jSONObject.has("isError") || !jSONObject.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                return str2;
            }
            String string2 = jSONObject.getString("isError");
            String string3 = jSONObject.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            if (!string2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                return str2;
            }
            if (!string3.equalsIgnoreCase("404") && !string3.equalsIgnoreCase("401")) {
                return str2;
            }
            if (d.f19354e) {
                Log.d(TAG, "remove the AID, status:" + string3);
            }
            return "";
        } catch (JSONException e2) {
            Log.e(TAG, e2.toString());
            return str2;
        } catch (Exception e3) {
            Log.e(TAG, e3.toString());
            return str2;
        }
    }
}
