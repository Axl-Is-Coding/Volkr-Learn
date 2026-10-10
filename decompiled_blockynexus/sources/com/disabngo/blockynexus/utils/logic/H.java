package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends RongIMClient.ResultCallback<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f10529b;

    H(I i, Context context) {
        this.f10529b = i;
        this.f10528a = context;
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Boolean bool) {
        ReportDataAdapter.onEvent(this.f10528a, EventConstant.CHAT_DELETE_CHAT);
    }
}
