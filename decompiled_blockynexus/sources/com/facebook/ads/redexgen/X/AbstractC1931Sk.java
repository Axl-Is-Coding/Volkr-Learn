package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1931Sk extends C4H {
    public static byte[] A03;
    public static String[] A04;
    public EI A00;
    public Scroller A01;
    public final C4J A02 = new C1930Sj(this);

    static {
        A0B();
        A0A();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        byte[] bArr = {-35, 10, -68, 5, 10, ci.m, ci.n, -3, 10, -1, 1, -68, 11, 2, -68, -21, 10, -30, 8, 5, 10, 3, -24, 5, ci.m, ci.n, 1, 10, 1, ci.l, -68, -3, 8, ci.l, 1, -3, 0, 21, -68, ci.m, 1, ci.n, -54};
        if (A04[2].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[3] = "Gfsvb5V6ZkZ1EjPhJmDEOg0wCX37AMGK";
        strArr[5] = "BogmwpJuEiSgKohE6B9VLJKkNQC2pxlX";
        A03 = bArr;
    }

    public static void A0B() {
        A04 = new String[]{"WP5CpU5dCfM1vj2iCgRczyLeS833jqA7", "f0t6mABNpir4NiI1IJBR", "VMSqLwjWc3fXvu7D9B7JwatTJSWiKmSt", "2kGOlvpEajHcc9JJ5BV7kSrV8Uhb9VDh", "BGGgbgkg4NpzKA2XjpG6Q8iHB2GG9zH0", "ziOTckvigWpUqNYWulExTvMWDfbzI1Sq", "WkLWBkQ13lLgYVln8HDaQ7gYbGPRUWfj", "hZJ2tRP2pGaevCKAXmW2Fr9GhnOGACBf"};
    }

    public abstract int A0E(C4E c4e, int i, int i2);

    @Nullable
    public abstract View A0F(C4E c4e);

    @Nullable
    public abstract int[] A0J(@NonNull C4E c4e, @NonNull View view);

    @Nullable
    private final C4R A06(C4E c4e) {
        return A0G(c4e);
    }

    private void A08() {
        this.A00.A1l(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A09() throws IllegalStateException {
        if (this.A00.getOnFlingListener() == null) {
            this.A00.A1k(this.A02);
            this.A00.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException(A07(0, 43, 103));
    }

    private boolean A0C(@NonNull C4E c4e, int i, int i2) {
        C4R c4rA06;
        if (!(c4e instanceof C4Q) || (c4rA06 = A06(c4e)) == null) {
            return false;
        }
        int iA0E = A0E(c4e, i, i2);
        String[] strArr = A04;
        if (strArr[0].charAt(25) == strArr[7].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "3QNQgzU1MIdfo8xP0zEWa1SfaSPVi8u7";
        strArr2[7] = "BhxrOivCOMjMD1hwED78TbVHZR3oyoMb";
        if (iA0E == -1) {
            return false;
        }
        c4rA06.A0B(iA0E);
        c4e.A1M(c4rA06);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final boolean A0D(int i, int i2) {
        C4E layoutManager = this.A00.getLayoutManager();
        if (layoutManager == null || this.A00.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.A00.getMinFlingVelocity();
        int minFlingVelocity2 = Math.abs(i2);
        if (minFlingVelocity2 <= minFlingVelocity) {
            int minFlingVelocity3 = Math.abs(i);
            if (minFlingVelocity3 <= minFlingVelocity) {
                return false;
            }
        }
        return A0C(layoutManager, i, i2);
    }

    @Nullable
    @Deprecated
    public SU A0G(C4E c4e) {
        if (!(c4e instanceof C4Q)) {
            return null;
        }
        return new C1566Dt(this, this.A00.getContext());
    }

    public final void A0H() {
        C4E layoutManager;
        View snapView;
        EI ei = this.A00;
        if (ei == null || (layoutManager = ei.getLayoutManager()) == null || (snapView = A0F(layoutManager)) == null) {
            return;
        }
        int[] iArrA0J = A0J(layoutManager, snapView);
        if (iArrA0J[0] != 0 || iArrA0J[1] != 0) {
            this.A00.A1f(iArrA0J[0], iArrA0J[1]);
        }
    }

    public final void A0I(@Nullable EI ei) throws IllegalStateException {
        EI ei2 = this.A00;
        if (ei2 == ei) {
            return;
        }
        if (ei2 != null) {
            A08();
        }
        this.A00 = ei;
        if (this.A00 != null) {
            A09();
            this.A01 = new Scroller(this.A00.getContext(), new DecelerateInterpolator());
            A0H();
        }
    }
}
