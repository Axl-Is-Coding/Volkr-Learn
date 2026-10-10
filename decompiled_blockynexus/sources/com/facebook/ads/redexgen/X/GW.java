package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GW implements PB {
    public static String[] A06;

    @Nullable
    public ValueAnimator A00;
    public PA A01 = PA.A05;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    public static void A05() {
        A06 = new String[]{"Zp1jBMTXyTngXAjRlLP1q6RZbaUI", "nHljDkT3i8Wirocu51jroGsoJHOhv1cR", "sP6X6aS", "KZL6M4", "KoOjzqZIxieUbLbPf8D", "B1jmqrSafv9jI6Lw73IRSYcL6IlnF6YH", "FLN3m70EKIfdw8", "ppmNyXlbfQKy53gkSU0tUatt7Y3PBdXb"};
    }

    public GW(View view, int i, int i2, int i3) {
        this.A05 = view;
        this.A02 = i;
        this.A04 = i2;
        this.A03 = i3;
    }

    private ValueAnimator A00(View view, int i, int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(this.A02);
        valueAnimatorOfInt.addUpdateListener(new PK(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            if (A06[1].charAt(28) != 'v') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[7] = "75AaLozsvbqC7RPKNa9MBDOQqsQ1eQ5U";
            strArr[5] = "oWQ9IgFva7oIaP1s8z2NxAvwjcynmKEe";
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z) {
        if (z) {
            this.A01 = PA.A06;
            this.A00 = A00(this.A05, this.A03, this.A04);
            this.A00.addListener(new PJ(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A04);
        LX.A0K(this.A05);
        this.A01 = PA.A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(boolean z) {
        LX.A0O(this.A05);
        if (z) {
            this.A01 = PA.A04;
            this.A00 = A00(this.A05, this.A04, this.A03);
            this.A00.addListener(new PI(this));
            this.A00.start();
            return;
        }
        View view = this.A05;
        if (A06[1].charAt(28) != 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[4] = "CRQ3If4kF9c";
        strArr[4] = "CRQ3If4kF9c";
        view.setTranslationY(this.A03);
        this.A01 = PA.A03;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void A3O(boolean z, boolean z2) {
        if (z2) {
            A09(z);
        } else {
            A0A(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final PA A78() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void cancel() {
        ValueAnimator valueAnimator = this.A00;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
