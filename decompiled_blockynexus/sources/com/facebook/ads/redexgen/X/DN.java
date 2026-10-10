package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DN {
    public int A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final DG A05;
    public final IF A06 = new IF(new byte[64]);
    public final IS A07;

    public DN(DG dg, IS is) {
        this.A05 = dg;
        this.A07 = is;
    }

    private void A00() {
        this.A06.A09(8);
        this.A03 = this.A06.A0G();
        this.A02 = this.A06.A0G();
        this.A06.A09(6);
        this.A00 = this.A06.A05(8);
    }

    private void A01() {
        this.A01 = 0L;
        if (this.A03) {
            this.A06.A09(4);
            long jA05 = ((long) this.A06.A05(3)) << 30;
            this.A06.A09(1);
            long jA052 = jA05 | ((long) (this.A06.A05(15) << 15));
            this.A06.A09(1);
            long jA053 = jA052 | ((long) this.A06.A05(15));
            this.A06.A09(1);
            if (!this.A04 && this.A02) {
                this.A06.A09(4);
                long jA054 = ((long) this.A06.A05(3)) << 30;
                this.A06.A09(1);
                long jA055 = jA054 | ((long) (this.A06.A05(15) << 15));
                this.A06.A09(1);
                long jA056 = jA055 | ((long) this.A06.A05(15));
                this.A06.A09(1);
                this.A07.A08(jA056);
                this.A04 = true;
            }
            long pts = this.A07.A08(jA053);
            this.A01 = pts;
        }
    }

    public final void A02() {
        this.A04 = false;
        this.A05.AD1();
    }

    public final void A03(IG ig) throws AD {
        ig.A0d(this.A06.A00, 0, 3);
        this.A06.A08(0);
        A00();
        ig.A0d(this.A06.A00, 0, this.A00);
        this.A06.A08(0);
        A01();
        this.A05.ABp(this.A01, true);
        this.A05.A48(ig);
        this.A05.ABo();
    }
}
