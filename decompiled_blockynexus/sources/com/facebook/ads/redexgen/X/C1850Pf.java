package com.facebook.ads.redexgen.X;

import cn.qqtheme.framework.widget.WheelView;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1850Pf {
    public float A00;
    public C0Q A01;
    public Map<String, String> A02;

    public C1850Pf(C0Q c0q) {
        this(c0q, WheelView.DividerConfig.FILL);
    }

    public C1850Pf(C0Q c0q, float f2) {
        this(c0q, f2, null);
    }

    public C1850Pf(C0Q c0q, float f2, Map<String, String> map) {
        this.A01 = c0q;
        this.A00 = f2;
        if (map != null) {
            this.A02 = map;
        } else {
            Map<String, String> windowParams = new HashMap<>();
            this.A02 = windowParams;
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A03();
    }

    public final C0Q A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A01 == C0Q.A0J;
    }
}
