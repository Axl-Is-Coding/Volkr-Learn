package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.ci;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1722Kd {
    public static byte[] A00;
    public static String[] A01;

    static {
        A05();
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            if (A01[4].charAt(13) == '3') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "lr9od7US3THgayVRC3YximplGEeGYREs";
            strArr[2] = "lr9od7US3THgayVRC3YximplGEeGYREs";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{60, 62, 41, 52, 43, 52, 41, 36, 54, 57, 51, 37, 56, 62, 51, 121, 54, 39, 39, 121, 22, 52, 35, 62, 33, 62, 35, 46, 3, Utf8.REPLACEMENT_BYTE, 37, 50, 54, 51, Utf8.REPLACEMENT_BYTE, 48, 58, 44, 49, 55, 58, 112, 55, 48, 42, 59, 48, 42, 112, 61, Utf8.REPLACEMENT_BYTE, 42, 59, 57, 49, 44, 39, 112, 18, 31, 11, ci.n, 29, 22, 27, 12, 53, 35, 36, 36, 51, 56, 34, 23, 53, 34, Utf8.REPLACEMENT_BYTE, 32, Utf8.REPLACEMENT_BYTE, 34, 47, 2, 62, 36, 51, 55, 50, 34, ci.l, 44, 59, 38, 57, 38, 59, 38, 42, 60};
    }

    public static void A05() {
        A01 = new String[]{"4Hyw1ld0", "fEzx6YE0SeCvem7jc58qc1uowK5CeHyF", "mKjUZIiYyhCBAWVMkGfhIPNFhY8yjY7b", "XoO13E9Z", "T5DEyuoaMCuUHewoghibS1K19XR2WHTa", "iIUB3596vuf", "PRfLmBQ8OOom6oFwc8jxiiNxNKuVVsiK", "TWoMGSFYHQz"};
    }

    public static EnumC1721Kc A00() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName(A03(8, 26, 93));
        Object objInvoke = cls.getMethod(A03(66, 21, 92), new Class[0]).invoke(null, new Object[0]);
        Field activitiesField = cls.getDeclaredField(A03(87, 11, 69));
        activitiesField.setAccessible(true);
        Map map = (Map) activitiesField.get(objInvoke);
        if (map == null) {
            return EnumC1721Kc.A0B;
        }
        for (Object obj : map.values()) {
            Field activitiesField2 = obj.getClass().getDeclaredField(A03(0, 8, 87));
            activitiesField2.setAccessible(true);
            Activity activity = (Activity) activitiesField2.get(obj);
            if (activity.isTaskRoot() && activity.getIntent().getCategories().contains(A03(34, 32, 84))) {
                return EnumC1721Kc.A06;
            }
        }
        return EnumC1721Kc.A09;
    }

    public static EnumC1721Kc A01(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return A02(context);
            }
            return A00();
        } catch (Exception unused) {
            return EnumC1721Kc.A04;
        }
    }

    @RequiresApi(api = 21)
    public static EnumC1721Kc A02(Context context) {
        if (context == null) {
            return EnumC1721Kc.A0C;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(A03(0, 8, 87));
        if (activityManager == null) {
            return EnumC1721Kc.A07;
        }
        List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
        if (appTasks.isEmpty()) {
            return EnumC1721Kc.A0A;
        }
        Iterator<ActivityManager.AppTask> it = appTasks.iterator();
        while (it.hasNext()) {
            ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
            if (taskInfo != null && taskInfo.baseIntent != null) {
                Set<String> categories = taskInfo.baseIntent.getCategories();
                if (A01[4].charAt(13) == '3') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[7] = "rbRaEFWiZz7";
                strArr[5] = "WgbgXmtUXm5";
                if (categories != null && taskInfo.baseIntent.getCategories().contains(A03(34, 32, 84))) {
                    return EnumC1721Kc.A05;
                }
            }
        }
        return EnumC1721Kc.A08;
    }
}
