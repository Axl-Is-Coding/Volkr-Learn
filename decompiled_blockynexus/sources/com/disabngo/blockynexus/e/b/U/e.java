package com.disabngo.blockynexus.e.b.U;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.BannerPic;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PreheatListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<BannerPic> {
    public e(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<BannerPic> getItemViewModel(BannerPic bannerPic) {
        return new d(this.context, bannerPic);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getReplaceToken() {
        return MessageToken.TOKEN_REPLACE_PREHEAT_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<BannerPic> listItemViewModel) {
        gVar.a(2, R.layout.item_preheat_view);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<BannerPic>> onResponseListener) {
        onResponseListener.onSuccess(new ArrayList());
    }
}
