package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class R2 extends AbstractC12430e {
    public static byte[] A02;
    public static String[] A03;
    public final C12500l A00;
    public final boolean A01;

    static {
        A0C();
        A0B();
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 30);
            if (A03[3].charAt(0) != '7') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "PWjD";
            strArr[5] = "PWjD";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A02 = new byte[]{93, 114, 119, 125, 117, 62, 114, 113, 121, 121, 123, 122, 71, 68, 70, 78, 122, 81, 76, 72, 64, 22, 31, 27, 12, 31, 37, ci.l, 19, 23, 31, 45, 55, 54, 33, 45, 47, 39};
    }

    public static void A0C() {
        A03 = new String[]{"1", "OJ2IOsbUnCKybSqk53zM3JXcifahO", "e4RldewFXKwYCBzcZ5CwWZ5XjhlRHNiJ", "729G42gqUNiz5ZAUAxRhvFZ2YWMhTd0L", "J1Ql0tv9onNfDvsMKNTgjNyaDa6Pnzub", "9fBm", "mbPUpspz4Nj5AFGqwEe2w9x9WWs", "2uSYGuFAJgr"};
    }

    public abstract void A0E();

    public R2(C2026Wb c2026Wb, J5 j5, String str, @Nullable C12500l c12500l, boolean z) {
        super(c2026Wb, j5, str);
        this.A00 = c12500l;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12430e
    public final void A0D() {
        C12500l c12500l = this.A00;
        if (c12500l != null) {
            c12500l.A08(this.A02);
        }
        A0E();
    }

    public final void A0F(Map<String, String> userReturnDataMap, @Nullable EnumC12420d enumC12420d) {
        if (!TextUtils.isEmpty(this.A02)) {
            if (this instanceof C1590Et) {
                super.A01.A8b(this.A02, userReturnDataMap);
            } else {
                J5 j5 = super.A01;
                String str = this.A02;
                if (A03[6].length() != 8) {
                    String[] strArr = A03;
                    strArr[6] = "4hYdj7INWre5bef3R1byHGHBMmQCX";
                    strArr[6] = "4hYdj7INWre5bef3R1byHGHBMmQCX";
                    j5.A8O(str, userReturnDataMap);
                } else {
                    String[] strArr2 = A03;
                    strArr2[5] = "IMSq";
                    strArr2[5] = "IMSq";
                    j5.A8O(str, userReturnDataMap);
                }
            }
            boolean zA02 = EnumC12420d.A02(enumC12420d);
            if (A03[1].length() == 32) {
                throw new RuntimeException();
            }
            String[] strArr3 = A03;
            strArr3[0] = "X";
            strArr3[0] = "X";
            C12500l c12500l = this.A00;
            if (c12500l != null) {
                c12500l.A07(enumC12420d);
                if (zA02) {
                    this.A00.A06();
                }
            } else {
                HashMap map = new HashMap();
                map.put(A0A(21, 10, 100), Long.toString(-1L));
                map.put(A0A(12, 9, 59), Long.toString(-1L));
                map.put(A0A(31, 7, 92), EnumC12420d.A03.name());
                super.A01.A8e(this.A02, map);
            }
        }
        C1733Kr.A02(super.A00, A0A(0, 12, 0));
    }
}
