package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccr implements zzeoy<zzccs> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzawo> zzfmk;
    private final zzeph<View> zzfnp;
    private final zzeph<zzua.zza.EnumC0120zza> zzfow;
    private final zzeph<zzawp> zzfrp;

    private zzccr(zzeph<zzawp> zzephVar, zzeph<Context> zzephVar2, zzeph<zzawo> zzephVar3, zzeph<View> zzephVar4, zzeph<zzua.zza.EnumC0120zza> zzephVar5) {
        this.zzfrp = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfmk = zzephVar3;
        this.zzfnp = zzephVar4;
        this.zzfow = zzephVar5;
    }

    public static zzccr zzd(zzeph<zzawp> zzephVar, zzeph<Context> zzephVar2, zzeph<zzawo> zzephVar3, zzeph<View> zzephVar4, zzeph<zzua.zza.EnumC0120zza> zzephVar5) {
        return new zzccr(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzccs(this.zzfrp.get(), this.zzesu.get(), this.zzfmk.get(), this.zzfnp.get(), this.zzfow.get());
    }
}
