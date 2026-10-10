package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.a.h;
import com.google.android.material.i.f;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import com.google.android.material.l.i;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: ChipDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends i implements Drawable.Callback, androidx.core.graphics.drawable.b, p.a {
    private static final int[] w = {R.attr.state_enabled};
    private static final ShapeDrawable x = new ShapeDrawable(new OvalShape());
    private float A;
    private boolean Aa;
    private float B;
    private ColorStateList Ba;
    private ColorStateList C;
    private WeakReference<a> Ca;
    private float D;
    private TextUtils.TruncateAt Da;
    private ColorStateList E;
    private boolean Ea;
    private CharSequence F;
    private int Fa;
    private boolean G;
    private boolean Ga;
    private Drawable H;
    private ColorStateList I;
    private float J;
    private boolean K;
    private boolean L;
    private Drawable M;
    private Drawable N;
    private ColorStateList O;
    private float P;
    private CharSequence Q;
    private boolean R;
    private boolean S;
    private Drawable T;
    private h U;
    private h V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private float aa;
    private float ba;
    private float ca;
    private float da;
    private final Context ea;
    private final Paint fa;
    private final Paint ga;
    private final Paint.FontMetrics ha;
    private final RectF ia;
    private final PointF ja;
    private final Path ka;
    private final p la;
    private int ma;
    private int na;
    private int oa;
    private int pa;
    private int qa;
    private int ra;
    private boolean sa;
    private int ta;
    private int ua;
    private ColorFilter va;
    private PorterDuffColorFilter wa;
    private ColorStateList xa;
    private ColorStateList y;
    private PorterDuff.Mode ya;
    private ColorStateList z;
    private int[] za;

    /* JADX INFO: compiled from: ChipDrawable.java */
    public interface a {
        void onChipDrawableSizeChange();
    }

    private c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.fa = new Paint(1);
        this.ha = new Paint.FontMetrics();
        this.ia = new RectF();
        this.ja = new PointF();
        this.ka = new Path();
        this.ua = 255;
        this.ya = PorterDuff.Mode.SRC_IN;
        this.Ca = new WeakReference<>(null);
        a(context);
        this.ea = context;
        this.la = new p(this);
        this.F = "";
        this.la.b().density = context.getResources().getDisplayMetrics().density;
        this.ga = null;
        Paint paint = this.ga;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(w);
        a(w);
        this.Ea = true;
        if (com.google.android.material.j.c.f13496a) {
            x.setTint(-1);
        }
    }

    public static c a(Context context, AttributeSet attributeSet, int i, int i2) {
        c cVar = new c(context, attributeSet, i, i2);
        cVar.a(attributeSet, i, i2);
        return cVar;
    }

    private void b(Canvas canvas, Rect rect) {
        if (this.Ga) {
            return;
        }
        this.fa.setColor(this.na);
        this.fa.setStyle(Paint.Style.FILL);
        this.fa.setColorFilter(ha());
        this.ia.set(rect);
        canvas.drawRoundRect(this.ia, x(), x(), this.fa);
    }

    private void c(Canvas canvas, Rect rect) {
        if (ja()) {
            a(rect, this.ia);
            RectF rectF = this.ia;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.H.setBounds(0, 0, (int) this.ia.width(), (int) this.ia.height());
            this.H.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void d(Canvas canvas, Rect rect) {
        if (this.D <= WheelView.DividerConfig.FILL || this.Ga) {
            return;
        }
        this.fa.setColor(this.pa);
        this.fa.setStyle(Paint.Style.STROKE);
        if (!this.Ga) {
            this.fa.setColorFilter(ha());
        }
        RectF rectF = this.ia;
        float f2 = rect.left;
        float f3 = this.D;
        rectF.set(f2 + (f3 / 2.0f), rect.top + (f3 / 2.0f), rect.right - (f3 / 2.0f), rect.bottom - (f3 / 2.0f));
        float f4 = this.B - (this.D / 2.0f);
        canvas.drawRoundRect(this.ia, f4, f4, this.fa);
    }

    private void e(Canvas canvas, Rect rect) {
        if (this.Ga) {
            return;
        }
        this.fa.setColor(this.ma);
        this.fa.setStyle(Paint.Style.FILL);
        this.ia.set(rect);
        canvas.drawRoundRect(this.ia, x(), x(), this.fa);
    }

    private float fa() {
        this.la.b().getFontMetrics(this.ha);
        Paint.FontMetrics fontMetrics = this.ha;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private void g(Canvas canvas, Rect rect) {
        this.fa.setColor(this.qa);
        this.fa.setStyle(Paint.Style.FILL);
        this.ia.set(rect);
        if (!this.Ga) {
            canvas.drawRoundRect(this.ia, x(), x(), this.fa);
        } else {
            a(new RectF(rect), this.ka);
            super.a(canvas, this.fa, this.ka, d());
        }
    }

    private boolean ga() {
        return this.S && this.T != null && this.R;
    }

    private void h(Canvas canvas, Rect rect) {
        Paint paint = this.ga;
        if (paint != null) {
            paint.setColor(androidx.core.a.a.b(-16777216, 127));
            canvas.drawRect(rect, this.ga);
            if (ja() || ia()) {
                a(rect, this.ia);
                canvas.drawRect(this.ia, this.ga);
            }
            if (this.F != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.ga);
            }
            if (ka()) {
                c(rect, this.ia);
                canvas.drawRect(this.ia, this.ga);
            }
            this.ga.setColor(androidx.core.a.a.b(-65536, 127));
            b(rect, this.ia);
            canvas.drawRect(this.ia, this.ga);
            this.ga.setColor(androidx.core.a.a.b(-16711936, 127));
            d(rect, this.ia);
            canvas.drawRect(this.ia, this.ga);
        }
    }

    private ColorFilter ha() {
        ColorFilter colorFilter = this.va;
        return colorFilter != null ? colorFilter : this.wa;
    }

    private void i(Canvas canvas, Rect rect) {
        if (this.F != null) {
            Paint.Align alignA = a(rect, this.ja);
            e(rect, this.ia);
            if (this.la.a() != null) {
                this.la.b().drawableState = getState();
                this.la.a(this.ea);
            }
            this.la.b().setTextAlign(alignA);
            int iSave = 0;
            boolean z = Math.round(this.la.a(T().toString())) > Math.round(this.ia.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.ia);
            }
            CharSequence charSequenceEllipsize = this.F;
            if (z && this.Da != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.la.b(), this.ia.width(), this.Da);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.ja;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.la.b());
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean ia() {
        return this.S && this.T != null && this.sa;
    }

    private boolean ja() {
        return this.G && this.H != null;
    }

    private boolean ka() {
        return this.L && this.M != null;
    }

    private void la() {
        this.Ba = this.Aa ? com.google.android.material.j.c.b(this.E) : null;
    }

    @TargetApi(21)
    private void ma() {
        this.N = new RippleDrawable(com.google.android.material.j.c.b(R()), this.M, x);
    }

    public void A(int i) {
        g(androidx.appcompat.a.a.a.a(this.ea, i));
    }

    public ColorStateList B() {
        return this.I;
    }

    public float C() {
        return this.A;
    }

    public float D() {
        return this.W;
    }

    public ColorStateList E() {
        return this.C;
    }

    public float F() {
        return this.D;
    }

    public Drawable G() {
        Drawable drawable = this.M;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public CharSequence H() {
        return this.Q;
    }

    public float I() {
        return this.ca;
    }

    public float J() {
        return this.P;
    }

    public float K() {
        return this.ba;
    }

    public int[] L() {
        return this.za;
    }

    public ColorStateList M() {
        return this.O;
    }

    public TextUtils.TruncateAt N() {
        return this.Da;
    }

    public h O() {
        return this.V;
    }

    public float P() {
        return this.Y;
    }

    public float Q() {
        return this.X;
    }

    public ColorStateList R() {
        return this.E;
    }

    public h S() {
        return this.U;
    }

    public CharSequence T() {
        return this.F;
    }

    public f U() {
        return this.la.a();
    }

    public float V() {
        return this.aa;
    }

    public float W() {
        return this.Z;
    }

    public boolean X() {
        return this.Aa;
    }

    public boolean Y() {
        return this.R;
    }

    public boolean Z() {
        return this.S;
    }

    public boolean aa() {
        return this.G;
    }

    public boolean ba() {
        return e(this.M);
    }

    public boolean ca() {
        return this.L;
    }

    protected void da() {
        a aVar = this.Ca.get();
        if (aVar != null) {
            aVar.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.ua;
        int iA = i < 255 ? com.google.android.material.c.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        e(canvas, bounds);
        b(canvas, bounds);
        if (this.Ga) {
            super.draw(canvas);
        }
        d(canvas, bounds);
        g(canvas, bounds);
        c(canvas, bounds);
        a(canvas, bounds);
        if (this.Ea) {
            i(canvas, bounds);
        }
        f(canvas, bounds);
        h(canvas, bounds);
        if (this.ua < 255) {
            canvas.restoreToCount(iA);
        }
    }

    boolean ea() {
        return this.Ea;
    }

    public void f(boolean z) {
        if (this.Aa != z) {
            this.Aa = z;
            la();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ua;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.va;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.W + t() + this.Z + this.la.a(T().toString()) + this.aa + u() + this.da), this.Fa);
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.Ga) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.B);
        } else {
            outline.setRoundRect(bounds, this.B);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return h(this.y) || h(this.z) || h(this.C) || (this.Aa && h(this.Ba)) || b(this.la.a()) || ga() || e(this.H) || e(this.T) || h(this.xa);
    }

    public void j(int i) {
        b(androidx.appcompat.a.a.a.b(this.ea, i));
    }

    public void k(float f2) {
        if (this.D != f2) {
            this.D = f2;
            this.fa.setStrokeWidth(f2);
            if (this.Ga) {
                super.e(f2);
            }
            invalidateSelf();
        }
    }

    public void l(int i) {
        d(androidx.appcompat.a.a.a.a(this.ea, i));
    }

    public void m(int i) {
        c(this.ea.getResources().getBoolean(i));
    }

    public void n(int i) {
        i(this.ea.getResources().getDimension(i));
    }

    public void o(int i) {
        j(this.ea.getResources().getDimension(i));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (ja()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.a(this.H, i);
        }
        if (ia()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.a(this.T, i);
        }
        if (ka()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.a(this.M, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (ja()) {
            zOnLevelChange |= this.H.setLevel(i);
        }
        if (ia()) {
            zOnLevelChange |= this.T.setLevel(i);
        }
        if (ka()) {
            zOnLevelChange |= this.M.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable, com.google.android.material.internal.p.a
    public boolean onStateChange(int[] iArr) {
        if (this.Ga) {
            super.onStateChange(iArr);
        }
        return a(iArr, L());
    }

    public void p(int i) {
        e(androidx.appcompat.a.a.a.a(this.ea, i));
    }

    public void q(int i) {
        k(this.ea.getResources().getDimension(i));
    }

    public void r(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            invalidateSelf();
            da();
        }
    }

    public void s(int i) {
        c(androidx.appcompat.a.a.a.b(this.ea, i));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.ua != i) {
            this.ua = i;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.va != colorFilter) {
            this.va = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.xa != colorStateList) {
            this.xa = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.ya != mode) {
            this.ya = mode;
            this.wa = com.google.android.material.e.a.a(this, this.xa, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (ja()) {
            visible |= this.H.setVisible(z, z2);
        }
        if (ia()) {
            visible |= this.T.setVisible(z, z2);
        }
        if (ka()) {
            visible |= this.M.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    float t() {
        return (ja() || ia()) ? this.X + this.J + this.Y : WheelView.DividerConfig.FILL;
    }

    float u() {
        return ka() ? this.ba + this.P + this.ca : WheelView.DividerConfig.FILL;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v(int i) {
        f(androidx.appcompat.a.a.a.a(this.ea, i));
    }

    public ColorStateList w() {
        return this.z;
    }

    public float x() {
        return this.Ga ? n() : this.B;
    }

    public void y(int i) {
        p(this.ea.getResources().getDimension(i));
    }

    public Drawable z() {
        Drawable drawable = this.H;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public float A() {
        return this.J;
    }

    public void B(int i) {
        b(h.a(this.ea, i));
    }

    public void C(int i) {
        a(new f(this.ea, i));
    }

    public void D(int i) {
        q(this.ea.getResources().getDimension(i));
    }

    public void E(int i) {
        r(this.ea.getResources().getDimension(i));
    }

    public void j(float f2) {
        if (this.W != f2) {
            this.W = f2;
            invalidateSelf();
            da();
        }
    }

    public void l(float f2) {
        if (this.ca != f2) {
            this.ca = f2;
            invalidateSelf();
            if (ka()) {
                da();
            }
        }
    }

    public void m(float f2) {
        if (this.P != f2) {
            this.P = f2;
            invalidateSelf();
            if (ka()) {
                da();
            }
        }
    }

    public void n(float f2) {
        if (this.ba != f2) {
            this.ba = f2;
            invalidateSelf();
            if (ka()) {
                da();
            }
        }
    }

    public void o(float f2) {
        if (this.Y != f2) {
            float fT = t();
            this.Y = f2;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                da();
            }
        }
    }

    public void p(float f2) {
        if (this.X != f2) {
            float fT = t();
            this.X = f2;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                da();
            }
        }
    }

    public void q(float f2) {
        if (this.aa != f2) {
            this.aa = f2;
            invalidateSelf();
            da();
        }
    }

    public Drawable v() {
        return this.T;
    }

    public void w(int i) {
        a(h.a(this.ea, i));
    }

    public void x(int i) {
        o(this.ea.getResources().getDimension(i));
    }

    public float y() {
        return this.da;
    }

    public void z(int i) {
        this.Fa = i;
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayA = s.a(this.ea, attributeSet, com.google.android.material.R.styleable.Chip, i, i2, new int[0]);
        this.Ga = typedArrayA.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        i(com.google.android.material.i.c.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        c(com.google.android.material.i.c.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        i(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, WheelView.DividerConfig.FILL));
        if (typedArrayA.hasValue(com.google.android.material.R.styleable.Chip_chipCornerRadius)) {
            f(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipCornerRadius, WheelView.DividerConfig.FILL));
        }
        e(com.google.android.material.i.c.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        k(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, WheelView.DividerConfig.FILL));
        g(com.google.android.material.i.c.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_rippleColor));
        b(typedArrayA.getText(com.google.android.material.R.styleable.Chip_android_text));
        a(com.google.android.material.i.c.c(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_android_textAppearance));
        int i3 = typedArrayA.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            a(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            a(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            a(TextUtils.TruncateAt.END);
        }
        c(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            c(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        b(com.google.android.material.i.c.b(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_chipIcon));
        if (typedArrayA.hasValue(com.google.android.material.R.styleable.Chip_chipIconTint)) {
            d(com.google.android.material.i.c.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_chipIconTint));
        }
        h(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, WheelView.DividerConfig.FILL));
        d(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            d(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        c(com.google.android.material.i.c.b(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_closeIcon));
        f(com.google.android.material.i.c.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_closeIconTint));
        m(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, WheelView.DividerConfig.FILL));
        a(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        b(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            b(typedArrayA.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        a(com.google.android.material.i.c.b(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_checkedIcon));
        b(h.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_showMotionSpec));
        a(h.a(this.ea, typedArrayA, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        j(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, WheelView.DividerConfig.FILL));
        p(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, WheelView.DividerConfig.FILL));
        o(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, WheelView.DividerConfig.FILL));
        r(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, WheelView.DividerConfig.FILL));
        q(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, WheelView.DividerConfig.FILL));
        n(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, WheelView.DividerConfig.FILL));
        l(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, WheelView.DividerConfig.FILL));
        g(typedArrayA.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, WheelView.DividerConfig.FILL));
        z(typedArrayA.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayA.recycle();
    }

    public void t(int i) {
        m(this.ea.getResources().getDimension(i));
    }

    public void u(int i) {
        n(this.ea.getResources().getDimension(i));
    }

    private void f(Canvas canvas, Rect rect) {
        if (ka()) {
            c(rect, this.ia);
            RectF rectF = this.ia;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.M.setBounds(0, 0, (int) this.ia.width(), (int) this.ia.height());
            if (com.google.android.material.j.c.f13496a) {
                this.N.setBounds(this.M.getBounds());
                this.N.jumpToCurrentState();
                this.N.draw(canvas);
            } else {
                this.M.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    public void r(int i) {
        l(this.ea.getResources().getDimension(i));
    }

    private void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.F != null) {
            float fT = this.W + t() + this.Z;
            float fU = this.da + u() + this.aa;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = rect.left + fT;
                rectF.right = rect.right - fU;
            } else {
                rectF.left = rect.left + fU;
                rectF.right = rect.right - fT;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void b(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (ka()) {
            float f2 = this.da + this.ca + this.P + this.ba + this.aa;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    public void k(int i) {
        h(this.ea.getResources().getDimension(i));
    }

    public void g(int i) {
        c(androidx.appcompat.a.a.a.a(this.ea, i));
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (ka()) {
            float f2 = this.da + this.ca;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = rect.right - f2;
                rectF.left = rectF.right - this.P;
            } else {
                rectF.left = rect.left + f2;
                rectF.right = rectF.left + this.P;
            }
            float fExactCenterY = rect.exactCenterY();
            float f3 = this.P;
            rectF.top = fExactCenterY - (f3 / 2.0f);
            rectF.bottom = rectF.top + f3;
        }
    }

    private void d(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (ka()) {
            float f2 = this.da + this.ca + this.P + this.ba + this.aa;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f2;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void g(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            la();
            onStateChange(getState());
        }
    }

    private static boolean b(f fVar) {
        ColorStateList colorStateList;
        return (fVar == null || (colorStateList = fVar.f13431b) == null || !colorStateList.isStateful()) ? false : true;
    }

    public void g(float f2) {
        if (this.da != f2) {
            this.da = f2;
            invalidateSelf();
            da();
        }
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.F, charSequence)) {
            return;
        }
        this.F = charSequence;
        this.la.a(true);
        invalidateSelf();
        da();
    }

    private static boolean e(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void e(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (this.Ga) {
                b(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Deprecated
    public void f(float f2) {
        if (this.B != f2) {
            this.B = f2;
            setShapeAppearanceModel(l().a(f2));
        }
    }

    private void d(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.a(drawable, androidx.core.graphics.drawable.a.e(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.M) {
            if (drawable.isStateful()) {
                drawable.setState(L());
            }
            androidx.core.graphics.drawable.a.a(drawable, this.O);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.H;
        if (drawable == drawable2 && this.K) {
            androidx.core.graphics.drawable.a.a(drawable2, this.I);
        }
    }

    public void c(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    private static boolean h(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void i(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            onStateChange(getState());
        }
    }

    public void b(Drawable drawable) {
        Drawable drawableZ = z();
        if (drawableZ != drawable) {
            float fT = t();
            this.H = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float fT2 = t();
            f(drawableZ);
            if (ja()) {
                d(this.H);
            }
            invalidateSelf();
            if (fT != fT2) {
                da();
            }
        }
    }

    public void f(ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (ka()) {
                androidx.core.graphics.drawable.a.a(this.M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Deprecated
    public void h(int i) {
        f(this.ea.getResources().getDimension(i));
    }

    public void c(boolean z) {
        if (this.G != z) {
            boolean zJa = ja();
            this.G = z;
            boolean zJa2 = ja();
            if (zJa != zJa2) {
                if (zJa2) {
                    d(this.H);
                } else {
                    f(this.H);
                }
                invalidateSelf();
                da();
            }
        }
    }

    public void h(float f2) {
        if (this.J != f2) {
            float fT = t();
            this.J = f2;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                da();
            }
        }
    }

    public void e(int i) {
        a(androidx.appcompat.a.a.a.b(this.ea, i));
    }

    public void i(float f2) {
        if (this.A != f2) {
            this.A = f2;
            invalidateSelf();
            da();
        }
    }

    void e(boolean z) {
        this.Ea = z;
    }

    public void f(int i) {
        b(this.ea.getResources().getBoolean(i));
    }

    public void i(int i) {
        g(this.ea.getResources().getDimension(i));
    }

    public void b(boolean z) {
        if (this.S != z) {
            boolean zIa = ia();
            this.S = z;
            boolean zIa2 = ia();
            if (zIa != zIa2) {
                if (zIa2) {
                    d(this.T);
                } else {
                    f(this.T);
                }
                invalidateSelf();
                da();
            }
        }
    }

    public void c(Drawable drawable) {
        Drawable drawableG = G();
        if (drawableG != drawable) {
            float fU = u();
            this.M = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            if (com.google.android.material.j.c.f13496a) {
                ma();
            }
            float fU2 = u();
            f(drawableG);
            if (ka()) {
                d(this.M);
            }
            invalidateSelf();
            if (fU != fU2) {
                da();
            }
        }
    }

    public void d(ColorStateList colorStateList) {
        this.K = true;
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (ja()) {
                androidx.core.graphics.drawable.a.a(this.H, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(h hVar) {
        this.U = hVar;
    }

    public void d(boolean z) {
        if (this.L != z) {
            boolean zKa = ka();
            this.L = z;
            boolean zKa2 = ka();
            if (zKa != zKa2) {
                if (zKa2) {
                    d(this.M);
                } else {
                    f(this.M);
                }
                invalidateSelf();
                da();
            }
        }
    }

    public void d(int i) {
        a(this.ea.getResources().getBoolean(i));
    }

    public void a(a aVar) {
        this.Ca = new WeakReference<>(aVar);
    }

    public void a(RectF rectF) {
        d(getBounds(), rectF);
    }

    private void a(Canvas canvas, Rect rect) {
        if (ia()) {
            a(rect, this.ia);
            RectF rectF = this.ia;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.T.setBounds(0, 0, (int) this.ia.width(), (int) this.ia.height());
            this.T.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (ja() || ia()) {
            float f2 = this.W + this.X;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = rect.left + f2;
                rectF.right = rectF.left + this.J;
            } else {
                rectF.right = rect.right - f2;
                rectF.left = rectF.right - this.J;
            }
            float fExactCenterY = rect.exactCenterY();
            float f3 = this.J;
            rectF.top = fExactCenterY - (f3 / 2.0f);
            rectF.bottom = rectF.top + f3;
        }
    }

    Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        Paint.Align align = Paint.Align.LEFT;
        if (this.F != null) {
            float fT = this.W + t() + this.Z;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                pointF.x = rect.left + fT;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fT;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - fa();
        }
        return align;
    }

    public boolean a(int[] iArr) {
        if (Arrays.equals(this.za, iArr)) {
            return false;
        }
        this.za = iArr;
        if (ka()) {
            return a(getState(), iArr);
        }
        return false;
    }

    @Override // com.google.android.material.internal.p.a
    public void a() {
        da();
        invalidateSelf();
    }

    private boolean a(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.y;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, this.ma) : 0;
        if (this.ma != colorForState) {
            this.ma = colorForState;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.z;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.na) : 0;
        if (this.na != colorForState2) {
            this.na = colorForState2;
            zOnStateChange = true;
        }
        int iA = com.google.android.material.d.a.a(colorForState, colorForState2);
        if ((this.oa != iA) | (f() == null)) {
            this.oa = iA;
            a(ColorStateList.valueOf(this.oa));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.C;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.pa) : 0;
        if (this.pa != colorForState3) {
            this.pa = colorForState3;
            zOnStateChange = true;
        }
        int colorForState4 = (this.Ba == null || !com.google.android.material.j.c.a(iArr)) ? 0 : this.Ba.getColorForState(iArr, this.qa);
        if (this.qa != colorForState4) {
            this.qa = colorForState4;
            if (this.Aa) {
                zOnStateChange = true;
            }
        }
        int colorForState5 = (this.la.a() == null || this.la.a().f13431b == null) ? 0 : this.la.a().f13431b.getColorForState(iArr, this.ra);
        if (this.ra != colorForState5) {
            this.ra = colorForState5;
            zOnStateChange = true;
        }
        boolean z2 = a(getState(), R.attr.state_checked) && this.R;
        if (this.sa == z2 || this.T == null) {
            z = false;
        } else {
            float fT = t();
            this.sa = z2;
            if (fT != t()) {
                zOnStateChange = true;
                z = true;
            } else {
                zOnStateChange = true;
                z = false;
            }
        }
        ColorStateList colorStateList4 = this.xa;
        int colorForState6 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.ta) : 0;
        if (this.ta != colorForState6) {
            this.ta = colorForState6;
            this.wa = com.google.android.material.e.a.a(this, this.xa, this.ya);
            zOnStateChange = true;
        }
        if (e(this.H)) {
            zOnStateChange |= this.H.setState(iArr);
        }
        if (e(this.T)) {
            zOnStateChange |= this.T.setState(iArr);
        }
        if (e(this.M)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            zOnStateChange |= this.M.setState(iArr3);
        }
        if (com.google.android.material.j.c.f13496a && e(this.N)) {
            zOnStateChange |= this.N.setState(iArr2);
        }
        if (zOnStateChange) {
            invalidateSelf();
        }
        if (z) {
            da();
        }
        return zOnStateChange;
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void a(f fVar) {
        this.la.a(fVar, this.ea);
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.Da = truncateAt;
    }

    public void a(CharSequence charSequence) {
        if (this.Q != charSequence) {
            this.Q = androidx.core.e.a.a().a(charSequence);
            invalidateSelf();
        }
    }

    public void a(boolean z) {
        if (this.R != z) {
            this.R = z;
            float fT = t();
            if (!z && this.sa) {
                this.sa = false;
            }
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                da();
            }
        }
    }

    public void a(Drawable drawable) {
        if (this.T != drawable) {
            float fT = t();
            this.T = drawable;
            float fT2 = t();
            f(this.T);
            d(this.T);
            invalidateSelf();
            if (fT != fT2) {
                da();
            }
        }
    }

    public void a(h hVar) {
        this.V = hVar;
    }
}
