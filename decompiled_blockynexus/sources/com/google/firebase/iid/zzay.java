package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import io.rong.imlib.common.RongLibConst;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class zzay {
    private static final long zzdn = TimeUnit.DAYS.toMillis(7);
    private final long timestamp;
    final String zzbv;
    private final String zzdo;

    private zzay(String str, String str2, long j) {
        this.zzbv = str;
        this.zzdo = str2;
        this.timestamp = j;
    }

    static String zza(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(RongLibConst.KEY_TOKEN, str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(strValueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String zzb(zzay zzayVar) {
        if (zzayVar == null) {
            return null;
        }
        return zzayVar.zzbv;
    }

    static zzay zzi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new zzay(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzay(jSONObject.getString(RongLibConst.KEY_TOKEN), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(strValueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    final boolean zzj(String str) {
        return System.currentTimeMillis() > this.timestamp + zzdn || !str.equals(this.zzdo);
    }
}
