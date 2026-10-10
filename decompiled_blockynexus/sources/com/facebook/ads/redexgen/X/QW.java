package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class QW extends FrameLayout implements M0 {
    public static final RelativeLayout.LayoutParams A0D = new RelativeLayout.LayoutParams(-1, -1);
    public boolean A00;
    public final AnonymousClass15 A01;
    public final AnonymousClass77 A02;
    public final C2026Wb A03;
    public final J5 A04;
    public final JC A05;
    public final LQ A06;
    public final AbstractC1762Lu A07;
    public final InterfaceC1767Lz A08;
    public final MU A09;
    public final C1849Pe A0A;
    public final LL A0B;

    @DoNotStrip
    public final AbstractC1848Pd A0C;

    public abstract void A0R();

    public abstract void A0T(C13604u c13604u);

    public abstract boolean A0U();

    public QW(C2026Wb c2026Wb, MU mu, J5 j5, AnonymousClass15 anonymousClass15, AnonymousClass77 anonymousClass77, InterfaceC1767Lz interfaceC1767Lz) {
        super(c2026Wb);
        this.A0C = new C1871Qa(this);
        this.A06 = new LQ();
        this.A00 = false;
        this.A03 = c2026Wb;
        this.A09 = mu;
        this.A04 = j5;
        this.A01 = anonymousClass15;
        this.A02 = anonymousClass77;
        this.A08 = interfaceC1767Lz;
        this.A05 = new JC(this.A01.A0Q(), this.A04);
        this.A0A = new C1849Pe(this, 1, new WeakReference(this.A0C), this.A03);
        this.A0A.A0Y(this.A01.A0G());
        this.A0A.A0Z(this.A01.A0H());
        this.A07 = A0O();
        this.A0B = new LL(this);
        this.A0B.A05(LK.A03);
    }

    private AbstractC1762Lu A0O() {
        AbstractC1762Lu fullScreenAdToolbar;
        if (C1693Iy.A1T(this.A03)) {
            fullScreenAdToolbar = new C2112Zm(this.A03, this.A08, this.A05, 4, 2);
        } else {
            fullScreenAdToolbar = new FullScreenAdToolbar(this.A03, this.A08, this.A05, 1, this.A01.A0E());
        }
        int iA03 = this.A01.A0M().A0E().A03();
        fullScreenAdToolbar.setPageDetails(this.A01.A0O(), this.A01.A0Q(), iA03, this.A01.A0P());
        fullScreenAdToolbar.A05(this.A01.A0L().A01(), true);
        if (iA03 < 0 && this.A01.A0M().A0L()) {
            fullScreenAdToolbar.setToolbarActionMode(4);
        }
        fullScreenAdToolbar.setToolbarListener(new QX(this));
        return fullScreenAdToolbar;
    }

    private void A0P() {
        if (this.A01.A0M().A0O()) {
            OE oeA0B = new OC(this.A03, this.A01.A0M().A0F(), this.A01.A0O()).A08(this.A01.A0L().A01()).A0B();
            JE.A04(oeA0B, this.A05, JB.A0U);
            addView(oeA0B, A0D);
            oeA0B.A04(new QY(this));
            return;
        }
        A0R();
    }

    public final void A0Q() {
        if (!this.A00) {
            this.A0A.A0W();
            this.A00 = true;
        }
    }

    public final void A0S(int i, KT kt) {
        new C1738Kw(i, new QZ(this, i, kt)).A08();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, @Nullable Bundle bundle, C13604u c13604u) {
        this.A08.A3L(this, A0D);
        A0T(c13604u);
        A0P();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        this.A0B.A03();
        if (!TextUtils.isEmpty(this.A01.A0Q())) {
            this.A04.A8E(this.A01.A0Q(), new NQ().A04(this.A0A).A03(this.A06).A06());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A06.A07(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(InterfaceC1767Lz interfaceC1767Lz) {
    }

    public void setUpFullscreenMode(boolean z) {
        LK lk;
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (z) {
            lk = LK.A04;
        } else {
            lk = LK.A03;
        }
        this.A0B.A05(lk);
    }
}
