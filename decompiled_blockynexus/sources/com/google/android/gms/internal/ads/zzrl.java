package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzrl implements ValueCallback<String> {
    private final /* synthetic */ zzrm zzbtr;

    zzrl(zzrm zzrmVar) {
        this.zzbtr = zzrmVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        zzrm zzrmVar = this.zzbtr;
        zzrmVar.zzbte.zza(zzrmVar.zzbtt, zzrmVar.zzbtu, str, zzrmVar.zzbtv);
    }
}
