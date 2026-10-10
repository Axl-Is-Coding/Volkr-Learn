package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzarb;
import com.google.android.gms.internal.ads.zzux;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs extends zzarb {
    private Activity zzaas;
    private AdOverlayInfoParcel zzdpw;
    private boolean zzdou = false;
    private boolean zzdpx = false;

    public zzs(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdpw = adOverlayInfoParcel;
        this.zzaas = activity;
    }

    private final synchronized void zzvc() {
        if (!this.zzdpx) {
            if (this.zzdpw.zzdpm != null) {
                this.zzdpw.zzdpm.zzum();
            }
            this.zzdpx = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onBackPressed() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onCreate(Bundle bundle) {
        zzp zzpVar;
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdpw;
        if (adOverlayInfoParcel == null) {
            this.zzaas.finish();
            return;
        }
        if (z) {
            this.zzaas.finish();
            return;
        }
        if (bundle == null) {
            zzux zzuxVar = adOverlayInfoParcel.zzcgv;
            if (zzuxVar != null) {
                zzuxVar.onAdClicked();
            }
            if (this.zzaas.getIntent() != null && this.zzaas.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzpVar = this.zzdpw.zzdpm) != null) {
                zzpVar.zzun();
            }
        }
        com.google.android.gms.ads.internal.zzp.zzkp();
        Activity activity = this.zzaas;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdpw;
        if (zza.zza(activity, adOverlayInfoParcel2.zzdpl, adOverlayInfoParcel2.zzdpq)) {
            return;
        }
        this.zzaas.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onDestroy() throws RemoteException {
        if (this.zzaas.isFinishing()) {
            zzvc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onPause() throws RemoteException {
        zzp zzpVar = this.zzdpw.zzdpm;
        if (zzpVar != null) {
            zzpVar.onPause();
        }
        if (this.zzaas.isFinishing()) {
            zzvc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onRestart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onResume() throws RemoteException {
        if (this.zzdou) {
            this.zzaas.finish();
            return;
        }
        this.zzdou = true;
        zzp zzpVar = this.zzdpw.zzdpm;
        if (zzpVar != null) {
            zzpVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdou);
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onStart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onStop() throws RemoteException {
        if (this.zzaas.isFinishing()) {
            zzvc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void zzdq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final boolean zzut() throws RemoteException {
        return false;
    }
}
