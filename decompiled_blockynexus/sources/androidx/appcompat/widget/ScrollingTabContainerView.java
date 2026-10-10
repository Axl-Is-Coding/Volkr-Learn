package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final c mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;

    private class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((b) view).a().f();
            int childCount = ScrollingTabContainerView.this.mTabLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((b) ScrollingTabContainerView.this.mTabLayout.getChildAt(i)).a();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.createTabView((ActionBar.b) getItem(i), true);
            }
            ((b) view).a((ActionBar.b) getItem(i));
            return view;
        }
    }

    protected class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f581a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f582b;

        protected c() {
        }

        public c a(ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.f582b = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f581a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f581a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.mVisibilityAnim = null;
            scrollingTabContainerView.setVisibility(this.f582b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f581a = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.mVisAnimListener = new c();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.d.a aVarA = androidx.appcompat.d.a.a(context);
        setContentHeight(aVarA.e());
        this.mStackedTabMaxWidth = aVarA.d();
        this.mTabLayout = createTabLayout();
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        Spinner spinner = this.mTabSpinner;
        return spinner != null && spinner.getParent() == this;
    }

    private void performCollapse() {
        if (isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = createSpinner();
        }
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.b bVar, boolean z) {
        b bVarCreateTabView = createTabView(bVar, false);
        this.mTabLayout.addView(bVarCreateTabView, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            bVarCreateTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        View childAt = this.mTabLayout.getChildAt(i);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.mTabSelector = new P(this, childAt);
        post(this.mTabSelector);
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
    public void animateToVisibility(int i) {
        ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i != 0) {
            ViewPropertyAnimator viewPropertyAnimatorAlpha = animate().alpha(WheelView.DividerConfig.FILL);
            viewPropertyAnimatorAlpha.setDuration(200L);
            viewPropertyAnimatorAlpha.setInterpolator(sAlphaInterpolator);
            c cVar = this.mVisAnimListener;
            cVar.a(viewPropertyAnimatorAlpha, i);
            viewPropertyAnimatorAlpha.setListener(cVar);
            viewPropertyAnimatorAlpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(WheelView.DividerConfig.FILL);
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = animate().alpha(1.0f);
        viewPropertyAnimatorAlpha2.setDuration(200L);
        viewPropertyAnimatorAlpha2.setInterpolator(sAlphaInterpolator);
        c cVar2 = this.mVisAnimListener;
        cVar2.a(viewPropertyAnimatorAlpha2, i);
        viewPropertyAnimatorAlpha2.setListener(cVar2);
        viewPropertyAnimatorAlpha2.start();
    }

    b createTabView(ActionBar.b bVar, boolean z) {
        b bVar2 = new b(getContext(), bVar, z);
        if (z) {
            bVar2.setBackgroundDrawable(null);
            bVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            bVar2.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new TabClickListener();
            }
            bVar2.setOnClickListener(this.mTabClickListener);
        }
        return bVar2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.d.a aVarA = androidx.appcompat.d.a.a(getContext());
        setContentHeight(aVarA.e());
        this.mStackedTabMaxWidth = aVarA.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((b) view).a().f();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.mTabLayout.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.mMaxTabWidth = -1;
        } else {
            if (childCount > 2) {
                this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.mMaxTabWidth = View.MeasureSpec.getSize(i) / 2;
            }
            this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, FileTypeUtils.GIGABYTE);
        if (!z && this.mAllowCollapse) {
            this.mTabLayout.measure(0, iMakeMeasureSpec);
            if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                performCollapse();
            } else {
                performExpand();
            }
        } else {
            performExpand();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.mSelectedTabIndex);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.mTabLayout.removeViewAt(i);
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.mAllowCollapse = z;
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.mSelectedTabIndex = i;
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.mTabLayout.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        Spinner spinner = this.mTabSpinner;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void updateTab(int i) {
        ((b) this.mTabLayout.getChildAt(i)).b();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    private class b extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ActionBar.b f576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f579e;

        public b(Context context, ActionBar.b bVar, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f575a = new int[]{android.R.attr.background};
            this.f576b = bVar;
            ia iaVarA = ia.a(context, null, this.f575a, R.attr.actionBarTabStyle, 0);
            if (iaVarA.g(0)) {
                setBackgroundDrawable(iaVarA.b(0));
            }
            iaVarA.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(ActionBar.b bVar) {
            this.f576b = bVar;
            b();
        }

        public void b() {
            ActionBar.b bVar = this.f576b;
            View viewB = bVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f579e = viewB;
                TextView textView = this.f577c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f578d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f578d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f579e;
            if (view != null) {
                removeView(view);
                this.f579e = null;
            }
            Drawable drawableC = bVar.c();
            CharSequence charSequenceE = bVar.e();
            if (drawableC != null) {
                if (this.f578d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f578d = appCompatImageView;
                }
                this.f578d.setImageDrawable(drawableC);
                this.f578d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f578d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f578d.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceE);
            if (z) {
                if (this.f577c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f577c = appCompatTextView;
                }
                this.f577c.setText(charSequenceE);
                this.f577c.setVisibility(0);
            } else {
                TextView textView2 = this.f577c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f577c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f578d;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            na.a(this, z ? null : bVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.mMaxTabWidth > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = ScrollingTabContainerView.this.mMaxTabWidth;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, FileTypeUtils.GIGABYTE), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public ActionBar.b a() {
            return this.f576b;
        }
    }

    public void addTab(ActionBar.b bVar, int i, boolean z) {
        b bVarCreateTabView = createTabView(bVar, false);
        this.mTabLayout.addView(bVarCreateTabView, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            bVarCreateTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }
}
