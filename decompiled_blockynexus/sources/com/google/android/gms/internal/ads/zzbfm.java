package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfm implements Runnable {
    private final /* synthetic */ String zzecs;
    private final /* synthetic */ String zzeln;
    private final /* synthetic */ int zzelo;
    private final /* synthetic */ int zzelp;
    private final /* synthetic */ boolean zzelq;
    private final /* synthetic */ zzbfl zzelr;
    private final /* synthetic */ long zzelt;
    private final /* synthetic */ long zzelu;
    private final /* synthetic */ int zzelv;
    private final /* synthetic */ int zzelw;

    zzbfm(zzbfl zzbflVar, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzelr = zzbflVar;
        this.zzecs = str;
        this.zzeln = str2;
        this.zzelo = i;
        this.zzelp = i2;
        this.zzelt = j;
        this.zzelu = j2;
        this.zzelq = z;
        this.zzelv = i3;
        this.zzelw = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.zzecs);
        map.put("cachedSrc", this.zzeln);
        map.put("bytesLoaded", Integer.toString(this.zzelo));
        map.put("totalBytes", Integer.toString(this.zzelp));
        map.put("bufferedDuration", Long.toString(this.zzelt));
        map.put("totalDuration", Long.toString(this.zzelu));
        map.put("cacheReady", this.zzelq ? "1" : "0");
        map.put("playerCount", Integer.toString(this.zzelv));
        map.put("playerPreparedCount", Integer.toString(this.zzelw));
        this.zzelr.zza("onPrecacheEvent", (Map<String, String>) map);
    }
}
