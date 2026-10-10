package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.27, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(19)
public class AnonymousClass27 extends C3U {
    @Override // com.facebook.ads.redexgen.X.C3E
    public Object A00(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public Object A01(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A03(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
    }

    @Override // com.facebook.ads.redexgen.X.C3E
    public final void A04(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
    }
}
