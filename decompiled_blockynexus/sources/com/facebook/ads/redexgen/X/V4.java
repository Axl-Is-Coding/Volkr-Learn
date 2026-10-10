package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V4 extends C6P {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{73, 91, 95, 74, 41, 75, ci.l, 119, 106, 102, 109, 97, 118, 12, 47, 24, 24, 5, 24, 74, 8, 31, 3, 6, ci.l, 3, 4, ci.k, 74, 12, 3, 6, ci.m, 74, 37, 8, 0, ci.m, 9, 30, 47, 30, ci.k, 12, 26, 95, 58, 17, 9, 95, 41, 30, ci.k, 22, 30, 29, 19, 26};
    }

    public static void A0A() {
        A01 = new String[]{"y8Nq67FtAwLOnhnq1UqleBVuRpU5lwEq", "kKy3QSHCMFgMLI4jLKgpj6Ml3G5G", "CtFK8Pc2dFCHV68GnB3BGsunpwsbXZLI", "F24bvZCYxJ", "TOSHYJ1lEJvd7RJrf6C3asPns89jgyAB", "1i4XZgSUiEitKg1uirtbWyvJYEy72451", "xxTjtjFBsKHKUg72VLV3KyKqm", "tv2qbFeBoe5tOdCVBoBS0k7Q0eg7h6FY"};
    }

    static {
        A0A();
        A09();
        A02 = V4.class.getSimpleName();
    }

    public V4(Context context, C13815p c13815p) {
        super(context, c13815p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A02(HashMap<String, V3> map) {
        return new WS(SystemClock.elapsedRealtime(), A03(), map, EnumC14036m.A0C);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException", "BadMethodUse-android.util.Log.e"})
    public static File A03(String str) {
        try {
            String strSubstring = str.substring(0, str.lastIndexOf(File.separator));
            String fileName = str.substring(str.lastIndexOf(File.separator) + 1);
            return new File(strSubstring, fileName);
        } catch (Exception e2) {
            Log.e(A02, A05(14, 26, 93), e2);
            return null;
        }
    }

    public static String A06(String str) {
        if (((str.hashCode() == 902502675 && str.equals(A05(6, 8, 5))) ? (byte) 0 : (byte) -1) != 0) {
            String strA05 = A05(0, 0, 28);
            if (A01[0].charAt(3) != 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "jdgM3VinY7vKBuJQR961ULiFKj7S";
            strArr[3] = "O0JYmDhqre";
            return strA05;
        }
        return Environment.getExternalStorageDirectory().toString();
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static String A07(String regex) {
        String strA05 = A05(0, 6, 66);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(strA05).matcher(regex);
        while (matcher.find()) {
            String matchedPattern = matcher.group();
            matcher.appendReplacement(stringBuffer, A06(matchedPattern));
        }
        matcher.appendTail(stringBuffer);
        String regex2 = stringBuffer.toString();
        try {
            regex2 = new File(regex2).getCanonicalPath();
            return regex2;
        } catch (IOException e2) {
            Log.e(A02, A05(40, 18, 72), e2);
            return regex2;
        }
    }

    public final C6Y A0H(List<C6X> list) {
        return new V2(this, list);
    }
}
