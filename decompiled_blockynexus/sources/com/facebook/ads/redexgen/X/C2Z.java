package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2Z, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2Z {
    public static boolean A00(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
