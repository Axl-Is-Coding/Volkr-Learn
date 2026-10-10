package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC13383y {
    public static byte[] A03;
    public int A00;
    public final Rect A01;
    public final C4E A02;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{84, 83, 75, 92, 81, 84, 89, 29, 82, 79, 84, 88, 83, 73, 92, 73, 84, 82, 83};
    }

    public abstract int A06();

    public abstract int A07();

    public abstract int A08();

    public abstract int A09();

    public abstract int A0A();

    public abstract int A0B();

    public abstract int A0C(View view);

    public abstract int A0D(View view);

    public abstract int A0E(View view);

    public abstract int A0F(View view);

    public abstract int A0G(View view);

    public abstract int A0H(View view);

    public abstract void A0J(int i);

    public AbstractC13383y(C4E c4e) {
        this.A00 = Integer.MIN_VALUE;
        this.A01 = new Rect();
        this.A02 = c4e;
    }

    public /* synthetic */ AbstractC13383y(C4E c4e, SV sv) {
        this(c4e);
    }

    public static AbstractC13383y A00(C4E c4e) {
        return new SV(c4e);
    }

    public static AbstractC13383y A01(C4E c4e) {
        return new SW(c4e);
    }

    public static AbstractC13383y A02(C4E c4e, int i) {
        if (i == 0) {
            return A00(c4e);
        }
        if (i == 1) {
            return A01(c4e);
        }
        throw new IllegalArgumentException(A03(0, 19, 11));
    }

    public final int A05() {
        if (Integer.MIN_VALUE == this.A00) {
            return 0;
        }
        return A0B() - this.A00;
    }

    public final void A0I() {
        this.A00 = A0B();
    }
}
