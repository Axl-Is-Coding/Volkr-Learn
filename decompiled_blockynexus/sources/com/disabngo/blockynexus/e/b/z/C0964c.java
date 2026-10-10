package com.disabngo.blockynexus.e.b.z;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.E.t;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.z.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GroupAdminManageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0964c extends DataListModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<GroupMember> f10401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Long> f10402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10403c;

    public C0964c(Context context, int i, int i2, List<GroupMember> list, List<Long> list2) {
        super(context, i);
        this.f10401a = list;
        this.f10403c = i2;
        this.f10402b = list2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupMember> getItemViewModel(GroupMember groupMember) {
        int i = this.f10403c;
        return i == 1 ? new t(this.context, groupMember, 3, this.f10402b) : i == 2 ? new t(this.context, groupMember, 4, this.f10402b) : new t(this.context, groupMember, 5, this.f10402b);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<GroupMember> listItemViewModel) {
        gVar.a(326, R.layout.item_group_admi_list);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GroupMember>> onResponseListener) {
        List<GroupMember> list = this.f10401a;
        if (list != null) {
            onResponseListener.onSuccess(list);
        }
    }
}
