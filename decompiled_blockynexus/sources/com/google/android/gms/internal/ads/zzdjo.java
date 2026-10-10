package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdjo extends zzxf implements com.google.android.gms.ads.internal.overlay.zzw, zzbwb, zzsc {
    private final zzbbx zzbot;
    private final String zzbuu;
    private final ViewGroup zzfpw;
    private final zzbix zzgpt;
    private final Context zzgsl;
    private AtomicBoolean zzgzs = new AtomicBoolean();
    private final zzdjm zzgzt;
    private final zzdkc zzgzu;
    private long zzgzv;
    private zzbnh zzgzw;
    protected zzbnv zzgzx;

    public zzdjo(zzbix zzbixVar, Context context, String str, zzdjm zzdjmVar, zzdkc zzdkcVar, zzbbx zzbbxVar) {
        this.zzfpw = new FrameLayout(context);
        this.zzgpt = zzbixVar;
        this.zzgsl = context;
        this.zzbuu = str;
        this.zzgzt = zzdjmVar;
        this.zzgzu = zzdkcVar;
        zzdkcVar.zza(this);
        this.zzbot = zzbbxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaso, reason: merged with bridge method [inline-methods] */
    public final void zzasr() {
        if (this.zzgzs.compareAndSet(false, true)) {
            zzbnv zzbnvVar = this.zzgzx;
            if (zzbnvVar != null && zzbnvVar.zzahz() != null) {
                this.zzgzu.zzb(this.zzgzx.zzahz());
            }
            this.zzgzu.onAdClosed();
            this.zzfpw.removeAllViews();
            zzbnh zzbnhVar = this.zzgzw;
            if (zzbnhVar != null) {
                com.google.android.gms.ads.internal.zzp.zzku().zzb(zzbnhVar);
            }
            zzbnv zzbnvVar2 = this.zzgzx;
            if (zzbnvVar2 != null) {
                zzbnvVar2.zzfd(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgzv);
            }
            destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzvn zzasp() {
        return zzdoq.zzb(this.zzgsl, Collections.singletonList(this.zzgzx.zzahw()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbnv zzbnvVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbnvVar.zzabc() ? 11 : 9);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzbnv zzbnvVar) {
        zzbnvVar.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgzx != null) {
            this.zzgzx.destroy();
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
        return this.zzgzt.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isReady() {
        return false;
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
    public final void showInterstitial() {
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
        this.zzgzt.zza(zzvsVar);
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
    public final void zzajx() {
        if (this.zzgzx == null) {
            return;
        }
        this.zzgzv = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
        int iZzaho = this.zzgzx.zzaho();
        if (iZzaho <= 0) {
            return;
        }
        this.zzgzw = new zzbnh(this.zzgpt.zzadj(), com.google.android.gms.ads.internal.zzp.zzky());
        this.zzgzw.zza(iZzaho, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjq
            private final zzdjo zzhac;

            {
                this.zzhac = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhac.zzasq();
            }
        });
    }

    final /* synthetic */ void zzasq() {
        this.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdjr
            private final zzdjo zzhac;

            {
                this.zzhac = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhac.zzasr();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfpw);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zzkf() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzvn zzkg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgzx == null) {
            return null;
        }
        return zzdoq.zzb(this.zzgsl, Collections.singletonList(this.zzgzx.zzahw()));
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
        zzasr();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzus() {
        zzasr();
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
        return this.zzgzt.zza(zzvgVar, this.zzbuu, new zzdjt(this), new zzdjs(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.overlay.zzo zza(zzbnv zzbnvVar) {
        boolean zZzabc = zzbnvVar.zzabc();
        int iIntValue = ((Integer) zzwm.zzpx().zzd(zzabb.zzctv)).intValue();
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = new com.google.android.gms.ads.internal.overlay.zzr();
        zzrVar.size = 50;
        zzrVar.paddingLeft = zZzabc ? iIntValue : 0;
        zzrVar.paddingRight = zZzabc ? 0 : iIntValue;
        zzrVar.paddingTop = 0;
        zzrVar.paddingBottom = iIntValue;
        return new com.google.android.gms.ads.internal.overlay.zzo(this.zzgsl, zzrVar, this);
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
