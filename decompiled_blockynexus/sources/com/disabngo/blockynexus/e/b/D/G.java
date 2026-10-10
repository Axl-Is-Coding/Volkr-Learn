package com.disabngo.blockynexus.e.b.D;

import com.sandboxol.common.utils.AppToastUtils;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: GroupInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class G extends RongIMClient.ResultCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f9166a;

    G(I i) {
        this.f9166a = i;
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
        AppToastUtils.showShortNegativeTipToast(this.f9166a.f9168a, errorCode.getMessage());
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Boolean bool) {
        this.f9166a.v.set(Boolean.valueOf(!r2.get().booleanValue()));
    }
}
