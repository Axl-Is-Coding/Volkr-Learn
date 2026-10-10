package com.disabngo.blockynexus.view.fragment.tribehas;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.TribeMember;
import java.util.List;

/* JADX INFO: compiled from: TribeHasListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class L extends DataListModel<TribeMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11979a;

    public L(Context context, int i, boolean z) {
        super(context, i);
        this.f11979a = z;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeMember> getItemViewModel(TribeMember tribeMember) {
        return new J(this.context, tribeMember, this.f11979a);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_TRIBE_MEMBER;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeMember> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_member_list);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TribeMember>> onResponseListener) {
        TribeApi.tribeMember(this.context, getData().size(), new K(this, onResponseListener));
    }
}
