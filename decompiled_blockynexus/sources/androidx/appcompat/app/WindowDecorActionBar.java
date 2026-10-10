package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.I;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Interpolator f266a = new AccelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Interpolator f267b = new DecelerateInterpolator();
    private boolean A;
    androidx.appcompat.d.i C;
    private boolean D;
    boolean E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Dialog f271f;
    ActionBarOverlayLayout g;
    ActionBarContainer h;
    DecorToolbar i;
    ActionBarContextView j;
    View k;
    ScrollingTabContainerView l;
    private TabImpl n;
    private boolean p;
    a q;
    androidx.appcompat.d.b r;
    b.a s;
    private boolean t;
    private boolean v;
    boolean y;
    boolean z;
    private ArrayList<TabImpl> m = new ArrayList<>();
    private int o = -1;
    private ArrayList<ActionBar.a> u = new ArrayList<>();
    private int w = 0;
    boolean x = true;
    private boolean B = true;
    final androidx.core.view.G F = new E(this);
    final androidx.core.view.G G = new F(this);
    final I H = new G(this);

    public class TabImpl extends ActionBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ActionBar.c f272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Drawable f273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f277f;
        final /* synthetic */ WindowDecorActionBar g;

        @Override // androidx.appcompat.app.ActionBar.b
        public CharSequence a() {
            return this.f275d;
        }

        @Override // androidx.appcompat.app.ActionBar.b
        public View b() {
            return this.f277f;
        }

        @Override // androidx.appcompat.app.ActionBar.b
        public Drawable c() {
            return this.f273b;
        }

        @Override // androidx.appcompat.app.ActionBar.b
        public int d() {
            return this.f276e;
        }

        @Override // androidx.appcompat.app.ActionBar.b
        public CharSequence e() {
            return this.f274c;
        }

        @Override // androidx.appcompat.app.ActionBar.b
        public void f() {
            this.g.a(this);
        }

        public ActionBar.c getCallback() {
            return this.f272a;
        }
    }

    public class a extends androidx.appcompat.d.b implements MenuBuilder.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MenuBuilder f279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b.a f280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference<View> f281f;

        public a(Context context, b.a aVar) {
            this.f278c = context;
            this.f280e = aVar;
            this.f279d = new MenuBuilder(context).c(1);
            this.f279d.setCallback(this);
        }

        @Override // androidx.appcompat.d.b
        public void a() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.q != this) {
                return;
            }
            if (WindowDecorActionBar.a(windowDecorActionBar.y, windowDecorActionBar.z, false)) {
                this.f280e.a(this);
            } else {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.r = this;
                windowDecorActionBar2.s = this.f280e;
            }
            this.f280e = null;
            WindowDecorActionBar.this.i(false);
            WindowDecorActionBar.this.j.closeMode();
            WindowDecorActionBar.this.i.e().sendAccessibilityEvent(32);
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.g.setHideOnContentScrollEnabled(windowDecorActionBar3.E);
            WindowDecorActionBar.this.q = null;
        }

        @Override // androidx.appcompat.d.b
        public void b(CharSequence charSequence) {
            WindowDecorActionBar.this.j.setTitle(charSequence);
        }

        @Override // androidx.appcompat.d.b
        public Menu c() {
            return this.f279d;
        }

        @Override // androidx.appcompat.d.b
        public MenuInflater d() {
            return new androidx.appcompat.d.g(this.f278c);
        }

        @Override // androidx.appcompat.d.b
        public CharSequence e() {
            return WindowDecorActionBar.this.j.getSubtitle();
        }

        @Override // androidx.appcompat.d.b
        public CharSequence g() {
            return WindowDecorActionBar.this.j.getTitle();
        }

        @Override // androidx.appcompat.d.b
        public void i() {
            if (WindowDecorActionBar.this.q != this) {
                return;
            }
            this.f279d.s();
            try {
                this.f280e.b(this, this.f279d);
            } finally {
                this.f279d.r();
            }
        }

        @Override // androidx.appcompat.d.b
        public boolean j() {
            return WindowDecorActionBar.this.j.isTitleOptional();
        }

        public boolean k() {
            this.f279d.s();
            try {
                return this.f280e.a(this, this.f279d);
            } finally {
                this.f279d.r();
            }
        }

        @Override // androidx.appcompat.d.b
        public void b(int i) {
            b(WindowDecorActionBar.this.f268c.getResources().getString(i));
        }

        @Override // androidx.appcompat.d.b
        public View b() {
            WeakReference<View> weakReference = this.f281f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.d.b
        public void a(View view) {
            WindowDecorActionBar.this.j.setCustomView(view);
            this.f281f = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.d.b
        public void a(CharSequence charSequence) {
            WindowDecorActionBar.this.j.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.d.b
        public void a(int i) {
            a((CharSequence) WindowDecorActionBar.this.f268c.getResources().getString(i));
        }

        @Override // androidx.appcompat.d.b
        public void a(boolean z) {
            super.a(z);
            WindowDecorActionBar.this.j.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            b.a aVar = this.f280e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public void a(MenuBuilder menuBuilder) {
            if (this.f280e == null) {
                return;
            }
            i();
            WindowDecorActionBar.this.j.showOverflowMenu();
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f270e = activity;
        View decorView = activity.getWindow().getDecorView();
        c(decorView);
        if (z) {
            return;
        }
        this.k = decorView.findViewById(R.id.content);
    }

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar b(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void c(View view) {
        this.g = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.i = b(view.findViewById(androidx.appcompat.R.id.action_bar));
        this.j = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        this.h = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        DecorToolbar decorToolbar = this.i;
        if (decorToolbar == null || this.j == null || this.h == null) {
            throw new IllegalStateException(WindowDecorActionBar.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f268c = decorToolbar.getContext();
        boolean z = (this.i.j() & 4) != 0;
        if (z) {
            this.p = true;
        }
        androidx.appcompat.d.a aVarA = androidx.appcompat.d.a.a(this.f268c);
        m(aVarA.a() || z);
        n(aVarA.f());
        TypedArray typedArrayObtainStyledAttributes = this.f268c.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            l(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void n(boolean z) {
        this.v = z;
        if (this.v) {
            this.h.setTabContainer(null);
            this.i.a(this.l);
        } else {
            this.i.a((ScrollingTabContainerView) null);
            this.h.setTabContainer(this.l);
        }
        boolean z2 = n() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.l;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.g;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.H(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.i.b(!this.v && z2);
        this.g.setHasNonEmbeddedTabs(!this.v && z2);
    }

    private void o() {
        if (this.A) {
            this.A = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            o(false);
        }
    }

    private boolean p() {
        return ViewCompat.C(this.h);
    }

    private void q() {
        if (this.A) {
            return;
        }
        this.A = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        o(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(float f2) {
        ViewCompat.a(this.h, f2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void b() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void d(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void e(boolean z) {
        a(z ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void f(boolean z) {
        a(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void g(boolean z) {
        a(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h(boolean z) {
        androidx.appcompat.d.i iVar;
        this.D = z;
        if (z || (iVar = this.C) == null) {
            return;
        }
        iVar.a();
    }

    public void i(boolean z) {
        androidx.core.view.F fA;
        androidx.core.view.F fA2;
        if (z) {
            q();
        } else {
            o();
        }
        if (!p()) {
            if (z) {
                this.i.setVisibility(4);
                this.j.setVisibility(0);
                return;
            } else {
                this.i.setVisibility(0);
                this.j.setVisibility(8);
                return;
            }
        }
        if (z) {
            fA2 = this.i.a(4, 100L);
            fA = this.j.setupAnimatorToVisibility(0, 200L);
        } else {
            fA = this.i.a(0, 200L);
            fA2 = this.j.setupAnimatorToVisibility(8, 100L);
        }
        androidx.appcompat.d.i iVar = new androidx.appcompat.d.i();
        iVar.a(fA2, fA);
        iVar.c();
    }

    public void j(boolean z) {
        View view;
        androidx.appcompat.d.i iVar = this.C;
        if (iVar != null) {
            iVar.a();
        }
        if (this.w != 0 || (!this.D && !z)) {
            this.F.b(null);
            return;
        }
        this.h.setAlpha(1.0f);
        this.h.setTransitioning(true);
        androidx.appcompat.d.i iVar2 = new androidx.appcompat.d.i();
        float f2 = -this.h.getHeight();
        if (z) {
            this.h.getLocationInWindow(new int[]{0, 0});
            f2 -= r5[1];
        }
        androidx.core.view.F fA = ViewCompat.a(this.h);
        fA.b(f2);
        fA.a(this.H);
        iVar2.a(fA);
        if (this.x && (view = this.k) != null) {
            androidx.core.view.F fA2 = ViewCompat.a(view);
            fA2.b(f2);
            iVar2.a(fA2);
        }
        iVar2.a(f266a);
        iVar2.a(250L);
        iVar2.a(this.F);
        this.C = iVar2;
        iVar2.c();
    }

    public void k(boolean z) {
        View view;
        View view2;
        androidx.appcompat.d.i iVar = this.C;
        if (iVar != null) {
            iVar.a();
        }
        this.h.setVisibility(0);
        if (this.w == 0 && (this.D || z)) {
            this.h.setTranslationY(WheelView.DividerConfig.FILL);
            float f2 = -this.h.getHeight();
            if (z) {
                this.h.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.h.setTranslationY(f2);
            androidx.appcompat.d.i iVar2 = new androidx.appcompat.d.i();
            androidx.core.view.F fA = ViewCompat.a(this.h);
            fA.b(WheelView.DividerConfig.FILL);
            fA.a(this.H);
            iVar2.a(fA);
            if (this.x && (view2 = this.k) != null) {
                view2.setTranslationY(f2);
                androidx.core.view.F fA2 = ViewCompat.a(this.k);
                fA2.b(WheelView.DividerConfig.FILL);
                iVar2.a(fA2);
            }
            iVar2.a(f267b);
            iVar2.a(250L);
            iVar2.a(this.G);
            this.C = iVar2;
            iVar2.c();
        } else {
            this.h.setAlpha(1.0f);
            this.h.setTranslationY(WheelView.DividerConfig.FILL);
            if (this.x && (view = this.k) != null) {
                view.setTranslationY(WheelView.DividerConfig.FILL);
            }
            this.G.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            ViewCompat.H(actionBarOverlayLayout);
        }
    }

    public void l(boolean z) {
        if (z && !this.g.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.E = z;
        this.g.setHideOnContentScrollEnabled(z);
    }

    void m() {
        b.a aVar = this.s;
        if (aVar != null) {
            aVar.a(this.r);
            this.r = null;
            this.s = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void onWindowVisibilityChanged(int i) {
        this.w = i;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration configuration) {
        n(androidx.appcompat.d.a.a(this.f268c).f());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void d() {
        androidx.appcompat.d.i iVar = this.C;
        if (iVar != null) {
            iVar.a();
            this.C = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean f() {
        DecorToolbar decorToolbar = this.i;
        if (decorToolbar == null || !decorToolbar.a()) {
            return false;
        }
        this.i.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View g() {
        return this.i.h();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(int i) {
        a(LayoutInflater.from(i()).inflate(i, this.i.e(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public int h() {
        return this.i.j();
    }

    public void m(boolean z) {
        this.i.a(z);
    }

    private void o(boolean z) {
        if (a(this.y, this.z, this.A)) {
            if (this.B) {
                return;
            }
            this.B = true;
            k(z);
            return;
        }
        if (this.B) {
            this.B = false;
            j(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    public void a(int i, int i2) {
        int iJ = this.i.j();
        if ((i2 & 4) != 0) {
            this.p = true;
        }
        this.i.a((i & i2) | ((i2 ^ (-1)) & iJ));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(boolean z) {
        if (z == this.t) {
            return;
        }
        this.t = z;
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            this.u.get(i).onMenuVisibilityChanged(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public androidx.appcompat.d.b a(b.a aVar) {
        a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.g.setHideOnContentScrollEnabled(false);
        this.j.killMode();
        a aVar3 = new a(this.j.getContext(), aVar);
        if (!aVar3.k()) {
            return null;
        }
        this.q = aVar3;
        aVar3.i();
        this.j.initForMode(aVar3);
        i(true);
        this.j.sendAccessibilityEvent(32);
        return aVar3;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(CharSequence charSequence) {
        this.i.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context i() {
        if (this.f269d == null) {
            TypedValue typedValue = new TypedValue();
            this.f268c.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f269d = new ContextThemeWrapper(this.f268c, i);
            } else {
                this.f269d = this.f268c;
            }
        }
        return this.f269d;
    }

    public int n() {
        return this.i.c();
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f271f = dialog;
        c(dialog.getWindow().getDecorView());
    }

    public void a(ActionBar.b bVar) {
        androidx.fragment.app.F fA;
        if (n() != 2) {
            this.o = bVar != null ? bVar.d() : -1;
            return;
        }
        if (!(this.f270e instanceof FragmentActivity) || this.i.e().isInEditMode()) {
            fA = null;
        } else {
            fA = ((FragmentActivity) this.f270e).getSupportFragmentManager().a();
            fA.e();
        }
        TabImpl tabImpl = this.n;
        if (tabImpl != bVar) {
            this.l.setTabSelected(bVar != null ? bVar.d() : -1);
            TabImpl tabImpl2 = this.n;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().b(this.n, fA);
            }
            this.n = (TabImpl) bVar;
            TabImpl tabImpl3 = this.n;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().a(this.n, fA);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().c(this.n, fA);
            this.l.animateToTab(bVar.d());
        }
        if (fA == null || fA.f()) {
            return;
        }
        fA.a();
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void c() {
        if (this.z) {
            return;
        }
        this.z = true;
        o(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean z) {
        if (this.p) {
            return;
        }
        d(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void a(boolean z) {
        this.x = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void a() {
        if (this.z) {
            this.z = false;
            o(true);
        }
    }

    public void a(View view) {
        this.i.a(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuC;
        a aVar = this.q;
        if (aVar == null || (menuC = aVar.c()) == null) {
            return false;
        }
        menuC.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuC.performShortcut(i, keyEvent, 0);
    }
}
