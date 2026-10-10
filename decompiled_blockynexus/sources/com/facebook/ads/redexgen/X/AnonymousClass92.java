package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.92, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass92 {
    public static AnonymousClass92 A00 = new AnonymousClass92();

    @VisibleForTesting
    public AnonymousClass92() {
    }

    public static AnonymousClass92 A00() {
        return A00;
    }

    @SuppressLint({"InstanceMethodCanBeStatic"})
    public final AnonymousClass91 A01(AnonymousClass87 anonymousClass87, boolean z) {
        return new XD(anonymousClass87, z, new C13755j());
    }

    @SuppressLint({"CatchGeneralException"})
    public final Map<String, String> A02(AnonymousClass87 anonymousClass87) {
        try {
            return A01(anonymousClass87, false).A6G();
        } catch (Throwable th) {
            anonymousClass87.A04().A3S(th);
            return C14568y.A01(anonymousClass87);
        }
    }
}
