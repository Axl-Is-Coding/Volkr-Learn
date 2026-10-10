package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbl implements zzdya<zzatc, zzdbm> {
    private Executor executor;
    private zzcpc zzguu;

    public zzdbl(Executor executor, zzcpc zzcpcVar) {
        this.executor = executor;
        this.zzguu = zzcpcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final /* synthetic */ zzdzc<zzdbm> zzf(zzatc zzatcVar) throws Exception {
        final zzatc zzatcVar2 = zzatcVar;
        return zzdyq.zzb(this.zzguu.zzg(zzatcVar2), new zzdya(zzatcVar2) { // from class: com.google.android.gms.internal.ads.zzdbk
            private final zzatc zzfvc;

            {
                this.zzfvc = zzatcVar2;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return zzdyq.zzaf(new zzdbm(new JsonReader(new InputStreamReader((InputStream) obj))).zzo(this.zzfvc.zzdty));
            }
        }, this.executor);
    }
}
