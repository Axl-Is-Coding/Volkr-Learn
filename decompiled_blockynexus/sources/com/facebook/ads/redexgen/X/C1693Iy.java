package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.just.agentweb.WebIndicator;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1693Iy {
    public static C1693Iy A01;
    public static byte[] A02;
    public static String[] A03;
    public static final String[] A04;
    public static final String[] A05;
    public final SharedPreferences A00;

    public static String A0N(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "rwxiKY1yX8M1uCycGOqUPfCL86zZ3gS";
            strArr[0] = "P38LhqS18Cw18aUWRDVsuYtPAT7MPJu";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 46);
            i4++;
        }
    }

    public static void A0Y() {
        A02 = new byte[]{108, 73, 107, 100, 105, 111, 102, 82, 126, 127, 101, 120, 127, 100, 116, 3, 47, 46, 52, 41, 46, 53, 37, 127, 106, 92, 70, 19, 68, 90, 95, 95, 19, 81, 86, 19, 71, 82, 88, 86, 93, 19, 71, 92, 19, 82, 93, 92, 71, 91, 86, 65, 19, 87, 86, 64, 71, 90, 93, 82, 71, 90, 92, 93, 29, 6, 17, 25, 8, 112, 109, 112, 109, 0, 45, 58, 50, 35, 91, 71, 91, 71, 70, 70, 70, 43, 123, 108, 100, 117, 125, 12, 10, 121, 123, 123, 113, 124, 125, 118, 108, 121, 116, 71, 123, 116, 113, 123, 115, 107, 71, 123, 119, 118, 126, 113, 127, 34, 32, 32, 42, 39, 38, 45, 55, 34, 47, 28, 32, 47, 42, 32, 40, 48, 28, 32, 44, 45, 37, 42, 36, 109, 55, 52, 44, 28, 48, 55, 38, 51, 28, 32, 34, 45, 32, 38, 47, 28, 33, 54, 55, 55, 44, 45, 28, 55, 38, 59, 55, 25, 27, 27, 17, 28, 29, 22, 12, 25, 20, 39, 27, 20, 17, 27, 19, 11, 39, 27, 23, 22, 30, 17, 31, 86, 12, ci.m, 23, 39, 11, 12, 29, 8, 39, 27, 23, 22, 30, 17, 10, 21, 39, 26, ci.k, 12, 12, 23, 22, 39, 12, 29, 0, 12, 3, 1, 1, 11, 6, 7, 12, 22, 3, ci.l, 61, 1, ci.l, 11, 1, 9, 17, 61, 1, ci.k, 12, 4, 11, 5, 76, 22, 21, ci.k, 61, 17, 22, 7, 18, 61, 1, ci.k, 12, 4, 11, ci.n, ci.m, 3, 22, 11, ci.k, 12, 68, 70, 70, 76, 65, 64, 75, 81, 68, 73, 122, 70, 73, 76, 70, 78, 86, 122, 70, 74, 75, 67, 76, 66, 11, 81, 82, 74, 122, 86, 81, 64, 85, 122, 70, 74, 75, 67, 76, 87, 72, 68, 81, 76, 74, 75, 122, 71, 74, 65, 92, 30, 28, 28, 22, 27, 26, 17, 11, 30, 19, 32, 28, 19, 22, 28, 20, 12, 32, 28, ci.n, 17, 25, 22, 24, 81, 11, 8, ci.n, 32, 12, 11, 26, ci.m, 32, 28, ci.n, 17, 25, 22, ci.k, 18, 30, 11, 22, ci.n, 17, 32, 11, 22, 11, 19, 26, 100, 97, 107, 114, 90, 100, 102, 102, 96, 117, 113, 100, 103, 105, 96, 90, 118, 113, 100, 102, 110, 113, 119, 100, 102, 96, 90, 102, 106, 107, 113, 96, 125, 113, 90, 99, 108, 105, 113, 96, 119, 90, 118, 108, 127, 96, 23, 18, 24, 1, 41, 23, 21, 21, 19, 6, 2, 23, 20, 26, 19, 41, 5, 2, 23, 21, 29, 2, 4, 23, 21, 19, 41, 26, 19, 24, 17, 2, 30, Utf8.REPLACEMENT_BYTE, 58, 48, 41, 1, Utf8.REPLACEMENT_BYTE, 50, 50, 49, 41, 1, 61, 49, 49, 53, 55, 59, 1, 51, Utf8.REPLACEMENT_BYTE, 48, Utf8.REPLACEMENT_BYTE, 57, 59, 44, 1, 55, 48, 55, 42, 55, Utf8.REPLACEMENT_BYTE, 50, 55, 36, Utf8.REPLACEMENT_BYTE, 42, 55, 49, 48, 1, 55, 48, 1, 60, Utf8.REPLACEMENT_BYTE, 45, 59, 1, Utf8.REPLACEMENT_BYTE, 58, 1, 61, 49, 48, 42, 44, 49, 50, 50, 59, 44, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 121, 116, 116, 119, 111, 71, 116, 119, 121, 124, 71, 124, 109, 106, 113, 118, 127, 71, 107, 112, 119, 111, 113, 118, 127, 31, 26, ci.n, 9, 33, 31, ci.n, 26, 12, 17, 23, 26, 33, 31, ci.n, 12, 33, 26, 27, 10, 27, 29, 10, 17, 12, 33, 27, ci.n, 31, 28, 18, 27, 46, 43, 33, 56, ci.n, 46, 33, 43, 61, 32, 38, 43, ci.n, 46, 33, 61, ci.n, 43, 42, 59, 42, 44, 59, 32, 61, ci.n, 59, 38, 34, 42, 32, 58, 59, ci.n, 34, 60, 62, 59, 49, 40, 0, 62, 49, 59, 45, 48, 54, 59, 0, 61, 51, 62, 60, 52, 51, 54, 44, 43, 58, 59, 0, 54, 49, 43, 58, 49, 43, 0, 42, 45, 51, 0, 47, 45, 58, 57, 54, 39, 58, 44, 112, 117, 127, 102, 78, 112, 127, 117, 99, 126, 120, 117, 78, 114, 112, 114, 121, 116, 78, 124, 126, 117, 100, 125, 116, 78, 124, 112, 105, 78, 98, 120, 107, 116, 33, 36, 46, 55, 31, 33, 46, 36, 50, 47, 41, 36, 31, 35, 33, 35, 40, 37, 31, 45, 47, 36, 53, 44, 37, 31, 50, 37, 52, 50, 57, 31, 44, 41, 45, 41, 52, 5, 0, 10, 19, 59, 5, 10, 0, 22, 11, ci.k, 0, 59, 7, 11, 9, 20, 22, 1, 23, 23, 59, ci.k, 9, 5, 3, 1, 23, 59, 0, 17, 22, ci.k, 10, 3, 59, 0, 11, 19, 10, 8, 11, 5, 0, 115, 118, 124, 101, 77, 115, 124, 118, 96, 125, 123, 118, 77, 118, 119, 116, 115, 103, 126, 102, 77, 115, 97, 97, 119, 102, 77, 98, 96, 119, 126, 125, 115, 118, 77, 97, 123, 104, 119, 77, 112, 107, 102, 119, 97, 28, 25, 19, 10, 34, 28, 19, 25, ci.m, 18, 20, 25, 34, 25, 20, ci.l, 28, 31, 17, 24, 34, ci.k, 17, 28, 4, 28, 31, 17, 24, 34, ci.k, ci.m, 24, 30, 28, 30, 21, 24, 69, 64, 74, 83, 123, 69, 74, 64, 86, 75, 77, 64, 123, 65, 74, 69, 70, 72, 65, 123, 74, 69, 80, 77, 82, 65, 123, 66, 81, 74, 74, 65, 72, 97, 100, 110, 119, 95, 97, 110, 100, 114, 111, 105, 100, 95, 102, 97, 105, 108, 95, 111, 110, 95, 119, 101, 98, 118, 105, 101, 119, 95, 101, 114, 114, 111, 114, 115, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 79, 75, 71, 65, 67, 121, 69, 71, 69, 78, 67, 121, 85, 82, 73, 84, 67, 121, 68, 95, 82, 67, 121, 69, 73, 83, 72, 82, 126, 123, 113, 104, 64, 126, 113, 123, 109, 112, 118, 123, 64, 114, 122, 114, 112, 109, 102, 64, 112, 111, 107, 125, 120, 114, 107, 67, 125, 114, 120, 
        110, 115, 117, 120, 67, 113, 110, 127, 67, 117, 113, 108, 110, 121, 111, 111, 117, 115, 114, 67, 122, 115, 110, 67, 114, 125, 104, 117, 106, 121, 67, 106, 117, 120, 121, 115, 67, 125, 120, 111, 55, 50, 56, 33, 9, 55, 56, 50, 36, 57, Utf8.REPLACEMENT_BYTE, 50, 9, 59, 36, 53, 9, Utf8.REPLACEMENT_BYTE, 59, 38, 36, 51, 37, 37, Utf8.REPLACEMENT_BYTE, 57, 56, 9, 48, 57, 36, 9, 56, 55, 34, Utf8.REPLACEMENT_BYTE, 32, 51, 9, 32, Utf8.REPLACEMENT_BYTE, 50, 51, 57, 9, 55, 50, 37, 9, 32, 100, 80, 85, 95, 70, 110, 80, 95, 85, 67, 94, 88, 85, 110, 95, 84, 69, 70, 94, 67, 90, 110, 85, 84, 87, 80, 68, 93, 69, 110, 82, 94, 95, 95, 84, 82, 69, 88, 94, 95, 110, 69, 88, 92, 84, 94, 68, 69, 110, 92, 66, 12, 9, 3, 26, 50, 12, 3, 9, 31, 2, 4, 9, 50, 3, 8, 25, 26, 2, 31, 6, 50, 9, 8, 11, 12, 24, 1, 25, 50, 31, 8, 12, 9, 50, 25, 4, 0, 8, 2, 24, 25, 50, 0, 30, 120, 125, 119, 110, 70, 120, 119, 125, 107, 118, 112, 125, 70, 119, 124, 109, 110, 118, 107, 114, 70, 125, 124, 127, 120, 108, 117, 109, 70, 107, 124, 109, 107, 112, 124, 106, 70, 119, 108, 116, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 101, 110, 127, 124, 100, 121, 96, 84, 111, 110, 109, 106, 126, 103, 127, 84, 127, 99, 121, 100, 127, 127, 103, 110, 84, 127, 98, 102, 110, 100, 126, 127, 84, 102, 120, 10, ci.m, 5, 28, 52, 10, 5, ci.m, 25, 4, 2, ci.m, 52, 5, ci.l, 31, 28, 4, 25, 0, 52, ci.m, ci.l, ci.k, 10, 30, 7, 31, 52, 31, 2, 6, ci.l, 4, 30, 31, 52, 6, 24, 21, ci.n, 26, 3, 43, 21, 26, ci.n, 6, 27, 29, ci.n, 43, 27, 0, 7, 24, 43, 17, 26, 21, 22, 24, 17, ci.n, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 121, 110, 123, 100, 121, 127, 84, 123, 121, 110, 120, 110, 101, 127, 106, 127, 98, 100, 101, 84, 110, 121, 121, 100, 121, 84, 124, 99, 110, 101, 84, 101, 100, 84, 98, 102, 123, 121, 110, 120, 120, 98, 100, 101, 43, 46, 36, 61, 21, 43, 36, 46, 56, 37, 35, 46, 21, 56, 47, 58, 37, 56, 62, 21, 58, 56, 47, 57, 47, 36, 62, 43, 62, 35, 37, 36, 21, 47, 56, 56, 37, 56, 57, 21, 35, 36, 57, 62, 47, 43, 46, 21, 37, 44, 21, 35, 36, 62, 47, 56, 36, 43, 38, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 85, 78, 73, 83, 74, 66, 121, 84, 67, 85, 67, 82, 121, 64, 73, 69, 83, 85, 121, 73, 72, 121, 72, 71, 82, 79, 80, 67, 121, 84, 67, 86, 73, 84, 82, 79, 72, 65, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 109, 122, 110, 106, 123, 103, 98, 104, 113, 89, 103, 104, 98, 116, 105, 111, 98, 89, 115, 117, 99, 89, 101, 103, 101, 110, 99, 89, 107, 105, 98, 115, 106, 99, 89, 96, 105, 116, 89, 111, 107, 103, 97, 99, 117, 124, 121, 115, 106, 66, 124, 115, 121, 111, 114, 116, 121, 66, 104, 110, 120, 66, 110, 105, 120, 124, 112, 116, 115, 122, 66, 116, 112, 124, 122, 120, 66, 121, 120, 126, 114, 121, 116, 115, 122, 56, 61, 55, 46, 6, 56, 55, 61, 43, 54, 48, 61, 6, 46, 49, 48, 45, 60, 53, 48, 42, 45, 60, 61, 6, 48, 55, 45, 60, 55, 45, 6, 44, 43, 53, 6, 41, 43, 60, Utf8.REPLACEMENT_BYTE, 48, 33, 60, 42, 86, 83, 89, 64, 104, 85, 86, 89, 89, 82, 69, 104, 89, 88, 67, 94, 81, 78, 104, 86, 83, 104, 91, 88, 86, 83, 82, 83, 104, 88, 89, 104, 86, 68, 68, 82, 67, 68, 104, 91, 88, 86, 83, 82, 83, 91, 94, 84, 77, 101, 88, 95, 84, 89, 82, 87, 91, 72, 81, 101, 72, 95, 74, 85, 72, 78, 101, 83, 84, 78, 95, 72, 76, 91, 86, 101, 87, 73, 52, 49, 59, 34, 10, 55, 57, 58, 54, 62, 10, 57, 58, 54, 62, 38, 54, 39, 48, 48, 59, ci.l, 11, 1, 24, 48, 12, 29, ci.l, 28, 7, 48, 28, 7, 6, 10, 3, 11, 48, 10, 1, ci.l, ci.k, 3, 10, 11, 109, 104, 98, 123, 83, 111, 120, 109, 83, 109, 98, 101, 97, 109, 120, 101, 99, 98, 83, 104, 105, 96, 109, 117, 83, 97, 127, 58, Utf8.REPLACEMENT_BYTE, 53, 44, 4, 56, 47, 58, 4, 54, 50, 53, 4, 40, 56, 58, 55, 62, 4, 58, 53, 50, 54, 58, 47, 50, 52, 53, 4, 43, 62, 41, 56, 62, 53, 47, 58, 60, 62, 35, 38, 44, 53, 29, 38, 45, 29, 44, 45, 54, 29, 48, 39, 46, 45, 35, 38, 29, 43, 44, 54, 39, 48, 49, 54, 43, 54, 43, 35, 46, 29, 35, 38, 35, 50, 54, 39, 48, 91, 94, 84, 77, 101, 95, 84, 91, 88, 86, 95, 101, 91, 79, 78, 85, 101, 94, 95, 73, 78, 72, 85, 67, 101, 86, 95, 91, 81, 73, 45, 40, 34, 59, 19, 41, 34, 45, 46, 32, 41, 19, 46, 37, 40, 40, 41, 62, 19, 56, 35, 39, 41, 34, 19, 37, 34, 42, 35, 7, 2, 8, 17, 57, 3, 8, 7, 4, 10, 3, 57, 2, 3, 4, 19, 1, 57, 9, ci.n, 3, 20, 10, 7, 31, 41, 44, 38, Utf8.REPLACEMENT_BYTE, 23, 45, 38, 41, 42, 36, 45, 23, 45, 48, 39, 56, 36, 41, 49, 45, 58, 23, 43, 41, 43, 32, 45, 114, 119, 125, 100, 76, 118, 125, 114, 113, 127, 118, 76, 118, 107, 
        124, 99, 127, 114, 106, 118, 97, 76, 101, 33, 122, 127, 117, 108, 68, 126, 117, 122, 121, 119, 126, 68, 125, 110, 117, 117, 126, 119, 21, ci.n, 26, 3, 43, 17, 26, 21, 22, 24, 17, 43, 29, 26, 24, 29, 26, 17, 43, 12, 43, 27, 1, 0, 43, 26, 27, 26, 43, 18, 1, 24, 24, 7, 23, 6, 17, 17, 26, 43, 27, 26, 43, 7, ci.n, 31, 91, 94, 84, 77, 101, 95, 84, 91, 88, 86, 95, 101, 84, 95, 78, 77, 85, 72, 81, 51, 54, 60, 37, ci.k, 55, 60, 51, 48, 62, 55, ci.k, 61, 62, 54, ci.k, 33, 43, 60, 49, ci.k, 49, 51, 62, 62, 35, 38, 44, 53, 29, 39, 44, 35, 32, 46, 39, 29, 50, 48, 39, 46, 45, 35, 38, 26, 31, 21, 12, 36, 30, 21, 26, 25, 23, 30, 36, 9, 26, 28, 30, 36, 8, 19, 26, ci.n, 30, 66, 71, 77, 84, 124, 70, 77, 66, 65, 79, 70, 124, 80, 90, 77, 64, 52, 49, 59, 34, 10, 51, 60, 57, 33, 48, 39, 10, 55, 60, 49, 49, 60, 59, 50, 10, 33, 58, 62, 48, 59, 37, 32, 42, 51, 27, 45, 42, 48, 33, 54, 55, 48, 45, 48, 45, 37, 40, 27, 42, 33, 51, 27, 45, 41, 37, 35, 33, 27, 32, 33, 55, 45, 35, 42, 89, 92, 86, 79, 103, 84, 87, 95, 95, 81, 86, 95, 103, 93, 86, 92, 72, 87, 81, 86, 76, 103, 72, 74, 93, 94, 81, 64, 87, 82, 88, 65, 105, 88, 87, 66, 95, 64, 83, 105, 85, 87, 68, 89, 67, 69, 83, 90, 105, 85, 89, 91, 70, 87, 85, 66, 105, 66, 94, 68, 83, 69, 94, 89, 90, 82, 58, Utf8.REPLACEMENT_BYTE, 53, 44, 4, 53, 58, 47, 50, 45, 62, 4, 45, 50, 62, 44, 4, 40, 53, 58, 43, 40, 51, 52, 47, 4, 55, 52, 60, 60, 50, 53, 60, 4, 62, 53, 58, 57, 55, 62, Utf8.REPLACEMENT_BYTE, 47, 42, 32, 57, 17, 32, 43, 57, 17, 34, 47, 32, 42, 61, 45, 47, 62, 43, 17, 43, 32, 42, 45, 47, 60, 42, 10, ci.m, 5, 28, 52, 4, 5, ci.m, ci.l, 29, 2, 8, ci.l, 52, 3, 2, 24, 31, 4, 25, 18, 52, ci.m, 10, 31, 10, 52, ci.l, 5, 10, 9, 7, ci.l, ci.m, 65, 68, 78, 87, 127, 80, 76, 65, 89, 65, 66, 76, 69, 127, 67, 76, 73, 67, 75, 127, 77, 65, 88, 127, 68, 69, 76, 65, 89, 127, 77, 83, 94, 91, 81, 72, 96, 79, 83, 94, 70, 94, 93, 83, 90, 76, 96, 83, 80, 88, 88, 86, 81, 88, 96, 90, 81, 94, 93, 83, 90, 91, 24, 29, 23, ci.l, 38, 9, 21, 24, 0, 24, 27, 21, 28, 10, 38, 23, 28, ci.l, 38, 29, 28, 10, ci.n, 30, 23, ci.k, 8, 2, 27, 51, 28, 0, ci.k, 21, ci.k, ci.l, 0, 9, 31, 51, 31, 4, 3, 27, 51, 9, 2, 8, ci.m, ci.k, 30, 8, 77, 72, 66, 91, 115, 92, 94, 73, 90, 73, 66, 88, 115, 92, 64, 77, 85, 77, 78, 64, 73, 115, 77, 89, 88, 67, 115, 79, 64, 69, 79, 71, 27, 30, 20, ci.k, 37, 10, ci.m, 8, 29, 31, 37, 21, 20, 37, 78, 75, 73, 37, 8, 31, 9, 10, 21, 20, 9, 31, 100, 97, 107, 114, 90, 119, 96, 102, 106, 104, 117, 112, 113, 96, 90, 103, 113, 90, 100, 99, 113, 96, 119, 90, 96, 125, 113, 119, 100, 118, 90, 102, 109, 100, 107, 98, 96, 79, 74, 64, 89, 113, 92, 75, 67, 65, 88, 75, 113, 70, 75, 79, 74, 66, 71, 64, 75, 113, 72, 65, 92, 113, 79, 74, 113, 74, 75, 90, 79, 71, 66, 93, 96, 101, 111, 118, 94, 115, 119, 94, 99, 116, 103, 103, 100, 115, 94, 98, 105, 100, 98, 106, 94, 100, 111, 96, 99, 109, 100, 101, ci.m, 10, 0, 25, 49, 28, 24, 49, 30, 2, ci.m, 23, 12, ci.m, ci.k, 5, 49, ci.k, 28, ci.m, 29, 6, 49, 8, ci.m, 2, 2, 12, ci.m, ci.k, 5, 20, 17, 27, 2, 42, 6, ci.n, 27, 17, 28, 27, 18, 42, 19, 7, ci.n, 4, 0, ci.n, 27, 22, 12, 42, 22, 20, 5, 5, 28, 27, 18, 42, 20, 25, 25, 26, 2, ci.n, 17, 117, 112, 122, 99, 75, 103, 124, 123, 97, 120, 112, 75, 117, 112, 112, 75, 113, 108, 96, 113, 122, 103, 125, 123, 122, 75, 96, 123, 75, 100, 120, 117, 109, 117, 118, 120, 113, 103, 121, 124, 118, 111, 71, 107, 112, 119, 109, 116, 124, 71, 123, 116, 125, 121, 106, 71, 126, 125, 121, 108, 109, 106, 125, 71, 123, 119, 118, 126, 113, 127, 71, 119, 118, 71, 123, 106, 121, 107, 112, 125, 107, 123, 126, 116, 109, 69, 105, 114, 117, 111, 118, 126, 69, 115, 125, 116, 117, 104, 127, 69, 126, 127, 105, 110, 104, 117, 99, 69, 121, 123, 118, 118, 43, 46, 36, 61, 21, 57, 34, 37, Utf8.REPLACEMENT_BYTE, 38, 46, 21, 35, 36, 41, 56, 47, 39, 47, 36, 62, 21, 56, 47, 62, 56, 51, 21, 41, 37, Utf8.REPLACEMENT_BYTE, 36, 62, 47, 56, 21, 37, 36, 21, 47, 39, 58, 62, 51, 21, 56, 47, 57, 58, 37, 36, 57, 47, 56, 61, 55, 46, 6, 42, 49, 54, 44, 53, 61, 6, 48, 55, 48, 45, 6, Utf8.REPLACEMENT_BYTE, 43, 54, 52, 6, 58, 54, 55, 45, 60, 55, 45, 6, 41, 43, 54, 47, 48, 61, 60, 43, 109, 104, 98, 123, 83, 127, 100, 99, 121, 96, 104, 83, 101, 98, 101, 120, 83, 99, 98, 83, 111, 96, 109, 127, 127, 83, 96, 99, 109, 104, 101, 98, 107, 10, ci.m, 5, 28, 52, 24, 3, 4, 30, 7, ci.m, 52, 7, 4, 12, 52, 10, 24, 24, ci.l, 31, 52, 
        30, 25, 7, 100, 97, 107, 114, 90, 118, 109, 106, 112, 105, 97, 90, 117, 119, 96, 102, 106, 104, 117, 112, 113, 96, 90, 103, 108, 97, 97, 96, 119, 90, 113, 106, 110, 96, 107, 0, 5, ci.m, 22, 62, 18, 9, ci.l, 22, 62, 0, 17, 17, 62, 8, ci.m, 18, 21, 0, ci.k, ci.k, 62, 0, 5, 62, 5, 4, 21, 0, 8, ci.k, 18, 23, 18, 24, 1, 41, 5, 2, 23, 21, 29, 2, 4, 23, 21, 19, 41, 17, 4, 25, 3, 6, 31, 24, 17, 41, 19, 24, 23, 20, 26, 19, 18, 52, 49, 59, 34, 10, 38, 34, 52, 37, 10, 39, 48, 37, 58, 39, 33, 10, 52, 59, 49, 10, 54, 57, 58, 38, 48, 81, 84, 94, 71, 111, 67, 73, 94, 83, 111, 81, 86, 68, 85, 66, 111, 81, 84, 111, 92, 95, 81, 84, 115, 118, 124, 101, 77, 97, 107, 124, 113, 77, 119, 124, 118, 98, 125, 123, 124, 102, 77, 98, 96, 119, 116, 123, 106, 61, 56, 50, 43, 3, 40, 53, 49, 57, 3, 40, 51, 3, 43, 61, 53, 40, 3, 58, 51, 46, 3, 42, 53, 56, 57, 51, 3, 44, 48, 61, 37, 3, 49, 47, 71, 66, 72, 81, 121, 82, 79, 75, 67, 121, 82, 73, 121, 81, 71, 79, 82, 121, 64, 73, 84, 121, 80, 79, 66, 67, 73, 121, 86, 84, 67, 86, 71, 84, 67, 66, 121, 75, 85, 99, 102, 108, 117, 93, 118, 107, 111, 103, 109, 119, 118, 93, 112, 103, 117, 99, 112, 102, 103, 102, 93, 116, 107, 102, 103, 109, 58, Utf8.REPLACEMENT_BYTE, 53, 44, 4, 47, 41, 50, 60, 60, 62, 41, 4, 53, 58, 47, 50, 45, 62, 4, 41, 62, 60, 50, 40, 47, 62, 41, 4, 45, 50, 62, 44, 4, 62, 41, 41, 52, 41, 4, 56, 58, 55, 55, 57, 58, 56, 48, 121, 124, 118, 111, 71, 109, 118, 113, 105, 109, 125, 71, 124, 122, 71, 118, 121, 117, 125, 71, 104, 125, 106, 71, 104, 106, 119, 123, 125, 107, 107, 34, 39, 45, 52, 28, 54, 48, 38, 28, 34, 51, 51, 28, 42, 45, 48, 55, 34, 47, 47, 28, 55, 44, 44, 47, 33, 34, 49, 25, 28, 22, ci.m, 39, ci.k, 11, 29, 39, 27, 25, 27, ci.n, 29, 28, 39, 29, 0, 29, 27, ci.k, 12, 23, 10, 39, 30, 23, 10, 39, 22, 29, 12, ci.m, 23, 10, 19, 94, 91, 81, 72, 96, 74, 76, 90, 96, 92, 94, 92, 87, 90, 91, 96, 90, 71, 90, 92, 74, 75, 80, 77, 96, 86, 81, 96, 92, 94, 92, 87, 90, 96, 82, 94, 81, 94, 88, 90, 77, 44, 41, 35, 58, 18, 56, 62, 40, 18, Utf8.REPLACEMENT_BYTE, 36, 61, 61, 33, 40, 18, 44, 35, 36, 32, 44, 57, 36, 34, 35, 32, 37, 47, 54, 30, 55, 40, 36, 54, 32, 35, 40, 45, 40, 53, 56, 30, 34, 41, 36, 34, 42, 30, 32, 51, 36, 32, 30, 35, 32, 50, 36, 37, 125, 105, 104, 115, 110, 115, 104, 125, 104, 121, 67, 120, 117, 111, 125, 126, 112, 121, 120, 68, 80, 81, 74, 87, 74, 81, 68, 81, 64, 122, 64, 75, 68, 71, 73, 64, 65, 32, 47, 42, 32, 40, 36, 54, 34, 49, 39, 28, 55, 42, 46, 38, 28, 46, 48, 8, 4, 6, 69, ci.k, 10, 8, ci.l, 9, 4, 4, 0, 69, 10, ci.m, 24, 69, 45, 46, 42, Utf8.REPLACEMENT_BYTE, 62, 57, 46, 52, 40, 36, 37, 45, 34, 44, 34, 38, 33, 38, 34, 58, 34, ci.n, 42, 35, 46, Utf8.REPLACEMENT_BYTE, 60, 42, 43, ci.n, 59, 38, 34, 42, ci.n, 46, 41, 59, 42, 61, ci.n, 38, 34, Utf8.REPLACEMENT_BYTE, 61, 42, 60, 60, 38, 32, 33, ci.l, 21, 12, 12, 39, 48, 38, 33, 39, 60, 54, 33, 48, 49, 10, 49, 52, 33, 52, 10, 37, 39, 58, 54, 48, 38, 38, 60, 59, 50, 10, 54, 58, 56, 55, 60, 59, 52, 33, 60, 58, 59, 38, 94, 89, 76, 78, 70, 114, 89, 95, 76, 78, 72, 114, 94, 76, 64, 93, 65, 72, 114, 95, 76, 89, 72, 27, 4, 9, 8, 2, 50, 12, 3, 9, 50, 8, 3, 9, ci.l, 12, 31, 9, 50, 12, 24, 25, 2, 31, 2, 25, 12, 25, 8, 89, 89, 89};
    }

    public static void A0Z() {
        A03 = new String[]{"lby1W0wNbQrJZLPqMH4DTOw3yxUdqdf", "kgmV30Pytio8Y45c0SmevPSfJ", "GuqAlZnTPhAyqf6xpABukX78gW1eK", "0NViSQPmvGXLcgxETt4LuQqf8msO5qX", "Lug9XUXTwCkms8e17b8k", "9KOEFfUvG6glq1MfonBkT6Lvp1EWxJyS", "tUrZTe4M4NOwFWRIXhIm4QJOvCAxV", "2InOXM9Ds0dFubkAVSo31GYyY3vE8A8q"};
    }

    static {
        A0Z();
        A0Y();
        A04 = new String[0];
        A05 = new String[]{A0N(86, 5, 14), A0N(65, 9, 115), A0N(74, 12, 88)};
    }

    public C1693Iy(Context context) {
        this.A00 = context.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A0N(3574, 31, 69), context), 0);
    }

    public static float A00(Context context) {
        return A0M(context).A1l(A0N(1797, 39, 117), 0.98f);
    }

    public static int A01(Context context) {
        return A0M(context).A1m(A0N(417, 33, 88), 100);
    }

    public static int A02(Context context) {
        return A0M(context).A1m(A0N(1691, 33, 20), 0);
    }

    public static int A03(Context context) {
        return A0M(context).A1m(A0N(1770, 27, 34), -1);
    }

    public static int A04(Context context) {
        return A0M(context).A1m(A0N(696, 37, 110), 3);
    }

    public static int A05(Context context) {
        return A0M(context).A1m(A0N(3556, 18, 109), 0);
    }

    public static int A06(Context context) {
        return A0M(context).A1m(A0N(582, 36, 97), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
    }

    public static int A07(Context context) {
        return A0M(context).A1m(A0N(1091, 50, 31), 30000);
    }

    public static int A08(Context context) {
        return A0M(context).A1m(A0N(1185, 40, 55), 3);
    }

    public static int A09(Context context) {
        return A0M(context).A1m(A0N(1141, 44, 67), WebIndicator.MAX_UNIFORM_SPEED_DURATION);
    }

    public static int A0A(Context context) {
        return A0M(context).A1m(A0N(1225, 48, 37), 100);
    }

    public static int A0B(Context context) {
        return A0M(context).A1m(A0N(1273, 39, 69), 60000);
    }

    public static int A0C(Context context) {
        return A0M(context).A1m(A0N(2262, 38, 24), 225);
    }

    public static int A0D(Context context) {
        return A0M(context).A1m(A0N(928, 41, 8), 3145728);
    }

    public static int A0E(Context context) {
        return A0M(context).A1m(A0N(3605, 37, 97), -1);
    }

    public static int A0F(Context context) {
        return A0M(context).A1m(A0N(2401, 32, 14), 2000);
    }

    public static int A0G(Context context) {
        return A0M(context).A1m(A0N(371, 46, 43), -1);
    }

    public static int A0H(Context context) {
        return A0M(context).A1m(A0N(3685, 23, 3), 0);
    }

    public static int A0I(Context context) {
        return A0M(context).A1m(A0N(3176, 35, 114), 1000);
    }

    public static int A0J(Context context) {
        return A0M(context).A1m(A0N(3211, 39, 8), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
    }

    public static long A0K(Context context) {
        return A0M(context).A1n(A0N(662, 34, 63), 67108864L);
    }

    public static long A0L(Context context) {
        return A0M(context).A1n(A0N(777, 45, 60), 1048576L);
    }

    public static synchronized C1693Iy A0M(Context context) {
        if (A01 == null) {
            A01 = new C1693Iy(context);
        }
        return A01;
    }

    public static String A0O(Context context) {
        return A0M(context).A1o(A0N(2234, 28, 22), A0N(3736, 3, 0));
    }

    public static String A0P(Context context) {
        return A0M(context).A1o(A0N(3151, 25, 60), A0N(3736, 3, 0));
    }

    public static String A0Q(Context context) {
        return A0M(context).A1o(A0N(117, 52, 109), A0N(1, 6, 36));
    }

    public static String A0R(Context context) {
        return A0M(context).A1o(A0N(268, 51, 11), A0N(24, 41, 29));
    }

    public static String A0S(Context context) {
        return A0M(context).A1o(A0N(169, 53, 86), A0N(7, 8, 63));
    }

    public static String A0T(Context context) {
        return A0M(context).A1o(A0N(319, 52, 81), A0N(15, 9, 110));
    }

    public static Set<String> A0U(Context context) {
        return A0M(context).A0X(A0N(618, 44, 113), A04);
    }

    public static Set<String> A0V(Context context) {
        return A0M(context).A0X(A0N(3646, 39, 123), A05);
    }

    public static Set<String> A0W(Context context) {
        return A0M(context).A0X(A0N(1602, 44, 119), A04);
    }

    private Set<String> A0X(String str, String[] strArr) {
        JSONArray jSONArray;
        String strA1o = A1o(str, null);
        try {
            if (strA1o != null) {
                jSONArray = new JSONArray(strA1o);
            } else {
                jSONArray = new JSONArray((Collection) Arrays.asList(strArr));
            }
            int length = jSONArray.length();
            LinkedHashSet linkedHashSet = new LinkedHashSet(length);
            for (int i = 0; i < length; i++) {
                linkedHashSet.add(jSONArray.getString(i));
            }
            return linkedHashSet;
        } catch (JSONException unused) {
            return new LinkedHashSet();
        }
    }

    public static void A0a(Context context) {
        A0M(context).A00.edit().clear().commit();
    }

    private void A0b(@Nullable String str, @Nullable String str2) throws JSONException {
        if (str == null || str.isEmpty() || str.equals(A0N(91, 2, 121))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.A00.edit();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String key = A0N(93, 24, 54);
            if (next.equals(key)) {
                String key2 = jSONObject.getString(next);
                A0b(key2, next);
            } else {
                String string = next;
                if (str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    String key3 = A0N(0, 1, 108);
                    sb.append(key3);
                    sb.append(string);
                    string = sb.toString();
                }
                String key4 = jSONObject.getString(next);
                editorEdit.putString(string, key4);
            }
        }
        editorEdit.apply();
    }

    public static boolean A0c(Context context) {
        return A0M(context).A1o(A0N(3708, 28, 67), A0N(3519, 19, 50)).equals(A0N(3538, 18, 11));
    }

    public static boolean A0d(Context context) {
        return A0M(context).A1q(A0N(512, 38, 54), false);
    }

    public static boolean A0e(Context context) {
        return A0M(context).A1q(A0N(2573, 37, 43), false);
    }

    public static boolean A0f(Context context) {
        return A0M(context).A1q(A0N(1905, 29, 98), true);
    }

    public static boolean A0g(Context context) {
        return A0M(context).A1q(A0N(2488, 27, 66), false);
    }

    public static boolean A0h(Context context) {
        return A0M(context).A1q(A0N(733, 44, 74), true);
    }

    public static boolean A0i(Context context) {
        return A0M(context).A1q(A0N(1745, 25, 65), true);
    }

    public static boolean A0j(Context context) {
        return A0M(context).A1q(A0N(450, 62, 112), false);
    }

    public static boolean A0k(Context context) {
        return A0M(context).A1q(A0N(1836, 39, 108), true);
    }

    public static boolean A0l(Context context) {
        return A0M(context).A1q(A0N(1875, 30, 20), false);
    }

    public static boolean A0m(Context context) {
        return A0M(context).A1q(A0N(860, 33, 10), true);
    }

    public static boolean A0n(Context context) {
        return A0M(context).A1q(A0N(893, 35, 46), false);
    }

    public static boolean A0o(Context context) {
        return A0M(context).A1q(A0N(2010, 18, 53), false);
    }

    public static boolean A0p(Context context) {
        return A0M(context).A1q(A0N(550, 32, 80), false);
    }

    public static boolean A0q(Context context) {
        return A0M(context).A1q(A0N(2175, 25, 123), false);
    }

    public static boolean A0r(Context context) {
        if (Build.VERSION.SDK_INT < 18) {
            return false;
        }
        C1693Iy c1693IyA0M = A0M(context);
        String strA0N = A0N(1934, 25, 72);
        if (A03[5].charAt(10) != 'g') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "eVi9wsoxiKuO8fS3Ni664QsxmOwf4Hz";
        strArr[0] = "nOcXZ0DMfofG3U9htYbEeRQSfAelmGW";
        return c1693IyA0M.A1q(strA0N, false);
    }

    public static boolean A0s(Context context) {
        return A0M(context).A1q(A0N(2367, 34, 69), false);
    }

    public static boolean A0t(Context context) {
        return A0M(context).A1q(A0N(969, 23, 49), false);
    }

    public static boolean A0u(Context context) {
        return A0M(context).A1q(A0N(2300, 41, 117), false);
    }

    public static boolean A0v(Context context) {
        return A0M(context).A1q(A0N(2137, 22, 85), false);
    }

    public static boolean A0w(Context context) {
        return A0M(context).A1q(A0N(2645, 28, 47), true);
    }

    public static boolean A0x(Context context) {
        return A0M(context).A1q(A0N(2673, 31, 64), true);
    }

    public static boolean A0y(Context context) {
        return A0M(context).A1q(A0N(3070, 32, 88), false);
    }

    public static boolean A0z(Context context) {
        return A0M(context).A1q(A0N(222, 46, 76), false);
    }

    public static boolean A10(Context context) {
        return A0M(context).A1q(A0N(2074, 19, 20), true);
    }

    public static boolean A11(Context context) {
        return A0M(context).A1q(A0N(1646, 45, 25), false);
    }

    public static boolean A12(Context context) {
        return A0M(context).A1q(A0N(2093, 25, 124), false);
    }

    public static boolean A13(Context context) {
        return A0M(context).A1q(A0N(1312, 25, 90), true);
    }

    public static boolean A14(Context context) {
        return A0M(context).A1q(A0N(2118, 19, 108), true);
    }

    public static boolean A15(Context context) {
        return A0M(context).A1q(A0N(2515, 32, 2), true);
    }

    public static boolean A16(Context context) {
        return A0M(context).A1q(A0N(1337, 57, 37), false);
    }

    public static boolean A17(Context context) {
        return A0M(context).A1q(A0N(1394, 59, 100), true);
    }

    public static boolean A18(Context context) {
        return A0M(context).A1q(A0N(2704, 38, 91), true);
    }

    public static boolean A19(Context context) {
        return A0M(context).A1q(A0N(2742, 38, 58), true);
    }

    public static boolean A1A(Context context) {
        return A0M(context).A1q(A0N(1724, 21, 123), false);
    }

    public static boolean A1B(Context context) {
        return A0M(context).A1q(A0N(2780, 43, 54), true);
    }

    public static boolean A1C(Context context) {
        return A0M(context).A1q(A0N(822, 38, 83), false);
    }

    public static boolean A1D(Context context) {
        return A0M(context).A1q(A0N(2433, 30, 17), true);
    }

    public static boolean A1E(Context context) {
        return A0M(context).A1q(A0N(992, 48, 50), false);
    }

    public static boolean A1F(Context context) {
        return A0M(context).A1q(A0N(1040, 51, 120), false);
    }

    public static boolean A1G(Context context) {
        return A0M(context).A1q(A0N(2823, 31, 52), false);
    }

    public static boolean A1H(Context context) {
        return A0M(context).A1q(A0N(2854, 53, 100), false);
    }

    public static boolean A1I(Context context) {
        return A0M(context).A1q(A0N(2907, 38, 119), true);
    }

    public static boolean A1J(Context context) {
        return A0M(context).A1q(A0N(2945, 33, 34), false);
    }

    public static boolean A1K(Context context) {
        return A0M(context).A1q(A0N(2978, 25, 69), false);
    }

    public static boolean A1L(Context context) {
        return A0M(context).A1q(A0N(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, 35, 43), false);
    }

    public static boolean A1M(Context context) {
        return A0M(context).A1q(A0N(2547, 26, 84), false);
    }

    public static boolean A1N(Context context) {
        return A0M(context).A1q(A0N(2610, 35, 0), false);
    }

    public static boolean A1O(Context context) {
        return A0M(context).A1q(A0N(1453, 51, 8), true);
    }

    public static boolean A1P(Context context) {
        return A0M(context).A1q(A0N(3038, 32, 79), false);
    }

    public static boolean A1Q(Context context) {
        return A0M(context).A1q(A0N(3102, 26, 123), false);
    }

    public static boolean A1R(Context context) {
        return A0M(context).A1q(A0N(3128, 23, 30), true);
    }

    public static boolean A1S(Context context) {
        return A0M(context).A1q(A0N(3250, 27, 44), false);
    }

    public static boolean A1T(Context context) {
        return A0M(context).A1q(A0N(3356, 28, 109), false);
    }

    public static boolean A1U(Context context) {
        return A0M(context).A1q(A0N(3486, 33, 111), false);
    }

    public static boolean A1V(Context context) {
        return A0M(context).A1q(A0N(2028, 46, 90), true);
    }

    public static boolean A1W(Context context) {
        return A0M(context).A1q(A0N(2200, 34, 106), false);
    }

    public static boolean A1X(Context context) {
        return A0M(context).A1q(A0N(3461, 25, 99), false);
    }

    public static boolean A1Y(Context context) {
        return A0M(context).A1q(A0N(3325, 31, 54), false);
    }

    public static boolean A1Z(Context context) {
        return A0M(context).A1q(A0N(2159, 16, 13), true);
    }

    public static boolean A1a(Context context) {
        return A0M(context).A1q(A0N(3277, 48, 117), false);
    }

    public static boolean A1b(Context context) {
        return A0M(context).A1q(A0N(1504, 18, 54), false);
    }

    public static boolean A1c(Context context) {
        return A0M(context).A1q(A0N(1522, 40, 40), false);
    }

    public static boolean A1d(Context context) {
        return A0M(context).A1q(A0N(3384, 36, 86), false);
    }

    public static boolean A1e(Context context) {
        return A0M(context).A1q(A0N(3420, 41, 17), true);
    }

    public static boolean A1f(Context context) {
        return A1g(context) && A0M(context).A1q(A0N(1959, 27, 102), false);
    }

    public static boolean A1g(Context context) {
        return Build.VERSION.SDK_INT >= 19 && A0M(context).A1q(A0N(1986, 24, 61), false);
    }

    public static boolean A1h(Context context) {
        return A0M(context).A1q(A0N(2341, 26, 96), false);
    }

    public static boolean A1i(Context context) {
        return A0M(context).A1q(A0N(2463, 25, 87), false);
    }

    public static boolean A1j(Context context) {
        return A0M(context).A1q(A0N(1562, 40, 51), true);
    }

    public final double A1k(String str, double d2) {
        String string = this.A00.getString(str, String.valueOf(d2));
        if (string != null) {
            try {
                if (string.equals(A0N(3642, 4, 78))) {
                    return d2;
                }
                d2 = Double.valueOf(string).doubleValue();
                return d2;
            } catch (NumberFormatException unused) {
                return d2;
            }
        }
        return d2;
    }

    public final float A1l(String str, float f2) {
        String string = this.A00.getString(str, String.valueOf(f2));
        if (string != null) {
            try {
                if (string.equals(A0N(3642, 4, 78))) {
                    return f2;
                }
                f2 = Float.valueOf(string).floatValue();
                return f2;
            } catch (NumberFormatException unused) {
                return f2;
            }
        }
        return f2;
    }

    public final int A1m(String str, int i) {
        String string = this.A00.getString(str, String.valueOf(i));
        if (string != null) {
            try {
                if (string.equals(A0N(3642, 4, 78))) {
                    return i;
                }
                i = Integer.valueOf(string).intValue();
                return i;
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i;
    }

    public final long A1n(String str, long j) {
        String string = this.A00.getString(str, String.valueOf(j));
        if (string != null) {
            try {
                if (string.equals(A0N(3642, 4, 78))) {
                    return j;
                }
                j = Long.valueOf(string).longValue();
                return j;
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    public final String A1o(String str, String str2) {
        String string = this.A00.getString(str, str2);
        return (string == null || string.equals(A0N(3642, 4, 78))) ? str2 : string;
    }

    public final void A1p(@Nullable String str) throws JSONException {
        A0b(str, null);
    }

    public final boolean A1q(String str, boolean z) {
        String string = this.A00.getString(str, String.valueOf(z));
        if (string != null) {
            boolean zEquals = string.equals(A0N(3642, 4, 78));
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[7] = "2ZyfpebDvRtNljKwQKDVcWpHPVLB6mST";
            strArr[7] = "2ZyfpebDvRtNljKwQKDVcWpHPVLB6mST";
            if (zEquals) {
                return z;
            }
            Boolean boolValueOf = Boolean.valueOf(string);
            String[] strArr2 = A03;
            if (strArr2[3].length() != strArr2[0].length()) {
                String[] strArr3 = A03;
                strArr3[3] = "hV4gkZa6iTnBQtPHVFcfTHmR1bNEdnz";
                strArr3[0] = "i5HGVVHoY9v13oxeOLvfdWmm2ZFB1W9";
                return boolValueOf.booleanValue();
            }
            String[] strArr4 = A03;
            strArr4[3] = "399Nx2YcC1GvFjLdWekHdHFO2r6iBpJ";
            strArr4[0] = "0IRISDuTH5uUbCTD7GqL21M5oCfRTNA";
            return boolValueOf.booleanValue();
        }
        return z;
    }
}
