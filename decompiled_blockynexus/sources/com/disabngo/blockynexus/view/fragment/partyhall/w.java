package com.disabngo.blockynexus.view.fragment.partyhall;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PartyHallListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends DataListModel<PartyItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<PartyItem> f11948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f11949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11950c;

    public w(Context context, int i, List<PartyItem> list, Map<String, String> map) {
        super(context, i);
        this.f11950c = true;
        this.f11948a = list;
        this.f11949b = map;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<PartyItem> getItemViewModel(PartyItem partyItem) {
        return new u(this.context, partyItem, this.f11949b);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_PARTY_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<PartyItem> listItemViewModel) {
        gVar.a(2, R.layout.item_party_hall);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<PartyItem>> onResponseListener) {
        List<PartyItem> list;
        if (!this.f11950c && (list = this.f11948a) != null && list.size() > 0) {
            DialogUtils.newsInstant().hideLoadingDialog();
        }
        if (this.f11950c) {
            List<PartyItem> list2 = this.f11948a;
            if (list2 == null || list2.size() == 0) {
                DialogUtils.newsInstant().showLoadingDialog(this.context);
            }
            this.f11950c = false;
        }
        onResponseListener.onSuccess(this.f11948a);
    }

    public void a(List<PartyItem> list) {
        this.f11948a = list;
    }
}
