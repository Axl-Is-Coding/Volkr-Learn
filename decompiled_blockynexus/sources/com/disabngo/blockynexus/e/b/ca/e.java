package com.disabngo.blockynexus.e.b.ca;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.fa.i;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateNewUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SafeSettingViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<List<SecretQuestionInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f9686b;

    e(g gVar, int i) {
        this.f9686b = gVar;
        this.f9685a = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9686b.f9688a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9686b.f9688a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SecretQuestionInfo> list) {
        if (list == null || list.size() < 2) {
            AppToastUtils.showShortNegativeTipToast(this.f9686b.f9688a, R.string.server_timeout);
            return;
        }
        int i = this.f9685a;
        if (i == 0) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(StringConstant.IS_FINISH_EMAIL_VERIFY, false);
            bundle.putParcelableArrayList(StringConstant.SECRET_QUESTION, (ArrayList) list);
            TemplateNewUtils.startTemplate(this.f9686b.f9688a, i.class, this.f9686b.f9688a.getString(R.string.item_view_secret_question), bundle);
            ReportDataAdapter.onEvent(this.f9686b.f9688a, EventConstant.MORE_SECRET_QUESTION_CLICK);
            return;
        }
        if (i == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList(StringConstant.SECRET_QUESTION, (ArrayList) list);
            TemplateNewUtils.startTemplate(this.f9686b.f9688a, com.disabngo.blockynexus.e.b.ha.f.class, this.f9686b.f9688a.getString(R.string.safety_verification), bundle2);
        }
    }
}
