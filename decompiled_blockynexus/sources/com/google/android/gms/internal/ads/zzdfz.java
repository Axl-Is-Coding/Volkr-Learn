package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfz implements zzdgx<zzdfw> {
    private final ScheduledExecutorService zzfmv;
    private final zzdok zzfsk;
    private final zzdzb zzgcz;
    private final zzcyy zzgqy;
    private String zzgup;
    private final zzcza zzgxj;
    private final Context zzvr;

    public zzdfz(zzdzb zzdzbVar, ScheduledExecutorService scheduledExecutorService, String str, zzcza zzczaVar, Context context, zzdok zzdokVar, zzcyy zzcyyVar) {
        this.zzgcz = zzdzbVar;
        this.zzfmv = scheduledExecutorService;
        this.zzgup = str;
        this.zzgxj = zzczaVar;
        this.zzvr = context;
        this.zzfsk = zzdokVar;
        this.zzgqy = zzcyyVar;
    }

    final /* synthetic */ zzdzc zza(String str, List list, Bundle bundle) throws Exception {
        zzbcg zzbcgVar = new zzbcg();
        this.zzgqy.zzgo(str);
        zzaph zzaphVarZzgp = this.zzgqy.zzgp(str);
        if (zzaphVarZzgp == null) {
            throw new NullPointerException();
        }
        zzaphVarZzgp.zza(ObjectWrapper.wrap(this.zzvr), this.zzgup, bundle, (Bundle) list.get(0), this.zzfsk.zzbpf, new zzczg(str, zzaphVarZzgp, zzbcgVar));
        return zzbcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdfw> zzarj() {
        return ((Boolean) zzwm.zzpx().zzd(zzabb.zzcqc)).booleanValue() ? zzdyq.zza(new zzdyb(this) { // from class: com.google.android.gms.internal.ads.zzdfy
            private final zzdfz zzgxi;

            {
                this.zzgxi = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdzc zzarv() {
                return this.zzgxi.zzarw();
            }
        }, this.zzgcz) : zzdyq.zzaf(null);
    }

    final /* synthetic */ zzdzc zzarw() {
        Map<String, List<Bundle>> mapZzt = this.zzgxj.zzt(this.zzgup, this.zzfsk.zzhfb);
        final ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Bundle>> entry : mapZzt.entrySet()) {
            final String key = entry.getKey();
            final List<Bundle> value = entry.getValue();
            Bundle bundle = this.zzfsk.zzhfa.zzchi;
            final Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
            arrayList.add(zzdyl.zzg(zzdyq.zza(new zzdyb(this, key, value, bundle2) { // from class: com.google.android.gms.internal.ads.zzdgb
                private final String zzdgm;
                private final zzdfz zzgxi;
                private final List zzgxk;
                private final Bundle zzgxl;

                {
                    this.zzgxi = this;
                    this.zzdgm = key;
                    this.zzgxk = value;
                    this.zzgxl = bundle2;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdzc zzarv() {
                    return this.zzgxi.zza(this.zzdgm, this.zzgxk, this.zzgxl);
                }
            }, this.zzgcz)).zza(((Long) zzwm.zzpx().zzd(zzabb.zzcqb)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv).zza(Throwable.class, new zzdvu(key) { // from class: com.google.android.gms.internal.ads.zzdga
                private final String zzdgt;

                {
                    this.zzdgt = key;
                }

                @Override // com.google.android.gms.internal.ads.zzdvu
                public final Object apply(Object obj) {
                    String strValueOf = String.valueOf(this.zzdgt);
                    zzbbq.zzfc(strValueOf.length() != 0 ? "Error calling adapter: ".concat(strValueOf) : new String("Error calling adapter: "));
                    return null;
                }
            }, this.zzgcz));
        }
        return zzdyq.zzk(arrayList).zza(new Callable(arrayList) { // from class: com.google.android.gms.internal.ads.zzdgd
            private final List zzgxm;

            {
                this.zzgxm = arrayList;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzdzc> list = this.zzgxm;
                JSONArray jSONArray = new JSONArray();
                for (zzdzc zzdzcVar : list) {
                    if (((JSONObject) zzdzcVar.get()) != null) {
                        jSONArray.put(zzdzcVar.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzdfw(jSONArray.toString());
            }
        }, this.zzgcz);
    }
}
