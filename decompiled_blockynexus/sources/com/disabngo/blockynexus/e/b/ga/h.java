package com.disabngo.blockynexus.e.b.ga;

import android.app.Activity;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;

/* JADX INFO: compiled from: SecretQuestionUnbindViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9793a;

    h(j jVar) {
        this.f9793a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9793a.f9795a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f9793a.f9795a, HttpUtils.getHttpErrorMsg(this.f9793a.f9795a, i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AccountCenter.newInstance().isFinishSecretQuestion.set(false);
        AccountCenter.putAccountInfo();
        ((Activity) this.f9793a.f9795a).finish();
    }
}
