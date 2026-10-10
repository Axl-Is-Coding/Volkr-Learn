package com.sandbox.login.web;

import com.sandbox.login.entity.AccountRecordResult;
import com.sandboxol.blocky.config.GameSharedConstant;
import com.sandboxol.center.entity.ChangePasswordForm;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.greendao.entity.User;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public interface IUserLoginApi {
    @POST("/user/api/v1/account/invalid/check")
    Observable<HttpResponse<Boolean>> accountCheck(@Header("bmg-device-id") String str, @Header("bmg-sign") String str2, @Query(GameSharedConstant.ACCOUNT) String str3, @Query("userId") long j, @Query("type") String str4);

    @POST("/user/api/v1/user/account/modify")
    Observable<HttpResponse> accountModify(@Query(GameSharedConstant.ACCOUNT) String str);

    @GET("/user/api/v1/user/login/change/record")
    Observable<HttpResponse<AccountRecordResult>> accountRecord(@Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @POST("/user/api/v1/login")
    Observable<HttpResponse<User>> login(@Body LoginRegisterAccountForm loginRegisterAccountForm);

    @POST("/user/api/v2/app/login")
    Observable<HttpResponse<User>> login(@Body LoginRegisterAccountForm loginRegisterAccountForm, @Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @POST("/user/api/v2/user/password/modify")
    Observable<HttpResponse> modifyPassword(@Body ChangePasswordForm changePasswordForm);

    @GET("/user/api/v1/user/set-psd/param/check")
    Observable<HttpResponse<Long>> paramCheck(@Query("type") String str);

    @POST("/user/api/v1/user/password/check")
    Observable<HttpResponse<Boolean>> passwordCheck(@Query("password") String str);

    @POST("/user/api/v2/app/set-password")
    Observable<HttpResponse> setPassword(@Body SetPasswordForm setPasswordForm, @Header("bmg-device-id") String str, @Header("bmg-sign") String str2);

    @POST("/user/api/v1/app/user/tourist/login")
    Observable<HttpResponse<User>> touristLogin(@Header("bmg-device-id") String str, @Header("bmg-sign") String str2, @Query("appType") String str3);
}
