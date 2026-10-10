package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzakc {
    public static void zza(zzajz zzajzVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzajzVar.zzj(str, jSONObject.toString());
    }

    public static void zzb(zzajz zzajzVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        String strValueOf = String.valueOf(sb.toString());
        zzbbq.zzef(strValueOf.length() != 0 ? "Dispatching AFMA event: ".concat(strValueOf) : new String("Dispatching AFMA event: "));
        zzajzVar.zzdc(sb.toString());
    }

    public static void zza(zzajz zzajzVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzajzVar.zzdc(sb.toString());
    }

    public static void zza(zzajz zzajzVar, String str, Map map) {
        try {
            zzajzVar.zza(str, com.google.android.gms.ads.internal.zzp.zzkr().zzj((Map<String, ?>) map));
        } catch (JSONException unused) {
            zzbbq.zzfe("Could not convert parameters to JSON.");
        }
    }
}
