package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12620x extends BroadcastReceiver {
    public static byte[] A04;
    public static String[] A05;
    public RB A00;
    public InterfaceC12610w A01;
    public C2026Wb A02;
    public String A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-39, -92, -80, -82, 111, -89, -94, -92, -90, -93, -80, -80, -84, 111, -94, -91, -76, 111, -86, -81, -75, -90, -77, -76, -75, -86, -75, -86, -94, -83, 111, -94, -92, -75, -86, -73, -86, -75, -70, -96, -91, -90, -76, -75, -77, -80, -70, -90, -91, -72, -60, -62, -125, -69, -74, -72, -70, -73, -60, -60, -64, -125, -74, -71, -56, -125, -66, -61, -55, -70, -57, -56, -55, -66, -55, -66, -74, -63, -125, -74, -72, -55, -66, -53, -66, -55, -50, -76, -71, -70, -56, -55, -57, -60, -50, -70, -71, -113, -44, -32, -34, -97, -41, -46, -44, -42, -45, -32, -32, -36, -97, -46, -43, -28, -97, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35, -97, -44, -35, -38, -44, -36, -42, -43, ci.k, 25, 23, -40, ci.n, 11, ci.k, ci.m, 12, 25, 25, 21, -40, 11, ci.l, 29, -40, 19, 24, 30, ci.m, 28, 29, 30, 19, 30, 19, 11, 22, -40, ci.k, 22, 19, ci.k, 21, ci.m, ci.l, -28, -87, -75, -77, 116, -84, -89, -87, -85, -88, -75, -75, -79, 116, -89, -86, -71, 116, -81, -76, -70, -85, -72, -71, -70, -81, -70, -81, -89, -78, 116, -86, -81, -71, -77, -81, -71, -71, -85, -86, -76, -64, -66, 127, -73, -78, -76, -74, -77, -64, -64, -68, 127, -78, -75, -60, 127, -70, -65, -59, -74, -61, -60, -59, -70, -59, -70, -78, -67, 127, -75, -70, -60, -66, -70, -60, -60, -74, -75, -117, -58, -46, -48, -111, -55, -60, -58, -56, -59, -46, -46, -50, -111, -60, -57, -42, -111, -52, -47, -41, -56, -43, -42, -41, -52, -41, -52, -60, -49, -111, -57, -52, -42, -45, -49, -60, -36, -56, -57, -30, -18, -20, -83, -27, -32, -30, -28, -31, -18, -18, -22, -83, -32, -29, -14, -83, -24, -19, -13, -28, -15, -14, -13, -24, -13, -24, -32, -21, -83, -29, -24, -14, -17, -21, -32, -8, -28, -29, -71, -104, -92, -94, 99, -101, -106, -104, -102, -105, -92, -92, -96, 99, -106, -103, -88, 99, -98, -93, -87, -102, -89, -88, -87, -98, -87, -98, -106, -95, 99, -102, -89, -89, -92, -89, -53, -41, -43, -106, -50, -55, -53, -51, -54, -41, -41, -45, -106, -55, -52, -37, -106, -47, -42, -36, -51, -38, -37, -36, -47, -36, -47, -55, -44, -106, -51, -38, -38, -41, -38, -94, -66, -54, -56, -119, -63, -68, -66, -64, -67, -54, -54, -58, -119, -68, -65, -50, -119, -60, -55, -49, -64, -51, -50, -49, -60, -49, -60, -68, -57, -119, -63, -60, -55, -60, -50, -61, -70, -68, -66, -49, -60, -47, -60, -49, -44, -107, -93, -81, -83, 110, -90, -95, -93, -91, -94, -81, -81, -85, 110, -95, -92, -77, 110, -87, -82, -76, -91, -78, -77, -76, -87, -76, -87, -95, -84, 110, -87, -83, -80, -78, -91, -77, -77, -87, -81, -82, 110, -84, -81, -89, -89, -91, -92, -75, -63, -65, -128, -72, -77, -75, -73, -76, -63, -63, -67, -128, -77, -74, -59, -128, -69, -64, -58, -73, -60, -59, -58, -69, -58, -69, -77, -66, -128, -69, -65, -62, -60, -73, -59, -59, -69, -63, -64, -128, -66, -63, -71, -71, -73, -74, -116, -52, -40, -42, -105, -49, -54, -52, -50, -53, -40, -40, -44, -105, -54, -51, -36, -105, -46, -41, -35, -50, -37, -36, -35, -46, -35, -46, -54, -43, -105, -37, -50, -32, -54, -37, -51, -23, -11, -13, -76, -20, -25, -23, -21, -24, -11, -11, -15, -76, -25, -22, -7, -76, -17, -12, -6, -21, -8, -7, -6, -17, -6, -17, -25, -14, -76, -8, -21, -3, -25, -8, -22, -64, 21, 33, 31, -32, 24, 19, 21, 23, 20, 33, 33, 29, -32, 19, 22, 37, -32, 27, 32, 38, 23, 36, 37, 38, 27, 38, 27, 19, 30, -32, 36, 23, 41, 19, 36, 22, 17, 37, 23, 36, 40, 23, 36, 17, 24, 19, 27, 30, 39, 36, 23, -61, -49, -51, -114, -58, -63, -61, -59, -62, -49, -49, -53, -114, -63, -60, -45, -114, -55, -50, -44, -59, -46, -45, -44, -55, -44, -55, -63, -52, -114, -46, -59, -41, -63, -46, -60, -65, -45, -59, -46, -42, -59, -46, -65, -58, -63, -55, -52, -43, -46, -59, -102, -46, -34, -36, -99, -43, -48, -46, -44, -47, -34, -34, -38, -99, -48, -45, -30, -99, -40, -35, -29, -44, -31, -30, -29, -40, -29, -40, -48, -37, -99, -31, -44, -26, -48, -31, -45, -50, -30, -44, -31, -27, -44, -31, -50, -30, -28, -46, -46, -44, -30, -30, -73, -61, -63, -126, -70, -75, -73, -71, -74, -61, -61, -65, -126, -75, -72, -57, -126, -67, -62, -56, -71, -58, -57, -56, -67, -56, -67, -75, -64, -126, -58, -71, -53, -75, -58, -72, -77, -57, -71, -58, -54, -71, -58, -77, -57, -55, -73, -73, -71, -57, -57, -114};
    }

    public static void A02() {
        A05 = new String[]{"Mqy89T38jyDNWJYJSU97Fc", "8J9Kjrdi7zCHtnCCZzRPzmuoDEsoDeEL", "VQNvZgn", "c7o7ADX8z3LY2p80YK3DAawzYrr5z54S", "gktsaQP9OjZySj1PqQ2WnsX4vKhqWtKG", "61ITioRvjCkhn", "SKricJIDyiylSn4Sa9TNq02zv28wIgF", "PC7X20f3JEut9CIsHKyQodWFOl4CO7PL"};
    }

    public C12620x(C2026Wb c2026Wb, String str, RB rb, InterfaceC12610w interfaceC12610w) {
        this.A02 = c2026Wb;
        this.A03 = str;
        this.A01 = interfaceC12610w;
        this.A00 = rb;
    }

    public final void A03() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(495, 48, 29) + this.A03);
        intentFilter.addAction(A00(291, 40, 74) + this.A03);
        intentFilter.addAction(A00(212, 40, 28) + this.A03);
        intentFilter.addAction(A00(135, 38, 117) + this.A03);
        intentFilter.addAction(A00(366, 36, 51) + this.A03);
        intentFilter.addAction(A00(49, 49, 32) + this.A03);
        intentFilter.addAction(A00(579, 37, 81) + this.A03);
        intentFilter.addAction(A00(770, 52, 31) + this.A03);
        intentFilter.addAction(A00(667, 52, 43) + this.A03);
        intentFilter.addAction(A00(402, 46, 38) + this.A03);
        C2E.A00(this.A02).A07(this, intentFilter);
    }

    public final void A04() {
        try {
            C2E.A00(this.A02).A06(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str = intent.getAction().split(A00(0, 1, 106))[0];
        if (this.A01 == null || str == null) {
            return;
        }
        if (A00(98, 37, 60).equals(str)) {
            this.A01.AA3(this.A00, null, true);
            return;
        }
        boolean zEquals = A00(173, 39, 17).equals(str);
        if (A05[0].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "aZIvEWsb8DNHwIIatfYd47toXevBFNNm";
        strArr[3] = "aZIvEWsb8DNHwIIatfYd47toXevBFNNm";
        if (zEquals) {
            this.A01.AA4(this.A00);
            return;
        }
        if (A00(252, 39, 46).equals(str)) {
            InterfaceC12610w interfaceC12610w = this.A01;
            RB rb = this.A00;
            if (A05[3].charAt(4) != 'D') {
                String[] strArr2 = A05;
                strArr2[0] = "TqpNublq1V6zWfVafs4QLB";
                strArr2[0] = "TqpNublq1V6zWfVafs4QLB";
                interfaceC12610w.AA5(rb);
                return;
            }
            String[] strArr3 = A05;
            strArr3[3] = "eUYQ7IhEg8fLvUIhXbZonlQsFkme40oK";
            strArr3[3] = "eUYQ7IhEg8fLvUIhXbZonlQsFkme40oK";
            interfaceC12610w.AA5(rb);
            return;
        }
        if (A00(448, 47, 11).equals(str)) {
            this.A01.AA8(this.A00);
            return;
        }
        if (A00(331, 35, 0).equals(str)) {
            if (C1693Iy.A17(context)) {
                this.A01.AA7(this.A00, AdError.AD_PRESENTATION_ERROR);
                return;
            } else {
                this.A01.AA7(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        }
        if (A00(1, 48, 12).equals(str)) {
            this.A01.onInterstitialActivityDestroyed();
            return;
        }
        if (A00(543, 36, 52).equals(str)) {
            InterfaceC12610w interfaceC12610w2 = this.A01;
            String[] strArr4 = A05;
            if (strArr4[5].length() != strArr4[6].length()) {
                String[] strArr5 = A05;
                strArr5[5] = "PFaD7A78iWhw0";
                strArr5[6] = "Xokjp6dtHHi9pHEHnv2i6gjJxblfyLK";
                interfaceC12610w2.AA9();
                return;
            }
            String[] strArr6 = A05;
            strArr6[5] = "QgYf1mTjAK5D7";
            strArr6[6] = "MAH4q6CsALUjtSr7ZeRTo0JQtTwrXFy";
            interfaceC12610w2.AA9();
            return;
        }
        if (A00(719, 51, 58).equals(str)) {
            this.A01.AAB();
            return;
        }
        if (!A00(616, 51, 125).equals(str)) {
            return;
        }
        InterfaceC12610w interfaceC12610w3 = this.A01;
        if (A05[7].charAt(0) != 'P') {
            throw new RuntimeException();
        }
        String[] strArr7 = A05;
        strArr7[0] = "2dNMpRkIvORsTqY7tSIXPx";
        strArr7[0] = "2dNMpRkIvORsTqY7tSIXPx";
        interfaceC12610w3.AAA();
    }
}
