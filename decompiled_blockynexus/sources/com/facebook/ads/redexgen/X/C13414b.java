package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13414b {
    public C4Y A00 = new C4Y();
    public final C4Z A01;

    public C13414b(C4Z c4z) {
        this.A01 = c4z;
    }

    public final View A00(int end, int next, int i, int i2) {
        int childStart = this.A01.A6m();
        int iA6l = this.A01.A6l();
        int i3 = next > end ? 1 : -1;
        View view = null;
        while (end != next) {
            View viewA5k = this.A01.A5k(end);
            this.A00.A04(childStart, iA6l, this.A01.A5n(viewA5k), this.A01.A5m(viewA5k));
            if (i != 0) {
                this.A00.A02();
                this.A00.A03(i);
                if (this.A00.A05()) {
                    return viewA5k;
                }
            }
            if (i2 != 0) {
                this.A00.A02();
                this.A00.A03(i2);
                if (this.A00.A05()) {
                    view = viewA5k;
                }
            }
            end += i3;
        }
        return view;
    }
}
