package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: WrappedDrawableApi14.java */
/* JADX INFO: loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final PorterDuff.Mode f1170a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    f f1174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1175f;
    Drawable g;

    d(f fVar, Resources resources) {
        this.f1174e = fVar;
        a(resources);
    }

    private void a(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f1174e;
        if (fVar == null || (constantState = fVar.f1177b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    private f c() {
        return new f(this.f1174e);
    }

    protected boolean b() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f1174e;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f1174e;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f1174e.f1176a = getChangingConfigurations();
        return this.f1174e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.g.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!b() || (fVar = this.f1174e) == null) ? null : fVar.f1178c;
        return (colorStateList != null && colorStateList.isStateful()) || this.g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1175f && super.mutate() == this) {
            this.f1174e = c();
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f1174e;
            if (fVar != null) {
                Drawable drawable2 = this.g;
                fVar.f1177b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1175f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.g.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.g.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.g.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.g.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.g.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f1174e.f1178c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1174e.f1179d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.g.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        f fVar = this.f1174e;
        ColorStateList colorStateList = fVar.f1178c;
        PorterDuff.Mode mode = fVar.f1179d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f1173d || colorForState != this.f1171b || mode != this.f1172c) {
                setColorFilter(colorForState, mode);
                this.f1171b = colorForState;
                this.f1172c = mode;
                this.f1173d = true;
                return true;
            }
        } else {
            this.f1173d = false;
            clearColorFilter();
        }
        return false;
    }

    d(Drawable drawable) {
        this.f1174e = c();
        a(drawable);
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable a() {
        return this.g;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f1174e;
            if (fVar != null) {
                fVar.f1177b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
