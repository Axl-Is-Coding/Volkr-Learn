package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class HV extends KT {
    public static String[] A02;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1843Oy A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"NpaKE5UdtAyMHqvaLPx4AGtZ31wY3C1j", "hZ", "QvlAFGERqyhtEWGueXr2oEhguGRVkueU", "1PB7Q2A0OVus1FFgj1K4N07XZBnviAmq", "QCLV5siYIKSB8enqXDrdMSWnSISBhPag", "u71qdrqstjoPYAgdzxDuhzTAB45rQyDC", "tsgBYsPi1Izoi1wW5rl36QAscdyZX4HE", "imzaDMEG6ltP9AayN9N6Pvq8SnbIyMdS"};
    }

    public HV(C1843Oy c1843Oy, int i) {
        this.A01 = c1843Oy;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (this.A01.A00.A00.getVideoView() != null) {
            int i = this.A00;
            if (A02[1].length() == 23) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "iSSYmESuchF7uAVhXaEYpov3466pRlYS";
            strArr[5] = "iSSYmESuchF7uAVhXaEYpov3466pRlYS";
            if (i <= 0) {
                this.A01.A00.A00.getVideoView().A0b(false, 9);
            }
        }
    }
}
