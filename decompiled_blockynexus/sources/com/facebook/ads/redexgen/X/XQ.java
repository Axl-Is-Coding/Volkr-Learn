package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XQ<T> implements C9P<T> {
    public static byte[] A06;
    public static String[] A07;
    public C9H A00;
    public C9H A01;
    public List<XQ<T>.RecordFileBasedFetch> A02 = new ArrayList();
    public boolean A03;
    public final C9G A04;
    public final C9W A05;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{-28, 2, ci.m, -63, ci.n, ci.m, ci.k, 26, -63, 5, 6, ci.k, 6, 21, 6, -63, 4, 22, 19, 20, ci.n, 19, 20, -63, 17, ci.n, 10, ci.m, 21, 10, ci.m, 8, -63, 2, 21, -63, 21, 9, 6, -63, 5, 2, 21, 2, 3, 2, 20, 6, -63, 20, 21, 2, 19, 21, -38, 12, 9, 10, 6, 9, -73, 7, 6, 10, 0, 11, 0, 6, 5, -73, 0, 10, -73, -8, 11, -73, -65, -68, -5, -61, -68, -5, -64, -61, -73, -8, 5, -5, -73, 9, -4, -6, 6, 9, -5, -73, -3, 0, 3, -4, -73, 10, -4, 8, 12, -4, 5, -6, -4, -73, 10, 11, -8, 9, 11, 10, -73, -8, 11, -73, -65, -68, -5, -61, -68, -5, -64, -47, -73, -5, -8, 11, -8, -73, -1, -8, 10, -73, 7, 9, 6, -7, -8, -7, 3, ci.n, -73, -7, -4, -4, 5, -73, 3, 6, 10, 11, -78, -28, -31, -30, -34, -31, -113, -33, -34, -30, -40, -29, -40, -34, -35, -113, -40, -30, -113, -48, -29, -113, -105, -108, -45, -101, -108, -45, -104, -101, -113, -47, -28, -29, -113, -31, -44, -46, -34, -31, -45, -113, -43, -40, -37, -44, -113, -30, -44, -32, -28, -44, -35, -46, -44, -113, -34, -35, -37, -24, -113, -41, -48, -30, -113, -43, -40, -37, -44, -113, -108, -45, -87, -113, -45, -48, -29, -48, -113, -41, -48, -30, -113, -33, -31, -34, -47, -48, -47, -37, -24, -113, -47, -44, -44, -35, -113, -37, -34, -30, -29, -27, 0, 8, 11, 4, 3, -65, 19, ci.l, -65, 0, 3, 3, -65, 3, 0, 19, 0, -65, 19, ci.l, -65, 11, ci.l, 6, -72, -45, -37, -34, -41, -42, -110, -26, -31, -110, -43, -34, -41, -45, -28, -110, -42, -45, -26, -45, -44, -45, -27, -41, -9, 18, 26, 29, 22, 21, -47, 37, 32, -47, 23, 22, 37, 20, 25, -47, 21, 18, 37, 18, -47, 23, 35, 32, 30, -47, 29, 32, 24, 34, 61, 69, 72, 65, 64, -4, 80, 75, -4, 67, 65, 80, -4, 78, 65, Utf8.REPLACEMENT_BYTE, 75, 78, 64, -4, Utf8.REPLACEMENT_BYTE, 75, 81, 74, 80, 5, 32, 40, 43, 36, 35, -33, 51, 46, -33, 52, 47, 35, 32, 51, 36, -33, 37, 40, 43, 36, -33, 50, 36, 48, 52, 36, 45, 34, 36, 43, 62, 60, 72, 75, 61, 31, 66, 69, 62, 27, 58, 76, 62, 61, 43, 62, 60, 72, 75, 61, 29, 58, 77, 58, 59, 58, 76, 62, -7, 60, 69, 72, 76, 62, 61, -8, 11, 9, 21, 24, 10, -20, ci.m, 18, 11, -24, 7, 25, 11, 10, -8, 11, 9, 21, 24, 10, -22, 7, 26, 7, 8, 7, 25, 11, -58, ci.m, 25, -58, 9, 18, 21, 25, 11, 10, -24, 1, -2, 1, 2, 10, 1, -77, -27, -8, -10, 2, 5, -9, -39, -4, -1, -8, -43, -12, 6, -8, -9, -27, -8, -10, 2, 5, -9, -41, -12, 7, -12, -11, -12, 6, -8, -77, -7, -8, 7, -10, -5, 11, 29, 26, 27, 23, 26, 5, 2, 21, 2};
    }

    public static void A02() {
        A07 = new String[]{"qjHjxJEnKto6KXykxGUV", "2zWwgsdc0YI2n1wuHJ0aHIsPzdmfxqsH", "nH8zlfZwPcU2YCM90OUKaCidDMv0PXY6", "9v530zo2HQQRKyJKvzn5HrUNTPRL7Myp", "K3vwlAe6bCWVMYHegp9FYHqzcyyslUPY", "TkUFKGPVf3MACXJSEel58pLd1ZQWiXgG", "k6Fq1", "q4H6OwDTyeTkPN5vSxQjqxUvCkQfNX6D"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    public XQ(C9M c9m, C9U c9u) throws IOException {
        this.A05 = new C9W(c9m.A04(A00(515, 4, 63)), c9u);
        this.A04 = new C9G(new File(c9m.A05(), A00(509, 6, 70)));
        this.A00 = this.A04.A04();
        A06(c9u);
        this.A01 = this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    private void A03(int i, int i2) throws IOException {
        this.A00 = new C9H(i, i2);
        this.A04.A05(this.A00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XP != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T>$RecordFileBasedFetch */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    /* JADX WARN: Incorrect inner types in method signature: (Lcom/facebook/ads/redexgen/X/XQ<TT;>.RecordFileBasedFetch;)V */
    public synchronized void A04(XP xp) throws C9Y {
        if (!this.A03) {
            if (A07(xp)) {
                if (xp.A5C() == 0) {
                    return;
                }
                if (this.A00.A05(xp.A00().A02) == 0) {
                    try {
                        Iterator<C9T> it = xp.A00.iterator();
                        while (it.hasNext()) {
                            if (it.next().A00 == this.A05.A08() && this.A05.A0E()) {
                                A03(this.A05.A07(), 0);
                            } else {
                                A03(this.A05.A07(), xp.A00().A00);
                                break;
                            }
                        }
                        if (this.A01.A05(this.A00) < 0) {
                            this.A01 = this.A00;
                        }
                        return;
                    } catch (IOException e2) {
                        throw new C9Y(A00(361, 30, 93), e2);
                    }
                }
                throw new C9Y(A00(0, 54, 63));
            }
            throw new C9Y(A00(466, 43, 49));
        }
        throw new C9Y(A00(427, 39, 68));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    private void A06(C9U c9u) throws IOException {
        C9H c9h = new C9H(this.A05.A07(), 0);
        if (c9h.A05(this.A00) > 0) {
            c9u.ACo(String.format(Locale.US, A00(54, 102, 53), Integer.valueOf(this.A00.A03()), Integer.valueOf(this.A00.A04()), Integer.valueOf(c9h.A03()), Integer.valueOf(c9h.A04())));
            this.A00 = c9h;
            return;
        }
        while (c9h.A03() < this.A00.A03()) {
            if (this.A05.A0E()) {
                c9h = new C9H(this.A05.A07(), 0);
            } else {
                c9u.ACo(String.format(Locale.US, A00(156, 101, 13), Integer.valueOf(this.A00.A03()), Integer.valueOf(this.A00.A04()), Integer.valueOf(c9h.A03())));
                this.A00 = new C9H(this.A05.A07(), this.A05.A08());
                this.A04.A05(this.A00);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XP != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T>$RecordFileBasedFetch */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    /* JADX WARN: Incorrect inner types in method signature: (Lcom/facebook/ads/redexgen/X/XQ<TT;>.RecordFileBasedFetch;)Z */
    public synchronized boolean A07(XP xp) {
        if (!this.A02.remove(xp)) {
            return false;
        }
        if (xp.A5C() > 0 && xp.A01().A02.A06(xp.A01().A01).equals(this.A01)) {
            this.A01 = xp.A00().A02;
        }
        if (A07[6].length() == 28) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "RJmBk8mp9ukvkOiT1GdeN9JCmreSI8hk";
        strArr[6] = "RJmBk8mp9ukvkOiT1GdeN9JCmreSI8hk";
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XP != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T>$RecordFileBasedFetch */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    @Override // com.facebook.ads.redexgen.X.C9P
    public final synchronized C9O A5B(byte[] bArr, int[] iArr) throws C9Y {
        XQ<T>.RecordFileBasedFetch xp;
        if (!this.A03) {
            int iA02 = 0;
            int i = 0;
            try {
                ArrayList arrayList = new ArrayList();
                boolean z = true;
                while (true) {
                    C9K c9kA0B = this.A05.A0B(this.A01.A03(), this.A01.A04(), bArr, iA02, iArr, i);
                    int iA00 = c9kA0B.A01().A00() - c9kA0B.A01().A01();
                    iA02 += c9kA0B.A01().A02();
                    i += iA00;
                    if (c9kA0B.A01().A03() == C9I.A02) {
                        arrayList.add(c9kA0B);
                    }
                    if (c9kA0B.A01().A03() == C9I.A03) {
                        break;
                    }
                    if (c9kA0B.A01().A03() == C9I.A04) {
                        if (this.A05.A07() + this.A05.A09() == this.A01.A03() + 1) {
                            z = false;
                            break;
                        }
                        this.A01 = new C9H(this.A01.A03() + 1, 0);
                    } else {
                        this.A01 = this.A01.A06(iA00);
                    }
                }
                xp = new XP(this, arrayList, z);
                this.A02.add(xp);
                if (!arrayList.isEmpty()) {
                    this.A01 = xp.A01().A02.A06(xp.A01().A01);
                }
            } catch (IOException e2) {
                throw new C9Y(A00(306, 29, 79), e2);
            }
        } else {
            throw new C9Y(A00(391, 36, 119));
        }
        return xp;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    @Override // com.facebook.ads.redexgen.X.C9P
    public final synchronized int A6w() throws C9Y {
        int iA0A;
        if (!this.A03) {
            try {
                iA0A = this.A05.A0A();
                if (this.A00.A03() == this.A05.A07()) {
                    iA0A -= this.A00.A04();
                }
            } catch (IOException e2) {
                throw new C9Y(A00(335, 26, 122), e2);
            }
        } else {
            throw new C9Y(A00(427, 39, 68));
        }
        return iA0A;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    @Override // com.facebook.ads.redexgen.X.C9P
    public final synchronized void ADj(byte[] bArr) throws C9Y {
        if (!this.A03) {
            try {
                this.A05.A0D(bArr);
            } catch (IOException e2) {
                throw new C9Y(A00(257, 25, 61), e2);
            }
        } else {
            throw new C9Y(A00(427, 39, 68));
        }
        String[] strArr = A07;
        if (strArr[5].charAt(29) != strArr[7].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "aLWzj";
        strArr2[6] = "aLWzj";
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    @Override // com.facebook.ads.redexgen.X.C9P
    public final synchronized void clear() throws C9Y {
        try {
            this.A05.A0C();
            A03(this.A05.A07(), 0);
            this.A02.clear();
        } catch (IOException e2) {
            throw new C9Y(A00(282, 24, 16), e2);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.XQ != com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T> */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.A03) {
            return;
        }
        this.A03 = true;
        this.A02.clear();
        this.A04.close();
        this.A05.close();
    }
}
