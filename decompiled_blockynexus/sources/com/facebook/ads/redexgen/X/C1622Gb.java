package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1622Gb implements PB {
    public int A00;

    @Nullable
    public ValueAnimator A01;
    public PA A02 = PA.A05;
    public final int A03;
    public final int A04;
    public final View A05;

    public C1622Gb(View view, int i, int i2, int i3) {
        this.A05 = view;
        this.A03 = i;
        this.A00 = i2;
        this.A04 = i3;
    }

    private ValueAnimator A00(int i, int i2, View view) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(this.A03);
        valueAnimatorOfInt.addUpdateListener(new PE(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z) {
        if (z) {
            this.A02 = PA.A06;
            this.A01 = A00(this.A00, this.A04, this.A05);
            this.A01.addListener(new PD(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        LX.A0K(this.A05);
        this.A02 = PA.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z) {
        LX.A0O(this.A05);
        if (z) {
            this.A02 = PA.A04;
            this.A01 = A00(this.A04, this.A00, this.A05);
            this.A01.addListener(new PC(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = PA.A03;
    }

    public final void A09(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void A3O(boolean z, boolean z2) {
        if (z2) {
            A07(z);
        } else {
            A08(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final PA A78() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void cancel() {
        ValueAnimator valueAnimator = this.A01;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
