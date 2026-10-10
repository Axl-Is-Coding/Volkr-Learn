package me.tatarka.bindingcollectionadapter2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BindingListViewAdapter<T> extends BaseAdapter implements me.tatarka.bindingcollectionadapter2.a<T> {
    private final c<T> callback = new c<>(this);
    private int dropDownItemLayout;
    private LayoutInflater inflater;
    private g<T> itemBinding;
    private a<? super T> itemIds;
    private b<? super T> itemIsEnabled;
    private final int itemTypeCount;
    private List<T> items;
    private int[] layouts;

    public interface a<T> {
        long a(int i, T t);
    }

    public interface b<T> {
        boolean a(int i, T t);
    }

    public BindingListViewAdapter(int i) {
        this.itemTypeCount = i;
    }

    private int ensureLayoutsInit() {
        int i = this.itemTypeCount;
        if (this.layouts == null) {
            this.layouts = new int[i];
        }
        return i;
    }

    public T getAdapterItem(int i) {
        return this.items.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.inflater == null) {
            this.inflater = LayoutInflater.from(viewGroup.getContext());
        }
        int i2 = this.dropDownItemLayout;
        if (i2 == 0) {
            return super.getDropDownView(i, view, viewGroup);
        }
        ViewDataBinding viewDataBindingOnCreateBinding = view == null ? onCreateBinding(this.inflater, i2, viewGroup) : androidx.databinding.e.a(view);
        onBindBinding(viewDataBindingOnCreateBinding, this.itemBinding.b(), i2, i, this.items.get(i));
        return viewDataBindingOnCreateBinding.getRoot();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.items.get(i);
    }

    public g<T> getItemBinding() {
        return this.itemBinding;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        a<? super T> aVar = this.itemIds;
        return aVar == null ? i : aVar.a(i, this.items.get(i));
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        ensureLayoutsInit();
        this.itemBinding.a(i, this.items.get(i));
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.layouts;
            if (i2 >= iArr.length) {
                iArr[i3] = this.itemBinding.a();
                return i3;
            }
            int iA = this.itemBinding.a();
            int[] iArr2 = this.layouts;
            if (iA == iArr2[i2]) {
                return i2;
            }
            if (iArr2[i2] == 0) {
                i3 = i2;
            }
            i2++;
        }
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.inflater == null) {
            this.inflater = LayoutInflater.from(viewGroup.getContext());
        }
        int i2 = this.layouts[getItemViewType(i)];
        ViewDataBinding viewDataBindingOnCreateBinding = view == null ? onCreateBinding(this.inflater, i2, viewGroup) : androidx.databinding.e.a(view);
        onBindBinding(viewDataBindingOnCreateBinding, this.itemBinding.b(), i2, i, this.items.get(i));
        return viewDataBindingOnCreateBinding.getRoot();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return ensureLayoutsInit();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.itemIds != null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b<? super T> bVar = this.itemIsEnabled;
        return bVar == null || bVar.a(i, this.items.get(i));
    }

    public void onBindBinding(ViewDataBinding viewDataBinding, int i, int i2, int i3, T t) {
        if (this.itemBinding.a(viewDataBinding, t)) {
            viewDataBinding.executePendingBindings();
        }
    }

    public ViewDataBinding onCreateBinding(LayoutInflater layoutInflater, int i, ViewGroup viewGroup) {
        return androidx.databinding.e.a(layoutInflater, i, viewGroup, false);
    }

    public void setDropDownItemLayout(int i) {
        this.dropDownItemLayout = i;
    }

    public void setItemBinding(g<T> gVar) {
        this.itemBinding = gVar;
    }

    public void setItemIds(a<? super T> aVar) {
        this.itemIds = aVar;
    }

    public void setItemIsEnabled(b<? super T> bVar) {
        this.itemIsEnabled = bVar;
    }

    public void setItems(List<T> list) {
        List<T> list2 = this.items;
        if (list2 == list) {
            return;
        }
        if (list2 instanceof ObservableList) {
            ((ObservableList) list2).removeOnListChangedCallback(this.callback);
        }
        if (list instanceof ObservableList) {
            ((ObservableList) list).addOnListChangedCallback(this.callback);
        }
        this.items = list;
        notifyDataSetChanged();
    }

    private static class c<T> extends ObservableList.a<ObservableList<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<BindingListViewAdapter<T>> f22975a;

        c(BindingListViewAdapter<T> bindingListViewAdapter) {
            this.f22975a = new WeakReference<>(bindingListViewAdapter);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList) {
            BindingListViewAdapter<T> bindingListViewAdapter = this.f22975a.get();
            if (bindingListViewAdapter == null) {
                return;
            }
            m.a();
            bindingListViewAdapter.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.a
        public void b(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void c(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2) {
            a(observableList);
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2, int i3) {
            a(observableList);
        }
    }
}
