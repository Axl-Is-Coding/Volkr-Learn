package com.facebook.ads.redexgen.X;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AH extends AbstractC2145aL {
    public static byte[] A02;
    public static String[] A03;
    public static final int[] A04;

    @Nullable
    public final InterfaceC1642Gx A00;
    public final AtomicReference<DefaultTrackSelector$Parameters> A01;

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        if (A03[6].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "oTI";
        strArr[6] = "oTI";
        A02 = new byte[]{-26, -33, -43};
    }

    public static void A0F() {
        A03 = new String[]{"1W0E1A", "gmqFy6ZQaP5ka1WITOse6lKCqSKhRNov", "yPEYbIXQTZij2dUvfHyn6qa5Z66I89l5", "Xhoxo0MeXbgag07m9diWTgmUhgioDUlF", "BIkkp", "x2Y7ova5yP2MY4Z3NAONKiEwX", "ON8", "BctZyAj3hw00k98sEs0CoZ2k5"};
    }

    static {
        A0F();
        A0E();
        A04 = new int[0];
    }

    public AH() {
        this((InterfaceC1642Gx) null);
    }

    public AH(@Nullable InterfaceC1642Gx interfaceC1642Gx) {
        this.A00 = interfaceC1642Gx;
        this.A01 = new AtomicReference<>(DefaultTrackSelector$Parameters.A0J);
    }

    public static int A00(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public static int A01(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static int A03(TrackGroup trackGroup, int[] iArr, int i, @Nullable String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            Integer num = list.get(i6);
            if (A03[2].charAt(31) == 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[7] = "3Iv8b3o73oRbqkF65Z5c5dFgz";
            strArr[5] = "e7BsWd0zc9qEfvrmMSkcTfHGf";
            int iIntValue = num.intValue();
            if (A0M(trackGroup.A02(iIntValue), str, iArr[iIntValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    public static int A04(TrackGroup trackGroup, int[] iArr, C1635Go c1635Go) {
        int i = 0;
        for (int i2 = 0; i2 < trackGroup.A01; i2++) {
            if (A0K(trackGroup.A02(i2), iArr[i2], c1635Go)) {
                i++;
            }
        }
        return i;
    }

    public static Point A05(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) != (i > i2)) {
                i = i2;
                i2 = i;
            }
        }
        int tempViewportWidth = i3 * i2;
        int i5 = i4 * i;
        if (A03[2].charAt(31) == 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "nfw";
        strArr[6] = "nfw";
        if (tempViewportWidth >= i5) {
            return new Point(i, IW.A04(i * i4, i3));
        }
        return new Point(IW.A04(i2 * i3, i4), i2);
    }

    @Nullable
    private final InterfaceC1643Gy A06(int i, TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C14789u {
        TrackGroup trackGroup = null;
        int trackIndex = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = trackGroupArray.A01;
            if (A03[3].charAt(2) == 'E') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "VerUiBJDpf251zcJKkmQW7r5SVlKN9oM";
            strArr[3] = "VerUiBJDpf251zcJKkmQW7r5SVlKN9oM";
            if (i3 < i4) {
                TrackGroup trackGroupA02 = trackGroupArray.A02(i3);
                int[] iArr2 = iArr[i3];
                for (int i5 = 0; i5 < trackGroupA02.A01; i5++) {
                    if (A0I(iArr2[i5], defaultTrackSelector$Parameters.A0B)) {
                        int i6 = (trackGroupA02.A02(i5).A0D & 1) != 0 ? 2 : 1;
                        if (A0I(iArr2[i5], false)) {
                            i6 += 1000;
                        }
                        if (i6 > i2) {
                            trackGroup = trackGroupA02;
                            trackIndex = i5;
                            i2 = i6;
                        }
                    }
                }
                i3++;
            } else {
                if (trackGroup == null) {
                    return null;
                }
                return new AG(trackGroup, trackIndex);
            }
        }
    }

    @Nullable
    public static InterfaceC1643Gy A07(TrackGroupArray trackGroupArray, int[][] iArr, int requiredAdaptiveSupport, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, InterfaceC1642Gx interfaceC1642Gx) throws C14789u {
        int i;
        if (defaultTrackSelector$Parameters.A0A) {
            i = 24;
        } else {
            i = 16;
        }
        boolean z = defaultTrackSelector$Parameters.A09 && (requiredAdaptiveSupport & i) != 0;
        for (int i2 = 0; i2 < trackGroupArray.A01; i2++) {
            TrackGroup trackGroupA02 = trackGroupArray.A02(i2);
            int[] iArrA0P = A0P(trackGroupA02, iArr[i2], z, i, defaultTrackSelector$Parameters.A03, defaultTrackSelector$Parameters.A02, defaultTrackSelector$Parameters.A01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            if (iArrA0P.length > 0) {
                return ((InterfaceC1642Gx) C1662Hr.A01(interfaceC1642Gx)).A4T(trackGroupA02, iArrA0P);
            }
        }
        return null;
    }

    @Nullable
    private final InterfaceC1643Gy A08(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, @Nullable InterfaceC1642Gx interfaceC1642Gx) throws C14789u {
        int trackIndex = -1;
        int i2 = -1;
        C1636Gp trackScore = null;
        for (int i3 = 0; i3 < trackGroupArray.A01; i3++) {
            TrackGroup trackGroupA02 = trackGroupArray.A02(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < trackGroupA02.A01; i4++) {
                if (A0I(iArr2[i4], defaultTrackSelector$Parameters.A0B)) {
                    C1636Gp c1636Gp = new C1636Gp(trackGroupA02.A02(i4), defaultTrackSelector$Parameters, iArr2[i4]);
                    if (trackScore == null || c1636Gp.A01(trackScore) > 0) {
                        i2 = i3;
                        trackIndex = i4;
                        trackScore = c1636Gp;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        TrackGroup trackGroupA022 = trackGroupArray.A02(i2);
        if (!defaultTrackSelector$Parameters.A0D && interfaceC1642Gx != null) {
            int[] iArrA0O = A0O(trackGroupA022, iArr[i2], defaultTrackSelector$Parameters.A09);
            if (iArrA0O.length > 0) {
                return interfaceC1642Gx.A4T(trackGroupA022, iArrA0O);
            }
        }
        return new AG(trackGroupA022, trackIndex);
    }

    @Nullable
    private final InterfaceC1643Gy A09(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, @Nullable InterfaceC1642Gx interfaceC1642Gx) throws C14789u {
        InterfaceC1643Gy interfaceC1643GyA07 = null;
        if (!defaultTrackSelector$Parameters.A0D && interfaceC1642Gx != null) {
            interfaceC1643GyA07 = A07(trackGroupArray, iArr, i, defaultTrackSelector$Parameters, interfaceC1642Gx);
        }
        if (interfaceC1643GyA07 == null) {
            return A0A(trackGroupArray, iArr, defaultTrackSelector$Parameters);
        }
        return interfaceC1643GyA07;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r1 <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        if (r3 <= r2) goto L26;
     */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0021 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d9 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.InterfaceC1643Gy A0A(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r19, int[][] r20, com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters r21) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AH.A0A(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray, int[][], com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.facebook.ads.redexgen.X.Gy");
    }

    @Nullable
    private final InterfaceC1643Gy A0B(TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C14789u {
        int i;
        int i2;
        TrackGroup trackGroup = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroupArray.A01; i5++) {
            TrackGroup trackGroupA02 = trackGroupArray.A02(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < trackGroupA02.A01; i6++) {
                if (A0I(iArr2[i6], defaultTrackSelector$Parameters.A0B)) {
                    Format formatA02 = trackGroupA02.A02(i6);
                    int i7 = formatA02.A0D & (defaultTrackSelector$Parameters.A00 ^ (-1));
                    boolean z = (i7 & 1) != 0;
                    boolean z2 = (i7 & 2) != 0;
                    boolean zA0L = A0L(formatA02, defaultTrackSelector$Parameters.A08);
                    if (zA0L || (defaultTrackSelector$Parameters.A0E && A0J(formatA02))) {
                        if (z) {
                            i = 8;
                        } else if (!z2) {
                            i = 6;
                        } else {
                            i = 4;
                        }
                        i2 = i + (zA0L ? 1 : 0);
                    } else if (z) {
                        i2 = 3;
                    } else if (!z2) {
                        continue;
                    } else if (A0L(formatA02, defaultTrackSelector$Parameters.A07)) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    if (A0I(iArr2[i6], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i4) {
                        trackGroup = trackGroupA02;
                        i3 = i6;
                        if (A03[6].length() != 3) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[2] = "ytO6VNlSXI4nyu5127ZVkMBSWij4cMOM";
                        strArr[2] = "ytO6VNlSXI4nyu5127ZVkMBSWij4cMOM";
                        i4 = i2;
                    } else {
                        continue;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new AG(trackGroup, i3);
    }

    public static List<Integer> A0D(TrackGroup trackGroup, int i, int maxVideoPixelsToRetain, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.A01);
        for (int i2 = 0; i2 < trackGroup.A01; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (i == Integer.MAX_VALUE || maxVideoPixelsToRetain == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < trackGroup.A01; i4++) {
            Format formatA02 = trackGroup.A02(i4);
            if (formatA02.A0F > 0) {
                int i5 = formatA02.A08;
                if (A03[3].charAt(2) == 'E') {
                    throw new RuntimeException();
                }
                String[] strArr = A03;
                strArr[2] = "kSz4FX5ZHsEkHeXGD1Cn3cbmsF2hLdtD";
                strArr[2] = "kSz4FX5ZHsEkHeXGD1Cn3cbmsF2hLdtD";
                if (i5 > 0) {
                    Point pointA05 = A05(z, i, maxVideoPixelsToRetain, formatA02.A0F, formatA02.A08);
                    int i6 = formatA02.A0F * formatA02.A08;
                    int videoPixels = formatA02.A0F;
                    if (videoPixels >= ((int) (pointA05.x * 0.98f))) {
                        int videoPixels2 = formatA02.A08;
                        if (videoPixels2 >= ((int) (pointA05.y * 0.98f)) && i6 < i3) {
                            i3 = i6;
                        }
                    }
                }
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int iA0F = trackGroup.A02(((Integer) arrayList.get(size)).intValue()).A0F();
                if (iA0F == -1 || iA0F > i3) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    public static void A0G(TrackGroup trackGroup, int[] iArr, int trackIndex, @Nullable String str, int i, int i2, int i3, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!A0M(trackGroup.A02(iIntValue), str, iArr[iIntValue], trackIndex, i, i2, i3)) {
                list.remove(size);
            }
        }
    }

    public static void A0H(C1641Gw c1641Gw, int[][][] iArr, AT[] atArr, InterfaceC1643Gy[] interfaceC1643GyArr, int rendererType) {
        if (rendererType == 0) {
            return;
        }
        int i = -1;
        int i2 = -1;
        if (A03[1].charAt(3) != 'F') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[4] = "rTjwD";
        strArr[0] = "uX38vm";
        boolean z = true;
        int i3 = 0;
        while (true) {
            if (i3 >= c1641Gw.A00()) {
                break;
            }
            int iA01 = c1641Gw.A01(i3);
            InterfaceC1643Gy interfaceC1643Gy = interfaceC1643GyArr[i3];
            if ((iA01 == 1 || iA01 == 2) && interfaceC1643Gy != null && A0N(iArr[i3], c1641Gw.A02(i3), interfaceC1643Gy)) {
                if (iA01 == 1) {
                    if (i != -1) {
                        z = false;
                        break;
                    }
                    i = i3;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i3;
                }
            }
            i3++;
        }
        boolean z2 = z & ((i == -1 || i2 == -1) ? false : true);
        if (A03[3].charAt(2) != 'E') {
            String[] strArr2 = A03;
            strArr2[4] = "aY4hR";
            strArr2[0] = "2v7HMH";
            if (!z2) {
                return;
            }
        } else if (!z2) {
            return;
        }
        AT at = new AT(rendererType);
        atArr[i] = at;
        atArr[i2] = at;
    }

    public static boolean A0I(int i, boolean z) {
        int maskedSupport = i & 7;
        return maskedSupport == 4 || (z && maskedSupport == 3);
    }

    public static boolean A0J(Format format) {
        return TextUtils.isEmpty(format.A0N) || A0L(format, A0C(0, 3, 21));
    }

    public static boolean A0K(Format format, int i, C1635Go c1635Go) {
        if (A0I(i, false) && format.A05 == c1635Go.A00 && format.A0C == c1635Go.A01) {
            return c1635Go.A02 == null || TextUtils.equals(c1635Go.A02, format.A0O);
        }
        return false;
    }

    public static boolean A0L(Format format, @Nullable String str) {
        return str != null && TextUtils.equals(str, IW.A0L(format.A0N));
    }

    public static boolean A0M(Format format, @Nullable String str, int i, int i2, int i3, int i4, int i5) {
        if (!A0I(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !IW.A0h(format.A0O, str)) {
            return false;
        }
        if (format.A0F != -1 && format.A0F > i3) {
            return false;
        }
        if (format.A08 != -1 && format.A08 > i4) {
            return false;
        }
        if (format.A04 != -1) {
            int i6 = format.A04;
            if (A03[2].charAt(31) == 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "FNCbzyr7QyRP3SA06TqNXuxS80zpa9Bi";
            strArr[2] = "FNCbzyr7QyRP3SA06TqNXuxS80zpa9Bi";
            if (i6 > i5) {
                return false;
            }
        }
        return true;
    }

    public static boolean A0N(int[][] iArr, TrackGroupArray trackGroupArray, InterfaceC1643Gy interfaceC1643Gy) {
        if (interfaceC1643Gy == null) {
            return false;
        }
        int iA01 = trackGroupArray.A01(interfaceC1643Gy.A7F());
        if (A03[2].charAt(31) == 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "tyUFTMgWRFIbU9oMa0yVOFtav5LFL8C4";
        strArr[1] = "tyUFTMgWRFIbU9oMa0yVOFtav5LFL8C4";
        for (int i = 0; i < interfaceC1643Gy.length(); i++) {
            if ((iArr[iA01][interfaceC1643Gy.A6V(i)] & 32) != 32) {
                return false;
            }
        }
        if (A03[2].charAt(31) != 'o') {
            String[] strArr2 = A03;
            strArr2[4] = "AvWfp";
            strArr2[0] = "jnm8oH";
            return true;
        }
        String[] strArr3 = A03;
        strArr3[3] = "hBflC2WcQfSqXI4XtpzFNLmvHBtesKLi";
        strArr3[3] = "hBflC2WcQfSqXI4XtpzFNLmvHBtesKLi";
        return true;
    }

    public static int[] A0O(TrackGroup trackGroup, int[] iArr, boolean z) {
        int iA04;
        int i = 0;
        C1635Go c1635Go = null;
        HashSet hashSet = new HashSet();
        int configurationCount = 0;
        while (true) {
            if (configurationCount < trackGroup.A01) {
                Format formatA02 = trackGroup.A02(configurationCount);
                C1635Go c1635Go2 = new C1635Go(formatA02.A05, formatA02.A0C, z ? null : formatA02.A0O);
                String[] strArr = A03;
                if (strArr[4].length() == strArr[0].length()) {
                    break;
                }
                String[] strArr2 = A03;
                strArr2[6] = "SWl";
                strArr2[6] = "SWl";
                if (hashSet.add(c1635Go2) && (iA04 = A04(trackGroup, iArr, c1635Go2)) > i) {
                    c1635Go = c1635Go2;
                    i = iA04;
                }
                configurationCount++;
            } else if (i > 1) {
                int[] adaptiveIndices = new int[i];
                if (A03[1].charAt(3) == 'F') {
                    String[] strArr3 = A03;
                    strArr3[2] = "ndqJYBN4kzCrcISGfJ6gLQAVvTseYRAq";
                    strArr3[2] = "ndqJYBN4kzCrcISGfJ6gLQAVvTseYRAq";
                    int index = 0;
                    for (int i2 = 0; i2 < trackGroup.A01; i2++) {
                        if (A0K(trackGroup.A02(i2), iArr[i2], (C1635Go) C1662Hr.A01(c1635Go))) {
                            adaptiveIndices[index] = i2;
                            index++;
                        }
                    }
                    return adaptiveIndices;
                }
            } else {
                return A04;
            }
        }
        throw new RuntimeException();
    }

    public static int[] A0P(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int trackIndex, int i4, int i5, boolean z2) {
        int iA03;
        if (trackGroup.A01 >= 2) {
            List<Integer> listA0D = A0D(trackGroup, i4, i5, z2);
            if (listA0D.size() < 2) {
                return A04;
            }
            String str = null;
            if (!z) {
                HashSet hashSet = new HashSet();
                int i6 = 0;
                for (int selectedMimeTypeTrackCount = 0; selectedMimeTypeTrackCount < listA0D.size(); selectedMimeTypeTrackCount++) {
                    String str2 = trackGroup.A02(listA0D.get(selectedMimeTypeTrackCount).intValue()).A0O;
                    if (hashSet.add(str2) && (iA03 = A03(trackGroup, iArr, i, str2, i2, i3, trackIndex, listA0D)) > i6) {
                        if (A03[3].charAt(2) == 'E') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[7] = "YYn4Z0UW1tJYYEwj5MQ7L1Rhi";
                        strArr[5] = "BvRHCOG0R11gnbm1vcetrlVSM";
                        str = str2;
                        i6 = iA03;
                    }
                }
            }
            A0G(trackGroup, iArr, i, str, i2, i3, trackIndex, listA0D);
            return listA0D.size() < 2 ? A04 : IW.A0k(listA0D);
        }
        return A04;
    }

    private final InterfaceC1643Gy[] A0Q(C1641Gw c1641Gw, int[][][] iArr, int[] iArr2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C14789u {
        boolean z;
        int iA00 = c1641Gw.A00();
        InterfaceC1643Gy[] interfaceC1643GyArr = new InterfaceC1643Gy[iA00];
        boolean seenVideoRendererWithMappedTracks = false;
        int i = 0;
        for (int i2 = 0; i2 < iA00; i2++) {
            int iA01 = c1641Gw.A01(i2);
            if (A03[2].charAt(31) == 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "HeTTodjeOHNf6YJV3Oi2xZW4zDR7myJi";
            strArr[2] = "HeTTodjeOHNf6YJV3Oi2xZW4zDR7myJi";
            if (2 == iA01) {
                if (i == 0) {
                    z = true;
                    interfaceC1643GyArr[i2] = A09(c1641Gw.A02(i2), iArr[i2], iArr2[i2], defaultTrackSelector$Parameters, this.A00);
                    i = interfaceC1643GyArr[i2] != null ? 1 : 0;
                } else {
                    z = true;
                }
                if (c1641Gw.A02(i2).A01 <= 0) {
                    z = false;
                }
                seenVideoRendererWithMappedTracks |= z;
            }
        }
        boolean z2 = false;
        int i3 = 0;
        if (A03[3].charAt(2) == 'E') {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "aVwUyHxCeGesw16VUIJPDtFnHPxsnnXC";
        strArr2[2] = "aVwUyHxCeGesw16VUIJPDtFnHPxsnnXC";
        for (int i4 = 0; i4 < iA00; i4++) {
            int iA012 = c1641Gw.A01(i4);
            if (iA012 != 1) {
                if (iA012 != 2) {
                    if (iA012 != 3) {
                        interfaceC1643GyArr[i4] = A06(iA012, c1641Gw.A02(i4), iArr[i4], defaultTrackSelector$Parameters);
                    } else if (i3 == 0) {
                        interfaceC1643GyArr[i4] = A0B(c1641Gw.A02(i4), iArr[i4], defaultTrackSelector$Parameters);
                        i3 = interfaceC1643GyArr[i4] != null ? 1 : 0;
                    }
                }
            } else if (!z2) {
                interfaceC1643GyArr[i4] = A08(c1641Gw.A02(i4), iArr[i4], iArr2[i4], defaultTrackSelector$Parameters, seenVideoRendererWithMappedTracks ? null : this.A00);
                z2 = interfaceC1643GyArr[i4] != null;
            }
        }
        return interfaceC1643GyArr;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC2145aL
    public final Pair<AT[], InterfaceC1643Gy[]> A0X(C1641Gw c1641Gw, int[][][] iArr, int[] iArr2) throws C14789u {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = this.A01.get();
        int i = c1641Gw.A00();
        InterfaceC1643Gy[] interfaceC1643GyArrA0Q = A0Q(c1641Gw, iArr, iArr2, defaultTrackSelector$Parameters);
        for (int i2 = 0; i2 < i; i2++) {
            if (defaultTrackSelector$Parameters.A07(i2)) {
                interfaceC1643GyArrA0Q[i2] = null;
            } else {
                TrackGroupArray trackGroupArrayA02 = c1641Gw.A02(i2);
                if (defaultTrackSelector$Parameters.A08(i2, trackGroupArrayA02)) {
                    DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverrideA06 = defaultTrackSelector$Parameters.A06(i2, trackGroupArrayA02);
                    if (defaultTrackSelector$SelectionOverrideA06 == null) {
                        interfaceC1643GyArrA0Q[i2] = null;
                    } else if (defaultTrackSelector$SelectionOverrideA06.A01 == 1) {
                        interfaceC1643GyArrA0Q[i2] = new AG(trackGroupArrayA02.A02(defaultTrackSelector$SelectionOverrideA06.A00), defaultTrackSelector$SelectionOverrideA06.A02[0]);
                    } else {
                        interfaceC1643GyArrA0Q[i2] = ((InterfaceC1642Gx) C1662Hr.A01(this.A00)).A4T(trackGroupArrayA02.A02(defaultTrackSelector$SelectionOverrideA06.A00), defaultTrackSelector$SelectionOverrideA06.A02);
                    }
                }
            }
        }
        AT[] atArr = new AT[i];
        for (int i3 = 0; i3 < i; i3++) {
            atArr[i3] = !defaultTrackSelector$Parameters.A07(i3) && (c1641Gw.A01(i3) == 5 || interfaceC1643GyArrA0Q[i3] != null) ? AT.A01 : null;
        }
        A0H(c1641Gw, iArr, atArr, interfaceC1643GyArrA0Q, defaultTrackSelector$Parameters.A04);
        return Pair.create(atArr, interfaceC1643GyArrA0Q);
    }
}
