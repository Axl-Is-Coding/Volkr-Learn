package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ToolbarActionBar extends ActionBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    DecorToolbar f256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Window.Callback f258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<ActionBar.a> f261f = new ArrayList<>();
    private final Runnable g = new A(this);
    private final Toolbar.a h = new B(this);

    private final class b implements MenuBuilder.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public void a(MenuBuilder menuBuilder) {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f258c != null) {
                if (toolbarActionBar.f256a.isOverflowMenuShowing()) {
                    ToolbarActionBar.this.f258c.onPanelClosed(108, menuBuilder);
                } else if (ToolbarActionBar.this.f258c.onPreparePanel(0, null, menuBuilder)) {
                    ToolbarActionBar.this.f258c.onMenuOpened(108, menuBuilder);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.a
        public boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }
    }

    private class c extends androidx.appcompat.d.j {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(ToolbarActionBar.this.f256a.getContext()) : super.onCreatePanelView(i);
        }

        @Override // androidx.appcompat.d.j, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (zOnPreparePanel) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.f257b) {
                    toolbarActionBar.f256a.setMenuPrepared();
                    ToolbarActionBar.this.f257b = true;
                }
            }
            return zOnPreparePanel;
        }
    }

    ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f256a = new ToolbarWidgetWrapper(toolbar, false);
        this.f258c = new c(callback);
        this.f256a.setWindowCallback(this.f258c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f256a.setWindowTitle(charSequence);
    }

    private Menu n() {
        if (!this.f259d) {
            this.f256a.a(new a(), new b());
            this.f259d = true;
        }
        return this.f256a.b();
    }

    public void a(View view) {
        a(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(CharSequence charSequence) {
        this.f256a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c(boolean z) {
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

    public Window.Callback getWrappedWindowCallback() {
        return this.f258c;
    }

    @Override // androidx.appcompat.app.ActionBar
    public int h() {
        return this.f256a.j();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context i() {
        return this.f256a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean j() {
        this.f256a.e().removeCallbacks(this.g);
        ViewCompat.a(this.f256a.e(), this.g);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    void k() {
        this.f256a.e().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean l() {
        return this.f256a.showOverflowMenu();
    }

    void m() {
        Menu menuN = n();
        MenuBuilder menuBuilder = menuN instanceof MenuBuilder ? (MenuBuilder) menuN : null;
        if (menuBuilder != null) {
            menuBuilder.s();
        }
        try {
            menuN.clear();
            if (!this.f258c.onCreatePanelMenu(0, menuN) || !this.f258c.onPreparePanel(0, null, menuN)) {
                menuN.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.r();
            }
        }
    }

    private final class a implements MenuPresenter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f262a;

        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public boolean a(MenuBuilder menuBuilder) {
            Window.Callback callback = ToolbarActionBar.this.f258c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.a
        public void a(MenuBuilder menuBuilder, boolean z) {
            if (this.f262a) {
                return;
            }
            this.f262a = true;
            ToolbarActionBar.this.f256a.g();
            Window.Callback callback = ToolbarActionBar.this.f258c;
            if (callback != null) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.f262a = false;
        }
    }

    public void a(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f256a.a(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b(boolean z) {
        if (z == this.f260e) {
            return;
        }
        this.f260e = z;
        int size = this.f261f.size();
        for (int i = 0; i < size; i++) {
            this.f261f.get(i).onMenuVisibilityChanged(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean e() {
        return this.f256a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean f() {
        if (!this.f256a.a()) {
            return false;
        }
        this.f256a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View g() {
        return this.f256a.h();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(int i) {
        a(LayoutInflater.from(this.f256a.getContext()).inflate(i, this.f256a.e(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(float f2) {
        ViewCompat.a(this.f256a.e(), f2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a(CharSequence charSequence) {
        this.f256a.setTitle(charSequence);
    }

    public void a(int i, int i2) {
        this.f256a.a((i & i2) | ((i2 ^ (-1)) & this.f256a.j()));
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            l();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuN = n();
        if (menuN == null) {
            return false;
        }
        menuN.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuN.performShortcut(i, keyEvent, 0);
    }
}
