package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.AppToastUtils;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends RongIMClient.ResultCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10556a;

    s(Context context) {
        this.f10556a = context;
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
        AppToastUtils.showLongPositiveTipToast(this.f10556a, R.string.add_blacklist_fail);
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Boolean bool) {
        AppToastUtils.showLongPositiveTipToast(this.f10556a, R.string.add_blacklist_success);
    }
}
