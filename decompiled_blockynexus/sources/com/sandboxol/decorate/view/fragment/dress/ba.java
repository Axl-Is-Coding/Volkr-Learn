package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressItemModel.java */
/* JADX INFO: loaded from: classes3.dex */
class ba extends OnResponseListener<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f17409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f17410b;

    ba(long j, Context context) {
        this.f17409a = j;
        this.f17410b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(SingleDressInfo singleDressInfo) {
        com.sandboxol.decorate.manager.v.a().g(this.f17409a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.decorate.web.u.a(this.f17410b, i);
        AppToastUtils.showShortNegativeTipToast(this.f17410b, R.string.decorate_dress_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f17410b, R.string.decorate_dress_failed);
        ServerOnError.showOnServerError(this.f17410b, i);
    }
}
