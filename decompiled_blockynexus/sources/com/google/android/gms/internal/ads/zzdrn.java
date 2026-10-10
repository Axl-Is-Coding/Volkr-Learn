package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrn implements zzeoy<ThreadFactory> {
    public static zzdrn zzavn() {
        return zzdrq.zzhjw;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdqz zzdqzVar = new zzdqz();
        zzepe.zza(zzdqzVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdqzVar;
    }
}
