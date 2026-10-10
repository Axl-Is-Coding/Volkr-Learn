package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OM extends LinearLayout {
    public static final int A04 = (int) (LX.A01 * 32.0f);
    public static final int A05 = (int) (LX.A01 * 8.0f);
    public TextView A00;
    public TextView A01;
    public C1794Nb A02;
    public final C2026Wb A03;

    public OM(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A03 = c2026Wb;
        A00(c2026Wb);
    }

    private final void A00(C2026Wb c2026Wb) {
        setGravity(16);
        this.A02 = new C1794Nb(c2026Wb);
        this.A02.setFullCircleCorners(true);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.setMargins(0, 0, A05, 0);
        addView(this.A02, layoutParams);
        LinearLayout linearLayout = new LinearLayout(c2026Wb);
        linearLayout.setOrientation(1);
        this.A00 = new TextView(c2026Wb);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LX.A0b(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(c2026Wb);
        LX.A0b(this.A01, false, 14);
        linearLayout.addView(this.A00);
        linearLayout.addView(this.A01);
        addView(linearLayout, layoutParams2);
    }

    public final void A01(int i, int i2) {
        this.A00.setTextColor(i);
        this.A01.setTextColor(i2);
    }

    public void setPageDetails(C1P c1p) {
        AsyncTaskC2037Wm asyncTaskC2037Wm = new AsyncTaskC2037Wm(this.A02, this.A03);
        int i = A04;
        asyncTaskC2037Wm.A06(i, i);
        asyncTaskC2037Wm.A08(c1p.A01());
        this.A00.setText(c1p.A02());
        this.A01.setText(c1p.A03());
    }
}
