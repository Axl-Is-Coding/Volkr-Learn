package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzk implements zzeoy<Set<zzcab<AppEventListener>>> {
    private final zzbys zzfwg;

    private zzbzk(zzbys zzbysVar) {
        this.zzfwg = zzbysVar;
    }

    public static zzbzk zzx(zzbys zzbysVar) {
        return new zzbzk(zzbysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<AppEventListener>> setZzakk = this.zzfwg.zzakk();
        zzepe.zza(setZzakk, "Cannot return null from a non-@Nullable @Provides method");
        return setZzakk;
    }
}
