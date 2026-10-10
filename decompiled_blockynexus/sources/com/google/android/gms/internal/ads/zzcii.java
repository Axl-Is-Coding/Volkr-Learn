package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcii implements zzads {
    private final /* synthetic */ zzcif zzgef;

    zzcii(zzcif zzcifVar) {
        this.zzgef = zzcifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final void zzsh() {
        if (this.zzgef.zzgaw != null) {
            this.zzgef.zzgaw.zzfz(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzads
    public final JSONObject zzsi() {
        return null;
    }
}
