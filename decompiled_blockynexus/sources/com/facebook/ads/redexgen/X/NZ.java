package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.Button;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NZ extends Button {
    public static final int A0B = (int) (LX.A01 * 16.0f);
    public static final int A0C = (int) (LX.A01 * 4.0f);
    public int A00;
    public int A01;
    public C1G A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final float A06;
    public final int A07;
    public final Runnable A08;
    public final Runnable A09;
    public final Runnable A0A;

    public NZ(C2026Wb c2026Wb, C1G c1g) {
        super(c2026Wb);
        this.A03 = false;
        this.A01 = 0;
        this.A00 = 0;
        this.A04 = true;
        this.A05 = false;
        this.A08 = new C2031Wg(this);
        this.A0A = new C2030Wf(this);
        this.A09 = new C2029We(this);
        this.A02 = c1g;
        this.A07 = C1693Iy.A03(c2026Wb);
        this.A06 = C1693Iy.A00(c2026Wb);
        LX.A0b(this, false, 16);
        setGravity(17);
        A04();
    }

    private void A04() {
        C1G c1g = this.A02;
        if (c1g != null) {
            this.A00 = c1g.A08(this.A05);
            this.A01 = this.A02.A09(this.A05);
        }
        LX.A0S(this, this.A00, this.A04 ? A0C : 0);
        setTextColor(this.A01);
    }

    private void A05() {
        if (this.A07 < 0 || !C1693Iy.A1P(getContext()) || this.A03) {
            return;
        }
        this.A03 = true;
        if (C1693Iy.A1X(getContext()) && Build.VERSION.SDK_INT >= 16) {
            postDelayed(this.A08, this.A07);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A05();
    }

    public void setRoundedCornersEnabled(boolean z) {
        this.A04 = z;
        A04();
    }

    public void setText(String str) {
        super.setText((CharSequence) str.toUpperCase(Locale.US));
    }

    public void setUpButtonColors(C1G c1g) {
        this.A02 = c1g;
        A04();
    }

    public void setViewShowsOverMedia(boolean z) {
        this.A05 = z;
        A04();
    }
}
