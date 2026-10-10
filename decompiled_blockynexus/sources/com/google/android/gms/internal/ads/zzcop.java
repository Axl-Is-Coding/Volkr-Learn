package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcop implements zzeoy<zzdzc<String>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzeg> zzfnq;
    private final zzeph<zzdzb> zzftu;

    private zzcop(zzeph<zzeg> zzephVar, zzeph<Context> zzephVar2, zzeph<zzdzb> zzephVar3) {
        this.zzfnq = zzephVar;
        this.zzesu = zzephVar2;
        this.zzftu = zzephVar3;
    }

    public static zzcop zzp(zzeph<zzeg> zzephVar, zzeph<Context> zzephVar2, zzeph<zzdzb> zzephVar3) {
        return new zzcop(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        final zzeg zzegVar = this.zzfnq.get();
        final Context context = this.zzesu.get();
        zzdzc zzdzcVarSubmit = this.zzftu.get().submit(new Callable(zzegVar, context) { // from class: com.google.android.gms.internal.ads.zzcoq
            private final Context zzckh;
            private final zzeg zzgjl;

            {
                this.zzgjl = zzegVar;
                this.zzckh = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzeg zzegVar2 = this.zzgjl;
                return zzegVar2.zzca().zzb(this.zzckh);
            }
        });
        zzepe.zza(zzdzcVarSubmit, "Cannot return null from a non-@Nullable @Provides method");
        return zzdzcVarSubmit;
    }
}
