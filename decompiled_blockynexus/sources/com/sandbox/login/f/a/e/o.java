package com.sandbox.login.f.a.e;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: AccountRecordListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends DataListModel<UserRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f15867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<UserRecord> f15868b;

    public o(Context context, ObservableField<String> observableField, int i) {
        super(context, i);
        this.f15868b = new ArrayList();
        this.f15867a = observableField;
    }

    public /* synthetic */ void a(OnResponseListener onResponseListener, List list) {
        if (list.size() > 0) {
            if (((UserRecord) list.get(0)).getUserId().equals(AccountCenter.newInstance().userId.get() + "")) {
                this.f15867a.set(((UserRecord) list.get(0)).getUid());
            }
            if (list.size() >= 2) {
                ReportDataAdapter.onEvent(this.context, EventConstant.HAVE_MORE_HISTORY_ID);
            }
            this.f15868b.clear();
            this.f15868b.addAll(list);
            UserRecord userRecord = new UserRecord();
            userRecord.setID(-1L);
            this.f15868b.add(userRecord);
            this.f15868b.add(userRecord);
        }
        onResponseListener.onSuccess(this.f15868b);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return "token.refresh.record.account.list";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<UserRecord> listItemViewModel) {
        gVar.a(com.sandbox.login.g.f15905b, R.layout.login_account_record_item);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(final OnResponseListener<List<UserRecord>> onResponseListener) {
        com.sandbox.login.a.b.a().a(new Action1() { // from class: com.sandbox.login.f.a.e.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15848a.a(onResponseListener, (List) obj);
            }
        });
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<UserRecord> getItemViewModel(UserRecord userRecord) {
        return new m(this.context, this.f15867a, userRecord);
    }
}
