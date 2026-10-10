package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.30, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass30 extends ViewGroup.LayoutParams {
    public float A00;
    public int A01;
    public int A02;
    public boolean A03;
    public int A04;
    public boolean A05;

    public AnonymousClass30() {
        super(-1, -1);
        this.A00 = WheelView.DividerConfig.FILL;
    }

    public AnonymousClass30(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A00 = WheelView.DividerConfig.FILL;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnonymousClass37.A0w);
        this.A04 = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
    }
}
