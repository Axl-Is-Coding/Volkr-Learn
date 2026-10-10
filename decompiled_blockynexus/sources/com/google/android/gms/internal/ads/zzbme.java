package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbme implements zzbma {
    private final zzdnt zzfmt;

    public zzbme(zzdnt zzdntVar) {
        this.zzfmt = zzdntVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbma
    public final void zzl(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzfmt.zzbn(Boolean.parseBoolean(str));
        } catch (Exception unused) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
