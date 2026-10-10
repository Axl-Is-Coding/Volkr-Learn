package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ed, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1576Ed {
    public final H9 A00;
    public final HB A01;
    public final HB A02;
    public final InterfaceC1646Hb A03;
    public final IK A04;

    public C1576Ed(InterfaceC1646Hb interfaceC1646Hb, HB hb) {
        this(interfaceC1646Hb, hb, null, null, null);
    }

    public C1576Ed(InterfaceC1646Hb interfaceC1646Hb, HB hb, @Nullable HB hb2, @Nullable H9 h9, @Nullable IK ik) {
        C1662Hr.A01(hb);
        this.A03 = interfaceC1646Hb;
        this.A02 = hb;
        this.A01 = hb2;
        this.A00 = h9;
        this.A04 = ik;
    }

    public final InterfaceC1646Hb A00() {
        return this.A03;
    }

    public final C2176aq A01(boolean z) {
        HC cacheReadDataSource;
        HA c2174ao;
        HB hb = this.A01;
        if (hb != null) {
            cacheReadDataSource = hb.A4D();
        } else {
            cacheReadDataSource = new C2158aY();
        }
        if (z) {
            return new C2176aq(this.A03, C2157aX.A02, cacheReadDataSource, null, 1, null);
        }
        H9 h9 = this.A00;
        if (h9 != null) {
            c2174ao = h9.createDataSink();
        } else {
            c2174ao = new C2174ao(this.A03, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        }
        HC hcA4D = this.A02.A4D();
        IK ik = this.A04;
        if (ik != null) {
            hcA4D = new C2168ai(hcA4D, ik, -1000);
        }
        return new C2176aq(this.A03, hcA4D, cacheReadDataSource, c2174ao, 1, null);
    }

    public final IK A02() {
        IK ik = this.A04;
        return ik != null ? ik : new IK();
    }
}
