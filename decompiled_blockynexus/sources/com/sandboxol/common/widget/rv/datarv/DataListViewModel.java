package com.sandboxol.common.widget.rv.datarv;

import android.content.Context;
import com.sandboxol.common.R;
import com.sandboxol.common.base.model.IListModel;
import com.sandboxol.common.base.viewmodel.ListViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.HttpUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataListViewModel<T> extends ListViewModel<T> {
    private boolean isReplace;

    public DataListViewModel(Context context, IListModel iListModel) {
        super(context, iListModel);
        onRefresh();
    }

    public void loadData() {
        if (this.model != null) {
            showEmptyView(this.context.getResources().getString(R.string.data_loading));
            ((DataListModel) this.model).onLoad(new OnResponseListener<List<T>>() { // from class: com.sandboxol.common.widget.rv.datarv.DataListViewModel.1
                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onError(int i, String str) {
                    DataListViewModel.this.onError(null);
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onServerError(int i) {
                    DataListViewModel dataListViewModel = DataListViewModel.this;
                    dataListViewModel.onError(HttpUtils.getHttpErrorMsg(((ListViewModel) dataListViewModel).context, i));
                }

                @Override // com.sandboxol.common.base.web.OnResponseListener
                public void onSuccess(List<T> list) {
                    if (list != null) {
                        DataListViewModel dataListViewModel = DataListViewModel.this;
                        dataListViewModel.setEnableSetItem(dataListViewModel.isReplace);
                        DataListViewModel.this.replaceData(list);
                    }
                    DataListViewModel.this.onSuccess();
                }
            });
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void onLoadMore() {
        setLoadingMore(false);
    }

    @Override // com.sandboxol.common.base.viewmodel.IListViewModel
    public void onRefresh() {
        setRefreshing(true);
        setLoadingMore(true);
        loadData();
    }

    public DataListViewModel(Context context, IListModel iListModel, boolean z) {
        super(context, iListModel);
        this.isReplace = z;
        onRefresh();
    }
}
