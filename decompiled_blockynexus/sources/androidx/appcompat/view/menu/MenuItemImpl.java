package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.k;
import androidx.core.view.AbstractC0314b;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemImpl implements androidx.core.b.a.b {
    private View A;
    private AbstractC0314b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f436f;
    private Intent g;
    private char h;
    private char j;
    private Drawable l;
    MenuBuilder n;
    private SubMenuBuilder o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;
    private int i = 4096;
    private int k = 4096;
    private int m = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.z = 0;
        this.n = menuBuilder;
        this.f431a = i2;
        this.f432b = i;
        this.f433c = i3;
        this.f434d = i4;
        this.f435e = charSequence;
        this.z = i5;
    }

    private static void a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    void b(boolean z) {
        int i = this.y;
        this.y = (z ? 2 : 0) | (i & (-3));
        if (i != this.y) {
            this.n.b(false);
        }
    }

    public int c() {
        return this.f434d;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    char d() {
        return this.n.p() ? this.j : this.h;
    }

    String e() {
        char cD = d();
        if (cD == 0) {
            return "";
        }
        Resources resources = this.n.e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i = this.n.p() ? this.k : this.i;
        a(sb, i, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        a(sb, i, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        a(sb, i, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        a(sb, i, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        a(sb, i, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        a(sb, i, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (cD == '\b') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (cD == '\n') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (cD != ' ') {
            sb.append(cD);
        } else {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!f()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.b(this);
        }
        return false;
    }

    public boolean f() {
        AbstractC0314b abstractC0314b;
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && (abstractC0314b = this.B) != null) {
            this.A = abstractC0314b.a(this);
        }
        return this.A != null;
    }

    public boolean g() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.n;
        if (menuBuilder.a(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.n.e().startActivity(this.g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        AbstractC0314b abstractC0314b = this.B;
        return abstractC0314b != null && abstractC0314b.d();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        AbstractC0314b abstractC0314b = this.B;
        if (abstractC0314b == null) {
            return null;
        }
        this.A = abstractC0314b.a(this);
        return this.A;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    Runnable getCallback() {
        return this.p;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f432b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.m == 0) {
            return null;
        }
        Drawable drawableB = androidx.appcompat.a.a.a.b(this.n.e(), this.m);
        this.m = 0;
        this.l = drawableB;
        return a(drawableB);
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f431a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f433c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f435e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f436f;
        if (charSequence == null) {
            charSequence = this.f435e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    public boolean h() {
        return (this.y & 32) == 32;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean i() {
        return (this.y & 4) != 0;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0314b abstractC0314b = this.B;
        return (abstractC0314b == null || !abstractC0314b.e()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        return (this.z & 1) == 1;
    }

    public boolean k() {
        return (this.z & 2) == 2;
    }

    public boolean l() {
        return this.n.k();
    }

    boolean m() {
        return this.n.q() && d() != 0;
    }

    public boolean n() {
        return (this.z & 4) == 4;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.j == c2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.n.b(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.p = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        this.y = (z ? 1 : 0) | (i & (-2));
        if (i != this.y) {
            this.n.b(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.h == c2) {
            return this;
        }
        this.h = c2;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.j = Character.toLowerCase(c3);
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i;
        this.n.c(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f435e = charSequence;
        this.n.b(false);
        SubMenuBuilder subMenuBuilder = this.o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f436f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f435e;
        }
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (e(z)) {
            this.n.d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f435e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void a(SubMenuBuilder subMenuBuilder) {
        this.o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    public void c(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public void d(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    @Override // android.view.MenuItem
    public androidx.core.b.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public androidx.core.b.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public androidx.core.b.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public androidx.core.b.a.b setActionView(View view) {
        int i;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i = this.f431a) > 0) {
            view.setId(i);
        }
        this.n.c(this);
        return this;
    }

    CharSequence a(k.a aVar) {
        if (aVar != null && aVar.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        if (this.j == c2 && this.k == i) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i);
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        if (this.h == c2 && this.i == i) {
            return this;
        }
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState(i);
        this.n.b(false);
        return this;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState(i);
        this.j = Character.toLowerCase(c3);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public void b() {
        this.n.c(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.l = null;
        this.m = i;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.n.e().getString(i));
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    @Override // androidx.core.b.a.b, android.view.MenuItem
    public androidx.core.b.a.b setActionView(int i) {
        Context contextE = this.n.e();
        setActionView(LayoutInflater.from(contextE).inflate(i, (ViewGroup) new LinearLayout(contextE), false));
        return this;
    }

    void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // androidx.core.b.a.b
    public AbstractC0314b a() {
        return this.B;
    }

    @Override // androidx.core.b.a.b
    public androidx.core.b.a.b a(AbstractC0314b abstractC0314b) {
        AbstractC0314b abstractC0314b2 = this.B;
        if (abstractC0314b2 != null) {
            abstractC0314b2.f();
        }
        this.A = null;
        this.B = abstractC0314b;
        this.n.b(true);
        AbstractC0314b abstractC0314b3 = this.B;
        if (abstractC0314b3 != null) {
            abstractC0314b3.a(new g(this));
        }
        return this;
    }

    public void a(boolean z) {
        this.D = z;
        this.n.b(false);
    }

    boolean e(boolean z) {
        int i = this.y;
        this.y = (z ? 0 : 8) | (i & (-9));
        return i != this.y;
    }
}
