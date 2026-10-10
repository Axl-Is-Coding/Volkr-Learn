package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GV {
    public static byte[] A00;
    public static String[] A01;

    static {
        A04();
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{60, 12, 11, 53, 27, 17, 49, 27, 17, 100, 31, 54, 99, 71, ci.m, 125, 51, 50, 98, 20};
    }

    public static void A04() {
        A01 = new String[]{"gehgTzpUAqg89EXiGGasdpNXUtk8k2dp", "VbYmpptfSIV8qdRodswF8V1n59zym7XK", "E44YX0wg", "TCU5yEG5ZIofchF4EQjDHlsQntmp46Yu", "EkmeYw2kQLbBECw2eANnaw7CzESY", "H", "OFssNajfj", "bi8IHmxX7dNFBPIWLmj9QBiFjZgAYPjN"};
    }

    public static GZ A00(GZ gz, String[] strArr, Map<String, GZ> map) {
        if (gz == null && strArr == null) {
            return null;
        }
        int i = 0;
        if (gz == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (gz == null && strArr.length > 1) {
            GZ gz2 = new GZ();
            int length = strArr.length;
            while (i < length) {
                String id = strArr[i];
                gz2.A0F(map.get(id));
                i++;
            }
            return gz2;
        }
        if (gz != null && strArr != null && strArr.length == 1) {
            return gz.A0F(map.get(strArr[0]));
        }
        if (gz != null && strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i < length2) {
                gz.A0F(map.get(strArr[i]));
                i++;
            }
            return gz;
        }
        return gz;
    }

    public static String A02(String str) {
        String strA01 = A01(0, 1, 106);
        String strReplaceAll = str.replaceAll(A01(1, 2, 93), strA01).replaceAll(A01(4, 5, 103), strA01);
        String strA012 = A01(3, 1, 73);
        return strReplaceAll.replaceAll(strA01, strA012).replaceAll(A01(9, 11, 99), strA012);
    }

    public static void A05(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    public static void A06(SpannableStringBuilder spannableStringBuilder, int i, int i2, GZ gz) {
        if (gz.A08() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(gz.A08()), i, i2, 33);
        }
        if (gz.A0Q()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (gz.A0R()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (gz.A0P()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(gz.A06()), i, i2, 33);
        }
        if (gz.A0O()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(gz.A05()), i, i2, 33);
        }
        if (gz.A0M() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(gz.A0M()), i, i2, 33);
        }
        Layout.Alignment alignmentA09 = gz.A09();
        String[] strArr = A01;
        if (strArr[0].charAt(0) == strArr[1].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "m";
        strArr2[2] = "ujiHtYdg";
        if (alignmentA09 != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(gz.A09()), i, i2, 33);
        }
        int iA07 = gz.A07();
        if (iA07 == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) gz.A04(), true), i, i2, 33);
        } else if (iA07 == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(gz.A04()), i, i2, 33);
        } else {
            if (iA07 != 3) {
                return;
            }
            spannableStringBuilder.setSpan(new RelativeSizeSpan(gz.A04() / 100.0f), i, i2, 33);
        }
    }
}
