package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.AdError;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RX implements InterfaceC12590u {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ C1581Ek A00;
    public final /* synthetic */ Runnable A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 16);
            if (A03[2].charAt(4) == 'y') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "2VG06oAYTcRzKBDE7gWFCU36hzL5px1b";
            strArr[7] = "j1xG2z3v9jq0UO66H2WqYNbpklLAu6IG";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{114, -93, -95, 116, 110, -94, -95, -97, -124, -93, -80, -80, -89, -76, 98, -85, -81, -78, -76, -89, -75, -75, -85, -79, -80, 98, -88, -85, -76, -89, -90, -118, -119, 93, 124, -119, -119, -128, -115, 103, -118, -126, -126, -124, -119, -126, 100, -120, -117, -115, -128, -114, -114, -124, -118, -119};
    }

    public static void A02() {
        A03 = new String[]{"7FIKHU9lgq27", "AgQqvAltXhi1bYF8zppFCZ", "CRAmwsbXNtyv0vmCJJ9qOPCwxUiND3E6", "ItQqdqoRYHMWKQzbVRTeHzNwEAi", "W2szVhKnaW", "HNVKE5hkEvipBMdeuLWXlSQ07SgK2Jmi", "9NOG2BA2dnlUEqMWgY53wMXC47FXKBrl", "EneshuO9jiHnlHF2bjWwp7WA0EKVaMOF"};
    }

    public RX(C1581Ek c1581Ek, Runnable runnable) {
        this.A00 = c1581Ek;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12590u
    public final void A9J(RA ra) {
        this.A00.A00.A0A().A3k();
        this.A00.A07.A0B();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12590u
    public final void A9K(RA ra, View view) {
        this.A00.A00.A0A().A3j(ra == this.A00.A01);
        if (ra != this.A00.A01) {
            return;
        }
        this.A00.A0G().removeCallbacks(this.A01);
        InterfaceC12510m interfaceC12510m = this.A00.A02;
        C1581Ek c1581Ek = this.A00;
        c1581Ek.A02 = ra;
        ((AbstractC1898Rb) c1581Ek).A00 = view;
        if (!c1581Ek.A0D) {
            this.A00.A07.A0E(ra);
        } else {
            this.A00.A07.A0D(view);
            this.A00.A0P(interfaceC12510m);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12590u
    public final void A9L(RA ra, AdError adError) {
        this.A00.A00.A0A().A3l(ra == this.A00.A01, adError.getErrorCode());
        if (ra != this.A00.A01) {
            return;
        }
        this.A00.A0G().removeCallbacks(this.A01);
        this.A00.A0P(ra);
        this.A00.A0O();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12590u
    public final void A9M(RA ra) {
        C1710Jr.A05(A00(31, 25, 11), A00(8, 23, 50), A00(0, 8, 46));
        this.A00.A00.A0A().A3m();
        this.A00.A07.A0C();
        this.A00.A0M();
    }
}
