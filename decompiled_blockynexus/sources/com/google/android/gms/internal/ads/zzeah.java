package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeah {
    private final zzefj zzhui;

    private zzeah(zzefj zzefjVar) {
        this.zzhui = zzefjVar;
    }

    static final zzeah zza(zzefj zzefjVar) throws GeneralSecurityException {
        if (zzefjVar == null || zzefjVar.zzbci() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzeah(zzefjVar);
    }

    public final String toString() {
        return zzeay.zzb(this.zzhui).toString();
    }

    final zzefj zzays() {
        return this.zzhui;
    }
}
