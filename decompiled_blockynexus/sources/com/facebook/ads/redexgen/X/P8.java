package com.facebook.ads.redexgen.X;

import android.graphics.Paint;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class P8 extends Paint {
    public final /* synthetic */ P9 A00;
    public final /* synthetic */ boolean A01;

    public P8(P9 p9, boolean z) {
        this.A00 = p9;
        this.A01 = z;
        setStyle(Paint.Style.FILL_AND_STROKE);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeWidth(3.0f);
        setAntiAlias(true);
        setColor(this.A01 ? -1 : -10066330);
    }
}
