package androidx.appcompat.view.menu;

/* JADX INFO: compiled from: MenuView.java */
/* JADX INFO: loaded from: classes.dex */
public interface k {

    /* JADX INFO: compiled from: MenuView.java */
    public interface a {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i);

        boolean prefersCondensedTitle();
    }

    void initialize(MenuBuilder menuBuilder);
}
