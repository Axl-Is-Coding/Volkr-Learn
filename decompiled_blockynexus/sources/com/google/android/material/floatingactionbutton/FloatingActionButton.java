package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.C0305s;
import androidx.appcompat.widget.C0307u;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.v;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.s;
import com.google.android.material.l.r;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@CoordinatorLayout.b(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements v, androidx.core.widget.n, com.google.android.material.g.a, r {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_FloatingActionButton;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final com.google.android.material.g.c expandableWidgetHelper;
    private final C0307u imageHelper;
    private PorterDuff.Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f13366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f13367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13368c;

        public BaseBehavior() {
            this.f13368c = true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.d) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide(this.f13367b, false);
                return true;
            }
            floatingActionButton.show(this.f13367b, false);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f13368c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout.d dVar) {
            if (dVar.h == 0) {
                dVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.f13368c && ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f13366a == null) {
                this.f13366a = new Rect();
            }
            Rect rect = this.f13366a;
            com.google.android.material.internal.f.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide(this.f13367b, false);
                return true;
            }
            floatingActionButton.show(this.f13367b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.shadowPadding;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) dVar).rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) dVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) dVar).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.c(floatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.b((View) floatingActionButton, i);
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.d dVar) {
            super.a(dVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.a(coordinatorLayout, floatingActionButton, i);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    class c<T extends FloatingActionButton> implements FloatingActionButtonImpl.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.android.material.a.k<T> f13370a;

        c(com.google.android.material.a.k<T> kVar) {
            this.f13370a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.d
        public void a() {
            this.f13370a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.d
        public void b() {
            this.f13370a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).f13370a.equals(this.f13370a);
        }

        public int hashCode() {
            return this.f13370a.hashCode();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private FloatingActionButtonImpl createImpl() {
        return Build.VERSION.SDK_INT >= 21 ? new p(this, new b()) : new FloatingActionButtonImpl(this, new b());
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = createImpl();
        }
        return this.impl;
    }

    private void offsetRectWithShadow(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.shadowPadding;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.b(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.imageMode;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0305s.a(colorForState, mode));
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private FloatingActionButtonImpl.e wrapOnVisibilityChangedListener(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new j(this, aVar);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public void addTransformationCallback(com.google.android.material.a.k<? extends FloatingActionButton> kVar) {
        getImpl().addTransformationCallback(new c(kVar));
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().g();
    }

    public Drawable getContentBackground() {
        return getImpl().b();
    }

    @Deprecated
    public boolean getContentRect(Rect rect) {
        if (!ViewCompat.C(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(rect);
        return true;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.a();
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        return getImpl().e();
    }

    public void getMeasuredContentRect(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(rect);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public com.google.android.material.l.n getShapeAppearanceModel() {
        com.google.android.material.l.n nVarH = getImpl().h();
        androidx.core.f.h.a(nVarH);
        return nVarH;
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        return getImpl().i();
    }

    public int getSize() {
        return this.size;
    }

    int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    @Override // androidx.core.view.v
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        hide(null);
    }

    @Override // com.google.android.material.g.b
    public boolean isExpanded() {
        return this.expandableWidgetHelper.b();
    }

    public boolean isOrWillBeHidden() {
        return getImpl().j();
    }

    public boolean isOrWillBeShown() {
        return getImpl().k();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().o();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().x();
        int iMin = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.m.b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.m.b bVar = (com.google.android.material.m.b) parcelable;
        super.onRestoreInstanceState(bVar.a());
        com.google.android.material.g.c cVar = this.expandableWidgetHelper;
        Bundle bundle = bVar.f13574c.get(EXPANDABLE_WIDGET_HELPER_KEY);
        androidx.core.f.h.a(bundle);
        cVar.a(bundle);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        com.google.android.material.m.b bVar = new com.google.android.material.m.b(parcelableOnSaveInstanceState);
        bVar.f13574c.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.c());
        return bVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getContentRect(this.touchArea) && !this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void removeTransformationCallback(com.google.android.material.a.k<? extends FloatingActionButton> kVar) {
        getImpl().removeTransformationCallback(new c(kVar));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().d(f2);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.customSize) {
            this.customSize = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().e(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().d()) {
            getImpl().a(z);
            requestLayout();
        }
    }

    public boolean setExpanded(boolean z) {
        return this.expandableWidgetHelper.a(z);
    }

    public void setExpandedComponentIdHint(int i) {
        this.expandableWidgetHelper.a(i);
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().w();
            if (this.imageTint != null) {
                onApplySupportImageTint();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.imageHelper.a(i);
        onApplySupportImageTint();
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().q();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().q();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().b(z);
    }

    @Override // com.google.android.material.l.r
    public void setShapeAppearanceModel(com.google.android.material.l.n nVar) {
        getImpl().a(nVar);
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public void setSize(int i) {
        this.customSize = 0;
        if (i != this.size) {
            this.size = i;
            requestLayout();
        }
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.imageTint != colorStateList) {
            this.imageTint = colorStateList;
            onApplySupportImageTint();
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.imageMode != mode) {
            this.imageMode = mode;
            onApplySupportImageTint();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().r();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().r();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().r();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.compatPadding != z) {
            this.compatPadding = z;
            getImpl().n();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().d();
    }

    public void show() {
        show(null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    private int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? getSizeDimension(1) : getSizeDimension(0);
    }

    public void hide(a aVar) {
        hide(aVar, true);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            getImpl().b(this.rippleColor);
        }
    }

    public void show(a aVar) {
        show(aVar, true);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayA = s.a(context2, attributeSet, R.styleable.FloatingActionButton, i, DEF_STYLE_RES, new int[0]);
        this.backgroundTint = com.google.android.material.i.c.a(context2, typedArrayA, R.styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = com.google.android.material.internal.v.a(typedArrayA.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.rippleColor = com.google.android.material.i.c.a(context2, typedArrayA, R.styleable.FloatingActionButton_rippleColor);
        this.size = typedArrayA.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.customSize = typedArrayA.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = typedArrayA.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayA.getDimension(R.styleable.FloatingActionButton_elevation, WheelView.DividerConfig.FILL);
        float dimension2 = typedArrayA.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, WheelView.DividerConfig.FILL);
        float dimension3 = typedArrayA.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, WheelView.DividerConfig.FILL);
        this.compatPadding = typedArrayA.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        this.maxImageSize = typedArrayA.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
        com.google.android.material.a.h hVarA = com.google.android.material.a.h.a(context2, typedArrayA, R.styleable.FloatingActionButton_showMotionSpec);
        com.google.android.material.a.h hVarA2 = com.google.android.material.a.h.a(context2, typedArrayA, R.styleable.FloatingActionButton_hideMotionSpec);
        com.google.android.material.l.n nVarA = com.google.android.material.l.n.a(context2, attributeSet, i, DEF_STYLE_RES, com.google.android.material.l.n.f13529a).a();
        boolean z = typedArrayA.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        typedArrayA.recycle();
        this.imageHelper = new C0307u(this);
        this.imageHelper.a(attributeSet, i);
        this.expandableWidgetHelper = new com.google.android.material.g.c(this);
        getImpl().a(nVarA);
        getImpl().a(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().b(dimensionPixelSize);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.maxImageSize);
        getImpl().b(hVarA);
        getImpl().a(hVarA2);
        getImpl().a(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    void hide(a aVar, boolean z) {
        getImpl().a(wrapOnVisibilityChangedListener(aVar), z);
    }

    void show(a aVar, boolean z) {
        getImpl().b(wrapOnVisibilityChangedListener(aVar), z);
    }

    private class b implements com.google.android.material.k.b {
        b() {
        }

        @Override // com.google.android.material.k.b
        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.shadowPadding.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.imagePadding, i2 + FloatingActionButton.this.imagePadding, i3 + FloatingActionButton.this.imagePadding, i4 + FloatingActionButton.this.imagePadding);
        }

        @Override // com.google.android.material.k.b
        public void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.k.b
        public boolean a() {
            return FloatingActionButton.this.compatPadding;
        }
    }
}
