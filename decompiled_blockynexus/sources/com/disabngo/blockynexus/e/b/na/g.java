package com.disabngo.blockynexus.e.b.na;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.J;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: TribeInviteFriendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends DataListModel<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableArrayList<String> f9977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Boolean> f9978b;

    public g(Context context, int i, ObservableArrayList<String> observableArrayList, ObservableField<Boolean> observableField) {
        super(context, i);
        this.f9977a = observableArrayList;
        this.f9978b = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<Friend> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_invite_friend);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<Friend>> onResponseListener) {
        this.f9977a.clear();
        J.a(this.context, (OnResponseListener<List<Friend>>) new f(this, onResponseListener), getRefreshToken(), false);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<Friend> getItemViewModel(Friend friend) {
        return new d(this.context, friend, this.f9977a, this.f9978b);
    }
}
