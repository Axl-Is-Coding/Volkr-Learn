package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import cn.qqtheme.framework.widget.WheelView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f2117a = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2122f;
    private float g;

    public ArcMotion() {
        this.f2118b = WheelView.DividerConfig.FILL;
        this.f2119c = WheelView.DividerConfig.FILL;
        this.f2120d = 70.0f;
        this.f2121e = WheelView.DividerConfig.FILL;
        this.f2122f = WheelView.DividerConfig.FILL;
        this.g = f2117a;
    }

    private static float d(float f2) {
        if (f2 < WheelView.DividerConfig.FILL || f2 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f2 / 2.0f));
    }

    public void a(float f2) {
        this.f2120d = f2;
        this.g = d(f2);
    }

    public void b(float f2) {
        this.f2118b = f2;
        this.f2121e = d(f2);
    }

    public void c(float f2) {
        this.f2119c = f2;
        this.f2122f = d(f2);
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        Path path = new Path();
        path.moveTo(f2, f3);
        float f9 = f4 - f2;
        float f10 = f5 - f3;
        float f11 = (f9 * f9) + (f10 * f10);
        float f12 = (f2 + f4) / 2.0f;
        float f13 = (f3 + f5) / 2.0f;
        float f14 = 0.25f * f11;
        boolean z = f3 > f5;
        if (Math.abs(f9) < Math.abs(f10)) {
            float fAbs = Math.abs(f11 / (f10 * 2.0f));
            if (z) {
                f7 = fAbs + f5;
                f6 = f4;
            } else {
                f7 = fAbs + f3;
                f6 = f2;
            }
            f8 = this.f2122f;
        } else {
            float f15 = f11 / (f9 * 2.0f);
            if (z) {
                f7 = f3;
                f6 = f15 + f2;
            } else {
                f6 = f4 - f15;
                f7 = f5;
            }
            f8 = this.f2121e;
        }
        float f16 = f14 * f8 * f8;
        float f17 = f12 - f6;
        float f18 = f13 - f7;
        float f19 = (f17 * f17) + (f18 * f18);
        float f20 = this.g;
        float f21 = f14 * f20 * f20;
        if (f19 < f16) {
            f21 = f16;
        } else if (f19 <= f21) {
            f21 = WheelView.DividerConfig.FILL;
        }
        if (f21 != WheelView.DividerConfig.FILL) {
            float fSqrt = (float) Math.sqrt(f21 / f19);
            f6 = ((f6 - f12) * fSqrt) + f12;
            f7 = f13 + (fSqrt * (f7 - f13));
        }
        path.cubicTo((f2 + f6) / 2.0f, (f3 + f7) / 2.0f, (f6 + f4) / 2.0f, (f7 + f5) / 2.0f, f4, f5);
        return path;
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2118b = WheelView.DividerConfig.FILL;
        this.f2119c = WheelView.DividerConfig.FILL;
        this.f2120d = 70.0f;
        this.f2121e = WheelView.DividerConfig.FILL;
        this.f2122f = WheelView.DividerConfig.FILL;
        this.g = f2117a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        c(androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, WheelView.DividerConfig.FILL));
        b(androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, WheelView.DividerConfig.FILL));
        a(androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        typedArrayObtainStyledAttributes.recycle();
    }
}
