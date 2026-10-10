package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzear;
import java.security.GeneralSecurityException;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeaw implements zzear.zza {
    private final /* synthetic */ zzeas zzhvc;
    private final /* synthetic */ zzeag zzhvd;

    zzeaw(zzeas zzeasVar, zzeag zzeagVar) {
        this.zzhvc = zzeasVar;
        this.zzhvd = zzeagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Set<Class<?>> zzayp() {
        return this.zzhvc.zzayp();
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final zzeab<?> zzayy() {
        zzeas zzeasVar = this.zzhvc;
        return new zzeap(zzeasVar, this.zzhvd, zzeasVar.zzayq());
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Class<?> zzayz() {
        return this.zzhvc.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final Class<?> zzaza() {
        return this.zzhvd.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzear.zza
    public final <Q> zzeab<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzeap(this.zzhvc, this.zzhvd, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }
}
