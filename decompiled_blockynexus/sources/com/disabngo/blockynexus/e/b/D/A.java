package com.disabngo.blockynexus.e.b.D;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GroupInfoListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class A extends DataListModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<GroupMember> f9154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<GroupMember> f9155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9156f;
    private boolean g;
    private GroupInfo h;
    public ObservableField<Boolean> i;
    public ObservableField<Boolean> j;
    public ObservableField<Integer> k;

    public A(Context context, int i, long j, List<GroupMember> list, GroupInfo groupInfo) {
        super(context, i);
        this.f9155e = new ArrayList();
        this.i = new ObservableField<>(false);
        this.j = new ObservableField<>(false);
        this.k = new ObservableField<>(0);
        this.f9151a = j;
        this.f9154d = list;
        this.h = groupInfo;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_MEMBERS_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GroupMember> listItemViewModel) {
        if (listItemViewModel.getItem().getUserId() == -1) {
            gVar.a(2, R.layout.item_invite_member);
        } else if (listItemViewModel.getItem().getUserId() == -2) {
            gVar.a(2, R.layout.item_remove_member);
        } else {
            gVar.a(2, R.layout.item_member_list);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GroupMember>> onResponseListener) {
        GroupInfo groupInfo = this.h;
        if (groupInfo == null || groupInfo.getGroupMembers() == null) {
            onResponseListener.onSuccess(new ArrayList());
        } else {
            b(this.h);
            onResponseListener.onSuccess(a(this.f9154d));
        }
        GroupChatApi.getGroupInfo(this.context, this.f9151a, new z(this, onResponseListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupInfo groupInfo) {
        this.k.set(Integer.valueOf(groupInfo.getOfficialGroup()));
        int i = 0;
        this.f9156f = groupInfo.getInviteStatus() != 0;
        this.i.set(Boolean.valueOf(groupInfo.getOwnerId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))));
        this.j.set(Boolean.valueOf(com.disabngo.blockynexus.d.y.b().b(groupInfo.getGroupMembers(), AccountCenter.newInstance().userId.get().longValue())));
        if (!this.i.get().booleanValue() && !this.j.get().booleanValue()) {
            i = 1;
        }
        this.f9153c = i;
        this.f9152b = groupInfo.getGroupName();
        this.g = com.disabngo.blockynexus.d.y.b().a(groupInfo.getGroupMembers(), AccountCenter.newInstance().userId.get().longValue());
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupMember> getItemViewModel(GroupMember groupMember) {
        if (groupMember.getUserId() == -1) {
            return new w(this.context, groupMember, this.f9154d, this.f9151a, this.f9153c);
        }
        if (groupMember.getUserId() == -2) {
            return new E(this.context, groupMember, this.f9154d, this.f9151a, this.f9152b);
        }
        return new x(this.context, groupMember);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GroupMember> a(GroupInfo groupInfo) {
        List<GroupMember> list = this.f9154d;
        if (list != null && list.size() > 0) {
            this.f9154d.clear();
        }
        if (groupInfo.getGroupMembers() != null && groupInfo.getGroupMembers().size() != 0) {
            this.f9154d.addAll(groupInfo.getGroupMembers());
        } else {
            this.f9154d.addAll(new ArrayList());
        }
        if (this.f9155e != null && this.f9154d.size() > 0) {
            this.f9155e.clear();
        }
        this.f9155e.addAll(a(this.f9154d));
        return this.f9155e;
    }

    private List<GroupMember> a(List<GroupMember> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 18) {
            arrayList.addAll(list.subList(0, 18));
        } else {
            arrayList.addAll(list);
        }
        List<GroupMember> listC = com.disabngo.blockynexus.d.y.b().c(arrayList);
        if (!this.i.get().booleanValue() && !this.j.get().booleanValue()) {
            if (this.g && this.k.get().intValue() == 0 && this.f9156f) {
                GroupMember groupMember = new GroupMember();
                groupMember.setUserName("");
                groupMember.setUserId(-1L);
                groupMember.setPic("");
                listC.add(groupMember);
            }
        } else {
            GroupMember groupMember2 = new GroupMember();
            groupMember2.setUserName("");
            groupMember2.setUserId(-1L);
            groupMember2.setPic("");
            GroupMember groupMember3 = new GroupMember();
            groupMember3.setUserName("");
            groupMember3.setUserId(-2L);
            groupMember3.setPic("");
            listC.add(groupMember2);
            listC.add(groupMember3);
        }
        return listC;
    }
}
