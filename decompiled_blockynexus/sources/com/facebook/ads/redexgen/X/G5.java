package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.text.Layout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class G5 {
    public final float A00;
    public final float A01;
    public final float A02;
    public final float A03;
    public final float A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final Bitmap A0A;
    public final Layout.Alignment A0B;
    public final CharSequence A0C;
    public final boolean A0D;

    public G5(Bitmap bitmap, float f2, int i, float f3, int i2, float f4, float f5) {
        this(null, null, bitmap, f3, 0, i2, f2, i, Integer.MIN_VALUE, Float.MIN_VALUE, f4, f5, false, -16777216);
    }

    public G5(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public G5(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4) {
        this(charSequence, alignment, f2, i, i2, f3, i3, f4, false, -16777216);
    }

    public G5(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4, int i4, float f5) {
        this(charSequence, alignment, null, f2, i, i2, f3, i3, i4, f5, f4, Float.MIN_VALUE, false, -16777216);
    }

    public G5(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4, boolean z, int i4) {
        this(charSequence, alignment, null, f2, i, i2, f3, i3, Integer.MIN_VALUE, Float.MIN_VALUE, f4, Float.MIN_VALUE, z, i4);
    }

    public G5(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f2, int i, int i2, float f3, int i3, int i4, float f4, float f5, float f6, boolean z, int i5) {
        this.A0C = charSequence;
        this.A0B = alignment;
        this.A0A = bitmap;
        this.A01 = f2;
        this.A06 = i;
        this.A05 = i2;
        this.A02 = f3;
        this.A07 = i3;
        this.A03 = f5;
        this.A00 = f6;
        this.A0D = z;
        this.A09 = i5;
        this.A08 = i4;
        this.A04 = f4;
    }
}
