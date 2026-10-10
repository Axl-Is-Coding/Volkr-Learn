package com.facebook.ads.redexgen.X;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RT implements InterfaceC14166z {
    public final C1R A00;
    public final InterfaceC12701f A01;
    public final AnonymousClass77 A02;
    public final C2026Wb A03;
    public final boolean A04;

    public RT(C2026Wb c2026Wb, InterfaceC12701f interfaceC12701f, AnonymousClass77 anonymousClass77, C1R c1r, boolean z) {
        this.A03 = c2026Wb;
        this.A01 = interfaceC12701f;
        this.A02 = anonymousClass77;
        this.A00 = c1r;
        this.A04 = z;
    }

    public /* synthetic */ RT(C2026Wb c2026Wb, InterfaceC12701f interfaceC12701f, AnonymousClass77 anonymousClass77, C1R c1r, boolean z, C12691e c12691e) {
        this(c2026Wb, interfaceC12701f, anonymousClass77, c1r, z);
    }

    private void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new C12711g(this.A00, this.A01, this.A04));
        webView.loadUrl(this.A00.A0F());
    }

    private void A01(boolean z) {
        if (this.A00.A0A() == C1S.A05) {
            A00();
            return;
        }
        String strA0F = this.A00.A0F();
        if (z) {
            strA0F = this.A02.A0L(this.A00.A0F());
        }
        this.A00.A0H(strA0F);
        this.A01.AAl();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9P() {
        if (this.A04) {
            this.A01.AAk(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9W() {
        A01(true);
    }
}
