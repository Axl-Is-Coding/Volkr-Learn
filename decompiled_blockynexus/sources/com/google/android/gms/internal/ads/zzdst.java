package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdst {
    private final Executor executor;
    private final zzbbu zzhln;

    public zzdst(Executor executor, zzbbu zzbbuVar) {
        this.executor = executor;
        this.zzhln = zzbbuVar;
    }

    public final void zzes(final String str) {
        this.executor.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzdsw
            private final String zzdgm;
            private final zzdst zzhlp;

            {
                this.zzhlp = this;
                this.zzdgm = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhlp.zzgz(this.zzdgm);
            }
        });
    }

    final /* synthetic */ void zzgz(String str) {
        this.zzhln.zzes(str);
    }

    public final void zzj(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            zzes(it.next());
        }
    }
}
