package com.disabngo.blockynexus.e.b.D;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.z.C0963b;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GroupInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class I extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GroupInfo f9169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GroupInfoParam f9172e;
    public A i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<GroupMember> f9173f = new ArrayList();
    private List<String> g = new ArrayList();
    public y h = new y();
    public ObservableField<String> j = new ObservableField<>();
    public ObservableField<Integer> k = new ObservableField<>();
    public ObservableField<Boolean> l = new ObservableField<>();
    public ObservableField<Boolean> m = new ObservableField<>();
    public ObservableField<Boolean> n = new ObservableField<>(false);
    public ObservableField<String> o = new ObservableField<>();
    public ObservableField<Boolean> p = new ObservableField<>(false);
    public ObservableField<String> q = new ObservableField<>();
    public ObservableField<Boolean> r = new ObservableField<>(true);
    public ObservableField<Boolean> s = new ObservableField<>(false);
    public ObservableField<Boolean> t = new ObservableField<>(false);
    public ObservableField<Boolean> u = new ObservableField<>(false);
    public ObservableField<Boolean> v = new ObservableField<>(false);
    public ObservableField<Boolean> w = new ObservableField<>(false);
    public ObservableField<Boolean> x = new ObservableField<>(false);
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.q
        @Override // rx.functions.Action0
        public final void call() {
            this.f9190a.m();
        }
    });
    public ReplyCommand z = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9177a.p();
        }
    });
    public ReplyCommand A = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.r
        @Override // rx.functions.Action0
        public final void call() {
            this.f9191a.F();
        }
    });
    public ReplyCommand B = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.o
        @Override // rx.functions.Action0
        public final void call() {
            this.f9188a.D();
        }
    });
    public ReplyCommand C = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f9182a.l();
        }
    });
    public ReplyCommand D = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f9179a.u();
        }
    });
    public ReplyCommand E = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.D.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f9184a.E();
        }
    });
    public ReplyCommand<Boolean> F = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.D.s
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9192a.a((Boolean) obj);
        }
    });

    public I(Context context, long j, boolean z) {
        this.f9168a = context;
        this.f9170c = j;
        this.s.set(Boolean.valueOf(z));
        this.f9172e = new GroupInfoParam();
        k();
        g(com.disabngo.blockynexus.d.y.b().b(j));
        initMessenger();
        this.i = new A(context, R.string.no_data, j, this.f9173f, com.disabngo.blockynexus.d.y.b().b(j));
        this.p.set(Boolean.valueOf(SharedUtils.getBoolean(context, String.valueOf(j), false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.s.get().booleanValue()) {
            N.a(this.f9168a, String.valueOf(this.f9170c), this.j.get(), false, this.f9169b.getGroupMembers().size());
        } else if (!this.m.get().booleanValue() || this.f9169b.getGroupMembers().size() <= 1) {
            new TwoButtonDialog(this.f9168a).setTitleText(R.string.group_notice_tip).setDetailText(R.string.group_quit_group_tip).setLeftButtonText(R.string.cancel).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.D.l
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f9185a.j();
                }
            }).show();
        } else {
            new TwoButtonDialog(this.f9168a).setTitleText(R.string.group_notice_tip).setDetailText(R.string.remind_owner_quit_group).setLeftButtonText(R.string.cancel).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.D.e
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f9178a.i();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        GroupInfo groupInfo = this.f9169b;
        if (groupInfo == null) {
            return;
        }
        N.a(String.valueOf(groupInfo.getGroupId()), !this.v.get().booleanValue(), new G(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Bundle bundle = new Bundle();
        bundle.putInt(StringConstant.TYPE_LIST_GROUP, 3);
        bundle.putParcelableArrayList(SharedConstant.KEY_GROUP_VIEW_ALL_MEMBER, (ArrayList) com.disabngo.blockynexus.d.y.b().c(this.f9173f));
        Context context = this.f9168a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.F.f.class, context.getString(R.string.group_all_members), bundle);
    }

    private void e(GroupInfo groupInfo) {
        this.f9169b = groupInfo;
        if (this.f9173f.size() == 0) {
            this.f9173f.addAll(groupInfo.getGroupMembers());
        }
        com.disabngo.blockynexus.d.y.b().e(this.f9169b);
        this.j.set(TextEllipsizeUtil.ellipsizeString(20, groupInfo.getGroupName(), TextEllipsizeUtil.SignLib.END_POINT));
        this.k.set(Integer.valueOf(groupInfo.getOfficialGroup()));
        this.n.set(Boolean.valueOf(groupInfo.getGroupMembers().size() > 18));
        Iterator<GroupMember> it = groupInfo.getGroupMembers().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupMember next = it.next();
            if (next.getUserId() == Long.valueOf(groupInfo.getOwnerId()).longValue()) {
                this.g.add(next.getUserName());
                this.g.add(next.getPic());
                break;
            }
        }
        this.q.set(groupInfo.getGroupPic());
        this.g.add(groupInfo.getReleaseTime());
    }

    private void f(GroupInfo groupInfo) {
        this.f9172e.setGroupId(groupInfo.getGroupId());
        this.f9172e.setGroupName(groupInfo.getGroupName());
        this.f9172e.setGroupNotice(groupInfo.getGroupNotice());
        this.f9172e.setInviterId(AccountCenter.newInstance().userId.get().longValue());
        this.f9172e.setInviteStatus(groupInfo.getInviteStatus());
        this.f9172e.setNoticePic(groupInfo.getNoticePic());
    }

    private void g(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        e(groupInfo);
        i(groupInfo);
        h(groupInfo);
        f(groupInfo);
    }

    private void h(GroupInfo groupInfo) {
        this.m.set(Boolean.valueOf(groupInfo.getOwnerId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))));
        this.r.set(Boolean.valueOf(com.disabngo.blockynexus.d.y.b().a(groupInfo.getGroupMembers(), AccountCenter.newInstance().userId.get().longValue())));
        this.t.set(Boolean.valueOf(com.disabngo.blockynexus.d.y.b().b(groupInfo.getGroupMembers(), AccountCenter.newInstance().userId.get().longValue())));
        this.u.set(Boolean.valueOf(this.t.get().booleanValue() || this.m.get().booleanValue()));
        this.x.set(true);
        this.f9171d = groupInfo.getOwnerId();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_TRANSFER_GROUP_OWNER, new Action0() { // from class: com.disabngo.blockynexus.e.b.D.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f9183a.f();
            }
        });
        Messenger.getDefault().register(this, "token.refresh.group.name", String.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.D.p
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9189a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_GROUP_NOTICE_STATE, GroupInfoParam.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.D.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9186a.a((GroupInfoParam) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_VIEW_ALL, new Action0() { // from class: com.disabngo.blockynexus.e.b.D.t
            @Override // rx.functions.Action0
            public final void call() {
                this.f9193a.h();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_GROUP_ADMIN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.D.u
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9194a.b((GroupInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_GROUP_INVITE_STATUS, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.D.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9187a.c((GroupInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_LIST_AFTER_BAN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.D.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9181a.d((GroupInfo) obj);
            }
        });
        Messenger.getDefault().register(this, "token.refresh.group.info", GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.D.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9180a.a((GroupInfo) obj);
            }
        });
    }

    private void k() {
        RongIM.getInstance().getConversation(Conversation.ConversationType.GROUP, String.valueOf(this.f9170c), new F(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        new D().a(this.f9168a, this.f9170c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ObservableField<Boolean> observableField = this.m;
        if (observableField == null || observableField.get() == null) {
            return;
        }
        if (this.m.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(SharedConstant.KEY_GROUP_INFO, this.f9172e);
            bundle.putInt(SharedConstant.KEY_GROUP_EDIT_TYPE, 0);
            Context context = this.f9168a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.C.g.class, context.getString(R.string.group_edit_name_title), bundle);
        } else {
            Context context2 = this.f9168a;
            AppToastUtils.showLongPositiveTipToast(context2, context2.getString(R.string.group_notice_tip_content));
        }
        ReportDataAdapter.onEvent(this.f9168a, EventConstant.GROUP_MODIFYNAME_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        List<String> list;
        ObservableField<Boolean> observableField = this.m;
        if (observableField == null || observableField.get() == null) {
            return;
        }
        if (this.m.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(SharedConstant.KEY_GROUP_INFO, this.f9172e);
            bundle.putInt(SharedConstant.KEY_GROUP_EDIT_TYPE, 1);
            Context context = this.f9168a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.C.g.class, context.getString(R.string.group_info_notice), bundle);
            ReportDataAdapter.onEvent(this.f9168a, EventConstant.GROUP_ANN_PAGE_LORD);
            return;
        }
        if (!this.l.get().booleanValue() || (list = this.g) == null || list.size() <= 0) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(SharedConstant.KEY_GROUP_INFO, this.f9172e);
        bundle2.putStringArrayList(SharedConstant.KEY_GROUP_OWNER, (ArrayList) this.g);
        Context context2 = this.f9168a;
        TemplateUtils.startTemplate(context2, com.disabngo.blockynexus.e.b.G.b.class, context2.getString(R.string.group_info_notice), bundle2);
        ReportDataAdapter.onEvent(this.f9168a, EventConstant.GROUP_ANN_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.disabngo.blockynexus.d.y.b().e(this.f9169b);
        Bundle bundle = new Bundle();
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9169b);
        Context context = this.f9168a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.E.u.class, context.getString(R.string.group_manager), bundle);
    }

    public /* synthetic */ void c(GroupInfo groupInfo) {
        this.f9169b = groupInfo;
        com.disabngo.blockynexus.d.y.b().e(groupInfo);
        this.f9172e.setInviteStatus(groupInfo.getInviteStatus());
    }

    public /* synthetic */ void d(GroupInfo groupInfo) {
        if (groupInfo != null) {
            this.f9169b = groupInfo;
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_MEMBERS_LIST);
        }
    }

    public /* synthetic */ void i() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9169b);
        bundle.putBoolean(SharedConstant.KEY_GROUP_TRANSFER, true);
        bundle.putInt(SharedConstant.KEY_GROUP_STATUS, 3);
        Context context = this.f9168a;
        TemplateUtils.startTemplate(context, C0963b.class, context.getString(R.string.group_manager_transfer), bundle);
    }

    public /* synthetic */ void j() {
        ReportDataAdapter.onEvent(this.f9168a, EventConstant.GROUP_QUIT_CLICK);
        GroupChatApi.quitGroup(this.f9168a, this.f9170c, this.j.get(), new H(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
        if (this.f9168a != null) {
            com.disabngo.blockynexus.d.y.b().e((GroupInfo) null);
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        N.a(Conversation.ConversationType.GROUP, String.valueOf(this.f9170c), bool.booleanValue());
    }

    public /* synthetic */ void b(GroupInfo groupInfo) {
        this.f9169b = groupInfo;
    }

    public /* synthetic */ void a(String str) {
        this.j.set(str);
        GroupInfo groupInfo = this.f9169b;
        if (groupInfo != null) {
            groupInfo.setGroupName(str);
            this.f9172e.setGroupName(str);
        }
    }

    private void i(GroupInfo groupInfo) {
        if (TextUtils.isEmpty(groupInfo.getGroupNotice()) && (groupInfo.getNoticePic() == null || groupInfo.getNoticePic().size() == 0)) {
            this.l.set(false);
            this.w.set(false);
            return;
        }
        this.l.set(true);
        if (TextUtils.isEmpty(groupInfo.getGroupNotice())) {
            this.w.set(false);
        } else {
            this.w.set(true);
            this.o.set(groupInfo.getGroupNotice());
        }
    }

    public /* synthetic */ void a(GroupInfoParam groupInfoParam) {
        if (TextUtils.isEmpty(groupInfoParam.getGroupNotice()) && (groupInfoParam.getNoticePic() == null || groupInfoParam.getNoticePic().size() == 0)) {
            this.l.set(false);
            this.w.set(false);
        } else {
            this.l.set(true);
            if (TextUtils.isEmpty(groupInfoParam.getGroupNotice())) {
                this.w.set(false);
            } else {
                this.w.set(true);
                this.o.set(groupInfoParam.getGroupNotice());
            }
        }
        this.f9172e.setGroupNotice(groupInfoParam.getGroupNotice());
        this.f9172e.setNoticePic(groupInfoParam.getNoticePic());
    }

    public /* synthetic */ void f() {
        Context context = this.f9168a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public /* synthetic */ void h() {
        if (this.n.get().booleanValue()) {
            this.n.set(false);
        }
    }

    public /* synthetic */ void a(GroupInfo groupInfo) {
        if (groupInfo != null) {
            g(groupInfo);
        }
    }
}
