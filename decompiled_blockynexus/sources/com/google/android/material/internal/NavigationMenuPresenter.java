package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.W;
import com.google.android.material.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationMenuPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NavigationMenuView f13438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LinearLayout f13439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MenuPresenter.a f13440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    MenuBuilder f13441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    b f13443f;
    LayoutInflater g;
    int h;
    boolean i;
    ColorStateList j;
    ColorStateList k;
    Drawable l;
    int m;
    int n;
    int o;
    boolean p;
    private int r;
    private int s;
    int t;
    boolean q = true;
    private int u = -1;
    final View.OnClickListener v = new View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            NavigationMenuPresenter.this.c(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean zA = navigationMenuPresenter.f13441d.a(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && zA) {
                NavigationMenuPresenter.this.f13443f.a(itemData);
            } else {
                z = false;
            }
            NavigationMenuPresenter.this.c(false);
            if (z) {
                NavigationMenuPresenter.this.a(false);
            }
        }
    };

    private static class a extends k {
        public a(View view) {
            super(view);
        }
    }

    private class b extends RecyclerView.a<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<d> f13445a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MenuItemImpl f13446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13447c;

        b() {
            f();
        }

        private void f() {
            if (this.f13447c) {
                return;
            }
            this.f13447c = true;
            this.f13445a.clear();
            this.f13445a.add(new c());
            int size = NavigationMenuPresenter.this.f13441d.n().size();
            int i = -1;
            boolean z = false;
            int size2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.f13441d.n().get(i2);
                if (menuItemImpl.isChecked()) {
                    a(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.c(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.f13445a.add(new e(NavigationMenuPresenter.this.t, 0));
                        }
                        this.f13445a.add(new f(menuItemImpl));
                        int size3 = this.f13445a.size();
                        int size4 = subMenu.size();
                        boolean z2 = false;
                        for (int i3 = 0; i3 < size4; i3++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i3);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.c(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    a(menuItemImpl);
                                }
                                this.f13445a.add(new f(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            a(size3, this.f13445a.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i) {
                        size2 = this.f13445a.size();
                        boolean z3 = menuItemImpl.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            ArrayList<d> arrayList = this.f13445a;
                            int i4 = NavigationMenuPresenter.this.t;
                            arrayList.add(new e(i4, i4));
                        }
                        z = z3;
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        a(size2, this.f13445a.size());
                        z = true;
                    }
                    f fVar = new f(menuItemImpl);
                    fVar.f13452b = z;
                    this.f13445a.add(fVar);
                    i = groupId;
                }
            }
            this.f13447c = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(k kVar, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) kVar.itemView).setText(((f) this.f13445a.get(i)).a().getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    e eVar = (e) this.f13445a.get(i);
                    kVar.itemView.setPadding(0, eVar.b(), 0, eVar.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) kVar.itemView;
            navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.k);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (navigationMenuPresenter.i) {
                navigationMenuItemView.setTextAppearance(navigationMenuPresenter.h);
            }
            ColorStateList colorStateList = NavigationMenuPresenter.this.j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = NavigationMenuPresenter.this.l;
            ViewCompat.a(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            f fVar = (f) this.f13445a.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(fVar.f13452b);
            navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.m);
            navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.n);
            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.p) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.o);
            }
            navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.r);
            navigationMenuItemView.initialize(fVar.a(), 0);
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f13446b;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f13445a.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.f13445a.get(i);
                if (dVar instanceof f) {
                    MenuItemImpl menuItemImplA = ((f) dVar).a();
                    View actionView = menuItemImplA != null ? menuItemImplA.getActionView() : null;
                    if (actionView != null) {
                        com.google.android.material.internal.k kVar = new com.google.android.material.internal.k();
                        actionView.saveHierarchyState(kVar);
                        sparseArray.put(menuItemImplA.getItemId(), kVar);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public MenuItemImpl c() {
            return this.f13446b;
        }

        int d() {
            int i = NavigationMenuPresenter.this.f13439b.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < NavigationMenuPresenter.this.f13443f.getItemCount(); i2++) {
                if (NavigationMenuPresenter.this.f13443f.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            return i;
        }

        public void e() {
            f();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int getItemCount() {
            return this.f13445a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int getItemViewType(int i) {
            d dVar = this.f13445a.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public k onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new h(navigationMenuPresenter.g, viewGroup, navigationMenuPresenter.v);
            }
            if (i == 1) {
                return new j(NavigationMenuPresenter.this.g, viewGroup);
            }
            if (i == 2) {
                return new i(NavigationMenuPresenter.this.g, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new a(NavigationMenuPresenter.this.f13439b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(k kVar) {
            if (kVar instanceof h) {
                ((NavigationMenuItemView) kVar.itemView).recycle();
            }
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.f13445a.get(i)).f13452b = true;
                i++;
            }
        }

        public void a(MenuItemImpl menuItemImpl) {
            if (this.f13446b == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f13446b;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f13446b = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void a(Bundle bundle) {
            MenuItemImpl menuItemImplA;
            View actionView;
            com.google.android.material.internal.k kVar;
            MenuItemImpl menuItemImplA2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f13447c = true;
                int size = this.f13445a.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.f13445a.get(i2);
                    if ((dVar instanceof f) && (menuItemImplA2 = ((f) dVar).a()) != null && menuItemImplA2.getItemId() == i) {
                        a(menuItemImplA2);
                        break;
                    }
                    i2++;
                }
                this.f13447c = false;
                f();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f13445a.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.f13445a.get(i3);
                    if ((dVar2 instanceof f) && (menuItemImplA = ((f) dVar2).a()) != null && (actionView = menuItemImplA.getActionView()) != null && (kVar = (com.google.android.material.internal.k) sparseParcelableArray.get(menuItemImplA.getItemId())) != null) {
                        actionView.restoreHierarchyState(kVar);
                    }
                }
            }
        }

        public void a(boolean z) {
            this.f13447c = z;
        }
    }

    private static class c implements d {
        c() {
        }
    }

    private interface d {
    }

    private static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13450b;

        public e(int i, int i2) {
            this.f13449a = i;
            this.f13450b = i2;
        }

        public int a() {
            return this.f13450b;
        }

        public int b() {
            return this.f13449a;
        }
    }

    private static class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItemImpl f13451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f13452b;

        f(MenuItemImpl menuItemImpl) {
            this.f13451a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f13451a;
        }
    }

    private class g extends W {
        g(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.W, androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            super.a(view, bVar);
            bVar.a(b.C0015b.a(NavigationMenuPresenter.this.f13443f.d(), 0, false));
        }
    }

    private static class h extends k {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class i extends k {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class j extends k {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class k extends RecyclerView.w {
        public k(View view) {
            super(view);
        }
    }

    private void k() {
        int i2 = (this.f13439b.getChildCount() == 0 && this.q) ? this.s : 0;
        NavigationMenuView navigationMenuView = this.f13438a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public View b(int i2) {
        View viewInflate = this.g.inflate(i2, (ViewGroup) this.f13439b, false);
        a(viewInflate);
        return viewInflate;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void c(int i2) {
        this.f13442e = i2;
    }

    public int d() {
        return this.f13439b.getChildCount();
    }

    public Drawable e() {
        return this.l;
    }

    public int f() {
        return this.m;
    }

    public int g() {
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f13442e;
    }

    public void h(int i2) {
        this.h = i2;
        this.i = true;
        a(false);
    }

    public ColorStateList i() {
        return this.j;
    }

    public ColorStateList j() {
        return this.k;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.a aVar) {
        this.f13440c = aVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Context context, MenuBuilder menuBuilder) {
        this.g = LayoutInflater.from(context);
        this.f13441d = menuBuilder;
        this.t = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public MenuItemImpl c() {
        return this.f13443f.c();
    }

    public void d(int i2) {
        this.m = i2;
        a(false);
    }

    public void e(int i2) {
        this.n = i2;
        a(false);
    }

    public void f(int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.p = true;
            a(false);
        }
    }

    public void g(int i2) {
        this.r = i2;
        a(false);
    }

    public void i(int i2) {
        this.u = i2;
        NavigationMenuView navigationMenuView = this.f13438a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void b(View view) {
        this.f13439b.removeView(view);
        if (this.f13439b.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.f13438a;
            navigationMenuView.setPadding(0, this.s, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void c(boolean z) {
        b bVar = this.f13443f;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public int h() {
        return this.r;
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        a(false);
    }

    public androidx.appcompat.view.menu.k a(ViewGroup viewGroup) {
        if (this.f13438a == null) {
            this.f13438a = (NavigationMenuView) this.g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            NavigationMenuView navigationMenuView = this.f13438a;
            navigationMenuView.setAccessibilityDelegateCompat(new g(navigationMenuView));
            if (this.f13443f == null) {
                this.f13443f = new b();
            }
            int i2 = this.u;
            if (i2 != -1) {
                this.f13438a.setOverScrollMode(i2);
            }
            this.f13439b = (LinearLayout) this.g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f13438a, false);
            this.f13438a.setAdapter(this.f13443f);
        }
        return this.f13438a;
    }

    public void b(boolean z) {
        if (this.q != z) {
            this.q = z;
            k();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        b bVar = this.f13443f;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.a aVar = this.f13440c;
        if (aVar != null) {
            aVar.a(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable a() {
        Bundle bundle = new Bundle();
        if (this.f13438a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f13438a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f13443f;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.b());
        }
        if (this.f13439b != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f13439b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f13438a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f13443f.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f13439b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(MenuItemImpl menuItemImpl) {
        this.f13443f.a(menuItemImpl);
    }

    public void a(View view) {
        this.f13439b.addView(view);
        NavigationMenuView navigationMenuView = this.f13438a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public View a(int i2) {
        return this.f13439b.getChildAt(i2);
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        a(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        a(false);
    }

    public void a(J j2) {
        int iE = j2.e();
        if (this.s != iE) {
            this.s = iE;
            k();
        }
        NavigationMenuView navigationMenuView = this.f13438a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, j2.b());
        ViewCompat.a(this.f13439b, j2);
    }
}
