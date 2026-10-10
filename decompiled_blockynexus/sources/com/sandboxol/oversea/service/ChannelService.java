package com.sandboxol.oversea.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.ApiException;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.moduleApi.IChannelService;
import com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.router.moduleInfo.pay.PayOrder;
import com.sandboxol.center.router.moduleInfo.pay.PayToken;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.oversea.R;
import com.sandboxol.oversea.a.j;
import com.twitter.sdk.android.core.identity.h;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.u;
import java.util.Arrays;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventChannel.CHANNEL_SERVICE)
public class ChannelService implements IChannelService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CallbackManager f18836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f18837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GoogleSignInClient f18838c;

    static /* synthetic */ void b(Context context, PayOrder payOrder) {
        try {
            if (payOrder.purchase == null) {
                IntentUtils.startRechargeDialog(context, true, context.getString(R.string.base_recharge_cancel_buy));
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                return;
            }
            int i = payOrder.code;
            boolean z = false;
            if (i == 1) {
                if (!payOrder.purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) && !payOrder.purchase.getSku().contains("cube") && !payOrder.purchase.getSku().contains("game")) {
                    if (payOrder.purchase.getSku().contains("vip")) {
                        if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                            com.sandboxol.oversea.a.h.c(context, payOrder.purchase, true);
                            return;
                        } else {
                            com.sandboxol.oversea.a.h.b(context, payOrder.purchase);
                            return;
                        }
                    }
                    if (!payOrder.purchase.getSku().contains("gift") && !payOrder.purchase.getSku().contains("pass")) {
                        if (payOrder.purchase.getSku().contains("dragon")) {
                            com.sandboxol.oversea.a.h.a(context, payOrder.purchase, false);
                            return;
                        }
                        return;
                    }
                    com.sandboxol.oversea.a.h.b(context, payOrder.purchase, false);
                    return;
                }
                com.sandboxol.oversea.a.h.a(context, payOrder.purchase);
                return;
            }
            if (i == 3) {
                if (payOrder.isShowDialog) {
                    IntentUtils.startRechargeDialog(context, true, context.getString(R.string.base_recharge_cancel_buy));
                }
                if (!payOrder.purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) && !payOrder.purchase.getSku().contains("cube") && !payOrder.purchase.getSku().contains("game")) {
                    if (payOrder.purchase.getSku().contains("vip")) {
                        if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                            VipManager.reportVipSubscribeFail(context, "PAY_CANCEL");
                            return;
                        } else {
                            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_VIP_CANCEL_PAY);
                            return;
                        }
                    }
                    if (payOrder.purchase.getSku().contains("gift") || payOrder.purchase.getSku().contains("pass") || !payOrder.purchase.getSku().contains("dragon")) {
                        return;
                    }
                    MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                    return;
                }
                ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_CANCEL_PAY);
                return;
            }
            if (i == 5) {
                if (!payOrder.purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) && !payOrder.purchase.getSku().contains("cube") && !payOrder.purchase.getSku().contains("game")) {
                    if (payOrder.purchase.getSku().contains("vip")) {
                        if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                            VipManager.reportVipSubscribeSuccess(context, payOrder.purchase.getSku());
                            return;
                        } else {
                            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_VIP_CONSUME_SUC, payOrder.purchase.getSku());
                            SandboxReportManager.onEvent(ReportEvent.USER_PUSH_VIP, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
                            return;
                        }
                    }
                    if (!payOrder.purchase.getSku().contains("gift") && !payOrder.purchase.getSku().contains("pass")) {
                        payOrder.purchase.getSku().contains("dragon");
                        return;
                    }
                    Messenger.getDefault().send(payOrder.purchase.getSku(), MessageToken.TOKEN_CHRISTMAS_BUY_GIF_SUCCESS);
                    return;
                }
                boolean z2 = payOrder.purchase != null && payOrder.purchase.getDeveloperPayload() != null && payOrder.purchase.getDeveloperPayload().contains("starCodeUserId") && payOrder.purchase.getDeveloperPayload().contains("starCode");
                if (payOrder.purchase != null && payOrder.purchase.getDeveloperPayload() != null && payOrder.purchase.getDeveloperPayload().contains("enableSumRecharge") && payOrder.purchase.getDeveloperPayload().contains("enableTimeRecharge")) {
                    z = true;
                }
                if (payOrder.isShowDialog) {
                    IntentUtils.startRechargeDialog(context, true, context.getString(R.string.base_recharge_success), z);
                }
                Messenger.getDefault().sendNoMsg(MessageToken.UPDATE_RECHARGE_EVENT_RED_POINT_STATUS);
                MultiProcessSharedUtils.putBoolean(context, "is.first.top.up." + AccountCenter.newInstance().userId.get(), true);
                ReportDataAdapter.onEvent(context, z2 ? z ? EventConstant.STAR_TOPUP_DIA_CONSUME_SUC_STAR_GAME : EventConstant.STAR_TOPUP_DIA_CONSUME_SUC_STAR : EventConstant.TOPUP_DIA_CONSUME_SUC, payOrder.purchase.getSku());
                SandboxReportManager.onEvent(ReportEvent.USER_RECHARGE, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
                return;
            }
            if (i == 7) {
                if (payOrder.isShowDialog) {
                    IntentUtils.startRechargeDialog(context, true, context.getString(R.string.base_recharge_no_install_google));
                }
                if (!payOrder.purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) && !payOrder.purchase.getSku().contains("cube") && !payOrder.purchase.getSku().contains("game")) {
                    if (payOrder.purchase.getSku().contains("vip")) {
                        if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                            VipManager.reportVipSubscribeFail(context, "PAY_NO_INSTALL");
                            return;
                        } else {
                            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_VIP_NO_GOOGLE);
                            return;
                        }
                    }
                    if (payOrder.purchase.getSku().contains("gift") || payOrder.purchase.getSku().contains("pass") || !payOrder.purchase.getSku().contains("dragon")) {
                        return;
                    }
                    MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                    return;
                }
                ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_NO_GOOGLE);
                return;
            }
            if (i != 8) {
                if (payOrder.isShowDialog) {
                    IntentUtils.startRechargeDialog(context, true, payOrder.message);
                }
                if (!payOrder.purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) && !payOrder.purchase.getSku().contains("cube") && !payOrder.purchase.getSku().contains("game")) {
                    if (payOrder.purchase.getSku().contains("vip")) {
                        if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                            VipManager.reportVipSubscribeFail(context, "UNKNOWN_FAILED");
                            return;
                        } else {
                            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_VIP_UNKNOWN_FAILED);
                            return;
                        }
                    }
                    if (payOrder.purchase.getSku().contains("gift") || payOrder.purchase.getSku().contains("pass") || !payOrder.purchase.getSku().contains("dragon")) {
                        return;
                    }
                    MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                    return;
                }
                ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_UNKNOWN_FAILED);
                return;
            }
            if (payOrder.isShowDialog) {
                IntentUtils.startRechargeDialog(context, false, context.getString(R.string.base_recharge_google_play_no_login));
            }
            if (!payOrder.purchase.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) && !payOrder.purchase.getSku().contains("cube") && !payOrder.purchase.getSku().contains("game")) {
                if (payOrder.purchase.getSku().contains("vip")) {
                    if (payOrder.purchase.getSku().contains(StringConstant.VIP_SUBSCRIBE_TYPE)) {
                        VipManager.reportVipSubscribeFail(context, "PAY_UNLOGIN_GOOGLE");
                        return;
                    } else {
                        ReportDataAdapter.onEvent(context, EventConstant.TOPUP_VIP_NO_LOGIN_GOOGLE);
                        return;
                    }
                }
                if (payOrder.purchase.getSku().contains("gift") || payOrder.purchase.getSku().contains("pass") || !payOrder.purchase.getSku().contains("dragon")) {
                    return;
                }
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                return;
            }
            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_NO_LOGIN_GOOGLE);
        } catch (Exception e2) {
            e2.printStackTrace();
            ReportDataAdapter.onEvent(context, EventConstant.TOPUP_CATCH);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void facebookLogin(Context context, ILoginListener iLoginListener) {
        try {
            this.f18836a = CallbackManager.Factory.create();
            LoginManager.getInstance().registerCallback(this.f18836a, new c(this, iLoginListener, context));
            LoginManager.getInstance().logInWithReadPermissions((Activity) context, Arrays.asList("public_profile"));
        } catch (Exception unused) {
            Log.e("Facebook", "facebook login failed");
            AppToastUtils.showShortNegativeTipToast(context, R.string.fb_login_failed);
            ReportDataAdapter.onEvent(context, EventConstant.THIRD_FACEBOOK_FAILED);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void googleLogin(Activity activity) {
        try {
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity) != 0) {
                AppToastUtils.showShortNegativeTipToast(activity, R.string.install_google_plus);
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
            } else {
                GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(activity.getString(R.string.server_client_id)).requestProfile().requestEmail().build();
                if (this.f18838c == null) {
                    this.f18838c = GoogleSignIn.getClient(activity, googleSignInOptionsBuild);
                }
                activity.startActivityForResult(this.f18838c.getSignInIntent(), IntConstant.GOOGLE_SIGN_IN);
            }
        } catch (Exception unused) {
            Log.e("GooglePlay", "googleLogin failed");
            AppToastUtils.showShortNegativeTipToast(activity, R.string.google_login_failed);
            ReportDataAdapter.onEvent(activity, EventConstant.THIRD_GOOGLE_FAILED);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void handleSignInResult(Intent intent, Context context, ILoginListener iLoginListener) throws Throwable {
        try {
            GoogleSignInAccount result = GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class);
            iLoginListener.loginSuccessful(result.getId(), result.getDisplayName(), result.getIdToken(), StringConstant.THIRD_PART_LOGIN_GOOGLE);
            ReportDataAdapter.onEvent(context, EventConstant.THIRD_GOOGLE_SUC);
        } catch (ApiException e2) {
            e2.printStackTrace();
            AppToastUtils.showShortNegativeTipToast(context, R.string.google_login_failed);
            ReportDataAdapter.onEvent(context, EventConstant.THIRD_GOOGLE_FAILED);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void initThirdPartySdk(Context context) {
        try {
            FacebookSdk.sdkInitialize(context);
            u.a aVar = new u.a(BaseApplication.getApp());
            aVar.a(new com.twitter.sdk.android.core.d(3));
            aVar.a(new q(BaseApplication.getContext().getResources().getString(R.string.twitter_consumer_key), BaseApplication.getContext().getResources().getString(R.string.twitter_consumer_secret)));
            aVar.a(true);
            n.b(aVar.a());
        } catch (Exception | VerifyError e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public /* synthetic */ boolean isBeta() {
        return com.sandboxol.center.router.moduleApi.b.a(this);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public boolean isHasGoogleService(Context context) {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onActivityResult(int i, int i2, Intent intent) {
        h hVar = this.f18837b;
        if (hVar != null) {
            hVar.a(i, i2, intent);
        }
        CallbackManager callbackManager = this.f18836a;
        if (callbackManager != null) {
            callbackManager.onActivityResult(i, i2, intent);
        }
        if (i == 10681) {
            if (i2 != -1) {
                Log.e("twitterShare", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                AppToastUtils.showShortPositiveTipToast(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.base_share_fail));
                return;
            } else {
                Log.e("twitterShare", "Success");
                Messenger.getDefault().send(StringConstant.THIRD_PART_LOGIN_TW, MessageToken.TOKEN_GET_SHARE_REWARD);
                Messenger.getDefault().sendNoMsg(MessageToken.WEB_SHARE_SUCCESS);
                AppToastUtils.showShortPositiveTipToast(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.base_share_successful));
                return;
            }
        }
        if (i == 10682) {
            if (i2 == -1) {
                Log.e("googlePlusShare", "Success");
                Messenger.getDefault().send(StringConstant.THIRD_PART_LOGIN_GOOGLE, MessageToken.TOKEN_GET_SHARE_REWARD);
                AppToastUtils.showShortPositiveTipToast(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.base_share_successful));
            } else {
                Log.e("googlePlusShare", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
                MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
                AppToastUtils.showShortPositiveTipToast(BaseApplication.getContext(), BaseApplication.getContext().getString(R.string.base_share_fail));
            }
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onFacebookShare(Activity activity, String str, String str2, Uri uri) {
        if (this.f18836a == null) {
            this.f18836a = CallbackManager.Factory.create();
        }
        j.a(activity, str, str2, uri, this.f18836a);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onGooglePayDestroy(Context context) {
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onGooglePayRegister(final Context context) {
        Messenger.getDefault().register(this, PayToken.TOKEN_GOOGLE_PAY, PayOrder.class, new Action1() { // from class: com.sandboxol.oversea.service.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                com.sandboxol.oversea.a.h.a(context, (PayOrder) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_RECHARGE_PAY, PayOrder.class, new Action1() { // from class: com.sandboxol.oversea.service.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChannelService.b(context, (PayOrder) obj);
            }
        });
        BillingManager.getInstance().initClient(BaseApplication.getContext());
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onGooglePayResume(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onGooglePlusShare(Activity activity, String str, String str2, Uri uri) {
        j.a(activity, str, str2, uri);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void onTwitterShare(Context context, String str, String str2, Uri uri) {
        j.a(context, str, str2, uri);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void startGooglePayActivity(Context context, String str, String str2, String str3) {
        BillingManager.getInstance().startPay((Activity) context, str, str2, str3);
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void twitterLogin(Context context, ILoginListener iLoginListener) {
        try {
            if (this.f18837b == null) {
                this.f18837b = new h();
            }
            if (CommonHelper.checkApkExist(context, "com.twitter.android")) {
                this.f18837b.a((Activity) context, new d(this, iLoginListener, context));
            } else {
                AppToastUtils.showShortNegativeTipToast(context, R.string.install_twitter);
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
            }
        } catch (Exception unused) {
            Log.e("TwitterKit", "init twitter login failed");
            AppToastUtils.showShortNegativeTipToast(context, R.string.twitter_login_failed);
            ReportDataAdapter.onEvent(context, EventConstant.THIRD_TWITTER_FAILED);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.IChannelService
    public void startGooglePayActivity(Context context, String str, String str2, String str3, String str4) {
        BillingManager.getInstance().startPay((Activity) context, str, str2, str3, str4);
    }
}
