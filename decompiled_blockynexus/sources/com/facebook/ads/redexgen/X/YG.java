package com.facebook.ads.redexgen.X;

import com.sandboxol.center.config.VipSubscribeStatus;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YG implements CA {
    public static byte[] A0F;
    public static String[] A0G;
    public static final CD A0H;
    public static final int A0I;
    public int A00;
    public int A02;
    public int A03;
    public long A05;
    public CC A06;
    public YE A07;
    public YJ A08;
    public boolean A09;
    public final IG A0C = new IG(4);
    public final IG A0B = new IG(9);
    public final IG A0E = new IG(11);
    public final IG A0D = new IG();
    public final YH A0A = new YH();
    public int A01 = 1;
    public long A04 = -9223372036854775807L;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0F = new byte[]{-117, -111, -101};
    }

    public static void A04() {
        A0G = new String[]{"F9KwQMNMxiTjkayDhPM6gvDLkPvUNcLn", "Em4FZTw9NeUBCVsnasMEsqdbQrmSbGq", "", "tDq5h6G1X4d5RY1LfaFLZXWqT85DrCya", "B5R7X", "Y", "Zp00UWtElOmikRSXEs37FpNUTZ5eWL9Y", "wqRNyyxlEoRi9"};
    }

    static {
        A04();
        A03();
        A0H = new YF();
        A0I = IW.A08(A01(0, 3, 9));
    }

    private IG A00(CB cb) throws InterruptedException, IOException {
        if (this.A02 > this.A0D.A06()) {
            IG ig = this.A0D;
            ig.A0c(new byte[Math.max(ig.A06() * 2, this.A02)], 0);
        } else {
            this.A0D.A0Z(0);
        }
        this.A0D.A0Y(this.A02);
        cb.readFully(this.A0D.A00, 0, this.A02);
        return this.A0D;
    }

    private void A02() {
        if (!this.A09) {
            this.A06.AD3(new YB(-9223372036854775807L));
            this.A09 = true;
        }
        if (this.A04 != -9223372036854775807L) {
            return;
        }
        this.A04 = this.A0A.A0E() == -9223372036854775807L ? -this.A05 : 0L;
    }

    private void A05(CB cb) throws InterruptedException, IOException {
        cb.ADZ(this.A00);
        this.A00 = 0;
        this.A01 = 3;
    }

    private boolean A06(CB cb) throws InterruptedException, IOException {
        if (!cb.ACL(this.A0B.A00, 0, 9, true)) {
            return false;
        }
        IG ig = this.A0B;
        if (A0G[4].length() == 15) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[3] = "xxv79KM5VyarLmUhQqEOMlbbyGFtPWOG";
        strArr[6] = "n0W8PrJEyrqWl4lCbLWkK9bcjvpbO2Fn";
        ig.A0Z(0);
        this.A0B.A0a(4);
        int iA0F = this.A0B.A0F();
        boolean z = (iA0F & 4) != 0;
        boolean hasAudio = (iA0F & 1) != 0;
        if (z && this.A07 == null) {
            this.A07 = new YE(this.A06.ADr(8, 1));
        }
        if (hasAudio && this.A08 == null) {
            this.A08 = new YJ(this.A06.ADr(9, 2));
        }
        this.A06.A54();
        this.A00 = (this.A0B.A09() - 9) + 4;
        this.A01 = 2;
        return true;
    }

    private boolean A07(CB cb) throws InterruptedException, IOException {
        boolean z = true;
        if (this.A03 == 8 && this.A07 != null) {
            A02();
            this.A07.A00(A00(cb), this.A04 + this.A05);
        } else if (this.A03 == 9 && this.A08 != null) {
            A02();
            this.A08.A00(A00(cb), this.A04 + this.A05);
        } else if (this.A03 == 18 && !this.A09) {
            this.A0A.A00(A00(cb), this.A05);
            long jA0E = this.A0A.A0E();
            if (jA0E != -9223372036854775807L) {
                this.A06.AD3(new YB(jA0E));
                this.A09 = true;
            }
        } else {
            int i = this.A02;
            if (A0G[4].length() == 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[0] = "mShHrd4Vu2jNkvRJUK8UrhhXjzgbGKl1";
            strArr[0] = "mShHrd4Vu2jNkvRJUK8UrhhXjzgbGKl1";
            cb.ADZ(i);
            z = false;
        }
        this.A00 = 4;
        this.A01 = 2;
        return z;
    }

    private boolean A08(CB cb) throws InterruptedException, IOException {
        if (!cb.ACL(this.A0E.A00, 0, 11, true)) {
            return false;
        }
        this.A0E.A0Z(0);
        this.A03 = this.A0E.A0F();
        this.A02 = this.A0E.A0H();
        this.A05 = this.A0E.A0H();
        this.A05 = (((long) (this.A0E.A0F() << 24)) | this.A05) * 1000;
        this.A0E.A0a(3);
        this.A01 = 4;
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A06 = cc;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        while (true) {
            int i = this.A01;
            if (i != 1) {
                if (i == 2) {
                    A05(cb);
                } else {
                    if (A0G[4].length() == 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0G;
                    strArr[4] = "ncW0XwKX3pgCRaaT";
                    strArr[4] = "ncW0XwKX3pgCRaaT";
                    if (i != 3) {
                        if (i == 4) {
                            if (A07(cb)) {
                                if (A0G[0].charAt(18) != 'j') {
                                    String[] strArr2 = A0G;
                                    strArr2[7] = VipSubscribeStatus.SUBSCRIPTION_ON_HOLD;
                                    strArr2[7] = VipSubscribeStatus.SUBSCRIPTION_ON_HOLD;
                                    return 0;
                                }
                                String[] strArr3 = A0G;
                                strArr3[7] = "DR5iBP2XCUKx659t";
                                strArr3[7] = "DR5iBP2XCUKx659t";
                                return 0;
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (!A08(cb)) {
                        return -1;
                    }
                }
            } else if (!A06(cb)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A01 = 1;
        this.A04 = -9223372036854775807L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        cb.ABs(this.A0C.A00, 0, 3);
        this.A0C.A0Z(0);
        if (this.A0C.A0H() != A0I) {
            return false;
        }
        cb.ABs(this.A0C.A00, 0, 2);
        this.A0C.A0Z(0);
        if ((this.A0C.A0J() & 250) != 0) {
            return false;
        }
        cb.ABs(this.A0C.A00, 0, 4);
        this.A0C.A0Z(0);
        int iA09 = this.A0C.A09();
        cb.ACt();
        cb.A3M(iA09);
        cb.ABs(this.A0C.A00, 0, 4);
        this.A0C.A0Z(0);
        return this.A0C.A09() == 0;
    }
}
