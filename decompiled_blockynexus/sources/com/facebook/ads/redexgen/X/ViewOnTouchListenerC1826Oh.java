package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1826Oh implements View.OnTouchListener {
    public final /* synthetic */ LU A00;

    public ViewOnTouchListenerC1826Oh(LU lu) {
        this.A00 = lu;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A00.A0A.A03(new I5(view, motionEvent));
        return false;
    }
}
