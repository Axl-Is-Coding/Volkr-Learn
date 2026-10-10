package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface MenuPresenter {

    public interface a {
        void a(MenuBuilder menuBuilder, boolean z);

        boolean a(MenuBuilder menuBuilder);
    }

    Parcelable a();

    void a(Context context, MenuBuilder menuBuilder);

    void a(Parcelable parcelable);

    void a(MenuBuilder menuBuilder, boolean z);

    void a(boolean z);

    boolean a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    boolean a(SubMenuBuilder subMenuBuilder);

    boolean b();

    boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    int getId();

    void setCallback(a aVar);
}
