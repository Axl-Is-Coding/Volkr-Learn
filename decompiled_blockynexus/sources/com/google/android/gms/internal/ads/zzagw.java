package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagw implements zzahq<Object> {
    private final zzagv zzdeq;

    public zzagw(zzagv zzagvVar) {
        this.zzdeq = zzagvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzbbq.zzfe("App event with no name parameter.");
        } else {
            this.zzdeq.onAppEvent(str, map.get("info"));
        }
    }
}
