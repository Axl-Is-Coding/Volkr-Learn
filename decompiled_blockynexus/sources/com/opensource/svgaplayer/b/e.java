package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: SVGAScaleInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f15479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f15480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f15481c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f15482d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f15483e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15484f;

    private final void f() {
        this.f15479a = WheelView.DividerConfig.FILL;
        this.f15480b = WheelView.DividerConfig.FILL;
        this.f15481c = 1.0f;
        this.f15482d = 1.0f;
        this.f15483e = 1.0f;
        this.f15484f = false;
    }

    public final boolean a() {
        return this.f15484f;
    }

    public final float b() {
        return this.f15481c;
    }

    public final float c() {
        return this.f15482d;
    }

    public final float d() {
        return this.f15479a;
    }

    public final float e() {
        return this.f15480b;
    }

    public final void a(float f2, float f3, float f4, float f5, ImageView.ScaleType scaleType) {
        i.b(scaleType, "scaleType");
        if (f2 == WheelView.DividerConfig.FILL || f3 == WheelView.DividerConfig.FILL || f4 == WheelView.DividerConfig.FILL || f5 == WheelView.DividerConfig.FILL) {
            return;
        }
        f();
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f3 - f5) / 2.0f;
        float f8 = f4 / f5;
        float f9 = f2 / f3;
        float f10 = f3 / f5;
        float f11 = f2 / f4;
        switch (d.f15478a[scaleType.ordinal()]) {
            case 1:
                this.f15479a = f6;
                this.f15480b = f7;
                break;
            case 2:
                if (f8 <= f9) {
                    this.f15483e = f11;
                    this.f15484f = true;
                    this.f15481c = f11;
                    this.f15482d = f11;
                    this.f15480b = (f3 - (f5 * f11)) / 2.0f;
                } else {
                    this.f15483e = f10;
                    this.f15484f = false;
                    this.f15481c = f10;
                    this.f15482d = f10;
                    this.f15479a = (f2 - (f4 * f10)) / 2.0f;
                }
                break;
            case 3:
                if (f4 < f2 && f5 < f3) {
                    this.f15479a = f6;
                    this.f15480b = f7;
                } else if (f8 <= f9) {
                    this.f15483e = f10;
                    this.f15484f = false;
                    this.f15481c = f10;
                    this.f15482d = f10;
                    this.f15479a = (f2 - (f4 * f10)) / 2.0f;
                } else {
                    this.f15483e = f11;
                    this.f15484f = true;
                    this.f15481c = f11;
                    this.f15482d = f11;
                    this.f15480b = (f3 - (f5 * f11)) / 2.0f;
                }
                break;
            case 4:
                if (f8 <= f9) {
                    this.f15483e = f10;
                    this.f15484f = false;
                    this.f15481c = f10;
                    this.f15482d = f10;
                    this.f15479a = (f2 - (f4 * f10)) / 2.0f;
                } else {
                    this.f15483e = f11;
                    this.f15484f = true;
                    this.f15481c = f11;
                    this.f15482d = f11;
                    this.f15480b = (f3 - (f5 * f11)) / 2.0f;
                }
                break;
            case 5:
                if (f8 <= f9) {
                    this.f15483e = f10;
                    this.f15484f = false;
                    this.f15481c = f10;
                    this.f15482d = f10;
                } else {
                    this.f15483e = f11;
                    this.f15484f = true;
                    this.f15481c = f11;
                    this.f15482d = f11;
                }
                break;
            case 6:
                if (f8 <= f9) {
                    this.f15483e = f10;
                    this.f15484f = false;
                    this.f15481c = f10;
                    this.f15482d = f10;
                    this.f15479a = f2 - (f4 * f10);
                } else {
                    this.f15483e = f11;
                    this.f15484f = true;
                    this.f15481c = f11;
                    this.f15482d = f11;
                    this.f15480b = f3 - (f5 * f11);
                }
                break;
            case 7:
                this.f15483e = Math.max(f11, f10);
                this.f15484f = f11 > f10;
                this.f15481c = f11;
                this.f15482d = f10;
                break;
            default:
                this.f15483e = f11;
                this.f15484f = true;
                this.f15481c = f11;
                this.f15482d = f11;
                break;
        }
    }
}
