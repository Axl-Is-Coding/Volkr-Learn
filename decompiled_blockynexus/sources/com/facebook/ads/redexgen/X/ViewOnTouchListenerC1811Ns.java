package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1811Ns implements View.OnTouchListener {
    public final /* synthetic */ C1880Qj A00;

    public ViewOnTouchListenerC1811Ns(C1880Qj c1880Qj) {
        this.A00 = c1880Qj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.A00.A00 < motionEvent.getY()) {
                    this.A00.A0R(false);
                }
            }
        } else {
            this.A00.A00 = motionEvent.getY();
        }
        return true;
    }
}
