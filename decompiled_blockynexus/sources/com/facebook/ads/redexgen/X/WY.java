package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class WY implements C0L {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ C2027Wc A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = bArrCopyOfRange[i4];
            if (A02[3].charAt(2) == 'x') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[0] = "5v5qZEzKm5dZGLy7lyhruzHwv9U4ulwR";
            strArr[0] = "5v5qZEzKm5dZGLy7lyhruzHwv9U4ulwR";
            bArrCopyOfRange[i4] = (byte) ((b2 ^ i3) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{5, 1, ci.k, 11, 9};
    }

    public static void A02() {
        A02 = new String[]{"aROWSCJTZ7USEA9NykDAgKPqU9Hz2yMC", "Zqbs868sBagHNlYScp55lXssWh10RIQa", "mbYc5GC1jhCg", "AuzesFDqytnerPl8cSxQvwaSTNgSXgGN", "J34OJh55Zf7CVcps1JZJSO0d6JwePACZ", "sgVYwbqUus7", "7dh0o4NaZc6u8WRc1KGfxvMUmypAWeMQ", "ZE0swazaf"};
    }

    public WY(C2027Wc c2027Wc) {
        this.A00 = c2027Wc;
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void A8A(Throwable th) {
        this.A00.A04().A8H(A00(0, 5, 0), C8Y.A1L, new C8Z(th));
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void A8L(Throwable th) {
        this.A00.A04().A8H(A00(0, 5, 0), C8Y.A1N, new C8Z(th));
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void ACP(String str, int i, @Nullable String str2, @Nullable Integer num, @Nullable Long l, AnonymousClass06 anonymousClass06) {
        C7A.A05(this.A00, anonymousClass06.A06, anonymousClass06.A08, anonymousClass06.A09, anonymousClass06.A07, anonymousClass06.A03, i, str2, num, l, null);
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void ACQ(String str, boolean z, AnonymousClass06 anonymousClass06) {
        C7A.A04(this.A00, new AnonymousClass79(anonymousClass06.A06, anonymousClass06.A08, anonymousClass06.A07, anonymousClass06.A03, str), z);
    }
}
