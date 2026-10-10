package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13765k implements BidderTokenProviderApi {
    public static byte[] A03;
    public static final AtomicBoolean A04;
    public C2027Wc A00;
    public String A01;

    @VisibleForTesting
    public final L9 A02 = new L9(300000000000L, new TJ(this));

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 5);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{-100, -87, -100, -89, -86, -94, 112, 103, 118, 121, 113, 116, 109, -127, 118, 123, 114, 103, 119, 105, 119, 119, 109, 115, 114, -125, 120, 109, 113, 105};
    }

    static {
        A04();
        A04 = new AtomicBoolean(false);
    }

    public static InterfaceC14578z A00(C2027Wc c2027Wc) {
        return C1693Iy.A0q(c2027Wc) ? AnonymousClass90.A01(A01(0, 6, 86), A01(18, 12, 31), A01(6, 12, 29)) : AnonymousClass90.A00();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C2027Wc c2027Wc;
        synchronized (this) {
            c2027Wc = this.A00;
        }
        if (c2027Wc == null) {
            return;
        }
        String strA7A = AnonymousClass92.A00().A01(c2027Wc, true).A7A(A00(c2027Wc));
        synchronized (this) {
            this.A01 = strA7A;
        }
    }

    public static void A03() {
        A04.set(true);
    }

    public final void A06() {
        this.A02.A05();
    }

    @Override // com.facebook.ads.internal.api.BidderTokenProviderApi
    public final synchronized String getBidderToken(Context context) {
        this.A00 = AnonymousClass50.A07(context);
        DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
        if (XA.A02().A0B(this.A00).ADS() || ((A04.get() && C1693Iy.A18(this.A00)) || this.A01 == null)) {
            A02();
            this.A02.A04().A03();
            A04.set(false);
        }
        this.A02.A06();
        return this.A01;
    }
}
