package com.facebook.ads.redexgen.X;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.21, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass21 implements Serializable {
    public AnonymousClass20 A00;
    public AnonymousClass20 A01;

    public AnonymousClass21() {
        this(0.5d, 0.5d);
    }

    public AnonymousClass21(double d2) {
        this(d2, 0.5d);
    }

    public AnonymousClass21(double d2, double d3) {
        this.A00 = new AnonymousClass20(d2);
        this.A01 = new AnonymousClass20(d3);
        A02();
    }

    public final AnonymousClass20 A00() {
        return this.A00;
    }

    public final AnonymousClass20 A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A06();
        this.A01.A06();
    }

    public final void A03() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A04(double d2, double d3) {
        this.A00.A08(d2, d3);
    }

    public final void A05(double d2, double d3) {
        this.A01.A08(d2, d3);
    }
}
