package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;

/* JADX INFO: compiled from: DrawableContainer.java */
/* JADX INFO: loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f344d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f346f;
    private boolean i;
    private Runnable j;
    private long k;
    private long l;
    private a m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f345e = 255;
    private int g = -1;
    private int h = -1;

    /* JADX INFO: compiled from: DrawableContainer.java */
    static class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable.Callback f347a;

        a() {
        }

        public a a(Drawable.Callback callback) {
            this.f347a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f347a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f347a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f347a;
            this.f347a = null;
            return callback;
        }
    }

    /* JADX INFO: compiled from: DrawableContainer.java */
    static abstract class b extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f353f;
        Drawable[] g;
        int h;
        boolean i;
        boolean j;
        Rect k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        b(b bVar, d dVar, Resources resources) {
            this.f350c = 160;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f348a = dVar;
            this.f349b = resources != null ? resources : bVar != null ? bVar.f349b : null;
            this.f350c = d.a(resources, bVar != null ? bVar.f350c : 0);
            if (bVar == null) {
                this.g = new Drawable[10];
                this.h = 0;
                return;
            }
            this.f351d = bVar.f351d;
            this.f352e = bVar.f352e;
            this.v = true;
            this.w = true;
            this.i = bVar.i;
            this.l = bVar.l;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            if (bVar.f350c == this.f350c) {
                if (bVar.j) {
                    this.k = new Rect(bVar.k);
                    this.j = true;
                }
                if (bVar.m) {
                    this.n = bVar.n;
                    this.o = bVar.o;
                    this.p = bVar.p;
                    this.q = bVar.q;
                    this.m = true;
                }
            }
            if (bVar.r) {
                this.s = bVar.s;
                this.r = true;
            }
            if (bVar.t) {
                this.u = bVar.u;
                this.t = true;
            }
            Drawable[] drawableArr = bVar.g;
            this.g = new Drawable[drawableArr.length];
            this.h = bVar.h;
            SparseArray<Drawable.ConstantState> sparseArray = bVar.f353f;
            if (sparseArray != null) {
                this.f353f = sparseArray.clone();
            } else {
                this.f353f = new SparseArray<>(this.h);
            }
            int i = this.h;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                    if (constantState != null) {
                        this.f353f.put(i2, constantState);
                    } else {
                        this.g[i2] = drawableArr[i2];
                    }
                }
            }
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f348a);
            return drawableMutate;
        }

        private void n() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f353f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.g[this.f353f.keyAt(i)] = b(this.f353f.valueAt(i).newDrawable(this.f349b));
                }
                this.f353f = null;
            }
        }

        public final int a(Drawable drawable) {
            int i = this.h;
            if (i >= this.g.length) {
                a(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f348a);
            this.g[i] = drawable;
            this.h++;
            this.f352e = drawable.getChangingConfigurations() | this.f352e;
            k();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return i;
        }

        final int c() {
            return this.g.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.h;
            Drawable[] drawableArr = this.g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f353f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public final int d() {
            return this.h;
        }

        public final int e() {
            if (!this.m) {
                b();
            }
            return this.o;
        }

        public final int f() {
            if (!this.m) {
                b();
            }
            return this.q;
        }

        public final int g() {
            if (!this.m) {
                b();
            }
            return this.p;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f351d | this.f352e;
        }

        public final Rect h() {
            if (this.i) {
                return null;
            }
            if (this.k != null || this.j) {
                return this.k;
            }
            n();
            Rect rect = new Rect();
            int i = this.h;
            Drawable[] drawableArr = this.g;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    int i3 = rect.left;
                    if (i3 > rect2.left) {
                        rect2.left = i3;
                    }
                    int i4 = rect.top;
                    if (i4 > rect2.top) {
                        rect2.top = i4;
                    }
                    int i5 = rect.right;
                    if (i5 > rect2.right) {
                        rect2.right = i5;
                    }
                    int i6 = rect.bottom;
                    if (i6 > rect2.bottom) {
                        rect2.bottom = i6;
                    }
                }
            }
            this.j = true;
            this.k = rect2;
            return rect2;
        }

        public final int i() {
            if (!this.m) {
                b();
            }
            return this.n;
        }

        public final int j() {
            if (this.r) {
                return this.s;
            }
            n();
            int i = this.h;
            Drawable[] drawableArr = this.g;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        void k() {
            this.r = false;
            this.t = false;
        }

        public final boolean l() {
            return this.l;
        }

        abstract void m();

        public final void c(int i) {
            this.B = i;
        }

        final boolean b(int i, int i2) {
            int i3 = this.h;
            Drawable[] drawableArr = this.g;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.z = i;
            return z;
        }

        public final void b(boolean z) {
            this.i = z;
        }

        protected void b() {
            this.m = true;
            n();
            int i = this.h;
            Drawable[] drawableArr = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final Drawable a(int i) {
            int iIndexOfKey;
            Drawable drawable = this.g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f353f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableB = b(this.f353f.valueAt(iIndexOfKey).newDrawable(this.f349b));
            this.g[i] = drawableB;
            this.f353f.removeAt(iIndexOfKey);
            if (this.f353f.size() == 0) {
                this.f353f = null;
            }
            return drawableB;
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.f349b = resources;
                int iA = d.a(resources, this.f350c);
                int i = this.f350c;
                this.f350c = iA;
                if (i != iA) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public final void b(int i) {
            this.A = i;
        }

        final void a(Resources.Theme theme) {
            if (theme != null) {
                n();
                int i = this.h;
                Drawable[] drawableArr = this.g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f352e |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        public final void a(boolean z) {
            this.l = z;
        }

        public void a(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.g, 0, drawableArr, 0, i);
            this.g = drawableArr;
        }

        public synchronized boolean a() {
            if (this.v) {
                return this.w;
            }
            n();
            this.v = true;
            int i = this.h;
            Drawable[] drawableArr = this.g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    d() {
    }

    private boolean c() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    b a() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean a(int r9) {
        /*
            r8 = this;
            int r0 = r8.g
            r1 = 0
            if (r9 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.b.a.d$b r0 = r8.f341a
            int r0 = r0.B
            r4 = -1
            r5 = 0
            r6 = 0
            if (r0 <= 0) goto L35
            android.graphics.drawable.Drawable r0 = r8.f344d
            if (r0 == 0) goto L1b
            r0.setVisible(r1, r1)
        L1b:
            android.graphics.drawable.Drawable r0 = r8.f343c
            if (r0 == 0) goto L2e
            r8.f344d = r0
            int r0 = r8.g
            r8.h = r0
            androidx.appcompat.b.a.d$b r0 = r8.f341a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r8.l = r0
            goto L3c
        L2e:
            r8.f344d = r5
            r8.h = r4
            r8.l = r6
            goto L3c
        L35:
            android.graphics.drawable.Drawable r0 = r8.f343c
            if (r0 == 0) goto L3c
            r0.setVisible(r1, r1)
        L3c:
            if (r9 < 0) goto L5c
            androidx.appcompat.b.a.d$b r0 = r8.f341a
            int r1 = r0.h
            if (r9 >= r1) goto L5c
            android.graphics.drawable.Drawable r0 = r0.a(r9)
            r8.f343c = r0
            r8.g = r9
            if (r0 == 0) goto L60
            androidx.appcompat.b.a.d$b r9 = r8.f341a
            int r9 = r9.A
            if (r9 <= 0) goto L58
            long r4 = (long) r9
            long r2 = r2 + r4
            r8.k = r2
        L58:
            r8.a(r0)
            goto L60
        L5c:
            r8.f343c = r5
            r8.g = r4
        L60:
            long r0 = r8.k
            r9 = 1
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L6d
            long r0 = r8.l
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L7f
        L6d:
            java.lang.Runnable r0 = r8.j
            if (r0 != 0) goto L79
            androidx.appcompat.b.a.c r0 = new androidx.appcompat.b.a.c
            r0.<init>(r8)
            r8.j = r0
            goto L7c
        L79:
            r8.unscheduleSelf(r0)
        L7c:
            r8.a(r9)
        L7f:
            r8.invalidateSelf()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.d.a(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f341a.a(theme);
    }

    int b() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f341a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f343c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f344d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f345e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f341a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f341a.a()) {
            return null;
        }
        this.f341a.f351d = getChangingConfigurations();
        return this.f341a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f343c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f342b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f341a.l()) {
            return this.f341a.e();
        }
        Drawable drawable = this.f343c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f341a.l()) {
            return this.f341a.i();
        }
        Drawable drawable = this.f343c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f341a.l()) {
            return this.f341a.f();
        }
        Drawable drawable = this.f343c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f341a.l()) {
            return this.f341a.g();
        }
        Drawable drawable = this.f343c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f343c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f341a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f343c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectH = this.f341a.h();
        if (rectH != null) {
            rect.set(rectH);
            padding = (rectH.right | ((rectH.left | rectH.top) | rectH.bottom)) != 0;
        } else {
            Drawable drawable = this.f343c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (c()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    public void invalidateDrawable(Drawable drawable) {
        b bVar = this.f341a;
        if (bVar != null) {
            bVar.k();
        }
        if (drawable != this.f343c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f341a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f344d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f344d = null;
            this.h = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f343c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f346f) {
                this.f343c.setAlpha(this.f345e);
            }
        }
        if (this.l != 0) {
            this.l = 0L;
            z = true;
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            b bVarA = a();
            bVarA.m();
            a(bVarA);
            this.i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f344d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f343c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f341a.b(i, b());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f344d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f343c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f344d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f343c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f343c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f346f && this.f345e == i) {
            return;
        }
        this.f346f = true;
        this.f345e = i;
        Drawable drawable = this.f343c;
        if (drawable != null) {
            if (this.k == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        b bVar = this.f341a;
        if (bVar.C != z) {
            bVar.C = z;
            Drawable drawable = this.f343c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, bVar.C);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.f341a;
        bVar.E = true;
        if (bVar.D != colorFilter) {
            bVar.D = colorFilter;
            Drawable drawable = this.f343c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        b bVar = this.f341a;
        if (bVar.x != z) {
            bVar.x = z;
            Drawable drawable = this.f343c;
            if (drawable != null) {
                drawable.setDither(bVar.x);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f343c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f342b;
        if (rect == null) {
            this.f342b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f343c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        b bVar = this.f341a;
        bVar.H = true;
        if (bVar.F != colorStateList) {
            bVar.F = colorStateList;
            androidx.core.graphics.drawable.a.a(this.f343c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f341a;
        bVar.I = true;
        if (bVar.G != mode) {
            bVar.G = mode;
            androidx.core.graphics.drawable.a.a(this.f343c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f344d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f343c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f343c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    private void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new a();
        }
        a aVar = this.m;
        aVar.a(drawable.getCallback());
        drawable.setCallback(aVar);
        try {
            if (this.f341a.A <= 0 && this.f346f) {
                drawable.setAlpha(this.f345e);
            }
            if (this.f341a.E) {
                drawable.setColorFilter(this.f341a.D);
            } else {
                if (this.f341a.H) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f341a.F);
                }
                if (this.f341a.I) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f341a.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f341a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f341a.C);
            }
            Rect rect = this.f342b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f346f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f343c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f345e
            r3.setAlpha(r9)
            r13.k = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.b.a.d$b r9 = r13.f341a
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f345e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.k = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f344d
            if (r9 == 0) goto L68
            long r10 = r13.l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L6a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L55
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f344d = r0
            r0 = -1
            r13.h = r0
            r13.l = r7
            goto L6a
        L55:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b.a.d$b r4 = r13.f341a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f345e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L6b
        L68:
            r13.l = r7
        L6a:
            r0 = r3
        L6b:
            if (r14 == 0) goto L77
            if (r0 == 0) goto L77
            java.lang.Runnable r14 = r13.j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.d.a(boolean):void");
    }

    final void a(Resources resources) {
        this.f341a.a(resources);
    }

    void a(b bVar) {
        this.f341a = bVar;
        int i = this.g;
        if (i >= 0) {
            this.f343c = bVar.a(i);
            Drawable drawable = this.f343c;
            if (drawable != null) {
                a(drawable);
            }
        }
        this.h = -1;
        this.f344d = null;
    }

    static int a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
