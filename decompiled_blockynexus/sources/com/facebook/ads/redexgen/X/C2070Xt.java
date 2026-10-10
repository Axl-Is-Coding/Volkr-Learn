package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.Bv;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(18)
public final class C2070Xt<T extends Bv> implements InterfaceC1520Bt<T> {
    public static byte[] A0K;
    public static String[] A0L;
    public int A00;
    public int A01;
    public HandlerThread A02;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/Xt<TT;>.PostRequestHandler; */
    public BZ A03;
    public C1519Br A04;
    public T A05;
    public Object A06;
    public Object A07;
    public byte[] A08;
    public byte[] A09;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/Xt<TT;>.PostResponseHandler; */
    public final HandlerC1509Ba A0A;
    public final C5 A0B;
    public final UUID A0C;
    public final int A0D;
    public final int A0E;
    public final Bb<T> A0F;
    public final C1515Bh A0G;
    public final DrmInitData.SchemeData A0H;
    public final C1<T> A0I;
    public final HashMap<String, String> A0J;

    static {
        A05();
        A04();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private long A01() {
        if (!C14729o.A05.equals(this.A0C)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> pairA01 = C9.A01(this);
        return Math.min(((Long) pairA01.first).longValue(), ((Long) pairA01.second).longValue());
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0K = new byte[]{38, 71, 72, 67, 87, 78, 86, 38, 84, 79, 53, 71, 85, 85, 75, 81, 80, -51, -5, -10, -37, -18, -6, -2, -18, -4, -3, -47, -22, -9, -19, -11, -18, -5, -55, -10, -10, -13, -10, -92, -8, -10, -3, -19, -14, -21, -92, -8, -13, -92, -10, -23, -9, -8, -13, -10, -23, -92, -37, -19, -24, -23, -6, -19, -14, -23, -92, -17, -23, -3, -9, -78, -23, 0, 0, 6, 3, 8, -1, -70, 6, 3, -3, -1, 8, ci.k, -1, -70, 2, -5, ci.k, -70, -1, 18, 10, 3, 12, -1, -2, -70, 9, 12, -70, 17, 3, 6, 6, -70, -1, 18, 10, 3, 12, -1, -70, ci.k, 9, 9, 8, -56, -70, -20, -1, 7, -5, 3, 8, 3, 8, 1, -70, ci.k, -1, -3, 9, 8, -2, ci.k, -44, -70};
    }

    public static void A05() {
        A0L = new String[]{"ygnbftuzQ623Ar", "0dBxCv", "0mS6EqtDw1IrcjMleAT8IB1AlC6o9dAz", "RvmLzAjUPGIONaTchxcxVzTcBBQZgw7Y", "nJTfBRZW6rn0", "sj1G7dKmGRmO2HqivExl", "qBp8iQwY5MoBhJy8uyiyd2Hnkft4tubm", "GRqzAUhZ8aAEJGz"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bb != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession$ProvisioningManager<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C1 != com.facebook.ads.internal.exoplayer2.drm.ExoMediaDrm<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public C2070Xt(UUID uuid, C1<T> c1, Bb<T> bb, @Nullable DrmInitData.SchemeData schemeData, int i, @Nullable byte[] bArr, HashMap<String, String> map, C5 c5, Looper looper, C1515Bh c1515Bh, int i2) {
        this.A0C = uuid;
        this.A0F = bb;
        this.A0I = c1;
        this.A0E = i;
        this.A08 = bArr;
        this.A0H = bArr != null ? null : schemeData;
        this.A0J = map;
        this.A0B = c5;
        this.A0D = i2;
        this.A0G = c1515Bh;
        this.A01 = 2;
        this.A0A = new HandlerC1509Ba(this, looper);
        this.A02 = new HandlerThread(A02(17, 17, 29));
        this.A02.start();
        this.A03 = new BZ(this, this.A02.getLooper());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private void A03() {
        if (this.A01 == 4) {
            this.A01 = 3;
            A09(new C4());
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private void A06(int i, boolean z) {
        byte[] bArr = i == 3 ? this.A08 : this.A09;
        byte[] bArr2 = null;
        String mimeType = null;
        String licenseServerUrl = null;
        DrmInitData.SchemeData schemeData = this.A0H;
        if (schemeData != null) {
            bArr2 = schemeData.A04;
            mimeType = this.A0H.A02;
            licenseServerUrl = this.A0H.A01;
        }
        try {
            this.A06 = Pair.create(this.A0I.getKeyRequest(bArr, bArr2, mimeType, i, this.A0J), licenseServerUrl);
            this.A03.A02(1, this.A06, z);
        } catch (Exception e2) {
            A0A(e2);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private void A09(Exception exc) {
        this.A04 = new C1519Br(exc);
        this.A0G.A04(exc);
        if (this.A01 != 4) {
            this.A01 = 1;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private void A0A(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.A0F.ACB(this);
        } else {
            A09(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r4 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r4 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        r5.A0I.provideKeyResponse(r5.A08, r7);
        r5.A0G.A01();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        r2 = r5.A0I.provideKeyResponse(r5.A09, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if (r5.A0E == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if (r5.A0E != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        if (r5.A08 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        if (r2.length == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        r5.A08 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        r5.A01 = 4;
        r5.A0G.A00();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0B(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.A06
            if (r6 != r0) goto L23
            boolean r3 = r5.A0E()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C2070Xt.A0L
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 19
            if (r1 == r0) goto L8d
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2070Xt.A0L
            java.lang.String r1 = "Dj52Xz5E9G6B"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "yQtL6VAJC1YqjW"
            r0 = 0
            r2[r0] = r1
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            r0 = 0
            r5.A06 = r0
            boolean r0 = r7 instanceof java.lang.Exception
            if (r0 == 0) goto L31
            java.lang.Exception r7 = (java.lang.Exception) r7
            r5.A0A(r7)
            return
        L31:
            byte[] r7 = (byte[]) r7     // Catch: java.lang.Exception -> L88
            int r4 = r5.A0E     // Catch: java.lang.Exception -> L88
            r3 = 3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C2070Xt.A0L
            r0 = 3
            r1 = r1[r0]
            r0 = 22
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L54
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2070Xt.A0L
            java.lang.String r1 = "2X8HJVAZNrszLj0VXzfxBiDDerG65NXA"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "2X8HJVAZNrszLj0VXzfxBiDDerG65NXA"
            r0 = 2
            r2[r0] = r1
            if (r4 != r3) goto L63
            goto L56
        L54:
            if (r4 != r3) goto L63
        L56:
            com.facebook.ads.redexgen.X.C1<T extends com.facebook.ads.redexgen.X.Bv> r1 = r5.A0I     // Catch: java.lang.Exception -> L88
            byte[] r0 = r5.A08     // Catch: java.lang.Exception -> L88
            r1.provideKeyResponse(r0, r7)     // Catch: java.lang.Exception -> L88
            com.facebook.ads.redexgen.X.Bh r0 = r5.A0G     // Catch: java.lang.Exception -> L88
            r0.A01()     // Catch: java.lang.Exception -> L88
            goto L8c
        L63:
            com.facebook.ads.redexgen.X.C1<T extends com.facebook.ads.redexgen.X.Bv> r1 = r5.A0I     // Catch: java.lang.Exception -> L88
            byte[] r0 = r5.A09     // Catch: java.lang.Exception -> L88
            byte[] r2 = r1.provideKeyResponse(r0, r7)     // Catch: java.lang.Exception -> L88
            int r1 = r5.A0E     // Catch: java.lang.Exception -> L88
            r0 = 2
            if (r1 == r0) goto L78
            int r0 = r5.A0E     // Catch: java.lang.Exception -> L88
            if (r0 != 0) goto L7f
            byte[] r0 = r5.A08     // Catch: java.lang.Exception -> L88
            if (r0 == 0) goto L7f
        L78:
            if (r2 == 0) goto L7f
            int r0 = r2.length     // Catch: java.lang.Exception -> L88
            if (r0 == 0) goto L7f
            r5.A08 = r2     // Catch: java.lang.Exception -> L88
        L7f:
            r0 = 4
            r5.A01 = r0     // Catch: java.lang.Exception -> L88
            com.facebook.ads.redexgen.X.Bh r0 = r5.A0G     // Catch: java.lang.Exception -> L88
            r0.A00()     // Catch: java.lang.Exception -> L88
            goto L8c
        L88:
            r0 = move-exception
            r5.A0A(r0)
        L8c:
            return
        L8d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2070Xt.A0B(java.lang.Object, java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public void A0C(Object obj, Object obj2) {
        if (obj == this.A07) {
            if (this.A01 != 2 && !A0E()) {
                return;
            }
            this.A07 = null;
            if (obj2 instanceof Exception) {
                this.A0F.AAy((Exception) obj2);
                return;
            }
            try {
                this.A0I.provideProvisionResponse((byte[]) obj2);
                this.A0F.AAx();
            } catch (Exception e2) {
                Bb<T> bb = this.A0F;
                String[] strArr = A0L;
                if (strArr[4].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0L;
                strArr2[2] = "a4sDA20kWFGOKzGfRWeaug5eKqIpzvIQ";
                strArr2[2] = "a4sDA20kWFGOKzGfRWeaug5eKqIpzvIQ";
                bb.AAy(e2);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private void A0D(boolean z) {
        int i = this.A0E;
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i != 3 || !A0F()) {
                    return;
                }
                A06(3, z);
                return;
            }
            byte[] bArr = this.A08;
            if (A0L[5].length() == 7) {
                throw new RuntimeException();
            }
            String[] strArr = A0L;
            strArr[3] = "nvqtgBbI1rUZtdpDbdJLT2qwzjn5A3EQ";
            strArr[3] = "nvqtgBbI1rUZtdpDbdJLT2qwzjn5A3EQ";
            if (bArr == null) {
                A06(2, z);
                return;
            } else {
                if (!A0F()) {
                    return;
                }
                A06(2, z);
                return;
            }
        }
        if (this.A08 == null) {
            A06(1, z);
            return;
        }
        if (this.A01 != 4 && !A0F()) {
            return;
        }
        long jA01 = A01();
        if (this.A0E != 0 || jA01 > 60) {
            if (jA01 <= 0) {
                A09(new C4());
                return;
            } else {
                this.A01 = 4;
                this.A0G.A02();
                return;
            }
        }
        String str = A02(72, 68, 46) + jA01;
        A06(2, z);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private boolean A0E() {
        int i = this.A01;
        return i == 3 || i == 4;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private boolean A0F() {
        try {
            this.A0I.restoreKeys(this.A09, this.A08);
            return true;
        } catch (Exception e2) {
            Log.e(A02(0, 17, 118), A02(34, 38, 24), e2);
            A09(e2);
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    private boolean A0G(boolean z) {
        if (A0E()) {
            return true;
        }
        try {
            this.A09 = this.A0I.openSession();
            this.A05 = (T) this.A0I.createMediaCrypto(this.A09);
            this.A01 = 3;
            return true;
        } catch (NotProvisionedException e2) {
            if (z) {
                this.A0F.ACB(this);
                return false;
            }
            A09(e2);
            return false;
        } catch (Exception e3) {
            A09(e3);
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final void A0H() {
        int i = this.A00 + 1;
        this.A00 = i;
        if (i == 1 && this.A01 != 1 && A0G(true)) {
            A0D(true);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final void A0I() {
        if (A0G(false)) {
            A0D(true);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final void A0J() {
        this.A07 = this.A0I.getProvisionRequest();
        this.A03.A02(0, this.A07, true);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final void A0K(int i) {
        if (A0E()) {
            String[] strArr = A0L;
            if (strArr[4].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[3] = "lZu3kopIqXcrfR3er40TopUaCPNEg1WS";
            strArr2[3] = "lZu3kopIqXcrfR3er40TopUaCPNEg1WS";
            if (i == 1) {
                this.A01 = 3;
                this.A0F.ACB(this);
            } else if (i == 2) {
                A0D(false);
            } else {
                if (i != 3) {
                    return;
                }
                A03();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final void A0L(Exception exc) {
        A09(exc);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final boolean A0M() {
        int i = this.A00 - 1;
        this.A00 = i;
        if (i != 0) {
            return false;
        }
        this.A01 = 0;
        this.A0A.removeCallbacksAndMessages(null);
        this.A03.removeCallbacksAndMessages(null);
        this.A03 = null;
        this.A02.quit();
        this.A02 = null;
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A07 = null;
        byte[] bArr = this.A09;
        if (bArr != null) {
            this.A0I.closeSession(bArr);
            this.A09 = null;
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final boolean A0N(byte[] bArr) {
        DrmInitData.SchemeData schemeData = this.A0H;
        return Arrays.equals(schemeData != null ? schemeData.A04 : null, bArr);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    public final boolean A0O(byte[] bArr) {
        return Arrays.equals(this.A09, bArr);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1520Bt
    public final C1519Br A6I() {
        if (this.A01 == 1) {
            return this.A04;
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1520Bt
    public final T A6d() {
        return this.A05;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1520Bt
    public final int A77() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1520Bt
    public final Map<String, String> ACC() {
        byte[] bArr = this.A09;
        if (bArr == null) {
            return null;
        }
        C1<T> c1 = this.A0I;
        if (A0L[5].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[7] = "lzhfD5NgGZX1H2DfqRAO4AgkK";
        strArr[7] = "lzhfD5NgGZX1H2DfqRAO4AgkK";
        return c1.queryKeyStatus(bArr);
    }
}
