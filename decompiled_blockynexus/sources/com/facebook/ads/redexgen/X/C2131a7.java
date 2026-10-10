package com.facebook.ads.redexgen.X;

import android.text.Layout;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2131a7 extends G5 implements Comparable<C2131a7> {
    public final int A00;

    public C2131a7(CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4, boolean z, int i4, int i5) {
        super(charSequence, alignment, f2, i, i2, f3, i3, f4, z, i4);
        this.A00 = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull C2131a7 c2131a7) {
        int i = c2131a7.A00;
        int i2 = this.A00;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }
}
