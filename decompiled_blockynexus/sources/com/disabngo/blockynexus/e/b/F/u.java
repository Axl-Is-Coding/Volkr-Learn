package com.disabngo.blockynexus.e.b.F;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.F.h;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.entity.GroupParam;
import com.disabngo.blockynexus.entity.GroupRemoveParam;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.view.dialog.PayGdiamondDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupMemberViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends ViewModel implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9279b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f9281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9283f;
    public List<GroupMember> h;
    public int j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f9280c = new i();
    public List<Long> g = new ArrayList();
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.F.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9245a.k();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.F.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9242a.i();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.F.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9244a.j();
        }
    });
    public ObservableField<Boolean> n = new ObservableField<>(false);
    public ObservableField<Boolean> o = new ObservableField<>(false);
    public ObservableField<Boolean> p = new ObservableField<>(false);
    public ObservableField<Integer> q = new ObservableField<>(0);
    public ObservableField<Integer> r = new ObservableField<>(1);
    public ObservableField<Integer> s = new ObservableField<>(1);
    public ObservableField<String> t = new ObservableField<>("");
    public ObservableField<Boolean> u = new ObservableField<>(false);
    public ObservableField<Integer> v = new ObservableField<>(0);
    public ObservableField<Integer> w = new ObservableField<>(0);
    public ObservableField<Integer> x = new ObservableField<>(0);
    private q i = new q();

    public u(Context context, int i, List<GroupMember> list, long j, String str, int i2) {
        this.f9278a = context;
        this.f9279b = i;
        this.f9282e = j;
        this.f9283f = str;
        this.h = list;
        this.j = i2;
        int i3 = this.f9279b;
        int i4 = (i3 == 0 || i3 == 1) ? R.string.group_no_friend : R.string.group_remove_empty;
        h();
        this.f9281d = new n(context, i4, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.n.set(false);
        GroupParam groupParam = new GroupParam();
        groupParam.setCost(this.q.get().intValue());
        groupParam.setCurrency((this.q.get().intValue() == 0 ? this.s : this.r).get().intValue());
        groupParam.setUserId(AccountCenter.newInstance().userId.get().longValue());
        groupParam.setMemberIds(this.g);
        GroupChatApi.createGroupChat(this.f9278a, groupParam, new r(this));
    }

    private void h() {
        int i = this.f9279b;
        if (i == 0) {
            this.i.a(this.f9278a, this.r, this.q, this.s);
            ReportDataAdapter.onEvent(this.f9278a, EventConstant.ENTER_START_GCHAT);
        } else if (i == 1) {
            this.i.a(this.f9278a, this.f9282e, this.v, this.w, this.x, this.u, this.t);
            ReportDataAdapter.onEvent(this.f9278a, EventConstant.GROUP_INVITE_PAGE);
        } else {
            if (i != 2) {
                return;
            }
            ReportDataAdapter.onEvent(this.f9278a, EventConstant.GROUP_KICK_PAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ReportDataAdapter.onEvent(this.f9278a, EventConstant.GROUP_INVITE_CLICK);
        this.i.a(this.f9278a, this.f9282e, this.g, new s(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.g.size() > 0) {
            ReportDataAdapter.onEvent(this.f9278a, EventConstant.GROUP_KICK_CLICK);
            GroupRemoveParam groupRemoveParam = new GroupRemoveParam();
            groupRemoveParam.setGroupId(this.f9282e);
            groupRemoveParam.setInviterId(AccountCenter.newInstance().userId.get().longValue());
            groupRemoveParam.setMemberIds(this.g);
            groupRemoveParam.setGroupName(this.f9283f);
            GroupChatApi.removeMemberFromGroup(this.f9278a, groupRemoveParam, new t(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.g.size() > 0) {
            ReportDataAdapter.onEvent(this.f9278a, EventConstant.GROUP_CLICK_START);
            if (this.r.get().intValue() == 2 || this.q.get().intValue() <= AccountCenter.newInstance().diamonds.get().longValue() || this.q.get().intValue() <= 0) {
                f();
            } else {
                DialogUtils.newsInstant().showPayGdiamondDialog(this.f9278a, (int) (((long) this.q.get().intValue()) - AccountCenter.newInstance().diamonds.get().longValue()), new PayGdiamondDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.F.c
                    @Override // com.sandboxol.center.view.dialog.PayGdiamondDialog.OnTwoButtonDialogClickListener
                    public final void onClick() {
                        this.f9243a.f();
                    }
                }, null);
            }
        }
    }

    public void b(int i) {
        this.i.a(this.f9278a, this.t, this.v.get().intValue(), this.w, i);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
    }
}
