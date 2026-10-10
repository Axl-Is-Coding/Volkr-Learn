package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.71, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass71 extends AbstractC1716Jx {
    public final Paint A00;
    public final C2026Wb A01;

    @Nullable
    public final JC A02;
    public final AbstractC1714Jv A03;
    public final AbstractC1708Jp A04;
    public final AbstractC1696Jb A05;
    public final P9 A06;

    public AnonymousClass71(C2026Wb c2026Wb, boolean z, @Nullable JC jc) {
        super(c2026Wb);
        this.A04 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.7F
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                this.A00.A06.setChecked(true);
            }
        };
        this.A05 = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.7E
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                this.A00.A06.setChecked(false);
            }
        };
        this.A03 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.7D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                this.A00.A06.setChecked(true);
            }
        };
        this.A02 = jc;
        this.A01 = c2026Wb;
        this.A06 = new P9(c2026Wb, z);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 23.76d), (int) (((double) displayMetrics.density) * 23.76d));
        layoutParams.addRule(13);
        this.A06.setLayoutParams(layoutParams);
        this.A06.setChecked(true);
        this.A06.setClickable(false);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        if (z) {
            this.A00.setColor(-1728053248);
        } else {
            this.A00.setColor(-1);
            this.A00.setAlpha(204);
        }
        LX.A0P(this, 0);
        addView(this.A06);
        setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 72.0d), (int) (((double) displayMetrics.density) * 72.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A04, this.A05, this.A03);
        }
        setOnClickListener(new P6(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A08() {
        setOnClickListener(null);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A03, this.A05, this.A04);
        }
        super.A08();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int centerX = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        canvas.drawCircle(getPaddingLeft() + r4, getPaddingTop() + (centerX / 2), centerX / 2, this.A00);
        super.onDraw(canvas);
    }
}
