package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5U {
    public static byte[] A01;
    public SharedPreferences A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-41, -38, -20, -37, -24, -22, -33, -23, -33, -28, -35, -65, -38, -32, -13, -13, -15, -24, -31, -12, -13, -24, -18, -19, -56, -29, 1, -1, 1, 6, 3, -14, -15, -16, -4, -6, -69, -13, -18, -16, -14, -17, -4, -4, -8, -69, -18, -15, 0, -69, -10, -15, -13, -18, -39, -42, -38, -42, -31, -82, -47, -63, -33, -50, -48, -40, -42, -37, -44};
    }

    public C5U(AnonymousClass87 anonymousClass87) {
        this.A00 = anonymousClass87.getSharedPreferences(ProcessUtils.getProcessSpecificName(A00(33, 21, 63), anonymousClass87), 0);
    }

    public final C5T A02() {
        SharedPreferences sharedPreferences = this.A00;
        String strA00 = A00(0, 13, 40);
        if (sharedPreferences.contains(strA00)) {
            return new C5T(this.A00.getString(strA00, A00(0, 0, 80)), this.A00.getBoolean(A00(54, 15, 31), false), C5S.A09, this.A00.getLong(A00(26, 7, 80), -1L));
        }
        return C5T.A00();
    }

    public final String A03() {
        return this.A00.getString(A00(13, 13, 49), A00(0, 0, 80));
    }

    public final void A04(C5T c5t) {
        SharedPreferences.Editor editorEdit = this.A00.edit();
        editorEdit.putString(A00(0, 13, 40), c5t.A03());
        editorEdit.putBoolean(A00(54, 15, 31), c5t.A04());
        editorEdit.putLong(A00(26, 7, 80), c5t.A01());
        editorEdit.apply();
    }

    public final void A05(String str) {
        SharedPreferences.Editor editorEdit = this.A00.edit();
        editorEdit.putString(A00(13, 13, 49), str);
        editorEdit.apply();
    }
}
