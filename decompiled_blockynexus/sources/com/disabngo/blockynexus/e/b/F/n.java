package com.disabngo.blockynexus.e.b.F;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: GroupMemberListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends DataListModel<GroupMember> {
    private u viewModel;

    public n(Context context, int i, u uVar) {
        super(context, i);
        this.viewModel = uVar;
    }

    private List<GroupMember> b(List<GroupMember> list) {
        ArrayList arrayList = new ArrayList();
        if (y.b().b(list, AccountCenter.newInstance().userId.get().longValue())) {
            arrayList.addAll(y.b().a(list));
        } else {
            arrayList.addAll(y.b().b(list));
        }
        if (arrayList.size() > 0) {
            arrayList.add(new GroupMember(-1L));
        }
        return arrayList;
    }

    private List<GroupMember> c(List<GroupMember> list) {
        TreeSet treeSet = new TreeSet(new com.disabngo.blockynexus.d.q());
        Iterator<GroupMember> it = list.iterator();
        while (it.hasNext()) {
            treeSet.add(it.next());
        }
        ArrayList arrayList = new ArrayList(treeSet);
        if (arrayList.size() > 0) {
            arrayList.add(new GroupMember(-1L));
        }
        return arrayList;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GroupMember> listItemViewModel) {
        if (listItemViewModel.getItem().getUserId() == -1) {
            gVar.a(2, R.layout.item_for_blank);
        } else {
            gVar.a(508, R.layout.item_group_member);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GroupMember>> onResponseListener) {
        u uVar = this.viewModel;
        int i = uVar.f9279b;
        if (i == 0) {
            a(new j(this, onResponseListener));
            return;
        }
        if (i == 1) {
            a(uVar.h, new k(this, onResponseListener));
        } else if (i == 2) {
            onResponseListener.onSuccess(b(uVar.h));
        } else {
            if (i != 3) {
                return;
            }
            onResponseListener.onSuccess(c(uVar.h));
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupMember> getItemViewModel(GroupMember groupMember) {
        return groupMember.getUserId() == -1 ? new g(this.context, groupMember) : new h(this.context, groupMember, this.viewModel.f9279b != 3, this.viewModel);
    }

    private void a(List<GroupMember> list, com.sandboxol.greendao.a.c<List<GroupMember>> cVar) {
        a(new l(this, list, cVar));
    }

    private void a(com.sandboxol.greendao.a.c<List<Friend>> cVar) {
        J.a(this.context, (OnResponseListener<List<Friend>>) new m(this, cVar), getRefreshToken(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GroupMember> a(List<Friend> list) {
        ArrayList arrayList = new ArrayList();
        for (Friend friend : list) {
            if (friend.getUserId() != 32) {
                GroupMember groupMember = new GroupMember();
                groupMember.setUserId(friend.getUserId());
                groupMember.setUserName(friend.getNickName());
                groupMember.setPic(friend.getPicUrl());
                groupMember.setVip(friend.getVip());
                arrayList.add(groupMember);
            }
        }
        return y.b().b(arrayList);
    }
}
