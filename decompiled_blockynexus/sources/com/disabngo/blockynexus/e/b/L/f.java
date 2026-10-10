package com.disabngo.blockynexus.e.b.L;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.MailInfo;
import com.disabngo.blockynexus.web.MailBoxApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: InboxListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends DataListModel<MailInfo> {
    public f(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<MailInfo> getItemViewModel(MailInfo mailInfo) {
        return new d(this.context, mailInfo);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_INBOX;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<MailInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_inbox_view);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<MailInfo>> onResponseListener) {
        MailBoxApi.mailList(this.context, new e(this, onResponseListener));
    }
}
