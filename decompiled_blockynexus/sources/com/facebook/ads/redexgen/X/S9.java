package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(16)
public class S9 extends C2W {
    @Override // com.facebook.ads.redexgen.X.C2W
    public final View.AccessibilityDelegate A00(final C2X c2x) {
        return new View.AccessibilityDelegate() { // from class: com.facebook.ads.redexgen.X.2U
            public static String[] A02;

            static {
                A00();
            }

            public static void A00() {
                A02 = new String[]{"5TXwkxGOky4JO26BdMoLZorZ75Qh7TJ1", "TGpCIVKfg9q9VkptB3w2PfFUtUXuMPxH", "XWnogg3sW", "LoblWG2nky8IldTW7marNA4rqywTihhk", "", "za5KD6H2U", "Ka0OyPk3mlOgfUpq6xId3QQILfS23GTN", "DN7QTk2L5QCC7wBdOwuQ1Nom6iZb"};
            }

            @Override // android.view.View.AccessibilityDelegate
            public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c2x.A05(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                C3K c3kA01 = c2x.A01(view);
                if (c3kA01 != null) {
                    Object objA02 = c3kA01.A02();
                    String[] strArr = A02;
                    if (strArr[0].charAt(14) == strArr[6].charAt(14)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[1] = "uCvPJ7NUfrK1Xmg35VTgFJzpSrozRbu2";
                    strArr2[1] = "uCvPJ7NUfrK1Xmg35VTgFJzpSrozRbu2";
                    return (AccessibilityNodeProvider) objA02;
                }
                return null;
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c2x.A07(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c2x.A08(view, C3I.A01(accessibilityNodeInfo));
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c2x.A03(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c2x.A06(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return c2x.A09(view, i, bundle);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void sendAccessibilityEvent(View view, int i) {
                c2x.A02(view, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c2x.A04(view, accessibilityEvent);
            }
        };
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final C3K A01(View.AccessibilityDelegate accessibilityDelegate, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C3K(accessibilityNodeProvider);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final boolean A02(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
    }
}
