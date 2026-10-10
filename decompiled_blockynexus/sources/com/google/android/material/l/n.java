package com.google.android.material.l;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13529a = new k(0.5f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f13530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f13531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f13532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f13533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    c f13534f;
    c g;
    c h;
    c i;
    f j;
    f k;
    f l;
    f m;

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f13535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f13536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f13537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f13538d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private c f13539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f13540f;
        private c g;
        private c h;
        private f i;
        private f j;
        private f k;
        private f l;

        public a() {
            this.f13535a = j.a();
            this.f13536b = j.a();
            this.f13537c = j.a();
            this.f13538d = j.a();
            this.f13539e = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.f13540f = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.g = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.h = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.i = j.b();
            this.j = j.b();
            this.k = j.b();
            this.l = j.b();
        }

        public a a(float f2) {
            d(f2);
            e(f2);
            c(f2);
            b(f2);
            return this;
        }

        public a b(c cVar) {
            this.g = cVar;
            return this;
        }

        public a c(c cVar) {
            this.f13539e = cVar;
            return this;
        }

        public a d(float f2) {
            this.f13539e = new com.google.android.material.l.a(f2);
            return this;
        }

        public a e(float f2) {
            this.f13540f = new com.google.android.material.l.a(f2);
            return this;
        }

        private static float e(d dVar) {
            if (dVar instanceof l) {
                return ((l) dVar).f13528a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f13511a;
            }
            return -1.0f;
        }

        public a b(float f2) {
            this.h = new com.google.android.material.l.a(f2);
            return this;
        }

        public a c(float f2) {
            this.g = new com.google.android.material.l.a(f2);
            return this;
        }

        public a d(c cVar) {
            this.f13540f = cVar;
            return this;
        }

        public a b(int i, c cVar) {
            b(j.a(i));
            b(cVar);
            return this;
        }

        public a c(int i, c cVar) {
            c(j.a(i));
            c(cVar);
            return this;
        }

        public a d(int i, c cVar) {
            d(j.a(i));
            d(cVar);
            return this;
        }

        public a a(c cVar) {
            this.h = cVar;
            return this;
        }

        public a b(d dVar) {
            this.f13537c = dVar;
            float fE = e(dVar);
            if (fE != -1.0f) {
                c(fE);
            }
            return this;
        }

        public a c(d dVar) {
            this.f13535a = dVar;
            float fE = e(dVar);
            if (fE != -1.0f) {
                d(fE);
            }
            return this;
        }

        public a d(d dVar) {
            this.f13536b = dVar;
            float fE = e(dVar);
            if (fE != -1.0f) {
                e(fE);
            }
            return this;
        }

        public a a(int i, c cVar) {
            a(j.a(i));
            a(cVar);
            return this;
        }

        public a a(d dVar) {
            this.f13538d = dVar;
            float fE = e(dVar);
            if (fE != -1.0f) {
                b(fE);
            }
            return this;
        }

        public a a(f fVar) {
            this.i = fVar;
            return this;
        }

        public n a() {
            return new n(this);
        }

        public a(n nVar) {
            this.f13535a = j.a();
            this.f13536b = j.a();
            this.f13537c = j.a();
            this.f13538d = j.a();
            this.f13539e = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.f13540f = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.g = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.h = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
            this.i = j.b();
            this.j = j.b();
            this.k = j.b();
            this.l = j.b();
            this.f13535a = nVar.f13530b;
            this.f13536b = nVar.f13531c;
            this.f13537c = nVar.f13532d;
            this.f13538d = nVar.f13533e;
            this.f13539e = nVar.f13534f;
            this.f13540f = nVar.g;
            this.g = nVar.h;
            this.h = nVar.i;
            this.i = nVar.j;
            this.j = nVar.k;
            this.k = nVar.l;
            this.l = nVar.m;
        }
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public interface b {
        c a(c cVar);
    }

    public static a a() {
        return new a();
    }

    public f b() {
        return this.l;
    }

    public d c() {
        return this.f13533e;
    }

    public c d() {
        return this.i;
    }

    public d e() {
        return this.f13532d;
    }

    public c f() {
        return this.h;
    }

    public f g() {
        return this.m;
    }

    public f h() {
        return this.k;
    }

    public f i() {
        return this.j;
    }

    public d j() {
        return this.f13530b;
    }

    public c k() {
        return this.f13534f;
    }

    public d l() {
        return this.f13531c;
    }

    public c m() {
        return this.g;
    }

    public a n() {
        return new a(this);
    }

    private n(a aVar) {
        this.f13530b = aVar.f13535a;
        this.f13531c = aVar.f13536b;
        this.f13532d = aVar.f13537c;
        this.f13533e = aVar.f13538d;
        this.f13534f = aVar.f13539e;
        this.g = aVar.f13540f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
    }

    public static a a(Context context, AttributeSet attributeSet, int i, int i2) {
        return a(context, attributeSet, i, i2, 0);
    }

    public static a a(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return a(context, attributeSet, i, i2, new com.google.android.material.l.a(i3));
    }

    public static a a(Context context, AttributeSet attributeSet, int i, int i2, c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    public static a a(Context context, int i, int i2) {
        return a(context, i, i2, 0);
    }

    private static a a(Context context, int i, int i2, int i3) {
        return a(context, i, i2, new com.google.android.material.l.a(i3));
    }

    private static a a(Context context, int i, int i2, c cVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            c cVarA = a(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cVar);
            c cVarA2 = a(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, cVarA);
            c cVarA3 = a(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, cVarA);
            c cVarA4 = a(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, cVarA);
            c cVarA5 = a(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, cVarA);
            a aVar = new a();
            aVar.c(i4, cVarA2);
            aVar.d(i5, cVarA3);
            aVar.b(i6, cVarA4);
            aVar.a(i7, cVarA5);
            return aVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public n() {
        this.f13530b = j.a();
        this.f13531c = j.a();
        this.f13532d = j.a();
        this.f13533e = j.a();
        this.f13534f = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
        this.g = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
        this.h = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
        this.i = new com.google.android.material.l.a(WheelView.DividerConfig.FILL);
        this.j = j.b();
        this.k = j.b();
        this.l = j.b();
        this.m = j.b();
    }

    private static c a(TypedArray typedArray, int i, c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i2 = typedValuePeekValue.type;
        if (i2 == 5) {
            return new com.google.android.material.l.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i2 == 6 ? new k(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public n a(float f2) {
        a aVarN = n();
        aVarN.a(f2);
        return aVarN.a();
    }

    public n a(b bVar) {
        a aVarN = n();
        aVarN.c(bVar.a(k()));
        aVarN.d(bVar.a(m()));
        aVarN.a(bVar.a(d()));
        aVarN.b(bVar.a(f()));
        return aVarN.a();
    }

    public boolean a(RectF rectF) {
        boolean z = this.m.getClass().equals(f.class) && this.k.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.l.getClass().equals(f.class);
        float fA = this.f13534f.a(rectF);
        return z && ((this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0 && (this.i.a(rectF) > fA ? 1 : (this.i.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f13531c instanceof l) && (this.f13530b instanceof l) && (this.f13532d instanceof l) && (this.f13533e instanceof l));
    }
}
