package com.facebook.ads.redexgen.X;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Eg extends AbstractC1898Rb {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[7].charAt(30) != strArr[6].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "Dg0tZg7IxBj4D2AEunqK4FRxjbaI0pzK";
            strArr2[4] = "5sVR5Q40j80Tm4EH72ZLdFDAQDj0jOHn";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 112);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{-11, -13, 0, -78, 1, 0, -2, 11, -78, 5, -9, 6, -78, 1, 0, -78, 4, -9, 9, -13, 4, -10, -9, -10, -78, 8, -5, -10, -9, 1, -78, -13, -10, 5, -15, -14, -93, -28, -25, -28, -13, -9, -24, -11, -93, -11, -24, -28, -25, -4, -93, -9, -14, -93, -10, -24, -9, -93, -11, -24, -6, -28, -11, -25, -93, -14, -15};
    }

    public static void A03() {
        A01 = new String[]{"QPajxPBXawZguZvIACdyFqOYUKJhGG1P", "5fhxQ1wmDDZwcYW6vVZtBFGAbpCppeaF", "0C8PIOmzvjBgpmOh8JUWA", "4kKOVZ4CcWBKVljagfvAN2XyBryastSO", "Oy7EzKzQwTS7e9udIDBq4FtqglrDvqBF", "BZaaKRqUw", "6zOS7wuF6dlGz7u6SsHniaRnv53e8kon", "jwUp8OtoUlvjJY1bP74aKb8UsU7a0Ko9"};
    }

    public Eg(C2026Wb c2026Wb, C12741j c12741j) {
        super(c2026Wb, c12741j);
    }

    private AnonymousClass11 A00(Runnable runnable) {
        return new C1906Rj(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0N() {
        RJ rj = (RJ) this.A02;
        rj.A00(this.A08.A00);
        rj.A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1898Rb
    public final void A0Q(InterfaceC12510m interfaceC12510m, C14498q c14498q, C14478o c14478o, Map<String, Object> map) {
        C1584En c1584En = (C1584En) interfaceC12510m;
        Runnable rewardedVideoTimeout = new C1905Ri(this, map, c1584En);
        if (C1693Iy.A1S(this.A0C)) {
            A0G().postDelayed(rewardedVideoTimeout, c14498q.A05().A05());
        }
        c1584En.A0D(this.A0C, A00(rewardedVideoTimeout), map, this.A08.A05, this.A08.A03, this.A08.A04);
    }

    public final void A0Y(RewardData rewardData) {
        if (this.A02 != null) {
            if (this.A02.A6p() == AdPlacementType.REWARDED_VIDEO) {
                ((RJ) this.A02).A01(rewardData);
                return;
            }
            throw new IllegalStateException(A01(0, 34, 34));
        }
        throw new IllegalStateException(A01(34, 33, 19));
    }
}
