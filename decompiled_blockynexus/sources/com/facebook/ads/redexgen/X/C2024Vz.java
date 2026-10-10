package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2024Vz implements C6Y {
    public static String[] A01;
    public final /* synthetic */ W8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"fhgAKr3d26sPe206xi", "SjffeijJA1Vv6PcXWUgct", "EsQusZwl1jUwipz2lU1dtOeOynoqp4qu", "0VpWGFYwNM1shdn7oayU", "oGsU7X9gn8B3aKKKnK6Um4C", "3PuUzv37NfYax6hYz8jf", "w27NqvUy0J9VzwNZKDXUsnO8qh2oDxhJ", "FZXbTPmbge4RvKyxAzubgHD8Txvy8Otv"};
    }

    public C2024Vz(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A00 == null) {
            AbstractC14046n abstractC14046nA08 = this.A00.A08(EnumC14006j.A07);
            if (A01[6].charAt(19) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "mdGsZgeczhjsROxHbS4UhtOI0ggMdB2A";
            strArr[6] = "mdGsZgeczhjsROxHbS4UhtOI0ggMdB2A";
            return abstractC14046nA08;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            W8 w8 = this.A00;
            TelephonyManager telephonyManager = w8.A00;
            String[] strArr2 = A01;
            if (strArr2[3].length() != strArr2[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[1] = "gYbGBXsMnQLVbPxH35aVX";
            strArr3[4] = "c9uQZVFrEkdSbUXAtWNBNx9";
            return w8.A05(telephonyManager.getDataNetworkType());
        }
        W8 w82 = this.A00;
        String[] strArr4 = A01;
        if (strArr4[2].length() != strArr4[0].length()) {
            String[] strArr5 = A01;
            strArr5[6] = "dEMR1C0fCLJEsmN6YStUhJGVUagFQ5EF";
            strArr5[6] = "dEMR1C0fCLJEsmN6YStUhJGVUagFQ5EF";
            return w82.A05(w82.A00.getNetworkType());
        }
        String[] strArr6 = A01;
        strArr6[7] = "IeVVB4pQAR4pX23W54Z95CGRKG6wHZI8";
        strArr6[7] = "IeVVB4pQAR4pX23W54Z95CGRKG6wHZI8";
        return w82.A05(w82.A00.getNetworkType());
    }
}
