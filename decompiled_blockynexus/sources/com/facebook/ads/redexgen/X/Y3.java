package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Y3 implements InterfaceC1761Lt {
    public static String[] A01;
    public final /* synthetic */ C2071Xu A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"6N", "smQA5TSxp7vjrWoIt3G8gqRI7vuv9Mo2", "nC2JCQuxt461FEwUH0osGyRmdjA", "Hvedh13CT0GkY3JhzOxajNH8XlaZQpLN", "5Odrxu44jwGQpLwu9LnTSanJ4TNopF0a", "7krTPzdKMYjdejqNC8FU3CrmbwWia7OA", "A91WiRAFiXbxe3egNbtfICOYy0", "PiGZqdHGAPhzlIXS2UC0uVxfbNyiCcLD"};
    }

    public Y3(C2071Xu c2071Xu) {
        this.A00 = c2071Xu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1761Lt
    public final void A9S() {
        this.A00.A0T.A03(JB.A07, null);
        this.A00.A0R.A0A().A2Z();
        if (!this.A00.A0V.A0A(this.A00.getContext())) {
            if (!this.A00.A0I) {
                LU lu = this.A00.A09;
                if (A01[2].length() != 27) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[4] = "5zrYwBRwluqa1cGxPZZJZEcv5DdOFBPm";
                strArr[7] = "gq390Wd0Yu1IJshZC9Clpt7tVnhSzLar";
                if (lu != null) {
                    if (this.A00.A0f()) {
                        this.A00.A09.A0X(EnumC1830Ol.A07);
                        return;
                    } else {
                        this.A00.A0N();
                        return;
                    }
                }
            }
            boolean z = this.A00.A0I;
            if (A01[1].charAt(8) == 'p') {
                String[] strArr2 = A01;
                strArr2[5] = "Zcc8pzIQVtObnEDs8jyH13QzYMXIQUWE";
                strArr2[5] = "Zcc8pzIQVtObnEDs8jyH13QzYMXIQUWE";
                if (!z) {
                    return;
                }
            } else if (!z) {
                return;
            }
            this.A00.A0I();
            return;
        }
        this.A00.A0S.A8D(this.A00.A0P.A0Q(), new NQ().A04(this.A00.A0f).A03(this.A00.A0V).A06());
    }
}
