package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7m, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7m extends C1717Jy {
    public int A00;
    public boolean A01;
    public final C9A<C7l> A02;
    public final C9A<C14257j> A03;
    public final C9A<C1703Jk> A04;
    public final C9A<C14247i> A05;
    public final C9A<IM> A06;
    public final C9A<IE> A07;
    public final C9A<ID> A08;
    public final C9A<C1660Hp> A09;
    public final C9A<C1655Hk> A0A;
    public final LU A0B;
    public final J8 A0C;
    public final AbstractC1661Hq A0D;

    public C7m(C2026Wb c2026Wb, J5 j5, LU lu, String str) {
        this(c2026Wb, j5, lu, new ArrayList(), str);
    }

    public C7m(C2026Wb c2026Wb, J5 j5, LU lu, String str, @Nullable Bundle bundle) {
        this(c2026Wb, j5, lu, new ArrayList(), str, bundle, null);
    }

    public C7m(C2026Wb c2026Wb, J5 j5, LU lu, String str, @Nullable Map<String, String> extraParams) {
        this(c2026Wb, j5, lu, new ArrayList(), str, null, extraParams);
    }

    public C7m(C2026Wb c2026Wb, J5 j5, LU lu, List<AbstractC12901z> list, String str) {
        super(c2026Wb, j5, lu, list, str, !lu.A0e());
        this.A0D = new AbstractC1661Hq() { // from class: com.facebook.ads.redexgen.X.7p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(I0 i0) {
                this.A00.A0a();
            }
        };
        this.A07 = new C1720Kb(this);
        this.A03 = new KP(this);
        this.A04 = new KO(this);
        this.A05 = new KM(this);
        this.A02 = new KI(this);
        this.A06 = new KF(this);
        this.A09 = new KD(this);
        this.A0A = new KB(this);
        this.A08 = new LR(this);
        this.A0C = new J8() { // from class: com.facebook.ads.redexgen.X.7q
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(JA ja) {
                C7m c7m = this.A00;
                c7m.A00 = c7m.A0B.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = lu;
        this.A0B.getEventBus().A04(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A0C, this.A08);
    }

    public C7m(C2026Wb c2026Wb, J5 j5, LU lu, List<AbstractC12901z> list, String str, @Nullable Bundle bundle, @Nullable Map<String, String> map) {
        super(c2026Wb, j5, lu, list, str, !lu.A0e(), bundle, map);
        this.A0D = new AbstractC1661Hq() { // from class: com.facebook.ads.redexgen.X.7p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(I0 i0) {
                this.A00.A0a();
            }
        };
        this.A07 = new C1720Kb(this);
        this.A03 = new KP(this);
        this.A04 = new KO(this);
        this.A05 = new KM(this);
        this.A02 = new KI(this);
        this.A06 = new KF(this);
        this.A09 = new KD(this);
        this.A0A = new KB(this);
        this.A08 = new LR(this);
        this.A0C = new J8() { // from class: com.facebook.ads.redexgen.X.7q
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(JA ja) {
                C7m c7m = this.A00;
                c7m.A00 = c7m.A0B.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = lu;
        this.A0B.getEventBus().A04(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A08);
    }

    public final void A0h() {
        this.A0B.getStateHandler().post(new C1736Ku(this));
    }
}
