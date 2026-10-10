package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class NT extends LinearLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final C2026Wb A02;
    public final ViewOnClickListenerC2033Wi A03;
    public final C1794Nb A04;
    public static final LinearLayout.LayoutParams A06 = new LinearLayout.LayoutParams(-2, -2);
    public static final int A05 = (int) (LX.A01 * 8.0f);

    public abstract void A0D(int i);

    public abstract void A0E(boolean z);

    public NT(C2026Wb c2026Wb, int i, C1G c1g, String str, J5 j5, InterfaceC1767Lz interfaceC1767Lz, C1849Pe c1849Pe, LQ lq) {
        super(c2026Wb);
        LX.A0N(this);
        this.A02 = c2026Wb;
        this.A00 = i;
        this.A04 = new C1794Nb(c2026Wb);
        LX.A0P(this.A04, 0);
        LX.A0N(this.A04);
        this.A03 = new ViewOnClickListenerC2033Wi(c2026Wb, str, c1g, j5, interfaceC1767Lz, c1849Pe, lq);
        LX.A0J(1001, this.A03);
        this.A01 = new RelativeLayout(c2026Wb);
        this.A01.setLayoutParams(A06);
        LX.A0N(this.A01);
    }

    public int A09(int i) {
        return 0;
    }

    public RelativeLayout.LayoutParams A0B(View view) {
        return new RelativeLayout.LayoutParams(-1, -2);
    }

    public RelativeLayout.LayoutParams A0C(View view) {
        return new RelativeLayout.LayoutParams(-1, -2);
    }

    public final ViewOnClickListenerC2033Wi getCTAButton() {
        return this.A03;
    }

    public View getExpandableLayout() {
        return null;
    }

    @VisibleForTesting
    public final ImageView getIconView() {
        return this.A04;
    }

    public void setInfo(C1F c1f, C1H c1h, String str, String str2, @Nullable NW nw) {
        this.A03.setCta(c1h, str, new HashMap(), nw);
        AsyncTaskC2037Wm asyncTaskC2037Wm = new AsyncTaskC2037Wm(this.A04, this.A02);
        int i = this.A00;
        asyncTaskC2037Wm.A06(i, i).A08(str2);
    }
}
