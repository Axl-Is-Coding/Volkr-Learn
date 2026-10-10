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

/* JADX INFO: compiled from: GroupInfoRemoveItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class E extends ListItemViewModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<GroupMember> f9162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9164d;

    public E(Context context, GroupMember groupMember, List<GroupMember> list, long j, String str) {
        super(context, groupMember);
        this.f9161a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f9176a.f();
            }
        });
        this.f9162b = list;
        this.f9163c = j;
        this.f9164d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt(StringConstant.TYPE_LIST_GROUP, 2);
        bundle.putParcelableArrayList(SharedConstant.KEY_GROUP_VIEW_ALL_MEMBER, (ArrayList) this.f9162b);
        bundle.putLong(StringConstant.KEY_ID_GROUP, this.f9163c);
        bundle.putString(StringConstant.KEY_NAME_GROUP, this.f9164d);
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.F.f.class, context.getString(R.string.group_remove_friends), bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupMember getItem() {
        return (GroupMember) super.getItem();
    }
}
