package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1927Sg extends C2X {
    public static String[] A01;
    public final C1928Sh A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Aypyv0FACfsPQTq8B8UFxLSJIGYFzsCC", "O7nTze5knL3NcSr2rovnk7vqxWhLtUKF", "w8KDuB7m9FBYOy6hiJzio9ilRX5MSLSp", "Kqe5H6YPSeJrA9PRZ2BXFN4qonyjjTB9", "VPpNE9vsyh3HxU94PoFE47DnBqUfoC5Y", "VSW3ZMLcugYKNhiURlJ0g5uJ7Smp29SS", "AB", "JpT6Sbfy0irMNtnKFHDBnJ8tZotKHb"};
    }

    public C1927Sg(C1928Sh c1928Sh) {
        this.A00 = c1928Sh;
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final void A08(View view, C3I c3i) {
        super.A08(view, c3i);
        if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
            this.A00.A01.getLayoutManager().A1D(view, c3i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C2X
    public final boolean A09(View view, int i, Bundle bundle) {
        if (!super.A09(view, i, bundle)) {
            if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
                return this.A00.A01.getLayoutManager().A1c(view, i, bundle);
            }
            return false;
        }
        if (A01[2].charAt(3) == 'j') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "SRS22nAnXgHfwC2qheyHP9Kgc2YZ";
        strArr[6] = "SRS22nAnXgHfwC2qheyHP9Kgc2YZ";
        return true;
    }
}
