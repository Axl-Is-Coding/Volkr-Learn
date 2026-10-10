package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.m;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z2 implements DV {
    public static String[] A06;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final DO A04;
    public final IG A05 = new IG(32);

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"kFQyFzcAtW9h", "T9w", "fQaNjl3SJX3d9bVQ", "oZJ95vdSt2TTHBWCj0JXn5a7ndpZ8Bju", "u9yp8kydrxa7", "6VdIrZzllDHdfU7GHzHok5zrzcn9yZKG", "C5", "TRfT7Vv0"};
    }

    public Z2(DO r3) {
        this.A04 = r3;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A49(IG ig, boolean z) {
        int iA07 = -1;
        if (z) {
            iA07 = ig.A07() + ig.A0F();
        }
        boolean z2 = this.A03;
        if (A06[1].length() == 27) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "Nc9T8xtu";
        strArr[7] = "Nc9T8xtu";
        if (z2) {
            if (!z) {
                return;
            }
            this.A03 = false;
            ig.A0Z(iA07);
            this.A00 = 0;
        }
        while (ig.A05() > 0) {
            int i = this.A00;
            if (i < 3) {
                if (i == 0) {
                    int iA0F = ig.A0F();
                    ig.A0Z(ig.A07() - 1);
                    if (A06[7].length() != 8) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A06;
                    strArr2[2] = "aJNwIS78aN3JetqFlJ8G";
                    strArr2[2] = "aJNwIS78aN3JetqFlJ8G";
                    if (iA0F == 255) {
                        this.A03 = true;
                        return;
                    }
                }
                int iMin = Math.min(ig.A05(), 3 - this.A00);
                ig.A0d(this.A05.A00, this.A00, iMin);
                this.A00 += iMin;
                if (this.A00 == 3) {
                    this.A05.A0X(3);
                    this.A05.A0a(1);
                    int iA0F2 = this.A05.A0F();
                    int iA0F3 = this.A05.A0F();
                    this.A02 = (iA0F2 & 128) != 0;
                    this.A01 = (((iA0F2 & 15) << 8) | iA0F3) + 3;
                    if (this.A05.A06() < this.A01) {
                        byte[] bytes = this.A05.A00;
                        this.A05.A0X(Math.min(m.a.f20900b, Math.max(this.A01, bytes.length * 2)));
                        System.arraycopy(bytes, 0, this.A05.A00, 0, 3);
                    }
                }
            } else {
                int iMin2 = Math.min(ig.A05(), this.A01 - this.A00);
                ig.A0d(this.A05.A00, this.A00, iMin2);
                this.A00 += iMin2;
                int i2 = this.A00;
                int i3 = this.A01;
                if (i2 == i3) {
                    boolean z3 = this.A02;
                    if (A06[7].length() != 8) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A06;
                    strArr3[1] = "WscUDiyP9zB";
                    strArr3[1] = "WscUDiyP9zB";
                    if (z3) {
                        if (IW.A09(this.A05.A00, 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        }
                        IG ig2 = this.A05;
                        int thirdHeaderByte = this.A01 - 4;
                        if (A06[2].length() != 29) {
                            String[] strArr4 = A06;
                            strArr4[3] = "nNiCCranccCPI0NRpeExr6ylwZyZykwG";
                            strArr4[5] = "pfAdcnCCuWORkUPhfNuwqkYYK2fT2IOL";
                            ig2.A0X(thirdHeaderByte);
                        } else {
                            String[] strArr5 = A06;
                            strArr5[2] = "0kjAgxStX";
                            strArr5[2] = "0kjAgxStX";
                            ig2.A0X(thirdHeaderByte);
                        }
                    } else {
                        this.A05.A0X(i3);
                    }
                    this.A04.A48(this.A05);
                    this.A00 = 0;
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A7g(IS is, CC cc, DU du) {
        this.A04.A7g(is, cc, du);
        this.A03 = true;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AD1() {
        this.A03 = true;
    }
}
