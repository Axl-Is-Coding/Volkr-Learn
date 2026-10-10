package io.rong.imkit.widget.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
    private Context mContext;
    protected List<T> mList = new ArrayList();

    public BaseAdapter() {
    }

    public void add(T t) {
        this.mList.add(t);
    }

    public void addCollection(Collection<T> collection) {
        this.mList.addAll(collection);
    }

    protected abstract void bindView(View view, int i, T t);

    public void clear() {
        this.mList.clear();
    }

    public int findPosition(T t) {
        int count = getCount();
        while (true) {
            int i = count - 1;
            if (count <= 0) {
                return -1;
            }
            if (t.equals(getItem(i))) {
                return i;
            }
            count = i;
        }
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(Landroid/view/View;I)TT; */
    protected View findViewById(View view, int i) {
        return view.findViewById(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        List<T> list = this.mList;
        if (list != null && i < list.size()) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newView(this.mContext, i, viewGroup);
        }
        bindView(view, i, getItem(i));
        return view;
    }

    protected abstract View newView(Context context, int i, ViewGroup viewGroup);

    public void remove(int i) {
        this.mList.remove(i);
    }

    public void removeAll() {
        this.mList.clear();
    }

    public void add(T t, int i) {
        this.mList.add(i, t);
    }

    @SafeVarargs
    public final void addCollection(T... tArr) {
        Collections.addAll(this.mList, tArr);
    }

    public BaseAdapter(Context context) {
        this.mContext = context;
    }

    public int findPosition(long j) {
        int count = getCount();
        while (true) {
            int i = count - 1;
            if (count <= 0) {
                return -1;
            }
            if (getItemId(i) == j) {
                return i;
            }
            count = i;
        }
    }
}
