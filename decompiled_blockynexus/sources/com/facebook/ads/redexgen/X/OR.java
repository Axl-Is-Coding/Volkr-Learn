package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OR {
    public static boolean A00;
    public static byte[] A01;
    public static String[] A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "V4DWKv2CalsHghC0GoFw5ZQ5aRA0odCa";
            strArr[5] = "V4DWKv2CalsHghC0GoFw5ZQ5aRA0odCa";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 71);
            i4++;
        }
    }

    public static void A03() {
        A01 = new byte[]{-1, 36, 46, 43, 39, 28, 52, 8, 32, 47, 45, 36, 30, 46, -37, 36, 46, -37, 41, 48, 39, 39, -23, 9, 28, 42, 38, 44, 41, 26, 28, 42, -41, 32, 42, -41, 37, 44, 35, 35, -27, -65, -54, -43, -46, -51, -54, -35, -46, -40, -41, -119, -49, -54, -46, -43, -50, -51, -105, -34, -32, -35};
    }

    public static void A04() {
        A02 = new String[]{"Y0rICHp14ARSNu9MlXOQlrQKpJ7V2hwf", "9bmfgm9m8nITbmWk0ICcMAG3MrS", "cwEc0HiI6y8ZhWJ4MUGuUSsWKgKIPOUb", "CeguwAwwe", "1UN8Pz5pD", "KG5kSs2s3o8nfvSCZiVMOrQyfdZTA2DP", "BO8EwxINC4bfwl9QwPIiUjcYWt5Jq71N", "VnsxrIf3KddrD6MinhDJfsdqz9CBs5tu"};
    }

    static {
        A04();
        A03();
        A00 = true;
    }

    @Nullable
    public static BitmapDrawable A00(C2026Wb c2026Wb, @Nullable String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(str, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null && (!A00 || A06(c2026Wb, bitmapDecodeByteArray))) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapDecodeByteArray);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = c2026Wb.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    } else {
                        A05(c2026Wb, A02(0, 23, 116));
                    }
                } else {
                    A05(c2026Wb, A02(23, 18, 112));
                }
                return bitmapDrawable;
            }
            return null;
        } catch (Throwable th) {
            c2026Wb.A04().A8H(A02(59, 3, 42), C8Y.A1b, new C8Z(th));
            return null;
        }
    }

    @Nullable
    public static OS A01(C2026Wb c2026Wb, @Nullable String str) {
        BitmapDrawable bitmapDrawableA00;
        try {
            if (TextUtils.isEmpty(str) || (bitmapDrawableA00 = A00(c2026Wb, str)) == null) {
                return null;
            }
            OS os = new OS(c2026Wb);
            if (Build.VERSION.SDK_INT >= 16) {
                os.setBackground(bitmapDrawableA00);
            } else {
                os.setBackgroundDrawable(bitmapDrawableA00);
            }
            os.setClickable(false);
            os.setFocusable(false);
            return os;
        } catch (Throwable th) {
            c2026Wb.A04().A8H(A02(59, 3, 42), C8Y.A1b, new C8Z(th));
            return null;
        }
    }

    public static void A05(C2026Wb c2026Wb, String str) {
        c2026Wb.A04().A8H(A02(59, 3, 42), C8Y.A1b, new C8Z(str));
    }

    @VisibleForTesting
    public static boolean A06(C2026Wb c2026Wb, Bitmap bitmap) {
        int i = 0;
        while (true) {
            int width = bitmap.getWidth();
            if (A02[2].charAt(4) == 'h') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "44dBdHmZhYYzc5DiIB6SXSnn6xfqMO61";
            strArr[2] = "44dBdHmZhYYzc5DiIB6SXSnn6xfqMO61";
            if (i < width) {
                for (int i2 = 0; i2 < bitmap.getHeight(); i2++) {
                    if (Color.alpha(bitmap.getPixel(i, i2)) / 255.0f > 0.03f) {
                        A05(c2026Wb, A02(41, 18, 34));
                        return false;
                    }
                }
                i++;
            } else {
                return true;
            }
        }
    }
}
