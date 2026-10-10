package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxh {
    @VisibleForTesting
    private static Uri zza(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }

    private static String zzb(String str, Context context) {
        String strZzaf = com.google.android.gms.ads.internal.zzp.zzlp().zzaf(context);
        String strZzag = com.google.android.gms.ads.internal.zzp.zzlp().zzag(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(strZzaf)) {
            str = zza(str, "gmp_app_id", strZzaf).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(strZzag)) ? str : zza(str, "fbs_aiid", strZzag).toString();
    }

    public static String zzc(String str, Context context, boolean z) {
        String strZzah;
        if ((((Boolean) zzwm.zzpx().zzd(zzabb.zzcnw)).booleanValue() && !z) || !com.google.android.gms.ads.internal.zzp.zzlp().zzac(context) || TextUtils.isEmpty(str) || (strZzah = com.google.android.gms.ads.internal.zzp.zzlp().zzah(context)) == null) {
            return str;
        }
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcno)).booleanValue()) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (com.google.android.gms.ads.internal.zzp.zzkr().zzep(str)) {
                com.google.android.gms.ads.internal.zzp.zzlp().zzi(context, strZzah);
                return zza(zzb(str, context), "fbs_aeid", strZzah).toString();
            }
            if (!com.google.android.gms.ads.internal.zzp.zzkr().zzeq(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzp.zzlp().zzj(context, strZzah);
            return zza(zzb(str, context), "fbs_aeid", strZzah).toString();
        }
        String str2 = (String) zzwm.zzpx().zzd(zzabb.zzcnp);
        if (!str.contains(str2)) {
            return str;
        }
        if (com.google.android.gms.ads.internal.zzp.zzkr().zzep(str)) {
            com.google.android.gms.ads.internal.zzp.zzlp().zzi(context, strZzah);
            return zzb(str, context).replace(str2, strZzah);
        }
        if (!com.google.android.gms.ads.internal.zzp.zzkr().zzeq(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzp.zzlp().zzj(context, strZzah);
        return zzb(str, context).replace(str2, strZzah);
    }

    public static String zzb(Uri uri, Context context) {
        if (!com.google.android.gms.ads.internal.zzp.zzlp().zzac(context)) {
            return uri.toString();
        }
        String strZzah = com.google.android.gms.ads.internal.zzp.zzlp().zzah(context);
        if (strZzah == null) {
            return uri.toString();
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcno)).booleanValue()) {
            String str = (String) zzwm.zzpx().zzd(zzabb.zzcnp);
            String string = uri.toString();
            if (string.contains(str)) {
                com.google.android.gms.ads.internal.zzp.zzlp().zzi(context, strZzah);
                return zzb(string, context).replace(str, strZzah);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String string2 = zza(zzb(uri.toString(), context), "fbs_aeid", strZzah).toString();
            com.google.android.gms.ads.internal.zzp.zzlp().zzi(context, strZzah);
            return string2;
        }
        return uri.toString();
    }
}
