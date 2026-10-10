package com.google.android.material.l;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q[] f13541a = new q[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f13542b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f13543c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f13544d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f13545e = new q();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f13546f = new float[2];
    private final float[] g = new float[2];

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    public interface a {
        void a(q qVar, Matrix matrix, int i);

        void b(q qVar, Matrix matrix, int i);
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f13547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f13548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f13549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f13550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f13551e;

        b(n nVar, float f2, RectF rectF, a aVar, Path path) {
            this.f13550d = aVar;
            this.f13547a = nVar;
            this.f13551e = f2;
            this.f13549c = rectF;
            this.f13548b = path;
        }
    }

    public o() {
        for (int i = 0; i < 4; i++) {
            this.f13541a[i] = new q();
            this.f13542b[i] = new Matrix();
            this.f13543c[i] = new Matrix();
        }
    }

    private float a(int i) {
        return (i + 1) * 90;
    }

    private void b(int i) {
        this.f13546f[0] = this.f13541a[i].a();
        this.f13546f[1] = this.f13541a[i].b();
        this.f13542b[i].mapPoints(this.f13546f);
        float fA = a(i);
        this.f13543c[i].reset();
        Matrix matrix = this.f13543c[i];
        float[] fArr = this.f13546f;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f13543c[i].preRotate(fA);
    }

    private void c(b bVar, int i) {
        b(i, bVar.f13547a).a(this.f13541a[i], 90.0f, bVar.f13551e, bVar.f13549c, a(i, bVar.f13547a));
        float fA = a(i);
        this.f13542b[i].reset();
        a(i, bVar.f13549c, this.f13544d);
        Matrix matrix = this.f13542b[i];
        PointF pointF = this.f13544d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f13542b[i].preRotate(fA);
    }

    public void a(n nVar, float f2, RectF rectF, Path path) {
        a(nVar, f2, rectF, null, path);
    }

    public void a(n nVar, float f2, RectF rectF, a aVar, Path path) {
        path.rewind();
        b bVar = new b(nVar, f2, rectF, aVar, path);
        for (int i = 0; i < 4; i++) {
            c(bVar, i);
            b(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            a(bVar, i2);
            b(bVar, i2);
        }
        path.close();
    }

    private void b(b bVar, int i) {
        int i2 = (i + 1) % 4;
        this.f13546f[0] = this.f13541a[i].a();
        this.f13546f[1] = this.f13541a[i].b();
        this.f13542b[i].mapPoints(this.f13546f);
        this.g[0] = this.f13541a[i2].c();
        this.g[1] = this.f13541a[i2].d();
        this.f13542b[i2].mapPoints(this.g);
        float f2 = this.f13546f[0];
        float[] fArr = this.g;
        float fMax = Math.max(((float) Math.hypot(f2 - fArr[0], r0[1] - fArr[1])) - 0.001f, WheelView.DividerConfig.FILL);
        float fA = a(bVar.f13549c, i);
        this.f13545e.b(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        c(i, bVar.f13547a).a(fMax, fA, bVar.f13551e, this.f13545e);
        this.f13545e.a(this.f13543c[i], bVar.f13548b);
        a aVar = bVar.f13550d;
        if (aVar != null) {
            aVar.b(this.f13545e, this.f13543c[i], i);
        }
    }

    private void a(b bVar, int i) {
        this.f13546f[0] = this.f13541a[i].c();
        this.f13546f[1] = this.f13541a[i].d();
        this.f13542b[i].mapPoints(this.f13546f);
        if (i == 0) {
            Path path = bVar.f13548b;
            float[] fArr = this.f13546f;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = bVar.f13548b;
            float[] fArr2 = this.f13546f;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f13541a[i].a(this.f13542b[i], bVar.f13548b);
        a aVar = bVar.f13550d;
        if (aVar != null) {
            aVar.a(this.f13541a[i], this.f13542b[i], i);
        }
    }

    private f c(int i, n nVar) {
        if (i == 1) {
            return nVar.b();
        }
        if (i == 2) {
            return nVar.g();
        }
        if (i != 3) {
            return nVar.h();
        }
        return nVar.i();
    }

    private float a(RectF rectF, int i) {
        float[] fArr = this.f13546f;
        q[] qVarArr = this.f13541a;
        fArr[0] = qVarArr[i].f13557c;
        fArr[1] = qVarArr[i].f13558d;
        this.f13542b[i].mapPoints(fArr);
        if (i != 1 && i != 3) {
            return Math.abs(rectF.centerY() - this.f13546f[1]);
        }
        return Math.abs(rectF.centerX() - this.f13546f[0]);
    }

    private c a(int i, n nVar) {
        if (i == 1) {
            return nVar.f();
        }
        if (i == 2) {
            return nVar.d();
        }
        if (i != 3) {
            return nVar.m();
        }
        return nVar.k();
    }

    private d b(int i, n nVar) {
        if (i == 1) {
            return nVar.e();
        }
        if (i == 2) {
            return nVar.c();
        }
        if (i != 3) {
            return nVar.l();
        }
        return nVar.j();
    }

    private void a(int i, RectF rectF, PointF pointF) {
        if (i == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }
}
