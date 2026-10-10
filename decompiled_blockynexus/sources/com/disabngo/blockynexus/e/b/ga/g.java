package com.disabngo.blockynexus.e.b.ga;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;

/* JADX INFO: compiled from: SecretQuestionUnbindViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f9792a;

    g(j jVar) {
        this.f9792a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9792a.f9795a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f9792a.f9795a, HttpUtils.getHttpErrorMsg(this.f9792a.f9795a, i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f9792a.i.set(true);
        String string = this.f9792a.f9795a.getResources().getString(R.string.send_verify_email_tips);
        j jVar = this.f9792a;
        jVar.g.set(String.format(string, String.format("%s*****@%s", jVar.f9797c.getEmail().split("@")[0].substring(0, 4), this.f9792a.f9797c.getEmail().split("@")[1])));
        AppToastUtils.showShortPositiveTipToast(this.f9792a.f9795a, R.string.bind_phone_code_send_success);
    }
}
