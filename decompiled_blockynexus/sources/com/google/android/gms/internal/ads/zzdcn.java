package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.umeng.analytics.pro.au;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcn implements zzdgu<Bundle> {
    private final zzbbx zzdqm;
    private final zzvs zzgvr;

    public zzdcn(zzvs zzvsVar, zzbbx zzbbxVar) {
        this.zzgvr = zzvsVar;
        this.zzdqm = zzbbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        int iIntValue = ((Integer) zzwm.zzpx().zzd(zzabb.zzcul)).intValue();
        zzbbx zzbbxVar = this.zzdqm;
        if (zzbbxVar != null && zzbbxVar.zzeem >= iIntValue) {
            bundle2.putString("app_open_version", "2");
        }
        zzvs zzvsVar = this.zzgvr;
        if (zzvsVar != null) {
            int i = zzvsVar.orientation;
            if (i == 1) {
                bundle2.putString("avo", au.aw);
            } else if (i == 2) {
                bundle2.putString("avo", "l");
            }
        }
    }
}
