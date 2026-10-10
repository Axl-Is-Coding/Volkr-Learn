package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhs;
import com.umeng.analytics.pro.au;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahu<T extends zzbfy & zzbhi & zzbhl & zzbhp & zzbhq & zzbhs> implements zzahq<T> {
    private final com.google.android.gms.ads.internal.zza zzdfm;
    private final zzaqd zzdfn;

    public zzahu(com.google.android.gms.ads.internal.zza zzaVar, zzaqd zzaqdVar) {
        this.zzdfm = zzaVar;
        this.zzdfn = zzaqdVar;
    }

    @VisibleForTesting
    static Uri zza(Context context, zzeg zzegVar, Uri uri, View view, Activity activity) {
        if (zzegVar == null) {
            return uri;
        }
        try {
            return zzegVar.zzc(uri) ? zzegVar.zza(uri, context, view, activity) : uri;
        } catch (zzef unused) {
            return uri;
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    private final void zzab(boolean z) {
        zzaqd zzaqdVar = this.zzdfn;
        if (zzaqdVar != null) {
            zzaqdVar.zzac(z);
        }
    }

    private static boolean zzd(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if (au.aw.equalsIgnoreCase(str)) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return com.google.android.gms.ads.internal.zzp.zzkt().zzxw();
        }
        return -1;
    }

    @VisibleForTesting
    static Uri zzf(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e2) {
            String strValueOf = String.valueOf(uri.toString());
            zzbbq.zzc(strValueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(strValueOf) : new String("Error adding click uptime parameter to url: "), e2);
        }
        return uri;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01c3  */
    @Override // com.google.android.gms.internal.ads.zzahq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zza(java.lang.Object r14, java.util.Map r15) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahu.zza(java.lang.Object, java.util.Map):void");
    }
}
