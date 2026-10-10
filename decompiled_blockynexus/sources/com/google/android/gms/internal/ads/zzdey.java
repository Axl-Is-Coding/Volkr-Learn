package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdey implements zzdgx<zzdez> {
    private final PackageInfo zzdqs;
    private final zzayr zzdzr;
    private final zzdok zzfsk;
    private final zzdzb zzgcz;

    public zzdey(zzdzb zzdzbVar, zzdok zzdokVar, PackageInfo packageInfo, zzayr zzayrVar) {
        this.zzgcz = zzdzbVar;
        this.zzfsk = zzdokVar;
        this.zzdqs = packageInfo;
        this.zzdzr = zzayrVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zza(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdey.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdez> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfb
            private final zzdey zzgwz;

            {
                this.zzgwz = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwz.zzars();
            }
        });
    }

    final /* synthetic */ zzdez zzars() throws Exception {
        final ArrayList<String> arrayList = this.zzfsk.zzhfc;
        return arrayList == null ? zzdfa.zzgwy : arrayList.isEmpty() ? zzdfd.zzgwy : new zzdez(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzdfc
            private final zzdey zzgwz;
            private final ArrayList zzgxa;

            {
                this.zzgwz = this;
                this.zzgxa = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Bundle bundle) {
                this.zzgwz.zza(this.zzgxa, bundle);
            }
        };
    }
}
