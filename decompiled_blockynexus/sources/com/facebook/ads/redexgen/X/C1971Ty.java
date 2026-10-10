package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ty, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1971Ty implements C6Y {
    public static String[] A01;
    public final /* synthetic */ U1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"9CH7FUr60fjSOu0uDtam6QWrW1LAXcO0", "MGZ5NGAJYsXrcQ530Rpa4mq072uYsiXm", "FSEpTqAJrXrPXD8Cb", "YDmM9nsCETgUfJB46tzDOSpydcNxEQ3F", "VGv8Kw1xSq2totQkDwmbaDQvoJVXTwia", "PqLjk4LqC3tC9ytXEM059nB67sHSnsxP", "xjbenFCMrkBs7EfKqhSnYCZ0lRG62qii", "xgMaaa53aLKiV09tKVXK6rj7dvlbsjte"};
    }

    public C1971Ty(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 24) {
            U1 u1 = this.A00;
            EnumC14006j enumC14006j = EnumC14006j.A05;
            String[] strArr = A01;
            if (strArr[4].charAt(20) == strArr[5].charAt(20)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "fnZh3TS8JAEKtifjP4n7RBztgRvZoar8";
            strArr2[2] = "4XQjD71oxr9tiB6pv";
            return u1.A08(enumC14006j);
        }
        if (this.A00.A01 != null) {
            U1 u12 = this.A00;
            return u12.A09(u12.A01.deviceProtectedDataDir);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
