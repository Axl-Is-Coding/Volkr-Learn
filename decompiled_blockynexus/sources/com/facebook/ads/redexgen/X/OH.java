package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OH {
    public final int[] A00(View view, int i, int i2) {
        C4F c4f = (C4F) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), c4f.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), c4f.height));
        return new int[]{view.getMeasuredWidth() + c4f.leftMargin + c4f.rightMargin, view.getMeasuredHeight() + c4f.bottomMargin + c4f.topMargin};
    }
}
