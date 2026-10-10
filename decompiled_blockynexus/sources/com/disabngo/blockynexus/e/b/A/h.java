package com.disabngo.blockynexus.e.b.A;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupBannedItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ListItemViewModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f9096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9097c;
    public Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9098d;

    public h(Context context, GroupMember groupMember, long j) {
        super(context, groupMember);
        this.f9096b = new ObservableField<>(false);
        this.f9097c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.A.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9087a.h();
            }
        });
        this.f9098d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.A.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f9088a.f();
            }
        });
        this.context = context;
        this.f9095a = j;
        if (groupMember != null) {
            this.f9096b.set(Boolean.valueOf(groupMember.getBanStatus() != 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (this.f9096b.get().booleanValue()) {
            Messenger.getDefault().send(Long.valueOf(((GroupMember) this.item).getUserId()), MessageToken.TOKEN_SHOW_BAN_BOTTOM_DIALOG);
            return;
        }
        ReportDataAdapter.onEvent(this.context, EventConstant.GROUP_BAN);
        Bundle bundle = new Bundle();
        bundle.putLong("key.group.id", this.f9095a);
        bundle.putLong(SharedConstant.KEY_GROUP_MEMBER_ID, ((GroupMember) this.item).getUserId());
        bundle.putString(SharedConstant.KEY_GROUP_MEMBER_NAME, ((GroupMember) this.item).getUserName());
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.view.fragment.groupbannedtimelist.c.class, context.getString(R.string.new_group_ban_time_title), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (((GroupMember) this.item).getUserId() == 32 || ((GroupMember) this.item).getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
            return;
        }
        Long lValueOf = 0L;
        try {
            lValueOf = Long.valueOf(((GroupMember) this.item).getUserId());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        J.a(this.context, (Friend) null, new FriendActivityIntentInfo(lValueOf.longValue(), 2));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupMember getItem() {
        return (GroupMember) super.getItem();
    }
}
