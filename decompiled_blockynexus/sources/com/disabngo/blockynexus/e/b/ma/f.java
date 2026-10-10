package com.disabngo.blockynexus.e.b.ma;

import android.content.Context;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeClanMembersBean;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeDetailLeaderItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends ListItemViewModel<TribeClanMembersBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f9938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9939b;

    public f(Context context, TribeClanMembersBean tribeClanMembersBean, int i) {
        super(context, tribeClanMembersBean);
        this.f9938a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ma.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9934a.f();
            }
        });
        this.f9939b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (((TribeClanMembersBean) this.item).getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
            J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((TribeClanMembersBean) this.item).getUserId(), 2), this.f9939b);
        }
    }
}
