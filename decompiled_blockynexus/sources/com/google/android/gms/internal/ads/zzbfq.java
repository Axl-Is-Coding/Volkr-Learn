package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfq implements zzahq<zzbdu> {
    private static Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzbbq.zzfe(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbdu zzbduVar, Map map) {
        zzbfl zzbflVarZza;
        zzbdu zzbduVar2 = zzbduVar;
        if (zzbbq.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String strValueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(strValueOf);
            zzbbq.zzef(sb.toString());
        }
        com.google.android.gms.ads.internal.zzp.zzln();
        if (map.containsKey("abort")) {
            if (zzbfi.zzc(zzbduVar2)) {
                return;
            }
            zzbbq.zzfe("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    String strValueOf2 = String.valueOf(str2);
                    zzbbq.zzfe(strValueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(strValueOf2) : new String("Malformed demuxed URL list for precache: "));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbfi.zzd(zzbduVar2) != null) {
                zzbbq.zzfe("Precache task is already running.");
                return;
            }
            if (zzbduVar2.zzzv() == null) {
                zzbbq.zzfe("Precache requires a dependency provider.");
                return;
            }
            zzbdv zzbdvVar = new zzbdv((String) map.get("flags"));
            Integer numZzb = zzb(map, "player");
            if (numZzb == null) {
                numZzb = 0;
            }
            zzbflVarZza = zzbduVar2.zzzv().zzboi.zza(zzbduVar2, numZzb.intValue(), null, zzbdvVar);
            new zzbfg(zzbduVar2, zzbflVarZza, str, strArr).zzwz();
        } else {
            zzbfg zzbfgVarZzd = zzbfi.zzd(zzbduVar2);
            if (zzbfgVarZzd == null) {
                zzbbq.zzfe("Precache must specify a source.");
                return;
            }
            zzbflVarZza = zzbfgVarZzd.zzelk;
        }
        Integer numZzb2 = zzb(map, "minBufferMs");
        if (numZzb2 != null) {
            zzbflVarZza.zzdl(numZzb2.intValue());
        }
        Integer numZzb3 = zzb(map, "maxBufferMs");
        if (numZzb3 != null) {
            zzbflVarZza.zzdm(numZzb3.intValue());
        }
        Integer numZzb4 = zzb(map, "bufferForPlaybackMs");
        if (numZzb4 != null) {
            zzbflVarZza.zzdn(numZzb4.intValue());
        }
        Integer numZzb5 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb5 != null) {
            zzbflVarZza.zzdo(numZzb5.intValue());
        }
    }
}
