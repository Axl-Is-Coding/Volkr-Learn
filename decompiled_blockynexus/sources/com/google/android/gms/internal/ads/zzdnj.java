package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnj extends zzavb {
    private final String zzbuu;
    private final zzdoj zzfuj;
    private final Context zzgsl;
    private final zzdnb zzhcx;
    private final zzdmc zzhcy;
    private zzcjg zzhcz;

    public zzdnj(String str, zzdnb zzdnbVar, Context context, zzdmc zzdmcVar, zzdoj zzdojVar) {
        this.zzbuu = str;
        this.zzhcx = zzdnbVar;
        this.zzhcy = zzdmcVar;
        this.zzfuj = zzdojVar;
        this.zzgsl = context;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcjg zzcjgVar = this.zzhcz;
        return zzcjgVar != null ? zzcjgVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzhcz == null || this.zzhcz.zzaix() == null) {
            return null;
        }
        return this.zzhcz.zzaix().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcjg zzcjgVar = this.zzhcz;
        return (zzcjgVar == null || zzcjgVar.zzanu()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final synchronized void zza(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException {
        zza(zzvgVar, zzavgVar, zzdoc.zzheq);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final synchronized void zzb(zzvg zzvgVar, zzavg zzavgVar) throws RemoteException {
        zza(zzvgVar, zzavgVar, zzdoc.zzher);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final zzyn zzki() {
        zzcjg zzcjgVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxl)).booleanValue() && (zzcjgVar = this.zzhcz) != null) {
            return zzcjgVar.zzaix();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final zzaux zzqz() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcjg zzcjgVar = this.zzhcz;
        if (zzcjgVar != null) {
            return zzcjgVar.zzqz();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzhcz == null) {
            zzbbq.zzfe("Rewarded can not be shown before loaded");
            this.zzhcy.zzj(zzdpe.zza(zzdpg.NOT_READY, null, null));
        } else {
            this.zzhcz.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavd zzavdVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhcy.zzb(zzavdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzavl zzavlVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhcy.zzb(zzavlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzyh zzyhVar) {
        if (zzyhVar == null) {
            this.zzhcy.zza(null);
        } else {
            this.zzhcy.zza(new zzdni(this, zzyhVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final synchronized void zza(zzavt zzavtVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdoj zzdojVar = this.zzfuj;
        zzdojVar.zzdvz = zzavtVar.zzdvz;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcon)).booleanValue()) {
            zzdojVar.zzdwa = zzavtVar.zzdwa;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauy
    public final void zza(zzyi zzyiVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzhcy.zzc(zzyiVar);
    }

    private final synchronized void zza(zzvg zzvgVar, zzavg zzavgVar, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhcy.zzb(zzavgVar);
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (zzayu.zzbe(this.zzgsl) && zzvgVar.zzcho == null) {
            zzbbq.zzfc("Failed to load the ad because app ID is missing.");
            this.zzhcy.zzk(zzdpe.zza(zzdpg.APP_ID_MISSING, null, null));
        } else {
            if (this.zzhcz != null) {
                return;
            }
            zzdmy zzdmyVar = new zzdmy(null);
            this.zzhcx.zzea(i);
            this.zzhcx.zza(zzvgVar, this.zzbuu, zzdmyVar, new zzdnl(this));
        }
    }
}
