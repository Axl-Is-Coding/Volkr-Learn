package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(14)
public final class PO {
    public static byte[] A02;
    public static String[] A03;
    public final C8 A00;
    public final C2153aT A01 = new C2153aT();

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-114, -104, -116, -114, -49, -51, -31, -33, -47, -114, -116, -90, -116, -114, -96, -86, -98, -96, -16, -29, -20, -30, -29, -16, -29, -16, -57, -20, -30, -29, -10, -96, -98, -72, -98, -96, -114, -23, 111, 114, -127, -68, 99, -75, -70, -79, -90, 99, 97, 123, 97, 99};
    }

    public static void A03() {
        A03 = new String[]{"WzijvlAd9RP1HJzMxCKzeYHnMs2QP54v", "kfrqpsiELz0FvZTPYg", "hAwPDz", "OryCsPOoCbEZ1Kjw18", "JoqBI6chV", "rfkFyJ13DXugB3RLj6H", "rQvj", "kthZXjW83"};
    }

    public PO(C2026Wb c2026Wb) {
        this.A00 = C14809w.A00(new XU(c2026Wb), new AH(new C2142aI(this.A01)), new XS());
    }

    @VisibleForTesting
    public static String A01(C14789u c14789u) {
        return A00(41, 11, 55) + c14789u.A01 + A00(14, 22, 116) + c14789u.A00 + A00(0, 14, 98) + c14789u.getCause() + A00(36, 2, 98);
    }

    public static boolean A04() {
        if (A03[0].charAt(3) == 'z') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "p35x";
        strArr[6] = "p35x";
        return true;
    }

    public final int A05() {
        return this.A00.A0K();
    }

    public final int A06() {
        return this.A00.A5d();
    }

    public final long A07() {
        return this.A00.A60();
    }

    public final long A08() {
        return this.A00.A6B();
    }

    @Nullable
    public final PM A09() {
        Format formatA0M = this.A00.A0M();
        if (formatA0M == null) {
            return null;
        }
        return new PM(formatA0M.A0F, formatA0M.A08);
    }

    public final void A0A() {
        this.A00.ACW();
    }

    public final void A0B() {
        this.A00.AD5();
    }

    public final void A0C() {
        this.A00.A0N();
    }

    public final void A0D(float f2) {
        this.A00.A0O(f2);
    }

    public final void A0E(long j) {
        this.A00.AD4(j);
    }

    public final void A0F(Context context, Uri uri) {
        if (C1693Iy.A1f(context)) {
            this.A00.A0Q(new Zl(PS.A05(context).A0E(context)).A00(uri));
        } else {
            this.A00.A0Q(new Zl(new C2155aV(context, IW.A0K(context, A00(38, 3, 4)), this.A01)).A00(uri));
        }
    }

    public final void A0G(@Nullable Surface surface) {
        this.A00.A0P(surface);
    }

    public final void A0H(PL pl) {
        this.A00.A3H(new G4(this, pl));
    }

    public final void A0I(PN pn) {
        this.A00.A0R(new GA(this, pn));
    }

    public final void A0J(boolean z) {
        this.A00.ADL(z);
    }

    public final boolean A0K() {
        return this.A00.A6r();
    }

    public final boolean A0L() {
        return this.A00.A0L() != null;
    }
}
