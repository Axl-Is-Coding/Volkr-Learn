package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbsActionBarView.java */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0289b extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected C0294g mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final a mVisAnimListener;
    protected androidx.core.view.F mVisibilityAnim;

    AbstractC0289b(Context context) {
        this(context, null);
    }

    protected static int next(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public void animateToVisibility(int i) {
        setupAnimatorToVisibility(i, 200L).c();
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        C0294g c0294g = this.mActionMenuPresenter;
        if (c0294g != null) {
            c0294g.c();
        }
    }

    public int getAnimatedVisibility() {
        return this.mVisibilityAnim != null ? this.mVisAnimListener.f630b : getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public abstract boolean hideOverflowMenu();

    public boolean isOverflowMenuShowPending() {
        C0294g c0294g = this.mActionMenuPresenter;
        if (c0294g != null) {
            return c0294g.g();
        }
        return false;
    }

    public abstract boolean isOverflowMenuShowing();

    public boolean isOverflowReserved() {
        C0294g c0294g = this.mActionMenuPresenter;
        return c0294g != null && c0294g.i();
    }

    protected int measureChildView(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0294g c0294g = this.mActionMenuPresenter;
        if (c0294g != null) {
            c0294g.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    protected int positionChild(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void postShowOverflowMenu() {
        post(new RunnableC0288a(this));
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            androidx.core.view.F f2 = this.mVisibilityAnim;
            if (f2 != null) {
                f2.a();
            }
            super.setVisibility(i);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public androidx.core.view.F setupAnimatorToVisibility(int i, long j) {
        androidx.core.view.F f2 = this.mVisibilityAnim;
        if (f2 != null) {
            f2.a();
        }
        if (i != 0) {
            androidx.core.view.F fA = ViewCompat.a(this);
            fA.a(WheelView.DividerConfig.FILL);
            fA.a(j);
            a aVar = this.mVisAnimListener;
            aVar.a(fA, i);
            fA.a(aVar);
            return fA;
        }
        if (getVisibility() != 0) {
            setAlpha(WheelView.DividerConfig.FILL);
        }
        androidx.core.view.F fA2 = ViewCompat.a(this);
        fA2.a(1.0f);
        fA2.a(j);
        a aVar2 = this.mVisAnimListener;
        aVar2.a(fA2, i);
        fA2.a(aVar2);
        return fA2;
    }

    public abstract boolean showOverflowMenu();

    /* JADX INFO: renamed from: androidx.appcompat.widget.b$a */
    /* JADX INFO: compiled from: AbsActionBarView.java */
    protected class a implements androidx.core.view.G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f629a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f630b;

        protected a() {
        }

        public a a(androidx.core.view.F f2, int i) {
            AbstractC0289b.this.mVisibilityAnim = f2;
            this.f630b = i;
            return this;
        }

        @Override // androidx.core.view.G
        public void b(View view) {
            if (this.f629a) {
                return;
            }
            AbstractC0289b abstractC0289b = AbstractC0289b.this;
            abstractC0289b.mVisibilityAnim = null;
            AbstractC0289b.super.setVisibility(this.f630b);
        }

        @Override // androidx.core.view.G
        public void c(View view) {
            AbstractC0289b.super.setVisibility(0);
            this.f629a = false;
        }

        @Override // androidx.core.view.G
        public void a(View view) {
            this.f629a = true;
        }
    }

    AbstractC0289b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbstractC0289b(Context context, AttributeSet attributeSet, int i) {
        int i2;
        super(context, attributeSet, i);
        this.mVisAnimListener = new a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && (i2 = typedValue.resourceId) != 0) {
            this.mPopupContext = new ContextThemeWrapper(context, i2);
        } else {
            this.mPopupContext = context;
        }
    }
}
