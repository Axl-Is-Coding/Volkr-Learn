package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzecw implements zzeaq<zzeam> {
    private static final Logger logger = Logger.getLogger(zzecw.class.getName());

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static class zza implements zzeam {
        private final zzeao<zzeam> zzhwe;
        private final byte[] zzhwp;

        private zza(zzeao<zzeam> zzeaoVar) {
            this.zzhwp = new byte[]{0};
            this.zzhwe = zzeaoVar;
        }

        @Override // com.google.android.gms.internal.ads.zzeam
        public final byte[] zzm(byte[] bArr) throws GeneralSecurityException {
            return this.zzhwe.zzayx().zzayv().equals(zzefv.LEGACY) ? zzegl.zza(this.zzhwe.zzayx().zzayw(), this.zzhwe.zzayx().zzayt().zzm(zzegl.zza(bArr, this.zzhwp))) : zzegl.zza(this.zzhwe.zzayx().zzayw(), this.zzhwe.zzayx().zzayt().zzm(bArr));
        }
    }

    zzecw() {
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final /* synthetic */ zzeam zza(zzeao<zzeam> zzeaoVar) throws GeneralSecurityException {
        return new zza(zzeaoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final Class<zzeam> zzayk() {
        return zzeam.class;
    }
}
