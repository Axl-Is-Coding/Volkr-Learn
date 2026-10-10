package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdmc extends AdMetadataListener implements zzbuh, zzbui, zzbuv, zzbvs, zzbwl, zzdls {
    private final zzdpw zzhao;
    private final AtomicReference<AdMetadataListener> zzhcg = new AtomicReference<>();
    private final AtomicReference<zzavg> zzhch = new AtomicReference<>();
    private final AtomicReference<zzavd> zzhci = new AtomicReference<>();
    private final AtomicReference<zzaug> zzhcj = new AtomicReference<>();
    private final AtomicReference<zzavl> zzhck = new AtomicReference<>();
    private final AtomicReference<zzaub> zzhcl = new AtomicReference<>();
    private final AtomicReference<zzyi> zzhcm = new AtomicReference<>();
    private zzdmc zzhcn = null;

    public zzdmc(zzdpw zzdpwVar) {
        this.zzhao = zzdpwVar;
    }

    public static zzdmc zzb(zzdmc zzdmcVar) {
        zzdmc zzdmcVar2 = new zzdmc(zzdmcVar.zzhao);
        zzdmcVar2.zzb((zzdls) zzdmcVar);
        return zzdmcVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdmcVar.zzhao.onAdClosed();
                zzdll.zza(zzdmcVar.zzhci, zzdmu.zzhaw);
                zzdll.zza(zzdmcVar.zzhcj, zzdmx.zzhaw);
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhcj, zzdmw.zzhaw);
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhch, zzdmf.zzhaw);
                zzdll.zza(zzdmcVar.zzhcj, zzdme.zzhaw);
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzdmc zzdmcVar = this.zzhcn;
        if (zzdmcVar != null) {
            zzdmcVar.onAdMetadataChanged();
        } else {
            zzdll.zza(this.zzhcg, zzdmp.zzhaw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhci, zzdms.zzhaw);
                zzdll.zza(zzdmcVar.zzhcj, zzdmv.zzhaw);
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhcj, zzdmk.zzhaw);
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhcj, zzdmh.zzhaw);
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzhcg.set(adMetadataListener);
    }

    public final void zzc(zzyi zzyiVar) {
        this.zzhcm.set(zzyiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final void zzj(final zzva zzvaVar) {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhci, new zzdlk(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzdmn
                    private final zzva zzfus;

                    {
                        this.zzfus = zzvaVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzavd) obj).zzh(this.zzfus);
                    }
                });
                zzdll.zza(zzdmcVar.zzhci, new zzdlk(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzdmm
                    private final zzva zzfus;

                    {
                        this.zzfus = zzvaVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzavd) obj).onRewardedAdFailedToShow(this.zzfus.errorCode);
                    }
                });
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(final zzva zzvaVar) {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                final int i = zzvaVar.errorCode;
                zzdll.zza(zzdmcVar.zzhch, new zzdlk(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzdmr
                    private final zzva zzfus;

                    {
                        this.zzfus = zzvaVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzavg) obj).zzi(this.zzfus);
                    }
                });
                zzdll.zza(zzdmcVar.zzhch, new zzdlk(i) { // from class: com.google.android.gms.internal.ads.zzdmq
                    private final int zzeeh;

                    {
                        this.zzeeh = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzavg) obj).onRewardedAdFailedToLoad(this.zzeeh);
                    }
                });
                zzdll.zza(zzdmcVar.zzhcj, new zzdlk(i) { // from class: com.google.android.gms.internal.ads.zzdmt
                    private final int zzeeh;

                    {
                        this.zzeeh = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzaug) obj).onRewardedVideoAdFailedToLoad(this.zzeeh);
                    }
                });
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    public final void zzb(zzavg zzavgVar) {
        this.zzhch.set(zzavgVar);
    }

    public final void zzb(zzavd zzavdVar) {
        this.zzhci.set(zzavdVar);
    }

    public final void zzb(zzavl zzavlVar) {
        this.zzhck.set(zzavlVar);
    }

    @Deprecated
    public final void zzb(zzaug zzaugVar) {
        this.zzhcj.set(zzaugVar);
    }

    @Deprecated
    public final void zzb(zzaub zzaubVar) {
        this.zzhcl.set(zzaubVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(final zzatw zzatwVar, final String str, final String str2) {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhci, new zzdlk(zzatwVar) { // from class: com.google.android.gms.internal.ads.zzdmg
                    private final zzatw zzfuw;

                    {
                        this.zzfuw = zzatwVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        zzatw zzatwVar2 = this.zzfuw;
                        ((zzavd) obj).zza(new zzavu(zzatwVar2.getType(), zzatwVar2.getAmount()));
                    }
                });
                zzdll.zza(zzdmcVar.zzhck, new zzdlk(zzatwVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdmj
                    private final String zzdgm;
                    private final String zzdjk;
                    private final zzatw zzfuw;

                    {
                        this.zzfuw = zzatwVar;
                        this.zzdgm = str;
                        this.zzdjk = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        zzatw zzatwVar2 = this.zzfuw;
                        ((zzavl) obj).zza(new zzavu(zzatwVar2.getType(), zzatwVar2.getAmount()), this.zzdgm, this.zzdjk);
                    }
                });
                zzdll.zza(zzdmcVar.zzhcj, new zzdlk(zzatwVar) { // from class: com.google.android.gms.internal.ads.zzdmi
                    private final zzatw zzfuw;

                    {
                        this.zzfuw = zzatwVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzaug) obj).zza(this.zzfuw);
                    }
                });
                zzdll.zza(zzdmcVar.zzhcl, new zzdlk(zzatwVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdml
                    private final String zzdgm;
                    private final String zzdjk;
                    private final zzatw zzfuw;

                    {
                        this.zzfuw = zzatwVar;
                        this.zzdgm = str;
                        this.zzdjk = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzaub) obj).zza(this.zzfuw, this.zzdgm, this.zzdjk);
                    }
                });
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwl
    public final void zzb(final zzvp zzvpVar) {
        zzdmc zzdmcVar = this;
        while (true) {
            zzdmc zzdmcVar2 = zzdmcVar.zzhcn;
            if (zzdmcVar2 == null) {
                zzdll.zza(zzdmcVar.zzhcm, new zzdlk(zzvpVar) { // from class: com.google.android.gms.internal.ads.zzdmo
                    private final zzvp zzfvm;

                    {
                        this.zzfvm = zzvpVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzyi) obj).zza(this.zzfvm);
                    }
                });
                return;
            }
            zzdmcVar = zzdmcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdls
    public final void zzb(zzdls zzdlsVar) {
        this.zzhcn = (zzdmc) zzdlsVar;
    }
}
