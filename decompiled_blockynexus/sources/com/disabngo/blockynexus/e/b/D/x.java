package com.disabngo.blockynexus.e.b.D;

import android.content.Context;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupInfoItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class x extends ListItemViewModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9200a;

    public x(Context context, GroupMember groupMember) {
        super(context, groupMember);
        this.f9200a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f9175a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (((GroupMember) this.item).getUserId() == 32 || ((GroupMember) this.item).getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
            return;
        }
        J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((GroupMember) this.item).getUserId(), 2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupMember getItem() {
        return (GroupMember) super.getItem();
    }
}
