package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IR {
    public static String[] A07;
    public static final Comparator<IQ> A08;
    public static final Comparator<IQ> A09;
    public int A01;
    public int A02;
    public int A03;
    public final int A04;
    public final IQ[] A06 = new IQ[5];
    public final ArrayList<IQ> A05 = new ArrayList<>();
    public int A00 = -1;

    public static void A02() {
        A07 = new String[]{"v8bLZp59B3s5kjImuBjcCmNW", "l5XLQfXbQh6R34DBcL2a2gRDiWiOWq7j", "cKC0Gfnr6KNVk9zoAEVguSpqajRxhGsy", "4MzGZFDG0CqgMdioIrH5vwyzFGAbThRu", "MvXRt7wPeDxEfDCDFesb3zWoJZhNCkxf", "mCnVL7G0HMRU3KziMebPW175T1XCPvkW", "oyPZ3wFE5cpoHVmJFEQQrP2WxUjSMaR1", "eOuchRPwSpgwlWmZThUBhEapR1FbTYXS"};
    }

    static {
        A02();
        A08 = new IO();
        A09 = new IP();
    }

    public IR(int i) {
        this.A04 = i;
    }

    private void A00() {
        if (this.A00 != 1) {
            Collections.sort(this.A05, A08);
            this.A00 = 1;
        }
    }

    private void A01() {
        if (this.A00 != 0) {
            Collections.sort(this.A05, A09);
            this.A00 = 0;
        }
    }

    public final float A03(float f2) {
        A01();
        float f3 = this.A03 * f2;
        int i = 0;
        int i2 = 0;
        while (true) {
            ArrayList<IQ> arrayList = this.A05;
            if (A07[7].charAt(12) != 'l') {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[1] = "MYxxtSQw2w0IEM5GsYZTgS2IPhbXFMQD";
            strArr[1] = "MYxxtSQw2w0IEM5GsYZTgS2IPhbXFMQD";
            int i3 = arrayList.size();
            if (i2 < i3) {
                IQ iq = this.A05.get(i2);
                int i4 = iq.A02;
                i += i4;
                if (i >= f3) {
                    return iq.A00;
                }
                i2++;
            } else {
                if (this.A05.isEmpty()) {
                    return Float.NaN;
                }
                return this.A05.get(r1.size() - 1).A00;
            }
        }
    }

    public final void A04(int i, float f2) {
        IQ iq;
        A00();
        int i2 = this.A02;
        if (i2 > 0) {
            IQ[] iqArr = this.A06;
            int i3 = i2 - 1;
            this.A02 = i3;
            iq = iqArr[i3];
        } else {
            iq = new IQ(null);
        }
        int i4 = this.A01;
        this.A01 = i4 + 1;
        iq.A01 = i4;
        if (A07[6].charAt(29) != 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[0] = "5E26ZSMWQoSDuNI0YD8YDk9y";
        strArr[0] = "5E26ZSMWQoSDuNI0YD8YDk9y";
        iq.A02 = i;
        iq.A00 = f2;
        this.A05.add(iq);
        this.A03 += i;
        while (true) {
            int i5 = this.A03;
            int i6 = this.A04;
            if (i5 > i6) {
                int i7 = i5 - i6;
                IQ iq2 = this.A05.get(0);
                if (iq2.A02 <= i7) {
                    this.A03 -= iq2.A02;
                    this.A05.remove(0);
                    int i8 = this.A02;
                    if (i8 < 5) {
                        IQ[] iqArr2 = this.A06;
                        if (A07[6].charAt(29) != 'a') {
                            this.A02 = i8 + 1;
                            iqArr2[i8] = iq2;
                        } else {
                            String[] strArr2 = A07;
                            strArr2[0] = "NjEm8Wq6Ir4EIF9DQvkt7JHV";
                            strArr2[0] = "NjEm8Wq6Ir4EIF9DQvkt7JHV";
                            this.A02 = i8 + 1;
                            iqArr2[i8] = iq2;
                        }
                    }
                } else {
                    iq2.A02 -= i7;
                    this.A03 -= i7;
                }
            } else {
                return;
            }
        }
    }
}
