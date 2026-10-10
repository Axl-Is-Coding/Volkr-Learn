package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfk implements Runnable {
    private final /* synthetic */ String zzecs;
    private final /* synthetic */ String zzeln;
    private final /* synthetic */ int zzelo;
    private final /* synthetic */ int zzelp;
    private final /* synthetic */ boolean zzelq = false;
    private final /* synthetic */ zzbfl zzelr;

    zzbfk(zzbfl zzbflVar, String str, String str2, int i, int i2, boolean z) {
        this.zzelr = zzbflVar;
        this.zzecs = str;
        this.zzeln = str2;
        this.zzelo = i;
        this.zzelp = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.zzecs);
        map.put("cachedSrc", this.zzeln);
        map.put("bytesLoaded", Integer.toString(this.zzelo));
        map.put("totalBytes", Integer.toString(this.zzelp));
        map.put("cacheReady", this.zzelq ? "1" : "0");
        this.zzelr.zza("onPrecacheEvent", (Map<String, String>) map);
    }
}
