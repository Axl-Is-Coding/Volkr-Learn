package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzecg implements zzeaq<zzdzz> {
    private static final Logger logger = Logger.getLogger(zzecg.class.getName());

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static class zza implements zzdzz {
        private final zzeao<zzdzz> zzhwe;

        public zza(zzeao<zzdzz> zzeaoVar) {
            this.zzhwe = zzeaoVar;
        }
    }

    zzecg() {
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final /* synthetic */ zzdzz zza(zzeao<zzdzz> zzeaoVar) throws GeneralSecurityException {
        return new zza(zzeaoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final Class<zzdzz> zzayk() {
        return zzdzz.class;
    }
}
