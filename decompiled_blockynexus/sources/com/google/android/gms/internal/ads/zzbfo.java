package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfo implements Runnable {
    private final /* synthetic */ String zzecs;
    private final /* synthetic */ String zzeln;
    private final /* synthetic */ zzbfl zzelr;
    private final /* synthetic */ long zzelu;

    zzbfo(zzbfl zzbflVar, String str, String str2, long j) {
        this.zzelr = zzbflVar;
        this.zzecs = str;
        this.zzeln = str2;
        this.zzelu = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.zzecs);
        map.put("cachedSrc", this.zzeln);
        map.put("totalDuration", Long.toString(this.zzelu));
        this.zzelr.zza("onPrecacheEvent", (Map<String, String>) map);
    }
}
