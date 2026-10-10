package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcqg implements zzbws {
    private final zzawo zzbqq;
    private final Context zzvr;

    zzcqg(Context context, zzawo zzawoVar) {
        this.zzvr = context;
        this.zzbqq = zzawoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(zzdog zzdogVar) {
        if (TextUtils.isEmpty(zzdogVar.zzhew.zzeou.zzdto)) {
            return;
        }
        this.zzbqq.zza(this.zzvr, zzdogVar.zzhev.zzfsk.zzhfa);
        this.zzbqq.zzk(this.zzvr, zzdogVar.zzhew.zzeou.zzdto);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(zzatc zzatcVar) {
    }
}
