package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzwm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zza {
    public static boolean zza(Context context, zzb zzbVar, zzv zzvVar) {
        int i = 0;
        if (zzbVar == null) {
            zzbbq.zzfe("No intent data for launcher overlay.");
            return false;
        }
        zzabb.initialize(context);
        Intent intent = zzbVar.intent;
        if (intent != null) {
            return zza(context, intent, zzvVar);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzbVar.url)) {
            zzbbq.zzfe("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(zzbVar.mimeType)) {
            intent2.setData(Uri.parse(zzbVar.url));
        } else {
            intent2.setDataAndType(Uri.parse(zzbVar.url), zzbVar.mimeType);
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzbVar.packageName)) {
            intent2.setPackage(zzbVar.packageName);
        }
        if (!TextUtils.isEmpty(zzbVar.zzdoj)) {
            String[] strArrSplit = zzbVar.zzdoj.split("/", 2);
            if (strArrSplit.length < 2) {
                String strValueOf = String.valueOf(zzbVar.zzdoj);
                zzbbq.zzfe(strValueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(strValueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str = zzbVar.zzdok;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzbbq.zzfe("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctk)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctj)).booleanValue()) {
                com.google.android.gms.ads.internal.zzp.zzkr();
                zzayu.zzb(context, intent2);
            }
        }
        return zza(context, intent2, zzvVar);
    }

    private static boolean zza(Context context, Intent intent, zzv zzvVar) {
        try {
            String strValueOf = String.valueOf(intent.toURI());
            zzayp.zzei(strValueOf.length() != 0 ? "Launching an intent: ".concat(strValueOf) : new String("Launching an intent: "));
            com.google.android.gms.ads.internal.zzp.zzkr();
            zzayu.zza(context, intent);
            if (zzvVar == null) {
                return true;
            }
            zzvVar.zzvd();
            return true;
        } catch (ActivityNotFoundException e2) {
            zzbbq.zzfe(e2.getMessage());
            return false;
        }
    }
}
