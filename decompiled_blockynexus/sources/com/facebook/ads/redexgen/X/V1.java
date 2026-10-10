package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.util.DisplayMetrics;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V1 extends C6P {
    public ContentResolver A00;
    public DisplayMetrics A01;

    public V1(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A01 = context.getResources().getDisplayMetrics();
        this.A00 = context.getContentResolver();
    }

    public final C6Y A0H() {
        return new V0(this);
    }

    public final C6Y A0I() {
        return new C1996Ux(this);
    }

    public final C6Y A0J() {
        return new C1997Uy(this);
    }

    public final C6Y A0K() {
        return new C1995Uw(this);
    }

    public final C6Y A0L() {
        return new C1998Uz(this);
    }
}
