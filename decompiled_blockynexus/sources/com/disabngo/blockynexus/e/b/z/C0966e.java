package com.disabngo.blockynexus.e.b.z;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.D.y;
import com.disabngo.blockynexus.entity.GroupAdminsParam;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.z.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GroupAdminManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0966e extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GroupInfo f10407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Long> f10408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10409d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0964c f10411f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f10410e = new y();
    public ObservableField<Boolean> g = new ObservableField<>(false);
    public ObservableField<Boolean> h = new ObservableField<>(false);
    public ObservableField<String> i = new ObservableField<>();
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.z.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f10400a.h();
        }
    });

    public C0966e(Context context, int i, GroupInfo groupInfo) {
        this.f10408c = new ArrayList();
        this.f10406a = context;
        this.h.set(false);
        this.f10407b = groupInfo;
        this.f10409d = i;
        List<GroupMember> listD = com.disabngo.blockynexus.d.y.b().d(groupInfo);
        ArrayList<GroupMember> arrayListA = com.disabngo.blockynexus.d.y.b().a(groupInfo, false);
        this.f10408c = com.disabngo.blockynexus.d.y.b().a(groupInfo);
        if (i == 1) {
            this.h.set(true);
            this.f10411f = new C0964c(context, R.string.no_data, 1, listD, this.f10408c);
        } else if (i == 2) {
            this.f10411f = new C0964c(context, R.string.no_data, 2, arrayListA, this.f10408c);
        } else {
            this.f10411f = new C0964c(context, R.string.no_data, 3, listD, this.f10408c);
        }
        f();
    }

    private void f() {
        int i = this.f10409d;
        if (i != 1) {
            if (i == 3) {
                this.i.set(this.f10406a.getResources().getString(R.string.select_transfer_object));
                this.g.set(true);
                return;
            }
            return;
        }
        this.i.set(this.f10406a.getResources().getString(R.string.admi) + "(" + com.disabngo.blockynexus.d.y.b().a(this.f10407b, false).size() + "/5)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ReportDataAdapter.onEvent(this.f10406a, EventConstant.GROUP_ADMIN);
        GroupAdminsParam groupAdminsParam = new GroupAdminsParam();
        groupAdminsParam.setGroupId(this.f10407b.getGroupId());
        groupAdminsParam.setInviterId(AccountCenter.newInstance().userId.get().longValue());
        groupAdminsParam.setMemberIds(this.f10408c);
        groupAdminsParam.setOperationType(!this.h.get().booleanValue() ? 1 : 0);
        GroupChatApi.setGroupManager(this.f10406a, groupAdminsParam, new C0965d(this, groupAdminsParam));
    }
}
