package com.disabngo.blockynexus.view.activity.start;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observer;

/* JADX INFO: compiled from: StartActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f11116a;

    n(o oVar) {
        this.f11116a = oVar;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            SharedUtils.putString(this.f11116a.f11117a, SharedConstant.REPORT_INFO, jSONObject.toString());
            ReportInfo reportInfo = (ReportInfo) new com.google.gson.j().a(jSONObject.toString(), ReportInfo.class);
            if (1 == reportInfo.getStatus()) {
                Messenger.getDefault().send(reportInfo, MessageToken.TOKEN_SEND_LOGIN_REPORT);
            }
            AccountCenter.newInstance().setNickName("");
            AccountCenter.newInstance().setPicUrl("");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
    }
}
