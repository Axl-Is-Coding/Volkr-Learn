package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T6 implements InterfaceC12761l {
    public static byte[] A03;
    public C5A A00;
    public C2026Wb A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{59, 52, 33, 60, 35, 48, 100, 127, 122, 127, 126, 102, 127};
    }

    public T6(C5A c5a, C2026Wb c2026Wb, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = c5a;
        this.A01 = c2026Wb;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12761l
    public final void A9p(C1697Jd c1697Jd) {
        KK.A00(new T3(this, c1697Jd));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12761l
    public final void AAb(List<RD> list) {
        AnonymousClass77 anonymousClass77 = new AnonymousClass77(this.A01);
        String strA02 = A02(6, 7, 70);
        for (RD rd : list) {
            if (A02(6, 7, 70).equals(strA02)) {
                strA02 = rd.A0R();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (rd.A0K() != null) {
                    anonymousClass77.A0R(new AnonymousClass74(rd.A0K().getUrl(), rd.A0K().getHeight(), rd.A0K().getWidth(), rd.A0R(), A02(0, 6, 2)));
                }
                if (rd.A0J() != null) {
                    anonymousClass77.A0R(new AnonymousClass74(rd.A0J().getUrl(), rd.A0J().getHeight(), rd.A0J().getWidth(), rd.A0R(), A02(0, 6, 2)));
                }
                if (!TextUtils.isEmpty(rd.A0T())) {
                    anonymousClass77.A0W(new AnonymousClass76(rd.A0T(), rd.A0R(), A02(0, 6, 2), rd.A0N().longValue()));
                }
            }
        }
        anonymousClass77.A0Q(new T5(this, list), new AnonymousClass70(strA02, A02(0, 6, 2)));
    }
}
