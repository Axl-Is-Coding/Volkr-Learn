package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.UserSignInList;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: ActivitySignUpListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends DataListModel<UserSignInList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UserSignInResponse f11455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f11456b;

    public f(Context context, d dVar, int i, UserSignInResponse userSignInResponse) {
        super(context, i);
        this.f11455a = userSignInResponse;
        this.f11456b = dVar;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<UserSignInList> getItemViewModel(UserSignInList userSignInList) {
        return new e(this.context, this.f11456b, this.f11455a, userSignInList);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<UserSignInList> listItemViewModel) {
        gVar.a(2, R.layout.item_activity_sign_up);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<UserSignInList>> onResponseListener) {
        UserSignInResponse userSignInResponse = this.f11455a;
        if (userSignInResponse == null || userSignInResponse.getUserSignInList().size() < 6) {
            return;
        }
        onResponseListener.onSuccess(this.f11455a.getUserSignInList().subList(0, 6));
    }
}
