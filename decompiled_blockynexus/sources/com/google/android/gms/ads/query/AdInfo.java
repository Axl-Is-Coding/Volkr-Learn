package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbbq;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class AdInfo {
    private final QueryInfo zzhlq;
    private final String zzhlr;

    @KeepForSdk
    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhlq = queryInfo;
        this.zzhlr = str;
    }

    @KeepForSdk
    public static String getRequestId(String str) {
        if (str == null) {
            zzbbq.zzfe("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            zzbbq.zzfe("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    @KeepForSdk
    public String getAdString() {
        return this.zzhlr;
    }

    @KeepForSdk
    public QueryInfo getQueryInfo() {
        return this.zzhlq;
    }
}
