package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfp implements Runnable {
    private final /* synthetic */ String zzecs;
    private final /* synthetic */ String zzeln;
    private final /* synthetic */ int zzelp;
    private final /* synthetic */ zzbfl zzelr;

    zzbfp(zzbfl zzbflVar, String str, String str2, int i) {
        this.zzelr = zzbflVar;
        this.zzecs = str;
        this.zzeln = str2;
        this.zzelp = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.zzecs);
        map.put("cachedSrc", this.zzeln);
        map.put("totalBytes", Integer.toString(this.zzelp));
        this.zzelr.zza("onPrecacheEvent", (Map<String, String>) map);
    }
}
