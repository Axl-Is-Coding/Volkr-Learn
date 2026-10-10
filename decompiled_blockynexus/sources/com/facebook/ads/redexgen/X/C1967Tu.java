package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1967Tu implements C6Y {
    public static String[] A01;
    public final /* synthetic */ U1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"CyYconlRA", "Z99FvxWAH", "r", "I6nMbGSwO", "f1HEaIkkO6UN2Wyn2K6t6YhOL5YQHMub", "q7TOnFp8MDH9pVcAi7q7X5O", "kHDnEbJrZHu3VwOwnck16fHaeHzzt8", "W41og5bN"};
    }

    public C1967Tu(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A01 != null) {
            U1 u1 = this.A00;
            String[] strArr = A01;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "ZWV";
            strArr2[2] = "ZWV";
            return u1.A09(u1.A01.sourceDir);
        }
        U1 u12 = this.A00;
        if (A01[6].length() == 14) {
            return u12.A08(EnumC14006j.A07);
        }
        String[] strArr3 = A01;
        strArr3[6] = "1VAENbmq7tYIb9ZQI0D0jEbiw3q";
        strArr3[6] = "1VAENbmq7tYIb9ZQI0D0jEbiw3q";
        return u12.A08(EnumC14006j.A07);
    }
}
