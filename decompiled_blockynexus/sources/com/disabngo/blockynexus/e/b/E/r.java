package com.disabngo.blockynexus.e.b.E;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.D.y;
import com.disabngo.blockynexus.e.b.z.C0963b;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GroupAdmiViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9220a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f9223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GroupInfo f9224e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<GroupMember> f9221b = new ObservableField<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f9222c = new y();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9225f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9206a.h();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9207a.i();
        }
    });
    public ObservableField<Boolean> h = new ObservableField<>(false);

    public r(Context context, GroupInfo groupInfo) {
        this.f9220a = context;
        this.f9224e = groupInfo;
        this.f9223d = new q(context, R.string.no_data, groupInfo);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        GroupInfo groupInfo = this.f9224e;
        if (groupInfo == null) {
            return;
        }
        if (groupInfo.getGroupMembers().size() < 2) {
            AppToastUtils.showShortNegativeTipToast(this.f9220a, R.string.toast_no_groupmember);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(SharedConstant.KEY_GROUP_MANAGER, true);
        bundle.putInt(SharedConstant.KEY_GROUP_STATUS, 1);
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9224e);
        Context context = this.f9220a;
        TemplateUtils.startTemplate(context, C0963b.class, context.getString(R.string.add_admin), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f9224e == null) {
            return;
        }
        if (com.disabngo.blockynexus.d.y.b().a(this.f9224e, false).size() == 0) {
            AppToastUtils.showShortNegativeTipToast(this.f9220a, R.string.toast_no_admins);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(SharedConstant.KEY_GROUP_MANAGER, false);
        bundle.putParcelable(SharedConstant.KEY_GROUP_INFO, this.f9224e);
        bundle.putInt(SharedConstant.KEY_GROUP_STATUS, 2);
        Context context = this.f9220a;
        TemplateUtils.startTemplate(context, C0963b.class, context.getString(R.string.delete_admin), bundle);
    }

    private void j() {
        GroupMember groupMemberB = com.disabngo.blockynexus.d.y.b().b(this.f9224e);
        if (this.f9224e.getOwnerId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
            this.h.set(true);
        } else {
            this.h.set(false);
        }
        this.f9221b.set(groupMemberB);
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_GROUP_ADMIN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.E.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9205a.a((GroupInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_TRANSFER_GROUP_OWNER, new Action0() { // from class: com.disabngo.blockynexus.e.b.E.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f9208a.f();
            }
        });
    }

    public /* synthetic */ void a(GroupInfo groupInfo) {
        this.f9224e = groupInfo;
    }

    public /* synthetic */ void f() {
        Context context = this.f9220a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
