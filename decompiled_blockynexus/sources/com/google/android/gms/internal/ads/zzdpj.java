package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpj implements zzayh, zzbui {
    private final zzayi zzdyh;
    private final HashSet<zzaxw> zzhgl = new HashSet<>();
    private final Context zzvr;

    public zzdpj(Context context, zzayi zzayiVar) {
        this.zzvr = context;
        this.zzdyh = zzayiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final synchronized void zza(HashSet<zzaxw> hashSet) {
        this.zzhgl.clear();
        this.zzhgl.addAll(hashSet);
    }

    public final Bundle zzatu() {
        return this.zzdyh.zza(this.zzvr, this);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final synchronized void zzk(zzva zzvaVar) {
        if (zzvaVar.errorCode != 3) {
            this.zzdyh.zzb(this.zzhgl);
        }
    }
}
