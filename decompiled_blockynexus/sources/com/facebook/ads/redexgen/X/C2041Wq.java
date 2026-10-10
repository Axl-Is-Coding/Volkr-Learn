package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2041Wq extends KT {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ AnonymousClass87 A01;
    public final /* synthetic */ C8R A02;
    public final /* synthetic */ C8Z A03;
    public final /* synthetic */ String A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-37, -3, 30, 27, 46, 32, -39, 28, 43, 26, 44, 33, -39, 27, 30, 28, 26, 46, 44, 30, -39, 44, -2, 39, 47, 34, 43, 40, 39, 38, 30, 39, 45, -3, 26, 45, 26, 9, 43, 40, 47, 34, 29, 30, 43, -39, 39, 40, 45, -39, 34, 39, 35, 30, 28, 45, 30, 29, -46, -24, -19, -22, -97, -24, -14, -97, -19, -12, -21, -21, -96, 30, 33, 33, 38, 49, 38, 44, 43, 30, 41, 28, 38, 43, 35, 44, 45, 66, 45, 53, 56, 45, 46, 56, 49, 43, 48, 53, Utf8.REPLACEMENT_BYTE, 55, 43, Utf8.REPLACEMENT_BYTE, 60, 45, 47, 49, 62, 60, 62, 67, 64, 104, 91, 89, 101, 104, 90, 85, 90, 87, 106, 87, 88, 87, 105, 91, -18, -31, -19, -15, -31, -17, -16, -37, -27, -32, 44, 46, 27, 45, 50, 41, 30, 49, 51, 32, 50, 55, 46, 35, 29, 33, 45, 34, 35};
    }

    public C2041Wq(AnonymousClass87 anonymousClass87, String str, int i, C8Z c8z, C8R c8r) {
        this.A01 = anonymousClass87;
        this.A04 = str;
        this.A00 = i;
        this.A03 = c8z;
        this.A02 = c8r;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        String stackTrace;
        Map<String, String> mapA4S;
        String strA6Y;
        try {
            if (C8S.A0K(this.A01, this.A04, this.A00, this.A03)) {
                return;
            }
            JF.A06(this.A01, J7.A0A.toString() + A00(0, 1, 41) + this.A04);
            Throwable cause = this.A03.getCause();
            if (cause != null) {
                stackTrace = LG.A03(this.A01, cause);
            } else if (J0.A0S(this.A01)) {
                stackTrace = LG.A03(this.A01, this.A03);
            } else {
                stackTrace = A00(0, 0, 106) + this.A03.getMessage();
            }
            if (J0.A0W(this.A01)) {
                mapA4S = this.A01.A02().A4S();
            } else if (this.A02 != null) {
                mapA4S = this.A02.A6H();
            } else if (C8S.A02) {
                String message = A00(1, 57, 65);
                C8S.A0G(new RuntimeException(message, this.A03));
                mapA4S = new HashMap<>();
            } else {
                mapA4S = this.A01.A02().A4S();
            }
            mapA4S.put(A00(136, 7, 65), this.A04);
            mapA4S.put(A00(143, 12, 70), String.valueOf(this.A00));
            JSONObject jSONObjectA02 = this.A03.A02();
            if (jSONObjectA02 != null) {
                mapA4S.put(A00(71, 15, 69), jSONObjectA02.toString());
            }
            if ((A00(106, 5, 99).equals(this.A04) || A00(111, 15, 126).equals(this.A04)) && (strA6Y = this.A01.A02().A6Y()) != null) {
                mapA4S.put(A00(86, 20, 84), strA6Y);
            }
            String strA07 = this.A01.A07();
            if (strA07 != null && !TextUtils.isEmpty(strA07)) {
                mapA4S.put(A00(126, 10, 4), strA07);
            }
            C8Q c8q = (C8Q) C8S.A0A.get();
            if (c8q == null) {
                C8S.A0G(new RuntimeException(A00(58, 13, 7)));
            } else {
                c8q.AED(stackTrace, mapA4S, this.A01);
            }
        } catch (Throwable th) {
            C8S.A0G(th);
        }
    }
}
