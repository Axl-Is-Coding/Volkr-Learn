package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcot implements zzeoy<List<String>> {
    public static zzcot zzaps() {
        return zzcow.zzgjn;
    }

    public static List<String> zzapt() {
        List<String> listZzrg = zzabb.zzrg();
        zzepe.zza(listZzrg, "Cannot return null from a non-@Nullable @Provides method");
        return listZzrg;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzapt();
    }
}
