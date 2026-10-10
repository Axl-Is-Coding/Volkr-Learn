package com.facebook.ads.redexgen.X;

import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13373x {
    public static String[] A01;
    public final InterfaceC13363w A00;

    static {
        A01();
    }

    public static void A01() {
        A01 = new String[]{"1CU3iw4Trc3qggngkxP7P26jEGLrLZaR", "qcH7HKgKdAybLTWn0rmK7JyCE0S9C8rn", "oNJ0dA1Zpt4CixMfeWT18n5RxX88Y0E3", "FZ8N3xW3PfzdZjJWrErZ2QIuE13XuJtD", "DvPOKoiXqOiYMgjx6IqCziqOSBLzEcJY", "MpMZeZ7xc490HXAXJonG5r1KTyiIoUHH", "NGMd8PbmdSzgSLgNcWdVjgLa", "jY1Ixh6DMe9BpV8yAbg842YJP45AQ2Eb"};
    }

    public C13373x(InterfaceC13363w interfaceC13363w) {
        this.A00 = interfaceC13363w;
    }

    private int A00(List<C3Z> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).A00 == 8) {
                if (z) {
                    return size;
                }
            } else {
                z = true;
            }
        }
        return -1;
    }

    private void A02(List<C3Z> list, int i, int i2) {
        C3Z c3z = list.get(i);
        C3Z nextOp = list.get(i2);
        int i3 = nextOp.A00;
        if (i3 != 1) {
            if (i3 == 2) {
                A04(list, i, c3z, i2, nextOp);
                return;
            } else {
                if (i3 == 4) {
                    A05(list, i, c3z, i2, nextOp);
                    return;
                }
                return;
            }
        }
        String[] strArr = A01;
        if (strArr[1].charAt(7) == strArr[5].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "aUQhN9RPINWHdtDS2haQB24BMlUHbr4B";
        strArr2[7] = "XOFwSchhjWWz78nEYYkf12AsjhBhdKRi";
        A03(list, i, c3z, i2, nextOp);
    }

    private void A03(List<C3Z> list, int i, C3Z c3z, int i2, C3Z c3z2) {
        int i3 = 0;
        if (c3z.A01 < c3z2.A02) {
            i3 = 0 - 1;
        }
        if (c3z.A02 < c3z2.A02) {
            i3++;
        }
        if (c3z2.A02 <= c3z.A02) {
            c3z.A02 += c3z2.A01;
        }
        if (c3z2.A02 <= c3z.A01) {
            c3z.A01 += c3z2.A01;
        }
        c3z2.A02 += i3;
        list.set(i, c3z2);
        list.set(i2, c3z);
    }

    private final void A04(List<C3Z> list, int i, C3Z c3z, int i2, C3Z c3z2) {
        boolean z;
        C3Z c3zA8w = null;
        boolean z2 = false;
        if (c3z.A02 < c3z.A01) {
            z = false;
            if (c3z2.A02 == c3z.A02 && c3z2.A01 == c3z.A01 - c3z.A02) {
                z2 = true;
            }
        } else {
            z = true;
            if (c3z2.A02 == c3z.A01 + 1 && c3z2.A01 == c3z.A02 - c3z.A01) {
                z2 = true;
            }
        }
        if (c3z.A01 < c3z2.A02) {
            c3z2.A02--;
        } else if (c3z.A01 < c3z2.A02 + c3z2.A01) {
            c3z2.A01--;
            c3z.A00 = 2;
            c3z.A01 = 1;
            int i3 = c3z2.A01;
            if (A01[6].length() == 11) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "8AUTweiK2qHuqKAjuAP9RAHRjtqC9cI5";
            strArr[3] = "fxjAamJyQJjVOLb9u9QxKoC9co41mLuZ";
            if (i3 == 0) {
                list.remove(i2);
                this.A00.ACR(c3z2);
                return;
            }
            return;
        }
        if (c3z.A02 <= c3z2.A02) {
            c3z2.A02++;
        } else if (c3z.A02 < c3z2.A02 + c3z2.A01) {
            c3zA8w = this.A00.A8w(2, c3z.A02 + 1, (c3z2.A02 + c3z2.A01) - c3z.A02, null);
            c3z2.A01 = c3z.A02 - c3z2.A02;
        }
        if (z2) {
            list.set(i, c3z2);
            list.remove(i2);
            this.A00.ACR(c3z);
            return;
        }
        if (z) {
            if (c3zA8w != null) {
                if (c3z.A02 > c3zA8w.A02) {
                    c3z.A02 -= c3zA8w.A01;
                }
                if (c3z.A01 > c3zA8w.A02) {
                    c3z.A01 -= c3zA8w.A01;
                }
            }
            if (c3z.A02 > c3z2.A02) {
                c3z.A02 -= c3z2.A01;
            }
            if (c3z.A01 > c3z2.A02) {
                c3z.A01 -= c3z2.A01;
            }
        } else {
            if (c3zA8w != null) {
                if (c3z.A02 >= c3zA8w.A02) {
                    c3z.A02 -= c3zA8w.A01;
                }
                if (c3z.A01 >= c3zA8w.A02) {
                    c3z.A01 -= c3zA8w.A01;
                }
            }
            if (c3z.A02 >= c3z2.A02) {
                c3z.A02 -= c3z2.A01;
            }
            if (c3z.A01 >= c3z2.A02) {
                c3z.A01 -= c3z2.A01;
            }
        }
        list.set(i, c3z2);
        String[] strArr2 = A01;
        if (strArr2[1].charAt(7) == strArr2[5].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A01;
        strArr3[1] = "R1vl9Esi4EQuoIO0IEs3BYKA9Bp2yfIo";
        strArr3[5] = "ll7MLLjNdpT1F8Cd0W3dCYnGe1w6KT9M";
        if (c3z.A02 != c3z.A01) {
            list.set(i2, c3z);
        } else {
            list.remove(i2);
        }
        if (c3zA8w != null) {
            list.add(i, c3zA8w);
        }
    }

    private final void A05(List<C3Z> list, int i, C3Z c3z, int i2, C3Z c3z2) {
        C3Z c3zA8w = null;
        C3Z c3zA8w2 = null;
        if (c3z.A01 < c3z2.A02) {
            c3z2.A02--;
        } else if (c3z.A01 < c3z2.A02 + c3z2.A01) {
            c3z2.A01--;
            c3zA8w = this.A00.A8w(4, c3z.A02, 1, c3z2.A03);
        }
        if (c3z.A02 <= c3z2.A02) {
            c3z2.A02++;
        } else if (c3z.A02 < c3z2.A02 + c3z2.A01) {
            int i3 = (c3z2.A02 + c3z2.A01) - c3z.A02;
            c3zA8w2 = this.A00.A8w(4, c3z.A02 + 1, i3, c3z2.A03);
            c3z2.A01 -= i3;
        }
        list.set(i2, c3z);
        if (c3z2.A01 > 0) {
            list.set(i, c3z2);
        } else {
            list.remove(i);
            this.A00.ACR(c3z2);
        }
        if (c3zA8w != null) {
            list.add(i, c3zA8w);
        }
        if (c3zA8w2 != null) {
            list.add(i, c3zA8w2);
        }
    }

    public final void A06(List<C3Z> list) {
        while (true) {
            int iA00 = A00(list);
            if (iA00 != -1) {
                A02(list, iA00, iA00 + 1);
            } else {
                return;
            }
        }
    }
}
