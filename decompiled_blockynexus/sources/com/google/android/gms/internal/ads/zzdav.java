package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdav implements zzdvu {
    static final zzdvu zzdwz = new zzdav();

    private zzdav() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final Object apply(Object obj) {
        return ((JSONObject) obj).optString("nas");
    }
}
