package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmx implements zzeoy<Set<zzcab<zzbuz>>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbmu> zzfop;
    private final zzeph<JSONObject> zzfoq;

    private zzbmx(zzeph<zzbmu> zzephVar, zzeph<Executor> zzephVar2, zzeph<JSONObject> zzephVar3) {
        this.zzfop = zzephVar;
        this.zzesr = zzephVar2;
        this.zzfoq = zzephVar3;
    }

    public static zzbmx zza(zzeph<zzbmu> zzephVar, zzeph<Executor> zzephVar2, zzeph<JSONObject> zzephVar3) {
        return new zzbmx(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set setEmptySet = this.zzfoq.get() == null ? Collections.emptySet() : Collections.singleton(new zzcab(this.zzfop.get(), this.zzesr.get()));
        zzepe.zza(setEmptySet, "Cannot return null from a non-@Nullable @Provides method");
        return setEmptySet;
    }
}
