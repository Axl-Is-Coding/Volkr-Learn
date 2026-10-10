package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(28)
public final class zzazk extends zzazl {
    private static void zza(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = z ? 1 : 2;
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzg(final Activity activity) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcox)).booleanValue() && com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxq() == null && !activity.isInMultiWindowMode()) {
            zza(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.internal.ads.zzazn
                private final zzazk zzebl;
                private final Activity zzebm;

                {
                    this.zzebl = this;
                    this.zzebm = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzazk.zza(this.zzebm, view, windowInsets);
                }
            });
        }
    }

    static /* synthetic */ WindowInsets zza(Activity activity, View view, WindowInsets windowInsets) {
        if (com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxq() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String strConcat = "";
            if (displayCutout != null) {
                zzayr zzayrVarZzwt = com.google.android.gms.ads.internal.zzp.zzkv().zzwt();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String str = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(strConcat)) {
                        strConcat = String.valueOf(strConcat).concat("|");
                    }
                    String strValueOf = String.valueOf(strConcat);
                    String strValueOf2 = String.valueOf(str);
                    strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                }
                zzayrVarZzwt.zzem(strConcat);
            } else {
                com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzem("");
            }
        }
        zza(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
}
