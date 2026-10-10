package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddq implements zzdgx<zzddr> {
    private final zzdok zzfsk;
    private final zzdzb zzgcz;
    private final String zzgup;
    private final zzckw zzgwl;

    public zzddq(zzdzb zzdzbVar, zzckw zzckwVar, zzdok zzdokVar, String str) {
        this.zzgcz = zzdzbVar;
        this.zzgwl = zzckwVar;
        this.zzfsk = zzdokVar;
        this.zzgup = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzddr> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddt
            private final zzddq zzgwn;

            {
                this.zzgwn = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwn.zzarp();
            }
        });
    }

    final /* synthetic */ zzddr zzarp() throws Exception {
        JSONObject jSONObjectZzq;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsr)).booleanValue() && (jSONObjectZzq = this.zzgwl.zzq(this.zzfsk.zzhfb, this.zzgup)) != null) {
            return new zzddr(jSONObjectZzq.toString());
        }
        return null;
    }
}
