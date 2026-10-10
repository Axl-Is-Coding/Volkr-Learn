package com.disabngo.blockynexus.e.b.F;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInviteCount;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupMemberModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener<GroupInviteCount> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f9269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f9270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f9271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f9272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ObservableField f9273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f9274f;
    final /* synthetic */ q g;

    p(q qVar, ObservableField observableField, ObservableField observableField2, ObservableField observableField3, ObservableField observableField4, ObservableField observableField5, Context context) {
        this.g = qVar;
        this.f9269a = observableField;
        this.f9270b = observableField2;
        this.f9271c = observableField3;
        this.f9272d = observableField4;
        this.f9273e = observableField5;
        this.f9274f = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInviteCount groupInviteCount) {
        if (groupInviteCount != null) {
            this.f9269a.set(Boolean.valueOf(groupInviteCount.getStatus() == 0));
            this.f9270b.set(Integer.valueOf(groupInviteCount.getDailyCount()));
            this.f9271c.set(Integer.valueOf(groupInviteCount.getInviteCount()));
            this.f9272d.set(Integer.valueOf(groupInviteCount.getInviteCount()));
            this.f9273e.set(this.f9274f.getString(R.string.new_group_invite_limit, String.valueOf(groupInviteCount.getDailyCount() - groupInviteCount.getInviteCount()), String.valueOf(groupInviteCount.getDailyCount())));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9274f, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9274f, i);
    }
}
