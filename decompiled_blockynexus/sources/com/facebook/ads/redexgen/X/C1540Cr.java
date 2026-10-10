package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1540Cr extends AbstractC1712Jt {
    public static String[] A01;
    public final /* synthetic */ AnonymousClass55 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"LKWkJLHWeQBpKWa7UOr", "n3GVMd2hYWvpJPgcK7G8gwhDICX0QRvF", "xWguot5bGbOrngmksJGOGVnUcrOeX8Yq", "Ofa75S47Yg9dCpk5kJ8", "1S7QAm0fWcEMmp0r33MjAmGaqGODAsQ1", "zqFnCLlNx7sTkxdlo9MHaJoU5FTNnDPM", "mLEAh1LmjQI6neJU4JsNwDaurLCI0CwU", "tuKdoZnhl5Xw"};
    }

    public C1540Cr(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9A
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A04(C1713Ju c1713Ju) {
        if (this.A00.A08 != null) {
            C2213bT.A0J(this.A00.A08.getInternalNativeAd()).A1U(false, true);
        }
        this.A00.A00.onError();
        String[] strArr = A01;
        if (strArr[6].charAt(12) != strArr[2].charAt(12)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "vYhRUt1P8SC0fadBpCg";
        strArr2[3] = "IJBm98yQ9J9eGhRKk2w";
    }
}
