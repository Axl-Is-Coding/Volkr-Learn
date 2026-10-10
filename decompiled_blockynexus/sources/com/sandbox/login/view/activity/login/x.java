package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseExceptionListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;
import java.io.IOException;
import java.io.InputStream;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: LoginModel.java */
/* JADX INFO: loaded from: classes2.dex */
class x extends OnResponseExceptionListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginRegisterAccountForm f15962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ y.a f15963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ y f15964d;

    x(y yVar, Context context, LoginRegisterAccountForm loginRegisterAccountForm, y.a aVar) {
        this.f15964d = yVar;
        this.f15961a = context;
        this.f15962b = loginRegisterAccountForm;
        this.f15963c = aVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        AccountManager.getInstance().onLoginFinish(this.f15961a, this.f15962b, user);
        y.a aVar = this.f15963c;
        if (aVar != null) {
            aVar.onSuccess();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 1002) {
            AccountCenter.newInstance().nickName.set(this.f15961a.getString(R.string.more_fragment_visitor));
            AccountCenter.newInstance().account.set(this.f15961a.getString(R.string.base_more_user_no_account));
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS);
            AppInfoCenter.newInstance().setAuthTokenSuccess(true);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_FINISH);
            Messenger.getDefault().send(1, MessageToken.TOKEN_LOGIN_REGISTER_SUCCESS);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
            ((Activity) this.f15961a).finish();
        } else {
            UserOnError.showErrorTip(this.f15961a, i);
        }
        y.a aVar = this.f15963c;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseExceptionListener
    public void onErrorWithData(int i, final Throwable th) {
        y.a aVar = this.f15963c;
        if (aVar != null) {
            aVar.a();
        }
        if (th instanceof HttpException) {
            Observable.create(new Observable.OnSubscribe() { // from class: com.sandbox.login.view.activity.login.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    x.a(th, (Subscriber) obj);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(this));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (i == 403) {
            Context context = this.f15961a;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.login_report_tip, AccountCenter.newInstance().userId.get()));
        } else {
            ServerOnError.showOnServerError(this.f15961a, i);
        }
        y.a aVar = this.f15963c;
        if (aVar != null) {
            aVar.a();
        }
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
