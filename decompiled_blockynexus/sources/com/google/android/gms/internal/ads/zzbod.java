package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbod implements zzeoy<zzua.zza.EnumC0120zza> {
    public static zzbod zzaia() {
        return zzbog.zzfpq;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzua.zza.EnumC0120zza enumC0120zza = zzua.zza.EnumC0120zza.APP_OPEN;
        zzepe.zza(enumC0120zza, "Cannot return null from a non-@Nullable @Provides method");
        return enumC0120zza;
    }
}
