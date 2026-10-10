package com.disabngo.blockynexus.view.activity.webview.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: StatusBarUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.app.Activity r3, int r4, int r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r2 = 21
            if (r0 < r2) goto L24
            android.view.Window r0 = r3.getWindow()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r0.addFlags(r2)
            android.view.Window r0 = r3.getWindow()
            r0.clearFlags(r1)
            android.view.Window r3 = r3.getWindow()
            int r4 = a(r4, r5)
            r3.setStatusBarColor(r4)
            goto L5f
        L24:
            r2 = 19
            if (r0 < r2) goto L5f
            android.view.Window r0 = r3.getWindow()
            r0.addFlags(r1)
            android.view.Window r0 = r3.getWindow()
            android.view.View r0 = r0.getDecorView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r0.getChildCount()
            if (r1 <= 0) goto L55
            int r1 = r1 + (-1)
            android.view.View r2 = r0.getChildAt(r1)
            boolean r2 = r2 instanceof com.disabngo.blockynexus.view.activity.webview.utils.StatusBarView
            if (r2 == 0) goto L55
            android.view.View r0 = r0.getChildAt(r1)
            int r4 = a(r4, r5)
            r0.setBackgroundColor(r4)
            goto L5c
        L55:
            com.disabngo.blockynexus.view.activity.webview.utils.StatusBarView r4 = b(r3, r4, r5)
            r0.addView(r4)
        L5c:
            a(r3)
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.view.activity.webview.utils.b.a(android.app.Activity, int, int):void");
    }

    private static StatusBarView b(Activity activity, int i, int i2) {
        StatusBarView statusBarView = new StatusBarView(activity);
        statusBarView.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        statusBarView.setBackgroundColor(a(i, i2));
        return statusBarView;
    }

    private static void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    private static int a(int i, int i2) {
        float f2 = 1.0f - (i2 / 255.0f);
        double d2 = ((i >> 16) & 255) * f2;
        Double.isNaN(d2);
        int i3 = (int) (d2 + 0.5d);
        double d3 = ((i >> 8) & 255) * f2;
        Double.isNaN(d3);
        double d4 = (i & 255) * f2;
        Double.isNaN(d4);
        return ((int) (d4 + 0.5d)) | (i3 << 16) | (-16777216) | (((int) (d3 + 0.5d)) << 8);
    }
}
