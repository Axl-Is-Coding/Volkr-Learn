package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.s;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.a {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private int animState;
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final com.google.android.material.floatingactionbutton.a changeVisibilityTracker;
    private final q extendStrategy;
    private final q hideStrategy;
    private boolean isExtended;
    private final Rect shadowPadding;
    private final q showStrategy;
    private final q shrinkStrategy;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> WIDTH = new h(Float.class, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
    static final Property<View, Float> HEIGHT = new i(Float.class, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f13361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f13362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private c f13363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f13365e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f13364d = false;
            this.f13365e = true;
        }

        void setInternalAutoHideCallback(c cVar) {
            this.f13362b = cVar;
        }

        void setInternalAutoShrinkCallback(c cVar) {
            this.f13363c = cVar;
        }

        private boolean b(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout.d dVar) {
            if (dVar.h == 0) {
                dVar.h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f13364d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f13365e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, extendedFloatingActionButton);
            return false;
        }

        protected void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.performMotion(this.f13365e ? extendedFloatingActionButton.shrinkStrategy : extendedFloatingActionButton.hideStrategy, this.f13365e ? this.f13363c : this.f13362b);
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f13364d || this.f13365e) && ((CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams()).c() == view.getId();
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f13361a == null) {
                this.f13361a = new Rect();
            }
            Rect rect = this.f13361a;
            com.google.android.material.internal.f.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        protected void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.performMotion(this.f13365e ? extendedFloatingActionButton.extendStrategy : extendedFloatingActionButton.showStrategy, this.f13365e ? this.f13363c : this.f13362b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            a(coordinatorLayout, extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            Rect rect2 = extendedFloatingActionButton.shadowPadding;
            rect.set(extendedFloatingActionButton.getLeft() + rect2.left, extendedFloatingActionButton.getTop() + rect2.top, extendedFloatingActionButton.getRight() - rect2.right, extendedFloatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i;
            Rect rect = extendedFloatingActionButton.shadowPadding;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams();
            int i2 = 0;
            if (extendedFloatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) dVar).rightMargin) {
                i = rect.right;
            } else {
                i = extendedFloatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) dVar).leftMargin ? -rect.left : 0;
            }
            if (extendedFloatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) {
                i2 = rect.bottom;
            } else if (extendedFloatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) dVar).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.c(extendedFloatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.b((View) extendedFloatingActionButton, i);
            }
        }
    }

    class b extends com.google.android.material.floatingactionbutton.b {
        private boolean g;

        public b(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public void a() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public boolean c() {
            return ExtendedFloatingActionButton.this.isOrWillBeHidden();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void d() {
            super.d();
            this.g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public int e() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
            if (this.g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 1;
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public void a(c cVar) {
            if (cVar != null) {
                cVar.b(ExtendedFloatingActionButton.this);
            }
        }
    }

    public static abstract class c {
        public abstract void a(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void b(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void c(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void d(ExtendedFloatingActionButton extendedFloatingActionButton);
    }

    interface e {
        int getHeight();

        int getWidth();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeHidden() {
        return getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeShown() {
        return getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performMotion(q qVar, c cVar) {
        if (qVar.c()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            qVar.a();
            qVar.a(cVar);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetF = qVar.f();
        animatorSetF.addListener(new g(this, qVar, cVar));
        Iterator<Animator.AnimatorListener> it = qVar.g().iterator();
        while (it.hasNext()) {
            animatorSetF.addListener(it.next());
        }
        animatorSetF.start();
    }

    private boolean shouldAnimateVisibilityChange() {
        return ViewCompat.C(this) && !isInEditMode();
    }

    public void addOnExtendAnimationListener(Animator.AnimatorListener animatorListener) {
        this.extendStrategy.b(animatorListener);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.hideStrategy.b(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.showStrategy.b(animatorListener);
    }

    public void addOnShrinkAnimationListener(Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.b(animatorListener);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    int getCollapsedSize() {
        return (Math.min(ViewCompat.r(this), ViewCompat.q(this)) * 2) + getIconSize();
    }

    public com.google.android.material.a.h getExtendMotionSpec() {
        return this.extendStrategy.b();
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        return this.hideStrategy.b();
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        return this.showStrategy.b();
    }

    public com.google.android.material.a.h getShrinkMotionSpec() {
        return this.shrinkStrategy.b();
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.a();
        }
    }

    public void removeOnExtendAnimationListener(Animator.AnimatorListener animatorListener) {
        this.extendStrategy.a(animatorListener);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.hideStrategy.a(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.showStrategy.a(animatorListener);
    }

    public void removeOnShrinkAnimationListener(Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.a(animatorListener);
    }

    public void setExtendMotionSpec(com.google.android.material.a.h hVar) {
        this.extendStrategy.a(hVar);
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.isExtended == z) {
            return;
        }
        q qVar = z ? this.extendStrategy : this.shrinkStrategy;
        if (qVar.c()) {
            return;
        }
        qVar.a();
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        this.hideStrategy.a(hVar);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        this.showStrategy.a(hVar);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public void setShrinkMotionSpec(com.google.android.material.a.h hVar) {
        this.shrinkStrategy.a(hVar);
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(com.google.android.material.a.h.a(getContext(), i));
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(c cVar) {
        performMotion(this.extendStrategy, cVar);
    }

    public void hide(c cVar) {
        performMotion(this.hideStrategy, cVar);
    }

    public void show(c cVar) {
        performMotion(this.showStrategy, cVar);
    }

    public void shrink(c cVar) {
        performMotion(this.shrinkStrategy, cVar);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shadowPadding = new Rect();
        this.animState = 0;
        this.changeVisibilityTracker = new com.google.android.material.floatingactionbutton.a();
        this.showStrategy = new d(this.changeVisibilityTracker);
        this.hideStrategy = new b(this.changeVisibilityTracker);
        this.isExtended = true;
        this.behavior = new ExtendedFloatingActionButtonBehavior(context, attributeSet);
        TypedArray typedArrayA = s.a(context, attributeSet, R.styleable.ExtendedFloatingActionButton, i, DEF_STYLE_RES, new int[0]);
        com.google.android.material.a.h hVarA = com.google.android.material.a.h.a(context, typedArrayA, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        com.google.android.material.a.h hVarA2 = com.google.android.material.a.h.a(context, typedArrayA, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        com.google.android.material.a.h hVarA3 = com.google.android.material.a.h.a(context, typedArrayA, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        com.google.android.material.a.h hVarA4 = com.google.android.material.a.h.a(context, typedArrayA, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.extendStrategy = new a(aVar, new com.google.android.material.floatingactionbutton.e(this), true);
        this.shrinkStrategy = new a(aVar, new f(this), false);
        this.showStrategy.a(hVarA);
        this.hideStrategy.a(hVarA2);
        this.extendStrategy.a(hVarA3);
        this.shrinkStrategy.a(hVarA4);
        typedArrayA.recycle();
        setShapeAppearanceModel(com.google.android.material.l.n.a(context, attributeSet, i, DEF_STYLE_RES, com.google.android.material.l.n.f13529a).a());
    }

    class d extends com.google.android.material.floatingactionbutton.b {
        public d(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public void a() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public boolean c() {
            return ExtendedFloatingActionButton.this.isOrWillBeShown();
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public int e() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 2;
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public void a(c cVar) {
            if (cVar != null) {
                cVar.c(ExtendedFloatingActionButton.this);
            }
        }
    }

    class a extends com.google.android.material.floatingactionbutton.b {
        private final e g;
        private final boolean h;

        a(com.google.android.material.floatingactionbutton.a aVar, e eVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.g = eVar;
            this.h = z;
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public void a() {
            ExtendedFloatingActionButton.this.isExtended = this.h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (this.h) {
                ExtendedFloatingActionButton.this.measure(0, 0);
            }
            layoutParams.width = this.g.getWidth();
            layoutParams.height = this.g.getHeight();
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public boolean c() {
            return this.h == ExtendedFloatingActionButton.this.isExtended || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public int e() {
            return R.animator.mtrl_extended_fab_change_size_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public AnimatorSet f() {
            com.google.android.material.a.h hVarH = h();
            if (hVarH.c(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                PropertyValuesHolder[] propertyValuesHolderArrA = hVarH.a(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                propertyValuesHolderArrA[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.g.getWidth());
                hVarH.a(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, propertyValuesHolderArrA);
            }
            if (hVarH.c(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                PropertyValuesHolder[] propertyValuesHolderArrA2 = hVarH.a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                propertyValuesHolderArrA2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.g.getHeight());
                hVarH.a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, propertyValuesHolderArrA2);
            }
            return super.b(hVarH);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.q
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.isExtended = this.h;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.q
        public void a(c cVar) {
            if (cVar == null) {
                return;
            }
            if (this.h) {
                cVar.a(ExtendedFloatingActionButton.this);
            } else {
                cVar.d(ExtendedFloatingActionButton.this);
            }
        }
    }
}
