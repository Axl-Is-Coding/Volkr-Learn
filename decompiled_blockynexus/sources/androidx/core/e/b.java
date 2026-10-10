package androidx.core.e;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: compiled from: ICUCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f1123b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 24) {
                try {
                    f1123b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1122a = cls.getMethod("getScript", String.class);
                f1123b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e3) {
            f1122a = null;
            f1123b = null;
            Log.w("ICUCompat", e3);
        }
    }

    public static String a(Locale locale) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i < 21) {
            String strB = b(locale);
            if (strB != null) {
                return a(strB);
            }
            return null;
        }
        try {
            return ((Locale) f1123b.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
            return locale.getScript();
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
            return locale.getScript();
        }
    }

    private static String b(Locale locale) {
        String string = locale.toString();
        try {
            if (f1123b != null) {
                return (String) f1123b.invoke(null, string);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return string;
    }

    private static String a(String str) {
        try {
            if (f1122a != null) {
                return (String) f1122a.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }
}
