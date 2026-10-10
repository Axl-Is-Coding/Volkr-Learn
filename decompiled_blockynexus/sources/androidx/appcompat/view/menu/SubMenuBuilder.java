package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

/* JADX INFO: loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder B;
    private MenuItemImpl C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.B = menuBuilder;
        this.C = menuItemImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.a(menuBuilder, menuItem) || this.B.a(menuBuilder, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean b(MenuItemImpl menuItemImpl) {
        return this.B.b(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String d() {
        MenuItemImpl menuItemImpl = this.C;
        int itemId = menuItemImpl != null ? menuItemImpl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder m() {
        return this.B.m();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean o() {
        return this.B.o();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean p() {
        return this.B.p();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean q() {
        return this.B.q();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.a aVar) {
        this.B.setCallback(aVar);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.d(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.e(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean a(MenuItemImpl menuItemImpl) {
        return this.B.a(menuItemImpl);
    }
}
