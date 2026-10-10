package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.umeng.analytics.pro.au;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabf {
    private String zzbre;
    private String zzcyu = zzacp.zzdao.get();
    private Map<String, String> zzcyv = new LinkedHashMap();
    private Context zzvr;

    public zzabf(Context context, String str) {
        this.zzvr = null;
        this.zzbre = null;
        this.zzvr = context;
        this.zzbre = str;
        this.zzcyv.put(au.ax, "gmob_sdk");
        this.zzcyv.put("v", "3");
        this.zzcyv.put(au.w, Build.VERSION.RELEASE);
        this.zzcyv.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzcyv;
        com.google.android.gms.ads.internal.zzp.zzkr();
        map.put("device", zzayu.zzxt());
        this.zzcyv.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.zzcyv;
        com.google.android.gms.ads.internal.zzp.zzkr();
        map2.put("is_lite_sdk", zzayu.zzaz(context) ? "1" : "0");
        Future<zzatl> futureZzy = com.google.android.gms.ads.internal.zzp.zzlc().zzy(this.zzvr);
        try {
            this.zzcyv.put("network_coarse", Integer.toString(futureZzy.get().zzdus));
            this.zzcyv.put("network_fine", Integer.toString(futureZzy.get().zzdut));
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "CsiConfiguration.CsiConfiguration");
        }
    }

    final Context getContext() {
        return this.zzvr;
    }

    final String zzlu() {
        return this.zzbre;
    }

    final String zzrk() {
        return this.zzcyu;
    }

    final Map<String, String> zzrl() {
        return this.zzcyv;
    }
}
