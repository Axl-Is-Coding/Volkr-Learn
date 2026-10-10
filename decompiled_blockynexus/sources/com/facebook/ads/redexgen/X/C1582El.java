package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.El, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1582El extends RM {
    public final C2026Wb A00;

    public C1582El(C1T c1t, List<C2213bT> list, C2026Wb c2026Wb) {
        super(c1t, list, c2026Wb);
        this.A00 = c2026Wb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2105Zc A07(ViewGroup viewGroup, int i) {
        return new C2105Zc(new M5(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.RM, com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A0I */
    public final void A0F(C2105Zc c2105Zc, int i) {
        super.A0F(c2105Zc, i);
        M5 m5 = (M5) c2105Zc.A0m();
        MK mk = (MK) m5.getImageCardView();
        mk.setImageDrawable(null);
        A0G(mk, i);
        C2213bT c2213bT = ((RM) this).A01.get(i);
        c2213bT.A0x().A0D(this.A00);
        c2213bT.A1G(m5, m5);
    }
}
