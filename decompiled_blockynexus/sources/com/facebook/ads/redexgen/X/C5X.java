package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5X {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[2].charAt(14) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "5u7aTW8yax3G";
            strArr[6] = "UvSwr6xgQWJsIweShl";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 109);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{118, 126, 115, 115, 124, 118, 96, 125, 123, 118, 123, 118, 40, 36, 37, Utf8.REPLACEMENT_BYTE, 46, 37, Utf8.REPLACEMENT_BYTE, 113, 100, 100, 40, 36, 38, 101, 45, 42, 40, 46, 41, 36, 36, 32, 101, 32, 42, Utf8.REPLACEMENT_BYTE, 42, 37, 42, 101, 59, 57, 36, 61, 34, 47, 46, 57, 101, 10, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 57, 34, 41, 62, Utf8.REPLACEMENT_BYTE, 34, 36, 37, 2, 47, 27, 57, 36, 61, 34, 47, 46, 57, 37, 32, 36, 32, 61, 22, 61, 59, 40, 42, 34, 32, 39, 46};
    }

    public static void A03() {
        A01 = new String[]{"BBXCQ1c8lWMx5iTCFSjBAsNmZ8", "uWpSMDe8Dl1QwAjraNXmi3HjN39WCwvV", "Nl77HN8SOPKSqciG8lmOC8DFY50qabgT", "qKAuPB5zte0w", "tHnAlNrx5zeOSNOAYBdYTMmeA", "muO01a58leOoeMmtxXp9cvgd3", "skgH0VF5dzwRL9wPv5", "Mbe4svBdXamA1BIwkYK5rcxDOVieSFVl"};
    }

    public static C5W A00(ContentResolver contentResolver) {
        String strA01 = A01(72, 14, 36);
        String strA012 = A01(3, 9, 127);
        String strA013 = A01(0, 3, 122);
        Cursor cursor = null;
        try {
            Cursor cursorQuery = contentResolver.query(Uri.parse(A01(12, 60, 38)), new String[]{strA013, strA012, strA01}, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                C5W c5w = new C5W(null, null, false);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return c5w;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex(strA013));
            String advertisingId = cursorQuery.getString(cursorQuery.getColumnIndex(strA012));
            C5W c5w2 = new C5W(string, advertisingId, Boolean.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex(strA01))).booleanValue());
            cursorQuery.close();
            return c5w2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
