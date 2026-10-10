package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.a.b;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.dlog.DLog;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: VectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final PorterDuff.Mode f2343b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f2344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuffColorFilter f2345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorFilter f2346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2347f;
    private boolean g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class a extends e {
        a() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.a.i.a(xmlPullParser, "pathData")) {
                TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2332d);
                a(typedArrayA, xmlPullParser);
                typedArrayA.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.k.e
        public boolean b() {
            return true;
        }

        a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2357b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2356a = androidx.core.a.b.a(string2);
            }
            this.f2358c = androidx.core.content.a.i.b(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static abstract class d {
        private d() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class g extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f f2367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f2368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f2369d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f2370e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f2371f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.f2368c = null;
            this.f2369d = k.f2343b;
            if (gVar != null) {
                this.f2366a = gVar.f2366a;
                this.f2367b = new f(gVar.f2367b);
                Paint paint = gVar.f2367b.f2365f;
                if (paint != null) {
                    this.f2367b.f2365f = new Paint(paint);
                }
                Paint paint2 = gVar.f2367b.f2364e;
                if (paint2 != null) {
                    this.f2367b.f2364e = new Paint(paint2);
                }
                this.f2368c = gVar.f2368c;
                this.f2369d = gVar.f2369d;
                this.f2370e = gVar.f2370e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2371f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f2367b.getRootAlpha() < 255;
        }

        public void c(int i, int i2) {
            this.f2371f.eraseColor(0);
            this.f2367b.a(new Canvas(this.f2371f), i, i2, (ColorFilter) null);
        }

        public void d() {
            this.g = this.f2368c;
            this.h = this.f2369d;
            this.i = this.f2367b.getRootAlpha();
            this.j = this.f2370e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2366a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k(this);
        }

        public void b(int i, int i2) {
            if (this.f2371f == null || !a(i, i2)) {
                this.f2371f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new k(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (!b() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f2367b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean c() {
            return this.f2367b.a();
        }

        public boolean a(int i, int i2) {
            return i == this.f2371f.getWidth() && i2 == this.f2371f.getHeight();
        }

        public boolean a() {
            return !this.k && this.g == this.f2368c && this.h == this.f2369d && this.j == this.f2370e && this.i == this.f2367b.getRootAlpha();
        }

        public g() {
            this.f2368c = null;
            this.f2369d = k.f2343b;
            this.f2367b = new f();
        }

        public boolean a(int[] iArr) {
            boolean zA = this.f2367b.a(iArr);
            this.k |= zA;
            return zA;
        }
    }

    k() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f2344c = new g();
    }

    public static k createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        k kVar = new k();
        kVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    Object a(String str) {
        return this.f2344c.f2367b.q.get(str);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2342a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.a(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() <= 0 || this.k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2346e;
        if (colorFilter == null) {
            colorFilter = this.f2345d;
        }
        canvas.getMatrix(this.j);
        this.j.getValues(this.i);
        float fAbs = Math.abs(this.i[0]);
        float fAbs2 = Math.abs(this.i[4]);
        float fAbs3 = Math.abs(this.i[1]);
        float fAbs4 = Math.abs(this.i[3]);
        if (fAbs3 != WheelView.DividerConfig.FILL || fAbs4 != WheelView.DividerConfig.FILL) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(DLog.CRS, (int) (this.k.width() * fAbs));
        int iMin2 = Math.min(DLog.CRS, (int) (this.k.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.k;
        canvas.translate(rect.left, rect.top);
        if (a()) {
            canvas.translate(this.k.width(), WheelView.DividerConfig.FILL);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k.offsetTo(0, 0);
        this.f2344c.b(iMin, iMin2);
        if (!this.g) {
            this.f2344c.c(iMin, iMin2);
        } else if (!this.f2344c.a()) {
            this.f2344c.c(iMin, iMin2);
            this.f2344c.d();
        }
        this.f2344c.a(canvas, colorFilter, this.k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2342a;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f2344c.f2367b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2344c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2342a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f2346e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f2342a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new h(drawable.getConstantState());
        }
        this.f2344c.f2366a = getChangingConfigurations();
        return this.f2344c;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2344c.f2367b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2344c.f2367b.j;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2342a;
        return drawable != null ? androidx.core.graphics.drawable.a.f(drawable) : this.f2344c.f2370e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        g gVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((gVar = this.f2344c) != null && (gVar.c() || ((colorStateList = this.f2344c.f2368c) != null && colorStateList.isStateful())));
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2347f && super.mutate() == this) {
            this.f2344c = new g(this.f2344c);
            this.f2347f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f2344c;
        ColorStateList colorStateList = gVar.f2368c;
        if (colorStateList != null && (mode = gVar.f2369d) != null) {
            this.f2345d = a(this.f2345d, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!gVar.c() || !gVar.a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f2344c.f2367b.getRootAlpha() != i) {
            this.f2344c.f2367b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f2344c.f2370e = z;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            return;
        }
        g gVar = this.f2344c;
        if (gVar.f2368c != colorStateList) {
            gVar.f2368c = colorStateList;
            this.f2345d = a(this.f2345d, colorStateList, gVar.f2369d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
            return;
        }
        g gVar = this.f2344c;
        if (gVar.f2369d != mode) {
            gVar.f2369d = mode;
            this.f2345d = a(this.f2345d, gVar.f2368c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f2372a;

        public h(Drawable.ConstantState constantState) {
            this.f2372a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2372a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2372a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            k kVar = new k();
            kVar.f2342a = (VectorDrawable) this.f2372a.newDrawable();
            return kVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            k kVar = new k();
            kVar.f2342a = (VectorDrawable) this.f2372a.newDrawable(resources);
            return kVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            k kVar = new k();
            kVar.f2342a = (VectorDrawable) this.f2372a.newDrawable(resources, theme);
            return kVar;
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2346e = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class b extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f2348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        androidx.core.content.a.b f2349f;
        float g;
        androidx.core.content.a.b h;
        float i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        b() {
            this.g = WheelView.DividerConfig.FILL;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = WheelView.DividerConfig.FILL;
            this.l = 1.0f;
            this.m = WheelView.DividerConfig.FILL;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        private Paint.Cap a(int i, Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.h.a();
        }

        float getStrokeAlpha() {
            return this.i;
        }

        int getStrokeColor() {
            return this.f2349f.a();
        }

        float getStrokeWidth() {
            return this.g;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f2) {
            this.j = f2;
        }

        void setFillColor(int i) {
            this.h.b(i);
        }

        void setStrokeAlpha(float f2) {
            this.i = f2;
        }

        void setStrokeColor(int i) {
            this.f2349f.b(i);
        }

        void setStrokeWidth(float f2) {
            this.g = f2;
        }

        void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        void setTrimPathStart(float f2) {
            this.k = f2;
        }

        private Paint.Join a(int i, Paint.Join join) {
            if (i == 0) {
                return Paint.Join.MITER;
            }
            if (i != 1) {
                return i != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2331c);
            a(typedArrayA, xmlPullParser, theme);
            typedArrayA.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2348e = null;
            if (androidx.core.content.a.i.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2357b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2356a = androidx.core.a.b.a(string2);
                }
                this.h = androidx.core.content.a.i.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = androidx.core.content.a.i.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(androidx.core.content.a.i.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(androidx.core.content.a.i.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.a.i.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f2349f = androidx.core.content.a.i.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.i = androidx.core.content.a.i.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.i);
                this.g = androidx.core.content.a.i.a(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
                this.l = androidx.core.content.a.i.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = androidx.core.content.a.i.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = androidx.core.content.a.i.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.f2358c = androidx.core.content.a.i.b(typedArray, xmlPullParser, "fillType", 13, this.f2358c);
            }
        }

        b(b bVar) {
            super(bVar);
            this.g = WheelView.DividerConfig.FILL;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = WheelView.DividerConfig.FILL;
            this.l = 1.0f;
            this.m = WheelView.DividerConfig.FILL;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f2348e = bVar.f2348e;
            this.f2349f = bVar.f2349f;
            this.g = bVar.g;
            this.i = bVar.i;
            this.h = bVar.h;
            this.f2358c = bVar.f2358c;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
        }

        @Override // androidx.vectordrawable.graphics.drawable.k.d
        public boolean a() {
            return this.h.d() || this.f2349f.d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.k.d
        public boolean a(int[] iArr) {
            return this.f2349f.a(iArr) | this.h.a(iArr);
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f2350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList<d> f2351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f2352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f2353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f2354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f2355f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public c(c cVar, a.a.b<String, Object> bVar) {
            e aVar;
            super();
            this.f2350a = new Matrix();
            this.f2351b = new ArrayList<>();
            this.f2352c = WheelView.DividerConfig.FILL;
            this.f2353d = WheelView.DividerConfig.FILL;
            this.f2354e = WheelView.DividerConfig.FILL;
            this.f2355f = 1.0f;
            this.g = 1.0f;
            this.h = WheelView.DividerConfig.FILL;
            this.i = WheelView.DividerConfig.FILL;
            this.j = new Matrix();
            this.m = null;
            this.f2352c = cVar.f2352c;
            this.f2353d = cVar.f2353d;
            this.f2354e = cVar.f2354e;
            this.f2355f = cVar.f2355f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            String str = this.m;
            if (str != null) {
                bVar.put(str, this);
            }
            this.j.set(cVar.j);
            ArrayList<d> arrayList = cVar.f2351b;
            for (int i = 0; i < arrayList.size(); i++) {
                d dVar = arrayList.get(i);
                if (dVar instanceof c) {
                    this.f2351b.add(new c((c) dVar, bVar));
                } else {
                    if (dVar instanceof b) {
                        aVar = new b((b) dVar);
                    } else {
                        if (!(dVar instanceof a)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        aVar = new a((a) dVar);
                    }
                    this.f2351b.add(aVar);
                    String str2 = aVar.f2357b;
                    if (str2 != null) {
                        bVar.put(str2, aVar);
                    }
                }
            }
        }

        private void b() {
            this.j.reset();
            this.j.postTranslate(-this.f2353d, -this.f2354e);
            this.j.postScale(this.f2355f, this.g);
            this.j.postRotate(this.f2352c, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
            this.j.postTranslate(this.h + this.f2353d, this.i + this.f2354e);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2330b);
            a(typedArrayA, xmlPullParser);
            typedArrayA.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f2353d;
        }

        public float getPivotY() {
            return this.f2354e;
        }

        public float getRotation() {
            return this.f2352c;
        }

        public float getScaleX() {
            return this.f2355f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f2353d) {
                this.f2353d = f2;
                b();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f2354e) {
                this.f2354e = f2;
                b();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f2352c) {
                this.f2352c = f2;
                b();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f2355f) {
                this.f2355f = f2;
                b();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                b();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                b();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                b();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f2352c = androidx.core.content.a.i.a(typedArray, xmlPullParser, "rotation", 5, this.f2352c);
            this.f2353d = typedArray.getFloat(1, this.f2353d);
            this.f2354e = typedArray.getFloat(2, this.f2354e);
            this.f2355f = androidx.core.content.a.i.a(typedArray, xmlPullParser, "scaleX", 3, this.f2355f);
            this.g = androidx.core.content.a.i.a(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = androidx.core.content.a.i.a(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = androidx.core.content.a.i.a(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        @Override // androidx.vectordrawable.graphics.drawable.k.d
        public boolean a() {
            for (int i = 0; i < this.f2351b.size(); i++) {
                if (this.f2351b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.k.d
        public boolean a(int[] iArr) {
            boolean zA = false;
            for (int i = 0; i < this.f2351b.size(); i++) {
                zA |= this.f2351b.get(i).a(iArr);
            }
            return zA;
        }

        public c() {
            super();
            this.f2350a = new Matrix();
            this.f2351b = new ArrayList<>();
            this.f2352c = WheelView.DividerConfig.FILL;
            this.f2353d = WheelView.DividerConfig.FILL;
            this.f2354e = WheelView.DividerConfig.FILL;
            this.f2355f = 1.0f;
            this.g = 1.0f;
            this.h = WheelView.DividerConfig.FILL;
            this.i = WheelView.DividerConfig.FILL;
            this.j = new Matrix();
            this.m = null;
        }
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static abstract class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected b.C0007b[] f2356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2359d;

        public e() {
            super();
            this.f2356a = null;
            this.f2358c = 0;
        }

        public void a(Path path) {
            path.reset();
            b.C0007b[] c0007bArr = this.f2356a;
            if (c0007bArr != null) {
                b.C0007b.a(c0007bArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public b.C0007b[] getPathData() {
            return this.f2356a;
        }

        public String getPathName() {
            return this.f2357b;
        }

        public void setPathData(b.C0007b[] c0007bArr) {
            if (androidx.core.a.b.a(this.f2356a, c0007bArr)) {
                androidx.core.a.b.b(this.f2356a, c0007bArr);
            } else {
                this.f2356a = androidx.core.a.b.a(c0007bArr);
            }
        }

        public e(e eVar) {
            super();
            this.f2356a = null;
            this.f2358c = 0;
            this.f2357b = eVar.f2357b;
            this.f2359d = eVar.f2359d;
            this.f2356a = androidx.core.a.b.a(eVar.f2356a);
        }
    }

    public static k a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            k kVar = new k();
            kVar.f2342a = androidx.core.content.a.h.a(resources, i, theme);
            kVar.h = new h(kVar.f2342a.getConstantState());
            return kVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f2344c;
        gVar.f2367b = new f();
        TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2329a);
        a(typedArrayA, xmlPullParser, theme);
        typedArrayA.recycle();
        gVar.f2366a = getChangingConfigurations();
        gVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f2345d = a(this.f2345d, gVar.f2368c, gVar.f2369d);
    }

    k(g gVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f2344c = gVar;
        this.f2345d = a(this.f2345d, gVar.f2368c, gVar.f2369d);
    }

    /* JADX INFO: compiled from: VectorDrawableCompat.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Matrix f2360a = new Matrix();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f2361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Path f2362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Matrix f2363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f2364e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Paint f2365f;
        private PathMeasure g;
        private int h;
        final c i;
        float j;
        float k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final a.a.b<String, Object> q;

        public f() {
            this.f2363d = new Matrix();
            this.j = WheelView.DividerConfig.FILL;
            this.k = WheelView.DividerConfig.FILL;
            this.l = WheelView.DividerConfig.FILL;
            this.m = WheelView.DividerConfig.FILL;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.a.b<>();
            this.i = new c();
            this.f2361b = new Path();
            this.f2362c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f2350a.set(matrix);
            cVar.f2350a.preConcat(cVar.j);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f2351b.size(); i3++) {
                d dVar = cVar.f2351b.get(i3);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f2350a, canvas, i, i2, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.n = i;
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.i, f2360a, canvas, i, i2, colorFilter);
        }

        public f(f fVar) {
            this.f2363d = new Matrix();
            this.j = WheelView.DividerConfig.FILL;
            this.k = WheelView.DividerConfig.FILL;
            this.l = WheelView.DividerConfig.FILL;
            this.m = WheelView.DividerConfig.FILL;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new a.a.b<>();
            this.i = new c(fVar.i, this.q);
            this.f2361b = new Path(fVar.f2361b);
            this.f2362c = new Path(fVar.f2362c);
            this.j = fVar.j;
            this.k = fVar.k;
            this.l = fVar.l;
            this.m = fVar.m;
            this.h = fVar.h;
            this.n = fVar.n;
            this.o = fVar.o;
            String str = fVar.o;
            if (str != null) {
                this.q.put(str, this);
            }
            this.p = fVar.p;
        }

        private void a(c cVar, e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f2 = i / this.l;
            float f3 = i2 / this.m;
            float fMin = Math.min(f2, f3);
            Matrix matrix = cVar.f2350a;
            this.f2363d.set(matrix);
            this.f2363d.postScale(f2, f3);
            float fA = a(matrix);
            if (fA == WheelView.DividerConfig.FILL) {
                return;
            }
            eVar.a(this.f2361b);
            Path path = this.f2361b;
            this.f2362c.reset();
            if (eVar.b()) {
                this.f2362c.setFillType(eVar.f2358c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f2362c.addPath(path, this.f2363d);
                canvas.clipPath(this.f2362c);
                return;
            }
            b bVar = (b) eVar;
            if (bVar.k != WheelView.DividerConfig.FILL || bVar.l != 1.0f) {
                float f4 = bVar.k;
                float f5 = bVar.m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (bVar.l + f5) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.f2361b, false);
                float length = this.g.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.g.getSegment(f8, length, path, true);
                    this.g.getSegment(WheelView.DividerConfig.FILL, f9, path, true);
                } else {
                    this.g.getSegment(f8, f9, path, true);
                }
                path.rLineTo(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
            }
            this.f2362c.addPath(path, this.f2363d);
            if (bVar.h.e()) {
                androidx.core.content.a.b bVar2 = bVar.h;
                if (this.f2365f == null) {
                    this.f2365f = new Paint(1);
                    this.f2365f.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.f2365f;
                if (bVar2.c()) {
                    Shader shaderB = bVar2.b();
                    shaderB.setLocalMatrix(this.f2363d);
                    paint.setShader(shaderB);
                    paint.setAlpha(Math.round(bVar.j * 255.0f));
                } else {
                    paint.setShader(null);
                    paint.setAlpha(255);
                    paint.setColor(k.a(bVar2.a(), bVar.j));
                }
                paint.setColorFilter(colorFilter);
                this.f2362c.setFillType(bVar.f2358c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f2362c, paint);
            }
            if (bVar.f2349f.e()) {
                androidx.core.content.a.b bVar3 = bVar.f2349f;
                if (this.f2364e == null) {
                    this.f2364e = new Paint(1);
                    this.f2364e.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.f2364e;
                Paint.Join join = bVar.o;
                if (join != null) {
                    paint2.setStrokeJoin(join);
                }
                Paint.Cap cap = bVar.n;
                if (cap != null) {
                    paint2.setStrokeCap(cap);
                }
                paint2.setStrokeMiter(bVar.p);
                if (bVar3.c()) {
                    Shader shaderB2 = bVar3.b();
                    shaderB2.setLocalMatrix(this.f2363d);
                    paint2.setShader(shaderB2);
                    paint2.setAlpha(Math.round(bVar.i * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(k.a(bVar3.a(), bVar.i));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.g * fMin * fA);
                canvas.drawPath(this.f2362c, paint2);
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {WheelView.DividerConfig.FILL, 1.0f, 1.0f, WheelView.DividerConfig.FILL};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            return fMax > WheelView.DividerConfig.FILL ? Math.abs(fA) / fMax : WheelView.DividerConfig.FILL;
        }

        public boolean a() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.i.a(iArr);
        }
    }

    static int a(int i, float f2) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    private static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i != 9) {
            switch (i) {
                case 14:
                    return PorterDuff.Mode.MULTIPLY;
                case 15:
                    return PorterDuff.Mode.SCREEN;
                case 16:
                    return PorterDuff.Mode.ADD;
                default:
                    return mode;
            }
        }
        return PorterDuff.Mode.SRC_ATOP;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        g gVar = this.f2344c;
        f fVar = gVar.f2367b;
        gVar.f2369d = a(androidx.core.content.a.i.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListA = androidx.core.content.a.i.a(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListA != null) {
            gVar.f2368c = colorStateListA;
        }
        gVar.f2370e = androidx.core.content.a.i.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f2370e);
        fVar.l = androidx.core.content.a.i.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.l);
        fVar.m = androidx.core.content.a.i.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.m);
        if (fVar.l <= WheelView.DividerConfig.FILL) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fVar.m > WheelView.DividerConfig.FILL) {
            fVar.j = typedArray.getDimension(3, fVar.j);
            fVar.k = typedArray.getDimension(2, fVar.k);
            if (fVar.j <= WheelView.DividerConfig.FILL) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (fVar.k > WheelView.DividerConfig.FILL) {
                fVar.setAlpha(androidx.core.content.a.i.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.o = string;
                    fVar.q.put(string, fVar);
                    return;
                }
                return;
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    private void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f2344c;
        f fVar = gVar.f2367b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2351b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.q.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f2366a = bVar.f2359d | gVar.f2366a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2351b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.q.put(aVar.getPathName(), aVar);
                    }
                    gVar.f2366a = aVar.f2359d | gVar.f2366a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2351b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.q.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f2366a = cVar2.k | gVar.f2366a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    void a(boolean z) {
        this.g = z;
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }
}
