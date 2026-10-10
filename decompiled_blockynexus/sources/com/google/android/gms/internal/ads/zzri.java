package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzri implements Runnable {
    private final /* synthetic */ zzrf zzbtc;

    zzri(zzrf zzrfVar) {
        this.zzbtc = zzrfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzbtc.lock) {
            if (this.zzbtc.foreground && this.zzbtc.zzbsu) {
                zzrf.zza(this.zzbtc, false);
                zzbbq.zzef("App went background");
                Iterator it = this.zzbtc.zzbsv.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzrh) it.next()).zzp(false);
                    } catch (Exception e2) {
                        zzbbq.zzc("", e2);
                    }
                }
            } else {
                zzbbq.zzef("App is still foreground");
            }
        }
    }
}
