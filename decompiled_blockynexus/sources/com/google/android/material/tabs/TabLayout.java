package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.na;
import androidx.core.view.C0313a;
import androidx.core.view.C0319g;
import androidx.core.view.ViewCompat;
import androidx.core.view.t;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import com.google.android.material.internal.v;
import com.google.android.material.l.i;
import com.google.android.material.l.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.a
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final androidx.core.f.e<f> tabPool = new androidx.core.f.g(16);
    private a adapterChangeListener;
    private int contentInsetStart;
    private b currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private g pageChangeListener;
    private androidx.viewpager.widget.a pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private b selectedListener;
    private final ArrayList<b> selectedListeners;
    private f selectedTab;
    private boolean setupViewPagerImplicitly;
    private final e slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final RectF tabViewContentBounds;
    private final androidx.core.f.e<TabView> tabViewPool;
    private final ArrayList<f> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;

    public final class TabView extends LinearLayout {
        private View badgeAnchorView;
        private com.google.android.material.b.b badgeDrawable;
        private Drawable baseBackgroundDrawable;
        private ImageView customIconView;
        private TextView customTextView;
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private f tab;
        private TextView textView;

        public TabView(Context context) {
            super(context);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(context);
            ViewCompat.b(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.a(this, t.a(getContext(), 1002));
            ViewCompat.a(this, (C0313a) null);
        }

        private void addOnLayoutChangeListener(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new com.google.android.material.tabs.d(this, view));
        }

        private float approximateLineWidth(Layout layout, int i, float f2) {
            return layout.getLineWidth(i) * (f2 / layout.getPaint().getTextSize());
        }

        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(Canvas canvas) {
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.android.material.b.b getBadge() {
            return this.badgeDrawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (View view : new View[]{this.textView, this.iconView, this.customView}) {
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        private FrameLayout getCustomParentForBadge(View view) {
            if ((view == this.iconView || view == this.textView) && com.google.android.material.b.c.f13151a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.google.android.material.b.b getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = com.google.android.material.b.b.a(getContext());
            }
            tryUpdateBadgeAnchor();
            com.google.android.material.b.b bVar = this.badgeDrawable;
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            return this.badgeDrawable != null;
        }

        private void inflateAndAddDefaultIconView() {
            FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot;
            if (com.google.android.material.b.c.f13151a) {
                frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot, 0);
            } else {
                frameLayoutCreatePreApi18BadgeAnchorRoot = this;
            }
            this.iconView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayoutCreatePreApi18BadgeAnchorRoot, false);
            frameLayoutCreatePreApi18BadgeAnchorRoot.addView(this.iconView, 0);
        }

        private void inflateAndAddDefaultTextView() {
            FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot;
            if (com.google.android.material.b.c.f13151a) {
                frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot);
            } else {
                frameLayoutCreatePreApi18BadgeAnchorRoot = this;
            }
            this.textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayoutCreatePreApi18BadgeAnchorRoot, false);
            frameLayoutCreatePreApi18BadgeAnchorRoot.addView(this.textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(View view) {
            if (hasBadgeDrawable() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                com.google.android.material.b.c.a(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable() && this.badgeAnchorView != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.b.b bVar = this.badgeDrawable;
                View view = this.badgeAnchorView;
                com.google.android.material.b.c.b(bVar, view, getCustomParentForBadge(view));
                this.badgeAnchorView = null;
            }
        }

        private void tryUpdateBadgeAnchor() {
            f fVar;
            f fVar2;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                if (this.iconView != null && (fVar2 = this.tab) != null && fVar2.b() != null) {
                    View view = this.badgeAnchorView;
                    ImageView imageView = this.iconView;
                    if (view == imageView) {
                        tryUpdateBadgeDrawableBounds(imageView);
                        return;
                    } else {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                }
                if (this.textView == null || (fVar = this.tab) == null || fVar.d() != 1) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                View view2 = this.badgeAnchorView;
                TextView textView = this.textView;
                if (view2 == textView) {
                    tryUpdateBadgeDrawableBounds(textView);
                } else {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.textView);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                com.google.android.material.b.c.c(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateBackgroundDrawable(Context context) {
            int i = TabLayout.this.tabBackgroundResId;
            if (i != 0) {
                this.baseBackgroundDrawable = androidx.appcompat.a.a.a.b(context, i);
                Drawable drawable = this.baseBackgroundDrawable;
                if (drawable != null && drawable.isStateful()) {
                    this.baseBackgroundDrawable.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable layerDrawable = gradientDrawable;
            if (TabLayout.this.tabRippleColorStateList != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = com.google.android.material.j.c.a(TabLayout.this.tabRippleColorStateList);
                if (Build.VERSION.SDK_INT >= 21) {
                    GradientDrawable gradientDrawable3 = gradientDrawable;
                    if (TabLayout.this.unboundedRipple) {
                        gradientDrawable3 = null;
                    }
                    layerDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, TabLayout.this.unboundedRipple ? null : gradientDrawable2);
                } else {
                    Drawable drawableI = androidx.core.graphics.drawable.a.i(gradientDrawable2);
                    androidx.core.graphics.drawable.a.a(drawableI, colorStateListA);
                    layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawableI});
                }
            }
            ViewCompat.a(this, layerDrawable);
            TabLayout.this.invalidate();
        }

        private void updateTextAndIcon(TextView textView, ImageView imageView) {
            f fVar = this.tab;
            Drawable drawableMutate = (fVar == null || fVar.b() == null) ? null : androidx.core.graphics.drawable.a.i(this.tab.b()).mutate();
            f fVar2 = this.tab;
            CharSequence charSequenceE = fVar2 != null ? fVar2.e() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceE);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceE);
                    if (this.tab.g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iA = (z && imageView.getVisibility() == 0) ? (int) v.a(getContext(), 8) : 0;
                if (TabLayout.this.inlineLabel) {
                    if (iA != C0319g.a(marginLayoutParams)) {
                        C0319g.a(marginLayoutParams, iA);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iA != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iA;
                    C0319g.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.tab;
            CharSequence charSequence = fVar3 != null ? fVar3.f13630d : null;
            if (z) {
                charSequence = null;
            }
            na.a(this, charSequence);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.baseBackgroundDrawable.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public f getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.b.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
            com.google.android.material.b.b bVar = this.badgeDrawable;
            if (bVar == null || !bVar.isVisible()) {
                return;
            }
            accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.badgeDrawable.b()));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.textView != null) {
                float f2 = TabLayout.this.tabTextSize;
                int i3 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.textView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int iD = TextViewCompat.d(this.textView);
                if (f2 != textSize || (iD >= 0 && i3 != iD)) {
                    if (TabLayout.this.mode == 1 && f2 > textSize && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.textView.setTextSize(0, f2);
                        this.textView.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.tab == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.tab.h();
            return true;
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        void setTab(f fVar) {
            if (fVar != this.tab) {
                this.tab = fVar;
                update();
            }
        }

        final void update() {
            f fVar = this.tab;
            Drawable drawableMutate = null;
            View viewA = fVar != null ? fVar.a() : null;
            if (viewA != null) {
                ViewParent parent = viewA.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewA);
                    }
                    addView(viewA);
                }
                this.customView = viewA;
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                this.customTextView = (TextView) viewA.findViewById(android.R.id.text1);
                TextView textView2 = this.customTextView;
                if (textView2 != null) {
                    this.defaultMaxLines = TextViewCompat.d(textView2);
                }
                this.customIconView = (ImageView) viewA.findViewById(android.R.id.icon);
            } else {
                View view = this.customView;
                if (view != null) {
                    removeView(view);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (fVar != null && fVar.b() != null) {
                    drawableMutate = androidx.core.graphics.drawable.a.i(fVar.b()).mutate();
                }
                if (drawableMutate != null) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, TabLayout.this.tabIconTint);
                    PorterDuff.Mode mode = TabLayout.this.tabIconTintMode;
                    if (mode != null) {
                        androidx.core.graphics.drawable.a.a(drawableMutate, mode);
                    }
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = TextViewCompat.d(this.textView);
                }
                TextViewCompat.d(this.textView, TabLayout.this.tabTextAppearance);
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else if (this.customTextView != null || this.customIconView != null) {
                updateTextAndIcon(this.customTextView, this.customIconView);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f13630d)) {
                setContentDescription(fVar.f13630d);
            }
            setSelected(fVar != null && fVar.f());
        }

        final void updateOrientation() {
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            if (this.customTextView == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView);
            } else {
                updateTextAndIcon(this.customTextView, this.customIconView);
            }
        }
    }

    @Deprecated
    public interface b<T extends f> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    public interface c extends b<f> {
    }

    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f13627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable f13628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f13629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f13630d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f13632f;
        public TabLayout h;
        public TabView i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f13631e = -1;
        private int g = 1;

        public f d(int i) {
            this.g = i;
            TabLayout tabLayout = this.h;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                this.h.updateTabViews(true);
            }
            i();
            if (com.google.android.material.b.c.f13151a && this.i.hasBadgeDrawable() && this.i.badgeDrawable.isVisible()) {
                this.i.invalidate();
            }
            return this;
        }

        public CharSequence e() {
            return this.f13629c;
        }

        public boolean f() {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f13631e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void g() {
            this.h = null;
            this.i = null;
            this.f13627a = null;
            this.f13628b = null;
            this.f13629c = null;
            this.f13630d = null;
            this.f13631e = -1;
            this.f13632f = null;
        }

        public void h() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.selectTab(this);
        }

        void i() {
            TabView tabView = this.i;
            if (tabView != null) {
                tabView.update();
            }
        }

        public View a() {
            return this.f13632f;
        }

        public Drawable b() {
            return this.f13628b;
        }

        public int c() {
            return this.f13631e;
        }

        public f a(View view) {
            this.f13632f = view;
            i();
            return this;
        }

        public f b(int i) {
            TabLayout tabLayout = this.h;
            if (tabLayout != null) {
                a(androidx.appcompat.a.a.a.b(tabLayout.getContext(), i));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void c(int i) {
            this.f13631e = i;
        }

        public f a(int i) {
            a(LayoutInflater.from(this.i.getContext()).inflate(i, (ViewGroup) this.i, false));
            return this;
        }

        public f b(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f13630d) && !TextUtils.isEmpty(charSequence)) {
                this.i.setContentDescription(charSequence);
            }
            this.f13629c = charSequence;
            i();
            return this;
        }

        public f a(Drawable drawable) {
            this.f13628b = drawable;
            TabLayout tabLayout = this.h;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                this.h.updateTabViews(true);
            }
            i();
            if (com.google.android.material.b.c.f13151a && this.i.hasBadgeDrawable() && this.i.badgeDrawable.isVisible()) {
                this.i.invalidate();
            }
            return this;
        }

        public int d() {
            return this.g;
        }

        public f a(CharSequence charSequence) {
            this.f13630d = charSequence;
            i();
            return this;
        }
    }

    public static class g implements ViewPager.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<TabLayout> f13633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13635c;

        public g(TabLayout tabLayout) {
            this.f13633a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f13635c = 0;
            this.f13634b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int i) {
            this.f13634b = this.f13635c;
            this.f13635c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int i, float f2, int i2) {
            TabLayout tabLayout = this.f13633a.get();
            if (tabLayout != null) {
                tabLayout.setScrollPosition(i, f2, this.f13635c != 2 || this.f13634b == 1, (this.f13635c == 2 && this.f13634b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.f13633a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.f13635c;
            tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.f13634b == 0));
        }
    }

    public static class h implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f13636a;

        public h(ViewPager viewPager) {
            this.f13636a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void onTabReselected(f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void onTabSelected(f fVar) {
            this.f13636a.setCurrentItem(fVar.c());
        }

        @Override // com.google.android.material.tabs.TabLayout.b
        public void onTabUnselected(f fVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void addTabFromItemView(TabItem tabItem) {
        f fVarNewTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            fVarNewTab.b(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            fVarNewTab.a(drawable);
        }
        int i = tabItem.customLayout;
        if (i != 0) {
            fVarNewTab.a(i);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            fVarNewTab.a(tabItem.getContentDescription());
        }
        addTab(fVarNewTab);
    }

    private void addTabView(f fVar) {
        TabView tabView = fVar.i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, fVar.c(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        addTabFromItemView((TabItem) view);
    }

    private void animateToTab(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.C(this) || this.slidingTabIndicator.a()) {
            setScrollPosition(i, WheelView.DividerConfig.FILL, true);
            return;
        }
        int scrollX = getScrollX();
        int iCalculateScrollXForTab = calculateScrollXForTab(i, WheelView.DividerConfig.FILL);
        if (scrollX != iCalculateScrollXForTab) {
            ensureScrollAnimator();
            this.scrollAnimator.setIntValues(scrollX, iCalculateScrollXForTab);
            this.scrollAnimator.start();
        }
        this.slidingTabIndicator.a(i, this.tabIndicatorAnimationDuration);
    }

    private void applyModeAndGravity() {
        int i = this.mode;
        ViewCompat.b(this.slidingTabIndicator, (i == 0 || i == 2) ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        int i2 = this.mode;
        if (i2 == 0) {
            this.slidingTabIndicator.setGravity(8388611);
        } else if (i2 == 1 || i2 == 2) {
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i, float f2) {
        int i2 = this.mode;
        if (i2 != 0 && i2 != 2) {
            return 0;
        }
        View childAt = this.slidingTabIndicator.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f2);
        return ViewCompat.m(this) == 0 ? left + i4 : left - i4;
    }

    private void configureTab(f fVar, int i) {
        fVar.c(i);
        this.tabs.add(i, fVar);
        int size = this.tabs.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            } else {
                this.tabs.get(i).c(i);
            }
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private TabView createTabView(f fVar) {
        androidx.core.f.e<TabView> eVar = this.tabViewPool;
        TabView tabViewA = eVar != null ? eVar.a() : null;
        if (tabViewA == null) {
            tabViewA = new TabView(getContext());
        }
        tabViewA.setTab(fVar);
        tabViewA.setFocusable(true);
        tabViewA.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.f13630d)) {
            tabViewA.setContentDescription(fVar.f13629c);
        } else {
            tabViewA.setContentDescription(fVar.f13630d);
        }
        return tabViewA;
    }

    private void dispatchTabReselected(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(fVar);
        }
    }

    private void dispatchTabSelected(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(fVar);
        }
    }

    private void dispatchTabUnselected(f fVar) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(fVar);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            this.scrollAnimator = new ValueAnimator();
            this.scrollAnimator.setInterpolator(com.google.android.material.a.a.f13082b);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new com.google.android.material.tabs.a(this));
        }
    }

    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                f fVar = this.tabs.get(i);
                if (fVar != null && fVar.b() != null && !TextUtils.isEmpty(fVar.e())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return (!z || this.inlineLabel) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i = this.requestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        int i2 = this.mode;
        if (i2 == 0 || i2 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i);
        this.slidingTabIndicator.removeViewAt(i);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.a(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            this.tabs.get(i).i();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = WheelView.DividerConfig.FILL;
        }
    }

    public void addOnTabSelectedListener(c cVar) {
        addOnTabSelectedListener((b) cVar);
    }

    public void addTab(f fVar) {
        addTab(fVar, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    protected f createTabFromPool() {
        f fVarA = tabPool.a();
        return fVarA == null ? new f() : fVarA;
    }

    public int getSelectedTabPosition() {
        f fVar = this.selectedTab;
        if (fVar != null) {
            return fVar.c();
        }
        return -1;
    }

    public f getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public f newTab() {
        f fVarCreateTabFromPool = createTabFromPool();
        fVarCreateTabFromPool.h = this;
        fVarCreateTabFromPool.i = createTabView(fVarCreateTabFromPool);
        return fVarCreateTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            View childAt = this.slidingTabIndicator.getChildAt(i);
            if (childAt instanceof TabView) {
                ((TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.v.a(r0, r1)
            int r0 = (int) r0
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2b
            if (r1 == 0) goto L1c
            goto L3e
        L1c:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L3e
        L2b:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L3e
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L3e
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L3e:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5c
            int r1 = r6.requestedTabMaxWidth
            if (r1 <= 0) goto L4d
            goto L5a
        L4d:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.v.a(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5a:
            r6.tabMaxWidth = r1
        L5c:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.mode
            if (r0 == 0) goto L7f
            if (r0 == r5) goto L73
            r1 = 2
            if (r0 == r1) goto L7f
            goto L8a
        L73:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8a
        L7d:
            r4 = 1
            goto L8a
        L7f:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8a
            goto L7d
        L8a:
            if (r4 == 0) goto Laa
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        androidx.viewpager.widget.a aVar = this.pagerAdapter;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i = 0; i < count; i++) {
                f fVarNewTab = newTab();
                fVarNewTab.b(this.pagerAdapter.getPageTitle(i));
                addTab(fVarNewTab, false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem));
        }
    }

    protected boolean releaseFromTabPool(f fVar) {
        return tabPool.a(fVar);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<f> it = this.tabs.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.g();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(c cVar) {
        removeOnTabSelectedListener((b) cVar);
    }

    public void removeTab(f fVar) {
        if (fVar.h != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(fVar.c());
    }

    public void removeTabAt(int i) {
        f fVar = this.selectedTab;
        int iC = fVar != null ? fVar.c() : 0;
        removeTabViewAt(i);
        f fVarRemove = this.tabs.remove(i);
        if (fVarRemove != null) {
            fVarRemove.g();
            releaseFromTabPool(fVarRemove);
        }
        int size = this.tabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.tabs.get(i2).c(i2);
        }
        if (iC == i) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, i - 1)));
        }
    }

    public void selectTab(f fVar) {
        selectTab(fVar, true);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        j.a(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        setOnTabSelectedListener((b) cVar);
    }

    void setPagerAdapter(androidx.viewpager.widget.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.pagerAdapter;
        if (aVar2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = aVar;
        if (z && aVar != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new d();
            }
            aVar.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i, float f2, boolean z) {
        setScrollPosition(i, f2, z, true);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            this.tabSelectedIndicator = drawable;
            ViewCompat.G(this.slidingTabIndicator);
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.slidingTabIndicator.a(i);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            ViewCompat.G(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.slidingTabIndicator.b(i);
    }

    public void setTabGravity(int i) {
        if (this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        ViewCompat.G(this.slidingTabIndicator);
    }

    public void setTabMode(int i) {
        if (i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        setPagerAdapter(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    void updateTabViews(boolean z) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            View childAt = this.slidingTabIndicator.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private class a implements ViewPager.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13618a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(aVar2, this.f13618a);
            }
        }

        void a(boolean z) {
            this.f13618a = z;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(b bVar) {
        if (this.selectedListeners.contains(bVar)) {
            return;
        }
        this.selectedListeners.add(bVar);
    }

    public void addTab(f fVar, int i) {
        addTab(fVar, i, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(b bVar) {
        this.selectedListeners.remove(bVar);
    }

    public void selectTab(f fVar, boolean z) {
        f fVar2 = this.selectedTab;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                dispatchTabReselected(fVar);
                animateToTab(fVar.c());
                return;
            }
            return;
        }
        int iC = fVar != null ? fVar.c() : -1;
        if (z) {
            if ((fVar2 == null || fVar2.c() == -1) && iC != -1) {
                setScrollPosition(iC, WheelView.DividerConfig.FILL, true);
            } else {
                animateToTab(iC);
            }
            if (iC != -1) {
                setSelectedTabView(iC);
            }
        }
        this.selectedTab = fVar;
        if (fVar2 != null) {
            dispatchTabUnselected(fVar2);
        }
        if (fVar != null) {
            dispatchTabSelected(fVar);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.selectedListener;
        if (bVar2 != null) {
            removeOnTabSelectedListener(bVar2);
        }
        this.selectedListener = bVar;
        if (bVar != null) {
            addOnTabSelectedListener(bVar);
        }
    }

    public void setScrollPosition(int i, float f2, boolean z, boolean z2) {
        int iRound = Math.round(i + f2);
        if (iRound < 0 || iRound >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z2) {
            this.slidingTabIndicator.a(i, f2);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i, f2), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Paint f13622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final GradientDrawable f13623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f13624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f13625e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13626f;
        private int g;
        private int h;
        private ValueAnimator i;

        e(Context context) {
            super(context);
            this.f13624d = -1;
            this.f13626f = -1;
            this.g = -1;
            this.h = -1;
            setWillNotDraw(false);
            this.f13622b = new Paint();
            this.f13623c = new GradientDrawable();
        }

        void a(int i) {
            if (this.f13622b.getColor() != i) {
                this.f13622b.setColor(i);
                ViewCompat.G(this);
            }
        }

        void b(int i) {
            if (this.f13621a != i) {
                this.f13621a = i;
                ViewCompat.G(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.tabSelectedIndicator;
            int height = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i = this.f13621a;
            if (i >= 0) {
                intrinsicHeight = i;
            }
            int i2 = TabLayout.this.tabIndicatorGravity;
            if (i2 == 0) {
                height = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i2 == 1) {
                height = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i2 != 2) {
                intrinsicHeight = i2 != 3 ? 0 : getHeight();
            }
            int i3 = this.g;
            if (i3 >= 0 && this.h > i3) {
                Drawable drawable2 = TabLayout.this.tabSelectedIndicator;
                if (drawable2 == null) {
                    drawable2 = this.f13623c;
                }
                Drawable drawableI = androidx.core.graphics.drawable.a.i(drawable2);
                drawableI.setBounds(this.g, height, this.h, intrinsicHeight);
                Paint paint = this.f13622b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        drawableI.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.b(drawableI, paint.getColor());
                    }
                }
                drawableI.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
                return;
            }
            this.i.cancel();
            a(this.f13624d, Math.round((1.0f - this.i.getAnimatedFraction()) * this.i.getDuration()));
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) v.a(getContext(), 16)) * 2)) {
                    z = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != WheelView.DividerConfig.FILL) {
                            layoutParams.width = iMax;
                            layoutParams.weight = WheelView.DividerConfig.FILL;
                            z = true;
                        }
                    }
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.tabGravity = 0;
                    tabLayout2.updateTabViews(false);
                    z = true;
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.f13626f == i) {
                return;
            }
            requestLayout();
            this.f13626f = i;
        }

        private void b() {
            int left;
            int right;
            View childAt = getChildAt(this.f13624d);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                    a((TabView) childAt, tabLayout.tabViewContentBounds);
                    left = (int) TabLayout.this.tabViewContentBounds.left;
                    right = (int) TabLayout.this.tabViewContentBounds.right;
                }
                if (this.f13625e > WheelView.DividerConfig.FILL && this.f13624d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f13624d + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.tabIndicatorFullWidth && (childAt2 instanceof TabView)) {
                        a((TabView) childAt2, tabLayout2.tabViewContentBounds);
                        left2 = (int) TabLayout.this.tabViewContentBounds.left;
                        right2 = (int) TabLayout.this.tabViewContentBounds.right;
                    }
                    float f2 = this.f13625e;
                    left = (int) ((left2 * f2) + ((1.0f - f2) * left));
                    right = (int) ((right2 * f2) + ((1.0f - f2) * right));
                }
            }
            b(left, right);
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void a(int i, float f2) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            this.f13624d = i;
            this.f13625e = f2;
            b();
        }

        void a(int i, int i2) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                a((TabView) childAt, tabLayout.tabViewContentBounds);
                left = (int) TabLayout.this.tabViewContentBounds.left;
                right = (int) TabLayout.this.tabViewContentBounds.right;
            }
            int i3 = left;
            int i4 = right;
            int i5 = this.g;
            int i6 = this.h;
            if (i5 == i3 && i6 == i4) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.i = valueAnimator2;
            valueAnimator2.setInterpolator(com.google.android.material.a.a.f13082b);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(WheelView.DividerConfig.FILL, 1.0f);
            valueAnimator2.addUpdateListener(new com.google.android.material.tabs.b(this, i5, i3, i6, i4));
            valueAnimator2.addListener(new com.google.android.material.tabs.c(this, i));
            valueAnimator2.start();
        }

        void b(int i, int i2) {
            if (i == this.g && i2 == this.h) {
                return;
            }
            this.g = i;
            this.h = i2;
            ViewCompat.G(this);
        }

        private void a(TabView tabView, RectF rectF) {
            int contentWidth = tabView.getContentWidth();
            int iA = (int) v.a(getContext(), 24);
            if (contentWidth < iA) {
                contentWidth = iA;
            }
            int left = (tabView.getLeft() + tabView.getRight()) / 2;
            int i = contentWidth / 2;
            rectF.set(left - i, WheelView.DividerConfig.FILL, left + i, WheelView.DividerConfig.FILL);
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tabs = new ArrayList<>();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new androidx.core.f.f(12);
        setHorizontalScrollBarEnabled(false);
        this.slidingTabIndicator = new e(context);
        super.addView(this.slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayA = s.a(context, attributeSet, R.styleable.TabLayout, i, R.style.Widget_Design_TabLayout, R.styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            i iVar = new i();
            iVar.a(ColorStateList.valueOf(colorDrawable.getColor()));
            iVar.a(context);
            iVar.b(ViewCompat.i(this));
            ViewCompat.a(this, iVar);
        }
        this.slidingTabIndicator.b(typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        this.slidingTabIndicator.a(typedArrayA.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.i.c.b(context, typedArrayA, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayA.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayA.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
        this.tabPaddingTop = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        this.tabTextAppearance = typedArrayA.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.tabTextAppearance, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.tabTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayA.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.tabTextColors = com.google.android.material.i.c.a(context, typedArrayA, R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayA.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), typedArrayA.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.tabIconTint = com.google.android.material.i.c.a(context, typedArrayA, R.styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = v.a(typedArrayA.getInt(R.styleable.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.tabRippleColorStateList = com.google.android.material.i.c.a(context, typedArrayA, R.styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = typedArrayA.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.requestedTabMinWidth = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = typedArrayA.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = typedArrayA.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mode = typedArrayA.getInt(R.styleable.TabLayout_tabMode, 1);
            this.tabGravity = typedArrayA.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = typedArrayA.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = typedArrayA.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayA.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setupWithViewPager(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            g gVar = this.pageChangeListener;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            a aVar = this.adapterChangeListener;
            if (aVar != null) {
                this.viewPager.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.currentVpSelectedListener;
        if (bVar != null) {
            removeOnTabSelectedListener(bVar);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new g(this);
            }
            this.pageChangeListener.a();
            viewPager.addOnPageChangeListener(this.pageChangeListener);
            this.currentVpSelectedListener = new h(viewPager);
            addOnTabSelectedListener(this.currentVpSelectedListener);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new a();
            }
            this.adapterChangeListener.a(z);
            viewPager.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), WheelView.DividerConfig.FILL, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z2;
    }

    public void addTab(f fVar, boolean z) {
        addTab(fVar, this.tabs.size(), z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void addTab(f fVar, int i, boolean z) {
        if (fVar.h == this) {
            configureTab(fVar, i);
            addTabView(fVar);
            if (z) {
                fVar.h();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }
}
