package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnLongClickListenerC13594t implements View.OnLongClickListener {
    public final /* synthetic */ C13604u A00;

    public ViewOnLongClickListenerC13594t(C13604u c13604u) {
        this.A00 = c13604u;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A00.A0B != null && this.A00.A06 != null) {
            this.A00.A0B.setBounds(0, 0, this.A00.A06.getWidth(), this.A00.A06.getHeight());
            this.A00.A0B.A0E(!this.A00.A0B.A0F());
        }
        return true;
    }
}
