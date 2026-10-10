package com.facebook.ads.redexgen.X;

import java.util.LinkedList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ja, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1695Ja {
    public final JY A0B;
    public final boolean A0F;
    public final String A0C = C1695Ja.class.getSimpleName();
    public final int A07 = 101;
    public final int A0A = 102;
    public final int A08 = 103;
    public final int A03 = 104;
    public final int A09 = 105;
    public final int A02 = 106;
    public final int A04 = 107;
    public final int A05 = 108;
    public final int A06 = 109;
    public final int A01 = 110;
    public final boolean A0E = false;
    public long A00 = -1;
    public final List<JZ> A0D = new LinkedList();

    public C1695Ja(AnonymousClass87 anonymousClass87, JY jy) {
        int iA0D = J0.A0D(anonymousClass87);
        if (iA0D < 1) {
            this.A0F = false;
        } else {
            double sessionRandom = iA0D;
            this.A0F = anonymousClass87.A05().A00() < 1.0d / sessionRandom;
        }
        this.A0B = jy;
    }

    private int A00() {
        return this.A0B.A5z();
    }

    private int A01() {
        if (this.A00 > 0) {
            return (int) (System.currentTimeMillis() - this.A00);
        }
        return -1;
    }

    private void A03(JZ jz) {
        synchronized (this.A0D) {
            this.A0D.add(jz);
        }
    }

    public final void A04() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 110, A00(), null));
    }

    public final void A05() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 106, A00(), null));
    }

    public final void A06() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 104, A00(), null));
    }

    public final void A07() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 109, -1, null));
    }

    public final void A08() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 107, A00(), null));
    }

    public final void A09() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 108, A00(), null));
    }

    public final void A0A() {
        if (!this.A0F) {
            return;
        }
        this.A00 = System.currentTimeMillis();
        A03(new JZ(0, 101, -1, null));
    }

    public final void A0B() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 105, A00(), null));
    }

    public final void A0C() {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 102, A00(), null));
    }

    public final void A0D(AnonymousClass87 anonymousClass87, String str) {
        if (!this.A0F) {
            return;
        }
        A03(new JZ(A01(), 103, A00(), null));
        ExecutorC1744Lc.A06.execute(new JX(this, str, anonymousClass87));
    }
}
