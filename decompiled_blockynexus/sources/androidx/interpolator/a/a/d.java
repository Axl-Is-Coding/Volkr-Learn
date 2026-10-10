package androidx.interpolator.a.a;

import android.view.animation.Interpolator;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: LookupTableInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f1564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f1565b;

    protected d(float[] fArr) {
        this.f1564a = fArr;
        this.f1565b = 1.0f / (this.f1564a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= WheelView.DividerConfig.FILL) {
            return WheelView.DividerConfig.FILL;
        }
        float[] fArr = this.f1564a;
        int iMin = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.f1565b;
        float f4 = (f2 - (iMin * f3)) / f3;
        float[] fArr2 = this.f1564a;
        return fArr2[iMin] + (f4 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
