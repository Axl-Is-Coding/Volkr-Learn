package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.mOverflowOnly = z;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = i;
        findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl menuItemImplF = this.mAdapterMenu.f();
        if (menuItemImplF != null) {
            ArrayList<MenuItemImpl> arrayListJ = this.mAdapterMenu.j();
            int size = arrayListJ.size();
            for (int i = 0; i < size; i++) {
                if (arrayListJ.get(i) == menuItemImplF) {
                    this.mExpandedIndex = i;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mExpandedIndex < 0 ? (this.mOverflowOnly ? this.mAdapterMenu.j() : this.mAdapterMenu.n()).size() : r0.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.mAdapterMenu.o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.mForceShowIcon) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> arrayListJ = this.mOverflowOnly ? this.mAdapterMenu.j() : this.mAdapterMenu.n();
        int i2 = this.mExpandedIndex;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayListJ.get(i);
    }
}
