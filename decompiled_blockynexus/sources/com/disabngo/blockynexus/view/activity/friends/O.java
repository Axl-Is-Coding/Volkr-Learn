package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.StatusBean;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class O extends OnResponseListener<StatusBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f10661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f10662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f10663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ObservableField f10664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ P f10665f;

    O(P p, int i, ObservableField observableField, ObservableField observableField2, Context context, ObservableField observableField3) {
        this.f10665f = p;
        this.f10660a = i;
        this.f10661b = observableField;
        this.f10662c = observableField2;
        this.f10663d = context;
        this.f10664e = observableField3;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StatusBean statusBean) {
        if (statusBean == null) {
            return;
        }
        if (statusBean.getPartyInfo() != null && statusBean.getPartyInfo().getCaptainId() != 0) {
            if (this.f10660a == 0) {
                this.f10661b.set(Boolean.valueOf(AppInfoCenter.newInstance().getAppConfig().isShowFriendFollow()));
            } else {
                this.f10661b.set(false);
            }
            this.f10662c.set(this.f10663d.getString(R.string.party_doing));
            com.disabngo.blockynexus.d.n.n(this.f10663d);
        }
        if (statusBean.getGamingInfo() != null) {
            if (this.f10660a == 0) {
                this.f10661b.set(Boolean.valueOf(AppInfoCenter.newInstance().getAppConfig().isShowFriendFollow()));
            } else {
                this.f10661b.set(false);
            }
            this.f10662c.set(this.f10663d.getString(R.string.friend_status_gaming));
            com.disabngo.blockynexus.d.n.n(this.f10663d);
        }
        this.f10664e.set(statusBean);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
