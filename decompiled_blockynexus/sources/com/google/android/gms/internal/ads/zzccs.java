package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccs implements zzbuh, zzbzu {
    private final View view;
    private final zzawo zzbqq;
    private final zzawp zzfrn;
    private final zzua.zza.EnumC0120zza zzfxc;
    private String zzfxe;
    private final Context zzvr;

    public zzccs(zzawp zzawpVar, Context context, zzawo zzawoVar, View view, zzua.zza.EnumC0120zza enumC0120zza) {
        this.zzfrn = zzawpVar;
        this.zzvr = context;
        this.zzbqq = zzawoVar;
        this.view = view;
        this.zzfxc = enumC0120zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
        this.zzfrn.zzam(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
        View view = this.view;
        if (view != null && this.zzfxe != null) {
            this.zzbqq.zzh(view.getContext(), this.zzfxe);
        }
        this.zzfrn.zzam(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzu
    public final void zzajj() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzu
    public final void zzajl() {
        this.zzfxe = this.zzbqq.zzae(this.zzvr);
        String strValueOf = String.valueOf(this.zzfxe);
        String str = this.zzfxc == zzua.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzfxe = str.length() != 0 ? strValueOf.concat(str) : new String(strValueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(zzatw zzatwVar, String str, String str2) {
        if (this.zzbqq.zzac(this.zzvr)) {
            try {
                this.zzbqq.zza(this.zzvr, this.zzbqq.zzah(this.zzvr), this.zzfrn.getAdUnitId(), zzatwVar.getType(), zzatwVar.getAmount());
            } catch (RemoteException e2) {
                zzbbq.zzd("Remote Exception to get reward item.", e2);
            }
        }
    }
}
