package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzatm implements Callable<zzatl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzatn zzdvl;

    zzatm(zzatn zzatnVar, Context context) {
        this.zzdvl = zzatnVar;
        this.val$context = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzatl call() throws java.lang.Exception {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzatn r0 = r6.zzdvl
            java.util.WeakHashMap r0 = com.google.android.gms.internal.ads.zzatn.zza(r0)
            android.content.Context r1 = r6.val$context
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.zzatp r0 = (com.google.android.gms.internal.ads.zzatp) r0
            if (r0 == 0) goto L3e
            long r1 = r0.zzdvp
            com.google.android.gms.internal.ads.zzaci<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzaco.zzdam
            java.lang.Object r3 = r3.get()
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            long r1 = r1 + r3
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzky()
            long r3 = r3.currentTimeMillis()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L2d
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r1 != 0) goto L3e
            com.google.android.gms.internal.ads.zzatk r1 = new com.google.android.gms.internal.ads.zzatk
            android.content.Context r2 = r6.val$context
            com.google.android.gms.internal.ads.zzatl r0 = r0.zzdvq
            r1.<init>(r2, r0)
            com.google.android.gms.internal.ads.zzatl r0 = r1.zzvn()
            goto L49
        L3e:
            com.google.android.gms.internal.ads.zzatk r0 = new com.google.android.gms.internal.ads.zzatk
            android.content.Context r1 = r6.val$context
            r0.<init>(r1)
            com.google.android.gms.internal.ads.zzatl r0 = r0.zzvn()
        L49:
            com.google.android.gms.internal.ads.zzatn r1 = r6.zzdvl
            java.util.WeakHashMap r1 = com.google.android.gms.internal.ads.zzatn.zza(r1)
            android.content.Context r2 = r6.val$context
            com.google.android.gms.internal.ads.zzatp r3 = new com.google.android.gms.internal.ads.zzatp
            com.google.android.gms.internal.ads.zzatn r4 = r6.zzdvl
            r3.<init>(r4, r0)
            r1.put(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatm.call():java.lang.Object");
    }
}
