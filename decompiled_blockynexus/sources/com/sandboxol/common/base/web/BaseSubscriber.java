package com.sandboxol.common.base.web;

import android.util.Log;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.config.HttpCode;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.NetworkUtil;
import com.sandboxol.messager.MessagerClient;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.HttpException;
import rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSubscriber<T, R extends HttpResponse<T>> extends Subscriber<R> {
    protected OnResponseListener<T> listener;

    public BaseSubscriber(OnResponseListener<T> onResponseListener) {
        this.listener = onResponseListener;
    }

    public IOnResponseAdapter<T> getOnResponseAdapter() {
        return new OnResponseAdapter();
    }

    public abstract boolean isCheckNetwork();

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        OnResponseListener<T> onResponseListener = this.listener;
        if (onResponseListener != null) {
            if (th instanceof HttpException) {
                int iCode = ((HttpException) th).code();
                if (iCode == 401) {
                    MessagerClient.getIns().sendMsg0(CommonMessageToken.TOKEN_REPEAT_LOGIN);
                }
                this.listener.onServerError(iCode);
                return;
            }
            if ((th instanceof ConnectException) || (th instanceof UnknownHostException)) {
                this.listener.onServerError(10000);
                return;
            }
            if (th instanceof SocketTimeoutException) {
                onResponseListener.onServerError(10001);
            } else if (th instanceof RuntimeException) {
                onResponseListener.onServerError(-1);
                ReportDataAdapter.onEvent(BaseApplication.getContext(), CommonMessageToken.TOKEN_HTTP_REQUEST_RUN_TIME_EXCEPTION, th.getMessage());
            } else {
                onResponseListener.onServerError(HttpCode.UN_KNOW);
                ReportDataAdapter.onEvent(BaseApplication.getContext(), CommonMessageToken.TOKEN_HTTP_REQUEST_UN_KNOW_EXCEPTION, th.getMessage());
            }
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        super.onStart();
        if (isCheckNetwork() && !NetworkUtil.isNetworkConnected(BaseApplication.getContext())) {
            onError(new ConnectException("no connect exception"));
        }
    }

    @Override // rx.Observer
    public void onNext(R r) {
        if (r.getCode() == 4) {
            this.listener.onServerError(4);
            Log.e("INNER_ERROR", this.listener.toString());
            return;
        }
        if (r.getCode() == 5) {
            this.listener.onServerError(5);
            return;
        }
        if (r.getCode() == 429) {
            this.listener.onServerError(429);
            return;
        }
        if (r.getCode() == 504) {
            this.listener.onServerError(504);
        } else if (r.getCode() == 17) {
            this.listener.onError(17, r.getMessage());
        } else {
            getOnResponseAdapter().onResponse(r, this.listener);
        }
    }
}
