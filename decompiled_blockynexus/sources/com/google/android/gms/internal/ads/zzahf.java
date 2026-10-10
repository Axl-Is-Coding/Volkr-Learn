package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahf implements zzahq<zzbgj> {
    zzahf() {
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        JSONObject jSONObjectZzsi;
        zzbgj zzbgjVar2 = zzbgjVar;
        zzads zzadsVarZzach = zzbgjVar2.zzach();
        if (zzadsVarZzach == null || (jSONObjectZzsi = zzadsVarZzach.zzsi()) == null) {
            zzbgjVar2.zza("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzbgjVar2.zza("nativeAdViewSignalsReady", jSONObjectZzsi);
        }
    }
}
