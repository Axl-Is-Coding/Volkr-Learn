package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcit implements com.google.android.gms.ads.internal.overlay.zzp, com.google.android.gms.ads.internal.overlay.zzv, zzagt, zzagv, zzux {
    private zzux zzcgv;
    private zzagt zzdep;
    private zzagv zzdeq;
    private com.google.android.gms.ads.internal.overlay.zzp zzdpm;
    private com.google.android.gms.ads.internal.overlay.zzv zzdpq;

    private zzcit() {
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final synchronized void onAdClicked() {
        if (this.zzcgv != null) {
            this.zzcgv.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagv
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdeq != null) {
            this.zzdeq.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onPause() {
        if (this.zzdpm != null) {
            this.zzdpm.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onResume() {
        if (this.zzdpm != null) {
            this.zzdpm.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagt
    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzdep != null) {
            this.zzdep.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzum() {
        if (this.zzdpm != null) {
            this.zzdpm.zzum();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzun() {
        if (this.zzdpm != null) {
            this.zzdpm.zzun();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv
    public final synchronized void zzvd() {
        if (this.zzdpq != null) {
            this.zzdpq.zzvd();
        }
    }

    /* synthetic */ zzcit(zzciq zzciqVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zza(zzux zzuxVar, zzagt zzagtVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzv zzvVar) {
        this.zzcgv = zzuxVar;
        this.zzdep = zzagtVar;
        this.zzdpm = zzpVar;
        this.zzdeq = zzagvVar;
        this.zzdpq = zzvVar;
    }
}
