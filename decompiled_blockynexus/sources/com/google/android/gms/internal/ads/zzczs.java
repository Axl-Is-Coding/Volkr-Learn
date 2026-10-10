package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczs implements zzbuh, zzbui, zzbuz, zzbvs, zzux {
    private zzwt zzgth;

    @Override // com.google.android.gms.internal.ads.zzux
    public final synchronized void onAdClicked() {
        if (this.zzgth != null) {
            try {
                this.zzgth.onAdClicked();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdClicked.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final synchronized void onAdClosed() {
        if (this.zzgth != null) {
            try {
                this.zzgth.onAdClosed();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdClosed.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final synchronized void onAdImpression() {
        if (this.zzgth != null) {
            try {
                this.zzgth.onAdImpression();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdImpression.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final synchronized void onAdLeftApplication() {
        if (this.zzgth != null) {
            try {
                this.zzgth.onAdLeftApplication();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdLeftApplication.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final synchronized void onAdLoaded() {
        if (this.zzgth != null) {
            try {
                this.zzgth.onAdLoaded();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdLoaded.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final synchronized void onAdOpened() {
        if (this.zzgth != null) {
            try {
                this.zzgth.onAdOpened();
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception at onAdOpened.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
    }

    public final synchronized zzwt zzaqt() {
        return this.zzgth;
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(zzatw zzatwVar, String str, String str2) {
    }

    public final synchronized void zzc(zzwt zzwtVar) {
        this.zzgth = zzwtVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0015 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbui
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzk(com.google.android.gms.internal.ads.zzva r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzwt r0 = r2.zzgth     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L11
            com.google.android.gms.internal.ads.zzwt r0 = r2.zzgth     // Catch: android.os.RemoteException -> Lb java.lang.Throwable -> L26
            r0.zzc(r3)     // Catch: android.os.RemoteException -> Lb java.lang.Throwable -> L26
            goto L11
        Lb:
            r0 = move-exception
            java.lang.String r1 = "Remote Exception at onAdFailedToLoadWithAdError."
            com.google.android.gms.internal.ads.zzbbq.zzd(r1, r0)     // Catch: java.lang.Throwable -> L26
        L11:
            com.google.android.gms.internal.ads.zzwt r0 = r2.zzgth     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            com.google.android.gms.internal.ads.zzwt r0 = r2.zzgth     // Catch: android.os.RemoteException -> L1e java.lang.Throwable -> L26
            int r3 = r3.errorCode     // Catch: android.os.RemoteException -> L1e java.lang.Throwable -> L26
            r0.onAdFailedToLoad(r3)     // Catch: android.os.RemoteException -> L1e java.lang.Throwable -> L26
            monitor-exit(r2)
            return
        L1e:
            r3 = move-exception
            java.lang.String r0 = "Remote Exception at onAdFailedToLoad."
            com.google.android.gms.internal.ads.zzbbq.zzd(r0, r3)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r2)
            return
        L26:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczs.zzk(com.google.android.gms.internal.ads.zzva):void");
    }
}
