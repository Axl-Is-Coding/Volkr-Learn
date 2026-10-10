package com.disabngo.blockynexus.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.utils.logic.N;
import com.google.gson.j;
import com.sandboxol.center.IAccountManager;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.G;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.c.ma;
import com.sandboxol.greendao.c.ra;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: AccountManagerService.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements IAccountManager {
    private void a(Context context) {
        ReportInfo reportInfo;
        String string = SharedUtils.getString(context, SharedConstant.REPORT_INFO);
        if (TextUtils.isEmpty(string) || (reportInfo = (ReportInfo) new j().a(string, ReportInfo.class)) == null || 1 != reportInfo.getStatus() || reportInfo.getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
            return;
        }
        SharedUtils.remove(context, SharedConstant.REPORT_INFO);
    }

    @Override // com.sandboxol.center.IAccountManager
    public void onLoginFinish(Context context, LoginRegisterAccountForm loginRegisterAccountForm, User user) {
        a(context);
        if (loginRegisterAccountForm.getPlatform() == null) {
            SharedUtils.putInt(context, SharedConstant.PASSWORD_WRONG_TIMES, 0);
            AccountCenter.newInstance().hasPassword.set(true);
            ReportDataAdapter.onEvent(context, EventConstant.ACCOUNT_LOGIN_SUC);
        } else {
            ReportDataAdapter.onEvent(context, EventConstant.ENTER_USEROAGE, loginRegisterAccountForm.getPlatform());
        }
        user.setPassword(loginRegisterAccountForm.getPassword());
        onUpdateAccount(context, user);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS);
        Messenger.getDefault().send(1, MessageToken.TOKEN_ACCOUNT);
        Messenger.getDefault().send(1, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
        SharedUtils.remove(context, SharedConstant.REPORT_INFO);
        AppToastUtils.showShortPositiveTipToast(context, R.string.account_login_success);
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_LOGIN_SUCCESS);
        Messenger.getDefault().send(1, MessageToken.TOKEN_GO_GAME);
        AppInfoCenter.newInstance().setAuthTokenSuccess(true);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_FINISH);
        LoginManager.onSaveUser(loginRegisterAccountForm.getUid(), loginRegisterAccountForm.getPassword(), user);
    }

    @Override // com.sandboxol.center.IAccountManager
    public void onNewAccountCreated(AuthTokenResponse authTokenResponse) {
        AccountCenter.logout();
        N.o();
        AccountCenter.newInstance().hasBinding.set(Boolean.valueOf(authTokenResponse.isHasBinding()));
        AccountCenter.newInstance().userId.set(Long.valueOf(authTokenResponse.getUserId()));
        AccountCenter.newInstance().token.set(authTokenResponse.getAccessToken());
        AccountCenter.newInstance().login.set(true);
        BaseApplication.getApp().setUserId(authTokenResponse.getUserId());
        BaseApplication.getApp().setAccessToken(authTokenResponse.getAccessToken());
        AccountCenter.putAccountInfo();
    }

    @Override // com.sandboxol.center.IAccountManager
    public void onRegisterFinish(Context context, User user) {
        AppToastUtils.showShortPositiveTipToast(context, R.string.account_register_success);
        onUpdateAccount(context, user);
        LoginManager.onSaveUser(user.getUserId() + "", user.getPassword(), user);
        Messenger.getDefault().send(1, MessageToken.TOKEN_REGISTER_SUCCESS);
        Messenger.getDefault().send(2, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_NEW_ICON_REGISTER);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
        ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_BUILDSUC);
        ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "success");
        if (context instanceof Activity) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS_START_MAIN);
        }
    }

    @Override // com.sandboxol.center.IAccountManager
    public void onUnLoginFinish() {
    }

    @Override // com.sandboxol.center.IAccountManager
    public void onUpdateAccount(Context context, User user) {
        AccountCenter.updateAccount(user);
        P.newInstance().d(user.getUserId());
        G.newInstance().a(user.getUserId());
        ma.newInstance().b(user.getUserId());
        ra.newInstance().b(user.getUserId());
        a();
    }

    private static void a() {
        UserApi.getUserVerifySettingsInfo(BaseApplication.getContext(), String.valueOf(AccountCenter.newInstance().userId.get()), new d());
    }
}
