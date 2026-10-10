package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected MenuBuilder f401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MenuPresenter.a f404f;
    private int g;
    private int h;
    protected k i;
    private int j;

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f399a = context;
        this.f402d = LayoutInflater.from(context);
        this.g = i;
        this.h = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Context context, MenuBuilder menuBuilder) {
        this.f400b = context;
        this.f403e = LayoutInflater.from(this.f400b);
        this.f401c = menuBuilder;
    }

    public abstract void a(MenuItemImpl menuItemImpl, k.a aVar);

    public boolean a(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public k b(ViewGroup viewGroup) {
        if (this.i == null) {
            this.i = (k) this.f402d.inflate(this.g, viewGroup, false);
            this.i.initialize(this.f401c);
            a(true);
        }
        return this.i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public MenuPresenter.a getCallback() {
        return this.f404f;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.a aVar) {
        this.f404f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.f401c;
        int i = 0;
        if (menuBuilder != null) {
            menuBuilder.b();
            ArrayList<MenuItemImpl> arrayListN = this.f401c.n();
            int size = arrayListN.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = arrayListN.get(i3);
                if (a(i2, menuItemImpl)) {
                    View childAt = viewGroup.getChildAt(i2);
                    MenuItemImpl itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewA = a(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        viewA.setPressed(false);
                        viewA.jumpDrawablesToCurrentState();
                    }
                    if (viewA != childAt) {
                        a(viewA, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i);
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public k.a a(ViewGroup viewGroup) {
        return (k.a) this.f402d.inflate(this.h, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        k.a aVarA;
        if (view instanceof k.a) {
            aVarA = (k.a) view;
        } else {
            aVarA = a(viewGroup);
        }
        a(menuItemImpl, aVarA);
        return (View) aVarA;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.a aVar = this.f404f;
        if (aVar != null) {
            aVar.a(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.a aVar = this.f404f;
        if (aVar != null) {
            return aVar.a(subMenuBuilder);
        }
        return false;
    }

    public void a(int i) {
        this.j = i;
    }
}
