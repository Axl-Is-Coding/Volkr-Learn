package com.warkiz.widget;

import com.google.firebase.crashlytics.internal.common.IdManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: compiled from: FormatUtils.java */
/* JADX INFO: loaded from: classes5.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[][] f21379a = {"0.".toCharArray(), IdManager.DEFAULT_VERSION_NAME.toCharArray(), "0.00".toCharArray(), "0.000".toCharArray(), "0.0000".toCharArray(), "0.00000".toCharArray(), "0.000000".toCharArray(), "0.0000000".toCharArray(), "0.00000000".toCharArray(), "0.000000000".toCharArray(), "0.0000000000".toCharArray(), "0.00000000000".toCharArray(), "0.000000000000".toCharArray(), "0.0000000000000".toCharArray(), "0.00000000000000".toCharArray(), "0.000000000000000".toCharArray()};

    static String a(double d2, int i) {
        char[] cArr;
        int iAbs = Math.abs(i);
        double dAbs = (Math.abs(d2) * Math.pow(10.0d, iAbs)) + 0.5d;
        if (dAbs > 9.99999999999999E14d || iAbs > 16) {
            return b(d2, iAbs);
        }
        long jNextUp = (long) Math.nextUp(dAbs);
        if (jNextUp < 1) {
            return "0";
        }
        char[] charArray = Long.toString(jNextUp).toCharArray();
        if (charArray.length > iAbs) {
            int length = charArray.length - 1;
            int length2 = charArray.length - iAbs;
            while (length >= length2 && charArray[length] == '0') {
                length--;
            }
            if (length >= length2) {
                cArr = new char[length + 2];
                System.arraycopy(charArray, 0, cArr, 0, length2);
                cArr[length2] = '.';
                System.arraycopy(charArray, length2, cArr, length2 + 1, (length - length2) + 1);
            } else {
                cArr = new char[length2];
                System.arraycopy(charArray, 0, cArr, 0, length2);
            }
        } else {
            int length3 = charArray.length - 1;
            while (length3 >= 0 && charArray[length3] == '0') {
                length3--;
            }
            char[] cArr2 = f21379a[iAbs - charArray.length];
            char[] cArrCopyOf = Arrays.copyOf(cArr2, cArr2.length + length3 + 1);
            System.arraycopy(charArray, 0, cArrCopyOf, cArr2.length, length3 + 1);
            cArr = cArrCopyOf;
        }
        if (Math.signum(d2) > 0.0d) {
            return new String(cArr);
        }
        return "-" + new String(cArr);
    }

    private static String b(double d2, int i) {
        String string = new BigDecimal(Double.toString(d2)).setScale(Math.abs(i), RoundingMode.HALF_UP).toString();
        if (i == 0) {
            return string;
        }
        int length = string.length() - 1;
        while (length >= 0 && string.charAt(length) == '0') {
            length--;
        }
        String strSubstring = string.substring(0, length + 1);
        return strSubstring.charAt(strSubstring.length() + (-1)) == '.' ? strSubstring.substring(0, strSubstring.length() - 1) : strSubstring;
    }
}
