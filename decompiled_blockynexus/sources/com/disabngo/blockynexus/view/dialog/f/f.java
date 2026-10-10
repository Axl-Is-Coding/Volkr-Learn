package com.disabngo.blockynexus.view.dialog.f;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ScrapHistoryInfo;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: ScrapHistoryListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends PageListModel<ScrapHistoryInfo> {
    public f(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<ScrapHistoryInfo> listItemViewModel) {
        if (i == 0) {
            gVar.a(2, R.layout.item_scrap_history_title);
        } else {
            gVar.a(2, R.layout.item_scrap_history);
        }
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<ScrapHistoryInfo>> onResponseListener) {
        ScrapApi.getCombineHistory(this.context, i, i2, new e(this, i, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ScrapHistoryInfo> getItemViewModel(ScrapHistoryInfo scrapHistoryInfo) {
        return new c(this.context, scrapHistoryInfo);
    }
}
