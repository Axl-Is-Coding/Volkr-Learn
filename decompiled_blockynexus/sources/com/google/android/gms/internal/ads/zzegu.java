package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzegu implements zzeac {
    private static final byte[] zzhvu = new byte[0];
    private final String zzice;
    private final byte[] zzicf;
    private final zzegz zzicg;
    private final zzegs zzich;
    private final zzegw zzici;

    public zzegu(ECPublicKey eCPublicKey, byte[] bArr, String str, zzegz zzegzVar, zzegs zzegsVar) throws GeneralSecurityException {
        zzegy.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzici = new zzegw(eCPublicKey);
        this.zzicf = bArr;
        this.zzice = str;
        this.zzicg = zzegzVar;
        this.zzich = zzegsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeac
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzegv zzegvVarZza = this.zzici.zza(this.zzice, this.zzicf, bArr2, this.zzich.zzazc(), this.zzicg);
        byte[] bArrZzc = this.zzich.zzn(zzegvVarZza.zzbdp()).zzc(bArr, zzhvu);
        byte[] bArrZzbdo = zzegvVarZza.zzbdo();
        return ByteBuffer.allocate(bArrZzbdo.length + bArrZzc.length).put(bArrZzbdo).put(bArrZzc).array();
    }
}
