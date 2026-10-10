package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzua;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmb implements zzeoy<Set<zzcab<zzdso>>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<String> zzggp;
    private final zzeph<Map<zzdsf, zzcmg>> zzggq;

    public zzcmb(zzeph<String> zzephVar, zzeph<Context> zzephVar2, zzeph<Executor> zzephVar3, zzeph<Map<zzdsf, zzcmg>> zzephVar4) {
        this.zzggp = zzephVar;
        this.zzesu = zzephVar2;
        this.zzesr = zzephVar3;
        this.zzggq = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setEmptySet;
        final String str = this.zzggp.get();
        Context context = this.zzesu.get();
        Executor executor = this.zzesr.get();
        Map<zzdsf, zzcmg> map = this.zzggq.get();
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctw)).booleanValue()) {
            zzts zztsVar = new zzts(new zztx(context));
            zztsVar.zza(new zztr(str) { // from class: com.google.android.gms.internal.ads.zzcmd
                private final String zzdgt;

                {
                    this.zzdgt = str;
                }

                @Override // com.google.android.gms.internal.ads.zztr
                public final void zza(zzua.zzi.zza zzaVar) {
                    zzaVar.zzcb(this.zzdgt);
                }
            });
            setEmptySet = Collections.singleton(new zzcab(new zzcme(zztsVar, map), executor));
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }
}
