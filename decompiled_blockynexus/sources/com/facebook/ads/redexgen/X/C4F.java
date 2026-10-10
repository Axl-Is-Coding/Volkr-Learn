package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C4F extends ViewGroup.MarginLayoutParams {
    public C4W A00;
    public boolean A01;
    public boolean A02;
    public final Rect A03;

    public C4F(int i, int i2) {
        super(i, i2);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4F(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4F(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4F(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C4F(C4F c4f) {
        super((ViewGroup.LayoutParams) c4f);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public final int A00() {
        return this.A00.A0J();
    }

    public final boolean A01() {
        return this.A00.A0g();
    }

    public final boolean A02() {
        return this.A00.A0d();
    }

    public final boolean A03() {
        return this.A00.A0c();
    }
}
