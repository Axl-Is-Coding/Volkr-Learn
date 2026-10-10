package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class OU implements View.OnTouchListener {
    public final /* synthetic */ OV A00;

    public OU(OV ov) {
        this.A00 = ov;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.A00.A01 = System.currentTimeMillis();
            OV.A00(this.A00);
            this.A00.A06.A8Q(this.A00.A03.A0Q(), new NQ().A04(this.A00.getViewabilityChecker()).A03(this.A00.getTouchDataRecorder()).A06());
            return false;
        }
        return false;
    }
}
