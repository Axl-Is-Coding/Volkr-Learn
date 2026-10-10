package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcos implements zzeoy<zzdzc<String>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdsi> zzfqv;

    private zzcos(zzeph<zzdsi> zzephVar, zzeph<Context> zzephVar2) {
        this.zzfqv = zzephVar;
        this.zzesu = zzephVar2;
    }

    public static zzcos zzap(zzeph<zzdsi> zzephVar, zzeph<Context> zzephVar2) {
        return new zzcos(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdsi zzdsiVar = this.zzfqv.get();
        final CookieManager cookieManagerZzbh = com.google.android.gms.ads.internal.zzp.zzkt().zzbh(this.zzesu.get());
        zzdrr zzdrrVarZzavs = zzdsiVar.zzu(zzdsf.WEBVIEW_COOKIE).zzc(new Callable(cookieManagerZzbh) { // from class: com.google.android.gms.internal.ads.zzcoo
            private final CookieManager zzgjk;

            {
                this.zzgjk = cookieManagerZzbh;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = this.zzgjk;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) zzwm.zzpx().zzd(zzabb.zzcoi));
            }
        }).zza(1L, TimeUnit.SECONDS).zza(Exception.class, zzcon.zzgjj).zzavs();
        zzepe.zza(zzdrrVarZzavs, "Cannot return null from a non-@Nullable @Provides method");
        return zzdrrVarZzavs;
    }
}
