package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1623Gc implements PB {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public PA A02 = PA.A05;

    public C1623Gc(View view, int i, Drawable drawable, Drawable drawable2) {
        this.A03 = i;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        this.A01 = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01.setCrossFadeEnabled(true);
        this.A00 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00.setCrossFadeEnabled(true);
        LX.A0W(this.A07, this.A01);
    }

    private void A04(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = PA.A06;
            LX.A0W(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new C1624Gd(this), this.A03);
            return;
        }
        LX.A0W(this.A07, this.A05);
        this.A02 = PA.A05;
    }

    private void A05(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = PA.A04;
            LX.A0W(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new C1634Gn(this), this.A03);
            return;
        }
        LX.A0W(this.A07, this.A04);
        this.A02 = PA.A03;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void A3O(boolean z, boolean z2) {
        if (z2) {
            A04(z);
        } else {
            A05(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final PA A78() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.PB
    public final void cancel() {
        PA pa;
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        if (this.A02 == PA.A04) {
            pa = PA.A05;
        } else {
            pa = PA.A03;
        }
        this.A02 = pa;
    }
}
