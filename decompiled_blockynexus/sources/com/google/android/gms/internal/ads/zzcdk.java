package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcdk implements zzahq<Object> {
    private WeakReference<zzcdi> zzfyj;

    private zzcdk(zzcdi zzcdiVar) {
        this.zzfyj = new WeakReference<>(zzcdiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        zzcdi zzcdiVar = this.zzfyj.get();
        if (zzcdiVar != null && "_ac".equals(map.get("eventName"))) {
            zzcdiVar.zzfxw.onAdClicked();
        }
    }
}
