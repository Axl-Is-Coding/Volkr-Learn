package com.sandboxol.common.base.viewmodel;

import com.sandboxol.common.widget.rv.msg.InsertMsg;
import com.sandboxol.common.widget.rv.msg.RemoveMsg;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IListViewModel<T> {
    void add(Object obj, int i, InsertMsg.INSERT_MODE insert_mode);

    void addItem(T t);

    void addItem(T t, int i, InsertMsg.INSERT_MODE insert_mode);

    void addItemViewModel(ListItemViewModel<T> listItemViewModel);

    void addItemViewModel(ListItemViewModel<T> listItemViewModel, int i, InsertMsg.INSERT_MODE insert_mode);

    void addItems(List<T> list);

    void addItems(List<T> list, int i, InsertMsg.INSERT_MODE insert_mode);

    void bindView(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel listItemViewModel);

    void clearItems();

    List<T> getData();

    List<ListItemViewModel<T>> getItemViewModel();

    int getViewTypeCount();

    void hideEmptyView();

    void onError(String str);

    void onLoadMore();

    void onRefresh();

    void onSuccess();

    void registerMessenger();

    void remove(Object obj, int i, RemoveMsg.REMOVE_MODE remove_mode);

    void removeIndex(int i);

    void removeItem(T t);

    void removeItems(Object obj);

    void replaceAll(List<T> list);

    void setLoadingMore(boolean z);

    void setRefreshing(boolean z);

    void showEmptyView(String str);
}
