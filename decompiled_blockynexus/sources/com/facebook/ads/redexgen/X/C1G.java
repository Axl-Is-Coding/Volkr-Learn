package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.Serializable;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1G implements Serializable {
    public static byte[] A09 = null;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final long serialVersionUID = 8946536326456653736L;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A09 = new byte[]{37, 52, 53, 52, 49, 52, 64, 84, 67, 21, 67, 17, 66, 65, 4, 30, 23, 30, 19, 30, 68, 82, 23, 71, 23, 70, 23, 72, 58, 127, 127, 45, 41, 33, 41, 127, 127, 59, 57, 57, Utf8.REPLACEMENT_BYTE, 52, 46, 5, 57, 53, 54, 53, 40, 110, 107, 83, 111, 99, 96, 99, 126, 57, 52, Utf8.REPLACEMENT_BYTE, 34, 4, 56, 52, 55, 52, 41, ci.k, 26, ci.m, 49, ci.k, 1, 2, 1, 28, 105, 126, 107, 85, 105, 101, 102, 101, 120, 85, 101, 124, 111, 120, 85, 103, 111, 110, 99, 107, 1, 22, 3, 61, 22, 7, 26, 22, 61, 1, ci.k, ci.l, ci.k, ci.n, 31, 8, 29, 35, 8, 25, 4, 8, 35, 31, 19, ci.n, 19, ci.l, 35, 19, 10, 25, ci.l, 35, 17, 25, 24, 21, 29, 43, 45, 58, 44, 49, 44, 52, 61, 7, 59, 55, 52, 55, 42, 83, 78, 83, 75, 66, 120, 68, 72, 75, 72, 85};
    }

    static {
        A03();
        A0A = Color.parseColor(A02(14, 7, 123));
        A0B = Color.parseColor(A02(7, 7, 43));
        A0C = Color.parseColor(A02(21, 7, 45));
        String strA02 = A02(28, 9, 69);
        A0D = Color.parseColor(strA02);
        A0E = Color.parseColor(A02(0, 7, 90));
        A0F = Color.parseColor(strA02);
    }

    public C1G(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.A00 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A03 = i4;
        this.A04 = i5;
        this.A05 = i6;
        this.A06 = i7;
        this.A07 = i8;
        this.A08 = i9;
    }

    public static int A00(@Nullable JSONObject jSONObject, String str, int i) {
        if (jSONObject != null && jSONObject.has(str)) {
            return Color.parseColor(jSONObject.optString(str));
        }
        return i;
    }

    public static C1G A01(@Nullable JSONObject jSONObject) {
        return new C1G(A00(jSONObject, A02(37, 12, 6), A0A), A00(jSONObject, A02(57, 10, 7), A0B), A00(jSONObject, A02(135, 14, 4), -16777216), A00(jSONObject, A02(49, 8, 80), A0C), A00(jSONObject, A02(67, 9, 50), A0D), A00(jSONObject, A02(76, 20, 86), -1), A00(jSONObject, A02(96, 14, 62), -1), A00(jSONObject, A02(110, 25, 32), A0F), A00(jSONObject, A02(149, 11, 123), -16777216));
    }

    public final int A04(boolean z) {
        if (z) {
            return -1;
        }
        return this.A00;
    }

    public final int A05(boolean z) {
        if (z) {
            return -1;
        }
        return this.A01;
    }

    public final int A06(boolean z) {
        if (z) {
            return -1;
        }
        return this.A02;
    }

    public final int A07(boolean z) {
        return z ? A0E : this.A03;
    }

    public final int A08(boolean z) {
        return z ? this.A05 : this.A04;
    }

    public final int A09(boolean z) {
        return z ? this.A07 : this.A06;
    }

    public final int A0A(boolean z) {
        if (z) {
            return -1;
        }
        return this.A08;
    }
}
