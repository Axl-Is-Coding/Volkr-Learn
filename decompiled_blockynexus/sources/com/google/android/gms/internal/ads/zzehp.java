package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzehp implements zzeam {
    private final zzecx zzido;
    private final int zzidp;

    public zzehp(zzecx zzecxVar, int i) throws GeneralSecurityException {
        this.zzido = zzecxVar;
        this.zzidp = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzecxVar.zzd(new byte[0], i);
    }

    @Override // com.google.android.gms.internal.ads.zzeam
    public final byte[] zzm(byte[] bArr) throws GeneralSecurityException {
        return this.zzido.zzd(bArr, this.zzidp);
    }
}
