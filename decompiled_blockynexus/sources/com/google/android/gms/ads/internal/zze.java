package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzalx;
import com.google.android.gms.internal.ads.zzama;
import com.google.android.gms.internal.ads.zzamb;
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzdzc;
import com.google.android.gms.internal.ads.zzwm;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zze {
    private long zzbop = 0;
    private Context zzvr;

    public final void zza(Context context, zzbbx zzbbxVar, String str, Runnable runnable) {
        zza(context, zzbbxVar, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzbbx zzbbxVar, String str, zzaxy zzaxyVar) {
        zza(context, zzbbxVar, false, zzaxyVar, zzaxyVar != null ? zzaxyVar.zzwh() : null, str, null);
    }

    @VisibleForTesting
    private final void zza(Context context, zzbbx zzbbxVar, boolean z, zzaxy zzaxyVar, String str, String str2, Runnable runnable) {
        if (zzp.zzky().elapsedRealtime() - this.zzbop < 5000) {
            zzbbq.zzfe("Not retrying to fetch app settings");
            return;
        }
        this.zzbop = zzp.zzky().elapsedRealtime();
        boolean z2 = true;
        if (zzaxyVar != null) {
            if (!(zzp.zzky().currentTimeMillis() - zzaxyVar.zzwe() > ((Long) zzwm.zzpx().zzd(zzabb.zzcst)).longValue()) && zzaxyVar.zzwf()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzbbq.zzfe("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzbbq.zzfe("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zzvr = applicationContext;
            zzamb zzambVarZzb = zzp.zzle().zzb(this.zzvr, zzbbxVar);
            zzalx<JSONObject> zzalxVar = zzama.zzdio;
            zzalt zzaltVarZza = zzambVarZzb.zza("google.afma.config.fetchAppSettings", zzalxVar, zzalxVar);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzdzc zzdzcVarZzi = zzaltVarZza.zzi(jSONObject);
                zzdzc zzdzcVarZzb = zzdyq.zzb(zzdzcVarZzi, zzd.zzboo, zzbbz.zzeeu);
                if (runnable != null) {
                    zzdzcVarZzi.addListener(runnable, zzbbz.zzeeu);
                }
                zzbcc.zza(zzdzcVarZzb, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e2) {
                zzbbq.zzc("Error requesting application settings", e2);
            }
        }
    }
}
