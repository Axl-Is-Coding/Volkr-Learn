package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeck implements zzeac {
    private final zzeao<zzeac> zzhwe;

    public zzeck(zzeao<zzeac> zzeaoVar) {
        this.zzhwe = zzeaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeac
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzegl.zza(this.zzhwe.zzayx().zzayw(), this.zzhwe.zzayx().zzayt().zzc(bArr, bArr2));
    }
}
