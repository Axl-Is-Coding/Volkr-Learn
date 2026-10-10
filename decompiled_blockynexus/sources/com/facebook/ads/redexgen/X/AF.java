package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AF {
    public static final AF A04 = new AF(1.0f);
    public final float A00;
    public final float A01;
    public final boolean A02;
    public final int A03;

    public AF(float f2) {
        this(f2, 1.0f, false);
    }

    public AF(float f2, float f3, boolean z) {
        C1662Hr.A03(f2 > WheelView.DividerConfig.FILL);
        C1662Hr.A03(f3 > WheelView.DividerConfig.FILL);
        this.A01 = f2;
        this.A00 = f3;
        this.A02 = z;
        this.A03 = Math.round(1000.0f * f2);
    }

    public final long A00(long j) {
        return ((long) this.A03) * j;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AF af = (AF) obj;
        return this.A01 == af.A01 && this.A00 == af.A00 && this.A02 == af.A02;
    }

    public final int hashCode() {
        return (((((17 * 31) + Float.floatToRawIntBits(this.A01)) * 31) + Float.floatToRawIntBits(this.A00)) * 31) + (this.A02 ? 1 : 0);
    }
}
