package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcxn implements zzcas {
    private final /* synthetic */ zzdnv zzgqc;
    private final /* synthetic */ zzdog zzgqp;
    private final /* synthetic */ zzctc zzgqq;
    final /* synthetic */ zzcxl zzgqr;

    zzcxn(zzcxl zzcxlVar, zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) {
        this.zzgqr = zzcxlVar;
        this.zzgqp = zzdogVar;
        this.zzgqc = zzdnvVar;
        this.zzgqq = zzctcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcas
    public final void onInitializationSucceeded() {
        Executor executor = this.zzgqr.zzfoc;
        final zzdog zzdogVar = this.zzgqp;
        final zzdnv zzdnvVar = this.zzgqc;
        final zzctc zzctcVar = this.zzgqq;
        executor.execute(new Runnable(this, zzdogVar, zzdnvVar, zzctcVar) { // from class: com.google.android.gms.internal.ads.zzcxq
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzcxn zzgqw;
            private final zzctc zzgqx;

            {
                this.zzgqw = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
                this.zzgqx = zzctcVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcxn zzcxnVar = this.zzgqw;
                zzdog zzdogVar2 = this.zzgcx;
                zzdnv zzdnvVar2 = this.zzfqn;
                zzctc zzctcVar2 = this.zzgqx;
                zzcxl zzcxlVar = zzcxnVar.zzgqr;
                zzcxl.zzc(zzdogVar2, zzdnvVar2, zzctcVar2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcas
    public final void zzdx(int i) {
        String strValueOf = String.valueOf(this.zzgqq.zzcib);
        zzbbq.zzfe(strValueOf.length() != 0 ? "Fail to initialize adapter ".concat(strValueOf) : new String("Fail to initialize adapter "));
    }
}
