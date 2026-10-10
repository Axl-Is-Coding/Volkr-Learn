package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13444e {
    public static byte[] A02;
    public static String[] A03;

    @VisibleForTesting
    public final S6<C4W, C13424c> A00 = new S6<>();

    @VisibleForTesting
    public final C2I<C4W> A01 = new C2I<>();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-99, -59, -61, -60, 112, -64, -62, -65, -58, -71, -76, -75, 112, -74, -68, -79, -73, 112, -96, -94, -107, 112, -65, -62, 112, -96, -97, -93, -92};
    }

    public static void A03() {
        A03 = new String[]{"WXpxlTya5H7kpLIT7UUfzIgXOYds4Vfk", "JVDNa5tAOP", "C1CZfaM4quGDjTOWU4x6KBGTC5pPu33J", "VymAVHyd", "K8p7KG0zsDoAf7GmBTiUCUpdPzk9iS4o", "MydLOSuorekD0WEADrXIrTB2aFx1Ufvf", "1zIVUT6Fxq52O6VZbnoN9TsXnO1jN3fj", "z9Q03TMU5lxkReREt3I6AE4mCa6N3G46"};
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r5 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r3.A00 &= r9 ^ (-1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        if (r9 != 4) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        r5 = r3.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        r6 = r3.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        if (com.facebook.ads.redexgen.X.C13444e.A03[5].charAt(20) == 'R') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
    
        r2 = com.facebook.ads.redexgen.X.C13444e.A03;
        r2[0] = "LDlhycQGZBtlD6IMRSONBH11SqKxQWfy";
        r2[6] = "DCgYh9gvbnrpKHe96mnmPCff01xTtOfJ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
    
        if ((r6 & 12) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        r7.A00.A0B(r4);
        com.facebook.ads.redexgen.X.C13424c.A02(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
    
        r2 = com.facebook.ads.redexgen.X.C13444e.A03;
        r2[7] = "9mfdPnfY5V3FVy8Q2gQ6uDsmmOIXndsz";
        r2[2] = "ekMjHGebRREBiMI4gT56rHDvbCCByAvd";
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        if ((r6 & 12) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        r2 = com.facebook.ads.redexgen.X.C13444e.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
    
        if (r2[7].charAt(19) == r2[2].charAt(19)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
    
        r2 = com.facebook.ads.redexgen.X.C13444e.A03;
        r2[1] = "AZoo0ocwP6";
        r2[3] = "Mxzo3dXJ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
    
        if (r9 != 8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b9, code lost:
    
        r5 = r3.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        if (r5 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00da, code lost:
    
        throw new java.lang.IllegalArgumentException(A01(0, 29, 9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.AnonymousClass49 A00(com.facebook.ads.redexgen.X.C4W r8, int r9) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C13444e.A00(com.facebook.ads.redexgen.X.4W, int):com.facebook.ads.redexgen.X.49");
    }

    @Nullable
    public final AnonymousClass49 A04(C4W c4w) {
        return A00(c4w, 8);
    }

    @Nullable
    public final AnonymousClass49 A05(C4W c4w) {
        return A00(c4w, 4);
    }

    public final C4W A06(long j) {
        return this.A01.A08(j);
    }

    public final void A07() {
        this.A00.clear();
        this.A01.A09();
    }

    public final void A08() {
        C13424c.A01();
    }

    public final void A09(long j, C4W c4w) {
        this.A01.A0B(j, c4w);
    }

    public final void A0A(C4W c4w) {
        C13424c c13424cA00 = this.A00.get(c4w);
        if (c13424cA00 == null) {
            c13424cA00 = C13424c.A00();
            this.A00.put(c4w, c13424cA00);
        }
        c13424cA00.A00 |= 1;
    }

    public final void A0B(C4W c4w) {
        C13424c c13424c = this.A00.get(c4w);
        if (c13424c == null) {
            return;
        }
        c13424c.A00 &= -2;
    }

    public final void A0C(C4W c4w) {
        int iA06 = this.A01.A06() - 1;
        while (true) {
            if (iA06 < 0) {
                break;
            }
            if (c4w == this.A01.A07(iA06)) {
                this.A01.A0A(iA06);
                break;
            }
            iA06--;
        }
        C13424c c13424cRemove = this.A00.remove(c4w);
        if (c13424cRemove != null) {
            C13424c.A02(c13424cRemove);
        }
    }

    public final void A0D(C4W c4w) {
        A0B(c4w);
    }

    public final void A0E(C4W c4w, AnonymousClass49 anonymousClass49) {
        C13424c c13424cA00 = this.A00.get(c4w);
        if (c13424cA00 == null) {
            c13424cA00 = C13424c.A00();
            this.A00.put(c4w, c13424cA00);
        }
        c13424cA00.A00 |= 2;
        c13424cA00.A02 = anonymousClass49;
    }

    public final void A0F(C4W c4w, AnonymousClass49 anonymousClass49) {
        C13424c c13424cA00 = this.A00.get(c4w);
        if (c13424cA00 == null) {
            c13424cA00 = C13424c.A00();
            this.A00.put(c4w, c13424cA00);
        }
        c13424cA00.A01 = anonymousClass49;
        c13424cA00.A00 |= 8;
    }

    public final void A0G(C4W c4w, AnonymousClass49 anonymousClass49) {
        C13424c c13424cA00 = this.A00.get(c4w);
        if (c13424cA00 == null) {
            c13424cA00 = C13424c.A00();
            this.A00.put(c4w, c13424cA00);
        }
        c13424cA00.A02 = anonymousClass49;
        c13424cA00.A00 |= 4;
    }

    public final void A0H(InterfaceC13434d interfaceC13434d) {
        for (int size = this.A00.size() - 1; size >= 0; size--) {
            C4W c4wA0A = this.A00.A0A(size);
            C13424c c13424cA0B = this.A00.A0B(size);
            if ((c13424cA0B.A00 & 3) == 3) {
                interfaceC13434d.ADw(c4wA0A);
            } else if ((c13424cA0B.A00 & 1) != 0) {
                if (c13424cA0B.A02 == null) {
                    interfaceC13434d.ADw(c4wA0A);
                } else {
                    AnonymousClass49 anonymousClass49 = c13424cA0B.A02;
                    AnonymousClass49 anonymousClass492 = c13424cA0B.A01;
                    if (A03[5].charAt(20) == 'R') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A03;
                    strArr[1] = "fJVAe19tdP";
                    strArr[3] = "3fJsXDGb";
                    interfaceC13434d.AC8(c4wA0A, anonymousClass49, anonymousClass492);
                }
            } else if ((c13424cA0B.A00 & 14) == 14) {
                interfaceC13434d.AC6(c4wA0A, c13424cA0B.A02, c13424cA0B.A01);
            } else if ((c13424cA0B.A00 & 12) == 12) {
                interfaceC13434d.ACA(c4wA0A, c13424cA0B.A02, c13424cA0B.A01);
            } else if ((c13424cA0B.A00 & 4) != 0) {
                interfaceC13434d.AC8(c4wA0A, c13424cA0B.A02, null);
            } else if ((c13424cA0B.A00 & 8) != 0) {
                interfaceC13434d.AC6(c4wA0A, c13424cA0B.A02, c13424cA0B.A01);
            }
            C13424c.A02(c13424cA0B);
        }
    }

    public final boolean A0I(C4W c4w) {
        C13424c c13424c = this.A00.get(c4w);
        return (c13424c == null || (c13424c.A00 & 1) == 0) ? false : true;
    }

    public final boolean A0J(C4W c4w) {
        C13424c c13424c = this.A00.get(c4w);
        return (c13424c == null || (c13424c.A00 & 4) == 0) ? false : true;
    }
}
