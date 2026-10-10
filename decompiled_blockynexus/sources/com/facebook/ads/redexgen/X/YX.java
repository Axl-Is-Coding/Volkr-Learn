package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.umeng.analytics.pro.ci;
import io.rong.imkit.utils.FileTypeUtils;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YX implements CA {
    public static byte[] A0X;
    public static String[] A0Y;
    public static final CD A0Z;
    public static final int A0a;
    public static final Format A0b;
    public static final byte[] A0c;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public CC A0C;
    public C1536Cn A0D;
    public IG A0E;
    public boolean A0F;
    public boolean A0G;
    public CM[] A0H;
    public CM[] A0I;
    public final int A0J;
    public final SparseArray<C1536Cn> A0K;

    @Nullable
    public final DrmInitData A0L;

    @Nullable
    public final CM A0M;

    @Nullable
    public final C1545Cw A0N;
    public final IG A0O;
    public final IG A0P;
    public final IG A0Q;
    public final IG A0R;

    @Nullable
    public final IS A0S;
    public final ArrayDeque<YR> A0T;
    public final ArrayDeque<C1535Cm> A0U;
    public final List<Format> A0V;
    public final byte[] A0W;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 23
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Pair<Long, Y6> A04(IG ig, long j) throws AD {
        long jA0O;
        long jA0O2;
        ig.A0Z(8);
        int iA01 = AbstractC1524Cb.A01(ig.A09());
        ig.A0a(4);
        long jA0N = ig.A0N();
        if (iA01 == 0) {
            jA0O = ig.A0N();
            jA0O2 = j + ig.A0N();
        } else {
            jA0O = ig.A0O();
            jA0O2 = j + ig.A0O();
        }
        long jA0F = IW.A0F(jA0O, 1000000L, jA0N);
        ig.A0a(2);
        int iA0J = ig.A0J();
        int[] iArr = new int[iA0J];
        long[] jArr = new long[iA0J];
        long[] jArr2 = new long[iA0J];
        long[] jArr3 = new long[iA0J];
        if (A0Y[2].charAt(18) != 'K') {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[5] = com.umeng.analytics.pro.au.ax;
        strArr[5] = com.umeng.analytics.pro.au.ax;
        int i = 0;
        long jA0F2 = jA0F;
        while (i < iA0J) {
            int iA09 = ig.A09();
            if ((Integer.MIN_VALUE & iA09) != 0) {
                throw new AD(A0A(581, 28, 75));
            }
            long jA0N2 = ig.A0N();
            iArr[i] = Integer.MAX_VALUE & iA09;
            jArr[i] = jA0O2;
            jArr3[i] = jA0F2;
            jA0O += jA0N2;
            jA0F2 = IW.A0F(jA0O, 1000000L, jA0N);
            jArr2[i] = jA0F2 - jArr3[i];
            ig.A0a(4);
            int i2 = iArr[i];
            if (A0Y[3].length() != 6) {
                String[] strArr2 = A0Y;
                strArr2[1] = "dhc";
                strArr2[1] = "dhc";
                jA0O2 += (long) i2;
                i += 0;
            } else {
                String[] strArr3 = A0Y;
                strArr3[5] = "h";
                strArr3[5] = "h";
                jA0O2 += (long) i2;
                i++;
            }
        }
        return Pair.create(Long.valueOf(jA0F), new Y6(iArr, jArr, jArr2, jArr3));
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0X, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0X = new byte[]{76, 64, 11, 62, 37, 39, 106, 57, 35, 48, 47, 106, 38, 47, 57, 57, 106, 62, 34, 43, 36, 106, 34, 47, 43, 46, 47, 56, 106, 38, 47, 36, 45, 62, 34, 106, 98, Utf8.REPLACEMENT_BYTE, 36, 57, Utf8.REPLACEMENT_BYTE, 58, 58, 37, 56, 62, 47, 46, 99, 100, 104, 67, 89, 95, 84, ci.k, 78, 66, 88, 67, 89, ci.k, 68, 67, ci.k, 94, 79, 74, 93, ci.k, 12, ci.n, ci.k, 28, ci.k, 5, 88, 67, 94, 88, 93, 93, 66, 95, 89, 72, 73, 4, 3, 5, 46, 52, 50, 57, 96, 35, 47, 53, 46, 52, 96, 41, 46, 96, 51, 39, 48, 36, 96, 97, 125, 96, 113, 96, 104, 53, 46, 51, 53, 48, 48, 47, 50, 52, 37, 36, 105, 110, 29, 41, 58, 60, 54, 62, 53, 47, 62, Utf8.REPLACEMENT_BYTE, 22, 43, 111, 30, 35, 47, 41, 58, 56, 47, 52, 41, 4, 42, 35, 34, Utf8.REPLACEMENT_BYTE, 36, 35, 42, 109, 35, 40, 42, 44, 57, 36, 59, 40, 109, 34, 43, 43, 62, 40, 57, 109, 57, 34, 109, 62, 44, 32, 61, 33, 40, 109, 41, 44, 57, 44, 99, 110, 71, 67, 68, 2, 67, 86, 77, 79, 2, 70, 71, 68, 75, 76, 71, 81, 2, 71, 90, 86, 71, 76, 70, 71, 70, 2, 67, 86, 77, 79, 2, 81, 75, 88, 71, 2, 10, 87, 76, 81, 87, 82, 82, 77, 80, 86, 71, 70, 11, 12, 38, ci.m, 11, 12, 74, 11, 30, 5, 7, 74, 29, 3, 30, 2, 74, 6, ci.m, 4, ci.k, 30, 2, 74, 84, 74, 88, 91, 94, 93, 94, 82, 89, 92, 94, 93, 74, 66, 31, 4, 25, 31, 26, 26, 5, 24, 30, ci.m, ci.l, 67, 68, 97, 72, 67, 74, 89, 69, ci.k, 64, 68, 94, 64, 76, 89, 78, 69, 23, ci.k, 88, 113, 113, 100, 114, 99, 55, 99, 120, 55, 114, 121, 116, 101, 110, 103, 99, 126, 120, 121, 55, 115, 118, 99, 118, 55, 96, 118, 100, 55, 121, 114, 112, 118, 99, 126, 97, 114, 57, 22, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 42, 60, 45, 121, 45, 54, 121, 60, 55, 61, 121, 54, Utf8.REPLACEMENT_BYTE, 121, 52, 61, 56, 45, 121, 46, 56, 42, 121, 55, 60, 62, 56, 45, 48, 47, 60, 119, 84, 109, 126, 105, 105, 114, 127, 114, 117, 124, 59, 79, 105, 122, 120, 112, 94, 117, 120, 105, 98, 107, 111, 114, 116, 117, 89, 116, 99, 59, 107, 122, 105, 122, 118, 126, 111, 126, 105, 104, 59, 114, 104, 59, 110, 117, 104, 110, 107, 107, 116, 105, 111, 126, 127, 53, 107, 83, 81, 72, 72, 93, 92, 24, 72, 75, 75, 80, 24, 89, 76, 87, 85, 24, ci.n, 94, 89, 81, 84, 93, 92, 24, 76, 87, 24, 93, 64, 76, 74, 89, 91, 76, 24, 77, 77, 81, 92, 17, 105, 81, 83, 74, 74, 83, 84, 93, 26, 91, 78, 85, 87, 26, 77, 83, 78, 82, 26, 86, 95, 84, 93, 78, 82, 26, 4, 26, 8, 11, ci.l, ci.k, ci.l, 2, 9, 12, ci.l, ci.k, 26, 18, 79, 84, 73, 79, 74, 74, 85, 72, 78, 95, 94, 19, 20, 11, 48, 59, 38, 46, 59, 61, 42, 59, 58, 126, 51, 49, 49, 40, 126, 60, 49, 38, 112, 95, 100, 111, 114, 122, 111, 105, 126, 111, 110, 42, 121, 107, 99, 101, 42, 111, 100, 126, 120, 115, 42, 105, 101, 127, 100, 126, 48, 42, 75, 112, 118, 127, 112, 122, 114, 123, 122, 62, 119, 112, 122, 119, 108, 123, 125, 106, 62, 108, 123, 120, 123, 108, 123, 112, 125, 123, 41, 30, ci.k, 22, 30, 29, 19, 26, 95, 19, 26, 17, 24, 11, 23, 95, 27, 26, 12, 28, ci.k, 22, ci.m, 11, 22, ci.n, 17, 95, 22, 17, 95, 12, 24, ci.m, 27, 95, 25, ci.n, 10, 17, 27, 95, 87, 10, 17, 12, 10, ci.m, ci.m, ci.n, ci.k, 11, 26, 27, 86, 3, 18, 18, ci.l, 11, 1, 3, 22, 11, ci.k, 12, 77, 26, 79, 7, ci.m, 17, 5, 62, 40, 36, 42, 46, 49, 60, 61, 55, 119, 48, 61, 46, 59, 61, 34, 47, 46, 36, 100, 38, 59, 127};
    }

    public static void A0E() {
        A0Y = new String[]{"bw2Pz5UYSLOOesGIJaWlA3GOzVLZPAg", "gG3", "yjdYoV9UEi8qMqqcqGKRK6SXbov0CwAj", "4kzePG", "OMn6r0AgRGwk9BJzU", "o", "aMFqcwP4FMZJ2yTkvuTBoGT2vGZy4ax", "h66GloOgbywQ1e6PB204dGM9vAJrPucq"};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0N(YR yr, SparseArray<C1536Cn> sparseArray, int i, byte[] bArr) throws AD {
        C1536Cn c1536CnA09 = A09(yr.A07(AbstractC1524Cb.A1I).A00, sparseArray);
        if (c1536CnA09 == null) {
            return;
        }
        C1547Cy c1547Cy = c1536CnA09.A07;
        long jA02 = c1547Cy.A06;
        c1536CnA09.A05();
        if (yr.A07(AbstractC1524Cb.A1H) != null && (i & 2) == 0) {
            jA02 = A02(yr.A07(AbstractC1524Cb.A1H).A00);
        }
        A0O(yr, c1536CnA09, jA02, i);
        C1546Cx c1546CxA00 = c1536CnA09.A05.A00(c1547Cy.A07.A02);
        YS ysA07 = yr.A07(AbstractC1524Cb.A0u);
        if (ysA07 != null) {
            A0Q(c1546CxA00, ysA07.A00, c1547Cy);
        }
        YS ysA072 = yr.A07(AbstractC1524Cb.A0t);
        if (ysA072 != null) {
            A0T(ysA072.A00, c1547Cy);
        }
        YS ysA073 = yr.A07(AbstractC1524Cb.A10);
        if (ysA073 != null) {
            A0U(ysA073.A00, c1547Cy);
        }
        YS ysA074 = yr.A07(AbstractC1524Cb.A0x);
        YS ysA075 = yr.A07(AbstractC1524Cb.A11);
        if (ysA074 != null && ysA075 != null) {
            A0W(ysA074.A00, ysA075.A00, c1546CxA00 != null ? c1546CxA00.A02 : null, c1547Cy);
        }
        int size = yr.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            YS ys = yr.A02.get(i2);
            int i3 = ((AbstractC1524Cb) ys).A00;
            int i4 = AbstractC1524Cb.A1Q;
            if (A0Y[7].charAt(27) != 'r') {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[6] = "tWuQt3qCpORkhzaHtCNFkUwj420xxTd";
            strArr[4] = "yKRRCTery0iDoE3P4";
            if (i3 == i4) {
                A0V(ys.A00, c1547Cy, bArr);
            }
        }
    }

    static {
        A0E();
        A0D();
        A0Z = new YW();
        A0a = IW.A08(A0A(682, 4, 24));
        A0c = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        A0b = Format.A02(null, A0A(664, 18, 55), Long.MAX_VALUE);
    }

    public YX() {
        this(0);
    }

    public YX(int i) {
        this(i, null);
    }

    public YX(int i, @Nullable IS is) {
        this(i, is, null, null);
    }

    public YX(int i, @Nullable IS is, @Nullable C1545Cw c1545Cw, @Nullable DrmInitData drmInitData) {
        this(i, is, c1545Cw, drmInitData, Collections.emptyList());
    }

    public YX(int i, @Nullable IS is, @Nullable C1545Cw c1545Cw, @Nullable DrmInitData drmInitData, List<Format> closedCaptionFormats) {
        this(i, is, c1545Cw, drmInitData, closedCaptionFormats, null);
    }

    public YX(int i, @Nullable IS is, @Nullable C1545Cw c1545Cw, @Nullable DrmInitData drmInitData, List<Format> list, @Nullable CM cm) {
        this.A0J = (c1545Cw != null ? 8 : 0) | i;
        this.A0S = is;
        this.A0N = c1545Cw;
        this.A0L = drmInitData;
        List<Format> closedCaptionFormats = Collections.unmodifiableList(list);
        this.A0V = closedCaptionFormats;
        this.A0M = cm;
        this.A0O = new IG(16);
        this.A0R = new IG(IC.A03);
        this.A0Q = new IG(5);
        this.A0P = new IG();
        this.A0W = new byte[16];
        this.A0T = new ArrayDeque<>();
        this.A0U = new ArrayDeque<>();
        this.A0K = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0A = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        A0B();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(com.facebook.ads.redexgen.X.C1536Cn r28, int r29, long r30, int r32, com.facebook.ads.redexgen.X.IG r33, int r34) {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YX.A00(com.facebook.ads.redexgen.X.Cn, int, long, int, com.facebook.ads.redexgen.X.IG, int):int");
    }

    public static long A01(IG ig) {
        ig.A0Z(8);
        int version = AbstractC1524Cb.A01(ig.A09());
        return version == 0 ? ig.A0N() : ig.A0O();
    }

    public static long A02(IG ig) {
        ig.A0Z(8);
        return AbstractC1524Cb.A01(ig.A09()) == 1 ? ig.A0O() : ig.A0N();
    }

    public static Pair<Integer, C1530Ch> A03(IG ig) {
        ig.A0Z(12);
        int defaultSampleDuration = ig.A09();
        int defaultSampleFlags = ig.A0I() - 1;
        return Pair.create(Integer.valueOf(defaultSampleDuration), new C1530Ch(defaultSampleFlags, ig.A0I(), ig.A0I(), ig.A09()));
    }

    public static DrmInitData A05(List<YS> list) {
        ArrayList arrayList = null;
        int i = list.size();
        for (int i2 = 0; i2 < i; i2++) {
            YS ys = list.get(i2);
            if (((AbstractC1524Cb) ys).A00 == AbstractC1524Cb.A0r) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = ys.A00.A00;
                UUID uuidA03 = C1542Ct.A03(bArr);
                if (uuidA03 == null) {
                    Log.w(A0A(128, 22, 14), A0A(437, 42, 109));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA03, A0A(696, 9, 30), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private C1530Ch A06(SparseArray<C1530Ch> sparseArray, int i) {
        if (sparseArray.size() != 1) {
            return (C1530Ch) C1662Hr.A01(sparseArray.get(i));
        }
        if (A0Y[7].charAt(27) != 'r') {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[3] = "nw8rk4";
        strArr[3] = "nw8rk4";
        return sparseArray.valueAt(0);
    }

    public static C1536Cn A07(SparseArray<C1536Cn> sparseArray) {
        C1536Cn c1536Cn = null;
        long j = Long.MAX_VALUE;
        int i = sparseArray.size();
        for (int i2 = 0; i2 < i; i2++) {
            C1536Cn c1536CnValueAt = sparseArray.valueAt(i2);
            if (c1536CnValueAt.A02 != c1536CnValueAt.A07.A02) {
                long j2 = c1536CnValueAt.A07.A0G[c1536CnValueAt.A02];
                if (j2 < j) {
                    c1536Cn = c1536CnValueAt;
                    j = j2;
                }
            }
        }
        return c1536Cn;
    }

    @Nullable
    public static C1536Cn A08(SparseArray<C1536Cn> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        C1536Cn c1536Cn = sparseArray.get(i);
        if (A0Y[0].length() == 21) {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[1] = "fYJ";
        strArr[1] = "fYJ";
        return c1536Cn;
    }

    public static C1536Cn A09(IG ig, SparseArray<C1536Cn> sparseArray) {
        int iA0I;
        int iA0I2;
        int iA0I3;
        int iA0I4;
        ig.A0Z(8);
        int iA00 = AbstractC1524Cb.A00(ig.A09());
        int trackId = ig.A09();
        C1536Cn c1536CnA08 = A08(sparseArray, trackId);
        if (c1536CnA08 == null) {
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0O = ig.A0O();
            c1536CnA08.A07.A05 = jA0O;
            c1536CnA08.A07.A04 = jA0O;
        }
        C1530Ch c1530Ch = c1536CnA08.A04;
        if ((iA00 & 2) != 0) {
            iA0I = ig.A0I() - 1;
        } else {
            iA0I = c1530Ch.A02;
        }
        int defaultSampleDescriptionIndex = iA00 & 8;
        if (defaultSampleDescriptionIndex != 0) {
            iA0I2 = ig.A0I();
        } else {
            iA0I2 = c1530Ch.A00;
        }
        int defaultSampleDescriptionIndex2 = iA00 & 16;
        if (defaultSampleDescriptionIndex2 != 0) {
            iA0I3 = ig.A0I();
        } else {
            iA0I3 = c1530Ch.A03;
        }
        int defaultSampleSize = iA00 & 32;
        if (defaultSampleSize != 0) {
            iA0I4 = ig.A0I();
        } else {
            iA0I4 = c1530Ch.A01;
        }
        c1536CnA08.A07.A07 = new C1530Ch(iA0I, iA0I2, iA0I3, iA0I4);
        return c1536CnA08;
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    private void A0C() {
        if (this.A0I == null) {
            this.A0I = new CM[2];
            int i = 0;
            CM cm = this.A0M;
            if (cm != null) {
                int emsgTrackOutputCount = 0 + 1;
                this.A0I[0] = cm;
                i = emsgTrackOutputCount;
            }
            int emsgTrackOutputCount2 = this.A0J;
            if ((emsgTrackOutputCount2 & 4) != 0) {
                CM[] cmArr = this.A0I;
                CC cc = this.A0C;
                int emsgTrackOutputCount3 = this.A0K.size();
                cmArr[i] = cc.ADr(emsgTrackOutputCount3, 4);
                i++;
            }
            this.A0I = (CM[]) Arrays.copyOf(this.A0I, i);
            for (CM cm2 : this.A0I) {
                cm2.A5I(A0b);
            }
        }
        if (this.A0H == null) {
            this.A0H = new CM[this.A0V.size()];
            for (int i2 = 0; i2 < this.A0H.length; i2++) {
                CM cmADr = this.A0C.ADr(this.A0K.size() + 1 + i2, 3);
                cmADr.A5I(this.A0V.get(i2));
                this.A0H[i2] = cmADr;
                String[] strArr = A0Y;
                if (strArr[6].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0Y;
                strArr2[7] = "E0z9VN5IoStoNoHPwfepvpkncforV8p8";
                strArr2[7] = "E0z9VN5IoStoNoHPwfepvpkncforV8p8";
            }
        }
    }

    private void A0F(long j) {
        while (!this.A0U.isEmpty()) {
            C1535Cm c1535CmRemoveFirst = this.A0U.removeFirst();
            this.A03 -= c1535CmRemoveFirst.A00;
            long jA07 = j + c1535CmRemoveFirst.A01;
            IS is = this.A0S;
            if (is != null) {
                jA07 = is.A07(jA07);
            }
            for (CM cm : this.A0I) {
                cm.ACy(jA07, 1, c1535CmRemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0G(long j) throws AD {
        while (!this.A0T.isEmpty() && this.A0T.peek().A00 == j) {
            A0J(this.A0T.pop());
        }
        A0B();
    }

    private void A0H(CB cb) throws InterruptedException, IOException {
        int i = ((int) this.A07) - this.A00;
        IG ig = this.A0E;
        if (ig != null) {
            cb.readFully(ig.A00, 8, i);
            A0P(new YS(this.A01, this.A0E), cb.A6t());
        } else {
            cb.ADZ(i);
        }
        A0G(cb.A6t());
    }

    private void A0I(CB cb) throws InterruptedException, IOException {
        C1536Cn c1536CnValueAt = null;
        long j = Long.MAX_VALUE;
        int size = this.A0K.size();
        for (int i = 0; i < size; i++) {
            C1547Cy c1547Cy = this.A0K.valueAt(i).A07;
            if (c1547Cy.A0B) {
                long j2 = c1547Cy.A04;
                if (A0Y[2].charAt(18) != 'K') {
                    throw new RuntimeException();
                }
                String[] strArr = A0Y;
                strArr[3] = "TcDom5";
                strArr[3] = "TcDom5";
                if (j2 < j) {
                    j = c1547Cy.A04;
                    c1536CnValueAt = this.A0K.valueAt(i);
                }
            }
        }
        if (c1536CnValueAt == null) {
            if (A0Y[3].length() != 6) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Y;
            strArr2[2] = "BU1FqSGZUKIp3lmSYzKBGxc2Z86jKcpe";
            strArr2[2] = "BU1FqSGZUKIp3lmSYzKBGxc2Z86jKcpe";
            this.A02 = 3;
            return;
        }
        long jA6t = j - cb.A6t();
        if (A0Y[3].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0Y;
        strArr3[0] = "Cvsa72edMITB5GhT";
        strArr3[0] = "Cvsa72edMITB5GhT";
        int bytesToSkip = (int) jA6t;
        if (bytesToSkip >= 0) {
            cb.ADZ(bytesToSkip);
            c1536CnValueAt.A07.A05(cb);
            return;
        }
        throw new AD(A0A(307, 39, 66));
    }

    private void A0J(YR yr) throws AD {
        if (((AbstractC1524Cb) yr).A00 == AbstractC1524Cb.A0j) {
            A0L(yr);
            return;
        }
        if (((AbstractC1524Cb) yr).A00 == AbstractC1524Cb.A0i) {
            A0K(yr);
            return;
        }
        if (this.A0T.isEmpty()) {
            return;
        }
        ArrayDeque<YR> arrayDeque = this.A0T;
        if (A0Y[1].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[7] = "6RjYlEZz613sKxZIpZ2APlvoVeArWnyB";
        strArr[7] = "6RjYlEZz613sKxZIpZ2APlvoVeArWnyB";
        arrayDeque.peek().A08(yr);
    }

    private void A0K(YR yr) throws AD {
        A0M(yr, this.A0K, this.A0J, this.A0W);
        DrmInitData drmInitDataA05 = this.A0L != null ? null : A05(yr.A02);
        if (drmInitDataA05 != null) {
            int i = this.A0K.size();
            for (int i2 = 0; i2 < i; i2++) {
                this.A0K.valueAt(i2).A07(drmInitDataA05);
            }
        }
        if (this.A0A != -9223372036854775807L) {
            int size = this.A0K.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.A0K.valueAt(i3).A06(this.A0A);
            }
            this.A0A = -9223372036854775807L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A0L(YR yr) throws AD {
        C1662Hr.A06(this.A0N == null, A0A(532, 20, 11));
        DrmInitData drmInitDataA05 = this.A0L;
        if (drmInitDataA05 == null) {
            drmInitDataA05 = A05(yr.A02);
        }
        YR yrA06 = yr.A06(AbstractC1524Cb.A0m);
        SparseArray sparseArray = new SparseArray();
        long jA01 = -9223372036854775807L;
        int size = yrA06.A02.size();
        for (int i = 0; i < size; i++) {
            YS ys = yrA06.A02.get(i);
            int i2 = ((AbstractC1524Cb) ys).A00;
            if (i2 == AbstractC1524Cb.A1M) {
                Pair<Integer, C1530Ch> pairA03 = A03(ys.A00);
                int i3 = ((Integer) pairA03.first).intValue();
                sparseArray.put(i3, pairA03.second);
            } else {
                int i4 = ((AbstractC1524Cb) ys).A00;
                if (i4 == AbstractC1524Cb.A0f) {
                    jA01 = A01(ys.A00);
                }
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = yr.A01.size();
        for (int i5 = 0; i5 < size2; i5++) {
            YR yr2 = yr.A01.get(i5);
            int i6 = ((AbstractC1524Cb) yr2).A00;
            if (i6 == AbstractC1524Cb.A1L) {
                C1545Cw c1545CwA0C = C1529Cg.A0C(yr2, yr.A07(AbstractC1524Cb.A0n), jA01, drmInitDataA05, (this.A0J & 16) != 0, false);
                if (c1545CwA0C != null) {
                    int i7 = c1545CwA0C.A00;
                    sparseArray2.put(i7, c1545CwA0C);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.A0K.size() == 0) {
            for (int i8 = 0; i8 < size3; i8++) {
                C1545Cw c1545Cw = (C1545Cw) sparseArray2.valueAt(i8);
                CC cc = this.A0C;
                int i9 = c1545Cw.A03;
                C1536Cn c1536Cn = new C1536Cn(cc.ADr(i8, i9));
                int i10 = c1545Cw.A00;
                c1536Cn.A08(c1545Cw, A06(sparseArray, i10));
                SparseArray<C1536Cn> sparseArray3 = this.A0K;
                int i11 = c1545Cw.A00;
                sparseArray3.put(i11, c1536Cn);
                this.A08 = Math.max(this.A08, c1545Cw.A04);
            }
            A0C();
            if (A0Y[5].length() != 1) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[5] = com.umeng.analytics.pro.au.au;
            strArr[5] = com.umeng.analytics.pro.au.au;
            this.A0C.A54();
            return;
        }
        C1662Hr.A04(this.A0K.size() == size3);
        for (int i12 = 0; i12 < size3; i12++) {
            C1545Cw c1545Cw2 = (C1545Cw) sparseArray2.valueAt(i12);
            this.A0K.get(c1545Cw2.A00).A08(c1545Cw2, A06(sparseArray, c1545Cw2.A00));
        }
    }

    public static void A0M(YR yr, SparseArray<C1536Cn> sparseArray, int i, byte[] bArr) throws AD {
        int size = yr.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            YR yr2 = yr.A01.get(i2);
            if (((AbstractC1524Cb) yr2).A00 == AbstractC1524Cb.A1K) {
                A0N(yr2, sparseArray, i, bArr);
            }
        }
    }

    public static void A0O(YR yr, C1536Cn c1536Cn, long j, int i) {
        int totalSampleCount = 0;
        int trunSampleCount = 0;
        List<YS> list = yr.A02;
        int leafChildrenSize = list.size();
        for (int totalSampleCount2 = 0; totalSampleCount2 < leafChildrenSize; totalSampleCount2++) {
            YS ys = list.get(totalSampleCount2);
            int i2 = ((AbstractC1524Cb) ys).A00;
            int i3 = AbstractC1524Cb.A1N;
            if (A0Y[2].charAt(18) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[0] = "HX3CrwnoNkNpp8Diq6RFqVXtJKh";
            strArr[0] = "HX3CrwnoNkNpp8Diq6RFqVXtJKh";
            if (i2 == i3) {
                IG ig = ys.A00;
                ig.A0Z(12);
                int iA0I = ig.A0I();
                if (iA0I > 0) {
                    trunSampleCount += iA0I;
                    totalSampleCount++;
                }
            }
        }
        c1536Cn.A02 = 0;
        c1536Cn.A00 = 0;
        c1536Cn.A01 = 0;
        c1536Cn.A07.A04(totalSampleCount, trunSampleCount);
        int i4 = 0;
        int iA00 = 0;
        if (A0Y[7].charAt(27) == 'r') {
            String[] strArr2 = A0Y;
            strArr2[1] = "K2a";
            strArr2[1] = "K2a";
        }
        for (int i5 = 0; i5 < leafChildrenSize; i5++) {
            YS ys2 = list.get(i5);
            if (((AbstractC1524Cb) ys2).A00 == AbstractC1524Cb.A1N) {
                iA00 = A00(c1536Cn, i4, j, i, ys2.A00, iA00);
                i4++;
            }
        }
    }

    private void A0P(YS ys, long j) throws AD {
        if (!this.A0T.isEmpty()) {
            this.A0T.peek().A09(ys);
            return;
        }
        if (((AbstractC1524Cb) ys).A00 == AbstractC1524Cb.A12) {
            Pair<Long, Y6> pairA04 = A04(ys.A00, j);
            this.A0B = ((Long) pairA04.first).longValue();
            this.A0C.AD3((CJ) pairA04.second);
            this.A0F = true;
            return;
        }
        if (((AbstractC1524Cb) ys).A00 != AbstractC1524Cb.A0P) {
            return;
        }
        A0R(ys.A00);
    }

    public static void A0Q(C1546Cx c1546Cx, IG ig, C1547Cy c1547Cy) throws AD {
        int flags = c1546Cx.A00;
        ig.A0Z(8);
        if ((AbstractC1524Cb.A00(ig.A09()) & 1) == 1) {
            ig.A0a(8);
        }
        int vectorSize = ig.A0F();
        int iA0I = ig.A0I();
        String[] strArr = A0Y;
        if (strArr[6].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0Y;
        strArr2[3] = "qY4fk5";
        strArr2[3] = "qY4fk5";
        if (iA0I == c1547Cy.A00) {
            int i = 0;
            if (vectorSize == 0) {
                boolean[] zArr = c1547Cy.A0H;
                for (int sampleCount = 0; sampleCount < iA0I; sampleCount++) {
                    int totalSize = ig.A0F();
                    i += totalSize;
                    zArr[sampleCount] = totalSize > flags;
                }
            } else {
                boolean z = vectorSize > flags;
                int i2 = vectorSize * iA0I;
                i = 0 + i2;
                Arrays.fill(c1547Cy.A0H, 0, iA0I, z);
            }
            c1547Cy.A03(i);
            return;
        }
        throw new AD(A0A(290, 17, 120) + iA0I + A0A(0, 2, 53) + c1547Cy.A00);
    }

    private void A0R(IG ig) {
        CM[] cmArr = this.A0I;
        if (cmArr == null || cmArr.length == 0) {
            return;
        }
        ig.A0Z(12);
        int iA05 = ig.A05();
        ig.A0R();
        ig.A0R();
        long jA0N = ig.A0N();
        long timescale = ig.A0N();
        long jA0F = IW.A0F(timescale, 1000000L, jA0N);
        for (CM cm : this.A0I) {
            ig.A0Z(12);
            cm.ACx(ig, iA05);
        }
        long j = this.A0B;
        if (j != -9223372036854775807L) {
            long jA07 = j + jA0F;
            IS is = this.A0S;
            if (is != null) {
                jA07 = is.A07(jA07);
            }
            for (CM cm2 : this.A0I) {
                cm2.ACy(jA07, 1, iA05, 0, null);
            }
            return;
        }
        this.A0U.addLast(new C1535Cm(jA0F, iA05));
        this.A03 += iA05;
    }

    public static void A0S(IG ig, int i, C1547Cy c1547Cy) throws AD {
        ig.A0Z(i + 8);
        int iA00 = AbstractC1524Cb.A00(ig.A09());
        if ((iA00 & 1) == 0) {
            boolean z = (iA00 & 2) != 0;
            int iA0I = ig.A0I();
            int i2 = c1547Cy.A00;
            if (A0Y[2].charAt(18) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[6] = "UNCiZzJs5PDRpvixsYfSSk1mhxuZgiq";
            strArr[4] = "wrSUtL8XPGusZqeHm";
            if (iA0I == i2) {
                Arrays.fill(c1547Cy.A0H, 0, iA0I, z);
                int sampleCount = ig.A05();
                c1547Cy.A03(sampleCount);
                c1547Cy.A06(ig);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(A0A(290, 17, 120));
            sb.append(iA0I);
            sb.append(A0A(0, 2, 53));
            int sampleCount2 = c1547Cy.A00;
            sb.append(sampleCount2);
            throw new AD(sb.toString());
        }
        throw new AD(A0A(381, 56, 78));
    }

    public static void A0T(IG ig, C1547Cy c1547Cy) throws AD {
        ig.A0Z(8);
        int iA09 = ig.A09();
        if ((AbstractC1524Cb.A00(iA09) & 1) == 1) {
            ig.A0a(8);
        }
        int iA0I = ig.A0I();
        int flags = A0Y[3].length();
        if (flags != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A0Y;
        strArr[3] = "xMtqR0";
        strArr[3] = "xMtqR0";
        if (iA0I == 1) {
            long jA0N = c1547Cy.A04 + (AbstractC1524Cb.A01(iA09) == 0 ? ig.A0N() : ig.A0O());
            String[] strArr2 = A0Y;
            String str = strArr2[6];
            String str2 = strArr2[4];
            int flags2 = str.length();
            if (flags2 != str2.length()) {
                String[] strArr3 = A0Y;
                strArr3[6] = "QBYjlSuWWzNHcmXjWc7avhw4MqaHk82";
                strArr3[4] = "P5zbNSbq1MUS3wdHf";
                c1547Cy.A04 = jA0N;
                return;
            }
            String[] strArr4 = A0Y;
            strArr4[7] = "vg5EJJPWiTbIFzTVTJFrvfHkMClrP8RJ";
            strArr4[7] = "vg5EJJPWiTbIFzTVTJFrvfHkMClrP8RJ";
            c1547Cy.A04 = jA0N;
            return;
        }
        throw new AD(A0A(552, 29, 95) + iA0I);
    }

    public static void A0U(IG ig, C1547Cy c1547Cy) throws AD {
        A0S(ig, 0, c1547Cy);
    }

    public static void A0V(IG ig, C1547Cy c1547Cy, byte[] bArr) throws AD {
        ig.A0Z(8);
        ig.A0d(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0c)) {
            return;
        }
        A0S(ig, 16, c1547Cy);
    }

    public static void A0W(IG ig, IG ig2, String str, C1547Cy c1547Cy) throws AD {
        ig.A0Z(8);
        int iA09 = ig.A09();
        if (ig.A09() != A0a) {
            return;
        }
        if (AbstractC1524Cb.A01(iA09) == 1) {
            ig.A0a(4);
        }
        int iA092 = ig.A09();
        String[] strArr = A0Y;
        if (strArr[6].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0Y;
        strArr2[3] = "cve2FA";
        strArr2[3] = "cve2FA";
        if (iA092 == 1) {
            ig2.A0Z(8);
            int iA093 = ig2.A09();
            if (ig2.A09() != A0a) {
                return;
            }
            int iA01 = AbstractC1524Cb.A01(iA093);
            if (A0Y[1].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0Y;
            strArr3[7] = "iX8BjoZjE8Q6Igd9BCVMMRG15zWrcCbA";
            strArr3[7] = "iX8BjoZjE8Q6Igd9BCVMMRG15zWrcCbA";
            if (iA01 == 1) {
                if (ig2.A0N() == 0) {
                    throw new AD(A0A(609, 55, 42));
                }
            } else if (iA01 >= 2) {
                ig2.A0a(4);
            }
            if (ig2.A0N() == 1) {
                ig2.A0a(1);
                int iA0F = ig2.A0F();
                int i = (iA0F & 240) >> 4;
                int i2 = iA0F & 15;
                boolean z = ig2.A0F() == 1;
                if (!z) {
                    return;
                }
                int iA0F2 = ig2.A0F();
                byte[] bArr = new byte[16];
                int perSampleIvSize = bArr.length;
                ig2.A0d(bArr, 0, perSampleIvSize);
                int skipByteBlock = A0Y[7].charAt(27);
                if (skipByteBlock != 114) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0Y;
                strArr4[0] = "v2evuoi5ipUorqJI1yS0NRy";
                strArr4[0] = "v2evuoi5ipUorqJI1yS0NRy";
                byte[] bArr2 = null;
                if (z && iA0F2 == 0) {
                    int iA0F3 = ig2.A0F();
                    bArr2 = new byte[iA0F3];
                    ig2.A0d(bArr2, 0, iA0F3);
                }
                c1547Cy.A0A = true;
                c1547Cy.A08 = new C1546Cx(z, str, iA0F2, bArr, i, i2, bArr2);
                return;
            }
            throw new AD(A0A(89, 39, 21));
        }
        throw new AD(A0A(50, 39, 120));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0X(int r4) {
        /*
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0j
            if (r4 == r0) goto L79
            int r3 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A1L
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.YX.A0Y
            r0 = 2
            r1 = r1[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            r0 = 75
            if (r1 == r0) goto L1b
        L15:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.YX.A0Y
            java.lang.String r1 = "T3RhZdPh4OhUklIpt3KHsdu4Qu4SXFxX"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "T3RhZdPh4OhUklIpt3KHsdu4Qu4SXFxX"
            r0 = 2
            r2[r0] = r1
            if (r4 == r3) goto L79
            int r3 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0d
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.YX.A0Y
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 3
            if (r1 == r0) goto L58
            if (r4 == r3) goto L79
        L39:
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0h
            if (r4 == r0) goto L79
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A16
            if (r4 == r0) goto L79
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0i
            if (r4 == r0) goto L79
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A1K
            if (r4 == r0) goto L79
            int r3 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0m
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.YX.A0Y
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 1
            if (r1 == r0) goto L67
            goto L15
        L58:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.YX.A0Y
            java.lang.String r1 = "W"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "W"
            r0 = 0
            r2[r0] = r1
            if (r4 == r3) goto L79
            goto L39
        L67:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.YX.A0Y
            java.lang.String r1 = "P"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "P"
            r0 = 5
            r2[r0] = r1
            if (r4 == r3) goto L79
            int r0 = com.facebook.ads.redexgen.X.AbstractC1524Cb.A0N
            if (r4 != r0) goto L7b
        L79:
            r0 = 1
        L7a:
            return r0
        L7b:
            r0 = 0
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YX.A0X(int):boolean");
    }

    public static boolean A0Y(int i) {
        return i == AbstractC1524Cb.A0V || i == AbstractC1524Cb.A0c || i == AbstractC1524Cb.A0n || i == AbstractC1524Cb.A12 || i == AbstractC1524Cb.A1A || i == AbstractC1524Cb.A1H || i == AbstractC1524Cb.A1I || i == AbstractC1524Cb.A1J || i == AbstractC1524Cb.A1M || i == AbstractC1524Cb.A1N || i == AbstractC1524Cb.A0r || i == AbstractC1524Cb.A0u || i == AbstractC1524Cb.A0t || i == AbstractC1524Cb.A10 || i == AbstractC1524Cb.A1Q || i == AbstractC1524Cb.A0x || i == AbstractC1524Cb.A11 || i == AbstractC1524Cb.A0O || i == AbstractC1524Cb.A0f || i == AbstractC1524Cb.A0P;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0Z(com.facebook.ads.redexgen.X.CB r11) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YX.A0Z(com.facebook.ads.redexgen.X.CB):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    private boolean A0a(CB cb) throws InterruptedException, IOException {
        C1546Cx c1546CxA00;
        int iACw;
        int i = 4;
        int i2 = 1;
        int i3 = 0;
        if (this.A02 == 3) {
            if (this.A0D == null) {
                C1536Cn c1536CnA07 = A07(this.A0K);
                if (c1536CnA07 == null) {
                    int iA6t = (int) (this.A09 - cb.A6t());
                    if (iA6t >= 0) {
                        cb.ADZ(iA6t);
                        A0B();
                        return false;
                    }
                    throw new AD(A0A(346, 35, 12));
                }
                int iA6t2 = (int) (c1536CnA07.A07.A0G[c1536CnA07.A02] - cb.A6t());
                if (iA6t2 < 0) {
                    Log.w(A0A(128, 22, 14), A0A(150, 40, 24));
                    iA6t2 = 0;
                }
                cb.ADZ(iA6t2);
                this.A0D = c1536CnA07;
            }
            this.A06 = this.A0D.A07.A0D[this.A0D.A01];
            if (this.A0D.A01 < this.A0D.A03) {
                cb.ADZ(this.A06);
                this.A0D.A01();
                if (!this.A0D.A09()) {
                    this.A0D = null;
                }
                this.A02 = 3;
                return true;
            }
            C1536Cn c1536Cn = this.A0D;
            if (A0Y[3].length() != 6) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[3] = "st8dZG";
            strArr[3] = "st8dZG";
            if (c1536Cn.A05.A02 == 1) {
                this.A06 -= 8;
                cb.ADZ(8);
            }
            this.A04 = this.A0D.A04();
            this.A06 += this.A04;
            this.A02 = 4;
            this.A05 = 0;
        }
        C1547Cy c1547Cy = this.A0D.A07;
        C1545Cw c1545Cw = this.A0D.A05;
        CM cm = this.A0D.A06;
        int i4 = this.A0D.A01;
        long jA01 = c1547Cy.A01(i4) * 1000;
        IS is = this.A0S;
        if (is != null) {
            jA01 = is.A07(jA01);
        }
        if (c1545Cw.A01 == 0) {
            while (true) {
                int i5 = this.A04;
                int i6 = this.A06;
                if (i5 >= i6) {
                    break;
                }
                this.A04 += cm.ACw(cb, i6 - i5, false);
            }
        } else {
            byte[] bArr = this.A0Q.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i7 = c1545Cw.A01 + 1;
            int i8 = 4 - c1545Cw.A01;
            while (this.A04 < this.A06) {
                int i9 = this.A05;
                if (i9 == 0) {
                    cb.readFully(bArr, i8, i7);
                    this.A0Q.A0Z(i3);
                    this.A05 = this.A0Q.A0I() - i2;
                    this.A0R.A0Z(i3);
                    cm.ACx(this.A0R, i);
                    cm.ACx(this.A0Q, i2);
                    this.A0G = this.A0H.length > 0 && IC.A0D(c1545Cw.A07.A0O, bArr[i]);
                    this.A04 += 5;
                    this.A06 += i8;
                } else {
                    if (this.A0G) {
                        this.A0P.A0X(i9);
                        cb.readFully(this.A0P.A00, i3, this.A05);
                        cm.ACx(this.A0P, this.A05);
                        iACw = this.A05;
                        int iA02 = IC.A02(this.A0P.A00, this.A0P.A08());
                        this.A0P.A0Z(A0A(686, 10, 13).equals(c1545Cw.A07.A0O) ? 1 : 0);
                        this.A0P.A0Y(iA02);
                        GG.A04(jA01, this.A0P, this.A0H);
                    } else {
                        iACw = cm.ACw(cb, i9, false);
                    }
                    this.A04 += iACw;
                    this.A05 -= iACw;
                    i = 4;
                    i2 = 1;
                    i3 = 0;
                }
            }
        }
        boolean z = c1547Cy.A0I[i4];
        CL cl = null;
        int i10 = z;
        if (c1547Cy.A0A) {
            int i11 = (z ? 1 : 0) | FileTypeUtils.GIGABYTE;
            if (c1547Cy.A08 != null) {
                c1546CxA00 = c1547Cy.A08;
            } else {
                c1546CxA00 = c1545Cw.A00(c1547Cy.A07.A02);
            }
            cl = c1546CxA00.A01;
            i10 = i11;
        }
        cm.ACy(jA01, i10, this.A06, 0, cl);
        A0F(jA01);
        if (!this.A0D.A09()) {
            this.A0D = null;
        }
        this.A02 = 3;
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A0C = cc;
        C1545Cw c1545Cw = this.A0N;
        if (c1545Cw != null) {
            C1536Cn c1536Cn = new C1536Cn(cc.ADr(0, c1545Cw.A03));
            c1536Cn.A08(this.A0N, new C1530Ch(0, 0, 0, 0));
            this.A0K.put(0, c1536Cn);
            A0C();
            this.A0C.A54();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        while (true) {
            int i = this.A02;
            if (i != 0) {
                if (A0Y[2].charAt(18) != 'K') {
                    throw new RuntimeException();
                }
                String[] strArr = A0Y;
                strArr[2] = "Ub8SUYMnE0bQG8CZo0KwdlTNogw2mbM0";
                strArr[2] = "Ub8SUYMnE0bQG8CZo0KwdlTNogw2mbM0";
                if (i == 1) {
                    A0H(cb);
                } else if (i != 2) {
                    boolean zA0a = A0a(cb);
                    if (A0Y[7].charAt(27) == 'r') {
                        String[] strArr2 = A0Y;
                        strArr2[5] = "b";
                        strArr2[5] = "b";
                        if (zA0a) {
                            return 0;
                        }
                    } else if (zA0a) {
                        return 0;
                    }
                } else {
                    A0I(cb);
                }
            } else if (!A0Z(cb)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        int size = this.A0K.size();
        for (int i = 0; i < size; i++) {
            this.A0K.valueAt(i).A05();
        }
        this.A0U.clear();
        this.A03 = 0;
        this.A0A = j2;
        this.A0T.clear();
        A0B();
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        return C1543Cu.A04(cb);
    }
}
