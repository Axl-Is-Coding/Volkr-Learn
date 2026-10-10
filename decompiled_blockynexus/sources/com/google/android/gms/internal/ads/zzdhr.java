package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhr implements zzdgx<zzdho> {
    private final Executor executor;
    private final PackageInfo zzdqs;
    private final zzaxx zzgyr;
    private final String zzgyu;

    public zzdhr(zzaxx zzaxxVar, Executor executor, String str, PackageInfo packageInfo) {
        this.zzgyr = zzaxxVar;
        this.executor = executor;
        this.zzgyu = str;
        this.zzdqs = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdho> zzarj() {
        return zzdyq.zzb(zzdyq.zzb(this.zzgyr.zza(this.zzgyu, this.zzdqs), zzdhq.zzdwz, this.executor), Throwable.class, new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzdht
            private final zzdhr zzgyw;

            {
                this.zzgyw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgyw.zzg((Throwable) obj);
            }
        }, this.executor);
    }

    final /* synthetic */ zzdzc zzg(Throwable th) throws Exception {
        return zzdyq.zzaf(new zzdho(this.zzgyu));
    }
}
