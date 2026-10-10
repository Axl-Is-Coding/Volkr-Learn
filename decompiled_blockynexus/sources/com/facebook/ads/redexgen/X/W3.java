package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class W3 implements C6Y {
    public static String[] A01;
    public final /* synthetic */ W8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Vo88lINS9S2N5LbTaKf1W2kwN6BIQQdD", "UoAdPktVrqtin724LV50L5", "LFaB2DLRyLVTAupR8IDTAiu1ygiAQNei", "sJjAsr1DYzEdJFVxSj", "YixUmkecZHZtQTXRs3SEpcqVtXLRAsNc", "NCQvJXIWgGsA6V8X34C", "SF2vY0k52k3yZQV1rBM1cg", "e4uMFN1tyFqCHoW3Lf"};
    }

    public W3(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A00 != null) {
            W8 w8 = this.A00;
            return w8.A09(w8.A00.getNetworkOperator());
        }
        W8 w82 = this.A00;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "y3WpFIrw6SINDCFjG4EXd7NBg48ZDa";
        strArr2[5] = "y3WpFIrw6SINDCFjG4EXd7NBg48ZDa";
        return w82.A08(EnumC14006j.A07);
    }
}
