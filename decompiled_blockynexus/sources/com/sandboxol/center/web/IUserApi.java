package com.sandboxol.center.web;

import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.center.config.StringConstant;
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
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.greendao.entity.BannerEntity;
import com.sandboxol.greendao.entity.RegisterInfo;
import com.sandboxol.greendao.entity.User;
import com.sandboxol.greendao.entity.Visitor;
import com.umeng.analytics.pro.au;
import java.util.List;
import java.util.Map;
import okhttp3.x;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes3.dex */
public interface IUserApi {
    @GET("/user/api/v1/app/auth-token")
    Observable<HttpResponse<AuthTokenResponse>> authToken(@Header("bmg-user-id") Long l, @Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @POST("/user/api/v1/users/secret/question")
    Observable<HttpResponse<UserVerifyInfo>> authUserQuestion(@Header(au.M) String str, @Query("userId") Long l, @Query("complete") int i, @Body SecretQuestionInfo secretQuestionInfo);

    @POST("/user/api/v1/users/bind/email")
    Observable<HttpResponse> bindEmail(@Body EmailBindForm emailBindForm);

    @POST("/user/api/{version}/users/bind/email")
    Observable<HttpResponse> bindEmail(@Path("version") String str, @Body EmailBindForm emailBindForm, @Query("answer") List<String> list);

    @POST("/user/api/v1/user/bind/phone")
    Observable<HttpResponse> bindPhone(@Body PhoneBindForm phoneBindForm);

    @PUT("/user/api/v1/user/info")
    Observable<HttpResponse<User>> changeInfo(@Body User user);

    @PUT("/user/api/v2/user/nickName")
    Observable<HttpResponse<User>> changeNickName(@Query("newName") String str, @Query("oldName") String str2);

    @GET("/config/files/blockymods-check-version")
    Observable<HttpResponse<LatestVersion>> checkAppVersion();

    @POST("/user/api/v1/user/nickname/exist")
    Observable<HttpResponse> checkNickNameTimely(@Query("nickName") String str);

    @PUT("/user/api/v2/users/{userId}/daily/sign/in")
    Observable<HttpResponse> clickSignIn(@Path("userId") Long l, @Header(au.M) String str);

    @POST("/user/api/v1/user/mac/id")
    Observable<HttpResponse> countDaily(@Query("appType") String str, @Query("uuid") String str2);

    @POST("/user/api/v1/user/daily/life/info")
    Observable<HttpResponse> dailyLifeInfo(@Query("appType") String str, @Header(au.M) String str2);

    @GET("/user/api/v2/users/{userId}/daily/sign/in")
    Observable<HttpResponse<Map<String, DailySignInfo>>> dailySignIn(@Path("userId") Long l, @Header(au.M) String str);

    @GET("/config/files/indiegame-{gameId}")
    Observable<HttpResponse<AdsCdConfig>> getAdsCdConfig(@Path("gameId") String str);

    @PUT("/user/api/v1/users/{userId}/daily/tasks/ads")
    Observable<HttpResponse<RechargeEntity>> getAdsReward(@Path("userId") long j);

    @GET("/user/api/v1/users/{userId}/daily/tasks/ads/config")
    Observable<HttpResponse<DailyAdsTaskInfo>> getAdsRewardInfo(@Path("userId") long j);

    @GET("/user/api/v1/user/id/card/status")
    Observable<HttpResponse<String>> getAuthentication(@Query("userId") Long l);

    @GET("/user/api/v1/clan/decoration/advertising/{userId}")
    Observable<HttpResponse<DressAdsInfo>> getDressAdsInfo(@Header(au.M) String str);

    @PUT("/user/api/v1/clan/decoration/advertising/{userId}")
    Observable<HttpResponse<DressAdsReward>> getDressAdsReward(@Header(au.M) String str);

    @GET("/user/api/v1/user/profile/join/switch")
    Observable<HttpResponse<Integer>> getIsShowFriendInGame();

    @GET("/config/files/indiegame-new-{gameId}")
    Observable<HttpResponse<AdsCdConfig>> getNewAdsCdConfig(@Path("gameId") String str);

    @POST("/user/api/v1/users/prefect/info/reward/{userId}")
    Observable<HttpResponse<BuyGameResponse>> getPerfectUserInfoReward(@Path("userId") Long l, @Header(au.M) String str);

    @GET("/user/api/v1/users/device/token")
    Observable<HttpResponse<String>> getRongToken();

    @PUT("/user/api/v1/users/daily/sign/ads")
    Observable<HttpResponse<AdsSignReward>> getSignAdsReward(@Header(au.M) String str);

    @GET("/user/api/v1/videostars/config/get")
    Observable<HttpResponse<VideoStarConfig>> getStarCodeConfig(@Header(au.M) String str);

    @GET("/user/api/v1/videostars/billing/list/get")
    Observable<HttpResponse<StarCodeUserIncomePageData<StarCodeUserIncomeInfo>>> getStarCodeUserIncomeDetail(@Query("pageNo") int i, @Query("pageSize") int i2);

    @GET("/user/api/v1/videostars/getbycode")
    Observable<HttpResponse<StarCodeUser>> getStarCodeUserInfo(@Query("starCode") String str);

    @GET("/user/api/v1/users/security/bind/email")
    Observable<HttpResponse<String>> getTipsEmail(@Query("userId") Long l);

    @GET("/user/api/v1/data/frequently/game/{userId}")
    Observable<HttpResponse<List<String>>> getUserLikeGameList(@Path("userId") long j, @Query("count") int i, @Header(au.M) String str);

    @GET("/user/api/v1/users/secret/question")
    Observable<HttpResponse<List<SecretQuestionInfo>>> getUserQuestion(@Query("type") int i, @Header(au.M) String str);

    @GET("/user/api/v2/users/verify/user/security/settings")
    Observable<HttpResponse<UserVerifySettingsInfo>> getUserVerifySettingsInfo(@Query("userId") String str, @Header(au.M) String str2);

    @GET("/user/api/v1/user/player/info")
    Observable<HttpResponse<BuyVipEntity>> getVipInfo();

    @GET("/user/api/v1/user/nickName/free")
    Observable<HttpResponse<ModifyNameFreeResponse>> isChangeNameFree();

    @POST("/user/api/v1/users/prefect/info/reward/check/{userId}")
    Observable<HttpResponse<Boolean>> isRewardCheck(@Path("userId") Long l);

    Observable<HttpResponse<Boolean>> isRewardCheck(@Path("userId") Long l, @Header("userId") Long l2, @Header("Access-Token") String str);

    @GET("/config/files/blockmods-config-v1")
    Observable<HttpResponse<AppConfig>> loadAppConfig();

    @GET("/config/files/blockymods-banner")
    Observable<HttpResponse<List<BannerEntity>>> loadBannerUrls();

    @GET("/config/files/game-detail-to-editor")
    Observable<HttpResponse<Map<String, List<String>>>> loadEditorConfig();

    @GET("/config/files/name-sensitive-word-config")
    Observable<HttpResponse<List<String>>> loadSensitiveWordConfig();

    @GET("/config/files/blockymods-share-reward")
    Observable<HttpResponse<List<ShareRewardEntity>>> loadShareReward();

    @POST("/user/api/v1/login")
    Observable<HttpResponse<User>> login(@Body LoginRegisterAccountForm loginRegisterAccountForm);

    @POST("/user/api/v1/app/login")
    Observable<HttpResponse<User>> login(@Body LoginRegisterAccountForm loginRegisterAccountForm, @Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @PUT("/user/api/v1/user/login-out")
    Observable<HttpResponse> logout();

    @POST("/user/api/v1/user/password/modify")
    Observable<HttpResponse> modifyPassword(@Body ChangePasswordForm changePasswordForm);

    @GET("/config/files/indiegame-moregame_introduction")
    Observable<HttpResponse<List<BannerInfo>>> moreDialogBanner();

    @GET("/user/api/v1/users/new/daily/tasks")
    Observable<HttpResponse<DailyTaskResponse>> newSignInList();

    @POST("/user/api/v1/user/id/card/status")
    Observable<HttpResponse<String>> postAuthentication(@Body AuthenticationEntity authenticationEntity);

    @POST("/user/api/v1/report/push")
    Observable<HttpResponse> postReport(@Header(au.M) String str, @Body ReportRequest reportRequest);

    @POST("/user/api/v1/user/language")
    Observable<HttpResponse> postUserLanguage(@Query("userId") Long l, @Query(au.M) String str);

    @PUT("/user/api/v1/videostars/cashapply")
    Observable<HttpResponse<RechargeEntity>> putCashApply(@Body CashApplyInfo cashApplyInfo);

    @PUT("/user/api/v1/videostars/exchange")
    Observable<HttpResponse<RechargeEntity>> putCashExchange(@Header(au.M) String str);

    @POST("/user/api/v1/register")
    Observable<HttpResponse<User>> register(@Body LoginRegisterAccountForm loginRegisterAccountForm);

    @POST("/user/api/v1/app/renew")
    Observable<HttpResponse<AuthTokenResponse>> renew(@Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @POST("/user/api/v1/app/renew")
    Observable<HttpResponse<AuthTokenResponse>> renew(@Header("bmg-device-id") String str, @Header("bmg-sign") String str2, @Query(GameSharedConstant.ACCOUNT) String str3);

    @POST("/user/api/v1/report/status")
    Observable<HttpResponse<ReportInfo>> reportStatus(@Header(au.M) String str);

    @POST("/user/api/v1/emails/password/reset")
    Observable<HttpResponse> resetPassword(@Query("email") String str);

    @POST("/user/api/v1/users/question/reset/password")
    Observable<HttpResponse> resetPasswordBySecretQuestion(@Query("userId") long j, @Query("newPwd") String str, @Query(StringConstant.AUTHCODE) String str2);

    @POST("/user/api/v1/sms/send/refound")
    Observable<HttpResponse> retrieve(@Query("phone") String str, @Query("type") String str2);

    @POST("/user/api/v1/user/password")
    Observable<HttpResponse> retrievePassword(@Body PhoneBindForm phoneBindForm);

    @POST("/user/api/v1/sms/send/{phone}")
    Observable<HttpResponse> sendCode(@Path("phone") String str, @Query("type") String str2);

    @POST("/user/api/v1/emails/{email}")
    Observable<HttpResponse> sendEmailCode(@Query("email") String str);

    @POST("/user/api/v1/emails/verify/{email}")
    Observable<HttpResponse> sendEmailVerifyCode(@Path("email") String str, @Query("unbindType") int i);

    @POST("/user/api/v1/users/security/verify/email/reset")
    Observable<HttpResponse<Object>> sendFullEmailToVerify(@Query("userId") Long l, @Query("email") String str, @Query("type") String str2);

    @POST("/user/api/v1/user/profile/join/switch")
    Observable<HttpResponse<Integer>> setIsShowFriendInGame();

    @POST("/user/api/v1/app/set-password")
    Observable<HttpResponse> setPassword(@Body SetPasswordForm setPasswordForm, @Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @POST("/user/api/{version}/users/secret/question/setting")
    Observable<HttpResponse> setUserQuestion(@Path("version") String str, @Header(au.M) String str2, @Body List<SecretQuestionInfo> list, @Query(StringConstant.AUTHCODE) String str3);

    @POST("/user/api/v1/users/sharing/reward")
    Observable<HttpResponse> shareReward(@Query("type") String str);

    @PUT("/user/api/v1/users/tasks/{type}")
    Observable<HttpResponse<RechargeEntity>> signIn(@Path("type") int i);

    @GET("/user/api/v1/users/dairy/tasks/{type}")
    Observable<HttpResponse<WeekTaskResponse>> signInList(@Path("type") int i);

    @DELETE("/user/api/v1/users/{userId}/emails")
    Observable<HttpResponse> unbindEmail(@Path("userId") Long l);

    @DELETE("/user/api/v2/users/{userId}/emails")
    Observable<HttpResponse> unbindEmail(@Path("userId") Long l, @Query("email") String str, @Query("verifyCode") String str2);

    @POST("/user/api/v1/user/unbind/phone")
    Observable<HttpResponse> unbindPhone(@Body PhoneBindForm phoneBindForm);

    @POST("/user/api/v1/users/unbind/user/security")
    Observable<HttpResponse> unbindUserSecretQuestion(@Body VerifyEmailForm verifyEmailForm);

    @POST("/user/api/v1/user/details/info")
    Observable<HttpResponse<User>> updateUserInfo();

    @PUT("/user/api/v1/user/device/id")
    Observable<HttpResponse> uploadDeviceId(@Body DeviceIdEntity deviceIdEntity);

    @POST("/user/api/v1/user/mac/id")
    Observable<HttpResponse> uploadID(@Query("appType") String str, @Query("uuid") String str2);

    @POST("/user/api/v1/file")
    @Multipart
    Observable<HttpResponse<String>> uploadIcon(@Query("fileName") String str, @Query("fileType") String str2, @Part x.b bVar);

    @POST("/user/api/v1/user/register")
    Observable<HttpResponse<User>> userRegister(@Body RegisterInfo registerInfo);

    @POST("/user/api/v1/users/verify/email")
    Observable<HttpResponse> verifyEmail(@Body VerifyEmailForm verifyEmailForm);

    @POST("/user/api/v1/users/security/verify/email")
    Observable<HttpResponse<SecurityVerifyResponse>> verifyEmailBeforeSetSecretQuestion(@Body VerifyEmailForm verifyEmailForm);

    @POST("/user/api/v1/visitor")
    Observable<HttpResponse<Visitor>> visitor(@Body LoginRegisterAccountForm loginRegisterAccountForm);
}
