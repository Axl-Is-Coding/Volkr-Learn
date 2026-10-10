package com.sandbox.login.view.widget.account;

import android.content.Context;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: AccountListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<UserRecord> {
    public e(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<UserRecord> getItemViewModel(UserRecord userRecord) {
        return new f(this.context, userRecord);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return "token.refresh.record.account.list";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<UserRecord> listItemViewModel) {
        gVar.a(com.sandbox.login.g.f15905b, R.layout.login_account_list_item);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<UserRecord>> onResponseListener) {
        List<UserRecord> listB = com.sandbox.login.a.b.a().b();
        if (listB.size() > 0) {
            ReportDataAdapter.onEvent(this.context, EventConstant.HAVE_AVAILABLE_ID);
        }
        onResponseListener.onSuccess(listB);
    }
}
