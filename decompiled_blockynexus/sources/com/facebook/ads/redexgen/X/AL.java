package com.facebook.ads.redexgen.X;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AL implements InterfaceC2129a4 {
    public static String[] A06;
    public long A00;
    public long A01;
    public C13052o A02;
    public final ArrayDeque<C13052o> A03 = new ArrayDeque<>();
    public final ArrayDeque<AR> A04;
    public final PriorityQueue<C13052o> A05;

    static {
        A0L();
    }

    public static void A0L() {
        A06 = new String[]{"xrToQ1M30eypgaiDt2KcbeXQSJmH4zEy", "FOMm0GJvPogulFgRKU73d9QQGInBRxBZ", "DAifx7fz7Oznb", "tEspMkbIuGZVzgapMfnbK02RMeMH6P5b", "hnmT", "jbKY175w2AZdEkpyONR9SNFucMTvW6Vd", "vt70xpgsPpIXmuxmiV", "wsDuhCL"};
    }

    public abstract G6 A0N();

    public abstract void A0R(C1490Ag c1490Ag);

    public abstract boolean A0T();

    public AL() {
        for (int i = 0; i < 10; i++) {
            this.A03.add(new C13052o());
        }
        this.A04 = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.A04.add(new C13042n(this));
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0M(C13052o c13052o) {
        c13052o.A07();
        this.A03.add(c13052o);
    }

    @Override // com.facebook.ads.redexgen.X.BT
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public C1490Ag A4h() throws G7 {
        C1662Hr.A04(this.A02 == null);
        if (this.A03.isEmpty()) {
            return null;
        }
        this.A02 = this.A03.pollFirst();
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.BT
    /* JADX INFO: renamed from: A0P, reason: merged with bridge method [inline-methods] */
    public AR A4i() throws G7 {
        if (this.A04.isEmpty()) {
            return null;
        }
        while (!this.A05.isEmpty() && ((C2067Xq) this.A05.peek()).A00 <= this.A00) {
            C13052o c13052oPoll = this.A05.poll();
            if (c13052oPoll.A04()) {
                AR arPollFirst = this.A04.pollFirst();
                arPollFirst.A00(4);
                if (A06[6].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[4] = "hAEA";
                strArr[4] = "hAEA";
                A0M(c13052oPoll);
                return arPollFirst;
            }
            A0R(c13052oPoll);
            if (A0T()) {
                G6 g6A0N = A0N();
                if (!c13052oPoll.A03()) {
                    AR arPollFirst2 = this.A04.pollFirst();
                    arPollFirst2.A09(((C2067Xq) c13052oPoll).A00, g6A0N, Long.MAX_VALUE);
                    A0M(c13052oPoll);
                    return arPollFirst2;
                }
            }
            A0M(c13052oPoll);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.BT
    /* JADX INFO: renamed from: A0Q, reason: merged with bridge method [inline-methods] */
    public void ACF(C1490Ag c1490Ag) throws G7 {
        C1662Hr.A03(c1490Ag == this.A02);
        if (c1490Ag.A03()) {
            C13052o c13052o = this.A02;
            String[] strArr = A06;
            if (strArr[5].charAt(10) != strArr[3].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[5] = "0mhI93daunZi59PwiuGO0KbLyKVCPwQH";
            strArr2[3] = "r2E3xZENv7Zr1SQt92aJBQoSxSc5nrbU";
            A0M(c13052o);
        } else {
            C13052o c13052o2 = this.A02;
            long j = this.A01;
            this.A01 = 1 + j;
            c13052o2.A00 = j;
            this.A05.add(this.A02);
        }
        this.A02 = null;
    }

    public final void A0S(AR ar) {
        ar.A07();
        this.A04.add(ar);
    }

    @Override // com.facebook.ads.redexgen.X.BT
    public void ACW() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2129a4
    public void ADN(long j) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.X.BT
    public void flush() {
        this.A01 = 0L;
        this.A00 = 0L;
        while (!this.A05.isEmpty()) {
            A0M(this.A05.poll());
        }
        C13052o c13052o = this.A02;
        if (c13052o != null) {
            A0M(c13052o);
            this.A02 = null;
        }
    }
}
