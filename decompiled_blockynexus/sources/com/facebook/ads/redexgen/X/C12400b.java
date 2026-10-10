package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(21)
public class C12400b extends AnonymousClass27 {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass27, com.facebook.ads.redexgen.X.C3E
    public final Object A00(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass27, com.facebook.ads.redexgen.X.C3E
    public final Object A01(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
    }
}
