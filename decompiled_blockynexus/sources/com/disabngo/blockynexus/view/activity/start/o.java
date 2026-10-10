package com.disabngo.blockynexus.view.activity.start;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseExceptionListener;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.User;
import java.io.IOException;
import java.io.InputStream;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: StartActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseExceptionListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AuthTokenResponse f11118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f11119c;

    o(p pVar, Context context, AuthTokenResponse authTokenResponse) {
        this.f11119c = pVar;
        this.f11117a = context;
        this.f11118b = authTokenResponse;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        AccountManager.getInstance().onUpdateAcount(this.f11117a, user);
        LoginManager.onUpdateUser(user);
        SharedUtils.remove(this.f11117a, SharedConstant.REPORT_INFO);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_AUTH_TOKEN_FINISH);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 1002) {
            AccountCenter.logout();
            AccountCenter.newInstance().hasBinding.set(Boolean.valueOf(this.f11118b.isHasBinding()));
            AccountCenter.newInstance().userId.set(Long.valueOf(this.f11118b.getUserId()));
            AccountCenter.newInstance().token.set(this.f11118b.getAccessToken());
            BaseApplication.getApp().setUserId(this.f11118b.getUserId());
            BaseApplication.getApp().setAccessToken(this.f11118b.getAccessToken());
            AccountCenter.newInstance().login.set(true);
            AccountCenter.putAccountInfo();
        }
        Log.e("updateUserInfo", "" + str);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_AUTH_TOKEN_FINISH);
    }

    @Override // com.sandboxol.common.base.web.OnResponseExceptionListener
    public void onErrorWithData(int i, final Throwable th) {
        if (th instanceof HttpException) {
            Observable.create(new Observable.OnSubscribe() { // from class: com.disabngo.blockynexus.view.activity.start.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    o.a(th, (Subscriber) obj);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this));
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_AUTH_TOKEN_FINISH);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("updateUserInfo", String.valueOf(i));
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_AUTH_TOKEN_FINISH);
    }

    static /* synthetic */ void a(Throwable th, Subscriber subscriber) {
        try {
            InputStream inputStreamByteStream = ((HttpException) th).response().errorBody().byteStream();
            String strInputStream2String = CommonHelper.inputStream2String(inputStreamByteStream);
            inputStreamByteStream.close();
            subscriber.onNext(strInputStream2String);
            subscriber.onCompleted();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
