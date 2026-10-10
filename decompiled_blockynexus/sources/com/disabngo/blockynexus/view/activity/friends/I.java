package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: FriendGoodsListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class I extends DataListModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableMap<Long, String> f10645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableMap<Long, String> f10646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Long> f10647c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f10648d;

    public I(Context context, int i, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, ObservableField<Long> observableField) {
        super(context, i);
        this.context = context;
        this.f10645a = observableMap;
        this.f10646b = observableMap2;
        this.f10647c = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SingleDressInfo> getItemViewModel(SingleDressInfo singleDressInfo) {
        return new G(this.context, singleDressInfo, this.f10645a, this.f10646b);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_FRIEND_DETAIL_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SingleDressInfo> listItemViewModel) {
        if (this.f10648d != null) {
            gVar.a(2, R.layout.item_party_friend_info_goods_view);
        } else {
            gVar.a(2, R.layout.item_friend_goods_view);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        com.sandboxol.decorate.web.t.b(this.context, this.f10647c.get().longValue(), new H(this, onResponseListener));
    }

    public I(Context context, int i, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, ObservableField<Long> observableField, ObservableField<Boolean> observableField2) {
        super(context, i);
        this.context = context;
        this.f10645a = observableMap;
        this.f10646b = observableMap2;
        this.f10647c = observableField;
        this.f10648d = observableField2;
    }
}
