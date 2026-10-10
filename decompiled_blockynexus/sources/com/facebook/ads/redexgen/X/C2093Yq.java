package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2093Yq implements DT {
    public static byte[] A02;
    public static String[] A03;
    public final int A00;
    public final List<Format> A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-120, -105, -105, -109, -112, -118, -120, -101, -112, -106, -107, 86, -118, -116, -120, 84, 93, 87, 95, -114, -99, -99, -103, -106, -112, -114, -95, -106, -100, -101, 92, -112, -110, -114, 90, 100, 93, 101};
    }

    public static void A03() {
        A03 = new String[]{"ggGLmhyInJSffjkfPU8VRn", "WisLA7DCjwWBxH7MqLlw8w9Z4gicIVYK", "baeaQjGS5RYnakDSUMD4HiL2ABi7hiKM", "QvfNkpkg0VH", "dkSLNeeU5ck3Twa6KyaCdOuwvlu7l8iW", "e6Ade", "C9ShSy7zMtGRXyHgR8PAzFWulvZi4KLP", "w2lskP6GH6NJyN70rzATNYjf2L9mjjHA"};
    }

    public C2093Yq() {
        this(0);
    }

    public C2093Yq(int i) {
        this(i, Collections.emptyList());
    }

    public C2093Yq(int i, List<Format> list) {
        this.A00 = i;
        if (!A04(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.A00(null, A01(0, 19, 33), 0, null));
        }
        this.A01 = list;
    }

    private DP A00(DS ds) {
        String strA01;
        int i;
        if (A04(32)) {
            return new DP(this.A01);
        }
        IG ig = new IG(ds.A03);
        List<Format> arrayList = this.A01;
        while (true) {
            int iA05 = ig.A05();
            String[] strArr = A03;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[6] = "9wGqNU4xey1NmHgGithGb88lbeAMl0Qa";
            strArr2[5] = "Me3yU";
            if (iA05 > 0) {
                int descriptorLength = ig.A0F();
                int descriptorTag = ig.A0F();
                int iA07 = ig.A07() + descriptorTag;
                if (descriptorLength == 134) {
                    arrayList = new ArrayList<>();
                    int nextDescriptorPosition = ig.A0F();
                    int i2 = nextDescriptorPosition & 31;
                    for (int accessibilityChannel = 0; accessibilityChannel < i2; accessibilityChannel++) {
                        String strA0T = ig.A0T(3);
                        int iA0F = ig.A0F();
                        int captionTypeByte = iA0F & 128;
                        int captionTypeByte2 = captionTypeByte != 0 ? 1 : 0;
                        if (captionTypeByte2 != 0) {
                            strA01 = A01(19, 19, 39);
                            i = iA0F & 63;
                        } else {
                            strA01 = A01(0, 19, 33);
                            i = 1;
                        }
                        arrayList.add(Format.A08(null, strA01, null, -1, 0, strA0T, i, null));
                        ig.A0a(2);
                    }
                }
                ig.A0Z(iA07);
            } else {
                return new DP(arrayList);
            }
        }
    }

    private boolean A04(int i) {
        return (this.A00 & i) != 0;
    }

    @Override // com.facebook.ads.redexgen.X.DT
    public final SparseArray<DV> A4J() {
        return new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.X.DT
    public final DV A4O(int i, DS ds) {
        if (i == 2) {
            return new C2102Yz(new C2096Yt());
        }
        if (i == 3 || i == 4) {
            return new C2102Yz(new C2101Yy(ds.A01));
        }
        if (i == 15) {
            if (A04(2)) {
                return null;
            }
            return new C2102Yz(new C2092Yp(false, ds.A01));
        }
        if (i == 17) {
            if (A04(2)) {
                return null;
            }
            return new C2102Yz(new C2100Yx(ds.A01));
        }
        if (i == 21) {
            return new C2102Yz(new C2099Yw());
        }
        if (i == 27) {
            if (A04(4)) {
                return null;
            }
            return new C2102Yz(new C2097Yu(A00(ds), A04(1), A04(8)));
        }
        if (i == 36) {
            return new C2102Yz(new C2098Yv(A00(ds)));
        }
        if (i != 89) {
            if (i != 138) {
                if (i != 129) {
                    if (i != 130) {
                        if (A03[7].charAt(7) != 'G') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[2] = "XLjLYE0qXOuIs9WeBuWhNfn9nKSLWrdd";
                        strArr[2] = "XLjLYE0qXOuIs9WeBuWhNfn9nKSLWrdd";
                        if (i == 134) {
                            if (A04(16)) {
                                return null;
                            }
                            return new Z2(new Z3());
                        }
                        if (i != 135) {
                            return null;
                        }
                    }
                }
                return new C2102Yz(new C2089Ym(ds.A01));
            }
            return new C2102Yz(new C2094Yr(ds.A01));
        }
        return new C2102Yz(new C2095Ys(ds.A02));
    }
}
