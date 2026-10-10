package com.facebook.ads.redexgen.X;

import com.facebook.ads.redexgen.X.AbstractC2068Xr;
import com.facebook.ads.redexgen.X.C2067Xq;
import java.lang.Exception;
import java.util.ArrayDeque;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2069Xs<I extends C2067Xq, O extends AbstractC2068Xr, E extends Exception> implements BT<I, O, E> {
    public static String[] A0D;
    public int A00;
    public int A01;
    public int A02;
    public I A03;
    public E A04;
    public boolean A05;
    public boolean A06;
    public final Thread A08;
    public final I[] A0B;
    public final O[] A0C;
    public final Object A07 = new Object();
    public final ArrayDeque<I> A09 = new ArrayDeque<>();
    public final ArrayDeque<O> A0A = new ArrayDeque<>();

    static {
        A0O();
    }

    public static void A0O() {
        A0D = new String[]{"Gkl", "qMMBfBKIWMYZs", "JMr5TMdVlQ7lAxQbe7gmsO3TMTXZHZrx", "k", "fplFQmQDWPfBEKatf3t9LdZAMaYE90Yr", "qk38PGrA", "BZh", "ypodQLxrY5Mqx0yNqiahJYpo"};
    }

    public abstract I A0V();

    public abstract O A0X();

    public abstract E A0Y(I i, O o, boolean z);

    public abstract E A0Z(Throwable th);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    public AbstractC2069Xs(I[] iArr, O[] oArr) {
        this.A0B = iArr;
        this.A00 = iArr.length;
        for (int i = 0; i < this.A00; i++) {
            ((I[]) this.A0B)[i] = A0V();
        }
        this.A0C = oArr;
        this.A01 = oArr.length;
        for (int i2 = 0; i2 < this.A01; i2++) {
            ((O[]) this.A0C)[i2] = A0X();
        }
        this.A08 = new BW(this);
        this.A08.start();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    private void A0L() {
        if (A0S()) {
            this.A07.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    private void A0M() throws Exception {
        E e2 = this.A04;
        if (e2 == null) {
        } else {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    public void A0N() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (A0T());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    private void A0P(I i) {
        i.A07();
        I[] iArr = this.A0B;
        int i2 = this.A00;
        this.A00 = i2 + 1;
        iArr[i2] = i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    private void A0Q(O o) {
        o.A07();
        O[] oArr = this.A0C;
        int i = this.A01;
        this.A01 = i + 1;
        oArr[i] = o;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    private boolean A0S() {
        return !this.A09.isEmpty() && this.A01 > 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    private boolean A0T() throws InterruptedException {
        synchronized (this.A07) {
            while (!this.A06 && !A0S()) {
                this.A07.wait();
            }
            if (this.A06) {
                return false;
            }
            I iRemoveFirst = this.A09.removeFirst();
            O[] oArr = this.A0C;
            int i = this.A01 - 1;
            this.A01 = i;
            O o = oArr[i];
            boolean z = this.A05;
            this.A05 = false;
            if (iRemoveFirst.A04()) {
                o.A00(4);
            } else {
                if (iRemoveFirst.A03()) {
                    o.A00(Integer.MIN_VALUE);
                }
                try {
                    this.A04 = (E) A0Y(iRemoveFirst, o, z);
                } catch (OutOfMemoryError e2) {
                    this.A04 = (E) A0Z(e2);
                } catch (RuntimeException e3) {
                    String[] strArr = A0D;
                    if (strArr[1].length() != strArr[7].length()) {
                        String[] strArr2 = A0D;
                        strArr2[1] = "JmdauonVcnINF";
                        strArr2[7] = "vppaV7cv17cCxaH2hgZaXUeE";
                        this.A04 = (E) A0Z(e3);
                    }
                    throw new RuntimeException();
                }
                if (this.A04 != null) {
                    synchronized (this.A07) {
                    }
                    return false;
                }
            }
            Object obj = this.A07;
            String[] strArr3 = A0D;
            if (strArr3[0].length() == strArr3[6].length()) {
                String[] strArr4 = A0D;
                strArr4[1] = "q0ZgAWd6JYMJo";
                strArr4[7] = "B3H8IuJfVBRbzuvGv4HpnNYI";
                synchronized (obj) {
                    if (this.A05) {
                        A0Q(o);
                    } else if (o.A03()) {
                        this.A02++;
                        A0Q(o);
                    } else {
                        o.A00 = this.A02;
                        this.A02 = 0;
                        this.A0A.addLast(o);
                    }
                    A0P(iRemoveFirst);
                }
                return true;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.BT
    /* JADX INFO: renamed from: A0U, reason: merged with bridge method [inline-methods] */
    public final I A4h() throws Exception {
        I i;
        I i2;
        synchronized (this.A07) {
            A0M();
            C1662Hr.A04(this.A03 == null);
            if (this.A00 == 0) {
                i = null;
            } else {
                I[] iArr = this.A0B;
                int i3 = this.A00 - 1;
                this.A00 = i3;
                i = iArr[i3];
            }
            this.A03 = i;
            i2 = this.A03;
        }
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.BT
    /* JADX INFO: renamed from: A0W, reason: merged with bridge method [inline-methods] */
    public final O A4i() throws Exception {
        synchronized (this.A07) {
            A0M();
            if (this.A0A.isEmpty()) {
                return null;
            }
            return this.A0A.removeFirst();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    public final void A0a(int i) {
        C1662Hr.A04(this.A00 == this.A0B.length);
        for (I inputBuffer : this.A0B) {
            inputBuffer.A09(i);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.BT
    /* JADX INFO: renamed from: A0b, reason: merged with bridge method [inline-methods] */
    public final void ACF(I i) throws Exception {
        synchronized (this.A07) {
            A0M();
            I inputBuffer = this.A03;
            C1662Hr.A03(i == inputBuffer);
            this.A09.addLast(i);
            A0L();
            this.A03 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    public void A0c(O o) {
        synchronized (this.A07) {
            A0Q(o);
            A0L();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.BT
    public final void ACW() {
        synchronized (this.A07) {
            this.A06 = true;
            this.A07.notify();
        }
        try {
            this.A08.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xs != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.Xq, O extends com.facebook.ads.redexgen.X.Xr, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.BT
    public final void flush() {
        synchronized (this.A07) {
            this.A05 = true;
            this.A02 = 0;
            if (this.A03 != null) {
                A0P(this.A03);
                this.A03 = null;
            }
            while (!this.A09.isEmpty()) {
                A0P(this.A09.removeFirst());
            }
            while (!this.A0A.isEmpty()) {
                A0Q(this.A0A.removeFirst());
            }
        }
    }
}
