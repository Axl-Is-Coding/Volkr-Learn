package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: PathInterpolatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f2340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f2341b;

    public h(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (androidx.core.content.a.i.a(xmlPullParser, "pathData")) {
            String strA = androidx.core.content.a.i.a(typedArray, xmlPullParser, "pathData", 4);
            Path pathB = androidx.core.a.b.b(strA);
            if (pathB != null) {
                a(pathB);
                return;
            }
            throw new InflateException("The path is null, which is created from " + strA);
        }
        if (!androidx.core.content.a.i.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!androidx.core.content.a.i.a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fA = androidx.core.content.a.i.a(typedArray, xmlPullParser, "controlX1", 0, WheelView.DividerConfig.FILL);
        float fA2 = androidx.core.content.a.i.a(typedArray, xmlPullParser, "controlY1", 1, WheelView.DividerConfig.FILL);
        boolean zA = androidx.core.content.a.i.a(xmlPullParser, "controlX2");
        if (zA != androidx.core.content.a.i.a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zA) {
            a(fA, fA2, androidx.core.content.a.i.a(typedArray, xmlPullParser, "controlX2", 2, WheelView.DividerConfig.FILL), androidx.core.content.a.i.a(typedArray, xmlPullParser, "controlY2", 3, WheelView.DividerConfig.FILL));
        } else {
            a(fA, fA2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= WheelView.DividerConfig.FILL) {
            return WheelView.DividerConfig.FILL;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f2340a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.f2340a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f2340a;
        float f3 = fArr[length] - fArr[i];
        if (f3 == WheelView.DividerConfig.FILL) {
            return this.f2341b[i];
        }
        float f4 = (f2 - fArr[i]) / f3;
        float[] fArr2 = this.f2341b;
        float f5 = fArr2[i];
        return f5 + (f4 * (fArr2[length] - f5));
    }

    public h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, a.l);
        a(typedArrayA, xmlPullParser);
        typedArrayA.recycle();
    }

    private void a(float f2, float f3) {
        Path path = new Path();
        path.moveTo(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        a(path);
    }

    private void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        a(path);
    }

    private void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, ((int) (length / 0.002f)) + 1);
        if (iMin > 0) {
            this.f2340a = new float[iMin];
            this.f2341b = new float[iMin];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < iMin; i2++) {
                pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
                this.f2340a[i2] = fArr[0];
                this.f2341b[i2] = fArr[1];
            }
            if (Math.abs(this.f2340a[0]) <= 1.0E-5d && Math.abs(this.f2341b[0]) <= 1.0E-5d) {
                int i3 = iMin - 1;
                if (Math.abs(this.f2340a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f2341b[i3] - 1.0f) <= 1.0E-5d) {
                    int i4 = 0;
                    float f2 = WheelView.DividerConfig.FILL;
                    while (i < iMin) {
                        float[] fArr2 = this.f2340a;
                        int i5 = i4 + 1;
                        float f3 = fArr2[i4];
                        if (f3 >= f2) {
                            fArr2[i] = f3;
                            i++;
                            f2 = f3;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f2340a[0]);
            sb.append(",");
            sb.append(this.f2341b[0]);
            sb.append(" end:");
            int i6 = iMin - 1;
            sb.append(this.f2340a[i6]);
            sb.append(",");
            sb.append(this.f2341b[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }
}
