package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcff implements zzads {
    private final /* synthetic */ zzcgc zzgbk;
    private final /* synthetic */ ViewGroup zzgbl;
    private final /* synthetic */ zzcfe zzgbm;

    zzcff(zzcfe zzcfeVar, zzcgc zzcgcVar, ViewGroup viewGroup) {
        this.zzgbm = zzcfeVar;
        this.zzgbk = zzcgcVar;
        this.zzgbl = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final void zzc(MotionEvent motionEvent) {
        this.zzgbk.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final void zzsh() {
        zzcfe zzcfeVar = this.zzgbm;
        if (zzcfe.zza(this.zzgbk, zzcfc.zzgba)) {
            this.zzgbk.onClick(this.zzgbl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final JSONObject zzsi() {
        return this.zzgbk.zzsi();
    }
}
