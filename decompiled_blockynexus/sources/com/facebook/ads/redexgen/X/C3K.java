package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3K {
    public static final C3J A01;
    public final Object A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A01 = new EM();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A01 = new EU();
        } else {
            A01 = new SM();
        }
    }

    public C3K() {
        this.A00 = A01.A8r(this);
    }

    public C3K(Object obj) {
        this.A00 = obj;
    }

    @Nullable
    public final C3I A00(int i) {
        return null;
    }

    @Nullable
    public final C3I A01(int i) {
        return null;
    }

    public final Object A02() {
        return this.A00;
    }

    @Nullable
    public final List<C3I> A03(String str, int i) {
        return null;
    }

    public final boolean A04(int i, int i2, Bundle bundle) {
        return false;
    }
}
