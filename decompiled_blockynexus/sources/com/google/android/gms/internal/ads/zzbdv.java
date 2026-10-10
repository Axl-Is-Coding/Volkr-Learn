package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdv {
    public final boolean zzeip;
    public final int zzeiq;
    public final int zzeir;
    public final int zzeis;
    private final String zzeit;
    public final int zzeiu;
    public final int zzeiv;
    public final int zzeiw;
    public final int zzeix;
    public final boolean zzeiy;
    public final int zzeiz;

    public zzbdv(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzeip = zza(jSONObject, "aggressive_media_codec_release", zzabb.zzcmt);
        this.zzeiq = zzb(jSONObject, "byte_buffer_precache_limit", zzabb.zzcmb);
        this.zzeir = zzb(jSONObject, "exo_cache_buffer_size", zzabb.zzcmi);
        this.zzeis = zzb(jSONObject, "exo_connect_timeout_millis", zzabb.zzclx);
        this.zzeit = zzc(jSONObject, "exo_player_version", zzabb.zzclw);
        this.zzeiu = zzb(jSONObject, "exo_read_timeout_millis", zzabb.zzcly);
        this.zzeiv = zzb(jSONObject, "load_check_interval_bytes", zzabb.zzclz);
        this.zzeiw = zzb(jSONObject, "player_precache_limit", zzabb.zzcma);
        this.zzeix = zzb(jSONObject, "socket_receive_buffer_size", zzabb.zzcmc);
        this.zzeiy = zza(jSONObject, "use_cache_data_source", zzabb.zzctc);
        this.zzeiz = zzb(jSONObject, "min_retry_count", zzabb.zzcme);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzaaq<Boolean> zzaaqVar) {
        return zza(jSONObject, str, ((Boolean) zzwm.zzpx().zzd(zzaaqVar)).booleanValue());
    }

    private static int zzb(JSONObject jSONObject, String str, zzaaq<Integer> zzaaqVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzwm.zzpx().zzd(zzaaqVar)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzaaq<String> zzaaqVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzwm.zzpx().zzd(zzaaqVar);
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }
}
