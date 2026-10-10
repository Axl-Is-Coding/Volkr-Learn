package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmd implements zzbma {
    private final Context zzvr;

    public zzbmd(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbma
    public final void zzl(Map<String, String> map) {
        CookieManager cookieManagerZzbh;
        String str = map.get("cookie");
        if (TextUtils.isEmpty(str) || (cookieManagerZzbh = com.google.android.gms.ads.internal.zzp.zzkt().zzbh(this.zzvr)) == null) {
            return;
        }
        cookieManagerZzbh.setCookie((String) zzwm.zzpx().zzd(zzabb.zzcoi), str);
    }
}
