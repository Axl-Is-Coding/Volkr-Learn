package com.disabngo.blockynexus.e.b.ea;

import android.app.Activity;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.entity.SecurityVerifyResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateNewUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SecretEmailVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<List<SecretQuestionInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SecurityVerifyResponse f9745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f9746b;

    j(k kVar, SecurityVerifyResponse securityVerifyResponse) {
        this.f9746b = kVar;
        this.f9745a = securityVerifyResponse;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9746b.f9747a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9746b.f9747a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SecretQuestionInfo> list) {
        if (list == null || list.size() < 2) {
            AppToastUtils.showShortNegativeTipToast(this.f9746b.f9747a, R.string.server_timeout);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.SECRET_AUTHCODE, this.f9745a.getAuthCode());
        bundle.putBoolean(StringConstant.IS_FINISH_EMAIL_VERIFY, true);
        bundle.putParcelableArrayList(StringConstant.SECRET_QUESTION, (ArrayList) list);
        TemplateNewUtils.startTemplate(this.f9746b.f9747a, com.disabngo.blockynexus.e.b.fa.i.class, this.f9746b.f9747a.getString(R.string.item_view_secret_question), bundle);
        ((Activity) this.f9746b.f9747a).finish();
    }
}
