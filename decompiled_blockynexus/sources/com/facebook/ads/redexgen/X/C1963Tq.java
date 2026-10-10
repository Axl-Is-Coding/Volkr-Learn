package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1963Tq implements C6Y {
    public static String[] A01;
    public final /* synthetic */ U1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"xoHvVsjIwv7W5ClpzJbisJEpOcq", "SYDRmpizq5sDZ4GfL4h8WluGMHdmoTuM", "DVzF2PeQv7hgrICuH3nyQdrZNKSxdA", "4lIziXMzxgphshR2rAqW9SlDjwpMcvxS", "Bksnruu9CDcd9v5jIjvraWrOMG1PGOq1", "vT5fBH5lG6OjAtE20tf2f7rqol7xKp1H", "b74VzSGUDjeF5gq780pkK2xwxVTOFG7b", "77MleEyOR9uHuiszCvhjWPNRz4PKDadz"};
    }

    public C1963Tq(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        String strA0f = this.A00.A02.A0f();
        if (strA0f != null) {
            U1 u1 = this.A00;
            if (A01[7].charAt(13) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "f9T5AhYAPA98oVvlWKPWGyhu6RS3SO";
            strArr[0] = "b7yxm3cRAk17Eqj8H4F2BjoUql6";
            return u1.A09(strA0f);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
