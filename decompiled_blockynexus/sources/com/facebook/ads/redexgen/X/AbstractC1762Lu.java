package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1762Lu extends LinearLayout {
    public static int A00 = (int) (LX.A01 * 56.0f);

    public abstract void A05(C1G c1g, boolean z);

    public abstract boolean A07();

    public abstract int getToolbarHeight();

    public abstract void setAdReportingVisible(boolean z);

    public abstract void setPageDetails(C1P c1p, String str, int i, C1W c1w);

    public abstract void setPageDetailsVisible(boolean z);

    public abstract void setProgress(float f2);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(@ToolbarActionView$ToolbarActionMode int i);

    public abstract void setToolbarListener(InterfaceC1761Lt interfaceC1761Lt);

    public AbstractC1762Lu(Context context) {
        super(context);
    }

    public void A06(MJ mj) {
    }
}
