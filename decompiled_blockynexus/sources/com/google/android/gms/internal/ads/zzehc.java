package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzehc implements zzdzv {
    private final zzehl zzidh;
    private final zzeam zzidi;
    private final int zzidj;

    public zzehc(zzehl zzehlVar, zzeam zzeamVar, int i) {
        this.zzidh = zzehlVar;
        this.zzidi = zzeamVar;
        this.zzidj = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdzv
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZzo = this.zzidh.zzo(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzegl.zza(bArrZzo, this.zzidi.zzm(zzegl.zza(bArr2, bArrZzo, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }
}
