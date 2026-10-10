package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class K6 {
    public static byte[] A08;
    public static String[] A09;
    public static final ThreadFactoryC1742La A0A;
    public static final Executor A0B;
    public K3 A01;
    public K5 A02;

    @Nullable
    public String A03;
    public Map<String, String> A04;
    public final C2026Wb A05;
    public long A00 = -1;
    public final K7 A06 = K7.A00();
    public final String A07 = KA.A00();

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A08 = new byte[]{59, 60, 108, 58, 111, 105, Utf8.REPLACEMENT_BYTE, 58, 122, 105, 107, 119, 117, 78, 65, 68, 72, 67, 89, 82, 95, 72, 92, 88, 72, 94, 89, 82, 68, 73, 98, 88, 11, 121, 101, 17, 11, 100, 101, 10, 108, 99, 102, 102, 10, 88, 79, 73, 79, 67, 92, 79, 78, 20, 53, 122, 28, 51, 54, 54, 122, Utf8.REPLACEMENT_BYTE, 40, 40, 53, 40, 122, 57, 53, 62, Utf8.REPLACEMENT_BYTE, 122, 1, 127, 41, 7, 122, 127, 41, 38, 7, 72, 6, ci.k, 28, 31, 7, 26, 3, 72, 11, 7, 6, 6, ci.k, 11, 28, 1, 7, 6, 88, 90, 81, 90, 77, 86, 92, 40, 35, 50, 49, 41, 52, 45, 55, 54, 31, 48, 53, 53, 17, 54, 54, 50};
    }

    public static void A0D() {
        A09 = new String[]{"jHqhq9rNYSSw", "oXXasJZKheaqJc0eeEDaqL9fqatR6yjH", "HZfV4vlkHnOHSqnfuZFUyeF6uFp1ZMa", "ctGGwCiuI8x2mhpb6iYaTSYvEv38GMVI", "hooRY0JbS2MOmGEMLhPLLpjKFYik6yA6", "UUaZIloNsnWPLtNmJ6BLiWitv8uuoCfe", "8CdfBsPlUzO8votQ5auuotJRUMhSpJIA", "YHWLBZkCs2mlLEga5omnGJot9WkTYHBz"};
    }

    static {
        A0D();
        A0C();
        A0A = new ThreadFactoryC1742La();
        A0B = Executors.newCachedThreadPool(A0A);
    }

    public K6(C2026Wb c2026Wb) {
        this.A05 = c2026Wb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC1855Pk A04(long j) {
        return new C2172am(this, j);
    }

    private void A0B() {
        C2026Wb c2026Wb = this.A05;
        if (c2026Wb == null || !Q1.A0C(c2026Wb)) {
            return;
        }
        C8Z c8z = new C8Z(A06(8, 5, 107));
        c8z.A03(1);
        this.A05.A04().A8H(A06(107, 7, 22), C8Y.A1d, c8z);
    }

    private void A0E(int i, String str) {
        String strA06 = A06(114, 10, 9);
        C1710Jr.A05(strA06, A06(37, 16, 122), A06(0, 8, 90));
        C1710Jr.A04(strA06, String.format(Locale.US, A06(53, 26, 10), Integer.valueOf(i), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(C1697Jd c1697Jd) {
        K5 k5 = this.A02;
        if (k5 != null) {
            k5.A9p(c1697Jd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(C1697Jd c1697Jd) {
        LS.A00(new C2167ah(this, c1697Jd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(C2166ag c2166ag) {
        K5 k5 = this.A02;
        if (k5 != null) {
            k5.ABM(c2166ag);
        }
    }

    private void A0N(C2166ag c2166ag) {
        QK qkA0C;
        LS.A00(new C2169aj(this, c2166ag));
        if (C1693Iy.A1R(this.A05) && (qkA0C = XA.A02().A0C()) != null) {
            qkA0C.A5H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(String str, long j) {
        String str2;
        try {
            K9 k9A06 = this.A06.A06(this.A05, str, j, this.A03);
            C14498q c14498qA00 = k9A06.A00();
            C13775l.A06(this.A05.A00(), str);
            if (c14498qA00 != null) {
                C1693Iy.A0M(this.A05).A1p(c14498qA00.A08());
                DynamicLoaderFactory.makeLoader(this.A05).getInitApi().maybeAttachCrashListener(this.A05);
                AnonymousClass22.A0P(this.A05.A00(), c14498qA00.A06());
                K2.A06(c14498qA00.A05().A0B(), this.A01);
                C1753Ll.A01(this.A05, A0B, c14498qA00);
                C8Z c8z = new C8Z(A06(30, 7, 123) + L2.A02());
                c8z.A04(1);
                c8z.A08(false);
                this.A05.A04().A8f(A06(100, 7, 111), C8Y.A1E, c8z);
            }
            int i = K4.A00[k9A06.A01().ordinal()];
            if (i == 1) {
                C2166ag c2166ag = (C2166ag) k9A06;
                if (c14498qA00 != null) {
                    if (c14498qA00.A05().A0E()) {
                        K2.A08(str, this.A01);
                    }
                    if (this.A04 != null) {
                        str2 = this.A04.get(A06(13, 17, 93));
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(k9A06.A02()) && !TextUtils.isEmpty(str2)) {
                        new C1691Iw(this.A05, str2, k9A06.A02()).A0C();
                    }
                }
                this.A05.A0A().A2n(LP.A01(this.A00));
                A0N(c2166ag);
                return;
            }
            if (i != 2) {
                AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                this.A05.A0A().A2m(LP.A01(this.A00), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                A0G(C1697Jd.A02(adErrorType, str));
                return;
            }
            C2149aP c2149aP = (C2149aP) k9A06;
            String finalErrMessage = c2149aP.A04();
            AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c2149aP.A03(), AdErrorType.ERROR_MESSAGE);
            A0E(c2149aP.A03(), finalErrMessage);
            if (finalErrMessage == null) {
                finalErrMessage = str;
            }
            this.A05.A0A().A2m(LP.A01(this.A00), adErrorTypeAdErrorTypeFromCode.getErrorCode(), finalErrMessage, adErrorTypeAdErrorTypeFromCode.isPublicError());
            A0G(C1697Jd.A02(adErrorTypeAdErrorTypeFromCode, finalErrMessage));
        } catch (Exception e2) {
            String errorMessage = e2.getMessage();
            AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
            C0R c0rA0A = this.A05.A0A();
            long jA01 = LP.A01(this.A00);
            int errorCode = adErrorType2.getErrorCode();
            boolean zIsPublicError = adErrorType2.isPublicError();
            if (A09[2].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A09;
            strArr[3] = "KiE48ndyzelvmzNW6bdZaRvZ6MMpVlPo";
            strArr[1] = "apnThSuxD28F5jipUISQB7XXqWmqfDCi";
            c0rA0A.A2m(jA01, errorCode, errorMessage, zIsPublicError);
            A0G(C1697Jd.A02(adErrorType2, errorMessage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0P(String str, long j) {
        A0B.execute(new C2175ap(this, str, j));
    }

    public final void A0Q(K3 k3) {
        this.A00 = System.currentTimeMillis();
        if (LN.A00(this.A05) == LM.A07) {
            A0B();
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String strA06 = A06(79, 21, 56);
            this.A05.A0A().A2m(LP.A01(this.A00), adErrorType.getErrorCode(), strA06, adErrorType.isPublicError());
            A0G(new C1697Jd(adErrorType, strA06));
            return;
        }
        this.A01 = k3;
        C14408h.A0B(this.A05);
        if (K2.A09(k3)) {
            String strA02 = K2.A02(k3);
            if (strA02 != null) {
                this.A05.A0A().ADz();
                A0P(strA02, 0L);
                return;
            } else {
                AdErrorType adErrorType2 = AdErrorType.LOAD_TOO_FREQUENTLY;
                this.A05.A0A().A2m(LP.A01(this.A00), adErrorType2.getErrorCode(), adErrorType2.getDefaultErrorMessage(), adErrorType2.isPublicError());
                A0G(C1697Jd.A02(adErrorType2, null));
                return;
            }
        }
        A0B.execute(new C2179at(this, k3));
    }

    public final void A0R(K5 k5) {
        this.A02 = k5;
    }
}
