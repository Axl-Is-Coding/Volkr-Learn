package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcrc implements zzdrp {
    static final zzdrp zzgjj = new zzcrc();

    private zzcrc() {
    }

    @Override // com.google.android.gms.internal.ads.zzdrp
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzayp.zzei("Ad request signals:");
        zzayp.zzei(jSONObject.toString(2));
        return jSONObject;
    }
}
