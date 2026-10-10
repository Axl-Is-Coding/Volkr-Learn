package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SE extends C2X {
    public static String[] A01;
    public final /* synthetic */ AnonymousClass37 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"qdMAGnvFuVn0ea0M3RnyzUUMgxm0S2Dt", "2PeyHnmE0bX58Ffgk0gx7OXrgxltyZLW", "2int", "nVrienaBQfkWnV6qIsNJmuY2fGTgVaBy", "EIAfoPo9YRxYx4hqHxVbjlkHHJjThpFm", "", "SPMlRY4DBSEQqdOiv1Q7wDslDeTbAa0F", "kfFOHzhabps7JVIWzUifit9US33gkwJk"};
    }

    public SE(AnonymousClass37 anonymousClass37) {
        this.A00 = anonymousClass37;
    }

    private boolean A01() {
        return this.A00.A01 != null && this.A00.A01.A05() > 1;
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(AnonymousClass37.class.getName());
        accessibilityEvent.setScrollable(A01());
        if (accessibilityEvent.getEventType() == 4096 && this.A00.A01 != null) {
            accessibilityEvent.setItemCount(this.A00.A01.A05());
            accessibilityEvent.setFromIndex(this.A00.A00);
            accessibilityEvent.setToIndex(this.A00.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final void A08(View view, C3I c3i) {
        super.A08(view, c3i);
        c3i.A0P(AnonymousClass37.class.getName());
        c3i.A0S(A01());
        if (this.A00.canScrollHorizontally(1)) {
            c3i.A0O(4096);
        }
        if (this.A00.canScrollHorizontally(-1)) {
            c3i.A0O(8192);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            return true;
        }
        if (i != 4096) {
            if (i != 8192 || !this.A00.canScrollHorizontally(-1)) {
                return false;
            }
            AnonymousClass37 anonymousClass37 = this.A00;
            anonymousClass37.setCurrentItem(anonymousClass37.A00 - 1);
            return true;
        }
        AnonymousClass37 anonymousClass372 = this.A00;
        String[] strArr = A01;
        if (strArr[3].charAt(13) != strArr[7].charAt(13)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[4] = "Vr8sNFSEZwclN9wLDYuYxTMloU2ohTqa";
        strArr2[4] = "Vr8sNFSEZwclN9wLDYuYxTMloU2ohTqa";
        if (!anonymousClass372.canScrollHorizontally(1)) {
            return false;
        }
        AnonymousClass37 anonymousClass373 = this.A00;
        anonymousClass373.setCurrentItem(anonymousClass373.A00 + 1);
        return true;
    }
}
