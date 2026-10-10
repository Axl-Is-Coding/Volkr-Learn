package com.google.android.gms.internal.ads;

import a.a.b;
import android.content.Context;
import android.view.View;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqd implements zzbuz, zzbvs {
    private final zzbbx zzbpe;
    private final zzbgj zzdgy;
    private final zzdnv zzeot;
    private IObjectWrapper zzfrd;
    private boolean zzfre;
    private final Context zzvr;

    public zzbqd(Context context, zzbgj zzbgjVar, zzdnv zzdnvVar, zzbbx zzbbxVar) {
        this.zzvr = context;
        this.zzdgy = zzbgjVar;
        this.zzeot = zzdnvVar;
        this.zzbpe = zzbbxVar;
    }

    private final synchronized void zzait() {
        if (this.zzeot.zzdtm) {
            if (this.zzdgy == null) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzp.zzlg().zzp(this.zzvr)) {
                int i = this.zzbpe.zzeel;
                int i2 = this.zzbpe.zzeem;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(Consts.DOT);
                sb.append(i2);
                this.zzfrd = com.google.android.gms.ads.internal.zzp.zzlg().zza(sb.toString(), this.zzdgy.getWebView(), "", "javascript", this.zzeot.zzhec.getVideoEventsOwner());
                View view = this.zzdgy.getView();
                if (this.zzfrd != null && view != null) {
                    com.google.android.gms.ads.internal.zzp.zzlg().zza(this.zzfrd, view);
                    this.zzdgy.zzap(this.zzfrd);
                    com.google.android.gms.ads.internal.zzp.zzlg().zzab(this.zzfrd);
                    this.zzfre = true;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final synchronized void onAdImpression() {
        if (!this.zzfre) {
            zzait();
        }
        if (this.zzeot.zzdtm && this.zzfrd != null && this.zzdgy != null) {
            this.zzdgy.zza("onSdkImpression", new b());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final synchronized void onAdLoaded() {
        if (this.zzfre) {
            return;
        }
        zzait();
    }
}
