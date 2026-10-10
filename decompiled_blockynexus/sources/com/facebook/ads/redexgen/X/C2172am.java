package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2172am implements InterfaceC1855Pk {
    public static byte[] A02;
    public final /* synthetic */ long A00;
    public final /* synthetic */ K6 A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{ci.l, 9, 89, 89, 94, 89, 5, 5, 89, 95, 10, 10, 10, 9, 10, ci.n, 9, 21, 20, 31, 34, 57, Utf8.REPLACEMENT_BYTE, 42, 46, 51, 53, 52, 96, 122, 83, 101, 114, 118, 101, 114, 32, 101, 114, 114, 111, 114, 32, 111, 99, 99, 117, 114, 114, 101, 100, 117, 67, 84, 80, 67, 84, 6, 84, 67, 86, 74, 79, 67, 66, 6, 85, 83, 69, 69, 67, 85, 85, 64, 83, 74, 74, 95, 19, 18, Utf8.REPLACEMENT_BYTE, 19, 17, 12, ci.n, 25, 8, 25, 61, 60, 23, 32, 32, 61, 32};
    }

    public C2172am(K6 k6, long j) {
        this.A01 = k6;
        this.A00 = j;
    }

    private final void A02(C1867Pw c1867Pw) {
        K2.A07(this.A01.A01);
        try {
            InterfaceC1853Pi interfaceC1853PiA00 = c1867Pw.A00();
            if (interfaceC1853PiA00 != null) {
                String strA5b = interfaceC1853PiA00.A5b();
                K9 k9A06 = this.A01.A06.A06(this.A01.A05, strA5b, this.A00, this.A01.A03);
                if (k9A06.A01() == K8.A03) {
                    C2149aP c2149aP = (C2149aP) k9A06;
                    String strA04 = c2149aP.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c2149aP.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA5b = strA04;
                    }
                    this.A01.A05.A0A().A2m(LP.A01(this.A01.A00), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA5b, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A01.A0G(C1697Jd.A02(adErrorTypeAdErrorTypeFromCode, strA5b));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c1867Pw.getMessage();
            this.A01.A05.A0A().A2m(LP.A01(this.A01.A00), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            this.A01.A0G(C1697Jd.A02(adErrorType, message));
        } catch (JSONException e2) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String message2 = c1867Pw.getMessage();
            C0R c0rA0A = this.A01.A05.A0A();
            long jA01 = LP.A01(this.A01.A00);
            int errorCode = adErrorType2.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String errorMessage = A00(15, 15, 14);
            sb.append(errorMessage);
            String errorMessage2 = e2.getMessage();
            sb.append(errorMessage2);
            c0rA0A.A2m(jA01, errorCode, sb.toString(), adErrorType2.isPublicError());
            this.A01.A0G(C1697Jd.A02(adErrorType2, message2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1855Pk
    public final void A9U(InterfaceC1853Pi interfaceC1853Pi) {
        C1710Jr.A05(A00(78, 10, 40), A00(51, 27, 114), A00(8, 7, 59));
        if (interfaceC1853Pi != null) {
            String strA5b = interfaceC1853Pi.A5b();
            K2.A07(this.A01.A01);
            this.A01.A0P(strA5b, this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1855Pk
    public final void A9q(Exception exc) {
        C1710Jr.A05(A00(88, 7, 6), A00(30, 21, 84), A00(0, 8, 104));
        if (C1867Pw.class.equals(exc.getClass())) {
            A02((C1867Pw) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String message = exc.getMessage();
        this.A01.A05.A0A().A2m(LP.A01(this.A01.A00), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
        this.A01.A0G(C1697Jd.A02(adErrorType, message));
    }
}
