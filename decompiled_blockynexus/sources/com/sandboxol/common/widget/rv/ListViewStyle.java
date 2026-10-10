package com.sandboxol.common.widget.rv;

import androidx.databinding.BaseObservable;
import com.sandboxol.common.BR;

/* JADX INFO: loaded from: classes3.dex */
public class ListViewStyle extends BaseObservable {
    private String emptyText;
    private boolean isLoadingMore;
    private boolean isRefreshing;
    private boolean isShowEmptyView;

    public String getEmptyText() {
        return this.emptyText;
    }

    public boolean isLoadingMore() {
        return this.isLoadingMore;
    }

    public boolean isRefreshing() {
        return this.isRefreshing;
    }

    public boolean isShowEmptyView() {
        return this.isShowEmptyView;
    }

    public void setEmptyText(String str) {
        this.emptyText = str;
        notifyPropertyChanged(BR.emptyText);
    }

    public void setLoadingMore(boolean z) {
        this.isLoadingMore = z;
        notifyPropertyChanged(BR.loadingMore);
    }

    public void setRefreshing(boolean z) {
        this.isRefreshing = z;
        notifyPropertyChanged(BR.refreshing);
    }

    public void setShowEmptyView(boolean z) {
        this.isShowEmptyView = z;
        notifyPropertyChanged(BR.showEmptyView);
    }
}
