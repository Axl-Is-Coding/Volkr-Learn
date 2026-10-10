package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NS extends AnonymousClass42<C1770Mc> {
    public static final int A05 = (int) (LX.A01 * 250.0f);
    public int A00 = 0;
    public boolean A01 = false;
    public final int A02;
    public final C2026Wb A03;
    public final List<String> A04;

    public NS(C2026Wb c2026Wb, List<String> list, int i) {
        this.A04 = list;
        this.A02 = i;
        this.A03 = c2026Wb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C1770Mc A07(ViewGroup viewGroup, int i) {
        return new C1770Mc(new NB(this.A03));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0F(C1770Mc c1770Mc, int startSpacing) {
        int i;
        int i2;
        String str = this.A04.get(startSpacing);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        if (this.A00 == 2 && this.A01) {
            i = A05;
        } else {
            int leftMargin = this.A02;
            i = leftMargin * 4;
        }
        if (startSpacing != 0) {
            i = this.A02;
        }
        int leftMargin2 = A0E();
        if (startSpacing >= leftMargin2 - 1) {
            int leftMargin3 = this.A02;
            i2 = leftMargin3 * 4;
        } else {
            i2 = this.A02;
        }
        marginLayoutParams.setMargins(i, 0, i2, 0);
        c1770Mc.A0m().setLayoutParams(marginLayoutParams);
        c1770Mc.A0m().A00(str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    public final int A0E() {
        return this.A04.size();
    }

    public final void A0G(int i, boolean z) {
        this.A00 = i;
        this.A01 = z;
    }
}
