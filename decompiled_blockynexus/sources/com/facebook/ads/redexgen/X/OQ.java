package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OQ extends FrameLayout {
    public static final int A07 = (int) (LX.A01 * 16.0f);
    public C14619d A00;

    @Nullable
    public C7m A01;
    public HI A02;
    public C7Q A03;
    public AnonymousClass71 A04;
    public final C2026Wb A05;
    public final JC A06;

    public OQ(C2026Wb c2026Wb, JC jc) {
        super(c2026Wb);
        this.A06 = jc;
        this.A05 = c2026Wb;
        setUpView(c2026Wb);
    }

    public final void A01() {
        A0b(true, 10);
    }

    public final void A02() {
        C7m c7m = this.A01;
        if (c7m != null) {
            c7m.A0h();
            this.A01 = null;
        }
    }

    public final void A03(C9A c9a) {
        getEventBus().A06(c9a);
    }

    public final void A04(J5 j5, String str, Map<String, String> extraParams) {
        A02();
        this.A01 = new C7m(this.A05, j5, this.A00, str, extraParams);
    }

    public final void A05(EnumC1834Op enumC1834Op) {
        A0Y(enumC1834Op, 13);
    }

    public final boolean A06() {
        return A0h();
    }

    @VisibleForTesting
    public LU getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A03.setImage(str);
    }

    private void setUpPlugins(C2026Wb c2026Wb) {
        A0U();
        this.A03 = new C7Q(c2026Wb);
        A0Z(this.A03);
        this.A02 = new HI(c2026Wb, this.A06);
        A0Z(new C7Y(c2026Wb));
        A0Z(this.A02);
        this.A04 = new AnonymousClass71(c2026Wb, true, this.A06);
        A0Z(this.A04);
        A0Z(new HK(this.A04, P1.A03, true, true));
        if (!A0d()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i = A07;
        layoutParams.setMargins(i, i, i, i);
        this.A02.setLayoutParams(layoutParams);
        addView(this.A02);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.9d] */
    private void setUpVideo(final C2026Wb c2026Wb) {
        this.A00 = new LU(c2026Wb) { // from class: com.facebook.ads.redexgen.X.9d
            @Override // android.widget.RelativeLayout, android.view.View
            public final void onMeasure(int newHeightSpec, int i) {
                if (View.MeasureSpec.getMode(newHeightSpec) == 1073741824) {
                    i = newHeightSpec;
                } else if (View.MeasureSpec.getMode(i) == 1073741824) {
                    newHeightSpec = i;
                }
                super.onMeasure(newHeightSpec, i);
            }
        };
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LX.A0N(this.A00);
        addView(this.A00);
        setOnClickListener(new OP(this));
    }

    private void setUpView(C2026Wb c2026Wb) {
        setUpVideo(c2026Wb);
        setUpPlugins(c2026Wb);
    }

    public void setVideoURI(String str) {
        setVideoURI(str);
    }

    public void setVolume(float f2) {
        setVolume(f2);
        this.A02.A0A();
    }
}
