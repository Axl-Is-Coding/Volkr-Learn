package com.unity3d.services.core.misc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.services.core.log.DeviceLog;

/* JADX INFO: loaded from: classes5.dex */
public class ViewUtilities {
    public static float dpFromPx(Context context, float f2) {
        return f2 / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(Context context, float f2) {
        return f2 * context.getResources().getDisplayMetrics().density;
    }

    public static void removeViewFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            ((ViewGroup) view.getParent()).removeView(view);
        } catch (Exception e2) {
            DeviceLog.exception("Error while removing view from it's parent", e2);
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        String str = Build.VERSION.SDK_INT < 16 ? "setBackgroundDrawable" : "setBackground";
        try {
            View.class.getMethod(str, Drawable.class).invoke(view, drawable);
        } catch (Exception e2) {
            DeviceLog.exception("Couldn't run" + str, e2);
        }
    }
}
