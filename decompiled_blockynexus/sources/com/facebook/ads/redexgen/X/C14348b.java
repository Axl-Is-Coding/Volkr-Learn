package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14348b extends QW {

    @Nullable
    public AbstractC1803Nk A00;
    public final InterfaceC13584s A01;
    public final AtomicBoolean A02;
    public final AtomicBoolean A03;
    public final AtomicBoolean A04;

    public C14348b(C2026Wb c2026Wb, MU mu, J5 j5, AnonymousClass15 anonymousClass15, AnonymousClass77 anonymousClass77, InterfaceC1767Lz interfaceC1767Lz) {
        super(c2026Wb, mu, j5, anonymousClass15, anonymousClass77, interfaceC1767Lz);
        this.A01 = new QV(this);
        this.A03 = new AtomicBoolean(false);
        this.A02 = new AtomicBoolean(false);
        this.A04 = new AtomicBoolean(false);
    }

    private AbstractC1803Nk A01(int i) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new AsyncTaskC2037Wm(imageView, super.A03).A06(super.A01.A0M().A0E().A00(), super.A01.A0M().A0E().A01()).A07(new QT(this)).A08(super.A01.A0M().A0E().A07());
        return C1804Nl.A00(new C1806Nn(super.A03, super.A04, this.A08, super.A01, imageView, this.A0A, this.A06).A0D(this.A07.getToolbarHeight()).A0F(this.A07).A0C(i).A0H(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A03.get() && this.A02.get()) {
            A0Q();
        }
    }

    private void A06(int i) {
        LX.A0M(this.A00);
        this.A00 = A01(i);
        C1G colors = this.A00.getColors();
        AbstractC1803Nk abstractC1803Nk = this.A00;
        LX.A0P(this, colors.A07(abstractC1803Nk != null && (abstractC1803Nk.A0b() || (this.A00 instanceof Sf))));
        this.A07.A05(colors, this.A00.A0b());
        addView(this.A00, 0, QW.A0D);
        AbstractC1803Nk abstractC1803Nk2 = this.A00;
        setUpFullscreenMode(abstractC1803Nk2 != null && abstractC1803Nk2.A0b());
    }

    @Override // com.facebook.ads.redexgen.X.QW
    public final void A0R() {
        LX.A0O(this.A00);
        LX.A0O(this.A07);
        this.A02.set(true);
        A05();
        int iA03 = super.A01.A0M().A0E().A03();
        if (iA03 > 0) {
            AbstractC1803Nk abstractC1803Nk = this.A00;
            if (abstractC1803Nk != null) {
                abstractC1803Nk.A0Z();
            }
            A0S(iA03, new QU(this));
            return;
        }
        this.A04.set(true);
        this.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.QW
    public final void A0T(C13604u c13604u) {
        c13604u.A0L(this.A01);
        A06(c13604u.A0I().getResources().getConfiguration().orientation);
        addView(this.A07, new FrameLayout.LayoutParams(-1, this.A07.getToolbarHeight()));
        LX.A0K(this.A00);
        LX.A0K(this.A07);
    }

    @Override // com.facebook.ads.redexgen.X.QW
    public final boolean A0U() {
        AbstractC1803Nk abstractC1803Nk = this.A00;
        return abstractC1803Nk != null && abstractC1803Nk.A0c(false);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (abstractC1803Nk != null) {
            return abstractC1803Nk.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.QW, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A01.A0M().A0M()) {
            A06(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QW, com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        AbstractC1803Nk abstractC1803Nk = this.A00;
        if (abstractC1803Nk != null) {
            abstractC1803Nk.A0V();
        }
        super.onDestroy();
    }
}
