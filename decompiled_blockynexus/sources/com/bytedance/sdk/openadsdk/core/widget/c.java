package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: compiled from: TTCustomShadowBackground.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f6603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f6604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearGradient f6605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6606f;
    private int g;
    private int h;
    private int i;
    private RectF j;
    private Paint k;

    /* JADX INFO: compiled from: TTCustomShadowBackground.java */
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int[] f6609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float[] f6610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private LinearGradient f6611e;
        private int h;
        private int i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6607a = t.j(o.a(), "tt_ssxinmian8");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6608b = t.j(o.a(), "tt_ssxinxian3");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f6612f = 10;
        private int g = 16;

        public a() {
            this.h = 0;
            this.i = 0;
            this.h = 0;
            this.i = 0;
        }

        public a a(int i) {
            this.f6607a = i;
            return this;
        }

        public a b(int i) {
            this.f6608b = i;
            return this;
        }

        public a c(int i) {
            this.f6612f = i;
            return this;
        }

        public a d(int i) {
            this.h = i;
            return this;
        }

        public a e(int i) {
            this.i = i;
            return this;
        }

        public a a(int[] iArr) {
            this.f6609c = iArr;
            return this;
        }

        public c a() {
            return new c(this.f6607a, this.f6609c, this.f6610d, this.f6608b, this.f6611e, this.f6612f, this.g, this.h, this.i);
        }
    }

    public c(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.f6601a = i;
        this.f6603c = iArr;
        this.f6604d = fArr;
        this.f6602b = i2;
        this.f6605e = linearGradient;
        this.f6606f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
    }

    private void a() {
        int[] iArr;
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setShadowLayer(this.g, this.h, this.i, this.f6602b);
        if (this.j == null || (iArr = this.f6603c) == null || iArr.length <= 1) {
            this.k.setColor(this.f6601a);
            return;
        }
        float[] fArr = this.f6604d;
        boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint = this.k;
        LinearGradient linearGradient = this.f6605e;
        if (linearGradient == null) {
            RectF rectF = this.j;
            linearGradient = new LinearGradient(rectF.left, WheelView.DividerConfig.FILL, rectF.right, WheelView.DividerConfig.FILL, this.f6603c, z ? this.f6604d : null, Shader.TileMode.CLAMP);
        }
        paint.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.j == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.g;
            int i3 = this.h;
            int i4 = bounds.top + i2;
            int i5 = this.i;
            this.j = new RectF((i + i2) - i3, i4 - i5, (bounds.right - i2) - i3, (bounds.bottom - i2) - i5);
        }
        if (this.k == null) {
            a();
        }
        RectF rectF = this.j;
        int i6 = this.f6606f;
        canvas.drawRoundRect(rectF, i6, i6, this.k);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.k;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.a(view, aVar.a());
    }
}
