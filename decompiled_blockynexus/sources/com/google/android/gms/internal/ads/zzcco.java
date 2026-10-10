package com.google.android.gms.internal.ads;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzua;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcco implements com.google.android.gms.ads.internal.overlay.zzp, zzbvs {
    private final zzbbx zzbpe;
    private final zzbgj zzdgy;
    private final zzdnv zzeot;

    @VisibleForTesting
    private IObjectWrapper zzfrd;
    private final zzua.zza.EnumC0120zza zzfxc;
    private final Context zzvr;

    public zzcco(Context context, zzbgj zzbgjVar, zzdnv zzdnvVar, zzbbx zzbbxVar, zzua.zza.EnumC0120zza enumC0120zza) {
        this.zzvr = context;
        this.zzdgy = zzbgjVar;
        this.zzeot = zzdnvVar;
        this.zzbpe = zzbbxVar;
        this.zzfxc = enumC0120zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        zzua.zza.EnumC0120zza enumC0120zza = this.zzfxc;
        if ((enumC0120zza == zzua.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD || enumC0120zza == zzua.zza.EnumC0120zza.INTERSTITIAL || enumC0120zza == zzua.zza.EnumC0120zza.APP_OPEN) && this.zzeot.zzdtm && this.zzdgy != null && com.google.android.gms.ads.internal.zzp.zzlg().zzp(this.zzvr)) {
            zzbbx zzbbxVar = this.zzbpe;
            int i = zzbbxVar.zzeel;
            int i2 = zzbbxVar.zzeem;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(Consts.DOT);
            sb.append(i2);
            this.zzfrd = com.google.android.gms.ads.internal.zzp.zzlg().zza(sb.toString(), this.zzdgy.getWebView(), "", "javascript", this.zzeot.zzhec.getVideoEventsOwner());
            if (this.zzfrd == null || this.zzdgy.getView() == null) {
                return;
            }
            com.google.android.gms.ads.internal.zzp.zzlg().zza(this.zzfrd, this.zzdgy.getView());
            this.zzdgy.zzap(this.zzfrd);
            com.google.android.gms.ads.internal.zzp.zzlg().zzab(this.zzfrd);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        this.zzfrd = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
        zzbgj zzbgjVar;
        if (this.zzfrd == null || (zzbgjVar = this.zzdgy) == null) {
            return;
        }
        zzbgjVar.zza("onSdkImpression", new HashMap());
    }
}
