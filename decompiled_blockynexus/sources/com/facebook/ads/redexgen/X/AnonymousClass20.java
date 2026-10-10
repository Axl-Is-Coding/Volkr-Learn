package com.facebook.ads.redexgen.X;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.20, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass20 implements Serializable {
    public double A00;
    public double A01;
    public double A02;
    public double A03;
    public double A04;
    public double A05;
    public double A06;
    public double A07;
    public double A08;
    public double A09;
    public int A0A;

    public AnonymousClass20(double d2) {
        this.A04 = d2;
    }

    public final double A00() {
        return this.A00;
    }

    public final double A01() {
        return this.A03;
    }

    public final double A02() {
        return this.A05;
    }

    public final double A03() {
        return this.A06;
    }

    public final double A04() {
        return this.A07;
    }

    public final double A05() {
        if (this.A0A == 0) {
            return 0.0d;
        }
        return this.A08;
    }

    public final void A06() {
        this.A00 = 0.0d;
        this.A02 = 0.0d;
        this.A03 = 0.0d;
        this.A05 = 0.0d;
        this.A0A = 0;
        this.A07 = 0.0d;
        this.A08 = 1.0d;
        this.A09 = 0.0d;
    }

    public final void A07() {
        this.A01 = 0.0d;
    }

    public final void A08(double d2, double d3) {
        this.A0A++;
        this.A07 += d2;
        this.A02 = d3;
        this.A09 += d3 * d2;
        this.A00 = this.A09 / this.A07;
        this.A08 = Math.min(this.A08, d3);
        this.A05 = Math.max(this.A05, d3);
        if (d3 >= this.A04) {
            this.A03 += d2;
            this.A01 += d2;
            this.A06 = Math.max(this.A06, this.A01);
            return;
        }
        this.A01 = 0.0d;
    }
}
