package com.disabngo.blockynexus.e.b.A;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.view.dialog.BottomDialog;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GroupBannedViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BottomDialog f9104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GroupInfo f9105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f9106d = new i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f9107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<GroupMember> f9108f;

    public m(Context context, GroupInfo groupInfo) {
        this.f9103a = context;
        if (groupInfo != null) {
            this.f9105c = groupInfo;
            this.f9108f = new ArrayList();
            this.f9108f.addAll(new l().a(groupInfo));
            this.f9107e = new j(context, R.string.no_data, groupInfo.getGroupId(), this.f9108f);
        }
        initMessenger();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_LIST_AFTER_BAN, GroupInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.A.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9089a.a((GroupInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SHOW_BAN_BOTTOM_DIALOG, Long.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.A.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9093a.a((Long) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_BAN_BOTTOM_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.e.b.A.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f9092a.f();
            }
        });
    }

    public /* synthetic */ void a(GroupInfo groupInfo) {
        if (groupInfo != null) {
            this.f9108f.clear();
            this.f9108f.addAll(new l().a(groupInfo));
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_BAN_LIST);
        }
    }

    public /* synthetic */ void f() {
        this.f9104b.dismiss();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(final Long l) {
        this.f9104b = new BottomDialog(this.f9103a).a(this.f9103a.getString(R.string.new_group_remove_ban), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.A.d
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f9090a.a(l, bottomDialog);
            }
        });
        this.f9104b.show();
    }

    public /* synthetic */ void a(Long l, BottomDialog bottomDialog) {
        new l().a(this.f9103a, this.f9105c.getGroupId(), l.longValue());
    }
}
