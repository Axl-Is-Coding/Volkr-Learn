package com.disabngo.blockynexus.e.b.pa;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeMessage;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: TribeMessageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends DataListModel<TribeMessage> {
    public j(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeMessage> getItemViewModel(TribeMessage tribeMessage) {
        return new i(this.context, tribeMessage);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeMessage> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_message);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TribeMessage>> onResponseListener) {
        TribeApi.tribeMessage(this.context, onResponseListener);
    }
}
