package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwv extends AdMetadataListener implements AppEventListener, zzbuh, zzbuv, zzbuz, zzbwb, zzbwl, zzux {
    private final zzbxq zzfvf = new zzbxq(this);
    private zzczs zzfvg;
    private zzczp zzfvh;
    private zzczr zzfvi;
    private zzczn zzfvj;
    private zzdkc zzfvk;
    private zzdmc zzfvl;

    private static <T> void zza(T t, zzbxt<T> zzbxtVar) {
        if (t != null) {
            zzbxtVar.zzq(t);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final void onAdClicked() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbwy.zzfve);
        zza(this.zzfvh, (zzbxt<zzczp>) zzbxb.zzfve);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbxg.zzfve);
        zza(this.zzfvl, (zzbxt<zzdmc>) zzbxi.zzfve);
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final void onAdImpression() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbxf.zzfve);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbxl.zzfve);
        zza(this.zzfvl, (zzbxt<zzdmc>) zzbxk.zzfve);
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zza(this.zzfvl, (zzbxt<zzdmc>) zzbxh.zzfve);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbwu.zzfve);
        zza(this.zzfvl, (zzbxt<zzdmc>) zzbwx.zzfve);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zza(this.zzfvi, (zzbxt<zzczr>) new zzbxt(str, str2) { // from class: com.google.android.gms.internal.ads.zzbxa
            private final String zzdgm;
            private final String zzdgt;

            {
                this.zzdgt = str;
                this.zzdgm = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxt
            public final void zzq(Object obj) {
                ((zzczr) obj).onAppEvent(this.zzdgt, this.zzdgm);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbww.zzfve);
        zza(this.zzfvl, (zzbxt<zzdmc>) zzbwz.zzfve);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
        zza(this.zzfvg, (zzbxt<zzczs>) zzbxn.zzfve);
        zza(this.zzfvl, (zzbxt<zzdmc>) zzbxm.zzfve);
    }

    public final zzbxq zzaiz() {
        return this.zzfvf;
    }

    @Override // com.google.android.gms.internal.ads.zzbwb
    public final void zzajx() {
        zza(this.zzfvk, (zzbxt<zzdkc>) zzbxe.zzfve);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(final zzatw zzatwVar, final String str, final String str2) {
        zza(this.zzfvg, (zzbxt<zzczs>) new zzbxt(zzatwVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbxp
            private final String zzdgm;
            private final String zzdjk;
            private final zzatw zzfuw;

            {
                this.zzfuw = zzatwVar;
                this.zzdgm = str;
                this.zzdjk = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxt
            public final void zzq(Object obj) {
            }
        });
        zza(this.zzfvl, (zzbxt<zzdmc>) new zzbxt(zzatwVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbxo
            private final String zzdgm;
            private final String zzdjk;
            private final zzatw zzfuw;

            {
                this.zzfuw = zzatwVar;
                this.zzdgm = str;
                this.zzdjk = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxt
            public final void zzq(Object obj) {
                ((zzdmc) obj).zzb(this.zzfuw, this.zzdgm, this.zzdjk);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final void zzj(final zzva zzvaVar) {
        zza(this.zzfvl, (zzbxt<zzdmc>) new zzbxt(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzbxj
            private final zzva zzfus;

            {
                this.zzfus = zzvaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxt
            public final void zzq(Object obj) {
                ((zzdmc) obj).zzj(this.zzfus);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void zzb(final zzvp zzvpVar) {
        zza(this.zzfvj, (zzbxt<zzczn>) new zzbxt(zzvpVar) { // from class: com.google.android.gms.internal.ads.zzbxd
            private final zzvp zzfvm;

            {
                this.zzfvm = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxt
            public final void zzq(Object obj) {
                ((zzczn) obj).zzb(this.zzfvm);
            }
        });
        zza(this.zzfvl, (zzbxt<zzdmc>) new zzbxt(zzvpVar) { // from class: com.google.android.gms.internal.ads.zzbxc
            private final zzvp zzfvm;

            {
                this.zzfvm = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxt
            public final void zzq(Object obj) {
                ((zzdmc) obj).zzb(this.zzfvm);
            }
        });
    }
}
