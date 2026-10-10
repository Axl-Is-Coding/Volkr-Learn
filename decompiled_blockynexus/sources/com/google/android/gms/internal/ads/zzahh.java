package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahh implements zzahq<Object> {
    zzahh() {
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        String strValueOf = String.valueOf(map.get("string"));
        zzbbq.zzfd(strValueOf.length() != 0 ? "Received log message: ".concat(strValueOf) : new String("Received log message: "));
    }
}
