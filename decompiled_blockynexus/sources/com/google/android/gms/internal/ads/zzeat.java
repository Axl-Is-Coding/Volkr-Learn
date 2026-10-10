package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzear;
import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeat implements zzear.zza {
    private final /* synthetic */ zzeag zzhuz;

    zzeat(zzeag zzeagVar) {
        this.zzhuz = zzeagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Set<Class<?>> zzayp() {
        return this.zzhuz.zzayp();
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final zzeab<?> zzayy() {
        zzeag zzeagVar = this.zzhuz;
        return new zzeae(zzeagVar, zzeagVar.zzayq());
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Class<?> zzayz() {
        return this.zzhuz.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Class<?> zzaza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final <Q> zzeab<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzeae(this.zzhuz, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }
}
