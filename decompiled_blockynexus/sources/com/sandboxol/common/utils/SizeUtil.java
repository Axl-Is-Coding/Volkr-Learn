package com.sandboxol.common.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public class SizeUtil {
    public static float dp2px(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static int[] forceGetViewSize(View view) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        return new int[]{iMakeMeasureSpec, iMakeMeasureSpec2};
    }

    public static int getDeviceHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getDeviceWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getTopBarHeight(Activity activity) {
        return getStatusBarHeight(activity) + activity.getResources().getDimensionPixelOffset(R.dimen.actionBarHeight);
    }

    public static float px2dp(Context context, float f2) {
        return TypedValue.applyDimension(0, f2, context.getResources().getDisplayMetrics());
    }

    public static float px2sp(Context context, float f2) {
        return TypedValue.applyDimension(0, f2, context.getResources().getDisplayMetrics());
    }

    public static float sp2px(Context context, float f2) {
        return TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }
}
