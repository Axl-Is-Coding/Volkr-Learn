package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Trace;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2G {
    public static void A00() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void A01(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
