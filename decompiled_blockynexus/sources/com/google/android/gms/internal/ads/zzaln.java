package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaln implements zzbck<zzaki> {
    final /* synthetic */ zzalm zzdie;

    zzaln(zzalm zzalmVar) {
        this.zzdie = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final /* synthetic */ void zzh(zzaki zzakiVar) {
        final zzaki zzakiVar2 = zzakiVar;
        zzbbz.zzeet.execute(new Runnable(this, zzakiVar2) { // from class: com.google.android.gms.internal.ads.zzalq
            private final zzaln zzdif;
            private final zzaki zzdig;

            {
                this.zzdif = this;
                this.zzdig = zzakiVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaln zzalnVar = this.zzdif;
                zzaki zzakiVar3 = this.zzdig;
                zzalnVar.zzdie.zzdhh.zzh(zzakiVar3);
                zzakiVar3.destroy();
            }
        });
    }
}
