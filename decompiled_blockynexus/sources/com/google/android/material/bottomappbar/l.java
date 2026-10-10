package com.google.android.material.bottomappbar;

import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.l.q;

/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends com.google.android.material.l.f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f13190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13192e;

    public l(float f2, float f3, float f4) {
        this.f13189b = f2;
        this.f13188a = f3;
        this.f13191d = f4;
        if (f4 < WheelView.DividerConfig.FILL) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f13192e = WheelView.DividerConfig.FILL;
    }

    @Override // com.google.android.material.l.f
    public void a(float f2, float f3, float f4, q qVar) {
        float f5 = this.f13190c;
        if (f5 == WheelView.DividerConfig.FILL) {
            qVar.a(f2, WheelView.DividerConfig.FILL);
            return;
        }
        float f6 = ((this.f13189b * 2.0f) + f5) / 2.0f;
        float f7 = f4 * this.f13188a;
        float f8 = f3 + this.f13192e;
        float f9 = (this.f13191d * f4) + ((1.0f - f4) * f6);
        if (f9 / f6 >= 1.0f) {
            qVar.a(f2, WheelView.DividerConfig.FILL);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float fSqrt = (float) Math.sqrt((f10 * f10) - (f11 * f11));
        float f12 = f8 - fSqrt;
        float f13 = f8 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f11));
        float f14 = 90.0f - degrees;
        qVar.a(f12, WheelView.DividerConfig.FILL);
        float f15 = f7 * 2.0f;
        qVar.a(f12 - f7, WheelView.DividerConfig.FILL, f12 + f7, f15, 270.0f, degrees);
        qVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        qVar.a(f13 - f7, WheelView.DividerConfig.FILL, f13 + f7, f15, 270.0f - degrees, degrees);
        qVar.a(f2, WheelView.DividerConfig.FILL);
    }

    float b() {
        return this.f13191d;
    }

    float c() {
        return this.f13189b;
    }

    public void d(float f2) {
        this.f13190c = f2;
    }

    public float e() {
        return this.f13190c;
    }

    public float f() {
        return this.f13192e;
    }

    void b(float f2) {
        this.f13189b = f2;
    }

    void c(float f2) {
        this.f13188a = f2;
    }

    float d() {
        return this.f13188a;
    }

    void e(float f2) {
        this.f13192e = f2;
    }

    void a(float f2) {
        this.f13191d = f2;
    }
}
