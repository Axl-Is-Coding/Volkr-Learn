package com.tencent.mapsdk.rastercore.b;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f19451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f19452e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static double f19449b = Math.log(2.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19448a = 5;

    public d(double d2) {
        this.f19452e = d2;
        f();
    }

    public d(int i, double d2) {
        this.f19450c = i;
        this.f19451d = d2;
        e();
    }

    public static double c(double d2) {
        return 156543.0339d / Math.pow(2.0d, d2);
    }

    private void e() {
        double dLog = Math.log(this.f19451d) / f19449b;
        double d2 = this.f19450c;
        Double.isNaN(d2);
        this.f19452e = dLog + d2;
        StringBuilder sb = new StringBuilder("refreshZoom--zoom=");
        sb.append(this.f19452e);
        sb.append(";level=");
        sb.append(this.f19450c);
        sb.append(";scale=");
        sb.append(this.f19451d);
    }

    private void f() {
        double d2 = this.f19452e;
        this.f19450c = (int) d2;
        double d3 = this.f19450c;
        Double.isNaN(d3);
        this.f19451d = Math.pow(2.0d, d2 - d3);
        StringBuilder sb = new StringBuilder("refreshLevel--zoom=");
        sb.append(this.f19452e);
        sb.append(";level=");
        sb.append(this.f19450c);
        sb.append(";scale=");
        sb.append(this.f19451d);
    }

    public final int a() {
        return this.f19450c;
    }

    public final void a(double d2) {
        this.f19451d = d2;
        e();
        f();
    }

    public final void a(int i) {
        this.f19450c = 19;
        e();
    }

    public final double b() {
        return this.f19451d;
    }

    public final void b(double d2) {
        this.f19452e = d2;
        f();
    }

    public final double c() {
        return this.f19452e;
    }

    public final double d() {
        return c(this.f19452e);
    }
}
