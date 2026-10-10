package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1768Ma {
    public static String[] A00;
    public static final int A01;
    public static final int A02;
    public static final int A03;

    public static void A03() {
        A00 = new String[]{"Mh7OQPY25mJ4xZdJdnJU4lIWxnSb2W80", "uMvQGqYS2R9kLiwAhxbB5gyg9uPLoFmG", "JD8RnvPxGeaTxsc34jN0O6vhnDfoaLvm", "v", "yiVoJ6", "bh6EDcFJy1WMlrC6ew5uNV", "HsXTYL", "k"};
    }

    static {
        A03();
        A01 = (int) (LX.A01 * 200.0f);
        A03 = (int) (LX.A01 * 200.0f);
        A02 = (int) (LX.A01 * 50.0f);
    }

    public static EnumC12640z A00(@Nullable NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return EnumC12640z.A05;
        }
        if (A04(nativeAdLayout)) {
            return EnumC12640z.A06;
        }
        return EnumC12640z.A04;
    }

    @Nullable
    public static MZ A01(C2026Wb c2026Wb, J5 j5, String str, @Nullable NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return null;
        }
        int width = nativeAdLayout.getWidth();
        int height = nativeAdLayout.getHeight();
        int i = A01;
        if (width >= i && height >= i) {
            return new XO(c2026Wb, j5, str);
        }
        if (width < A03 || height < A02) {
            return null;
        }
        return new XR(c2026Wb, j5, str);
    }

    public static MZ A02(C2026Wb c2026Wb, J5 j5, String str, C1P c1p, M0 m0, InterfaceC1767Lz interfaceC1767Lz) {
        return new XV(c2026Wb, j5, str, c1p, m0, interfaceC1767Lz);
    }

    public static boolean A04(NativeAdLayout nativeAdLayout) {
        int h = nativeAdLayout.getWidth();
        int w = nativeAdLayout.getHeight();
        int i = A01;
        if (h < i || w < i) {
            if (h >= A03) {
                int i2 = A02;
                if (A00[5].length() != 22) {
                    throw new RuntimeException();
                }
                String[] strArr = A00;
                strArr[5] = "hhrIY4o6fKEkU42z4UVpb3";
                strArr[5] = "hhrIY4o6fKEkU42z4UVpb3";
                if (w < i2) {
                }
            }
            return true;
        }
        return false;
    }
}
