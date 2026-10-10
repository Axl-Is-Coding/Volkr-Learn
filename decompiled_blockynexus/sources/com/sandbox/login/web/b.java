package com.sandbox.login.web;

import android.content.Context;
import com.sandbox.login.e.e;
import com.sandbox.login.entity.AccountRecordResult;
import com.sandboxol.center.entity.ChangePasswordForm;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.center.web.http.LoginSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.User;
import com.trello.rxlifecycle.ActivityEvent;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: UserLoginApi.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IUserLoginApi f16012a = (IUserLoginApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IUserLoginApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnResponseListener<User> onResponseListener) {
        LoginRegisterAccountForm loginRegisterAccountFormM82clone = loginRegisterAccountForm.m82clone();
        if (loginRegisterAccountFormM82clone.getPassword() != null) {
            loginRegisterAccountFormM82clone.setPassword(e.b(loginRegisterAccountFormM82clone.getPassword()));
        }
        f16012a.login(loginRegisterAccountFormM82clone, CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoginSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context context, String str, OnResponseListener<Long> onResponseListener) {
        f16012a.paramCheck(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Context context, String str, OnResponseListener<Boolean> onResponseListener) {
        f16012a.passwordCheck(e.b(str)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(final Context context, final OnResponseListener<User> onResponseListener) {
        f16012a.touristLogin(CommonHelper.getAndroidId(context), CommonHelper.getSignature(context), "android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandbox.login.web.a
            @Override // rx.functions.Action0
            public final void call() {
                b.c(context, onResponseListener);
            }
        })));
    }

    public static void a(LoginRegisterAccountForm loginRegisterAccountForm, OnResponseListener<User> onResponseListener) {
        f16012a.login(loginRegisterAccountForm).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<User>>) new LoginSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, String str, long j, String str2, OnResponseListener<Boolean> onResponseListener) {
        f16012a.accountCheck(CommonHelper.getAndroidId(context), CommonHelper.getSignature(context), str, j, str2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, String str, OnResponseListener onResponseListener) {
        f16012a.accountModify(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, OnResponseListener<AccountRecordResult> onResponseListener) {
        f16012a.accountRecord(CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, SetPasswordForm setPasswordForm, OnResponseListener onResponseListener) {
        SetPasswordForm setPasswordForm2 = new SetPasswordForm(setPasswordForm);
        if (setPasswordForm.getPassword() != null) {
            setPasswordForm2.setPassword(e.b(setPasswordForm2.getPassword()));
        }
        if (setPasswordForm.getConfirmPassword() != null) {
            setPasswordForm2.setConfirmPassword(e.b(setPasswordForm2.getConfirmPassword()));
        }
        f16012a.setPassword(setPasswordForm2, CommonHelper.getAndroidId(context), CommonHelper.getSignature(context)).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context, ChangePasswordForm changePasswordForm, OnResponseListener onResponseListener) {
        ChangePasswordForm changePasswordForm2 = new ChangePasswordForm(changePasswordForm);
        if (changePasswordForm2.getOldPassword() != null) {
            changePasswordForm2.setOldPassword(e.b(changePasswordForm2.getOldPassword()));
        }
        if (changePasswordForm2.getNewPassword() != null) {
            changePasswordForm2.setNewPassword(e.b(changePasswordForm2.getNewPassword()));
        }
        f16012a.modifyPassword(changePasswordForm2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }
}
