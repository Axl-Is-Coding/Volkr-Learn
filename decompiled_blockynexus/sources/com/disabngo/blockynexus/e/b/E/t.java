package com.disabngo.blockynexus.e.b.E;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.entity.GroupTransferParam;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: GroupAdminItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends ListItemViewModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f9227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f9228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9229c;
    public Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Long> f9230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f9231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9232f;
    private GroupInfo g;

    public t(Context context, GroupMember groupMember) {
        super(context, groupMember);
        this.f9227a = new ObservableField<>(false);
        this.f9228b = new ObservableField<>(false);
        this.f9231e = new ObservableField<>();
        this.f9232f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f9209a.h();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        if (((GroupMember) this.item).getIdentity() == 1) {
            this.f9231e.set(this.context.getResources().getString(R.string.admi));
        } else {
            int vip = ((GroupMember) this.item).getVip();
            if (vip == 1) {
                this.f9231e.set("vip");
            } else if (vip == 2) {
                this.f9231e.set("vip+");
            } else if (vip == 3) {
                this.f9231e.set("mvp");
            }
        }
        int i = this.f9229c;
        if (i == 3) {
            if (((GroupMember) this.item).getIdentity() > 0) {
                this.f9227a.set(false);
                return;
            } else {
                this.f9227a.set(true);
                return;
            }
        }
        if (i == 4) {
            this.f9227a.set(true);
        } else {
            this.f9227a.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (this.f9229c == 5) {
            new TwoButtonDialog(this.context).setDetailText(this.context.getString(R.string.hint_transfer_group, ((GroupMember) this.item).getUserName())).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.E.g
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f9210a.i();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        ReportDataAdapter.onEvent(this.context, EventConstant.GROUP_MASTER_TRANSFER);
        this.g = y.b().f();
        if (this.g == null) {
            return;
        }
        GroupTransferParam groupTransferParam = new GroupTransferParam();
        groupTransferParam.setUserId(((GroupMember) this.item).getUserId());
        groupTransferParam.setGroupId(this.g.getGroupId());
        try {
            groupTransferParam.setInviterId(Long.parseLong(this.g.getOwnerId()));
        } finally {
            GroupChatApi.transferGroupOwner(this.context, groupTransferParam, new s(this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if (this.f9230d == null) {
            return;
        }
        CheckBox checkBox = (CheckBox) view;
        long userId = ((GroupMember) this.item).getUserId();
        int i = this.f9229c;
        if (i != 3) {
            if (i == 4) {
                if (!checkBox.isChecked()) {
                    this.f9230d.remove(Long.valueOf(userId));
                    return;
                } else if (this.f9230d.contains(Long.valueOf(userId))) {
                    this.f9230d.remove(Long.valueOf(userId));
                    return;
                } else {
                    this.f9230d.add(Long.valueOf(userId));
                    return;
                }
            }
            return;
        }
        if (!checkBox.isChecked()) {
            this.f9228b.set(false);
            if (this.f9230d.contains(Long.valueOf(userId))) {
                this.f9230d.remove(Long.valueOf(userId));
                return;
            }
            return;
        }
        if (this.f9230d.size() < 5) {
            this.f9230d.add(Long.valueOf(userId));
            this.f9228b.set(true);
        } else {
            checkBox.setChecked(false);
            this.f9228b.set(false);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GroupMember getItem() {
        return (GroupMember) super.getItem();
    }

    public t(Context context, GroupMember groupMember, int i, List<Long> list) {
        super(context, groupMember);
        this.f9227a = new ObservableField<>(false);
        this.f9228b = new ObservableField<>(false);
        this.f9231e = new ObservableField<>();
        this.f9232f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.E.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f9209a.h();
            }
        });
        this.context = context;
        this.f9229c = i;
        this.f9230d = list;
        f();
    }
}
