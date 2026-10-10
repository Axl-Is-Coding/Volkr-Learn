package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzj {
    private final String zzbqw;
    private final Bundle zzckr;

    public zzzj(String str, Bundle bundle) {
        this.zzbqw = str;
        this.zzckr = bundle;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzwm.zzqb().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String getQuery() {
        return this.zzbqw;
    }

    public final Bundle getQueryBundle() {
        return this.zzckr;
    }
}
