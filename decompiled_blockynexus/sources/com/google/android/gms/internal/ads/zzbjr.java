package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjr implements zzeoy<zzatq> {
    private final zzeph<Context> zzesu;

    public zzbjr(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Context context = this.zzesu.get();
        zzato zzatoVar = new zzato(context, new zzatv(context).zzvg());
        zzepe.zza(zzatoVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzatoVar;
    }
}
