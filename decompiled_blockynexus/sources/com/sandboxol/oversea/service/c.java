package com.sandboxol.oversea.service;

import android.content.Context;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.oversea.R;

/* JADX INFO: compiled from: ChannelService.java */
/* JADX INFO: loaded from: classes4.dex */
class c implements FacebookCallback<LoginResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ILoginListener f18841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ChannelService f18843c;

    c(ChannelService channelService, ILoginListener iLoginListener, Context context) {
        this.f18843c = channelService;
        this.f18841a = iLoginListener;
        this.f18842b = context;
    }

    @Override // com.facebook.FacebookCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(LoginResult loginResult) {
        Log.d("Facebook", String.format("id: %s, name: %s", loginResult.getAccessToken().getUserId(), loginResult.getAccessToken().getToken()));
        this.f18841a.loginSuccessful(loginResult.getAccessToken().getUserId(), Profile.getCurrentProfile().getName(), loginResult.getAccessToken().getToken(), StringConstant.THIRD_PART_LOGIN_FB);
        ReportDataAdapter.onEvent(this.f18842b, EventConstant.THIRD_FACEBOOK_SUC);
    }

    @Override // com.facebook.FacebookCallback
    public void onCancel() {
        Log.d("Facebook", "fackbook login cancel");
        AppToastUtils.showShortNegativeTipToast(this.f18842b, R.string.fb_login_cancel);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
    }

    @Override // com.facebook.FacebookCallback
    public void onError(FacebookException facebookException) {
        if ((facebookException instanceof FacebookAuthorizationException) && AccessToken.getCurrentAccessToken() != null) {
            LoginManager.getInstance().logOut();
        }
        Log.d("Facebook", "facebook login error:" + facebookException.getMessage());
        AppToastUtils.showShortNegativeTipToast(this.f18842b, R.string.fb_login_failed);
        ReportDataAdapter.onEvent(this.f18842b, EventConstant.THIRD_FACEBOOK_FAILED);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
    }
}
