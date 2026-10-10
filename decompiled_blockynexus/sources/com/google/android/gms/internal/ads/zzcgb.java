package com.google.android.gms.internal.ads;

import a.a.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgb implements zzbuz {
    private final zzcei zzfxu;
    private final zzcem zzfyv;

    public zzcgb(zzcei zzceiVar, zzcem zzcemVar) {
        this.zzfxu = zzceiVar;
        this.zzfyv = zzcemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final void onAdImpression() {
        if (this.zzfxu.zzamh() == null) {
            return;
        }
        zzbgj zzbgjVarZzamg = this.zzfxu.zzamg();
        zzbgj zzbgjVarZzamf = this.zzfxu.zzamf();
        if (zzbgjVarZzamg == null) {
            zzbgjVarZzamg = zzbgjVarZzamf != null ? zzbgjVarZzamf : null;
        }
        if (!this.zzfyv.zzalw() || zzbgjVarZzamg == null) {
            return;
        }
        zzbgjVarZzamg.zza("onSdkImpression", new b());
    }
}
