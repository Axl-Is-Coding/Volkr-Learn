package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzebs implements zzdzv {
    private static final byte[] zzhvu = new byte[0];
    private final zzefe zzhvv;
    private final zzdzv zzhvw;

    public zzebs(zzefe zzefeVar, zzdzv zzdzvVar) {
        this.zzhvv = zzefeVar;
        this.zzhvw = zzdzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzv
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzear.zzb(this.zzhvv).toByteArray();
        byte[] bArrZzc = this.zzhvw.zzc(byteArray, zzhvu);
        byte[] bArrZzc2 = ((zzdzv) zzear.zza(this.zzhvv.zzbbt(), byteArray, zzdzv.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(bArrZzc.length + 4 + bArrZzc2.length).putInt(bArrZzc.length).put(bArrZzc).put(bArrZzc2).array();
    }
}
