package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import cn.qqtheme.framework.widget.WheelView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f2186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f2187b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f2188c = new Matrix();

    public PatternPathMotion() {
        this.f2187b.lineTo(1.0f, WheelView.DividerConfig.FILL);
        this.f2186a = this.f2187b;
    }

    public void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f2 = fArr[0];
        float f3 = fArr[1];
        pathMeasure.getPosTan(WheelView.DividerConfig.FILL, fArr, null);
        float f4 = fArr[0];
        float f5 = fArr[1];
        if (f4 == f2 && f5 == f3) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f2188c.setTranslate(-f4, -f5);
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        float fA = 1.0f / a(f6, f7);
        this.f2188c.postScale(fA, fA);
        this.f2188c.postRotate((float) Math.toDegrees(-Math.atan2(f7, f6)));
        path.transform(this.f2188c, this.f2187b);
        this.f2186a = path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.k);
        try {
            String strA = androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strA != null) {
                a(androidx.core.a.b.b(strA));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float fA = a(f6, f7);
        double dAtan2 = Math.atan2(f7, f6);
        this.f2188c.setScale(fA, fA);
        this.f2188c.postRotate((float) Math.toDegrees(dAtan2));
        this.f2188c.postTranslate(f2, f3);
        Path path = new Path();
        this.f2187b.transform(this.f2188c, path);
        return path;
    }

    private static float a(float f2, float f3) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }
}
