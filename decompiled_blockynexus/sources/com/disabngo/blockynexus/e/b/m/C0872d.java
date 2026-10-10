package com.disabngo.blockynexus.e.b.m;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.m.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0872d extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0873e f9930a;

    C0872d(C0873e c0873e) {
        this.f9930a = c0873e;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        Messenger.getDefault().send(user, MessageToken.FRIEND_MATCH_UPDATE_USER_INFO_DETAIL);
        AppToastUtils.showShortPositiveTipToast(this.f9930a.f9931a, R.string.modify_success);
        ReportDataAdapter.onEvent(this.f9930a.f9931a, EventConstant.MORE_PERS_SUC);
        SandboxReportManager.onEvent(ReportEvent.USER_PERSONLA_PROFILE, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
        Messenger.getDefault().send(4, MessageToken.TOKEN_ACCOUNT);
        if (!(this.f9930a.f9931a instanceof Activity) || ((Activity) this.f9930a.f9931a).isFinishing()) {
            return;
        }
        ((Activity) this.f9930a.f9931a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f9930a.f9931a, this.f9930a.f9931a.getString(R.string.connect_error_code, Integer.valueOf(i)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9930a.f9931a, i);
    }
}
