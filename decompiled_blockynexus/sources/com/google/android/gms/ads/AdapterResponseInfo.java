package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzvr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class AdapterResponseInfo {
    private final zzvr zzadf;
    private final AdError zzadg;

    private AdapterResponseInfo(zzvr zzvrVar) {
        this.zzadf = zzvrVar;
        zzva zzvaVar = zzvrVar.zzcid;
        this.zzadg = zzvaVar == null ? null : zzvaVar.zzph();
    }

    public static AdapterResponseInfo zza(zzvr zzvrVar) {
        if (zzvrVar != null) {
            return new AdapterResponseInfo(zzvrVar);
        }
        return null;
    }

    public final AdError getAdError() {
        return this.zzadg;
    }

    public final String getAdapterClassName() {
        return this.zzadf.zzcib;
    }

    public final Bundle getCredentials() {
        return this.zzadf.zzcie;
    }

    public final long getLatencyMillis() {
        return this.zzadf.zzcic;
    }

    public final String toString() {
        try {
            return zzdp().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzdp() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zzadf.zzcib);
        jSONObject.put("Latency", this.zzadf.zzcic);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zzadf.zzcie.keySet()) {
            jSONObject2.put(str, this.zzadf.zzcie.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzadg;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzdp());
        }
        return jSONObject;
    }
}
