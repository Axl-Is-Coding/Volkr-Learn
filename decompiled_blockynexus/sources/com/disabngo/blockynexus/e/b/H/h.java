package com.disabngo.blockynexus.e.b.H;

import android.content.Context;
import android.os.Bundle;
import android.text.Spanned;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.D.v;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.GroupRequest;
import com.disabngo.blockynexus.entity.JoinGroupRequest;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.ColorTextHelper;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupVerificationItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ListItemViewModel<GroupRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f9301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f9302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f9303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Spanned> f9304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f9305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9306f;
    public ReplyCommand g;
    public ReplyCommand h;

    public h(Context context, GroupRequest groupRequest) {
        super(context, groupRequest);
        this.f9301a = new ObservableField<>(h());
        this.f9302b = new ObservableField<>(Boolean.valueOf(i()));
        this.f9303c = new ObservableField<>(true);
        this.f9304d = new ObservableField<>();
        this.f9305e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.H.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f9297a.l();
            }
        });
        this.f9306f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.H.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9295a.k();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.H.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f9296a.m();
            }
        });
        this.h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.H.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f9298a.p();
            }
        });
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        Bundle bundle = new Bundle();
        bundle.putString("key.group.id", String.valueOf(((GroupRequest) this.item).getGroupId()));
        Context context = this.context;
        TemplateUtils.startTemplate(context, v.class, context.getString(R.string.group_info), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void p() {
        if (((GroupRequest) this.item).getUserId() == 32 || ((GroupRequest) this.item).getUserId() == AccountCenter.newInstance().userId.get().longValue()) {
            return;
        }
        J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((GroupRequest) this.item).getUserId(), 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JoinGroupRequest f() {
        JoinGroupRequest joinGroupRequest = new JoinGroupRequest();
        joinGroupRequest.setGroupId(((GroupRequest) this.item).getGroupId());
        joinGroupRequest.setOperateId(((GroupRequest) this.item).getUserId());
        joinGroupRequest.setType(((GroupRequest) this.item).getType());
        joinGroupRequest.setUserId(AccountCenter.newInstance().userId.get().longValue());
        return joinGroupRequest;
    }

    private String h() {
        int status = getItem().getStatus();
        return status != 0 ? status != 1 ? status != 2 ? "" : this.context.getString(R.string.refuse_add_friend) : this.context.getString(R.string.agree_add_friend) : "";
    }

    private boolean i() {
        int status = getItem().getStatus();
        if (status != 0) {
            return status == 1 || status == 2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j() {
        int type = ((GroupRequest) this.item).getType();
        String string = (type == 0 || type != 1) ? this.context.getString(R.string.new_group_apply_to_group) : this.context.getString(R.string.new_group_invite_to_group);
        this.f9304d.set(new ColorTextHelper.Builder().appendText(((GroupRequest) this.item).getNickName(), R.color.NewGroupNickNameTextColor).appendText(string, R.color.itemTextDefaultColor).appendText(TextEllipsizeUtil.ellipsizeString(16, ((GroupRequest) this.item).getGroupName(), TextEllipsizeUtil.SignLib.END_POINT), R.color.NewGroupNickNameTextColor).create().getColorText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f9303c.set(false);
        j.a(this.context, f(), new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f9303c.set(false);
        j.b(this.context, f(), new f(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupRequest getItem() {
        return (GroupRequest) super.getItem();
    }
}
