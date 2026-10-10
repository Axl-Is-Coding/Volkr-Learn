package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdko extends zzxf implements com.google.android.gms.ads.internal.overlay.zzp, zzbwb, zzsc {
    private final String zzbuu;
    private final zzbix zzgpt;
    private final Context zzgsl;
    private AtomicBoolean zzgzs = new AtomicBoolean();
    private final zzdkc zzgzu;
    private long zzgzv;
    private zzbnh zzgzw;
    private final zzdkm zzhay;
    protected zzboh zzhaz;

    public zzdko(zzbix zzbixVar, Context context, String str, zzdkm zzdkmVar, zzdkc zzdkcVar) {
        this.zzgpt = zzbixVar;
        this.zzgsl = context;
        this.zzbuu = str;
        this.zzhay = zzdkmVar;
        this.zzgzu = zzdkcVar;
        zzdkcVar.zza((zzbwb) this);
        zzdkcVar.zza((com.google.android.gms.ads.internal.overlay.zzp) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaso, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzasu() {
        if (this.zzgzs.compareAndSet(false, true)) {
            this.zzgzu.onAdClosed();
            if (this.zzgzw != null) {
                com.google.android.gms.ads.internal.zzp.zzku().zzb(this.zzgzw);
            }
            if (this.zzhaz != null) {
                this.zzhaz.zzfd(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgzv);
            }
            destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhaz != null) {
            this.zzhaz.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String getAdUnitId() {
        return this.zzbuu;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzyo getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized boolean isLoading() {
        return this.zzhay.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzari zzariVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaro zzaroVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaug zzaugVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvs zzvsVar) {
        this.zzhay.zza(zzvsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwo zzwoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwt zzwtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxj zzxjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxk zzxkVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyi zzyiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyu zzyuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwb
    public final synchronized void zzajx() {
        if (this.zzhaz == null) {
            return;
        }
        this.zzgzv = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
        int iZzaho = this.zzhaz.zzaho();
        if (iZzaho <= 0) {
            return;
        }
        this.zzgzw = new zzbnh(this.zzgpt.zzadj(), com.google.android.gms.ads.internal.zzp.zzky());
        this.zzgzw.zza(iZzaho, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkq
            private final zzdko zzhba;

            {
                this.zzhba = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhba.zzast();
            }
        });
    }

    final /* synthetic */ void zzast() {
        this.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdkr
            private final zzdko zzhba;

            {
                this.zzhba = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhba.zzasu();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zzkf() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzvn zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String zzkh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzyn zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzxk zzkj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzwt zzkk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzmt() {
        zzasu();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        zzasu();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized boolean zza(zzvg zzvgVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (zzayu.zzbe(this.zzgsl) && zzvgVar.zzcho == null) {
            zzbbq.zzfc("Failed to load the ad because app ID is missing.");
            this.zzgzu.zzk(zzdpe.zza(zzdpg.APP_ID_MISSING, null, null));
            return false;
        }
        if (isLoading()) {
            return false;
        }
        this.zzgzs = new AtomicBoolean();
        return this.zzhay.zza(zzvgVar, this.zzbuu, new zzdkt(this), new zzdks(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzboh zzbohVar) {
        zzbohVar.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzsh zzshVar) {
        this.zzgzu.zzb(zzshVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzvn zzvnVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzxq zzxqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzaak zzaakVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzaby zzabyVar) {
    }
}
