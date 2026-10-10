package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.sandboxol.center.config.VipSubscribeStatus;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CQ implements XX {
    public static byte[] A0M;
    public static String[] A0N;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;

    @Nullable
    public C14789u A05;
    public AE A06;
    public AF A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final Handler A0C;
    public final Handler A0D;
    public final CN A0E;
    public final AX A0F;
    public final AY A0G;
    public final H1 A0H;
    public final H2 A0I;
    public final ArrayDeque<C14829y> A0J;
    public final CopyOnWriteArraySet<AI> A0K;
    public final XZ[] A0L;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0N[7].length() == 1) {
                throw new RuntimeException();
            }
            String[] strArr = A0N;
            strArr[7] = "NVWBbKH";
            strArr[7] = "NVWBbKH";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 75);
            i4++;
        }
    }

    public static void A03() {
        A0M = new byte[]{108, 23, 126, 67, 84, 107, 87, 90, 66, 94, 73, 114, 86, 75, 87, 64, 125, 106, 85, 105, 100, 124, 96, 119, 73, 108, 103, 42, 55, 43, 61, 43, 49, 54, 17, 22, 11, 95, 27, 44, 37, 44, 40, 58, 44, 105, 64, 72, 53, 78, 50, 36, 36, 42, 21, 46, 97, 40, 38, 47, 46, 51, 36, 37, 97, 35, 36, 34, 32, 52, 50, 36, 97, 32, 47, 97, 32, 37, 97, 40, 50, 97, 49, 45, 32, 56, 40, 47, 38};
    }

    public static void A04() {
        A0N = new String[]{"FdQu0fmyjo2y", "53g7H5tUmq98heWq", "c", "OWB4F6Jbct6Ly4JY", "NHyc4CVBcI41", "VuRuzyUBfoaB1KqcrIY9ro", "m", "Ea4pNsdJDJP"};
    }

    @SuppressLint({"HandlerLeak"})
    public CQ(XZ[] xzArr, H1 h1, A9 a9, InterfaceC1665Hu interfaceC1665Hu) {
        Log.i(A02(2, 13, 112), A02(33, 5, 52) + Integer.toHexString(System.identityHashCode(this)) + A02(0, 2, 7) + A02(15, 18, 78) + A02(47, 3, 94) + IW.A04 + A02(46, 1, 86));
        C1662Hr.A04(xzArr.length > 0);
        this.A0L = (XZ[]) C1662Hr.A01(xzArr);
        this.A0H = (H1) C1662Hr.A01(h1);
        this.A0A = false;
        this.A03 = 0;
        this.A0B = false;
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0I = new H2(new AT[xzArr.length], new InterfaceC1643Gy[xzArr.length], null);
        this.A0G = new AY();
        this.A0F = new AX();
        this.A07 = AF.A04;
        final Looper looperMyLooper = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
        this.A0C = new Handler(looperMyLooper) { // from class: com.facebook.ads.redexgen.X.9x
            @Override // android.os.Handler
            public final void handleMessage(Message message) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    this.A00.A0B(message);
                } catch (Throwable th) {
                    KL.A00(th, this);
                }
            }
        };
        this.A06 = new AE(AZ.A01, 0L, TrackGroupArray.A04, this.A0I);
        this.A0J = new ArrayDeque<>();
        this.A0E = new CN(xzArr, h1, this.A0I, a9, this.A0A, this.A03, this.A0B, this.A0C, this, interfaceC1665Hu);
        Looper eventLooper = this.A0E.A0x();
        this.A0D = new Handler(eventLooper);
    }

    private long A00(long j) {
        long jA01 = C14729o.A01(j);
        if (!this.A06.A04.A02()) {
            this.A06.A03.A0A(this.A06.A04.A02, this.A0F);
            return jA01 + this.A0F.A08();
        }
        return jA01;
    }

    private AE A01(boolean z, boolean z2, int i) {
        if (z) {
            this.A01 = 0;
            this.A00 = 0;
            this.A04 = 0L;
        } else {
            this.A01 = A63();
            this.A00 = A08();
            this.A04 = A60();
        }
        AE ae = new AE(z2 ? AZ.A01 : this.A06.A03, z2 ? null : this.A06.A07, this.A06.A04, this.A06.A02, this.A06.A01, i, false, z2 ? TrackGroupArray.A04 : this.A06.A05, z2 ? this.A0I : this.A06.A06);
        String[] strArr = A0N;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0N;
        strArr2[7] = "Xqr2ExcYOBi8j1Q";
        strArr2[7] = "Xqr2ExcYOBi8j1Q";
        return ae;
    }

    private void A05(AE ae, int i, boolean z, int timelineChangeReason) {
        int i2;
        AE aeA04 = ae;
        this.A02 -= i;
        if (this.A02 == 0) {
            if (aeA04.A02 == -9223372036854775807L) {
                aeA04 = aeA04.A04(aeA04.A04, 0L, aeA04.A01);
            }
            if (!this.A06.A03.A0F() || this.A08) {
                AZ az = aeA04.A03;
                String[] strArr = A0N;
                if (strArr[1].length() == strArr[3].length()) {
                    String[] strArr2 = A0N;
                    strArr2[7] = "oGDG41JiAsT7PCq0";
                    strArr2[7] = "oGDG41JiAsT7PCq0";
                    if (az.A0F()) {
                        this.A00 = 0;
                        this.A01 = 0;
                        String[] strArr3 = A0N;
                        if (strArr3[6].length() == strArr3[2].length()) {
                            String[] strArr4 = A0N;
                            strArr4[1] = "vrOcQin3pszluGLq";
                            strArr4[3] = "REI4M31lEJcbEC2a";
                            this.A04 = 0L;
                        }
                    }
                }
                throw new RuntimeException();
            }
            if (this.A08) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            boolean z2 = this.A09;
            this.A08 = false;
            this.A09 = false;
            A06(aeA04, z, timelineChangeReason, i2, z2, false);
        }
    }

    private void A06(final AE ae, final boolean z, final int i, final int i2, final boolean z2, final boolean z3) {
        boolean z4 = !this.A0J.isEmpty();
        ArrayDeque<C14829y> arrayDeque = this.A0J;
        final AE ae2 = this.A06;
        final CopyOnWriteArraySet<AI> copyOnWriteArraySet = this.A0K;
        final H1 h1 = this.A0H;
        final boolean z5 = this.A0A;
        arrayDeque.addLast((C14829y) new Object(ae, ae2, copyOnWriteArraySet, h1, z, i, i2, z2, z5, z3) { // from class: com.facebook.ads.redexgen.X.9y
            public static String[] A0C;
            public final int A00;
            public final int A01;
            public final AE A02;
            public final H1 A03;
            public final Set<AI> A04;
            public final boolean A05;
            public final boolean A06;
            public final boolean A07;
            public final boolean A08;
            public final boolean A09;
            public final boolean A0A;
            public final boolean A0B;

            static {
                A00();
            }

            public static void A00() {
                A0C = new String[]{"WV1wdoH9jrQVDigahBrbrXyjnekpmiiE", "mIVo7Cnr72P7RKesjBWLJYV7ajvYF70D", "pH5vi4Kbi5SdF2Ft8jCp0yyfmrwCNJ93", "VAiIhwzGtJV", "mutijWrtbdTsRUOKFhZTpXzdiINxdKbV", "iAqM", "YM6GPYhzTMlO14HNxrpVvdDRlTI", "SmN7PcN3RYN"};
            }

            {
                this.A02 = ae;
                this.A04 = copyOnWriteArraySet;
                this.A03 = h1;
                this.A08 = z;
                this.A00 = i;
                this.A01 = i2;
                this.A09 = z2;
                this.A06 = z5;
                this.A07 = z3 || ae2.A00 != ae.A00;
                this.A0A = (ae2.A03 == ae.A03 && ae2.A07 == ae.A07) ? false : true;
                this.A05 = ae2.A08 != ae.A08;
                this.A0B = ae2.A06 != ae.A06;
            }

            public final void A01() {
                if (this.A0A || this.A01 == 0) {
                    Iterator<AI> it = this.A04.iterator();
                    while (it.hasNext()) {
                        it.next().ABP(this.A02.A03, this.A02.A07, this.A01);
                    }
                }
                boolean z6 = this.A08;
                String[] strArr = A0C;
                if (strArr[1].charAt(12) == strArr[4].charAt(12)) {
                    String[] strArr2 = A0C;
                    strArr2[3] = "CSJCqnrxZvV";
                    strArr2[7] = "Hkj5q7ot6VH";
                    if (z6) {
                        Iterator<AI> it2 = this.A04.iterator();
                        while (true) {
                            boolean zHasNext = it2.hasNext();
                            String[] strArr3 = A0C;
                            if (strArr3[0].charAt(22) == strArr3[2].charAt(22)) {
                                String[] strArr4 = A0C;
                                strArr4[1] = "CqJcwx9zuxyuReRUn3Ztwbm9rESV0hnU";
                                strArr4[4] = "BsXcrNWYLVI0RgolRvCIuekTJNQNO1r0";
                                if (!zHasNext) {
                                    break;
                                } else {
                                    it2.next().AAs(this.A00);
                                }
                            } else if (!zHasNext) {
                                break;
                            } else {
                                it2.next().AAs(this.A00);
                            }
                        }
                    }
                    if (this.A0B) {
                        this.A03.A0W(this.A02.A06.A02);
                        Iterator<AI> it3 = this.A04.iterator();
                        while (it3.hasNext()) {
                            it3.next().ABQ(this.A02.A05, this.A02.A06.A01);
                        }
                    }
                    boolean z7 = this.A05;
                    String[] strArr5 = A0C;
                    if (strArr5[1].charAt(12) == strArr5[4].charAt(12)) {
                        String[] strArr6 = A0C;
                        strArr6[6] = "ZmCtUBpIkW4VOgBlZsMYRrBehzT";
                        strArr6[5] = "Qd2F";
                        if (z7) {
                            Iterator<AI> it4 = this.A04.iterator();
                            while (it4.hasNext()) {
                                it4.next().AAO(this.A02.A08);
                            }
                        }
                        if (this.A07) {
                            Iterator<AI> it5 = this.A04.iterator();
                            while (it5.hasNext()) {
                                it5.next().AAq(this.A06, this.A02.A00);
                            }
                        }
                        if (this.A09) {
                            for (AI listener : this.A04) {
                                listener.ABD();
                            }
                            return;
                        }
                        return;
                    }
                }
                throw new RuntimeException();
            }
        });
        this.A06 = ae;
        if (z4) {
            return;
        }
        while (!this.A0J.isEmpty()) {
            this.A0J.peekFirst().A01();
            this.A0J.removeFirst();
        }
    }

    private boolean A07() {
        return this.A06.A03.A0F() || this.A02 > 0;
    }

    public final int A08() {
        if (A07()) {
            return this.A00;
        }
        return this.A06.A04.A02;
    }

    public final void A09(int i) {
        A0A(i, -9223372036854775807L);
    }

    public final void A0A(int i, long j) {
        long jA00;
        AZ az = this.A06.A03;
        if (i >= 0) {
            boolean zA0F = az.A0F();
            if (A0N[5].length() == 22) {
                String[] strArr = A0N;
                strArr[6] = "k";
                strArr[2] = "F";
                if (zA0F || i < az.A02()) {
                    this.A09 = true;
                    this.A02++;
                    boolean zA0C = A0C();
                    if (A0N[7].length() != 1) {
                        String[] strArr2 = A0N;
                        strArr2[1] = "iOLxdGxzjtj8VTTv";
                        strArr2[3] = "k2rTYfByBhCiNj1b";
                        if (zA0C) {
                            String strA02 = A02(2, 13, 112);
                            String[] strArr3 = A0N;
                            if (strArr3[4].length() == strArr3[0].length()) {
                                String[] strArr4 = A0N;
                                strArr4[7] = "fs0FIhTd6T569fWM98lB5KOUS";
                                strArr4[7] = "fs0FIhTd6T569fWM98lB5KOUS";
                                Log.w(strA02, A02(50, 39, 10));
                                this.A0C.obtainMessage(0, 1, -1, this.A06).sendToTarget();
                                return;
                            }
                        } else {
                            this.A01 = i;
                            if (az.A0F()) {
                                if (A0N[7].length() == 1) {
                                    throw new RuntimeException();
                                }
                                String[] strArr5 = A0N;
                                strArr5[5] = "dOqGbPzaS7jKfyvdUFqkQf";
                                strArr5[5] = "dOqGbPzaS7jKfyvdUFqkQf";
                                this.A04 = j == -9223372036854775807L ? 0L : j;
                                this.A00 = 0;
                            } else {
                                if (j == -9223372036854775807L) {
                                    jA00 = az.A0C(i, this.A0G).A01();
                                } else {
                                    jA00 = C14729o.A00(j);
                                }
                                Pair<Integer, Long> pairA08 = az.A08(this.A0G, this.A0F, i, jA00);
                                this.A04 = C14729o.A01(jA00);
                                this.A00 = ((Integer) pairA08.first).intValue();
                            }
                            this.A0E.A0z(az, i, C14729o.A00(j));
                            for (AI ai : this.A0K) {
                                String[] strArr6 = A0N;
                                if (strArr6[4].length() != strArr6[0].length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr7 = A0N;
                                strArr7[1] = "l5NWk5x9vooO50uu";
                                strArr7[3] = "FcAzQ8glamB386Jq";
                                ai.AAs(1);
                            }
                            return;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        throw new A8(az, i, j);
    }

    public final void A0B(Message message) {
        int i = message.what;
        if (i == 0) {
            A05((AE) message.obj, message.arg1, message.arg2 != -1, message.arg2);
            return;
        }
        if (i != 1) {
            String[] strArr = A0N;
            if (strArr[4].length() == strArr[0].length()) {
                String[] strArr2 = A0N;
                strArr2[5] = "7KT5lT3IIkvardi0cOE285";
                strArr2[5] = "7KT5lT3IIkvardi0cOE285";
                if (i == 2) {
                    C14789u c14789u = (C14789u) message.obj;
                    this.A05 = c14789u;
                    Iterator<AI> it = this.A0K.iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        String[] strArr3 = A0N;
                        if (strArr3[4].length() != strArr3[0].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr4 = A0N;
                        strArr4[7] = "lr70Wm3MPuK1";
                        strArr4[7] = "lr70Wm3MPuK1";
                        if (zHasNext) {
                            it.next().AAo(c14789u);
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        } else {
            AF af = (AF) message.obj;
            if (!this.A07.equals(af)) {
                this.A07 = af;
                CopyOnWriteArraySet<AI> copyOnWriteArraySet = this.A0K;
                String[] strArr5 = A0N;
                if (strArr5[6].length() == strArr5[2].length()) {
                    String[] strArr6 = A0N;
                    strArr6[1] = "XPkhdR3hZ8JGZkbg";
                    strArr6[3] = "HitM1md97HqEAHyx";
                    Iterator<AI> it2 = copyOnWriteArraySet.iterator();
                    while (it2.hasNext()) {
                        it2.next().AAm(af);
                    }
                    return;
                }
            } else {
                return;
            }
        }
        throw new RuntimeException();
    }

    public final boolean A0C() {
        return !A07() && this.A06.A04.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void A3H(AI ai) {
        this.A0K.add(ai);
    }

    @Override // com.facebook.ads.redexgen.X.XX
    public final AQ A4K(AP ap) {
        return new AQ(this.A0E, ap, this.A06.A03, A63(), this.A0D);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A5d() {
        long jA5e = A5e();
        long jA6B = A6B();
        if (jA5e != -9223372036854775807L) {
            String[] strArr = A0N;
            if (strArr[6].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[6] = VipSubscribeStatus.SUBSCRIPTION_RESTARTED;
            strArr2[2] = "n";
            if (jA6B != -9223372036854775807L) {
                String[] strArr3 = A0N;
                if (strArr3[4].length() != strArr3[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0N;
                strArr4[6] = "w";
                strArr4[2] = "D";
                if (jA6B == 0) {
                    return 100;
                }
                return IW.A06((int) ((100 * jA5e) / jA6B), 0, 100);
            }
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A5e() {
        if (A07()) {
            return this.A04;
        }
        return A00(this.A06.A09);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A5v() {
        if (A0C()) {
            this.A06.A03.A0A(this.A06.A04.A02, this.A0F);
            return this.A0F.A08() + C14729o.A01(this.A06.A01);
        }
        return A60();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A5x() {
        if (A0C()) {
            return this.A06.A04.A00;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A5y() {
        if (A0C()) {
            return this.A06.A04.A01;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A60() {
        if (A07()) {
            return this.A04;
        }
        return A00(this.A06.A0A);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final AZ A62() {
        return this.A06.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A63() {
        if (A07()) {
            return this.A01;
        }
        return this.A06.A03.A0A(this.A06.A04.A02, this.A0F).A00;
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A6B() {
        AZ az = this.A06.A03;
        if (az.A0F()) {
            return -9223372036854775807L;
        }
        if (A0C()) {
            F6 f6 = this.A06.A04;
            az.A0A(f6.A02, this.A0F);
            return C14729o.A01(this.A0F.A0A(f6.A00, f6.A01));
        }
        return az.A0C(A63(), this.A0G).A02();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final boolean A6r() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.XX
    public final void AC2(F8 f8, boolean z, boolean z2) {
        this.A05 = null;
        AE aeA01 = A01(z, z2, 2);
        this.A08 = true;
        this.A02++;
        this.A0E.A10(f8, z, z2);
        A06(aeA01, false, 4, 1, false, false);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void ACW() {
        StringBuilder sb = new StringBuilder();
        sb.append(A02(38, 8, 2));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(A02(0, 2, 7));
        sb.append(A02(15, 18, 78));
        String strA02 = A02(47, 3, 94);
        sb.append(strA02);
        sb.append(IW.A04);
        sb.append(strA02);
        sb.append(A4.A00());
        sb.append(A02(46, 1, 86));
        Log.i(A02(2, 13, 112), sb.toString());
        this.A0E.A0y();
        this.A0C.removeCallbacksAndMessages(null);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void AD4(long j) {
        A0A(A63(), j);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void AD5() {
        A09(A63());
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void ADL(boolean z) {
        if (this.A0A != z) {
            this.A0A = z;
            this.A0E.A11(z);
            A06(this.A06, false, 4, 1, false, true);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void ADi(boolean z) {
        if (z) {
            this.A05 = null;
        }
        AE aeA01 = A01(z, z, 1);
        this.A02++;
        this.A0E.A12(z);
        A06(aeA01, false, 4, 1, false, false);
    }
}
