package cn.qqtheme.framework.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class CompatUtils {
    @TargetApi(21)
    public static Drawable getDrawable(Context context, int i) {
        return Build.VERSION.SDK_INT < 21 ? context.getResources().getDrawable(i) : context.getDrawable(i);
    }

    @TargetApi(16)
    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }
}
