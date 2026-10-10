package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeba implements zzeaq<zzdzv> {
    private static final Logger logger = Logger.getLogger(zzeba.class.getName());

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static class zza implements zzdzv {
        private final zzeao<zzdzv> zzhvo;

        private zza(zzeao<zzdzv> zzeaoVar) {
            this.zzhvo = zzeaoVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdzv
        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzegl.zza(this.zzhvo.zzayx().zzayw(), this.zzhvo.zzayx().zzayt().zzc(bArr, bArr2));
        }
    }

    zzeba() {
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final /* synthetic */ zzdzv zza(zzeao<zzdzv> zzeaoVar) throws GeneralSecurityException {
        return new zza(zzeaoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final Class<zzdzv> zzayk() {
        return zzdzv.class;
    }
}
