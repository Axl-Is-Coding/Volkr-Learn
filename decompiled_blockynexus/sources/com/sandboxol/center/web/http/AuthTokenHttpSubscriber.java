package com.sandboxol.center.web.http;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.BaseSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseExceptionListener;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.HttpException;

/* JADX INFO: loaded from: classes3.dex */
public class AuthTokenHttpSubscriber<T, R extends HttpResponse<T>> extends BaseSubscriber<T, R> {
    protected ReplyCommand command;
    protected OnResponseListener<T> listener;

    public AuthTokenHttpSubscriber(OnResponseListener<T> onResponseListener, ReplyCommand replyCommand) {
        super(onResponseListener);
        this.listener = onResponseListener;
        this.command = replyCommand;
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber, rx.Observer
    public void onError(Throwable th) {
        OnResponseListener<T> onResponseListener = this.listener;
        if (onResponseListener != null) {
            if (!(th instanceof HttpException)) {
                if ((th instanceof ConnectException) || (th instanceof UnknownHostException)) {
                    this.listener.onServerError(10000);
                    return;
                }
                if (th instanceof SocketTimeoutException) {
                    onResponseListener.onServerError(5);
                    return;
                } else if (th instanceof RuntimeException) {
                    onResponseListener.onServerError(-1);
                    return;
                } else {
                    onResponseListener.onServerError(com.sandboxol.common.config.HttpCode.UN_KNOW);
                    return;
                }
            }
            int iCode = ((HttpException) th).code();
            if (iCode == 401) {
                if (this.command != null) {
                    UserApi.getToken(BaseApplication.getContext(), new OnResponseListener<AuthTokenResponse>() { // from class: com.sandboxol.center.web.http.AuthTokenHttpSubscriber.1
                        @Override // com.sandboxol.common.base.web.OnResponseListener
                        public void onError(int i, String str) {
                            MessagerClient.getIns().sendMsg0(CommonMessageToken.TOKEN_REPEAT_LOGIN);
                            AccountCenter.newInstance().login.set(false);
                        }

                        @Override // com.sandboxol.common.base.web.OnResponseListener
                        public void onServerError(int i) {
                            MessagerClient.getIns().sendMsg0(CommonMessageToken.TOKEN_REPEAT_LOGIN);
                            AccountCenter.newInstance().login.set(false);
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
                            Messenger.getDefault().sendNoMsg(CommonMessageToken.TOKEN_REPEAT_LOGIN);
                            AuthTokenHttpSubscriber.this.listener.retry();
                            AuthTokenHttpSubscriber.this.command.execute();
                        }
                    });
                }
            } else {
                if (iCode != 403) {
                    this.listener.onServerError(iCode);
                    return;
                }
                OnResponseListener<T> onResponseListener2 = this.listener;
                if (onResponseListener2 instanceof OnResponseExceptionListener) {
                    ((OnResponseExceptionListener) onResponseListener2).onErrorWithData(iCode, th);
                } else {
                    MessagerClient.getIns().sendMsg0(CommonMessageToken.TOKEN_REPEAT_LOGIN);
                }
            }
        }
    }
}
