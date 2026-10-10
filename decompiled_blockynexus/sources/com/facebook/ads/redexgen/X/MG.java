package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MG extends KT {
    public static String[] A04;
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ LU A02;
    public final /* synthetic */ EnumC1846Pb A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"pUIboC8CwdUMtM1tPR8iEtPz8p", "ladzvmq", "gZiIZXhhpFNWaRiPv", "vQtAVDGFp8M", "7j30UYRlUEXcM4Kd2wK", "XchzO9Mtzl1GyvdPdWlZd1J0iwZmFx3H", "VTwPVxpRcW0", "YPnzN72MuP4y3lnuBhqZ0NoSyY"};
    }

    public MG(LU lu, EnumC1846Pb enumC1846Pb, int i, int i2) {
        this.A02 = lu;
        this.A03 = enumC1846Pb;
        this.A01 = i;
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (this.A03 == EnumC1846Pb.A07) {
            this.A02.A0J(JB.A0m);
            this.A02.A09.A0A().A30();
            this.A02.A0A.A03(LU.A0C());
            return;
        }
        if (this.A03 == EnumC1846Pb.A03) {
            this.A02.A0J(JB.A0h);
            this.A02.A03 = true;
            this.A02.A0A.A03(LU.A0E);
            return;
        }
        EnumC1846Pb enumC1846Pb = this.A03;
        EnumC1846Pb enumC1846Pb2 = EnumC1846Pb.A06;
        String[] strArr = A04;
        if (strArr[0].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[5] = "Wlqb3PCyph61UkVVxo7ng7VZa1hYfmo4";
        strArr2[5] = "Wlqb3PCyph61UkVVxo7ng7VZa1hYfmo4";
        if (enumC1846Pb == enumC1846Pb2) {
            this.A02.A0J(JB.A0g);
            this.A02.A09.A0A().A2s();
            this.A02.A03 = true;
            this.A02.A06.removeCallbacksAndMessages(null);
            AnonymousClass99 anonymousClass99 = this.A02.A0A;
            int i = this.A01;
            anonymousClass99.A03(new C7l(i, i));
            return;
        }
        if (this.A03 == EnumC1846Pb.A0A) {
            this.A02.A0J(JB.A0k);
            this.A02.A09.A0A().A37();
            this.A02.A0A.A03(LU.A0B());
            this.A02.A06.removeCallbacksAndMessages(null);
            this.A02.A0G();
            return;
        }
        if (this.A03 == EnumC1846Pb.A05) {
            this.A02.A0J(JB.A0j);
            this.A02.A09.A0A().A2w();
            AnonymousClass99 anonymousClass992 = this.A02.A0A;
            final int i2 = this.A00;
            anonymousClass992.A03(new AbstractC1715Jw(i2) { // from class: com.facebook.ads.redexgen.X.7j
            });
            this.A02.A06.removeCallbacksAndMessages(null);
            return;
        }
        if (this.A03 == EnumC1846Pb.A04) {
            this.A02.A0J(JB.A0i);
            this.A02.A09.A0A().A2t();
            this.A02.A0A.A03(LU.A0I);
            this.A02.A06.removeCallbacksAndMessages(null);
            return;
        }
        if (this.A03 == EnumC1846Pb.A09) {
            this.A02.A0J(JB.A0g);
            this.A02.A09.A0A().A32();
            this.A02.A03 = true;
            this.A02.A06.removeCallbacksAndMessages(null);
            this.A02.A0A.A03(new C7l(this.A00, this.A01));
        }
    }
}
