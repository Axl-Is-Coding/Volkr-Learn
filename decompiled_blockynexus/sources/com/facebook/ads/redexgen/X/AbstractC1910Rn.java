package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1910Rn implements InterfaceC12891y {
    public static byte[] A05;
    public final InterfaceC12791o A00;
    public final C2026Wb A01;
    public final String A02 = UUID.randomUUID().toString();
    public final Handler A03;
    public final InterfaceC12841t A04;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-65, -46, -53, -63, -55, -62, -36, -62, -43, -47, -49, -66, -48, -36, -56, -62, -42, -46, -41, -35, -24, -50, -37, -37, -40, -37, -24, -52, -40, -51, -50, -24, -44, -50, -30, -83, -82, -84, -71, -101, -98, -71, -93, -98, -71, -91, -97, -77, -24, -23, -25, -12, -38, -25, -25, -28, -25, -12, -30, -38, -24, -24, -42, -36, -38, -12, -32, -38, -18};
    }

    public abstract void A05();

    public AbstractC1910Rn(C2026Wb c2026Wb, InterfaceC12851u interfaceC12851u) {
        this.A01 = c2026Wb;
        DynamicLoaderFactory.makeLoader(this.A01).getInitApi().onAdLoadInvoked(this.A01);
        this.A00 = new C1907Rk(c2026Wb, this);
        this.A03 = new Handler(Looper.getMainLooper());
        this.A04 = interfaceC12851u.A4L(this.A00, this);
    }

    public final void A04() {
        if (!C1693Iy.A0l(this.A01)) {
            return;
        }
        LS.A00(new C1909Rm(this));
    }

    public final void A06(int i, AdErrorType adErrorType, @Nullable String str) {
        Bundle bundle = new Bundle();
        String strA02 = A02(48, 21, 113);
        if (str != null) {
            bundle.putString(strA02, str);
        } else {
            bundle.putString(strA02, adErrorType.getDefaultErrorMessage());
        }
        bundle.putInt(A02(17, 18, 101), adErrorType.getErrorCode());
        AAW(i, this.A02, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12891y
    public final void AAW(int i, String str, @Nullable Bundle bundle) {
        Message messageObtain = Message.obtain((Handler) null, i);
        messageObtain.getData().putString(A02(35, 13, 54), str);
        if (bundle != null) {
            messageObtain.getData().putBundle(A02(0, 17, 89), bundle);
        }
        this.A03.post(new C1908Rl(this, messageObtain));
    }
}
