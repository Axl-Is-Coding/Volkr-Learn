package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SV extends AbstractC13383y {
    public SV(C4E c4e) {
        super(c4e, null);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A06() {
        return this.A02.A0i();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A07() {
        return this.A02.A0i() - this.A02.A0g();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A08() {
        return this.A02.A0g();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A09() {
        return this.A02.A0j();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0A() {
        return this.A02.A0f();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0B() {
        return (this.A02.A0i() - this.A02.A0f()) - this.A02.A0g();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0C(View view) {
        return this.A02.A0o(view) + ((C4F) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0D(View view) {
        C4F c4f = (C4F) view.getLayoutParams();
        return this.A02.A0n(view) + c4f.leftMargin + c4f.rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0E(View view) {
        C4F c4f = (C4F) view.getLayoutParams();
        return this.A02.A0m(view) + c4f.topMargin + c4f.bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0F(View view) {
        return this.A02.A0l(view) - ((C4F) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0G(View view) {
        this.A02.A1F(view, true, this.A01);
        return this.A01.right;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final int A0H(View view) {
        this.A02.A1F(view, true, this.A01);
        return this.A01.left;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC13383y
    public final void A0J(int i) {
        this.A02.A10(i);
    }
}
