package androidx.appcompat.b.a;

import a.a.j;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.d;
import androidx.appcompat.b.a.f;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.M;
import androidx.core.content.a.i;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.k;
import cn.qqtheme.framework.widget.WheelView;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class b extends androidx.appcompat.b.a.f implements androidx.core.graphics.drawable.b {
    private C0003b p;
    private f q;
    private int r;
    private int s;
    private boolean t;

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f333a;

        a(Animatable animatable) {
            super();
            this.f333a = animatable;
        }

        @Override // androidx.appcompat.b.a.b.f
        public void c() {
            this.f333a.start();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void d() {
            this.f333a.stop();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.b.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class C0003b extends f.a {
        a.a.f<Long> K;
        j<Integer> L;

        C0003b(C0003b c0003b, b bVar, Resources resources) {
            super(c0003b, bVar, resources);
            if (c0003b != null) {
                this.K = c0003b.K;
                this.L = c0003b.L;
            } else {
                this.K = new a.a.f<>();
                this.L = new j<>();
            }
        }

        private static long f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int iA = super.a(drawable);
            long jF = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = iA;
            this.K.a(jF, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return iA;
        }

        int b(int[] iArr) {
            int iA = super.a(iArr);
            return iA >= 0 ? iA : super.a(StateSet.WILD_CARD);
        }

        int c(int i, int i2) {
            return (int) this.K.b(f(i, i2), -1L).longValue();
        }

        int d(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.b(i, 0).intValue();
        }

        boolean e(int i, int i2) {
            return (this.K.b(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.b.a.f.a, androidx.appcompat.b.a.d.b
        void m() {
            this.K = this.K.m0clone();
            this.L = this.L.m1clone();
        }

        @Override // androidx.appcompat.b.a.f.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this, null);
        }

        boolean d(int i, int i2) {
            return (this.K.b(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        @Override // androidx.appcompat.b.a.f.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new b(this, resources);
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int iA = super.a(iArr, drawable);
            this.L.c(iA, Integer.valueOf(i));
            return iA;
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f334a;

        c(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f334a = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.b.a.b.f
        public void c() {
            this.f334a.start();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void d() {
            this.f334a.stop();
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f336b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(eVar.a());
            objectAnimatorOfInt.setInterpolator(eVar);
            this.f336b = z2;
            this.f335a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.b.a.b.f
        public boolean a() {
            return this.f336b;
        }

        @Override // androidx.appcompat.b.a.b.f
        public void b() {
            this.f335a.reverse();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void c() {
            this.f335a.start();
        }

        @Override // androidx.appcompat.b.a.b.f
        public void d() {
            this.f335a.cancel();
        }
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static abstract class f {
        private f() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public b() {
        this(null, null);
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void d() {
        onStateChange(getState());
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = i.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayA.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayA.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayA.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableA = resourceId3 > 0 ? M.a().a(context, resourceId3) : null;
        boolean z = typedArrayA.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayA.recycle();
        if (drawableA == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableA = xmlPullParser.getName().equals("animated-vector") ? AnimatedVectorDrawableCompat.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableA == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.p.a(resourceId, resourceId2, drawableA, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayA = i.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayA.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(typedArrayA);
        a(resources);
        typedArrayA.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        d();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.b.a.f, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.q;
        if (fVar != null) {
            fVar.d();
            this.q = null;
            a(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.m();
                this.t = true;
            }
        }
        return this;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iB = this.p.b(iArr);
        boolean z = iB != b() && (b(iB) || a(iB));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.b.a.d, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    b(C0003b c0003b, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        a(new C0003b(c0003b, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = i.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayA.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayA.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableA = resourceId2 > 0 ? M.a().a(context, resourceId2) : null;
        typedArrayA.recycle();
        int[] iArrA = a(attributeSet);
        if (drawableA == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableA = xmlPullParser.getName().equals("vector") ? k.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableA != null) {
            return this.p.a(iArrA, drawableA, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            b bVar = new b();
            bVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return bVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    private static class e implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f339c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f338b = numberOfFrames;
            int[] iArr = this.f337a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f337a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f337a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f339c = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i = (int) ((f2 * this.f339c) + 0.5f);
            int i2 = this.f338b;
            int[] iArr = this.f337a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f339c : WheelView.DividerConfig.FILL);
        }

        int a() {
            return this.f339c;
        }
    }

    private boolean b(int i) {
        int iB;
        int iC;
        f aVar;
        f fVar = this.q;
        if (fVar != null) {
            if (i == this.r) {
                return true;
            }
            if (i == this.s && fVar.a()) {
                fVar.b();
                this.r = this.s;
                this.s = i;
                return true;
            }
            iB = this.r;
            fVar.d();
        } else {
            iB = b();
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        C0003b c0003b = this.p;
        int iD = c0003b.d(iB);
        int iD2 = c0003b.d(i);
        if (iD2 == 0 || iD == 0 || (iC = c0003b.c(iD, iD2)) < 0) {
            return false;
        }
        boolean zE = c0003b.e(iD, iD2);
        a(iC);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            aVar = new d((AnimationDrawable) current, c0003b.d(iD, iD2), zE);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            aVar = new c((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                aVar = new a((Animatable) current);
            }
            return false;
        }
        aVar.c();
        this.q = aVar;
        this.s = iB;
        this.r = i;
        return true;
    }

    private void a(TypedArray typedArray) {
        C0003b c0003b = this.p;
        if (Build.VERSION.SDK_INT >= 21) {
            c0003b.f351d |= typedArray.getChangingConfigurations();
        }
        c0003b.b(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, c0003b.i));
        c0003b.a(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, c0003b.l));
        c0003b.b(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, c0003b.A));
        c0003b.c(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, c0003b.B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, c0003b.x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d
    public C0003b a() {
        return new C0003b(this.p, this, null);
    }

    @Override // androidx.appcompat.b.a.f, androidx.appcompat.b.a.d
    void a(d.b bVar) {
        super.a(bVar);
        if (bVar instanceof C0003b) {
            this.p = (C0003b) bVar;
        }
    }
}
