package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.C0316d;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f13457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f13458b;
    private CharSequence A;
    private boolean B;
    private boolean C;
    private Bitmap D;
    private Paint E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int[] J;
    private boolean K;
    private TimeInterpolator N;
    private TimeInterpolator O;
    private float P;
    private float Q;
    private float R;
    private ColorStateList S;
    private float T;
    private float U;
    private float V;
    private ColorStateList W;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f13459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13461e;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private com.google.android.material.i.a x;
    private com.google.android.material.i.a y;
    private CharSequence z;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private final TextPaint L = new TextPaint(129);
    private final TextPaint M = new TextPaint(this.L);
    private final Rect g = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f13462f = new Rect();
    private final RectF h = new RectF();

    static {
        f13457a = Build.VERSION.SDK_INT < 18;
        f13458b = null;
        Paint paint = f13458b;
        if (paint != null) {
            paint.setAntiAlias(true);
            f13458b.setColor(-65281);
        }
    }

    public e(View view) {
        this.f13459c = view;
    }

    private boolean e(Typeface typeface) {
        com.google.android.material.i.a aVar = this.x;
        if (aVar != null) {
            aVar.a();
        }
        if (this.v == typeface) {
            return false;
        }
        this.v = typeface;
        return true;
    }

    private void o() {
        float f2 = this.I;
        d(this.l);
        CharSequence charSequence = this.A;
        float fMeasureText = WheelView.DividerConfig.FILL;
        float fMeasureText2 = charSequence != null ? this.L.measureText(charSequence, 0, charSequence.length()) : WheelView.DividerConfig.FILL;
        int iA = C0316d.a(this.j, this.B ? 1 : 0);
        int i = iA & 112;
        if (i == 48) {
            this.p = this.g.top - this.L.ascent();
        } else if (i != 80) {
            this.p = this.g.centerY() + (((this.L.descent() - this.L.ascent()) / 2.0f) - this.L.descent());
        } else {
            this.p = this.g.bottom;
        }
        int i2 = iA & 8388615;
        if (i2 == 1) {
            this.r = this.g.centerX() - (fMeasureText2 / 2.0f);
        } else if (i2 != 5) {
            this.r = this.g.left;
        } else {
            this.r = this.g.right - fMeasureText2;
        }
        d(this.k);
        CharSequence charSequence2 = this.A;
        if (charSequence2 != null) {
            fMeasureText = this.L.measureText(charSequence2, 0, charSequence2.length());
        }
        int iA2 = C0316d.a(this.i, this.B ? 1 : 0);
        int i3 = iA2 & 112;
        if (i3 == 48) {
            this.o = this.f13462f.top - this.L.ascent();
        } else if (i3 != 80) {
            this.o = this.f13462f.centerY() + (((this.L.descent() - this.L.ascent()) / 2.0f) - this.L.descent());
        } else {
            this.o = this.f13462f.bottom;
        }
        int i4 = iA2 & 8388615;
        if (i4 == 1) {
            this.q = this.f13462f.centerX() - (fMeasureText / 2.0f);
        } else if (i4 != 5) {
            this.q = this.f13462f.left;
        } else {
            this.q = this.f13462f.right - fMeasureText;
        }
        q();
        f(f2);
    }

    private void p() {
        c(this.f13461e);
    }

    private void q() {
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            bitmap.recycle();
            this.D = null;
        }
    }

    private void r() {
        if (this.D != null || this.f13462f.isEmpty() || TextUtils.isEmpty(this.A)) {
            return;
        }
        c(WheelView.DividerConfig.FILL);
        this.F = this.L.ascent();
        this.G = this.L.descent();
        TextPaint textPaint = this.L;
        CharSequence charSequence = this.A;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.G - this.F);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.D = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.D);
        CharSequence charSequence2 = this.A;
        canvas.drawText(charSequence2, 0, charSequence2.length(), WheelView.DividerConfig.FILL, iRound2 - this.L.descent(), this.L);
        if (this.E == null) {
            this.E = new Paint(3);
        }
    }

    private int s() {
        return c(this.m);
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.N = timeInterpolator;
        n();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        n();
    }

    public int c() {
        return this.j;
    }

    public float d() {
        a(this.M);
        return -this.M.ascent();
    }

    public int f() {
        return c(this.n);
    }

    public int g() {
        return this.i;
    }

    public float h() {
        b(this.M);
        return -this.M.ascent();
    }

    public Typeface i() {
        Typeface typeface = this.v;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float j() {
        return this.f13461e;
    }

    public CharSequence k() {
        return this.z;
    }

    public final boolean l() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.n;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.m) != null && colorStateList.isStateful());
    }

    void m() {
        this.f13460d = this.g.width() > 0 && this.g.height() > 0 && this.f13462f.width() > 0 && this.f13462f.height() > 0;
    }

    public void n() {
        if (this.f13459c.getHeight() <= 0 || this.f13459c.getWidth() <= 0) {
            return;
        }
        o();
        p();
    }

    private void f(float f2) {
        d(f2);
        this.C = f13457a && this.H != 1.0f;
        if (this.C) {
            r();
        }
        ViewCompat.G(this.f13459c);
    }

    public void c(int i) {
        com.google.android.material.i.f fVar = new com.google.android.material.i.f(this.f13459c.getContext(), i);
        ColorStateList colorStateList = fVar.f13431b;
        if (colorStateList != null) {
            this.m = colorStateList;
        }
        float f2 = fVar.f13430a;
        if (f2 != WheelView.DividerConfig.FILL) {
            this.k = f2;
        }
        ColorStateList colorStateList2 = fVar.i;
        if (colorStateList2 != null) {
            this.W = colorStateList2;
        }
        this.U = fVar.j;
        this.V = fVar.k;
        this.T = fVar.l;
        com.google.android.material.i.a aVar = this.x;
        if (aVar != null) {
            aVar.a();
        }
        this.x = new com.google.android.material.i.a(new d(this), fVar.a());
        fVar.a(this.f13459c.getContext(), this.x);
        n();
    }

    public void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            n();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            n();
        }
    }

    public void d(int i) {
        if (this.i != i) {
            this.i = i;
            n();
        }
    }

    public Typeface e() {
        Typeface typeface = this.u;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    private boolean d(Typeface typeface) {
        com.google.android.material.i.a aVar = this.y;
        if (aVar != null) {
            aVar.a();
        }
        if (this.u == typeface) {
            return false;
        }
        this.u = typeface;
        return true;
    }

    private void e(float f2) {
        this.h.left = a(this.f13462f.left, this.g.left, f2, this.N);
        this.h.top = a(this.o, this.p, f2, this.N);
        this.h.right = a(this.f13462f.right, this.g.right, f2, this.N);
        this.h.bottom = a(this.f13462f.bottom, this.g.bottom, f2, this.N);
    }

    public void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            n();
        }
    }

    public void b(int i, int i2, int i3, int i4) {
        if (a(this.f13462f, i, i2, i3, i4)) {
            return;
        }
        this.f13462f.set(i, i2, i3, i4);
        this.K = true;
        m();
    }

    public void a(int i, int i2, int i3, int i4) {
        if (a(this.g, i, i2, i3, i4)) {
            return;
        }
        this.g.set(i, i2, i3, i4);
        this.K = true;
        m();
    }

    private void d(float f2) {
        float f3;
        boolean z;
        boolean z2;
        if (this.z == null) {
            return;
        }
        float fWidth = this.g.width();
        float fWidth2 = this.f13462f.width();
        if (a(f2, this.l)) {
            float f4 = this.l;
            this.H = 1.0f;
            Typeface typeface = this.w;
            Typeface typeface2 = this.u;
            if (typeface != typeface2) {
                this.w = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
            f3 = f4;
            z = z2;
        } else {
            f3 = this.k;
            Typeface typeface3 = this.w;
            Typeface typeface4 = this.v;
            if (typeface3 != typeface4) {
                this.w = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (a(f2, this.k)) {
                this.H = 1.0f;
            } else {
                this.H = f2 / this.k;
            }
            float f5 = this.l / this.k;
            fWidth = fWidth2 * f5 > fWidth ? Math.min(fWidth / f5, fWidth2) : fWidth2;
        }
        if (fWidth > WheelView.DividerConfig.FILL) {
            z = this.I != f3 || this.K || z;
            this.I = f3;
            this.K = false;
        }
        if (this.A == null || z) {
            this.L.setTextSize(this.I);
            this.L.setTypeface(this.w);
            this.L.setLinearText(this.H != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.z, this.L, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.A)) {
                return;
            }
            this.A = charSequenceEllipsize;
            this.B = b(this.A);
        }
    }

    public void b(Rect rect) {
        b(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void b(TextPaint textPaint) {
        textPaint.setTextSize(this.k);
        textPaint.setTypeface(this.v);
    }

    public void a(Rect rect) {
        a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void b(int i) {
        if (this.j != i) {
            this.j = i;
            n();
        }
    }

    public void a(RectF rectF) {
        float fA;
        boolean zB = b(this.z);
        if (!zB) {
            fA = this.g.left;
        } else {
            fA = this.g.right - a();
        }
        rectF.left = fA;
        Rect rect = this.g;
        rectF.top = rect.top;
        rectF.right = !zB ? rectF.left + a() : rect.right;
        rectF.bottom = this.g.top + d();
    }

    public void b(Typeface typeface) {
        if (e(typeface)) {
            n();
        }
    }

    public void b(float f2) {
        float fA = androidx.core.c.a.a(f2, WheelView.DividerConfig.FILL, 1.0f);
        if (fA != this.f13461e) {
            this.f13461e = fA;
            p();
        }
    }

    public void c(Typeface typeface) {
        boolean zD = d(typeface);
        boolean zE = e(typeface);
        if (zD || zE) {
            n();
        }
    }

    public float a() {
        if (this.z == null) {
            return WheelView.DividerConfig.FILL;
        }
        a(this.M);
        TextPaint textPaint = this.M;
        CharSequence charSequence = this.z;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private void c(float f2) {
        e(f2);
        this.s = a(this.q, this.r, f2, this.N);
        this.t = a(this.o, this.p, f2, this.N);
        f(a(this.k, this.l, f2, this.O));
        if (this.n != this.m) {
            this.L.setColor(a(s(), f(), f2));
        } else {
            this.L.setColor(f());
        }
        this.L.setShadowLayer(a(this.T, this.P, f2, (TimeInterpolator) null), a(this.U, this.Q, f2, (TimeInterpolator) null), a(this.V, this.R, f2, (TimeInterpolator) null), a(c(this.W), c(this.S), f2));
        ViewCompat.G(this.f13459c);
    }

    private boolean b(CharSequence charSequence) {
        return (ViewCompat.m(this.f13459c) == 1 ? androidx.core.e.e.f1141d : androidx.core.e.e.f1140c).isRtl(charSequence, 0, charSequence.length());
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.l);
        textPaint.setTypeface(this.u);
    }

    public void a(int i) {
        com.google.android.material.i.f fVar = new com.google.android.material.i.f(this.f13459c.getContext(), i);
        ColorStateList colorStateList = fVar.f13431b;
        if (colorStateList != null) {
            this.n = colorStateList;
        }
        float f2 = fVar.f13430a;
        if (f2 != WheelView.DividerConfig.FILL) {
            this.l = f2;
        }
        ColorStateList colorStateList2 = fVar.i;
        if (colorStateList2 != null) {
            this.S = colorStateList2;
        }
        this.Q = fVar.j;
        this.R = fVar.k;
        this.P = fVar.l;
        com.google.android.material.i.a aVar = this.y;
        if (aVar != null) {
            aVar.a();
        }
        this.y = new com.google.android.material.i.a(new c(this), fVar.a());
        fVar.a(this.f13459c.getContext(), this.y);
        n();
    }

    public ColorStateList b() {
        return this.n;
    }

    private int c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.J;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void a(Typeface typeface) {
        if (d(typeface)) {
            n();
        }
    }

    public final boolean a(int[] iArr) {
        this.J = iArr;
        if (!l()) {
            return false;
        }
        n();
        return true;
    }

    public void a(Canvas canvas) {
        float fAscent;
        int iSave = canvas.save();
        if (this.A != null && this.f13460d) {
            float f2 = this.s;
            float f3 = this.t;
            boolean z = this.C && this.D != null;
            if (z) {
                fAscent = this.F * this.H;
                float f4 = this.G;
            } else {
                fAscent = this.L.ascent() * this.H;
                this.L.descent();
                float f5 = this.H;
            }
            if (z) {
                f3 += fAscent;
            }
            float f6 = f3;
            float f7 = this.H;
            if (f7 != 1.0f) {
                canvas.scale(f7, f7, f2, f6);
            }
            if (z) {
                canvas.drawBitmap(this.D, f2, f6, this.E);
            } else {
                CharSequence charSequence = this.A;
                canvas.drawText(charSequence, 0, charSequence.length(), f2, f6, this.L);
            }
        }
        canvas.restoreToCount(iSave);
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.z, charSequence)) {
            this.z = charSequence;
            this.A = null;
            q();
            n();
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int a(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f3) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f3) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f3) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f3) + (Color.blue(i2) * f2)));
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.a.a.a(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
