package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzva;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int code;
    private final String zzacm;
    private final String zzacn;
    private final AdError zzaco;

    public AdError(int i, String str, String str2) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = null;
    }

    public AdError getCause() {
        return this.zzaco;
    }

    public int getCode() {
        return this.code;
    }

    public String getDomain() {
        return this.zzacn;
    }

    public String getMessage() {
        return this.zzacm;
    }

    public String toString() {
        try {
            return zzdp().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zzva zzdo() {
        AdError adError = this.zzaco;
        return new zzva(this.code, this.zzacm, this.zzacn, adError == null ? null : new zzva(adError.code, adError.zzacm, adError.zzacn, null, null), null);
    }

    public JSONObject zzdp() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.code);
        jSONObject.put("Message", this.zzacm);
        jSONObject.put("Domain", this.zzacn);
        AdError adError = this.zzaco;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzdp());
        }
        return jSONObject;
    }

    public AdError(int i, String str, String str2, AdError adError) {
        this.code = i;
        this.zzacm = str;
        this.zzacn = str2;
        this.zzaco = adError;
    }
}
