package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmz {
    private final Executor executor;
    private final String packageName;
    private final String zzbre;
    private final zzbbu zzedh;
    private final boolean zzghp;
    private final Context zzvr;
    private final String zzcyu = zzacp.zzdao.get();
    private final Map<String, String> zzghi = new HashMap();

    public zzcmz(Executor executor, zzbbu zzbbuVar, Context context, zzbbx zzbbxVar) {
        this.executor = executor;
        this.zzedh = zzbbuVar;
        this.zzvr = context;
        this.packageName = context.getPackageName();
        this.zzghp = ((double) zzwm.zzqa().nextFloat()) <= zzacp.zzdan.get().doubleValue();
        this.zzbre = zzbbxVar.zzbre;
        this.zzghi.put(au.ax, "gmob_sdk");
        this.zzghi.put("v", "3");
        this.zzghi.put(au.w, Build.VERSION.RELEASE);
        this.zzghi.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzghi;
        com.google.android.gms.ads.internal.zzp.zzkr();
        map.put("device", zzayu.zzxt());
        this.zzghi.put("app", this.packageName);
        Map<String, String> map2 = this.zzghi;
        com.google.android.gms.ads.internal.zzp.zzkr();
        map2.put("is_lite_sdk", zzayu.zzaz(this.zzvr) ? "1" : "0");
        this.zzghi.put("e", TextUtils.join(",", zzabb.zzrh()));
        this.zzghi.put("sdkVersion", this.zzbre);
    }

    public final Map<String, String> zzapg() {
        return new HashMap(this.zzghi);
    }

    public final ConcurrentHashMap<String, String> zzaph() {
        return new ConcurrentHashMap<>(this.zzghi);
    }

    final /* synthetic */ void zzgi(String str) {
        this.zzedh.zzes(str);
    }

    final void zzn(Map<String, String> map) {
        final String strZzo = zzo(map);
        if (this.zzghp) {
            this.executor.execute(new Runnable(this, strZzo) { // from class: com.google.android.gms.internal.ads.zzcnc
                private final String zzdgm;
                private final zzcmz zzghs;

                {
                    this.zzghs = this;
                    this.zzdgm = strZzo;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzghs.zzgi(this.zzdgm);
                }
            });
        }
        zzayp.zzei(strZzo);
    }

    final String zzo(Map<String, String> map) {
        Uri.Builder builderBuildUpon = Uri.parse(this.zzcyu).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }
}
