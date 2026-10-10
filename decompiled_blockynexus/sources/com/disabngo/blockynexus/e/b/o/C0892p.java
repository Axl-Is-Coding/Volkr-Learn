package com.disabngo.blockynexus.e.b.o;

import android.content.Context;
import android.util.Log;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0892p extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f10005b;

    C0892p(v vVar, Context context) {
        this.f10005b = vVar;
        this.f10004a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.d("RongIM_getToken", str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.d("RongIM_getToken", "error:" + i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        if (str != null) {
            SharedUtils.putLong(this.f10004a, StringConstant.RONG_CHAT_TOKEN_EXPIRY_TIME, System.currentTimeMillis());
            SharedUtils.putString(this.f10004a, StringConstant.RONG_CHAT_TOKEN, str);
            N.a(this.f10004a, str);
        }
        Log.d("RongIM_getToken", str);
    }
}
