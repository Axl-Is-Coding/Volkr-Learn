package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f619f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private C0294g n;
    private int o;
    private int p;
    private Drawable q;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    private int l() {
        if (this.f614a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f614a.getNavigationIcon();
        return 15;
    }

    private void m() {
        if ((this.f615b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f614a.setNavigationContentDescription(this.p);
            } else {
                this.f614a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void n() {
        if ((this.f615b & 4) == 0) {
            this.f614a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f614a;
        Drawable drawable = this.g;
        if (drawable == null) {
            drawable = this.q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void o() {
        Drawable drawable;
        int i = this.f615b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f619f) == null) {
            drawable = this.f618e;
        }
        this.f614a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(boolean z) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean a() {
        return this.f614a.hasExpandedActionView();
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f615b & 8) != 0) {
            this.f614a.setSubtitle(charSequence);
        }
    }

    public void c(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.f614a.getNavigationContentDescription())) {
            d(this.p);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.f614a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f614a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean d() {
        return this.f618e != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup e() {
        return this.f614a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void g() {
        this.f614a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f614a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f614a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View h() {
        return this.f617d;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.f614a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean i() {
        return this.f619f != null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.f614a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.f614a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int j() {
        return this.f615b;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void k() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i) {
        setIcon(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.a aVar) {
        if (this.n == null) {
            this.n = new C0294g(this.f614a.getContext());
            this.n.a(R.id.action_menu_presenter);
        }
        this.n.setCallback(aVar);
        this.f614a.setMenu((MenuBuilder) menu, this.n);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.h = true;
        c(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i) {
        this.f614a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        c(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.f614a.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f614a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        ia iaVarA = ia.a(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.q = iaVarA.b(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceE = iaVarA.e(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceE)) {
                setTitle(charSequenceE);
            }
            CharSequence charSequenceE2 = iaVarA.e(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceE2)) {
                b(charSequenceE2);
            }
            Drawable drawableB = iaVarA.b(R.styleable.ActionBar_logo);
            if (drawableB != null) {
                a(drawableB);
            }
            Drawable drawableB2 = iaVarA.b(R.styleable.ActionBar_icon);
            if (drawableB2 != null) {
                setIcon(drawableB2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            a(iaVarA.d(R.styleable.ActionBar_displayOptions, 0));
            int iG = iaVarA.g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (iG != 0) {
                a(LayoutInflater.from(this.f614a.getContext()).inflate(iG, (ViewGroup) this.f614a, false));
                a(this.f615b | 16);
            }
            int iF = iaVarA.f(R.styleable.ActionBar_height, 0);
            if (iF > 0) {
                ViewGroup.LayoutParams layoutParams = this.f614a.getLayoutParams();
                layoutParams.height = iF;
                this.f614a.setLayoutParams(layoutParams);
            }
            int iB = iaVarA.b(R.styleable.ActionBar_contentInsetStart, -1);
            int iB2 = iaVarA.b(R.styleable.ActionBar_contentInsetEnd, -1);
            if (iB >= 0 || iB2 >= 0) {
                this.f614a.setContentInsetsRelative(Math.max(iB, 0), Math.max(iB2, 0));
            }
            int iG2 = iaVarA.g(R.styleable.ActionBar_titleTextStyle, 0);
            if (iG2 != 0) {
                Toolbar toolbar2 = this.f614a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iG2);
            }
            int iG3 = iaVarA.g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (iG3 != 0) {
                Toolbar toolbar3 = this.f614a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iG3);
            }
            int iG4 = iaVarA.g(R.styleable.ActionBar_popupTheme, 0);
            if (iG4 != 0) {
                this.f614a.setPopupTheme(iG4);
            }
        } else {
            this.f615b = l();
        }
        iaVarA.a();
        c(i);
        this.k = this.f614a.getNavigationContentDescription();
        this.f614a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final androidx.appcompat.view.menu.a f620a;

            {
                this.f620a = new androidx.appcompat.view.menu.a(ToolbarWidgetWrapper.this.f614a.getContext(), 0, android.R.id.home, 0, 0, ToolbarWidgetWrapper.this.i);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.l;
                if (callback == null || !toolbarWidgetWrapper.m) {
                    return;
                }
                callback.onMenuItemSelected(0, this.f620a);
            }
        });
    }

    public void a(Drawable drawable) {
        this.f619f = drawable;
        o();
    }

    public void d(int i) {
        a(i == 0 ? null : getContext().getString(i));
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f618e = drawable;
        o();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(int i) {
        View view;
        int i2 = this.f615b ^ i;
        this.f615b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m();
                }
                n();
            }
            if ((i2 & 3) != 0) {
                o();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f614a.setTitle(this.i);
                    this.f614a.setSubtitle(this.j);
                } else {
                    this.f614a.setTitle((CharSequence) null);
                    this.f614a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f617d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f614a.addView(view);
            } else {
                this.f614a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void b(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    private void c(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f615b & 8) != 0) {
            this.f614a.setTitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void b(boolean z) {
        this.f614a.setCollapsible(z);
    }

    public void b(Drawable drawable) {
        this.g = drawable;
        n();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void b(SparseArray<Parcelable> sparseArray) {
        this.f614a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int c() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu b() {
        return this.f614a.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f616c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f614a;
            if (parent == toolbar) {
                toolbar.removeView(this.f616c);
            }
        }
        this.f616c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.o != 2) {
            return;
        }
        this.f614a.addView(this.f616c, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f616c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.f196a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(View view) {
        View view2 = this.f617d;
        if (view2 != null && (this.f615b & 16) != 0) {
            this.f614a.removeView(view2);
        }
        this.f617d = view;
        if (view == null || (this.f615b & 16) == 0) {
            return;
        }
        this.f614a.addView(this.f617d);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public androidx.core.view.F a(int i, long j) {
        androidx.core.view.F fA = ViewCompat.a(this.f614a);
        fA.a(i == 0 ? 1.0f : WheelView.DividerConfig.FILL);
        fA.a(j);
        fA.a(new ma(this, i));
        return fA;
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        m();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(SparseArray<Parcelable> sparseArray) {
        this.f614a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void a(MenuPresenter.a aVar, MenuBuilder.a aVar2) {
        this.f614a.setMenuCallbacks(aVar, aVar2);
    }
}
