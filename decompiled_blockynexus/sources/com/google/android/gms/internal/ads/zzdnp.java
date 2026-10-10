package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnp extends zzauc {
    private final zzdoj zzfuj;
    private boolean zzgtm = false;
    private final zzdnb zzhcx;
    private final zzdmc zzhcy;
    private zzcjg zzhcz;

    public zzdnp(zzdnb zzdnbVar, zzdmc zzdmcVar, zzdoj zzdojVar) {
        this.zzhcx = zzdnbVar;
        this.zzhcy = zzdmcVar;
        this.zzfuj = zzdojVar;
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
            com.google.android.gms.internal.ads.zzcjg r0 = r1.zzhcz     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            com.google.android.gms.internal.ads.zzcjg r0 = r1.zzhcz     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnp.zzaqu():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void destroy() throws RemoteException {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzcjg zzcjgVar = this.zzhcz;
        return zzcjgVar != null ? zzcjgVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzhcz == null || this.zzhcz.zzaix() == null) {
            return null;
        }
        return this.zzhcz.zzaix().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzaqu();
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void pause() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void resume() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void setAppPackageName(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcon)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfuj.zzdwa = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgtm = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfuj.zzdvz = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void show() throws RemoteException {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void zza(zzaum zzaumVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (zzabd.zzct(zzaumVar.zzbuu)) {
            return;
        }
        if (zzaqu()) {
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcuv)).booleanValue()) {
                return;
            }
        }
        zzdmy zzdmyVar = new zzdmy(null);
        this.zzhcz = null;
        this.zzhcx.zzea(zzdoc.zzhep);
        this.zzhcx.zza(zzaumVar.zzdqr, zzaumVar.zzbuu, zzdmyVar, new zzdno(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    @Override // com.google.android.gms.internal.ads.zzaud
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzi(com.google.android.gms.dynamic.IObjectWrapper r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.internal.ads.zzcjg r0 = r2.zzhcz     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Lc
            monitor-exit(r2)
            return
        Lc:
            if (r3 == 0) goto L19
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch: java.lang.Throwable -> L23
            boolean r0 = r3 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L19
            android.app.Activity r3 = (android.app.Activity) r3     // Catch: java.lang.Throwable -> L23
            goto L1a
        L19:
            r3 = 0
        L1a:
            com.google.android.gms.internal.ads.zzcjg r0 = r2.zzhcz     // Catch: java.lang.Throwable -> L23
            boolean r1 = r2.zzgtm     // Catch: java.lang.Throwable -> L23
            r0.zzb(r1, r3)     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            return
        L23:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnp.zzi(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhcz != null) {
            this.zzhcz.zzaiw().zzca(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhcz != null) {
            this.zzhcz.zzaiw().zzcb(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized zzyn zzki() throws RemoteException {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxl)).booleanValue()) {
            return null;
        }
        if (this.zzhcz == null) {
            return null;
        }
        return this.zzhcz.zzaix();
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzhcy.zza(null);
        if (this.zzhcz != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzhcz.zzaiw().zzcc(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final boolean zzra() {
        zzcjg zzcjgVar = this.zzhcz;
        return zzcjgVar != null && zzcjgVar.zzra();
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zza(zzaug zzaugVar) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzhcy.zzb(zzaugVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zza(zzaub zzaubVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzhcy.zzb(zzaubVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zza(zzxj zzxjVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzxjVar == null) {
            this.zzhcy.zza(null);
        } else {
            this.zzhcy.zza(new zzdnr(this, zzxjVar));
        }
    }
}
