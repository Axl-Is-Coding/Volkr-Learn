package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfh implements zzdgx<zzdfe> {
    private final zzdzb zzguy;
    private final Set<String> zzgvm;
    private final Context zzvr;

    public zzdfh(zzdzb zzdzbVar, Context context, Set<String> set) {
        this.zzguy = zzdzbVar;
        this.zzvr = context;
        this.zzgvm = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdfe> zzarj() {
        return this.zzguy.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfg
            private final zzdfh zzgxc;

            {
                this.zzgxc = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgxc.zzart();
            }
        });
    }

    final /* synthetic */ zzdfe zzart() throws Exception {
        return (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuc)).booleanValue() && zzdfe.zze(this.zzgvm)) ? new zzdfe(com.google.android.gms.ads.internal.zzp.zzlg().getVersion(this.zzvr)) : new zzdfe(null);
    }
}
