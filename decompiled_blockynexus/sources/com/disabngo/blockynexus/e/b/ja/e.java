package com.disabngo.blockynexus.e.b.ja;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ShareRewardEntity;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: ShareListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<ShareRewardEntity> {
    public e(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ShareRewardEntity> getItemViewModel(ShareRewardEntity shareRewardEntity) {
        return new d(this.context, shareRewardEntity);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ShareRewardEntity> listItemViewModel) {
        gVar.a(2, R.layout.item_share);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ShareRewardEntity>> onResponseListener) {
        UserApi.loadShareReward(this.context, onResponseListener);
    }
}
