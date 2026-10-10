package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2050Wz implements KJ {
    @Override // com.facebook.ads.redexgen.X.KJ
    public final void ACk(Throwable th, Object obj) {
        if (obj instanceof AnonymousClass85) {
            C2026Wb c2026WbA5N = ((AnonymousClass85) obj).A5N();
            if (c2026WbA5N != null) {
                c2026WbA5N.A0E(th);
                return;
            }
            return;
        }
        if (!(obj instanceof View)) {
            return;
        }
        Context context = ((View) obj).getContext();
        if (!(context instanceof C2026Wb)) {
            return;
        }
        ((C2026Wb) context).A0E(th);
    }
}
