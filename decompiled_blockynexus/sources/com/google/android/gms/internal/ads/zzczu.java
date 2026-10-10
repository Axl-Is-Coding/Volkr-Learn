package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbys;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczu extends zzxf {
    private final Executor zzfoc;
    private final zzbix zzgpt;
    private final Context zzgsl;
    private zzaby zzgsw;
    private zzdzc<zzcbe> zzgsx;
    private zzcbe zzgtl;
    private final zzczs zzgsq = new zzczs();
    private final zzczr zzgss = new zzczr();
    private final zzdmc zzgtk = new zzdmc(new zzdpw());
    private final zzczn zzgst = new zzczn();
    private final zzdom zzgsm = new zzdom();
    private boolean zzgtm = false;

    public zzczu(zzbix zzbixVar, Context context, zzvn zzvnVar, String str) {
        this.zzgpt = zzbixVar;
        this.zzgsm.zze(zzvnVar).zzgt(str);
        this.zzfoc = zzbixVar.zzadi();
        this.zzgsl = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized boolean zzaqu() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcbe r0 = r1.zzgtl     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            com.google.android.gms.internal.ads.zzcbe r0 = r1.zzgtl     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isClosed()     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczu.zzaqu():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgtl != null) {
            this.zzgtl.zzaiw().zzcc(null);
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
        if (this.zzgtl == null || this.zzgtl.zzaix() == null) {
            return null;
        }
        return this.zzgtl.zzaix().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyo getVideoController() {
        return null;
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
            com.google.android.gms.internal.ads.zzdzc<com.google.android.gms.internal.ads.zzcbe> r0 = r1.zzgsx     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            com.google.android.gms.internal.ads.zzdzc<com.google.android.gms.internal.ads.zzcbe> r0 = r1.zzgsx     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczu.isLoading():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzaqu();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgtl != null) {
            this.zzgtl.zzaiw().zzca(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgtl != null) {
            this.zzgtl.zzaiw().zzcb(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgtm = z;
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
    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzgtl == null) {
            return;
        }
        this.zzgtl.zzbi(this.zzgtm);
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
    public final void zza(zzsh zzshVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvn zzvnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvs zzvsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwo zzwoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyu zzyuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized boolean zza(zzvg zzvgVar) {
        zzcce zzcceVarZzaey;
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (zzayu.zzbe(this.zzgsl) && zzvgVar.zzcho == null) {
            zzbbq.zzfc("Failed to load the ad because app ID is missing.");
            if (this.zzgsq != null) {
                this.zzgsq.zzk(zzdpe.zza(zzdpg.APP_ID_MISSING, null, null));
            }
            return false;
        }
        if (this.zzgsx == null && !zzaqu()) {
            zzdox.zze(this.zzgsl, zzvgVar.zzche);
            this.zzgtl = null;
            zzdok zzdokVarZzatn = this.zzgsm.zzh(zzvgVar).zzatn();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyh)).booleanValue()) {
                zzcceVarZzaey = this.zzgpt.zzadt().zze(new zzbtp.zza().zzce(this.zzgsl).zza(zzdokVarZzatn).zzajv()).zze(new zzbys.zza().zzakr()).zzb(new zzcyn(this.zzgsw)).zzaey();
            } else {
                zzbys.zza zzaVar = new zzbys.zza();
                if (this.zzgtk != null) {
                    zzaVar.zza((zzbuh) this.zzgtk, this.zzgpt.zzadi()).zza((zzbvs) this.zzgtk, this.zzgpt.zzadi()).zza((zzbui) this.zzgtk, this.zzgpt.zzadi());
                }
                zzcceVarZzaey = this.zzgpt.zzadt().zze(new zzbtp.zza().zzce(this.zzgsl).zza(zzdokVarZzatn).zzajv()).zze(zzaVar.zza((zzbuh) this.zzgsq, this.zzgpt.zzadi()).zza((zzbvs) this.zzgsq, this.zzgpt.zzadi()).zza((zzbui) this.zzgsq, this.zzgpt.zzadi()).zza((zzux) this.zzgsq, this.zzgpt.zzadi()).zza(this.zzgss, this.zzgpt.zzadi()).zza(this.zzgst, this.zzgpt.zzadi()).zzakr()).zzb(new zzcyn(this.zzgsw)).zzaey();
            }
            this.zzgsx = zzcceVarZzaey.zzaev().zzajh();
            zzdyq.zza(this.zzgsx, new zzczt(this, zzcceVarZzaey), this.zzfoc);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzkf() {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzvn zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized String zzkh() {
        if (this.zzgtl == null || this.zzgtl.zzaix() == null) {
            return null;
        }
        return this.zzgtl.zzaix().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized zzyn zzki() {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxl)).booleanValue()) {
            return null;
        }
        if (this.zzgtl == null) {
            return null;
        }
        return this.zzgtl.zzaix();
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
    public final synchronized void zza(zzxq zzxqVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgsm.zzc(zzxqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final synchronized void zza(zzaak zzaakVar) {
        this.zzgsm.zzc(zzaakVar);
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

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaug zzaugVar) {
        this.zzgtk.zzb(zzaugVar);
    }

    static /* synthetic */ zzdzc zza(zzczu zzczuVar, zzdzc zzdzcVar) {
        zzczuVar.zzgsx = null;
        return null;
    }
}
