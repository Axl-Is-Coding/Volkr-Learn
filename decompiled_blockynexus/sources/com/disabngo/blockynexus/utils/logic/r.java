package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.AppToastUtils;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends RongIMClient.ResultCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10555a;

    r(Context context) {
        this.f10555a = context;
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
        AppToastUtils.showLongPositiveTipToast(this.f10555a, R.string.delete_friend_failed);
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Boolean bool) {
        AppToastUtils.showLongPositiveTipToast(this.f10555a, R.string.delete_friend_success);
    }
}
