package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdr implements zzeoy<zzcae> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdnv> zzfrj;

    public zzcdr(zzeph<Context> zzephVar, zzeph<zzdnv> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzfrj = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcae zzcaeVar = new zzcae(this.zzesu.get(), new HashSet(), this.zzfrj.get());
        zzepe.zza(zzcaeVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcaeVar;
    }
}
