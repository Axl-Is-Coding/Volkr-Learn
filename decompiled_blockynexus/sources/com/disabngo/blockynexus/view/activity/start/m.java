package com.disabngo.blockynexus.view.activity.start;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.BlockAccountResult;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: StartActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<AuthTokenResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f11115b;

    m(p pVar, Context context) {
        this.f11115b = pVar;
        this.f11114a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 1004) {
            if (this.f11115b.f11121b < 1) {
                AccountCenter.newInstance().userId.set(0L);
                BaseApplication.getApp().setUserId(0L);
                p.b(this.f11115b);
            }
            ReportDataAdapter.onEvent(this.f11114a, EventConstant.STAR_APP_ENTER_LOGIN);
        } else if (i == 17 && str != null) {
            try {
                AppInfoCenter.newInstance().setBlockAccount((BlockAccountResult) new com.google.gson.j().a(str, new l(this).getType()));
                Messenger.getDefault().sendNoMsg(MessageToken.SHOW_BLOCK_ACCOUNT_DIALOG);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        AppInfoCenter.newInstance().setAuthTokenSuccess(false);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_AUTH_TOKEN_FINISH);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("autoToken", String.valueOf(i));
        AppInfoCenter.newInstance().setAuthTokenSuccess(false);
        ServerOnError.showOnServerError(this.f11114a, i);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_AUTH_TOKEN_FINISH);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(AuthTokenResponse authTokenResponse) {
        AccountCenter.newInstance().hasBinding.set(Boolean.valueOf(authTokenResponse.isHasBinding()));
        AccountCenter.newInstance().userId.set(Long.valueOf(authTokenResponse.getUserId()));
        AccountCenter.newInstance().token.set(authTokenResponse.getAccessToken());
        BaseApplication.getApp().setAccessToken(authTokenResponse.getAccessToken());
        BaseApplication.getApp().setUserId(authTokenResponse.getUserId());
        AccountCenter.newInstance().login.set(true);
        AccountCenter.putAccountInfo();
        this.f11115b.a(this.f11114a, authTokenResponse);
        AppInfoCenter.newInstance().setAuthTokenSuccess(true);
        SandboxReportManager.onEvent(ReportEvent.NEW_CLICK_LOGIN, ReportEventType.USER_LOGIN_BEHAVIOR, "android");
    }
}
