package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.SignInReward;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: ActivitySignUpRewardListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends DataListModel<SignInReward> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<SignInReward> f11461a;

    public j(Context context, int i, List<SignInReward> list) {
        super(context, i);
        this.f11461a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SignInReward> getItemViewModel(SignInReward signInReward) {
        return new i(this.context, signInReward);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SignInReward> listItemViewModel) {
        gVar.a(2, R.layout.item_activity_sign_up_reward);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SignInReward>> onResponseListener) {
        onResponseListener.onSuccess(this.f11461a);
    }
}
