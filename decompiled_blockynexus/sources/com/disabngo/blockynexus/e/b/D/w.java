package com.disabngo.blockynexus.e.b.D;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupInfoInviteItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends ListItemViewModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<GroupMember> f9197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9199d;

    public w(Context context, GroupMember groupMember, List<GroupMember> list, long j, int i) {
        super(context, groupMember);
        this.f9196a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9174a.f();
            }
        });
        this.f9197b = list;
        this.f9198c = j;
        this.f9199d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt(StringConstant.TYPE_LIST_GROUP, 1);
        bundle.putParcelableArrayList(SharedConstant.KEY_GROUP_VIEW_ALL_MEMBER, (ArrayList) this.f9197b);
        bundle.putLong(StringConstant.KEY_ID_GROUP, this.f9198c);
        bundle.putInt(SharedConstant.KEY_GROUP_IDENTITY, this.f9199d);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.F.f.class, context.getString(R.string.group_invite_friends), bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupMember getItem() {
        return (GroupMember) super.getItem();
    }
}
