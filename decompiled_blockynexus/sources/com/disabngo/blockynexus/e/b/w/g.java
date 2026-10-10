package com.disabngo.blockynexus.e.b.w;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.UserVerifySettingsInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: ForgetPswByEmailOrSecretQuestionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener<UserVerifySettingsInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f10260a;

    g(h hVar) {
        this.f10260a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UserVerifySettingsInfo userVerifySettingsInfo) {
        this.f10260a.g.set(userVerifySettingsInfo.getUserId() + "");
        this.f10260a.f10264d.set(Boolean.valueOf(userVerifySettingsInfo.isBindEmail()));
        this.f10260a.h = String.valueOf(userVerifySettingsInfo.getUserId());
        if (userVerifySettingsInfo.getSecretQuestionList() != null) {
            this.f10260a.f10265e.addAll(userVerifySettingsInfo.getSecretQuestionList());
        }
        this.f10260a.k();
        this.f10260a.i.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 102) {
            AppToastUtils.showShortNegativeTipToast(this.f10260a.f10261a, R.string.id_not_exist);
        } else if (i != 122) {
            AppToastUtils.showShortNegativeTipToast(this.f10260a.f10261a, str);
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f10260a.f10261a, R.string.not_set_secret);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10260a.f10261a, i);
    }
}
