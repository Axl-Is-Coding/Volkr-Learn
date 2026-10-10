package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1555Dg {
    public final String A00;
    public final boolean A01;

    public C1555Dg(String str, boolean z) {
        this.A00 = str;
        this.A01 = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != C1555Dg.class) {
            return false;
        }
        C1555Dg c1555Dg = (C1555Dg) obj;
        return TextUtils.equals(this.A00, c1555Dg.A00) && this.A01 == c1555Dg.A01;
    }

    public final int hashCode() {
        int i = 1 * 31;
        String str = this.A00;
        int result = str == null ? 0 : str.hashCode();
        int result2 = (i + result) * 31;
        int result3 = this.A01 ? 1231 : 1237;
        return result2 + result3;
    }
}
