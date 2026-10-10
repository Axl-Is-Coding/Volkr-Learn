package com.google.android.material.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f13555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f13556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f13557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f13558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f13559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f13560f;
    private final List<e> g = new ArrayList();
    private final List<f> h = new ArrayList();

    /* JADX INFO: compiled from: ShapePath.java */
    static class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f13561b;

        public a(c cVar) {
            this.f13561b = cVar;
        }

        @Override // com.google.android.material.l.q.f
        public void a(Matrix matrix, com.google.android.material.k.a aVar, int i, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f13561b.b(), this.f13561b.f(), this.f13561b.c(), this.f13561b.a()), i, this.f13561b.d(), this.f13561b.e());
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final RectF f13565b = new RectF();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f13566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f13567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f13568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f13569f;

        @Deprecated
        public float g;

        @Deprecated
        public float h;

        public c(float f2, float f3, float f4, float f5) {
            b(f2);
            f(f3);
            c(f4);
            a(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float c() {
            return this.f13568e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float d() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float e() {
            return this.h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float f() {
            return this.f13567d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float b() {
            return this.f13566c;
        }

        private void c(float f2) {
            this.f13568e = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(float f2) {
            this.g = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(float f2) {
            this.h = f2;
        }

        private void f(float f2) {
            this.f13567d = f2;
        }

        @Override // com.google.android.material.l.q.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f13572a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f13565b.set(b(), f(), c(), a());
            path.arcTo(f13565b, d(), e(), false);
            path.transform(matrix);
        }

        private void b(float f2) {
            this.f13566c = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float a() {
            return this.f13569f;
        }

        private void a(float f2) {
            this.f13569f = f2;
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f13570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f13571c;

        @Override // com.google.android.material.l.q.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f13572a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f13570b, this.f13571c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f13572a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Matrix f13573a = new Matrix();

        f() {
        }

        public abstract void a(Matrix matrix, com.google.android.material.k.a aVar, int i, Canvas canvas);

        public final void a(com.google.android.material.k.a aVar, int i, Canvas canvas) {
            a(f13573a, aVar, i, canvas);
        }
    }

    public q() {
        b(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
    }

    private float e() {
        return this.f13559e;
    }

    private float f() {
        return this.f13560f;
    }

    private void g(float f2) {
        this.f13556b = f2;
    }

    public void a(float f2, float f3, float f4, float f5) {
        f(f2);
        g(f3);
        d(f2);
        e(f3);
        b(f4);
        c((f4 + f5) % 360.0f);
        this.g.clear();
        this.h.clear();
    }

    public void b(float f2, float f3) {
        a(f2, f3, 270.0f, WheelView.DividerConfig.FILL);
    }

    float c() {
        return this.f13555a;
    }

    float d() {
        return this.f13556b;
    }

    private void c(float f2) {
        this.f13560f = f2;
    }

    private void d(float f2) {
        this.f13557c = f2;
    }

    private void e(float f2) {
        this.f13558d = f2;
    }

    private void f(float f2) {
        this.f13555a = f2;
    }

    float b() {
        return this.f13558d;
    }

    private void b(float f2) {
        this.f13559e = f2;
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class b extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f13562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f13563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f13564d;

        public b(d dVar, float f2, float f3) {
            this.f13562b = dVar;
            this.f13563c = f2;
            this.f13564d = f3;
        }

        @Override // com.google.android.material.l.q.f
        public void a(Matrix matrix, com.google.android.material.k.a aVar, int i, Canvas canvas) {
            RectF rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (float) Math.hypot(this.f13562b.f13571c - this.f13564d, this.f13562b.f13570b - this.f13563c), WheelView.DividerConfig.FILL);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f13563c, this.f13564d);
            matrix2.preRotate(a());
            aVar.a(canvas, matrix2, rectF, i);
        }

        float a() {
            return (float) Math.toDegrees(Math.atan((this.f13562b.f13571c - this.f13564d) / (this.f13562b.f13570b - this.f13563c)));
        }
    }

    public void a(float f2, float f3) {
        d dVar = new d();
        dVar.f13570b = f2;
        dVar.f13571c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, a(), b());
        a(bVar, bVar.a() + 270.0f, bVar.a() + 270.0f);
        d(f2);
        e(f3);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.d(f6);
        cVar.e(f7);
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < WheelView.DividerConfig.FILL;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        a(aVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        d(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        e(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    f a(Matrix matrix) {
        a(f());
        return new p(this, new ArrayList(this.h), matrix);
    }

    private void a(f fVar, float f2, float f3) {
        a(f2);
        this.h.add(fVar);
        b(f3);
    }

    private void a(float f2) {
        if (e() == f2) {
            return;
        }
        float fE = ((f2 - e()) + 360.0f) % 360.0f;
        if (fE > 180.0f) {
            return;
        }
        c cVar = new c(a(), b(), a(), b());
        cVar.d(e());
        cVar.e(fE);
        this.h.add(new a(cVar));
        b(f2);
    }

    float a() {
        return this.f13557c;
    }
}
