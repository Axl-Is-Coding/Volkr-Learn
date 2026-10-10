package com.google.android.material.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.l.o;
import com.google.android.material.l.q;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends Drawable implements androidx.core.graphics.drawable.b, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f13515a = new Paint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f13516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q.f[] f13517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q.f[] f13518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Matrix f13520f;
    private final Path g;
    private final Path h;
    private final RectF i;
    private final RectF j;
    private final Region k;
    private final Region l;
    private n m;
    private final Paint n;
    private final Paint o;
    private final com.google.android.material.k.a p;
    private final o.a q;
    private final o r;
    private PorterDuffColorFilter s;
    private PorterDuffColorFilter t;
    private Rect u;
    private final RectF v;

    /* synthetic */ i(a aVar, g gVar) {
        this(aVar);
    }

    private boolean A() {
        return Build.VERSION.SDK_INT < 21 || !(s() || this.g.isConvex());
    }

    private boolean B() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        a aVar = this.f13516b;
        this.s = a(aVar.g, aVar.h, this.n, true);
        a aVar2 = this.f13516b;
        this.t = a(aVar2.f13526f, aVar2.h, this.o, false);
        a aVar3 = this.f13516b;
        if (aVar3.u) {
            this.p.a(aVar3.g.getColorForState(getState(), 0));
        }
        return (androidx.core.f.c.a(porterDuffColorFilter, this.s) && androidx.core.f.c.a(porterDuffColorFilter2, this.t)) ? false : true;
    }

    private void C() {
        float fQ = q();
        this.f13516b.r = (int) Math.ceil(0.75f * fQ);
        this.f13516b.s = (int) Math.ceil(fQ * 0.25f);
        B();
        z();
    }

    private static int a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void t() {
        this.m = l().a(new h(this, -v()));
        this.r.a(this.m, this.f13516b.k, u(), this.h);
    }

    private RectF u() {
        RectF rectFD = d();
        float fV = v();
        this.j.set(rectFD.left + fV, rectFD.top + fV, rectFD.right - fV, rectFD.bottom - fV);
        return this.j;
    }

    private float v() {
        return y() ? this.o.getStrokeWidth() / 2.0f : WheelView.DividerConfig.FILL;
    }

    private boolean w() {
        a aVar = this.f13516b;
        int i = aVar.q;
        return i != 1 && aVar.r > 0 && (i == 2 || A());
    }

    private boolean x() {
        Paint.Style style = this.f13516b.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean y() {
        Paint.Style style = this.f13516b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > WheelView.DividerConfig.FILL;
    }

    private void z() {
        super.invalidateSelf();
    }

    public void c(int i) {
        a aVar = this.f13516b;
        if (aVar.q != i) {
            aVar.q = i;
            z();
        }
    }

    protected RectF d() {
        Rect bounds = getBounds();
        this.i.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(a(alpha, this.f13516b.m));
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.f13516b.l);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(a(alpha2, this.f13516b.m));
        if (this.f13519e) {
            t();
            b(d(), this.g);
            this.f13519e = false;
        }
        if (w()) {
            canvas.save();
            d(canvas);
            int iWidth = (int) (this.v.width() - getBounds().width());
            int iHeight = (int) (this.v.height() - getBounds().height());
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.v.width()) + (this.f13516b.r * 2) + iWidth, ((int) this.v.height()) + (this.f13516b.r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f2 = (getBounds().left - this.f13516b.r) - iWidth;
            float f3 = (getBounds().top - this.f13516b.r) - iHeight;
            canvas2.translate(-f2, -f3);
            a(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f2, f3, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
        if (x()) {
            b(canvas);
        }
        if (y()) {
            c(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    public void e(float f2) {
        this.f13516b.l = f2;
        invalidateSelf();
    }

    public ColorStateList f() {
        return this.f13516b.f13524d;
    }

    public float g() {
        return this.f13516b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f13516b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f13516b.q == 2) {
            return;
        }
        if (s()) {
            outline.setRoundRect(getBounds(), n());
        } else {
            b(d(), this.g);
            if (this.g.isConvex()) {
                outline.setConvexPath(this.g);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.u;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.k.set(getBounds());
        b(d(), this.g);
        this.l.setPath(this.g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    public float h() {
        return this.f13516b.n;
    }

    public int i() {
        double d2 = this.f13516b.s;
        double dSin = Math.sin(Math.toRadians(r0.t));
        Double.isNaN(d2);
        return (int) (d2 * dSin);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f13519e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f13516b.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f13516b.f13526f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f13516b.f13525e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f13516b.f13524d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        double d2 = this.f13516b.s;
        double dCos = Math.cos(Math.toRadians(r0.t));
        Double.isNaN(d2);
        return (int) (d2 * dCos);
    }

    public int k() {
        return this.f13516b.r;
    }

    public n l() {
        return this.f13516b.f13521a;
    }

    public ColorStateList m() {
        return this.f13516b.g;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f13516b = new a(this.f13516b);
        return this;
    }

    public float n() {
        return this.f13516b.f13521a.k().a(d());
    }

    public float o() {
        return this.f13516b.f13521a.m().a(d());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f13519e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.p.a
    protected boolean onStateChange(int[] iArr) {
        boolean z = a(iArr) || B();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public float p() {
        return this.f13516b.p;
    }

    public float q() {
        return e() + p();
    }

    public boolean r() {
        com.google.android.material.f.a aVar = this.f13516b.f13522b;
        return aVar != null && aVar.a();
    }

    public boolean s() {
        return this.f13516b.f13521a.a(d());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        a aVar = this.f13516b;
        if (aVar.m != i) {
            aVar.m = i;
            z();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13516b.f13523c = colorFilter;
        z();
    }

    @Override // com.google.android.material.l.r
    public void setShapeAppearanceModel(n nVar) {
        this.f13516b.f13521a = nVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f13516b.g = colorStateList;
        B();
        z();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        a aVar = this.f13516b;
        if (aVar.h != mode) {
            aVar.h = mode;
            B();
            z();
        }
    }

    public i() {
        this(new n());
    }

    public void b(ColorStateList colorStateList) {
        a aVar = this.f13516b;
        if (aVar.f13525e != colorStateList) {
            aVar.f13525e = colorStateList;
            onStateChange(getState());
        }
    }

    public i(Context context, AttributeSet attributeSet, int i, int i2) {
        this(n.a(context, attributeSet, i, i2).a());
    }

    public static i a(Context context, float f2) {
        int iA = com.google.android.material.d.a.a(context, R.attr.colorSurface, i.class.getSimpleName());
        i iVar = new i();
        iVar.a(context);
        iVar.a(ColorStateList.valueOf(iA));
        iVar.b(f2);
        return iVar;
    }

    public float e() {
        return this.f13516b.o;
    }

    public i(n nVar) {
        this(new a(nVar, null));
    }

    private int d(int i) {
        float fQ = q() + h();
        com.google.android.material.f.a aVar = this.f13516b.f13522b;
        return aVar != null ? aVar.b(i, fQ) : i;
    }

    public void c(float f2) {
        a aVar = this.f13516b;
        if (aVar.k != f2) {
            aVar.k = f2;
            this.f13519e = true;
            invalidateSelf();
        }
    }

    private i(a aVar) {
        this.f13517c = new q.f[4];
        this.f13518d = new q.f[4];
        this.f13520f = new Matrix();
        this.g = new Path();
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        this.n = new Paint(1);
        this.o = new Paint(1);
        this.p = new com.google.android.material.k.a();
        this.r = new o();
        this.v = new RectF();
        this.f13516b = aVar;
        this.o.setStyle(Paint.Style.STROKE);
        this.n.setStyle(Paint.Style.FILL);
        f13515a.setColor(-1);
        f13515a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        B();
        a(getState());
        this.q = new g(this);
    }

    public void b(float f2) {
        a aVar = this.f13516b;
        if (aVar.o != f2) {
            aVar.o = f2;
            C();
        }
    }

    public void d(float f2) {
        a aVar = this.f13516b;
        if (aVar.n != f2) {
            aVar.n = f2;
            C();
        }
    }

    private void c(Canvas canvas) {
        a(canvas, this.o, this.h, this.m, u());
    }

    public void b(int i) {
        a aVar = this.f13516b;
        if (aVar.t != i) {
            aVar.t = i;
            z();
        }
    }

    private void d(Canvas canvas) {
        int i = i();
        int iJ = j();
        if (Build.VERSION.SDK_INT < 21) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.f13516b.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(i, iJ);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(i, iJ);
    }

    public void a(ColorStateList colorStateList) {
        a aVar = this.f13516b;
        if (aVar.f13524d != colorStateList) {
            aVar.f13524d = colorStateList;
            onStateChange(getState());
        }
    }

    private void b(Canvas canvas) {
        a(canvas, this.n, this.g, this.f13516b.f13521a, d());
    }

    public float c() {
        return this.f13516b.f13521a.f().a(d());
    }

    private void b(RectF rectF, Path path) {
        a(rectF, path);
        if (this.f13516b.j != 1.0f) {
            this.f13520f.reset();
            Matrix matrix = this.f13520f;
            float f2 = this.f13516b.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f13520f);
        }
        path.computeBounds(this.v, true);
    }

    public void a(float f2, int i) {
        e(f2);
        b(ColorStateList.valueOf(i));
    }

    public void a(float f2, ColorStateList colorStateList) {
        e(f2);
        b(colorStateList);
    }

    public void a(float f2) {
        setShapeAppearanceModel(this.f13516b.f13521a.a(f2));
    }

    public void a(int i, int i2, int i3, int i4) {
        a aVar = this.f13516b;
        if (aVar.i == null) {
            aVar.i = new Rect();
        }
        this.f13516b.i.set(i, i2, i3, i4);
        this.u = this.f13516b.i;
        invalidateSelf();
    }

    public float b() {
        return this.f13516b.f13521a.d().a(d());
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f13521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.google.android.material.f.a f13522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorFilter f13523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f13524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f13525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f13526f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public a(n nVar, com.google.android.material.f.a aVar) {
            this.f13524d = null;
            this.f13525e = null;
            this.f13526f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = WheelView.DividerConfig.FILL;
            this.o = WheelView.DividerConfig.FILL;
            this.p = WheelView.DividerConfig.FILL;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f13521a = nVar;
            this.f13522b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i(this, null);
            iVar.f13519e = true;
            return iVar;
        }

        public a(a aVar) {
            this.f13524d = null;
            this.f13525e = null;
            this.f13526f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = WheelView.DividerConfig.FILL;
            this.o = WheelView.DividerConfig.FILL;
            this.p = WheelView.DividerConfig.FILL;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f13521a = aVar.f13521a;
            this.f13522b = aVar.f13522b;
            this.l = aVar.l;
            this.f13523c = aVar.f13523c;
            this.f13524d = aVar.f13524d;
            this.f13525e = aVar.f13525e;
            this.h = aVar.h;
            this.g = aVar.g;
            this.m = aVar.m;
            this.j = aVar.j;
            this.s = aVar.s;
            this.q = aVar.q;
            this.u = aVar.u;
            this.k = aVar.k;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.r = aVar.r;
            this.t = aVar.t;
            this.f13526f = aVar.f13526f;
            this.v = aVar.v;
            Rect rect = aVar.i;
            if (rect != null) {
                this.i = new Rect(rect);
            }
        }
    }

    public void a(Context context) {
        this.f13516b.f13522b = new com.google.android.material.f.a(context);
        C();
    }

    public void a(int i) {
        this.p.a(i);
        this.f13516b.u = false;
        z();
    }

    public void a(Paint.Style style) {
        this.f13516b.v = style;
        z();
    }

    protected void a(Canvas canvas, Paint paint, Path path, RectF rectF) {
        a(canvas, paint, path, this.f13516b.f13521a, rectF);
    }

    private void a(Canvas canvas, Paint paint, Path path, n nVar, RectF rectF) {
        if (nVar.a(rectF)) {
            float fA = nVar.m().a(rectF);
            canvas.drawRoundRect(rectF, fA, fA, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    private void a(Canvas canvas) {
        if (this.f13516b.s != 0) {
            canvas.drawPath(this.g, this.p.a());
        }
        for (int i = 0; i < 4; i++) {
            this.f13517c[i].a(this.p, this.f13516b.r, canvas);
            this.f13518d[i].a(this.p, this.f13516b.r, canvas);
        }
        int i2 = i();
        int iJ = j();
        canvas.translate(-i2, -iJ);
        canvas.drawPath(this.g, f13515a);
        canvas.translate(i2, iJ);
    }

    protected final void a(RectF rectF, Path path) {
        o oVar = this.r;
        a aVar = this.f13516b;
        oVar.a(aVar.f13521a, aVar.k, rectF, this.q, path);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        if (colorStateList != null && mode != null) {
            return a(colorStateList, mode, z);
        }
        return a(paint, z);
    }

    private PorterDuffColorFilter a(Paint paint, boolean z) {
        int color;
        int iD;
        if (!z || (iD = d((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iD, PorterDuff.Mode.SRC_IN);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = d(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f13516b.f13524d == null || color2 == (colorForState2 = this.f13516b.f13524d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.f13516b.f13525e == null || color == (colorForState = this.f13516b.f13525e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }
}
