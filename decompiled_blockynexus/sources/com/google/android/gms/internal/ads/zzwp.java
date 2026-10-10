package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzwp extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcji;

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzcji != null) {
                this.zzcji.onAdClosed();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzcji != null) {
                this.zzcji.onAdFailedToLoad(i);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzcji != null) {
                this.zzcji.onAdLeftApplication();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzcji != null) {
                this.zzcji.onAdLoaded();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzcji != null) {
                this.zzcji.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcji = adListener;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.lock) {
            if (this.zzcji != null) {
                this.zzcji.onAdFailedToLoad(loadAdError);
            }
        }
    }
}
