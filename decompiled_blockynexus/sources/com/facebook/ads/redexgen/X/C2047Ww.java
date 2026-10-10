package com.facebook.ads.redexgen.X;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ww, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2047Ww extends KT {
    public static byte[] A03;
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ C2027Wc A01;
    public final /* synthetic */ MultithreadedBundleWrapper A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{91, 108, 99, 40, 123, 125, 107, 107, 109, 123, 123, 110, 125, 100, 100, 113, 40, 97, 102, 97, 124, 97, 105, 100, 97, 114, 109, 108, 41};
    }

    public C2047Ww(C2027Wc c2027Wc, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener) {
        this.A01 = c2027Wc;
        this.A02 = multithreadedBundleWrapper;
        this.A00 = initListener;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        try {
            XA.A02().A0D(this.A01);
            if (!C14538v.A06.get() && C1693Iy.A12(this.A01)) {
                AnonymousClass94.A04(this.A01, this.A02);
            }
        } catch (Throwable th) {
            this.A01.A04().A3S(th);
        }
        C14538v.A0E(this.A01);
        AudienceNetworkAds.InitListener initListener = this.A00;
        if (initListener != null) {
            C14538v.A06(initListener, new C14528u(true, A00(0, 29, 0)));
        }
    }
}
