package com.sandboxol.googlepay.c.a.c;

import android.content.Context;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.googlepay.R;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: RechargeHistoryModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends PageListModel<PayRecordInfo> {
    e(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<PayRecordInfo> getItemViewModel(PayRecordInfo payRecordInfo) {
        return new c(this.context, payRecordInfo);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<PayRecordInfo> listItemViewModel) {
        gVar.a(com.sandboxol.googlepay.a.f18173b, R.layout.item_recharge_history);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<PayRecordInfo>> onResponseListener) {
        BillingManager.getInstance().rechargeHistory(this.context, i, i2, onResponseListener);
    }
}
