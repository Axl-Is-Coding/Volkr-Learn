package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1873Qc extends NG {
    public final /* synthetic */ C1872Qb A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1873Qc(C1872Qb c1872Qb, C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A00 = c1872Qb;
        getSettings().setAllowFileAccess(true);
    }

    @Override // com.facebook.ads.redexgen.X.NG
    public final WebChromeClient A0C() {
        return new O5(this.A00, null);
    }

    @Override // com.facebook.ads.redexgen.X.NG
    public final WebViewClient A0D() {
        return new O6(this.A00, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.A00.A0C.A07(motionEvent, this, this);
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }
}
