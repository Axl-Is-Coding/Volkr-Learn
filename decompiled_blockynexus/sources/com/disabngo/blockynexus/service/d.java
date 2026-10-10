package com.disabngo.blockynexus.service;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.UserVerifySettingsInfo;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: AccountManagerService.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends OnResponseListener<UserVerifySettingsInfo> {
    d() {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(UserVerifySettingsInfo userVerifySettingsInfo) {
        if (userVerifySettingsInfo.getSecretQuestionList() != null) {
            AccountCenter.newInstance().setIsFinishSecretQuestion(true);
        } else {
            AccountCenter.newInstance().setIsFinishSecretQuestion(false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AccountCenter.newInstance().setIsFinishSecretQuestion(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
