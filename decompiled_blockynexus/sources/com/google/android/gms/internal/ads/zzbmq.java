package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmq implements zzahq<Object> {
    final /* synthetic */ zzbml zzfnt;

    zzbmq(zzbml zzbmlVar) {
        this.zzfnt = zzbmlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfnt.zzm(map)) {
            this.zzfnt.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbmp
                private final zzbmq zzfnu;

                {
                    this.zzfnu = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfnu.zzfnt.zzfnj.zzahh();
                }
            });
        }
    }
}
