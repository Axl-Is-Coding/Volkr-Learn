package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.A;
import androidx.core.view.AbstractC0314b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuBuilder implements androidx.core.b.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f421a = {1, 4, 5, 3, 2, 0};
    private boolean A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resources f423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f426f;
    private ContextMenu.ContextMenuInfo n;
    CharSequence o;
    Drawable p;
    View q;
    private MenuItemImpl y;
    private int m = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<MenuItemImpl> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> x = new CopyOnWriteArrayList<>();
    private boolean z = false;
    private ArrayList<MenuItemImpl> g = new ArrayList<>();
    private ArrayList<MenuItemImpl> h = new ArrayList<>();
    private boolean i = true;
    private ArrayList<MenuItemImpl> j = new ArrayList<>();
    private ArrayList<MenuItemImpl> k = new ArrayList<>();
    private boolean l = true;

    public interface a {
        void a(MenuBuilder menuBuilder);

        boolean a(MenuBuilder menuBuilder, MenuItem menuItem);
    }

    public interface b {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f422b = context;
        this.f423c = context.getResources();
        e(true);
    }

    private void d(boolean z) {
        if (this.x.isEmpty()) {
            return;
        }
        s();
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter = weakReference.get();
            if (menuPresenter == null) {
                this.x.remove(weakReference);
            } else {
                menuPresenter.a(z);
            }
        }
        r();
    }

    private void e(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.x.isEmpty()) {
            return;
        }
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter = weakReference.get();
            if (menuPresenter == null) {
                this.x.remove(weakReference);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    menuPresenter.a(parcelable);
                }
            }
        }
    }

    private void f(Bundle bundle) {
        Parcelable parcelableA;
        if (this.x.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter = weakReference.get();
            if (menuPresenter == null) {
                this.x.remove(weakReference);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelableA = menuPresenter.a()) != null) {
                    sparseArray.put(id, parcelableA);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public void a(MenuPresenter menuPresenter) {
        a(menuPresenter, this.f422b);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f422b.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(MenuPresenter menuPresenter) {
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter2 = weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.x.remove(weakReference);
            }
        }
    }

    public MenuBuilder c(int i) {
        this.m = i;
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.y;
        if (menuItemImpl != null) {
            a(menuItemImpl);
        }
        this.g.clear();
        b(true);
    }

    public void clearHeader() {
        this.p = null;
        this.o = null;
        this.q = null;
        b(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    protected String d() {
        return "android:menu:actionviewstates";
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.g.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (menuItemFindItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public Drawable g() {
        return this.p;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.g.get(i);
    }

    public CharSequence h() {
        return this.o;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.g.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public View i() {
        return this.q;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public ArrayList<MenuItemImpl> j() {
        b();
        return this.k;
    }

    boolean k() {
        return this.u;
    }

    Resources l() {
        return this.f423c;
    }

    public MenuBuilder m() {
        return this;
    }

    public ArrayList<MenuItemImpl> n() {
        if (!this.i) {
            return this.h;
        }
        this.h.clear();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.g.get(i);
            if (menuItemImpl.isVisible()) {
                this.h.add(menuItemImpl);
            }
        }
        this.i = false;
        this.l = true;
        return this.h;
    }

    public boolean o() {
        return this.z;
    }

    boolean p() {
        return this.f424d;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl menuItemImplA = a(i, keyEvent);
        boolean zA = menuItemImplA != null ? a(menuItemImplA, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return zA;
    }

    public boolean q() {
        return this.f425e;
    }

    public void r() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iA = a(i);
        if (iA >= 0) {
            int size = this.g.size() - iA;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.g.get(iA).getGroupId() != i) {
                    break;
                }
                a(iA, false);
                i2 = i3;
            }
            b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(b(i), true);
    }

    public void s() {
        if (this.r) {
            return;
        }
        this.r = true;
        this.s = false;
        this.t = false;
    }

    public void setCallback(a aVar) {
        this.f426f = aVar;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.g.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.c(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.z = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.g.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.g.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.g.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f424d = z;
        b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.g.size();
    }

    public void a(MenuPresenter menuPresenter, Context context) {
        this.x.add(new WeakReference<>(menuPresenter));
        menuPresenter.a(context, this);
        this.l = true;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f423c.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f423c.getString(i));
    }

    public void c(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f422b, this, menuItemImpl);
        menuItemImpl.a(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f423c.getString(i4));
    }

    public void b(Bundle bundle) {
        e(bundle);
    }

    private boolean a(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean zA = menuPresenter != null ? menuPresenter.a(subMenuBuilder) : false;
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter2 = weakReference.get();
            if (menuPresenter2 == null) {
                this.x.remove(weakReference);
            } else if (!zA) {
                zA = menuPresenter2.a(subMenuBuilder);
            }
        }
        return zA;
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f423c.getString(i4));
    }

    public void b(boolean z) {
        if (!this.r) {
            if (z) {
                this.i = true;
                this.l = true;
            }
            d(z);
            return;
        }
        this.s = true;
        if (z) {
            this.t = true;
        }
    }

    public void d(Bundle bundle) {
        f(bundle);
    }

    private void e(boolean z) {
        this.f425e = z && this.f423c.getConfiguration().keyboard != 1 && A.c(ViewConfiguration.get(this.f422b), this.f422b);
    }

    void d(MenuItemImpl menuItemImpl) {
        this.i = true;
        b(true);
    }

    private static int f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f421a;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void a(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(d());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).a(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    protected MenuBuilder d(int i) {
        a(0, null, i, null, null);
        return this;
    }

    public Context e() {
        return this.f422b;
    }

    public MenuItemImpl f() {
        return this.y;
    }

    public void b() {
        ArrayList<MenuItemImpl> arrayListN = n();
        if (this.l) {
            boolean zB = false;
            for (WeakReference<MenuPresenter> weakReference : this.x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                } else {
                    zB |= menuPresenter.b();
                }
            }
            if (zB) {
                this.j.clear();
                this.k.clear();
                int size = arrayListN.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = arrayListN.get(i);
                    if (menuItemImpl.h()) {
                        this.j.add(menuItemImpl);
                    } else {
                        this.k.add(menuItemImpl);
                    }
                }
            } else {
                this.j.clear();
                this.k.clear();
                this.k.addAll(n());
            }
            this.l = false;
        }
    }

    void c(MenuItemImpl menuItemImpl) {
        this.l = true;
        b(true);
    }

    protected MenuBuilder e(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public ArrayList<MenuItemImpl> c() {
        b();
        return this.j;
    }

    public void c(boolean z) {
        this.A = z;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iF = f(i3);
        MenuItemImpl menuItemImplA = a(i, i2, i3, iF, charSequence, this.m);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.n;
        if (contextMenuInfo != null) {
            menuItemImplA.a(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.g;
        arrayList.add(a(arrayList, iF), menuItemImplA);
        b(true);
        return menuItemImplA;
    }

    private MenuItemImpl a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, boolean z) {
        if (i < 0 || i >= this.g.size()) {
            return;
        }
        this.g.remove(i);
        if (z) {
            b(true);
        }
    }

    public boolean b(MenuItemImpl menuItemImpl) {
        boolean zA = false;
        if (this.x.isEmpty()) {
            return false;
        }
        s();
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter = weakReference.get();
            if (menuPresenter == null) {
                this.x.remove(weakReference);
            } else {
                zA = menuPresenter.a(this, menuItemImpl);
                if (zA) {
                    break;
                }
            }
        }
        r();
        if (zA) {
            this.y = menuItemImpl;
        }
        return zA;
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.g.size();
        s();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.g.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.i() && menuItemImpl.isCheckable()) {
                menuItemImpl.b(menuItemImpl == menuItem);
            }
        }
        r();
    }

    public int a(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.g.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        a aVar = this.f426f;
        return aVar != null && aVar.a(menuBuilder, menuItem);
    }

    public void a() {
        a aVar = this.f426f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private static int a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    void a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean zP = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.g.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = zP ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & 69647) == ((zP ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zP && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    MenuItemImpl a(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<MenuItemImpl> arrayList = this.w;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zP = p();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            if (zP) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zP && numericShortcut == '\b' && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (MenuPresenter) null, i);
    }

    public boolean a(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean zG = menuItemImpl.g();
        AbstractC0314b abstractC0314bA = menuItemImpl.a();
        boolean z = abstractC0314bA != null && abstractC0314bA.a();
        if (menuItemImpl.f()) {
            zG |= menuItemImpl.expandActionView();
            if (zG) {
                a(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                a(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.a(new SubMenuBuilder(e(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                abstractC0314bA.a(subMenuBuilder);
            }
            zG |= a(subMenuBuilder, menuPresenter);
            if (!zG) {
                a(true);
            }
        } else if ((i & 1) == 0) {
            a(true);
        }
        return zG;
    }

    public final void a(boolean z) {
        if (this.v) {
            return;
        }
        this.v = true;
        for (WeakReference<MenuPresenter> weakReference : this.x) {
            MenuPresenter menuPresenter = weakReference.get();
            if (menuPresenter == null) {
                this.x.remove(weakReference);
            } else {
                menuPresenter.a(this, z);
            }
        }
        this.v = false;
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesL = l();
        if (view != null) {
            this.q = view;
            this.o = null;
            this.p = null;
        } else {
            if (i > 0) {
                this.o = resourcesL.getText(i);
            } else if (charSequence != null) {
                this.o = charSequence;
            }
            if (i2 > 0) {
                this.p = androidx.core.content.b.c(e(), i2);
            } else if (drawable != null) {
                this.p = drawable;
            }
            this.q = null;
        }
        b(false);
    }

    protected MenuBuilder a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuBuilder a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public boolean a(MenuItemImpl menuItemImpl) {
        boolean zB = false;
        if (!this.x.isEmpty() && this.y == menuItemImpl) {
            s();
            for (WeakReference<MenuPresenter> weakReference : this.x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.x.remove(weakReference);
                } else {
                    zB = menuPresenter.b(this, menuItemImpl);
                    if (zB) {
                        break;
                    }
                }
            }
            r();
            if (zB) {
                this.y = null;
            }
        }
        return zB;
    }
}
