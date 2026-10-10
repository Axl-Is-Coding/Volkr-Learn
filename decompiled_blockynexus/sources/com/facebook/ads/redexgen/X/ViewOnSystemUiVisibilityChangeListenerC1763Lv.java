package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnSystemUiVisibilityChangeListenerC1763Lv implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ C2116Zq A00;

    public ViewOnSystemUiVisibilityChangeListenerC1763Lv(C2116Zq c2116Zq) {
        this.A00 = c2116Zq;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z = this.A00.getResources().getConfiguration().orientation == 1;
        C2116Zq c2116Zq = this.A00;
        if (z) {
            layoutParams = c2116Zq.A09;
        } else {
            layoutParams = c2116Zq.A08;
        }
        if ((i & 2) == 0) {
            this.A00.A02 = true;
            if (!z) {
                i5 = 0;
            } else {
                i5 = C2116Zq.A0M;
            }
            if (!z) {
                i6 = 0;
            } else {
                i6 = C2116Zq.A0M;
            }
            if (!z) {
                i7 = 0;
            } else {
                i7 = C2116Zq.A0M * 3;
            }
            layoutParams.setMargins(i5, 0, i6, i7);
        } else {
            this.A00.A02 = false;
            if (!z) {
                i2 = 0;
            } else {
                i2 = C2116Zq.A0M;
            }
            if (!z) {
                i3 = 0;
            } else {
                i3 = C2116Zq.A0M;
            }
            if (!z) {
                i4 = 0;
            } else {
                i4 = C2116Zq.A0M;
            }
            layoutParams.setMargins(i2, 0, i3, i4);
        }
        this.A00.setLayoutParams(layoutParams);
    }
}
