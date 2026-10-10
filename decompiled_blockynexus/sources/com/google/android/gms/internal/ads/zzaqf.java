package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqf {
    private final zzbgj zzdgy;
    private final boolean zzdnp;
    private final String zzdnq;

    public zzaqf(zzbgj zzbgjVar, Map<String, String> map) {
        this.zzdgy = zzbgjVar;
        this.zzdnq = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdnp = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdnp = true;
        }
    }

    public final void execute() {
        int iZzxw;
        if (this.zzdgy == null) {
            zzbbq.zzfe("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdnq)) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            iZzxw = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdnq)) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            iZzxw = 6;
        } else {
            iZzxw = this.zzdnp ? -1 : com.google.android.gms.ads.internal.zzp.zzkt().zzxw();
        }
        this.zzdgy.setRequestedOrientation(iZzxw);
    }
}
