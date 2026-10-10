package io.rong.common.fwlog;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class LogSplitUtil {
    private static final int MAX_CONTENT_SIZE = 850;
    public static final String SUFFIX_SPLIT = "-X";

    private static void merge(int i, String str, String str2, int i2, int i3, String str3, Object... objArr) {
        if (i2 >= i3) {
            return;
        }
        Object[] objArr2 = new Object[i3 - i2];
        for (int i4 = 0; i4 < i3; i4++) {
            objArr2[i4] = objArr[i2 + i4];
        }
        String strSubstring = str3.substring(0, str3.length() - 1);
        String strSubstring2 = strSubstring.substring(0, strSubstring.lastIndexOf("|"));
        if (SUFFIX_SPLIT.equals(str2) && i <= 1) {
            i = 2;
        }
        FwLog.write(i, 2, str + str2, strSubstring2, objArr2);
    }

    private static void split(int i, String str, String str2, String str3, String str4) {
        while (!TextUtils.isEmpty(str4)) {
            String str5 = str4.length() > 850 ? new String(Arrays.copyOf(str4.getBytes(), 850)) : str4;
            FwLog.write((!SUFFIX_SPLIT.equals(str2) || i > 1) ? i : 2, 2, str + str2, str3, str5);
            if (str4.length() < 850) {
                return;
            }
            str4 = str4.substring(850);
            str2 = SUFFIX_SPLIT;
        }
    }

    public static void write(int i, String str, String str2, Object... objArr) {
        int i2;
        int i3;
        String str3;
        int i4;
        Object[] objArr2 = objArr;
        int length = str2.length();
        int length2 = objArr2.length;
        int length3 = length;
        int i5 = 0;
        while (true) {
            String string = "null";
            if (i5 >= length2) {
                break;
            }
            Object obj = objArr2[i5];
            if (obj != null) {
                string = obj.toString();
            }
            length3 += string.length();
            i5++;
        }
        int i6 = 850;
        if (length3 <= 850) {
            FwLog.write(i, 2, str, str2, objArr2);
            return;
        }
        String strSubstring = str.substring(str.lastIndexOf("-"));
        String strSubstring2 = str.substring(0, str.lastIndexOf("-"));
        String[] strArrSplit = str2.split("\\|");
        String str4 = strSubstring;
        String str5 = "";
        int length4 = 0;
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        while (i8 < strArrSplit.length) {
            boolean z2 = str5.contains("|") ? true : z;
            String str6 = str5 + strArrSplit[i8] + "|";
            int length5 = length4 + str6.length();
            String string2 = objArr2[i8] != null ? objArr2[i8].toString() : "null";
            if (string2.length() < i6) {
                int length6 = length5 + string2.length();
                if (length6 > i6) {
                    i2 = i8;
                    merge(i, strSubstring2, str4, i7, i8, str6, objArr);
                    i7 = i2 + 1;
                    str5 = strArrSplit[i2] + "|";
                    length4 = strArrSplit[i2].length() + string2.length() + 1;
                    str4 = SUFFIX_SPLIT;
                    z = z2;
                } else {
                    String str7 = string2;
                    i2 = i8;
                    if (i2 != strArrSplit.length - 1) {
                        i3 = length6;
                        str3 = str4;
                        i4 = i7;
                    } else if (i7 == i2) {
                        FwLog.write((!SUFFIX_SPLIT.equals(str4) || i > 1) ? i : 2, 2, strSubstring2 + str4, strArrSplit[i2], str7);
                        i3 = length6;
                        str3 = str4;
                        i4 = i7;
                    } else {
                        i3 = length6;
                        i4 = i7;
                        str3 = str4;
                        merge(i, strSubstring2, str4, i7, i2, str6, objArr);
                    }
                    str4 = str3;
                    i7 = i4;
                    length4 = i3;
                    z = z2;
                    str5 = str6;
                }
            } else {
                String str8 = string2;
                String str9 = str4;
                i2 = i8;
                int i9 = i7;
                if (z2) {
                    if (i2 > i9) {
                        merge(i, strSubstring2, str9, i9, i2, str6, objArr);
                        str9 = SUFFIX_SPLIT;
                    }
                    split(i, strSubstring2, str9, strArrSplit[i2], str8);
                } else {
                    split(i, strSubstring2, str9, strArrSplit[i2], str8);
                }
                i7 = i2 + 1;
                str5 = "";
                str4 = SUFFIX_SPLIT;
                length4 = 0;
                z = false;
            }
            i8 = i2 + 1;
            objArr2 = objArr;
            i6 = 850;
        }
    }
}
