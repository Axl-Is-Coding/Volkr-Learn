package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnf {
    public static JSONObject zzb(zzdnv zzdnvVar) {
        try {
            return new JSONObject(zzdnvVar.zzdsv);
        } catch (JSONException unused) {
            return null;
        }
    }
}
