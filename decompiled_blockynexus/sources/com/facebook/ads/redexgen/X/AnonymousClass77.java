package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.77, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass77 {
    public static AnonymousClass00 A0A;
    public static byte[] A0B;
    public static String[] A0C;
    public static final String A0D;
    public static final Map<String, AnonymousClass06> A0E;
    public long A00;
    public JC A01;
    public final AnonymousClass78 A03;
    public final AnonymousClass87 A04;
    public final boolean A08;
    public final boolean A09;
    public final Map<String, Bitmap> A07 = Collections.synchronizedMap(new HashMap());
    public final Handler A02 = new Handler(Looper.getMainLooper());
    public final List<Callable<Boolean>> A05 = new ArrayList();
    public final List<Callable<Boolean>> A06 = new ArrayList();

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0B = new byte[]{-67, -62, -68, -17, -62, -19, -67, -65, 127, 123, -128, -128, 127, -82, -84, -82, 121, -105, -103, -98, -101, 86, -87, -86, -105, -88, -86, -101, -102, 100, 96, 126, -128, -123, -122, -117, -124, 61, -128, -116, -118, -115, -119, -126, -111, -126, -119, -89, -87, -82, -81, -76, -83, 102, -84, -89, -81, -78, -85, -86, -113, -83, -81, -76, -75, -70, -77, 108, -65, -64, -83, -66, -64, -79, -80, 122, 122, 122, -127, -76, -97, -95, -84, -80, -91, -85, -86, 92, -77, -92, -91, -88, -95, 92, -95, -76, -95, -97, -79, -80, -91, -86, -93, 92, -97, -99, -97, -92, -95, 92, -96, -85, -77, -86, -88, -85, -99, -96, -81, 106, -125, -126, -124, 86, -123, -126, 88, -86, -88, -86, -81, -84, -118, -74, -76, -73, -77, -84, -69, -80, -74, -75, -113, -74, -74, -78, -79, -81, -79, -74, -77, -108, -81, -73, -70, -61, -64, -77, -106, -67, -67, -71, 122, -115, 122, 120, -118, -119, 122, -113, -110, -124, -121, -24, -21, -35, -32, -37, -16, -27, -23, -31, -37, -23, -17, -20, -31, -24, -16};
    }

    public static void A0E() {
        A0C = new String[]{"8gkZjHnxCvZyg7TzwjjGeSdvls9L7Gam", "fcbSC3ja3K2jNylkxCBC51G6bXitMdQ0", "2foOCT", "ocB0m3", "KfMQJM794wt5IuG", "feDb68pnVWWOEqV45c", "KnEa0S3Tnigt4irEXno07XBXpnYxFsFq", "aK1UKkDbG3zR1xh0x3umKxUvmkPLseuR"};
    }

    static {
        A0E();
        A0D();
        A0D = AnonymousClass77.class.getSimpleName();
        A0E = Collections.synchronizedMap(new HashMap());
    }

    public AnonymousClass77(AnonymousClass87 anonymousClass87) {
        this.A04 = anonymousClass87;
        this.A03 = AnonymousClass78.A06(anonymousClass87.A00());
        this.A08 = C1693Iy.A1c(anonymousClass87);
        this.A09 = PO.A04() && C1693Iy.A1f(anonymousClass87);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.07] */
    public static synchronized AnonymousClass00 A03(C2027Wc c2027Wc) {
        if (A0A == null) {
            A0A = AnonymousClass01.A00(c2027Wc, new Object() { // from class: com.facebook.ads.redexgen.X.07
                public int A00;
                public int A01;
                public boolean A02;
                public boolean A03;
                public boolean A04;

                public final AnonymousClass07 A00(int i) {
                    this.A00 = i;
                    return this;
                }

                public final AnonymousClass07 A01(int i) {
                    this.A01 = i;
                    return this;
                }

                public final AnonymousClass07 A02(boolean z) {
                    this.A02 = z;
                    return this;
                }

                public final AnonymousClass07 A03(boolean z) {
                    this.A03 = z;
                    return this;
                }

                public final AnonymousClass07 A04(boolean z) {
                    this.A04 = z;
                    return this;
                }

                public final AnonymousClass08 A05() {
                    return new AnonymousClass08(this.A00, this.A02, this.A01, this.A03, this.A04);
                }
            }.A00(C1693Iy.A04(c2027Wc)).A02(c2027Wc.A03().A7l()).A01(-1).A03(C1693Iy.A0h(c2027Wc)).A04(C1693Iy.A1j(c2027Wc)).A05(), A05(c2027Wc));
        }
        return A0A;
    }

    public static AnonymousClass06 A04(AnonymousClass87 anonymousClass87, String str) {
        AnonymousClass06 anonymousClass06 = A0E.get(str);
        if (C7A.A06(anonymousClass87) && anonymousClass06 != null) {
            return new AnonymousClass06(anonymousClass06);
        }
        return new AnonymousClass06(str);
    }

    public static C0L A05(C2027Wc c2027Wc) {
        return new WY(c2027Wc);
    }

    public static AtomicBoolean A0B(ArrayList<Callable<Boolean>> arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator<Callable<Boolean>> it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A0C;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[5] = "";
            strArr2[5] = "";
            if (zHasNext) {
                arrayList2.add(ExecutorC1744Lc.A02().submit(it.next()));
            } else {
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        atomicBoolean.set(atomicBoolean.get() && ((Boolean) ((Future) it2.next()).get()).booleanValue());
                    }
                } catch (InterruptedException | ExecutionException e2) {
                    Log.e(A0D, A08(78, 42, 50), e2);
                    atomicBoolean.set(false);
                }
                return atomicBoolean;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(JB jb) {
        if (this.A01 == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(A08(173, 12, 114), LP.A04(this.A00));
        this.A01.A03(jb, map);
    }

    @Nullable
    public final Bitmap A0I(String str) {
        return this.A07.get(str);
    }

    @Nullable
    public final Bitmap A0J(String str, int i, int i2) {
        if (this.A08) {
            AnonymousClass06 anonymousClass06A04 = A04(this.A04, str);
            anonymousClass06A04.A03 = A08(185, 4, 111);
            anonymousClass06A04.A01 = i2;
            anonymousClass06A04.A00 = i;
            return A03(this.A04.A00()).ACq(anonymousClass06A04, true).A00();
        }
        return this.A03.A0E(this.A04, str, i, i2, A08(169, 4, 25));
    }

    public final String A0K(String str) {
        if (this.A08) {
            return A0L(str);
        }
        return this.A03.A0F(str);
    }

    public final String A0L(String cachedUrl) {
        AnonymousClass06 anonymousClass06A04 = A04(this.A04, cachedUrl);
        anonymousClass06A04.A03 = A08(185, 4, 111);
        String strACs = A03(this.A04.A00()).ACs(anonymousClass06A04);
        return strACs != null ? strACs : cachedUrl;
    }

    public final String A0M(String str) {
        if (this.A09) {
            return str;
        }
        return A0L(str);
    }

    public final void A0N() {
        C1710Jr.A05(A08(127, 19, 61), A08(30, 16, 19), A08(8, 8, 64));
    }

    public final void A0O() {
        C1710Jr.A05(A08(146, 16, 68), A08(46, 14, 60), A08(120, 7, 23));
    }

    public final void A0P() {
        this.A07.clear();
    }

    public final void A0Q(@Nullable InterfaceC14166z interfaceC14166z, AnonymousClass70 anonymousClass70) {
        C1710Jr.A05(A08(162, 7, 11), A08(60, 18, 66), A08(0, 8, 127));
        this.A00 = System.currentTimeMillis();
        C7A.A02(this.A04, anonymousClass70, C7A.A07, A08(16, 14, 44), -1L);
        ExecutorC1744Lc.A03().execute(new WX(this, new ArrayList(this.A05), interfaceC14166z, anonymousClass70, new ArrayList(this.A06)));
        this.A05.clear();
        this.A06.clear();
    }

    public final void A0R(final AnonymousClass74 anonymousClass74) {
        Callable<Boolean> callable = new Callable<Boolean>(anonymousClass74) { // from class: com.facebook.ads.redexgen.X.75
            public static byte[] A02;
            public static String[] A03;
            public final AnonymousClass74 A00;

            static {
                A03();
                A02();
            }

            public static String A01(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                int i4 = 0;
                while (true) {
                    int length = bArrCopyOfRange.length;
                    if (A03[1].length() == 32) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A03;
                    strArr[3] = "";
                    strArr[3] = "";
                    if (i4 >= length) {
                        return new String(bArrCopyOfRange);
                    }
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 48);
                    i4++;
                }
            }

            public static void A02() {
                A02 = new byte[]{-20, -16, -28, -22, -24};
            }

            public static void A03() {
                A03 = new String[]{"jwTNBF52XqMGgcVEiQTwvXvSBsl43Bcu", "zl9XISU", "9LwyCiCzMXmNgkxTRjX8XUqiNT4UlidW", "Jar4Zz8ck96tLH67JFbLbWmYESMeU49V", "Yd8bjyjazIom6Oxe2tnjIAJyfdSlHwWG", "VgUZ5KaBAYbzt3oMIew8EQ4BA2c", "hXTgBapwd4emagenALPcDOSBW5zmdf3H", "17k"};
            }

            {
                this.A00 = anonymousClass74;
            }

            private final Boolean A00() throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    TrafficStats.setThreadStatsTag(61453);
                    AnonymousClass06 anonymousClass06 = new AnonymousClass06(this.A00.A07, this.A00.A06, this.A00.A05, A01(0, 5, 83), this.A00.A01, this.A00.A02);
                    anonymousClass06.A01 = this.A00.A04;
                    anonymousClass06.A00 = this.A00.A03;
                    if (C7A.A06(this.A01.A04)) {
                        AnonymousClass77.A0E.put(this.A00.A07, anonymousClass06);
                    }
                    boolean z = this.A01.A08;
                    boolean zA01 = false;
                    if (A03[3].length() != 5) {
                        String[] strArr = A03;
                        strArr[4] = "CZcPy1KhLDdCOlGcBT5xxsnRB32IUDMD";
                        strArr[4] = "CZcPy1KhLDdCOlGcBT5xxsnRB32IUDMD";
                        if (z) {
                            zA01 = AnonymousClass77.A03(this.A01.A04.A00()).ACq(anonymousClass06, false).A01();
                        } else if (this.A01.A03.A0D(this.A00) != null) {
                            zA01 = true;
                        }
                        C7C c7c = this.A00.A00;
                        if (c7c != null && c7c.A02()) {
                            int iA00 = c7c.A00();
                            int iA01 = c7c.A01();
                            if (iA00 <= 0 || iA01 <= 0) {
                                if (this.A01.A08) {
                                    A05(this.A00.A07, anonymousClass06);
                                } else {
                                    int i = this.A00.A03;
                                    int width = this.A00.A04;
                                    A04(i, width);
                                }
                            } else if (this.A01.A08) {
                                anonymousClass06.A00 = iA00;
                                anonymousClass06.A01 = iA01;
                                A05(this.A00.A07, anonymousClass06);
                            } else {
                                A04(iA00, iA01);
                            }
                        }
                        return Boolean.valueOf(zA01);
                    }
                    throw new RuntimeException();
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }

            private void A04(int i, int i2) {
                Bitmap bitmapA0E = this.A01.A03.A0E(this.A01.A04, this.A00.A07, i, i2, this.A00.A01);
                if (bitmapA0E == null) {
                    return;
                }
                this.A01.A07.put(this.A00.A07, bitmapA0E);
            }

            private void A05(String str, AnonymousClass06 anonymousClass06) {
                Bitmap bitmapA00 = AnonymousClass77.A03(this.A01.A04.A00()).ACq(anonymousClass06, true).A00();
                if (bitmapA00 == null) {
                    return;
                }
                this.A01.A07.put(str, bitmapA00);
            }

            @Override // java.util.concurrent.Callable
            public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    return A00();
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }
        };
        if (!anonymousClass74.A02) {
            this.A05.add(callable);
        } else {
            this.A06.add(callable);
        }
    }

    public final void A0S(AnonymousClass74 anonymousClass74) {
        anonymousClass74.A02 = true;
        A0R(anonymousClass74);
    }

    public final void A0T(AnonymousClass76 anonymousClass76) {
        this.A05.add(new AnonymousClass73(this, anonymousClass76));
    }

    public final void A0U(AnonymousClass76 anonymousClass76) {
        anonymousClass76.A05 = true;
        this.A06.add(new AnonymousClass73(this, anonymousClass76));
    }

    public final void A0V(AnonymousClass76 anonymousClass76) {
        anonymousClass76.A05 = true;
        if (this.A09) {
            this.A06.add(new AnonymousClass72(this, anonymousClass76));
        } else {
            this.A06.add(new AnonymousClass73(this, anonymousClass76));
        }
    }

    public final void A0W(AnonymousClass76 anonymousClass76) {
        if (this.A09) {
            this.A05.add(new AnonymousClass72(this, anonymousClass76));
        } else {
            this.A05.add(new AnonymousClass73(this, anonymousClass76));
        }
    }

    public final void A0X(JC jc) {
        this.A01 = jc;
    }

    public final boolean A0Y(String str) {
        return A0L(str) != null;
    }
}
