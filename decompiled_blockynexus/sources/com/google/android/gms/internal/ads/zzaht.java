package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzaht {
    private final View view;
    private final zzeg zzbpk;
    private final Context zzvr;

    public zzaht(Context context, zzeg zzegVar, View view) {
        this.zzvr = context;
        this.zzbpk = zzegVar;
        this.view = view;
    }

    @VisibleForTesting
    private final ResolveInfo zza(Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = this.zzvr.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= listQueryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = listQueryIntentActivities.get(i);
                    if (resolveInfoResolveActivity != null && resolveInfoResolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveInfoResolveActivity;
                        break;
                    }
                    i++;
                }
            }
            arrayList.addAll(listQueryIntentActivities);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
        return resolveInfo;
    }

    @VisibleForTesting
    private final ResolveInfo zzb(Intent intent) {
        return zza(intent, new ArrayList<>());
    }

    private static Intent zze(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.Intent zzc(java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaht.zzc(java.util.Map):android.content.Intent");
    }

    private static Intent zza(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }
}
