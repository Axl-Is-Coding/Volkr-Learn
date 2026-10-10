package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2187b1 implements InterfaceC1665Hu {
    @Override // com.facebook.ads.redexgen.X.InterfaceC1665Hu
    public final I4 A4I(Looper looper, @Nullable Handler.Callback callback) {
        return new C2188b2(new Handler(looper, callback));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1665Hu
    public final long A4z() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1665Hu
    public final long ADy() {
        return SystemClock.uptimeMillis();
    }
}
