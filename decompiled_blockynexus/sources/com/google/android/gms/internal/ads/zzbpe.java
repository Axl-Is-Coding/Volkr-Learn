package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpe implements zzeoy<Set<zzcab<zzbvs>>> {
    private final zzeph<zzbqf> zzfpj;
    private final zzbot zzfqp;

    public zzbpe(zzbot zzbotVar, zzeph<zzbqf> zzephVar) {
        this.zzfqp = zzbotVar;
        this.zzfpj = zzephVar;
    }

    public static Set<zzcab<zzbvs>> zza(zzbot zzbotVar, zzbqf zzbqfVar) {
        Set<zzcab<zzbvs>> setSingleton = Collections.singleton(new zzcab(zzbqfVar, zzbbz.zzeeu));
        zzepe.zza(setSingleton, "Cannot return null from a non-@Nullable @Provides method");
        return setSingleton;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqp, this.zzfpj.get());
    }
}
