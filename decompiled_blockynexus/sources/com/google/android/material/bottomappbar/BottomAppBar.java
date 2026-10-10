package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.s;
import com.google.android.material.internal.v;
import com.google.android.material.l.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private int animatingModeChangeCounter;
    private ArrayList<a> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    com.google.android.material.a.k<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private final com.google.android.material.l.i materialShapeDrawable;
    private Animator menuAnimator;
    private Animator modeAnimator;

    interface a {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    static class b extends androidx.customview.a.c {
        public static final Parcelable.Creator<b> CREATOR = new k();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13172d;

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13171c);
            parcel.writeInt(this.f13172d ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13171c = parcel.readInt();
            this.f13172d = parcel.readInt() != 0;
        }
    }

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFabAnimationListeners(FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new i(this));
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void createFabTranslationXAnimation(int i, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", getFabTranslationX(i));
        objectAnimatorOfFloat.setDuration(ANIMATION_DURATION);
        list.add(objectAnimatorOfFloat);
    }

    private void createMenuViewTranslationAnimation(int i, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", WheelView.DividerConfig.FILL);
            objectAnimatorOfFloat.addListener(new h(this, actionMenuView, i, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        ArrayList<a> arrayList;
        int i = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAnimationStart() {
        ArrayList<a> arrayList;
        int i = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i + 1;
        if (i != 0 || (arrayList = this.animationListeners) == null) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton findDependentFab() {
        View viewFindDependentView = findDependentView();
        if (viewFindDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) viewFindDependentView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.bottomInset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX(int i) {
        boolean z = ViewCompat.m(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.fabOffsetEndMode) * (z ? -1 : 1);
        }
        return WheelView.DividerConfig.FILL;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l getTopEdgeTreatment() {
        return (l) this.materialShapeDrawable.l().i();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        return floatingActionButtonFindDependentFab != null && floatingActionButtonFindDependentFab.isOrWillBeShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeAnimateMenuView(int i, boolean z) {
        if (ViewCompat.C(this)) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!isFabVisibleOrWillBeShown()) {
                i = 0;
                z = false;
            }
            createMenuViewTranslationAnimation(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.menuAnimator = animatorSet;
            this.menuAnimator.addListener(new g(this));
            this.menuAnimator.start();
        }
    }

    private void maybeAnimateModeChange(int i) {
        if (this.fabAlignmentMode == i || !ViewCompat.C(this)) {
            return;
        }
        Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.fabAnimationMode == 1) {
            createFabTranslationXAnimation(i, arrayList);
        } else {
            createFabDefaultXAnimation(i, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.modeAnimator = animatorSet;
        this.modeAnimator.addListener(new d(this));
        this.modeAnimator.start();
    }

    private void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (isFabVisibleOrWillBeShown()) {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
            } else {
                translateActionMenuView(actionMenuView, 0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCutoutState() {
        getTopEdgeTreatment().e(getFabTranslationX());
        View viewFindDependentView = findDependentView();
        this.materialShapeDrawable.c((this.fabAttached && isFabVisibleOrWillBeShown()) ? 1.0f : WheelView.DividerConfig.FILL);
        if (viewFindDependentView != null) {
            viewFindDependentView.setTranslationY(getFabTranslationY());
            viewFindDependentView.setTranslationX(getFabTranslationX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateActionMenuView(ActionMenuView actionMenuView, int i, boolean z) {
        actionMenuView.setTranslationX(getActionMenuViewTranslationX(actionMenuView, i, z));
    }

    void addAnimationListener(a aVar) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(aVar);
    }

    protected void createFabDefaultXAnimation(int i, List<Animator> list) {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        if (floatingActionButtonFindDependentFab == null || floatingActionButtonFindDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        floatingActionButtonFindDependentFab.hide(new f(this, i));
    }

    protected int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.m(this) == 1;
        int measuredWidth = z2 ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f196a & 8388615) == 8388611) {
                measuredWidth = z2 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = measuredWidth - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft());
        if (i == 1 && z) {
            return right;
        }
        return 0;
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.m();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().b();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().c();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().d();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.l.j.a(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            cancelAnimations();
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.a());
        this.fabAlignmentMode = bVar.f13171c;
        this.fabAttached = bVar.f13172d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f13171c = this.fabAlignmentMode;
        bVar.f13172d = this.fabAttached;
        return bVar;
    }

    public void performHide() {
        getBehavior().a(this);
    }

    public void performShow() {
        getBehavior().b(this);
    }

    void removeAnimationListener(a aVar) {
        ArrayList<a> arrayList = this.animationListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
    }

    public void replaceMenu(int i) {
        getMenu().clear();
        inflateMenu(i);
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a(this.materialShapeDrawable, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().a(f2);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.materialShapeDrawable.b(f2);
        getBehavior().a(this, this.materialShapeDrawable.k() - this.materialShapeDrawable.j());
    }

    public void setFabAlignmentMode(int i) {
        maybeAnimateModeChange(i);
        maybeAnimateMenuView(i, this.fabAttached);
        this.fabAlignmentMode = i;
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().b(f2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().c(f2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    boolean setFabDiameter(int i) {
        float f2 = i;
        if (f2 == getTopEdgeTreatment().e()) {
            return false;
        }
        getTopEdgeTreatment().d(f2);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Rect f13169e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference<BottomAppBar> f13170f;
        private int g;
        private final View.OnLayoutChangeListener h;

        public Behavior() {
            this.h = new j(this);
            this.f13169e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.f13170f = new WeakReference<>(bottomAppBar);
            View viewFindDependentView = bottomAppBar.findDependentView();
            if (viewFindDependentView != null && !ViewCompat.C(viewFindDependentView)) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) viewFindDependentView.getLayoutParams();
                dVar.f901d = 49;
                this.g = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
                if (viewFindDependentView instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewFindDependentView;
                    floatingActionButton.addOnLayoutChangeListener(this.h);
                    bottomAppBar.addFabAnimationListeners(floatingActionButton);
                }
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.a(coordinatorLayout, bottomAppBar, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = new j(this);
            this.f13169e = new Rect();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.b(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.materialShapeDrawable = new com.google.android.material.l.i();
        this.animatingModeChangeCounter = 0;
        this.fabAttached = true;
        this.fabAnimationListener = new com.google.android.material.bottomappbar.a(this);
        this.fabTransformationCallback = new com.google.android.material.bottomappbar.b(this);
        Context context2 = getContext();
        TypedArray typedArrayA = s.a(context2, attributeSet, R.styleable.BottomAppBar, i, DEF_STYLE_RES, new int[0]);
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context2, typedArrayA, R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayA.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayA.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayA.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = typedArrayA.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = typedArrayA.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = typedArrayA.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        typedArrayA.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        l lVar = new l(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        n.a aVarA = n.a();
        aVarA.a(lVar);
        this.materialShapeDrawable.setShapeAppearanceModel(aVarA.a());
        this.materialShapeDrawable.c(2);
        this.materialShapeDrawable.a(Paint.Style.FILL);
        this.materialShapeDrawable.a(context2);
        setElevation(dimensionPixelSize);
        androidx.core.graphics.drawable.a.a(this.materialShapeDrawable, colorStateListA);
        ViewCompat.a(this, this.materialShapeDrawable);
        v.a(this, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
