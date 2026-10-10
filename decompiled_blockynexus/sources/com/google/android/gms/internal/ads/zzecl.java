package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecl implements zzegs {
    private final String zzhwf;
    private final int zzhwg;
    private zzedu zzhwh;
    private zzede zzhwi;
    private int zzhwj;

    zzecl(zzefe zzefeVar) throws GeneralSecurityException {
        this.zzhwf = zzefeVar.zzbbt();
        if (this.zzhwf.equals(zzeax.zzhvf)) {
            try {
                zzedx zzedxVarZzl = zzedx.zzl(zzefeVar.zzbbu(), zzejm.zzbft());
                this.zzhwh = (zzedu) zzear.zzb(zzefeVar);
                this.zzhwg = zzedxVarZzl.getKeySize();
                return;
            } catch (zzekj e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (!this.zzhwf.equals(zzeax.zzhve)) {
            String strValueOf = String.valueOf(this.zzhwf);
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(strValueOf) : new String("unsupported AEAD DEM key type: "));
        }
        try {
            zzedh zzedhVarZzf = zzedh.zzf(zzefeVar.zzbbu(), zzejm.zzbft());
            this.zzhwi = (zzede) zzear.zzb(zzefeVar);
            this.zzhwj = zzedhVarZzf.zzazp().getKeySize();
            this.zzhwg = this.zzhwj + zzedhVarZzf.zzazq().getKeySize();
        } catch (zzekj e3) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzegs
    public final int zzazc() {
        return this.zzhwg;
    }

    @Override // com.google.android.gms.internal.ads.zzegs
    public final zzdzv zzn(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzhwg) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.zzhwf.equals(zzeax.zzhvf)) {
            return (zzdzv) zzear.zza(this.zzhwf, (zzedu) zzedu.zzbah().zza(this.zzhwh).zzw(zzeip.zzi(bArr, 0, this.zzhwg)).zzbgt(), zzdzv.class);
        }
        if (!this.zzhwf.equals(zzeax.zzhve)) {
            throw new GeneralSecurityException("unknown DEM key type");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, this.zzhwj);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, this.zzhwj, this.zzhwg);
        zzedi zzediVar = (zzedi) zzedi.zzazt().zza(this.zzhwi.zzazl()).zzu(zzeip.zzu(bArrCopyOfRange)).zzbgt();
        return (zzdzv) zzear.zza(this.zzhwf, (zzede) zzede.zzazn().zzet(this.zzhwi.getVersion()).zzb(zzediVar).zzb((zzeet) zzeet.zzbbl().zza(this.zzhwi.zzazm()).zzad(zzeip.zzu(bArrCopyOfRange2)).zzbgt()).zzbgt(), zzdzv.class);
    }
}
