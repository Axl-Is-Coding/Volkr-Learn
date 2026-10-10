package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: VisibilityChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class w {
    private static boolean a(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        long jHeight = ((long) rect.height()) * ((long) rect.width());
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        return height > 0 && jHeight * 100 >= ((long) i) * height;
    }

    private static boolean b(View view, int i) {
        return view.getWidth() >= c(view, i) && view.getHeight() >= d(view, i);
    }

    private static int c(View view, int i) {
        if (i != 3) {
            return 20;
        }
        double dC = ac.c(view.getContext().getApplicationContext());
        Double.isNaN(dC);
        return (int) (dC * 0.7d);
    }

    private static int d(View view, int i) {
        if (i == 3) {
            return ac.d(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int b(View view, int i, int i2) throws Throwable {
        if (!a(view.getContext())) {
            return 4;
        }
        if (!a(view)) {
            return 1;
        }
        if (b(view, i2)) {
            return !a(view, i) ? 3 : 0;
        }
        return 6;
    }

    private static boolean a(Context context) throws Throwable {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
        return ((Boolean) (method != null ? method.invoke(powerManager, new Object[0]) : false)).booleanValue();
    }

    private static boolean a(View view) {
        return view != null && view.isShown();
    }

    public static boolean a(View view, int i, int i2) {
        try {
            return b(view, i, i2) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
