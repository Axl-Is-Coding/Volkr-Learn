package com.sandboxol.common.base.model;

import com.sandboxol.common.base.viewmodel.IListViewModel;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes3.dex */
public interface IListModel<T> extends IModel {
    List<T> getData();

    String getErrorHint();

    String getInsertToken();

    ListItemViewModel<T> getItemViewModel(T t);

    String getLoadMoreToken();

    String getRefreshToken();

    String getRemoveToken();

    String getReplaceToken();

    IListViewModel<T> getViewModel();

    int getViewTypeCount();

    void onBind(g gVar, int i, ListItemViewModel<T> listItemViewModel);

    void setViewModel(IListViewModel<T> iListViewModel);
}
