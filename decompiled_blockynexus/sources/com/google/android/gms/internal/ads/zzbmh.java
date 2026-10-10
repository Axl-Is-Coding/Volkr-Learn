package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmh implements zzbuh, zzbuv, zzbuz, zzbvs, zzux {
    private final Executor executor;
    private final View view;
    private final zzacb zzeon;
    private final ScheduledExecutorService zzfmv;
    private final zzdog zzfmw;
    private final zzdnv zzfmx;
    private final zzdsr zzfmy;
    private final zzdor zzfmz;
    private final zzeg zzfna;
    private final zzacg zzfnb;
    private boolean zzfnc;
    private boolean zzfnd;
    private final Context zzvr;

    public zzbmh(Context context, Executor executor, ScheduledExecutorService scheduledExecutorService, zzdog zzdogVar, zzdnv zzdnvVar, zzdsr zzdsrVar, zzdor zzdorVar, View view, zzeg zzegVar, zzacb zzacbVar, zzacg zzacgVar) {
        this.zzvr = context;
        this.executor = executor;
        this.zzfmv = scheduledExecutorService;
        this.zzfmw = zzdogVar;
        this.zzfmx = zzdnvVar;
        this.zzfmy = zzdsrVar;
        this.zzfmz = zzdorVar;
        this.zzfna = zzegVar;
        this.view = view;
        this.zzeon = zzacbVar;
        this.zzfnb = zzacgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final void onAdClicked() {
        if (zzact.zzdbb.get().booleanValue()) {
            zzdyq.zza(zzdyl.zzg(this.zzfnb.zza(this.zzvr, null, this.zzeon.zzrv(), this.zzeon.zzrw())).zza(((Long) zzwm.zzpx().zzd(zzabb.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv), new zzbmk(this), this.executor);
            return;
        }
        zzdor zzdorVar = this.zzfmz;
        zzdsr zzdsrVar = this.zzfmy;
        zzdog zzdogVar = this.zzfmw;
        zzdnv zzdnvVar = this.zzfmx;
        List<String> listZza = zzdsrVar.zza(zzdogVar, zzdnvVar, zzdnvVar.zzdkj);
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzdorVar.zza(listZza, zzayu.zzbf(this.zzvr) ? zzcsq.zzgne : zzcsq.zzgnd);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final synchronized void onAdImpression() {
        if (!this.zzfnd) {
            String strZza = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcro)).booleanValue() ? this.zzfna.zzca().zza(this.zzvr, this.view, (Activity) null) : null;
            if (!zzact.zzdbc.get().booleanValue()) {
                this.zzfmz.zzi(this.zzfmy.zza(this.zzfmw, this.zzfmx, false, strZza, null, this.zzfmx.zzdkk));
                this.zzfnd = true;
            } else {
                zzdyq.zza(zzdyl.zzg(this.zzfnb.zzc(this.zzvr, null)).zza(((Long) zzwm.zzpx().zzd(zzabb.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv), new zzbmj(this, strZza), this.executor);
                this.zzfnd = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final synchronized void onAdLoaded() {
        if (this.zzfnc) {
            ArrayList arrayList = new ArrayList(this.zzfmx.zzdkk);
            arrayList.addAll(this.zzfmx.zzhdl);
            this.zzfmz.zzi(this.zzfmy.zza(this.zzfmw, this.zzfmx, true, null, null, arrayList));
        } else {
            this.zzfmz.zzi(this.zzfmy.zza(this.zzfmw, this.zzfmx, this.zzfmx.zzhdn));
            this.zzfmz.zzi(this.zzfmy.zza(this.zzfmw, this.zzfmx, this.zzfmx.zzhdl));
        }
        this.zzfnc = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
        zzdor zzdorVar = this.zzfmz;
        zzdsr zzdsrVar = this.zzfmy;
        zzdog zzdogVar = this.zzfmw;
        zzdnv zzdnvVar = this.zzfmx;
        zzdorVar.zzi(zzdsrVar.zza(zzdogVar, zzdnvVar, zzdnvVar.zzhdm));
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
        zzdor zzdorVar = this.zzfmz;
        zzdsr zzdsrVar = this.zzfmy;
        zzdog zzdogVar = this.zzfmw;
        zzdnv zzdnvVar = this.zzfmx;
        zzdorVar.zzi(zzdsrVar.zza(zzdogVar, zzdnvVar, zzdnvVar.zzdtd));
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(zzatw zzatwVar, String str, String str2) {
        zzdor zzdorVar = this.zzfmz;
        zzdsr zzdsrVar = this.zzfmy;
        zzdnv zzdnvVar = this.zzfmx;
        zzdorVar.zzi(zzdsrVar.zza(zzdnvVar, zzdnvVar.zzdte, zzatwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final void zzj(zzva zzvaVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqg)).booleanValue()) {
            zzdor zzdorVar = this.zzfmz;
            zzdsr zzdsrVar = this.zzfmy;
            zzdog zzdogVar = this.zzfmw;
            zzdnv zzdnvVar = this.zzfmx;
            zzdorVar.zzi(zzdsrVar.zza(zzdogVar, zzdnvVar, zzdnvVar.zzhdo));
        }
    }
}
