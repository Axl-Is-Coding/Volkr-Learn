package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczn implements zzbwl {
    private final AtomicReference<zzyi> zzgtc = new AtomicReference<>();

    public final void zzb(zzyi zzyiVar) {
        this.zzgtc.set(zzyiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void zzb(final zzvp zzvpVar) {
        zzdll.zza(this.zzgtc, new zzdlk(zzvpVar) { // from class: com.google.android.gms.internal.ads.zzczq
            private final zzvp zzfvm;

            {
                this.zzfvm = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdlk
            public final void zzq(Object obj) throws RemoteException {
                ((zzyi) obj).zza(this.zzfvm);
            }
        });
    }
}
