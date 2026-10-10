package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1930Sj extends C4J {
    public static String[] A02;
    public boolean A00 = false;
    public final /* synthetic */ AbstractC1931Sk A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"mAEXsU", "ynqBxBOImfiaim2rOjt4gNln3IJjMmAs", "wywpOwDcOClPwSqhh8hqnS4LzA6xmBGs", "SzqLf2", "g6", "3b", "2rYsw0AU9P5CKqqKD8yWz2y811Q4TNqs", "g7NtZwf9Cfcv4ky8xJWe0WMsxKKUH5F1"};
    }

    public C1930Sj(AbstractC1931Sk abstractC1931Sk) {
        this.A01 = abstractC1931Sk;
    }

    @Override // com.facebook.ads.redexgen.X.C4J
    public final void A0V(EI ei, int i) {
        super.A0V(ei, i);
        if (i == 0 && this.A00) {
            this.A00 = false;
            this.A01.A0H();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4J
    public final void A0W(EI ei, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        String[] strArr = A02;
        if (strArr[5].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "WMOmT1QQvzwg3wEMb9eL1K1wBJkCMN2D";
        strArr2[1] = "WMOmT1QQvzwg3wEMb9eL1K1wBJkCMN2D";
        this.A00 = true;
    }
}
