package com.sandboxol.center.view.dialog.scrap;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.entity.ScrapInfoInBackpack;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapBagListModel extends PageListModel<ScrapInfoInBackpack> {
    private long friendId;
    public ObservableField<Boolean> isFromMain;
    public ObservableField<Boolean> isNoData;
    private boolean isPrivate;
    private int type;

    public ScrapBagListModel(Context context, int i, ObservableField<Boolean> observableField, long j, boolean z, ObservableField<Boolean> observableField2) {
        super(context, R.string.base_err_no_scrap);
        this.type = i;
        this.friendId = j;
        this.isFromMain = observableField;
        this.isPrivate = z;
        this.isNoData = observableField2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ScrapInfoInBackpack> listItemViewModel) {
        gVar.a(BR.ViewModel, R.layout.base_item_scrap_bag);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, final OnResponseListener<PageData<ScrapInfoInBackpack>> onResponseListener) {
        ScrapApi.getBackpackInfo(this.context, this.type, i, i2, new OnResponseListener<PageData<ScrapInfoInBackpack>>() { // from class: com.sandboxol.center.view.dialog.scrap.ScrapBagListModel.1
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i3, String str) {
                ScrapOnError.showErrorTip(((DefaultListModel) ScrapBagListModel.this).context, i3);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i3) {
                ServerOnError.showOnServerError(((DefaultListModel) ScrapBagListModel.this).context, i3);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(PageData<ScrapInfoInBackpack> pageData) {
                if (pageData == null || pageData.getData() == null || pageData.getData().size() == 0) {
                    ScrapBagListModel.this.isNoData.set(true);
                }
                onResponseListener.onSuccess(pageData);
            }
        });
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<ScrapInfoInBackpack> getItemViewModel(ScrapInfoInBackpack scrapInfoInBackpack) {
        return new ScrapBagItemViewModel(this.context, scrapInfoInBackpack, this.isFromMain, this.friendId, this.isPrivate);
    }
}
