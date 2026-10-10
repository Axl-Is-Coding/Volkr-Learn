package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: MenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends b implements Menu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.b.a.a f477d;

    public l(Context context, androidx.core.b.a.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f477d = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(this.f477d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f477d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(this.f477d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        b();
        this.f477d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f477d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return a(this.f477d.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return a(this.f477d.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f477d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f477d.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f477d.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f477d.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        a(i);
        this.f477d.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        b(i);
        this.f477d.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f477d.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f477d.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f477d.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f477d.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f477d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(this.f477d.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return a(this.f477d.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(this.f477d.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(this.f477d.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(this.f477d.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(this.f477d.addSubMenu(i, i2, i3, i4));
    }
}
