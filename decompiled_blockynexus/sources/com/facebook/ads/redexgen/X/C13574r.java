package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C13574r {
    public static byte[] A04;
    public final Intent A00;
    public final C13604u A01;
    public final C2026Wb A02;
    public final J5 A03;

    static {
        A0N();
    }

    public static String A0M(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A04 = new byte[]{51, 54, ci.k, 54, 51, 38, 51, ci.k, 48, 39, 60, 54, 62, 55, ci.l, 25, 11, 29, ci.l, 24, 25, 24, 42, 21, 24, 25, 19, 61, 24, 56, 29, 8, 29, 62, 9, 18, 24, ci.n, 25, 77, 82, 95, 94, 84, 100, 79, 82, 86, 94, 100, 75, 84, 87, 87, 82, 85, 92, 100, 82, 85, 79, 94, 73, 77, 90, 87};
    }

    public C13574r(C13604u c13604u, Intent intent, J5 j5, C2026Wb c2026Wb) {
        this.A01 = c13604u;
        this.A00 = intent;
        this.A03 = j5;
        this.A02 = c2026Wb;
    }

    public /* synthetic */ C13574r(C13604u c13604u, Intent intent, J5 j5, C2026Wb c2026Wb, C13564q c13564q) {
        this(c13604u, intent, j5, c2026Wb);
    }

    private RN A00() {
        return (RN) this.A00.getSerializableExtra(A0M(0, 14, 29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A02() {
        C13604u c13604u = this.A01;
        return new C2106Zd(c13604u, this.A02, this.A03, new C1933Sm(c13604u));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A03() {
        return new C1872Qb(this.A02, this.A03, new C1933Sm(this.A01), A00(), new C2052Xb(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A04() {
        return new C1872Qb(this.A02, this.A03, new C1933Sm(this.A01), (RO) this.A00.getSerializableExtra(A0M(14, 25, 51)), new XY(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A05() {
        C2026Wb c2026Wb = this.A02;
        return new C14307t(c2026Wb, this.A03, new AnonymousClass77(c2026Wb), new C1933Sm(this.A01), A00());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A06() {
        return new C14348b(this.A02, new C2052Xb(), this.A03, A00(), new AnonymousClass77(this.A02), new C1933Sm(this.A01));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A07() {
        return new Y5(this.A02, this.A03, new C1933Sm(this.A01), A00(), null, new C2052Xb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A08() {
        return new C7v(this.A02, new C2052Xb(), this.A03, A00(), new AnonymousClass77(this.A02), new C1933Sm(this.A01));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A09() {
        RO ro = (RO) this.A00.getSerializableExtra(A0M(14, 25, 51));
        C13564q c13564q = null;
        if (ro.A0f()) {
            return new C7v(this.A02, new XY(), this.A03, ro, new AnonymousClass77(this.A02), new C1552Dd(this.A01));
        }
        C2026Wb c2026Wb = this.A02;
        return new C2071Xu(c2026Wb, this.A03, new LU(c2026Wb), new C1552Dd(this.A01), ro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A0A() {
        RO ro = (RO) this.A00.getSerializableExtra(A0M(14, 25, 51));
        return new Y5(this.A02, this.A03, new C1552Dd(this.A01), ro, ro.A0V(), new XY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public M0 A0B(RelativeLayout relativeLayout) {
        C2055Xe c2055Xe = new C2055Xe(this.A02, new C1934Sn(this), this.A03, new C1933Sm(this.A01));
        c2055Xe.A05(relativeLayout);
        c2055Xe.A04(this.A00.getIntExtra(A0M(39, 27, 116), 200));
        LX.A0P(relativeLayout, -16777216);
        return c2055Xe;
    }
}
