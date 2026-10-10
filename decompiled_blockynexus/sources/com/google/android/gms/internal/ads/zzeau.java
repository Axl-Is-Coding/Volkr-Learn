package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzear;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeau implements zzear.zza {
    private final /* synthetic */ zzeab zzhva;

    zzeau(zzeab zzeabVar) {
        this.zzhva = zzeabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Set<Class<?>> zzayp() {
        return Collections.singleton(this.zzhva.zzayk());
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final zzeab<?> zzayy() {
        return this.zzhva;
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Class<?> zzayz() {
        return this.zzhva.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Class<?> zzaza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final <Q> zzeab<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        if (this.zzhva.zzayk().equals(cls)) {
            return this.zzhva;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }
}
