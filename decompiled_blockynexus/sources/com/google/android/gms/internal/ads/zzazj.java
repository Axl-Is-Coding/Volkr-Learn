package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class zzazj extends zzazg {
    @Override // com.google.android.gms.internal.ads.zzazd
    public final zzbgi zza(zzbgj zzbgjVar, zzts zztsVar, boolean z) {
        return new zzbhm(zzbgjVar, zztsVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final CookieManager zzbh(Context context) {
        if (zzazd.zzxy()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbbq.zzc("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final int zzxz() {
        return R.style.Theme.Material.Dialog.Alert;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
