package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbys;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczj extends zzxf implements zzbwo {
    private final ViewGroup zzfpw;
    private final zzbix zzgpt;
    private zzboq zzgsg;
    private final Context zzgsl;
    private final zzbwk zzgsu;
    private zzvn zzgsv;
    private zzaby zzgsw;
    private zzdzc<zzboq> zzgsx;
    private final zzczs zzgsq = new zzczs();
    private final zzczp zzgsr = new zzczp();
    private final zzczr zzgss = new zzczr();
    private final zzczn zzgst = new zzczn();
    private final zzdom zzgsm = new zzdom();

    public zzczj(zzbix zzbixVar, Context context, zzvn zzvnVar, String str) {
        this.zzfpw = new FrameLayout(context);
        this.zzgpt = zzbixVar;
        this.zzgsl = context;
        this.zzgsm.zze(zzvnVar).zzgt(str);
        this.zzgsu = zzbixVar.zzadm();
        this.zzgsu.zza(this, this.zzgpt.zzadi());
        this.zzgsv = zzvnVar;
    }

    private final synchronized zzbpm zzb(zzdok zzdokVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcye)).booleanValue()) {
            return this.zzgpt.zzadp().zzd(new zzbtp.zza().zzce(this.zzgsl).zza(zzdokVar).zzajv()).zzd(new zzbys.zza().zzakr()).zza(new zzcyn(this.zzgsw)).zzb(new zzccw(zzcep.zzgap, null)).zza(new zzbqh(this.zzgsu)).zzc(new zzbol(this.zzfpw)).zzaey();
        }
        return this.zzgpt.zzadp().zzd(new zzbtp.zza().zzce(this.zzgsl).zza(zzdokVar).zzajv()).zzd(new zzbys.zza().zza((zzux) this.zzgsq, this.zzgpt.zzadi()).zza(this.zzgsr, this.zzgpt.zzadi()).zza((zzbuh) this.zzgsq, this.zzgpt.zzadi()).zza((zzbvs) this.zzgsq, this.zzgpt.zzadi()).zza((zzbui) this.zzgsq, this.zzgpt.zzadi()).zza(this.zzgss, this.zzgpt.zzadi()).zza(this.zzgst, this.zzgpt.zzadi()).zzakr()).zza(new zzcyn(this.zzgsw)).zzb(new zzccw(zzcep.zzgap, null)).zza(new zzbqh(this.zzgsu)).zzc(new zzbol(this.zzfpw)).zzaey();
    }

    private final synchronized void zzd(zzvn zzvnVar) {
        this.zzgsm.zze(zzvnVar);
        this.zzgsm.zzbo(this.zzgsv.zzcia);
    }

    private final synchronized boolean zzg(zzvg zzvgVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (zzayu.zzbe(this.zzgsl) && zzvgVar.zzcho == null) {
            zzbbq.zzfc("Failed to load the ad because app ID is missing.");
            if (this.zzgsq != null) {
                this.zzgsq.zzk(zzdpe.zza(zzdpg.APP_ID_MISSING, null, null));
            }
            return false;
        }
        if (this.zzgsx != null) {
            return false;
        }
        zzdox.zze(this.zzgsl, zzvgVar.zzche);
        zzdok zzdokVarZzatn = this.zzgsm.zzh(zzvgVar).zzatn();
        if (zzacx.zzdbv.get().booleanValue() && this.zzgsm.zzkg().zzchx && this.zzgsq != null) {
            this.zzgsq.zzk(zzdpe.zza(zzdpg.INVALID_AD_SIZE, null, null));
            return false;
        }
        zzbpm zzbpmVarZzb = zzb(zzdokVarZzatn);
        this.zzgsx = zzbpmVarZzb.zzaev().zzajh();
        zzdyq.zza(this.zzgsx, new zzczm(this, zzbpmVarZzb), this.zzgpt.zzadi());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgsg != null) {
            this.zzgsg.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String getAdUnitId() {
        return this.zzgsm.zzatl();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgsg == null || this.zzgsg.zzaix() == null) {
            return null;
        }
        return this.zzgsg.zzaix().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzyo getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzgsg == null) {
            return null;
        }
        return this.zzgsg.getVideoController();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    @Override // com.google.android.gms.internal.ads.zzxc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isLoading() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdzc<com.google.android.gms.internal.ads.zzboq> r0 = r1.zzgsx     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            com.google.android.gms.internal.ads.zzdzc<com.google.android.gms.internal.ads.zzboq> r0 = r1.zzgsx     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isDone()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L10
            r0 = 1
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r1)
            goto L16
        L15:
            throw r0
        L16:
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczj.isLoading():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgsg != null) {
            this.zzgsg.zzaiw().zzca(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgsg != null) {
            this.zzgsg.zzaiw().zzcb(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgsm.zzbp(z);
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
    public final void zza(zzsh zzshVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvs zzvsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyu zzyuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized boolean zza(zzvg zzvgVar) {
        zzd(this.zzgsv);
        return zzg(zzvgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwo
    public final synchronized void zzakb() {
        boolean zZza;
        Object parent = this.zzfpw.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            zZza = com.google.android.gms.ads.internal.zzp.zzkr().zza(view, view.getContext());
        } else {
            zZza = false;
        }
        if (!zZza) {
            this.zzgsu.zzdw(60);
            return;
        }
        zzvn zzvnVarZzkg = this.zzgsm.zzkg();
        if (this.zzgsg != null && this.zzgsg.zzaif() != null && this.zzgsm.zzato()) {
            zzvnVarZzkg = zzdoq.zzb(this.zzgsl, Collections.singletonList(this.zzgsg.zzaif()));
        }
        zzd(zzvnVarZzkg);
        zzg(this.zzgsm.zzatk());
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfpw);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zzkf() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzgsg != null) {
            this.zzgsg.zzkf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzvn zzkg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgsg != null) {
            return zzdoq.zzb(this.zzgsl, Collections.singletonList(this.zzgsg.zzahw()));
        }
        return this.zzgsm.zzkg();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String zzkh() {
        if (this.zzgsg == null || this.zzgsg.zzaix() == null) {
            return null;
        }
        return this.zzgsg.zzaix().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzyn zzki() {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxl)).booleanValue()) {
            return null;
        }
        if (this.zzgsg == null) {
            return null;
        }
        return this.zzgsg.zzaix();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzxk zzkj() {
        return this.zzgss.zzaqs();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzwt zzkk() {
        return this.zzgsq.zzaqt();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwt zzwtVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgsq.zzc(zzwtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxk zzxkVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgss.zzb(zzxkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzvn zzvnVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgsm.zze(zzvnVar);
        this.zzgsv = zzvnVar;
        if (this.zzgsg != null) {
            this.zzgsg.zza(this.zzfpw, zzvnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzxq zzxqVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgsm.zzc(zzxqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzaak zzaakVar) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgsm.zzc(zzaakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwo zzwoVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgsr.zzb(zzwoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzaby zzabyVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgsw = zzabyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyi zzyiVar) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzgst.zzb(zzyiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxj zzxjVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    static /* synthetic */ zzdzc zza(zzczj zzczjVar, zzdzc zzdzcVar) {
        zzczjVar.zzgsx = null;
        return null;
    }
}
