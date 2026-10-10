package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzcyc extends zzank {
    private final zzbvr zzfrr;
    private final zzbvh zzfsg;
    private final zzbuk zzfwv;
    private final zzbwa zzfwy;
    private final zzbuu zzfxv;
    private final zzbuc zzfxw;
    private final zzbyf zzget;
    private final zzbxy zzgqz;
    private final zzcau zzgrk;

    public zzcyc(zzbuc zzbucVar, zzbuu zzbuuVar, zzbvh zzbvhVar, zzbvr zzbvrVar, zzbyf zzbyfVar, zzbwa zzbwaVar, zzcau zzcauVar, zzbxy zzbxyVar, zzbuk zzbukVar) {
        this.zzfxw = zzbucVar;
        this.zzfxv = zzbuuVar;
        this.zzfsg = zzbvhVar;
        this.zzfrr = zzbvrVar;
        this.zzget = zzbyfVar;
        this.zzfwy = zzbwaVar;
        this.zzgrk = zzcauVar;
        this.zzgqz = zzbxyVar;
        this.zzfwv = zzbukVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdClicked() {
        this.zzfxw.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdClosed() {
        this.zzfwy.zzum();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdFailedToLoad(int i) {
    }

    public void onAdImpression() {
        this.zzfxv.onAdImpression();
        this.zzgqz.zzajk();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdLeftApplication() {
        this.zzfsg.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdLoaded() {
        this.zzfrr.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAdOpened() {
        this.zzfwy.zzun();
        this.zzgqz.zzajm();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onAppEvent(String str, String str2) {
        this.zzget.onAppEvent(str, str2);
    }

    public void onVideoEnd() {
        this.zzgrk.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onVideoPause() {
        this.zzgrk.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void onVideoPlay() throws RemoteException {
        this.zzgrk.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzafa zzafaVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zza(zzanm zzanmVar) {
    }

    public void zza(zzaux zzauxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public void zzb(zzauv zzauvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzc(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzc(zzva zzvaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    @Deprecated
    public final void zzdd(int i) throws RemoteException {
        zze(new zzva(i, "", AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzdn(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zzdo(String str) {
        zze(new zzva(0, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzanh
    public final void zze(zzva zzvaVar) {
        this.zzfwv.zzl(zzdpe.zza(zzdpg.MEDIATION_SHOW_ERROR, zzvaVar));
    }

    public void zzuc() {
        this.zzgrk.onVideoStart();
    }

    public void zzud() throws RemoteException {
    }
}
