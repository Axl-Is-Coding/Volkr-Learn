package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfr implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzecs;
    private final /* synthetic */ String zzeln;
    private final /* synthetic */ zzbfl zzelr;
    private final /* synthetic */ String zzelx;

    zzbfr(zzbfl zzbflVar, String str, String str2, String str3, String str4) {
        this.zzelr = zzbflVar;
        this.zzecs = str;
        this.zzeln = str2;
        this.zzelx = str3;
        this.val$message = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheCanceled");
        map.put("src", this.zzecs);
        if (!TextUtils.isEmpty(this.zzeln)) {
            map.put("cachedSrc", this.zzeln);
        }
        zzbfl zzbflVar = this.zzelr;
        map.put("type", zzbfl.zzfp(this.zzelx));
        map.put("reason", this.zzelx);
        if (!TextUtils.isEmpty(this.val$message)) {
            map.put("message", this.val$message);
        }
        this.zzelr.zza("onPrecacheEvent", (Map<String, String>) map);
    }
}
