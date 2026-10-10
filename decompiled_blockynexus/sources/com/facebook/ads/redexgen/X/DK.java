package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DK {
    public static String[] A0I;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final CM A0E;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<IB> A0D = new SparseArray<>();
    public final SparseArray<IA> A0C = new SparseArray<>();
    public DJ A06 = new DJ();
    public DJ A07 = new DJ();
    public byte[] A0B = new byte[128];
    public final IH A0F = new IH(this.A0B, 0, 0);

    static {
        A00();
    }

    public static void A00() {
        A0I = new String[]{"4oBn500ONSa7zUcj69ZejwliI7fNkQe9", "sao3", "S05M", "dUQbnZGK3vs92wXndxl51oc8w6Wzg5UK", "r2dYBwwJ6wCRp20YpqJDniAkemsUTuNE", "fcxFuh", "wirhT", "AIyirGzN48rHG0XGibSi5d9zNx7vdYO1"};
    }

    public DK(CM cm, boolean z, boolean z2) {
        this.A0E = cm;
        this.A0G = z;
        this.A0H = z2;
        A02();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void A01(int i) {
        boolean z = this.A0A;
        this.A0E.ACy(this.A05, z ? 1 : 0, (int) (this.A02 - this.A04), i, null);
    }

    public final void A02() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A03();
    }

    public final void A03(long j, int i) {
        boolean z = false;
        if (this.A01 == 9 || (this.A0H && this.A07.A01(this.A06))) {
            if (this.A09) {
                A01(i + ((int) (j - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        boolean z2 = this.A0A;
        int i2 = this.A01;
        if (i2 == 5 || (this.A0G && i2 == 1 && this.A07.A06())) {
            z = true;
        }
        this.A0A = z2 | z;
    }

    public final void A04(long j, int i, long j2) {
        this.A01 = i;
        this.A03 = j2;
        this.A02 = j;
        if (!this.A0G || this.A01 != 1) {
            if (!this.A0H) {
                return;
            }
            int i2 = this.A01;
            if (i2 != 5 && i2 != 1 && i2 != 2) {
                return;
            }
        }
        DJ dj = this.A06;
        this.A06 = this.A07;
        this.A07 = dj;
        this.A07.A03();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A05(IA ia) {
        this.A0C.append(ia.A00, ia);
    }

    public final void A06(IB ib) {
        this.A0D.append(ib.A05, ib);
    }

    public final void A07(byte[] bArr, int readLength, int i) {
        if (!this.A08) {
            return;
        }
        int i2 = i - readLength;
        byte[] bArr2 = this.A0B;
        int length = bArr2.length;
        int i3 = this.A00;
        if (length < i3 + i2) {
            this.A0B = Arrays.copyOf(bArr2, (i3 + i2) * 2);
        }
        System.arraycopy(bArr, readLength, this.A0B, this.A00, i2);
        this.A00 += i2;
        this.A0F.A09(this.A0B, 0, this.A00);
        if (!this.A0F.A0C(8)) {
            return;
        }
        this.A0F.A07();
        int deltaPicOrderCnt1 = this.A0F.A06(2);
        this.A0F.A08(5);
        if (!this.A0F.A0A()) {
            return;
        }
        this.A0F.A05();
        if (!this.A0F.A0A()) {
            return;
        }
        int iA05 = this.A0F.A05();
        if (!this.A0H) {
            this.A08 = false;
            this.A07.A04(iA05);
            return;
        }
        if (!this.A0F.A0A()) {
            return;
        }
        int iA052 = this.A0F.A05();
        String[] strArr = A0I;
        if (strArr[0].charAt(5) != strArr[3].charAt(5)) {
            String[] strArr2 = A0I;
            strArr2[6] = "2v7XO";
            strArr2[6] = "2v7XO";
            int picParameterSetId = this.A0C.indexOfKey(iA052);
            if (picParameterSetId < 0) {
                this.A08 = false;
                return;
            }
            IA ppsData = this.A0C.get(iA052);
            IB ib = this.A0D.get(ppsData.A01);
            if (ib.A09) {
                if (!this.A0F.A0C(2)) {
                    return;
                } else {
                    this.A0F.A08(2);
                }
            }
            if (!this.A0F.A0C(ib.A01)) {
                return;
            }
            boolean zA0B = false;
            boolean z = false;
            boolean zA0B2 = false;
            int iA06 = this.A0F.A06(ib.A01);
            boolean bottomFieldFlagPresent = ib.A08;
            if (!bottomFieldFlagPresent) {
                boolean bottomFieldFlagPresent2 = this.A0F.A0C(1);
                if (!bottomFieldFlagPresent2) {
                    return;
                }
                zA0B = this.A0F.A0B();
                if (zA0B) {
                    boolean bottomFieldFlagPresent3 = this.A0F.A0C(1);
                    if (!bottomFieldFlagPresent3) {
                        return;
                    }
                    zA0B2 = this.A0F.A0B();
                    z = true;
                } else {
                    String[] strArr3 = A0I;
                    if (strArr3[2].length() == strArr3[1].length()) {
                        String[] strArr4 = A0I;
                        strArr4[4] = "qwcYbvbtciQlsge07t8jnpQbFFEGYRzL";
                        strArr4[4] = "qwcYbvbtciQlsge07t8jnpQbFFEGYRzL";
                    }
                }
            }
            boolean z2 = this.A01 == 5;
            int iA053 = 0;
            if (z2) {
                if (!this.A0F.A0A()) {
                    return;
                }
                IH ih = this.A0F;
                if (A0I[5].length() == 32) {
                    throw new RuntimeException();
                }
                String[] strArr5 = A0I;
                strArr5[0] = "CUn0EGRMZuaxcZmcWt6bm8g2eSLscmSu";
                strArr5[3] = "AO4oaRrhS9J5INJLsqTeqW6rWo7URvM3";
                iA053 = ih.A05();
            }
            int iA062 = 0;
            int iA04 = 0;
            int iA042 = 0;
            int iA043 = 0;
            int picOrderCntLsb = ib.A04;
            if (picOrderCntLsb == 0) {
                IH ih2 = this.A0F;
                int deltaPicOrderCnt12 = ib.A03;
                if (!ih2.A0C(deltaPicOrderCnt12)) {
                    return;
                }
                IH ih3 = this.A0F;
                int i4 = ib.A03;
                int picOrderCntLsb2 = A0I[7].charAt(28);
                if (picOrderCntLsb2 != 108) {
                    String[] strArr6 = A0I;
                    strArr6[4] = "13MW05H83xonKdXxuFb2nSy24rNhSBqM";
                    strArr6[4] = "13MW05H83xonKdXxuFb2nSy24rNhSBqM";
                    iA062 = ih3.A06(i4);
                    if (ppsData.A02 && !zA0B) {
                        if (!this.A0F.A0A()) {
                            return;
                        } else {
                            iA04 = this.A0F.A04();
                        }
                    }
                }
            } else {
                int picOrderCntLsb3 = ib.A04;
                if (A0I[7].charAt(28) == 'l') {
                    throw new RuntimeException();
                }
                String[] strArr7 = A0I;
                strArr7[7] = "MOrewcskpOrth27AIRJiHCsaXTOPbZzW";
                strArr7[7] = "MOrewcskpOrth27AIRJiHCsaXTOPbZzW";
                if (picOrderCntLsb3 == 1 && !ib.A07) {
                    if (!this.A0F.A0A()) {
                        return;
                    }
                    iA042 = this.A0F.A04();
                    if (ppsData.A02 && !zA0B) {
                        if (!this.A0F.A0A()) {
                            return;
                        } else {
                            iA043 = this.A0F.A04();
                        }
                    }
                }
            }
            this.A07.A05(ib, deltaPicOrderCnt1, iA05, iA06, iA052, zA0B, z, zA0B2, z2, iA053, iA062, iA04, iA042, iA043);
            this.A08 = false;
            return;
        }
        throw new RuntimeException();
    }

    public final boolean A08() {
        return this.A0H;
    }
}
