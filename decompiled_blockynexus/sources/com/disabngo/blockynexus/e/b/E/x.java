package com.disabngo.blockynexus.e.b.E;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.D.y;
import com.disabngo.blockynexus.e.b.z.C0963b;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GroupManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class x extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GroupInfo f9235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f9236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GroupInfoParam f9237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f9238d = new y();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f9239e = new ObservableField<>(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f9240f = new ObservableField<>();
    public ObservableField<String> g = new ObservableField<>();
    public ObservableField<String> h = new ObservableField<>();
    public ObservableField<Integer> i = new ObservableField<>();
    public ObservableField<Boolean> j = new ObservableField<>(false);
    public ObservableField<Integer> k = new ObservableField<>(0);
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f9216a.p();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f9215a.k();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f9211a.h();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f9213a.m();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f9212a.l();
        }
    });

    public x(Context context, GroupInfo groupInfo) {
        this.f9236b = context;
        this.f9235a = groupInfo;
        initMessenger();
        j();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f9237c.setInviteStatus(this.f9239e.get().intValue() == 0 ? 1 : 0);
        GroupChatApi.updateGroupInfo(this.f9236b, this.f9237c, new v(this));
    }

    private void i() {
        int inviteStatus = this.f9235a.getInviteStatus();
        this.f9239e.set(Integer.valueOf(inviteStatus));
        this.k.set(Integer.valueOf(this.f9235a.getForbiddenWordsStatus()));
        this.f9237c = new GroupInfoParam();
        this.f9237c.setInviteStatus(inviteStatus);
        this.f9237c.setGroupId(this.f9235a.getGroupId());
        this.f9237c.setGroupName(this.f9235a.getGroupName());
        this.f9237c.setGroupNotice(this.f9235a.getGroupNotice());
        this.f9237c.setInviterId(Long.parseLong(this.f9235a.getOwnerId()));
        this.f9237c.setNoticePic(this.f9235a.getNoticePic());
        this.f9237c.setGroupPic(this.f9235a.getGroupPic());
        this.j.set(Boolean.valueOf(this.f9235a.getOwnerId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))));
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_GROUP_ADMIN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.E.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9217a.a((GroupInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_TRANSFER_GROUP_OWNER, new Action0() { // from class: com.disabngo.blockynexus.e.b.E.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f9218a.f();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_LIST_AFTER_BAN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.E.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9214a.b((GroupInfo) obj);
            }
        });
    }

    private void j() {
        List listA = com.disabngo.blockynexus.d.y.b().a(this.f9235a, false);
        if (listA.size() >= 3) {
            listA = listA.subList(0, 3);
        }
        this.i.set(Integer.valueOf(listA.size()));
        for (int i = 0; i < listA.size(); i++) {
            GroupMember groupMember = (GroupMember) listA.get(i);
            if (i == 0) {
                this.h.set(groupMember.getPic());
            } else if (i == 1) {
                this.g.set(groupMember.getPic());
            } else if (i == 2) {
                this.f9240f.set(groupMember.getPic());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f9235a == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9235a);
        Context context = this.f9236b;
        TemplateUtils.startTemplate(context, p.class, context.getString(R.string.admi), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        GroupChatApi.banOrUnbanAllMember(this.f9236b, this.f9235a.getGroupId(), new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9235a);
        Context context = this.f9236b;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.A.g.class, context.getString(R.string.new_group_banned_title), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        GroupInfo groupInfo = this.f9235a;
        if (groupInfo == null) {
            return;
        }
        if (groupInfo.getGroupMembers().size() < 2) {
            AppToastUtils.showShortNegativeTipToast(this.f9236b, R.string.toast_no_groupmember);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9235a);
        bundle.putBoolean(SharedConstant.KEY_GROUP_TRANSFER, true);
        bundle.putInt(SharedConstant.KEY_GROUP_STATUS, 3);
        Context context = this.f9236b;
        TemplateUtils.startTemplate(context, C0963b.class, context.getString(R.string.group_manager_transfer), bundle);
    }

    public /* synthetic */ void f() {
        Context context = this.f9236b;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void b(GroupInfo groupInfo) {
        if (groupInfo != null) {
            this.f9235a = groupInfo;
        }
    }

    public /* synthetic */ void a(GroupInfo groupInfo) {
        this.f9235a = groupInfo;
        j();
    }
}
