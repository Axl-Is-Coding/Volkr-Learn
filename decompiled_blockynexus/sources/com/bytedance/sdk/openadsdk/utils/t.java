package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: compiled from: ResourceHelp.java */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Resources f7129b;

    private static String a(Context context) {
        if (f7128a == null) {
            f7128a = context.getPackageName();
        }
        return f7128a;
    }

    public static int b(Context context, String str) {
        return a(context, str, "string");
    }

    public static Drawable c(Context context, String str) {
        return context.getResources().getDrawable(d(context, str));
    }

    public static int d(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int e(Context context, String str) {
        return a(context, str, "id");
    }

    public static int f(Context context, String str) {
        return a(context, str, "layout");
    }

    public static int g(Context context, String str) {
        return a(context, str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
    }

    public static int h(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int i(Context context, String str) {
        return context.getResources().getColor(j(context, str));
    }

    public static int j(Context context, String str) {
        return a(context, str, "color");
    }

    public static int k(Context context, String str) {
        return a(context, str, "integer");
    }

    public static int l(Context context, String str) {
        return context.getResources().getInteger(k(context, str));
    }

    private static int a(Context context, String str, String str2) {
        if (f7129b == null) {
            f7129b = context.getResources();
        }
        return f7129b.getIdentifier(str, str2, a(context));
    }

    public static String a(Context context, String str) {
        return context.getResources().getString(b(context, str));
    }
}
