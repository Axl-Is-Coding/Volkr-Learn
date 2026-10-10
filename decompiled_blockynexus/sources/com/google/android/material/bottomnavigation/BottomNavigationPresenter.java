package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuBuilder f13194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BottomNavigationMenuView f13195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13196c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13197d;

    static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        k f13199b;

        a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f13198a);
            parcel.writeParcelable(this.f13199b, 0);
        }

        a(Parcel parcel) {
            this.f13198a = parcel.readInt();
            this.f13199b = (k) parcel.readParcelable(a.class.getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z) {
    }

    public void a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f13195b = bottomNavigationMenuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void b(boolean z) {
        this.f13196c = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f13197d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.a aVar) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Context context, MenuBuilder menuBuilder) {
        this.f13194a = menuBuilder;
        this.f13195b.initialize(this.f13194a);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(boolean z) {
        if (this.f13196c) {
            return;
        }
        if (z) {
            this.f13195b.buildMenuView();
        } else {
            this.f13195b.updateMenuView();
        }
    }

    public void a(int i) {
        this.f13197d = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable a() {
        a aVar = new a();
        aVar.f13198a = this.f13195b.getSelectedItemId();
        aVar.f13199b = com.google.android.material.b.c.a(this.f13195b.getBadgeDrawables());
        return aVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(Parcelable parcelable) {
        if (parcelable instanceof a) {
            a aVar = (a) parcelable;
            this.f13195b.tryRestoreSelectedItemId(aVar.f13198a);
            this.f13195b.setBadgeDrawables(com.google.android.material.b.c.a(this.f13195b.getContext(), aVar.f13199b));
        }
    }
}
