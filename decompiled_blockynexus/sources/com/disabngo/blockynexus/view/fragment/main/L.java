package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.StatusBean;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: OtherWayEnterGameLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class L extends OnResponseListener<StatusBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f11776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f11777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f11778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnDataListener f11779d;

    L(long j, Context context, boolean z, OnDataListener onDataListener) {
        this.f11776a = j;
        this.f11777b = context;
        this.f11778c = z;
        this.f11779d = onDataListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StatusBean statusBean) {
        if (statusBean != null) {
            long j = this.f11776a;
            if (j != 0) {
                Q.a(this.f11777b, j, statusBean, this.f11778c);
                OnDataListener onDataListener = this.f11779d;
                if (onDataListener != null) {
                    onDataListener.onSuccess(statusBean);
                    return;
                }
                return;
            }
        }
        AppToastUtils.showShortNegativeTipToast(this.f11777b, R.string.follow_friend_is_finish);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 10113) {
            AppToastUtils.showShortNegativeTipToast(this.f11777b, R.string.follow_friend_not_allow_follow);
        } else {
            FriendOnError.showErrorTip(this.f11777b, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11777b, i);
    }
}
