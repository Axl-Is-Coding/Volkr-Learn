package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1738Kw {
    public static String[] A05;
    public float A00;
    public boolean A01;
    public boolean A02;
    public final Handler A03;
    public final InterfaceC1737Kv A04;

    static {
        A02();
    }

    public static void A02() {
        A05 = new String[]{"AKWVUs1l0Ice5I6VX", "CXPBWDMo1Zqj2yCW5W30Ut48PEWYgYey", "QYYsUNIn7qky9LY", "uhDWqwwqE26XK4rQkizWNR4dlHqM4UZ3", "ZNpftHLPxc7R9PnANzOwdg7R2ap4pSI6", "3ke", "xa09Mpjas6OdUQMP5Qo7kdS83JfCqy78", "u6CBuCaaqyjpN4LkQhRqLLvzhKEDnG9S"};
    }

    public C1738Kw(int i, InterfaceC1737Kv interfaceC1737Kv) {
        this(i, interfaceC1737Kv, new Handler());
    }

    @VisibleForTesting
    public C1738Kw(int i, InterfaceC1737Kv interfaceC1737Kv, Handler handler) {
        this.A02 = false;
        this.A00 = i;
        this.A04 = interfaceC1737Kv;
        this.A03 = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        this.A00 -= 0.25f;
        this.A04.AAv(this.A00);
        if (this.A00 <= WheelView.DividerConfig.FILL) {
            boolean z = this.A01;
            if (A05[4].charAt(25) == 'L') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[6] = "KuCOx1ArmKJG2Js90Y8iwcXaowa3uSzZ";
            strArr[6] = "KuCOx1ArmKJG2Js90Y8iwcXaowa3uSzZ";
            if (!z) {
                this.A01 = true;
                this.A04.A9V();
                this.A02 = false;
            }
        }
    }

    public final float A04() {
        return this.A00;
    }

    public final boolean A05() {
        return this.A00 <= WheelView.DividerConfig.FILL;
    }

    public final boolean A06() {
        return this.A02;
    }

    public final boolean A07() {
        if (!A06()) {
            return false;
        }
        this.A02 = false;
        return true;
    }

    public final boolean A08() {
        if (A05() && !this.A01) {
            this.A01 = true;
            this.A04.A9V();
        }
        if (!A05() && !A06()) {
            this.A02 = true;
            this.A04.AAv(this.A00);
            this.A03.postDelayed(new C2144aK(this), 250L);
            return true;
        }
        if (A05[4].charAt(25) == 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "u6tCNg8GXSpiTqjQspDcQdpU9nt4kRaX";
        strArr[7] = "uRN5Zlx2bfjM01c7Y9BPyYrHFfBp2TpI";
        return false;
    }
}
