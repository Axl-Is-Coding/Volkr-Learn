package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: UIUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f7095a = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7096b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static float f7097c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f7098d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f7099e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static WindowManager f7100f;

    static {
        a(com.bytedance.sdk.openadsdk.core.o.a());
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, WebView webView) {
    }

    private static boolean a() {
        return f7095a < WheelView.DividerConfig.FILL || f7096b < 0 || f7097c < WheelView.DividerConfig.FILL || f7098d < 0 || f7099e < 0;
    }

    private static boolean a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static int b(Context context, float f2) {
        a(context);
        float fE = e(context);
        if (fE <= WheelView.DividerConfig.FILL) {
            fE = 1.0f;
        }
        return (int) ((f2 / fE) + 0.5f);
    }

    public static int c(Context context) {
        a(context);
        return f7098d;
    }

    public static int d(Context context) {
        a(context);
        return f7099e;
    }

    public static float e(Context context) {
        a(context);
        return f7095a;
    }

    public static int f(Context context) {
        a(context);
        return f7096b;
    }

    public static void g(View view) {
        if (view == null) {
            return;
        }
        a(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", WheelView.DividerConfig.FILL, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ac.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int h(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float i(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        return context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android") > 0 ? context.getApplicationContext().getResources().getDimensionPixelSize(r1) : WheelView.DividerConfig.FILL;
    }

    public static boolean j(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void a(Context context) {
        Context contextA = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
        f7100f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
        if (contextA == null) {
            return;
        }
        if (a()) {
            DisplayMetrics displayMetrics = contextA.getResources().getDisplayMetrics();
            f7095a = displayMetrics.density;
            f7096b = displayMetrics.densityDpi;
            f7097c = displayMetrics.scaledDensity;
            f7098d = displayMetrics.widthPixels;
            f7099e = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = f7098d;
            int i2 = f7099e;
            if (i > i2) {
                f7098d = i2;
                f7099e = i;
                return;
            }
            return;
        }
        int i3 = f7098d;
        int i4 = f7099e;
        if (i3 < i4) {
            f7098d = i4;
            f7099e = i3;
        }
    }

    public static int[] b(Context context) {
        if (context == null) {
            return null;
        }
        if (f7100f == null) {
            f7100f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f7100f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int iIntValue = displayMetrics.widthPixels;
            int iIntValue2 = displayMetrics.heightPixels;
            int i = Build.VERSION.SDK_INT;
            if (i >= 14 && i < 17) {
                try {
                    iIntValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    iIntValue2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                    iIntValue = point.x;
                    iIntValue2 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = iIntValue;
            iArr[1] = iIntValue2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] c(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean e(View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() == 1.0f;
    }

    public static void f(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, WheelView.DividerConfig.FILL);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ac.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ac.a(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", WheelView.DividerConfig.FILL, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int g(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowInsets");
            return cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static float a(Context context, float f2) {
        a(context);
        return (f2 * e(context)) + 0.5f;
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new j(rect, view));
    }

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static boolean b(Activity activity) {
        return a("ro.miui.notch", activity) == 1 || j(activity) || l(activity) || k(activity) || c(activity);
    }

    public static void a(View view, int i) {
        if (view == null || view.getVisibility() == i || !a(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3842);
                activity.getWindow().addFlags(134217728);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a(String str, Activity activity) {
        if (!u.e()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), new Integer(0))).intValue();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return 0;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            o.e("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            o.e("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void a(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setAlpha(f2);
    }
}
