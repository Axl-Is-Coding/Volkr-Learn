package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RequiresApi(21)
public class C12390a extends AnonymousClass17 {
    @Override // com.facebook.ads.redexgen.X.C13092s
    public final C3A A09(View view, C3A c3a) {
        WindowInsets windowInsets = (WindowInsets) C3A.A01(c3a);
        WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (windowInsetsDispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
        }
        return C3A.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final C3A A0A(View view, C3A c3a) {
        WindowInsets windowInsets = (WindowInsets) C3A.A01(c3a);
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (windowInsetsOnApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(windowInsetsOnApplyWindowInsets);
        }
        return C3A.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final void A0C(View view) {
        view.stopNestedScroll();
    }

    @Override // com.facebook.ads.redexgen.X.C13092s
    public final void A0F(View view, final InterfaceC12942d interfaceC12942d) {
        if (interfaceC12942d == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.facebook.ads.redexgen.X.2r
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return (WindowInsets) C3A.A01(interfaceC12942d.A99(view2, C3A.A00(windowInsets)));
                }
            });
        }
    }
}
