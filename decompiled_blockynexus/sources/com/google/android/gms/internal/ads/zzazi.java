package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
public class zzazi extends zzazj {
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcts)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctu)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzwm.zzpt();
        int iZzc = zzbbg.zzc(activity, configuration.screenHeightDp);
        int iZzc2 = zzbbg.zzc(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzp.zzkr();
        DisplayMetrics displayMetricsZza = zzayu.zza(windowManager);
        int i = displayMetricsZza.heightPixels;
        int i2 = displayMetricsZza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d2 = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d2);
        int iRound = ((int) Math.round(d2 + 0.5d)) * ((Integer) zzwm.zzpx().zzd(zzabb.zzctr)).intValue();
        return !(zze(i, iZzc + dimensionPixelSize, iRound) && zze(i2, iZzc2, iRound));
    }
}
