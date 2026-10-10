package com.disabngo.blockynexus.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListViewBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected LayoutInflater layoutInflater;
    protected List<T> list;

    public ListViewBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public void setData(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
