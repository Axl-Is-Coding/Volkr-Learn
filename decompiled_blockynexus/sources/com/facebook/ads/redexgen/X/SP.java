package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SP implements InterfaceC13363w {
    public static byte[] A08;
    public static String[] A09;
    public int A00;
    public C2P<C3Z> A01;
    public final C3Y A02;
    public final C13373x A03;
    public final Runnable A04;
    public final ArrayList<C3Z> A05;
    public final ArrayList<C3Z> A06;
    public final boolean A07;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A08 = new byte[]{-100, -75, -78, -75, -74, -66, -75, 103, -68, -73, -85, -88, -69, -84, 103, -74, -73, 103, -69, -64, -73, -84, 103, -83, -74, -71, 103, -44, -45, -47, -34, -123, -41, -54, -46, -44, -37, -54, -123, -58, -45, -55, -123, -38, -43, -55, -58, -39, -54, -123, -44, -43, -40, -123, -56, -58, -45, -123, -57, -54, -123, -55, -50, -40, -43, -58, -39, -56, -51, -54, -55, -123, -50, -45, -123, -53, -50, -41, -40, -39, -123, -43, -58, -40, -40, -24, -23, -103, -20, -31, -24, -18, -27, -35, -103, -37, -34, -103, -21, -34, -26, -24, -17, -34, -103, -24, -21, -103, -18, -23, -35, -38, -19, -34, -89, 30, 19, 26, 32, 23, ci.m, -53, 25, 26, 31, -53, ci.m, 20, 30, 27, 12, 31, ci.l, 19, -53, 12, ci.m, ci.m, -53, 26, 29, -53, 24, 26, 33, ci.n, -53, 17, 26, 29, -53, 27, 29, ci.n, -53, 23, 12, 36, 26, 32, 31};
    }

    public static void A04() {
        A09 = new String[]{"X1JWoRd1RTsi5LXg3YfkE890Z0SkAp6s", "8cHG76lMVFwKxBGRg2kgut24eHhxfbd", "G9TzZa55JFGh4eGgvGtqHGY1m3qrW6LM", "T7A4lgHZzGr7V1uQcw7LfDSO4lerGRH7", "wT7nveBXif1G6UL4LkiEJi9kfhK", "XR1Jqmc9zxsTs7lfyBsyi3NvUHLKhP3K", "pVA6ZWYUVwE4UScIoRBBosOqE3FsfWwK", "nWmw"};
    }

    public SP(C3Y c3y) {
        this(c3y, false);
    }

    public SP(C3Y c3y, boolean z) {
        this.A01 = new S7(30);
        this.A05 = new ArrayList<>();
        this.A06 = new ArrayList<>();
        this.A00 = 0;
        this.A02 = c3y;
        this.A07 = z;
        this.A03 = new C13373x(this);
    }

    private int A00(int i, int start) {
        int i2;
        int i3;
        for (int end = this.A06.size() - 1; end >= 0; end--) {
            C3Z c3z = this.A06.get(end);
            if (c3z.A00 == 8) {
                if (c3z.A02 < c3z.A01) {
                    i2 = c3z.A02;
                    i3 = c3z.A01;
                } else {
                    i2 = c3z.A01;
                    i3 = c3z.A02;
                }
                if (i >= i2 && i <= i3) {
                    if (i2 == c3z.A02) {
                        if (start == 1) {
                            c3z.A01++;
                        } else if (start == 2) {
                            c3z.A01--;
                        }
                        i++;
                    } else {
                        if (start == 1) {
                            c3z.A02++;
                        } else if (start == 2) {
                            c3z.A02--;
                        }
                        i--;
                    }
                } else if (i < c3z.A02) {
                    if (start == 1) {
                        c3z.A02++;
                        c3z.A01++;
                    } else if (start == 2) {
                        c3z.A02--;
                        c3z.A01--;
                    }
                }
            } else if (c3z.A02 <= i) {
                if (c3z.A00 == 1) {
                    int i4 = c3z.A01;
                    if (A09[7].length() != 4) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A09;
                    strArr[7] = "N0sU";
                    strArr[7] = "N0sU";
                    i -= i4;
                } else if (c3z.A00 == 2) {
                    i += c3z.A01;
                }
            } else if (start == 1) {
                c3z.A02++;
            } else if (start == 2) {
                c3z.A02--;
            }
        }
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            C3Z c3z2 = this.A06.get(size);
            if (c3z2.A00 == 8) {
                if (c3z2.A01 == c3z2.A02 || c3z2.A01 < 0) {
                    this.A06.remove(size);
                    ACR(c3z2);
                }
            } else if (c3z2.A01 <= 0) {
                this.A06.remove(size);
                ACR(c3z2);
            }
        }
        return i;
    }

    private final int A01(int i, int i2) {
        int size = this.A06.size();
        while (i2 < size) {
            C3Z c3z = this.A06.get(i2);
            if (c3z.A00 == 8) {
                if (c3z.A02 == i) {
                    i = c3z.A01;
                } else {
                    if (c3z.A02 < i) {
                        i--;
                    }
                    if (c3z.A01 <= i) {
                        i++;
                    }
                }
            } else if (c3z.A02 > i) {
                continue;
            } else if (c3z.A00 == 2) {
                if (i < c3z.A02 + c3z.A01) {
                    return -1;
                }
                i -= c3z.A01;
            } else {
                int i3 = c3z.A00;
                String[] strArr = A09;
                if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[1] = "6d2Cvy1MfGwOem3AHh21iiz4RwVuOhP";
                strArr2[1] = "6d2Cvy1MfGwOem3AHh21iiz4RwVuOhP";
                if (i3 == 1) {
                    i += c3z.A01;
                }
            }
            i2++;
        }
        return i;
    }

    private void A05(C3Z c3z) {
        A0A(c3z);
    }

    private void A06(C3Z c3z) {
        A0A(c3z);
    }

    private void A07(C3Z c3z) {
        int tmpEnd = c3z.A02;
        int type = 0;
        int position = c3z.A02 + c3z.A01;
        byte b2 = -1;
        int i = c3z.A02;
        while (i < position) {
            boolean z = false;
            if (this.A02.A5F(i) != null || A0D(i)) {
                if (b2 == 0) {
                    A09(A8w(2, tmpEnd, type, null));
                    z = true;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    C3Z newOp = A8w(2, tmpEnd, type, null);
                    A0A(newOp);
                    z = true;
                }
                b2 = 0;
            }
            if (z) {
                i -= type;
                position -= type;
                type = 1;
            } else {
                type++;
            }
            i++;
        }
        if (type != c3z.A01) {
            ACR(c3z);
            c3z = A8w(2, tmpEnd, type, null);
        }
        if (b2 == 0) {
            A09(c3z);
        } else {
            A0A(c3z);
        }
    }

    private void A08(C3Z c3z) {
        int tmpEnd = c3z.A02;
        int type = 0;
        int position = c3z.A02 + c3z.A01;
        byte b2 = -1;
        int i = c3z.A02;
        while (true) {
            String[] strArr = A09;
            if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[0] = "QVMb2fRXyzWHiAZPpRD1aZXDVthvAAWC";
            strArr2[0] = "QVMb2fRXyzWHiAZPpRD1aZXDVthvAAWC";
            if (i < position) {
                if (this.A02.A5F(i) != null || A0D(i)) {
                    if (b2 == 0) {
                        A09(A8w(4, tmpEnd, type, c3z.A03));
                        type = 0;
                        tmpEnd = i;
                    }
                    b2 = 1;
                } else {
                    if (b2 == 1) {
                        C3Z newOp = A8w(4, tmpEnd, type, c3z.A03);
                        A0A(newOp);
                        type = 0;
                        tmpEnd = i;
                    }
                    b2 = 0;
                }
                type++;
                i++;
            } else {
                if (type != c3z.A01) {
                    Object obj = c3z.A03;
                    ACR(c3z);
                    c3z = A8w(4, tmpEnd, type, obj);
                }
                if (b2 == 0) {
                    A09(c3z);
                    return;
                } else {
                    A0A(c3z);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(com.facebook.ads.redexgen.X.C3Z r12) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.SP.A09(com.facebook.ads.redexgen.X.3Z):void");
    }

    private void A0A(C3Z c3z) {
        this.A06.add(c3z);
        int i = c3z.A00;
        if (i == 1) {
            this.A02.A8x(c3z.A02, c3z.A01);
            return;
        }
        if (i == 2) {
            this.A02.A90(c3z.A02, c3z.A01);
            return;
        }
        if (i == 4) {
            this.A02.A8j(c3z.A02, c3z.A01, c3z.A03);
        } else {
            if (i == 8) {
                this.A02.A8y(c3z.A02, c3z.A01);
                return;
            }
            throw new IllegalArgumentException(A02(0, 27, 5) + c3z);
        }
    }

    private final void A0B(C3Z c3z, int i) {
        this.A02.A9c(c3z);
        int i2 = c3z.A00;
        if (i2 == 2) {
            this.A02.A8z(i, c3z.A01);
        } else {
            if (i2 == 4) {
                this.A02.A8j(i, c3z.A01, c3z.A03);
                return;
            }
            throw new IllegalArgumentException(A02(27, 58, 35));
        }
    }

    private final void A0C(List<C3Z> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ACR(list.get(i));
        }
        list.clear();
    }

    private boolean A0D(int i) {
        int size = this.A06.size();
        for (int pos = 0; pos < size; pos++) {
            C3Z c3z = this.A06.get(pos);
            if (c3z.A00 == 8) {
                if (A01(c3z.A01, pos + 1) == i) {
                    return true;
                }
            } else {
                int i2 = c3z.A00;
                if (A09[4].length() == 28) {
                    throw new RuntimeException();
                }
                String[] strArr = A09;
                strArr[7] = "h3FT";
                strArr[7] = "h3FT";
                if (i2 == 1) {
                    int i3 = c3z.A02 + c3z.A01;
                    for (int i4 = c3z.A02; i4 < i3; i4++) {
                        if (A01(i4, pos + 1) == i) {
                            return true;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final int A0E(int i) {
        return A01(i, 0);
    }

    public final int A0F(int i) {
        int size = this.A05.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3Z c3z = this.A05.get(i2);
            int i3 = c3z.A00;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (c3z.A02 == i) {
                            i = c3z.A01;
                        } else {
                            if (c3z.A02 < i) {
                                i--;
                            }
                            if (c3z.A01 <= i) {
                                i++;
                            }
                        }
                    }
                } else if (c3z.A02 > i) {
                    continue;
                } else {
                    if (c3z.A02 + c3z.A01 > i) {
                        return -1;
                    }
                    i -= c3z.A01;
                }
            } else if (c3z.A02 <= i) {
                i += c3z.A01;
            }
        }
        return i;
    }

    public final void A0G() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            this.A02.A9e(this.A06.get(i));
        }
        A0C(this.A06);
        this.A00 = 0;
    }

    public final void A0H() {
        A0G();
        int size = this.A05.size();
        for (int i = 0; i < size; i++) {
            C3Z c3z = this.A05.get(i);
            int i2 = c3z.A00;
            if (i2 == 1) {
                this.A02.A9e(c3z);
                C3Y c3y = this.A02;
                int i3 = c3z.A02;
                int i4 = c3z.A01;
                c3y.A8x(i3, i4);
            } else if (i2 == 2) {
                this.A02.A9e(c3z);
                C3Y c3y2 = this.A02;
                int i5 = c3z.A02;
                int i6 = c3z.A01;
                if (A09[0].charAt(28) != 'A') {
                    String[] strArr = A09;
                    strArr[0] = "CM7MK7KhSxDopOj0YrHNMoPSB3hYAvlM";
                    strArr[0] = "CM7MK7KhSxDopOj0YrHNMoPSB3hYAvlM";
                    c3y2.A8z(i5, i6);
                } else {
                    String[] strArr2 = A09;
                    strArr2[0] = "0a4GBd0juwjU6ZOPGBL8pgIRsQZTAwEC";
                    strArr2[0] = "0a4GBd0juwjU6ZOPGBL8pgIRsQZTAwEC";
                    c3y2.A8z(i5, i6);
                }
            } else if (i2 == 4) {
                this.A02.A9e(c3z);
                C3Y c3y3 = this.A02;
                int i7 = c3z.A02;
                int i8 = c3z.A01;
                if (A09[0].charAt(28) != 'A') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A09;
                strArr3[1] = "6Qpi3zwbHCTXm3nhA4JhLro11ECL3LU";
                strArr3[1] = "6Qpi3zwbHCTXm3nhA4JhLro11ECL3LU";
                c3y3.A8j(i7, i8, c3z.A03);
            } else if (i2 == 8) {
                this.A02.A9e(c3z);
                C3Y c3y4 = this.A02;
                int i9 = c3z.A02;
                int i10 = c3z.A01;
                c3y4.A8y(i9, i10);
            }
            Runnable runnable = this.A04;
            if (runnable != null) {
                runnable.run();
            }
        }
        A0C(this.A05);
        this.A00 = 0;
    }

    public final void A0I() {
        this.A03.A06(this.A05);
        int size = this.A05.size();
        for (int i = 0; i < size; i++) {
            C3Z c3z = this.A05.get(i);
            int i2 = c3z.A00;
            String[] strArr = A09;
            String str = strArr[6];
            String str2 = strArr[5];
            int i3 = str.charAt(31);
            if (i3 != str2.charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[1] = "1BDdKJQJlsgxETOK14Gjs1hC7fjbuKK";
            strArr2[1] = "1BDdKJQJlsgxETOK14Gjs1hC7fjbuKK";
            if (i2 == 1) {
                A05(c3z);
            } else if (i2 == 2) {
                A07(c3z);
            } else if (i2 == 4) {
                A08(c3z);
            } else if (i2 == 8) {
                A06(c3z);
            }
            Runnable runnable = this.A04;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.A05.clear();
    }

    public final void A0J() {
        A0C(this.A05);
        A0C(this.A06);
        this.A00 = 0;
    }

    public final boolean A0K() {
        return this.A05.size() > 0;
    }

    public final boolean A0L() {
        return (this.A06.isEmpty() || this.A05.isEmpty()) ? false : true;
    }

    public final boolean A0M(int i) {
        return (this.A00 & i) != 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13363w
    public final C3Z A8w(int i, int i2, int i3, Object obj) {
        C3Z c3zA2P = this.A01.A2P();
        if (c3zA2P == null) {
            return new C3Z(i, i2, i3, obj);
        }
        c3zA2P.A00 = i;
        c3zA2P.A02 = i2;
        c3zA2P.A01 = i3;
        c3zA2P.A03 = obj;
        return c3zA2P;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13363w
    public final void ACR(C3Z c3z) {
        if (!this.A07) {
            c3z.A03 = null;
            this.A01.ACZ(c3z);
        }
    }
}
