package com.disabngo.blockynexus.e.b.O;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: MakeFriendTagListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends DataListModel<String> {
    public s(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_TRIBE_INFO_TAG;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<String> listItemViewModel) {
        gVar.a(2, R.layout.item_make_friend_tribe_detail_label);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<String>> onResponseListener) {
        onResponseListener.onSuccess(u.a().b());
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<String> getItemViewModel(String str) {
        return new r(this.context, str);
    }
}
