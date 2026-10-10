package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuPresenter implements AdapterView.OnItemClickListener, MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LayoutInflater f414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    MenuBuilder f415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExpandedMenuView f416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f418f;
    int g;
    private MenuPresenter.a h;
    a i;
    private int j;

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f419a = -1;

        public a() {
            a();
        }

        void a() {
            MenuItemImpl menuItemImplF = ListMenuPresenter.this.f415c.f();
            if (menuItemImplF != null) {
                ArrayList<MenuItemImpl> arrayListJ = ListMenuPresenter.this.f415c.j();
                int size = arrayListJ.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListJ.get(i) == menuItemImplF) {
                        this.f419a = i;
                        return;
                    }
                }
            }
            this.f419a = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f415c.j().size() - ListMenuPresenter.this.f417e;
            return this.f419a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f414b.inflate(listMenuPresenter.g, viewGroup, false);
            }
            ((k.a) view).initialize(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> arrayListJ = ListMenuPresenter.this.f415c.j();
            int i2 = i + ListMenuPresenter.this.f417e;
            int i3 = this.f419a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return arrayListJ.get(i2);
        }
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f413a = context;
        this.f414b = LayoutInflater.from(this.f413a);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Context context, MenuBuilder menuBuilder) {
        int i = this.f418f;
        if (i != 0) {
            this.f413a = new ContextThemeWrapper(context, i);
            this.f414b = LayoutInflater.from(this.f413a);
        } else if (this.f413a != null) {
            this.f413a = context;
            if (this.f414b == null) {
                this.f414b = LayoutInflater.from(this.f413a);
            }
        }
        this.f415c = menuBuilder;
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void b(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f416d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public ListAdapter c() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.j;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f415c.a(this.i.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.a aVar) {
        this.h = aVar;
    }

    public ListMenuPresenter(int i, int i2) {
        this.g = i;
        this.f418f = i2;
    }

    public k a(ViewGroup viewGroup) {
        if (this.f416d == null) {
            this.f416d = (ExpandedMenuView) this.f414b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.i == null) {
                this.i = new a();
            }
            this.f416d.setAdapter((ListAdapter) this.i);
            this.f416d.setOnItemClickListener(this);
        }
        return this.f416d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).a((IBinder) null);
        MenuPresenter.a aVar = this.h;
        if (aVar == null) {
            return true;
        }
        aVar.a(subMenuBuilder);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.a aVar = this.h;
        if (aVar != null) {
            aVar.a(menuBuilder, z);
        }
    }

    public void a(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f416d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable a() {
        if (this.f416d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        b(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Parcelable parcelable) {
        a((Bundle) parcelable);
    }
}
