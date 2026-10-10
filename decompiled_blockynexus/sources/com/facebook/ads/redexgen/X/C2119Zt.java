package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import com.umeng.analytics.pro.ci;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2119Zt implements InterfaceC1754Lm {
    public static byte[] A03;
    public static String[] A04;
    public C14498q A00;
    public InterfaceC1854Pj A01;
    public final Executor A02;

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{107, 110, 110, 104, 109, 96, 104, 106, 111, 107, 106, 105, 110, 104, 107, 64, 75, 69, 66, 65, 71, 70, 64, 66, 74, 74, 71, 70, 65, 70, 64, 79, 69, 79, 67, 69, 79, 66, 70, 79, 79, 65, 79, 70, 71, 10, 79, 20, ci.n, 68, 79, 23, 71, ci.n, 68, 65, 66, 67, 65, 66, 64, 23, 64, 21, 64, 70, 18, 65, 70, 65, ci.n, 67, 20, 21, 68, 69, 21, 68, 116, 86, 89, 84, 82, 91, 30, 50, 42, 115, 60, 39, 59, 54, 33, 32, 115, Utf8.REPLACEMENT_BYTE, 60, 52, 58, 61, 115, 50, 32, 115, 42, 60, 38, 115, 39, 60, 115, 55, 54, 49, 38, 52, 108, 115, 27, 60, 36, 115, 55, 60, 115, 42, 60, 38, 115, 33, 54, 35, 33, 60, 55, 38, 48, 54, 115, 39, 59, 54, 115, 58, 32, 32, 38, 54, 108, 83, 101, 110, 100, 32, 82, 101, 112, 111, 114, 116, 52, 11, 2, 23, 67, 43, 2, 19, 19, 6, ci.k, 6, 7, 92, 27, 25, 25, 31, 9, 9, 37, ci.l, 21, 17, 31, 20, ci.l, 12, 25, 8, 10, 2, 31, 20, 50, 4, 9, 42, 37, 32, 44, 39, 61, 22, 61, 32, 36, 44, 90, 85, 80, 92, 87, 77, 102, 77, 86, 82, 92, 87, 108, 96, 97, 105, 102, 104, 80, 102, 107, 32, 33, 55, 39, 54, 45, 52, 48, 45, 43, 42, 61, 53, 36, 49, 52, 49, 36, 49, 116, 112, 106, 122, 70, 112, 119, 127, 118, 106, 108, 122, 109, 64, 118, 123, 122, 113, 107, 118, 121, 118, 122, 109};
    }

    public static void A06() {
        A04 = new String[]{"ZQ30B3g1EnWzQxn3crjjGmBLF8czgnrz", "nRJ0geoMgiM0DOpSqitarteTb49iW4bu", "zkGhqanHWGORl0FJV2wFc9MBhnbxSqBt", "Ydk0P72aTQrHa0LOhdAcfW", "R4envBHR3aj", "p22B9bEQtnR9xLSz", "XdKDLLdRQiXAjT4HFpZKaT6yuzMG741E", "BfaY"};
    }

    public C2119Zt(Executor executor, C14498q c14498q, C2026Wb c2026Wb) {
        this.A01 = Q1.A01(c2026Wb.A00());
        this.A02 = executor;
        this.A00 = c14498q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A03(String str) {
        C1868Px miscInfo = new C1868Px();
        C1868Px c1868Px = new C1868Px();
        C1868Px c1868Px2 = new C1868Px();
        miscInfo.put(A01(257, 15, 96), C5V.A00().A03());
        miscInfo.put(A01(220, 9, 112), A01(15, 15, 13));
        miscInfo.put(A01(186, 11, 18), A01(0, 15, 38));
        miscInfo.put(A01(174, 12, 5), A01(30, 48, 9));
        miscInfo.put(A01(197, 11, 54), (System.currentTimeMillis() / 1000) + A01(0, 0, 125));
        String strA07 = this.A00.A07();
        if (strA07 != null) {
            c1868Px2.put(A01(208, 12, 70), strA07);
        }
        if (A04[2].charAt(28) != 'S') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[1] = "6c1y5rO2F72616lTK87Vm3xCzjJjlGKf";
        strArr[1] = "6c1y5rO2F72616lTK87Vm3xCzjJjlGKf";
        c1868Px.put(A01(229, 11, 59), str);
        c1868Px.put(A01(248, 9, 102), L6.A01(c1868Px2));
        miscInfo.A05(A01(240, 8, 47), L6.A01(c1868Px));
        return miscInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(C14498q c14498q) {
        this.A00 = c14498q;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1754Lm
    public final void ABE() {
        Activity activityA00 = C1728Kk.A00();
        if (activityA00 == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activityA00);
        builder.setTitle(A01(160, 14, 28));
        EditText editText = new EditText(activityA00);
        editText.setSingleLine(false);
        editText.setImeOptions(FileTypeUtils.GIGABYTE);
        editText.setHint(A01(84, 65, 44));
        editText.setMaxLines(2);
        editText.setMinLines(2);
        builder.setView(editText);
        builder.setNegativeButton(A01(78, 6, 72), new DialogInterfaceOnClickListenerC1751Lj(this));
        builder.setPositiveButton(A01(149, 11, 127), new DialogInterfaceOnClickListenerC1752Lk(this, editText));
        builder.create().show();
    }
}
