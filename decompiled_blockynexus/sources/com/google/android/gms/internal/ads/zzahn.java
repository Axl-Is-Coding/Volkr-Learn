package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahn implements zzahq<zzbgj> {
    zzahn() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        zzbgj zzbgjVar2 = zzbgjVar;
        WindowManager windowManager = (WindowManager) zzbgjVar2.getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzp.zzkr();
        DisplayMetrics displayMetricsZza = zzayu.zza(windowManager);
        int i = displayMetricsZza.widthPixels;
        int i2 = displayMetricsZza.heightPixels;
        int[] iArr = new int[2];
        HashMap map2 = new HashMap();
        ((View) zzbgjVar2).getLocationInWindow(iArr);
        map2.put("xInPixels", Integer.valueOf(iArr[0]));
        map2.put("yInPixels", Integer.valueOf(iArr[1]));
        map2.put("windowWidthInPixels", Integer.valueOf(i));
        map2.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbgjVar2.zza("locationReady", map2);
        zzbbq.zzfe("GET LOCATION COMPILED");
    }
}
