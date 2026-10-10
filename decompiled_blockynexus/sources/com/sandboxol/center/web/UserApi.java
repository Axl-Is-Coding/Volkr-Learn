package com.sandboxol.center.web;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AdsCdConfig;
import com.sandboxol.center.entity.AdsSignReward;
import com.sandboxol.center.entity.AppConfig;
import com.sandboxol.center.entity.AuthenticationEntity;
import com.sandboxol.center.entity.BannerInfo;
import com.sandboxol.center.entity.BuyGameResponse;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.CashApplyInfo;
import com.sandboxol.center.entity.ChangePasswordForm;
import com.sandboxol.center.entity.DailyAdsTaskInfo;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.entity.DailyTaskResponse;
import com.sandboxol.center.entity.DeviceIdEntity;
import com.sandboxol.center.entity.DressAdsInfo;
import com.sandboxol.center.entity.DressAdsReward;
import com.sandboxol.center.entity.EmailBindForm;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.entity.ModifyNameFreeResponse;
import com.sandboxol.center.entity.PhoneBindForm;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.center.entity.ReportRequest;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.entity.SecurityVerifyResponse;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.entity.ShareRewardEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.entity.StarCodeUserIncomeInfo;
import com.sandboxol.center.entity.StarCodeUserIncomePageData;
import com.sandboxol.center.entity.UserVerifyInfo;
import com.sandboxol.center.entity.UserVerifySettingsInfo;
import com.sandboxol.center.entity.VerifyEmailForm;
import com.sandboxol.center.entity.VideoStarConfig;
import com.sandboxol.center.entity.WeekTaskResponse;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.center.web.http.LoadingHttpListSubscriber;
import com.sandboxol.center.web.http.LoadingHttpSubscriber;
import com.sandboxol.center.web.http.LoginSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpListSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.BannerEntity;
import com.sandboxol.greendao.entity.RegisterInfo;
import com.sandboxol.greendao.entity.User;
import com.sandboxol.greendao.entity.Visitor;
import com.trello.rxlifecycle.ActivityEvent;
import io.rong.common.LibStorageUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import okhttp3.x;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class UserApi {
    private static IUserApi api;

    static /* synthetic */ void a(HttpResponse httpResponse) {
        if (httpResponse.getCode() == 1) {
            return;
        }
        Exceptions.propagate(new Exception("failed to load visitor data."));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void authToken(Context context, OnResponseListener<AuthTokenResponse> onResponseListener) {
        getApi(context).authToken(AccountCenter.newInstance().userId.get(), CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void authUserQuestion(final Context context, final Long l, final SecretQuestionInfo secretQuestionInfo, final int i, final OnResponseListener<UserVerifyInfo> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.va
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.authUserQuestion(context, l, secretQuestionInfo, i, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            getApi(context).authUserQuestion(CommonHelper.getLanguage(), l, i, secretQuestionInfo).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            getApi(context).authUserQuestion(CommonHelper.getLanguage(), l, i, secretQuestionInfo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse<UserVerifyInfo>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void bannerUrl(Context context, OnResponseListener<List<BannerEntity>> onResponseListener) {
        getApi(context).loadBannerUrls().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpListSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void bindEmail(final Context context, final String str, final EmailBindForm emailBindForm, final OnResponseListener onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ua
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.bindEmail(context, str, emailBindForm, onResponseListener);
            }
        });
        if (str.equals(StringConstant.EMAIL_BIND)) {
            getApi(context).bindEmail(emailBindForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            getApi(context).unbindEmail(AccountCenter.newInstance().userId.get()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void bindPhone(final Context context, final String str, final PhoneBindForm phoneBindForm, final OnResponseListener onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.cb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.bindPhone(context, str, phoneBindForm, onResponseListener);
            }
        });
        if (str.equals(StringConstant.BIND_PHONE)) {
            getApi(context).bindPhone(phoneBindForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            getApi(context).unbindPhone(phoneBindForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void changeInfo(final Context context, final User user, final OnResponseListener<User> onResponseListener) {
        getApi(context).changeInfo(user).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Na
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.changeInfo(context, user, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void changeNickname(final Context context, final String str, final OnResponseListener<User> onResponseListener) {
        getApi(context).changeNickName(str, AccountCenter.newInstance().nickName.get()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.za
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.changeNickname(context, str, onResponseListener);
            }
        })));
    }

    public static void checkAppVersion(Context context, OnResponseListener<LatestVersion> onResponseListener) {
        getApi(context).checkAppVersion().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<LatestVersion>>) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void checkNickNameTimely(Context context, String str, OnResponseListener<Object> onResponseListener) {
        getApi(context).checkNickNameTimely(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clickSignIn(final Context context, final OnResponseListener onResponseListener) {
        getApi(context).clickSignIn(AccountCenter.newInstance().userId.get(), CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ea
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.clickSignIn(context, onResponseListener);
            }
        })));
    }

    public static void countDaily(Context context, String str, OnResponseListener onResponseListener) {
        getApi(context).countDaily(str, CommonHelper.getAndroidId(context)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dailyLifeInfo(final Context context, final OnResponseListener onResponseListener) {
        getApi(context).dailyLifeInfo("android", CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Xa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.dailyLifeInfo(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dailySignIn(final Context context, final OnResponseListener<Map<String, DailySignInfo>> onResponseListener) {
        getApi(context).dailySignIn(AccountCenter.newInstance().userId.get(), CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ja
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.dailySignIn(context, onResponseListener);
            }
        })));
    }

    public static void getAdsCdConfig(final Context context, final String str, final OnResponseListener<AdsCdConfig> onResponseListener) {
        getApi(context).getAdsCdConfig(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<AdsCdConfig>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.bb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getAdsCdConfig(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAdsRewardInfo(final Context context, final OnResponseListener<DailyAdsTaskInfo> onResponseListener) {
        getApi(context).getAdsRewardInfo(AccountCenter.newInstance().userId.get().longValue()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.La
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getAdsRewardInfo(context, onResponseListener);
            }
        })));
    }

    private static IUserApi getApi(Context context) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        if (api == null) {
            synchronized (UserApi.class) {
                try {
                    api = (IUserApi) RetrofitFactory.httpsCreate(((BaseApplication) context.getApplicationContext()).getMetaDataBaseUrl(), IUserApi.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ReportDataAdapter.onEvent(context, EventConstant.TOKEN_APP_EXCEPTION);
                    Process.killProcess(Process.myPid());
                }
            }
        }
        return api;
    }

    public static void getAuthentication(final Context context, final OnResponseListener<String> onResponseListener) {
        getApi(context).getAuthentication(AccountCenter.newInstance().userId.get()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<String>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ib
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getAuthentication(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getDressAdsInfo(final Context context, final OnResponseListener<DressAdsInfo> onResponseListener) {
        getApi(context).getDressAdsInfo(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Oa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getDressAdsInfo(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getDressAdsReward(final Context context, final OnResponseListener<DressAdsReward> onResponseListener) {
        getApi(context).getDressAdsReward(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoadingHttpSubscriber(context, onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ia
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getDressAdsReward(context, onResponseListener);
            }
        }), true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getIsShowFriendInGame(final Context context, final OnResponseListener<Integer> onResponseListener) {
        getApi(context).getIsShowFriendInGame().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ia
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getIsShowFriendInGame(context, onResponseListener);
            }
        })));
    }

    public static void getMoreDialogBanner(Context context, boolean z, boolean z2, OnResponseListener<List<BannerInfo>> onResponseListener) {
        if (z2) {
            getApi(context).moreDialogBanner().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<BannerInfo>>>) new LoadingHttpListSubscriber(context, onResponseListener, null, z));
        } else {
            getApi(context).moreDialogBanner().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<BannerInfo>>>) new LoadingHttpListSubscriber(context, onResponseListener, null, z));
        }
    }

    public static void getNewAdsCdConfig(final Context context, final String str, final OnResponseListener<AdsCdConfig> onResponseListener) {
        getApi(context).getNewAdsCdConfig(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<AdsCdConfig>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ka
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getNewAdsCdConfig(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getPerfectUserInfoReward(final Context context, final OnResponseListener<BuyGameResponse> onResponseListener) {
        getApi(context).getPerfectUserInfoReward(AccountCenter.newInstance().userId.get(), CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Sa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getPerfectUserInfoReward(context, onResponseListener);
            }
        })));
    }

    public static void getRongToken(final Context context, final OnResponseListener<String> onResponseListener) {
        getApi(context).getRongToken().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<String>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.na
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getRongToken(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getSignAdsReward(final Context context, final OnResponseListener<AdsSignReward> onResponseListener) {
        getApi(context).getSignAdsReward(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Pa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getSignAdsReward(context, onResponseListener);
            }
        })));
    }

    public static void getStarCodeConfig(final Context context, final OnResponseListener<VideoStarConfig> onResponseListener) {
        getApi(context).getStarCodeConfig(CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<VideoStarConfig>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.qa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getStarCodeConfig(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getStarCodeUserIncomeDetail(final Context context, final int i, final int i2, final OnResponseListener<StarCodeUserIncomePageData<StarCodeUserIncomeInfo>> onResponseListener) {
        getApi(context).getStarCodeUserIncomeDetail(i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.sa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getStarCodeUserIncomeDetail(context, i, i2, onResponseListener);
            }
        })));
    }

    public static void getStarCodeUserInfo(final Context context, final String str, final OnResponseListener<StarCodeUser> onResponseListener) {
        getApi(context).getStarCodeUserInfo(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<StarCodeUser>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.eb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getStarCodeUserInfo(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTipsEmail(final Context context, final long j, final OnResponseListener<String> onResponseListener) {
        getApi(context).getTipsEmail(Long.valueOf(j)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ta
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getTipsEmail(context, j, onResponseListener);
            }
        })));
    }

    public static void getToken(Context context, OnResponseListener<AuthTokenResponse> onResponseListener) {
        getApi(context).authToken(AccountCenter.newInstance().userId.get(), CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<AuthTokenResponse>>) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUserLikeGameList(final Context context, final OnResponseListener<List<String>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Qa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getUserLikeGameList(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            getApi(context).getUserLikeGameList(AccountCenter.newInstance().userId.get().longValue(), 5, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            getApi(context).getUserLikeGameList(AccountCenter.newInstance().userId.get().longValue(), 5, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse<List<String>>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUserQuestion(final Context context, final int i, final OnResponseListener<List<SecretQuestionInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Wa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getUserQuestion(context, i, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            getApi(context).getUserQuestion(i, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new LoadingHttpSubscriber(context, onResponseListener, retryCommand));
        } else {
            getApi(context).getUserQuestion(i, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse<List<SecretQuestionInfo>>>) new LoadingHttpSubscriber(context, onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUserVerifySettingsInfo(final Context context, final String str, final OnResponseListener<UserVerifySettingsInfo> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Da
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getUserVerifySettingsInfo(context, str, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            getApi(context).getUserVerifySettingsInfo(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            getApi(context).getUserVerifySettingsInfo(str, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse<UserVerifySettingsInfo>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getVipInfo(final Context context, final OnResponseListener<BuyVipEntity> onResponseListener) {
        getApi(context).getVipInfo().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web._a
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.getVipInfo(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void isChangeNameFree(final Context context, final OnResponseListener<ModifyNameFreeResponse> onResponseListener) {
        getApi(context).isChangeNameFree().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.oa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.isChangeNameFree(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void isRewardCheck(Context context, OnResponseListener<Boolean> onResponseListener) {
        getApi(context).isRewardCheck(AccountCenter.newInstance().userId.get()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void loadAppConfig(Context context, OnResponseListener<AppConfig> onResponseListener) {
        getApi(context).loadAppConfig().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void loadEditorConfig(Context context, OnResponseListener<Map<String, List<String>>> onResponseListener) {
        getApi(context).loadEditorConfig().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    public static void loadSensitiveWordConfig(Context context, OnResponseListener<List<String>> onResponseListener) {
        getApi(context).loadSensitiveWordConfig().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe((Subscriber<? super HttpResponse<List<String>>>) new HttpListSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void loadShareReward(Context context, OnResponseListener<List<ShareRewardEntity>> onResponseListener) {
        getApi(context).loadShareReward().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpListSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void login(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnResponseListener<User> onResponseListener, boolean z) {
        getApi(context).login(loginRegisterAccountForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoginSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void logout(final Context context, final OnResponseListener onResponseListener) {
        getApi(context).logout().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ma
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.logout(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void modifyPassword(final Context context, final ChangePasswordForm changePasswordForm, final OnResponseListener onResponseListener) {
        getApi(context).modifyPassword(changePasswordForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.xa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.modifyPassword(context, changePasswordForm, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void newSignIn(final Context context, final OnResponseListener<RechargeEntity> onResponseListener) {
        getApi(context).getAdsReward(AccountCenter.newInstance().userId.get().longValue()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ja
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.newSignIn(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void newSignInList(final Context context, final OnResponseListener<DailyTaskResponse> onResponseListener) {
        getApi(context).newSignInList().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ua
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.newSignInList(context, onResponseListener);
            }
        })));
    }

    public static void postAuthentication(final Context context, final AuthenticationEntity authenticationEntity, final OnResponseListener<String> onResponseListener) {
        getApi(context).postAuthentication(authenticationEntity).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<String>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.gb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.postAuthentication(context, authenticationEntity, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postReport(Context context, ReportRequest reportRequest, OnResponseListener onResponseListener) {
        getApi(context).postReport(CommonHelper.getLanguage(), reportRequest).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postUserLanguage(Context context, OnResponseListener onResponseListener) {
        if (AccountCenter.newInstance().userId.get().longValue() != 0) {
            getApi(context).postUserLanguage(AccountCenter.newInstance().userId.get(), CommonHelper.getUserLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(3L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void putCashApply(final Context context, final CashApplyInfo cashApplyInfo, final OnResponseListener<RechargeEntity> onResponseListener) {
        getApi(context).putCashApply(cashApplyInfo).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Za
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.putCashApply(context, cashApplyInfo, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void putCashExchange(final Context context, final OnResponseListener<RechargeEntity> onResponseListener) {
        getApi(context).putCashExchange(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.jb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.putCashExchange(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void register(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnResponseListener<User> onResponseListener) {
        getApi(context).register(loginRegisterAccountForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void renew(Context context, OnResponseListener<AuthTokenResponse> onResponseListener) {
        getApi(context).renew(CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void reportStatus(Context context, OnResponseListener<ReportInfo> onResponseListener) {
        getApi(context).reportStatus(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void resetPassword(Context context, String str, OnResponseListener onResponseListener) {
        getApi(context).resetPassword(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void resetPasswordBySecretQuestion(final Context context, final Long l, final String str, final String str2, final OnResponseListener onResponseListener) {
        getApi(context).resetPasswordBySecretQuestion(l.longValue(), str, str2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ab
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.resetPasswordBySecretQuestion(context, l, str, str2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void retrieve(final Context context, final String str, final OnResponseListener onResponseListener) {
        getApi(context).retrieve(str, "passwordReFound").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.la
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.retrieve(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void retrievePassword(final Context context, final PhoneBindForm phoneBindForm, final OnResponseListener onResponseListener) {
        getApi(context).retrievePassword(phoneBindForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ta
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.retrievePassword(context, phoneBindForm, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void sendCode(final Context context, final String str, final String str2, final OnResponseListener onResponseListener) {
        getApi(context).sendCode(str, str2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ra
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.sendCode(context, str, str2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void sendEmailCode(final Context context, final String str, final OnResponseListener onResponseListener) {
        getApi(context).sendEmailCode(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ba
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.sendEmailCode(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void sendEmailVerifyCode(final Context context, final String str, final int i, final OnResponseListener onResponseListener) {
        getApi(context).sendEmailVerifyCode(str, i).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ya
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.sendEmailVerifyCode(context, str, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void sendFullEmailToVerify(final Context context, final long j, final String str, final OnResponseListener<Object> onResponseListener) {
        getApi(context).sendFullEmailToVerify(Long.valueOf(j), str, "bg").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ya
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.sendFullEmailToVerify(context, j, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setIsShowFriendInGame(final Context context, final OnResponseListener<Integer> onResponseListener) {
        getApi(context).setIsShowFriendInGame().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Aa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.setIsShowFriendInGame(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setPassword(final Context context, final SetPasswordForm setPasswordForm, final OnResponseListener onResponseListener) {
        getApi(context).setPassword(setPasswordForm, CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.pa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.setPassword(context, setPasswordForm, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setUserQuestion(final Context context, final String str, final List<SecretQuestionInfo> list, final String str2, final OnResponseListener onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.hb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.setUserQuestion(context, str, list, str2, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            getApi(context).setUserQuestion(str, CommonHelper.getLanguage(), list, str2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            getApi(context).setUserQuestion(str, CommonHelper.getLanguage(), list, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void shareReward(final Context context, final String str, final OnResponseListener onResponseListener) {
        getApi(context).shareReward(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Va
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.shareReward(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static void signIn(Context context, int i, OnResponseListener<RechargeEntity> onResponseListener) {
        getApi(context).signIn(i).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static void signInList(Context context, int i, OnResponseListener<WeekTaskResponse> onResponseListener) {
        getApi(context).signInList(i).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void unbindEmail(final Context context, final String str, final String str2, final OnResponseListener onResponseListener) {
        getApi(context).unbindEmail(AccountCenter.newInstance().userId.get(), str, str2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ga
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.unbindEmail(context, str, str2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void unbindUserSecretQuestion(final Context context, final VerifyEmailForm verifyEmailForm, final OnResponseListener onResponseListener) {
        getApi(context).unbindUserSecretQuestion(verifyEmailForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ha
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.unbindUserSecretQuestion(context, verifyEmailForm, onResponseListener);
            }
        })));
    }

    public static void upLoadID(Context context, String str, String str2, OnResponseListener onResponseListener) {
        getApi(context).uploadID(str, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void updateUserInfo(final Context context, final OnResponseListener<User> onResponseListener) {
        getApi(context).updateUserInfo().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(3L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ha
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.updateUserInfo(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void uploadDeviceId(final Context context, final OnResponseListener onResponseListener) {
        DeviceIdEntity deviceIdEntity = new DeviceIdEntity();
        deviceIdEntity.setDeviceId(CommonHelper.getAndroidId(context));
        deviceIdEntity.setSignature(CommonHelper.getSignature(context));
        Log.e("uploadDeviceId1", deviceIdEntity.getDeviceId());
        Log.e("uploadDeviceId2", deviceIdEntity.getSignature());
        getApi(context).uploadDeviceId(deviceIdEntity).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.wa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.uploadDeviceId(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void uploadIcon(final Context context, final File file, final String str, final OnResponseListener<String> onResponseListener) {
        x.b bVarA;
        okhttp3.G gCreate = okhttp3.G.create(okhttp3.w.b("multipart/form-data"), file);
        try {
            bVarA = x.b.a(LibStorageUtils.FILE, str, gCreate);
        } catch (Exception unused) {
            bVarA = x.b.a(LibStorageUtils.FILE, "unknown name", gCreate);
        }
        getApi(context).uploadIcon(str, "jpg", bVarA).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Fa
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.uploadIcon(context, file, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void userRegister(final Context context, final RegisterInfo registerInfo, final OnResponseListener<User> onResponseListener) {
        getApi(context).userRegister(registerInfo).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.fb
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.userRegister(context, registerInfo, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void verifyEmail(final Context context, final VerifyEmailForm verifyEmailForm, final OnResponseListener onResponseListener) {
        getApi(context).verifyEmail(verifyEmailForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ma
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.verifyEmail(context, verifyEmailForm, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void verifyEmailBeforeSetSecretQuestion(final Context context, final VerifyEmailForm verifyEmailForm, final OnResponseListener<SecurityVerifyResponse> onResponseListener) {
        getApi(context).verifyEmailBeforeSetSecretQuestion(verifyEmailForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ra
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.verifyEmailBeforeSetSecretQuestion(context, verifyEmailForm, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void visitor(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnResponseListener<Visitor> onResponseListener) {
        getApi(context).visitor(loginRegisterAccountForm).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.ka
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                UserApi.a((HttpResponse) obj);
            }
        }).retry(2L).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void login(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnResponseListener<User> onResponseListener) {
        getApi(context).login(loginRegisterAccountForm, CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoginSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void renew(Context context, String str, OnResponseListener<AuthTokenResponse> onResponseListener) {
        getApi(context).renew(CommonHelper.getAndroidId(context), CommonHelper.getSignature(context), str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    public static void setPassword(final Context context, final boolean z, final SetPasswordForm setPasswordForm, final OnResponseListener onResponseListener) {
        getApi(context).setPassword(setPasswordForm, CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new LoadingHttpSubscriber(context, onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Ca
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.setPassword(context, z, setPasswordForm, onResponseListener);
            }
        }), z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void bindEmail(final Context context, final String str, final EmailBindForm emailBindForm, final List<String> list, final OnResponseListener onResponseListener) {
        getApi(context).bindEmail(str, emailBindForm, list).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.db
            @Override // rx.functions.Action0
            public final void call() {
                UserApi.bindEmail(context, str, emailBindForm, list, onResponseListener);
            }
        })));
    }
}
