package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ll, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1753Ll {

    @Nullable
    public static C1753Ll A02;
    public final C2119Zt A00;
    public final C1755Ln A01;

    public C1753Ll(C2026Wb c2026Wb, Executor executor, C14498q c14498q) {
        this.A01 = new C1755Ln(c2026Wb);
        this.A00 = new C2119Zt(executor, c14498q, c2026Wb);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C2026Wb c2026Wb, Executor executor, C14498q c14498q) {
        if (!C1693Iy.A0v(c2026Wb)) {
            return;
        }
        C1753Ll c1753Ll = A02;
        if (c1753Ll == null) {
            A02 = new C1753Ll(c2026Wb, executor, c14498q);
            A02.A00();
        } else {
            c1753Ll.A02(c14498q);
        }
    }

    private void A02(C14498q c14498q) {
        this.A00.A07(c14498q);
    }
}
