package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class RM extends AnonymousClass42<C2105Zc> {
    public static final int A05 = (int) (LX.A01 * 4.0f);

    @Nullable
    public AnonymousClass14 A00;
    public final List<C2213bT> A01;
    public final int A02;
    public final C2026Wb A03;

    @DoNotStrip
    public final AbstractC1848Pd A04 = new RK(this);

    public RM(C1T c1t, List<C2213bT> list, C2026Wb c2026Wb) {
        this.A03 = c2026Wb;
        this.A02 = c1t.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A04(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i2 = this.A02;
        if (i == 0) {
            i2 *= 2;
        }
        marginLayoutParams.setMargins(i2, 0, i >= this.A01.size() + (-1) ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    public final int A0E() {
        return this.A01.size();
    }

    public final void A0G(ImageView imageView, int i) {
        C2213bT c2213bT = this.A01.get(i);
        JQ adCoverImage = c2213bT.getAdCoverImage();
        if (adCoverImage != null) {
            AsyncTaskC2037Wm asyncTaskC2037WmA05 = new AsyncTaskC2037Wm(imageView, this.A03).A05();
            asyncTaskC2037WmA05.A07(new RL(this, i, c2213bT));
            asyncTaskC2037WmA05.A08(adCoverImage.getUrl());
        }
    }

    public final void A0H(AnonymousClass14 anonymousClass14) {
        this.A00 = anonymousClass14;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public void A0F(C2105Zc c2105Zc, int i) {
        c2105Zc.A0m().setLayoutParams(A04(i));
    }
}
