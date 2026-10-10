package com.google.android.material.k;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ShadowRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13502a = new int[3];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f13503b = {WheelView.DividerConfig.FILL, 0.5f, 1.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f13504c = new int[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f13505d = {WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0.5f, 1.0f};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f13506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f13507f;
    private final Paint g;
    private int h;
    private int i;
    private int j;
    private final Path k;

    public a() {
        this(-16777216);
    }

    public void a(int i) {
        this.h = androidx.core.a.a.b(i, 68);
        this.i = androidx.core.a.a.b(i, 20);
        this.j = androidx.core.a.a.b(i, 0);
    }

    public a(int i) {
        this.k = new Path();
        a(i);
        this.f13507f = new Paint(4);
        this.f13507f.setStyle(Paint.Style.FILL);
        this.f13506e = new Paint();
        this.f13506e.setColor(this.h);
        this.g = new Paint(this.f13507f);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += i;
        rectF.offset(WheelView.DividerConfig.FILL, -i);
        int[] iArr = f13502a;
        iArr[0] = this.j;
        iArr[1] = this.i;
        iArr[2] = this.h;
        Paint paint = this.g;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f13503b, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.g);
        canvas.restore();
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i, float f2, float f3) {
        boolean z = f3 < WheelView.DividerConfig.FILL;
        Path path = this.k;
        if (z) {
            int[] iArr = f13504c;
            iArr[0] = 0;
            iArr[1] = this.j;
            iArr[2] = this.i;
            iArr[3] = this.h;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i;
            rectF.inset(f4, f4);
            int[] iArr2 = f13504c;
            iArr2[0] = 0;
            iArr2[1] = this.h;
            iArr2[2] = this.i;
            iArr2[3] = this.j;
        }
        float fWidth = 1.0f - (i / (rectF.width() / 2.0f));
        float[] fArr = f13505d;
        fArr[1] = fWidth;
        fArr[2] = ((1.0f - fWidth) / 2.0f) + fWidth;
        this.f13507f.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, f13504c, f13505d, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        canvas.drawArc(rectF, f2, f3, true, this.f13507f);
        canvas.restore();
    }

    public Paint a() {
        return this.f13506e;
    }
}
