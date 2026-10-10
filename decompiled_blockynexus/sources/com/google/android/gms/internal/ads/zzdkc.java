package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdkc implements com.google.android.gms.ads.internal.overlay.zzp, zzbui, zzbwb, zzdls {
    private final zzdpw zzhao;
    private final AtomicReference<zzsh> zzhap = new AtomicReference<>();
    private final AtomicReference<zzsm> zzhaq = new AtomicReference<>();
    private final AtomicReference<zzsq> zzhar = new AtomicReference<>();
    private final AtomicReference<zzbwb> zzhas = new AtomicReference<>();
    private final AtomicReference<com.google.android.gms.ads.internal.overlay.zzp> zzhat = new AtomicReference<>();
    private zzdkc zzhau = null;

    public zzdkc(zzdpw zzdpwVar) {
        this.zzhao = zzdpwVar;
    }

    public static zzdkc zzb(zzdkc zzdkcVar) {
        zzdkc zzdkcVar2 = new zzdkc(zzdkcVar.zzhao);
        zzdkcVar2.zzb((zzdls) zzdkcVar);
        return zzdkcVar2;
    }

    public final void onAdClosed() {
        zzdkc zzdkcVar = this;
        while (true) {
            zzdkc zzdkcVar2 = zzdkcVar.zzhau;
            if (zzdkcVar2 == null) {
                zzdkcVar.zzhao.onAdClosed();
                zzdll.zza(zzdkcVar.zzhaq, zzdkg.zzhaw);
                zzdll.zza(zzdkcVar.zzhar, zzdkj.zzhaw);
                return;
            }
            zzdkcVar = zzdkcVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    public final void zza(zzsq zzsqVar) {
        this.zzhar.set(zzsqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwb
    public final void zzajx() {
        zzdkc zzdkcVar = this;
        while (true) {
            zzdkc zzdkcVar2 = zzdkcVar.zzhau;
            if (zzdkcVar2 == null) {
                zzdll.zza(zzdkcVar.zzhas, zzdki.zzhaw);
                zzdll.zza(zzdkcVar.zzhar, zzdkl.zzhaw);
                return;
            }
            zzdkcVar = zzdkcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(final zzva zzvaVar) {
        zzdkc zzdkcVar = this;
        while (true) {
            zzdkc zzdkcVar2 = zzdkcVar.zzhau;
            if (zzdkcVar2 == null) {
                zzdll.zza(zzdkcVar.zzhap, new zzdlk(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzdke
                    private final zzva zzfus;

                    {
                        this.zzfus = zzvaVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzsh) obj).zza(this.zzfus);
                    }
                });
                zzdll.zza(zzdkcVar.zzhap, new zzdlk(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzdkh
                    private final zzva zzfus;

                    {
                        this.zzfus = zzvaVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzsh) obj).onAppOpenAdFailedToLoad(this.zzfus.errorCode);
                    }
                });
                return;
            }
            zzdkcVar = zzdkcVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        zzdkc zzdkcVar = this;
        while (true) {
            zzdkc zzdkcVar2 = zzdkcVar.zzhau;
            if (zzdkcVar2 == null) {
                zzdll.zza(zzdkcVar.zzhat, zzdkk.zzhaw);
                return;
            }
            zzdkcVar = zzdkcVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
    }

    public final void zza(zzbwb zzbwbVar) {
        this.zzhas.set(zzbwbVar);
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzp zzpVar) {
        this.zzhat.set(zzpVar);
    }

    public final void zzb(zzsh zzshVar) {
        this.zzhap.set(zzshVar);
    }

    public final void zzb(zzsm zzsmVar) {
        this.zzhaq.set(zzsmVar);
    }

    public final void zzb(final zzsg zzsgVar) {
        zzdkc zzdkcVar = this;
        while (true) {
            zzdkc zzdkcVar2 = zzdkcVar.zzhau;
            if (zzdkcVar2 == null) {
                zzdll.zza(zzdkcVar.zzhap, new zzdlk(zzsgVar) { // from class: com.google.android.gms.internal.ads.zzdkf
                    private final zzsg zzhav;

                    {
                        this.zzhav = zzsgVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdlk
                    public final void zzq(Object obj) throws RemoteException {
                        ((zzsh) obj).zza(this.zzhav);
                    }
                });
                return;
            }
            zzdkcVar = zzdkcVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdls
    public final void zzb(zzdls zzdlsVar) {
        this.zzhau = (zzdkc) zzdlsVar;
    }
}
