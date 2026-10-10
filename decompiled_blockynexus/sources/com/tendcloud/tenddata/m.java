package com.tendcloud.tenddata;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20034a = true;

    public static void a(String str, Throwable th) {
        if (f20034a) {
            a(str, 4);
            th.printStackTrace();
        }
    }

    private static void b(String str, int i) {
        String strA = a();
        if (i == 2) {
            Log.v(strA, str);
            return;
        }
        if (i == 3) {
            Log.d(strA, str);
            return;
        }
        if (i == 4) {
            Log.i(strA, str);
        } else if (i == 5) {
            Log.w(strA, str);
        } else {
            if (i != 6) {
                return;
            }
            Log.e(strA, str);
        }
    }

    public static void dForDeveloper(String str) {
        if (f20034a) {
            a(str, 3);
        }
    }

    public static void dForInternal(String... strArr) {
    }

    public static void eForDeveloper(String str) {
        if (f20034a) {
            a(str, 6);
        }
    }

    public static void eForInternal(Throwable th) {
    }

    public static void eForInternal(String... strArr) {
    }

    public static void iForDeveloper(String str) {
        if (f20034a) {
            a(str, 4);
        }
    }

    public static void iForInternal(String... strArr) {
    }

    public static void json(String str) {
    }

    private static void a(String str, int i) {
        if (str == null) {
            return;
        }
        try {
            int length = str.length();
            int i2 = 2000;
            int i3 = 0;
            int i4 = 0;
            while (i3 < 100) {
                if (length > i2) {
                    b(str.substring(i4, i2), i);
                    i3++;
                    i4 = i2;
                    i2 += 2000;
                } else {
                    b(str.substring(i4, length), i);
                    return;
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private static synchronized String a() {
        try {
            new Exception().getStackTrace()[4].getClassName().lastIndexOf(Consts.DOT);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return ab.u;
        }
        return ab.u;
    }
}
