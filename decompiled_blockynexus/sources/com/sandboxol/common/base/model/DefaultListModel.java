package com.sandboxol.common.base.model;

import android.content.Context;
import android.text.TextUtils;
import com.sandboxol.common.R;
import com.sandboxol.common.base.viewmodel.IListViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultListModel<T> implements IListModel<T> {
    protected Context context;
    private String errorHint;
    private IListViewModel viewModel;

    public DefaultListModel(Context context, int i) {
        this.context = context;
        this.errorHint = context.getResources().getString(i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public List<T> getData() {
        IListViewModel iListViewModel = this.viewModel;
        return iListViewModel != null ? iListViewModel.getData() : new ArrayList();
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public String getErrorHint() {
        if (TextUtils.isEmpty(this.errorHint)) {
            this.errorHint = this.context.getResources().getString(R.string.no_data);
        }
        return this.errorHint;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public String getInsertToken() {
        return null;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public String getLoadMoreToken() {
        return null;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return null;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public String getRemoveToken() {
        return null;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public String getReplaceToken() {
        return null;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public IListViewModel<T> getViewModel() {
        return this.viewModel;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void setViewModel(IListViewModel<T> iListViewModel) {
        this.viewModel = iListViewModel;
    }
}
