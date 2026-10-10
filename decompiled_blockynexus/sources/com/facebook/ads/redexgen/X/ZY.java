package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZY implements InterfaceC1761Lt {
    public static String[] A02;
    public final /* synthetic */ C13604u A00;
    public final /* synthetic */ ZU A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"9zQQ", "ignw1BD", "Iwiu", "Rj9759ruFeEHfZFHtC0tN77N", "Yw9WW67qBp7nurOongm62UMTZpj72Daq", "XdprQx2", "zMrI2nkZvee1EVY6Hu3DKwgaLEX6aHI5", "7LD9TnQa5MzlVBDCJJS9JW3wW2x"};
    }

    public ZY(ZU zu, C13604u c13604u) {
        this.A01 = zu;
        this.A00 = c13604u;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1761Lt
    public final void A9S() {
        this.A01.A0B.A03(JB.A07, null);
        if (this.A01.A0X()) {
            return;
        }
        if (this.A01.A0U()) {
            this.A01.A0T(this.A00);
            return;
        }
        C13604u c13604u = this.A00;
        if (A02[7].length() != 27) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "TQLH18Rv5MEOVOxcIrRMtSKcbgUrlpIS";
        strArr[4] = "TQLH18Rv5MEOVOxcIrRMtSKcbgUrlpIS";
        c13604u.finish(1);
    }
}
