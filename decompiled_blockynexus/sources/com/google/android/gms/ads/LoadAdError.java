package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzwm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class LoadAdError extends AdError {
    private final ResponseInfo zzadj;

    public LoadAdError(int i, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zzadj = responseInfo;
    }

    public final ResponseInfo getResponseInfo() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue()) {
            return this.zzadj;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.AdError
    public final String toString() {
        try {
            return zzdp().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject zzdp() throws JSONException {
        JSONObject jSONObjectZzdp = super.zzdp();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            jSONObjectZzdp.put("Response Info", "null");
        } else {
            jSONObjectZzdp.put("Response Info", responseInfo.zzdp());
        }
        return jSONObjectZzdp;
    }
}
