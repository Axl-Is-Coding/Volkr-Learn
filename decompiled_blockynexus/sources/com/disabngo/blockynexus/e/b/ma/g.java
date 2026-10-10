package com.disabngo.blockynexus.e.b.ma;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.O.u;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.TribeClanMembersBean;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: TribeDetailLeaderListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends DataListModel<TribeClanMembersBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<TribeClanMembersBean> f9942c;

    public g(Context context, int i, int i2, int i3) {
        super(context, i);
        this.f9940a = i2;
        this.f9941b = i3;
    }

    public void a(List<TribeClanMembersBean> list) {
        this.f9942c = list;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_TRIBE_INFO_MEMBERS;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeClanMembersBean> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_leader);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TribeClanMembersBean>> onResponseListener) {
        if (this.f9940a == 1) {
            onResponseListener.onSuccess(u.a().c());
        } else {
            onResponseListener.onSuccess(this.f9942c);
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeClanMembersBean> getItemViewModel(TribeClanMembersBean tribeClanMembersBean) {
        return new f(this.context, tribeClanMembersBean, this.f9941b);
    }

    public g(Context context, int i, int i2) {
        super(context, i);
        this.f9940a = i2;
    }
}
