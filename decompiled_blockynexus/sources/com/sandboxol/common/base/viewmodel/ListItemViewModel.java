package com.sandboxol.common.base.viewmodel;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListItemViewModel<T> extends ViewModel {
    protected Context context;
    protected T item;

    public ListItemViewModel(Context context, T t) {
        this.context = context;
        this.item = t;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(T t) {
        this.item = t;
        notifyChange();
    }
}
