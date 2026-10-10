package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzdgo;
import com.google.android.gms.internal.ads.zzvg;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzq {
    private final String zzbqu;
    private final Map<String, String> zzbqv = new TreeMap();
    private String zzbqw;
    private String zzbqx;
    private final Context zzvr;

    public zzq(Context context, String str) {
        this.zzvr = context.getApplicationContext();
        this.zzbqu = str;
    }

    public final String getQuery() {
        return this.zzbqw;
    }

    public final void zza(zzvg zzvgVar, zzbbx zzbbxVar) {
        this.zzbqw = zzvgVar.zzchg.zzbqw;
        Bundle bundle = zzvgVar.zzchi;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 == null) {
            return;
        }
        String str = zzacm.zzdaf.get();
        for (String str2 : bundle2.keySet()) {
            if (str.equals(str2)) {
                this.zzbqx = bundle2.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.zzbqv.put(str2.substring(4), bundle2.getString(str2));
            }
        }
        this.zzbqv.put("SDKVersion", zzbbxVar.zzbre);
        if (zzacm.zzdad.get().booleanValue()) {
            try {
                Bundle bundleZza = zzdgo.zza(this.zzvr, new JSONArray(zzacm.zzdae.get()));
                for (String str3 : bundleZza.keySet()) {
                    this.zzbqv.put(str3, bundleZza.get(str3).toString());
                }
            } catch (JSONException e2) {
                zzbbq.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e2);
            }
        }
    }

    public final String zzlq() {
        return this.zzbqx;
    }

    public final String zzlr() {
        return this.zzbqu;
    }

    public final Map<String, String> zzls() {
        return this.zzbqv;
    }
}
