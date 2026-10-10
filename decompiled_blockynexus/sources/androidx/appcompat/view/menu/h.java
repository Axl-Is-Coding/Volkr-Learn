package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.AbstractC0314b;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuItemWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.appcompat.view.menu.b implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.b.a.b f465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f466e;

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class a extends AbstractC0314b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ActionProvider f467d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f467d = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0314b
        public boolean a() {
            return this.f467d.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0314b
        public View c() {
            return this.f467d.onCreateActionView();
        }

        @Override // androidx.core.view.AbstractC0314b
        public boolean d() {
            return this.f467d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0314b
        public void a(SubMenu subMenu) {
            this.f467d.onPrepareSubMenu(h.this.a(subMenu));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private AbstractC0314b.InterfaceC0017b f469f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.AbstractC0314b
        public View a(MenuItem menuItem) {
            return this.f467d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0314b
        public boolean b() {
            return this.f467d.isVisible();
        }

        @Override // androidx.core.view.AbstractC0314b
        public boolean e() {
            return this.f467d.overridesItemVisibility();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            AbstractC0314b.InterfaceC0017b interfaceC0017b = this.f469f;
            if (interfaceC0017b != null) {
                interfaceC0017b.onActionProviderVisibilityChanged(z);
            }
        }

        @Override // androidx.core.view.AbstractC0314b
        public void a(AbstractC0314b.InterfaceC0017b interfaceC0017b) {
            this.f469f = interfaceC0017b;
            this.f467d.setVisibilityListener(interfaceC0017b != null ? this : null);
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    static class c extends FrameLayout implements androidx.appcompat.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f470a;

        /* JADX WARN: Multi-variable type inference failed */
        c(View view) {
            super(view.getContext());
            this.f470a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f470a;
        }

        @Override // androidx.appcompat.d.c
        public void onActionViewCollapsed() {
            this.f470a.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.d.c
        public void onActionViewExpanded() {
            this.f470a.onActionViewExpanded();
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f471a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f471a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f471a.onMenuItemActionCollapse(h.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f471a.onMenuItemActionExpand(h.this.a(menuItem));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f473a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f473a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f473a.onMenuItemClick(h.this.a(menuItem));
        }
    }

    public h(Context context, androidx.core.b.a.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f465d = bVar;
    }

    public void a(boolean z) {
        try {
            if (this.f466e == null) {
                this.f466e = this.f465d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f466e.invoke(this.f465d, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f465d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f465d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0314b abstractC0314bA = this.f465d.a();
        if (abstractC0314bA instanceof a) {
            return ((a) abstractC0314bA).f467d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f465d.getActionView();
        return actionView instanceof c ? ((c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f465d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f465d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f465d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f465d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f465d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f465d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f465d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f465d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f465d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f465d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f465d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f465d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f465d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(this.f465d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f465d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f465d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f465d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f465d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f465d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f465d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f465d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f465d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f465d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        AbstractC0314b bVar = Build.VERSION.SDK_INT >= 16 ? new b(this.f454a, actionProvider) : new a(this.f454a, actionProvider);
        androidx.core.b.a.b bVar2 = this.f465d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f465d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f465d.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f465d.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f465d.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f465d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f465d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f465d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f465d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f465d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f465d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f465d.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f465d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f465d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f465d.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f465d.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f465d.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f465d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f465d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f465d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f465d.setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f465d.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f465d.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.f465d.setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f465d.setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f465d.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f465d.setActionView(i);
        View actionView = this.f465d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f465d.setActionView(new c(actionView));
        }
        return this;
    }
}
