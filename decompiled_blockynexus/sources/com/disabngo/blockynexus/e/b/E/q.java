package com.disabngo.blockynexus.e.b.E;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: GroupAdmiListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends DataListModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GroupInfo f9219a;

    public q(Context context, int i, GroupInfo groupInfo) {
        super(context, i);
        this.f9219a = groupInfo;
    }

    public /* synthetic */ void a(OnResponseListener onResponseListener, GroupInfo groupInfo) {
        this.f9219a = groupInfo;
        onResponseListener.onSuccess(y.b().a(this.f9219a, false));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GroupMember> listItemViewModel) {
        gVar.a(326, R.layout.item_group_admi_list);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(final OnResponseListener<List<GroupMember>> onResponseListener) {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_GROUP_ADMIN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.E.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9203a.a(onResponseListener, (GroupInfo) obj);
            }
        });
        onResponseListener.onSuccess(y.b().a(this.f9219a, false));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupMember> getItemViewModel(GroupMember groupMember) {
        return new t(this.context, groupMember);
    }
}
