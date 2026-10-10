package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SD implements InterfaceC12942d {
    public final Rect A00 = new Rect();
    public final /* synthetic */ AnonymousClass37 A01;

    public SD(AnonymousClass37 anonymousClass37) {
        this.A01 = anonymousClass37;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12942d
    public final C3A A99(View view, C3A c3a) {
        C3A c3aA06 = C2t.A06(view, c3a);
        if (c3aA06.A08()) {
            return c3aA06;
        }
        Rect rect = this.A00;
        rect.left = c3aA06.A04();
        rect.top = c3aA06.A06();
        rect.right = c3aA06.A05();
        rect.bottom = c3aA06.A03();
        int childCount = this.A01.getChildCount();
        for (int i = 0; i < childCount; i++) {
            C3A c3aA05 = C2t.A05(this.A01.getChildAt(i), c3aA06);
            rect.left = Math.min(c3aA05.A04(), rect.left);
            rect.top = Math.min(c3aA05.A06(), rect.top);
            rect.right = Math.min(c3aA05.A05(), rect.right);
            rect.bottom = Math.min(c3aA05.A03(), rect.bottom);
        }
        return c3aA06.A07(rect.left, rect.top, rect.right, rect.bottom);
    }
}
