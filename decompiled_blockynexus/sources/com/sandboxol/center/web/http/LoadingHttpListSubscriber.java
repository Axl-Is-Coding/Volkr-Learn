package com.sandboxol.center.web.http;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.utils.DialogUtilsWrap;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LoadingHttpListSubscriber<T, R extends HttpResponse<List<T>>> extends AuthTokenHttpSubscriber<List<T>, R> {
    private Context context;
    private boolean isShowLoading;

    public LoadingHttpListSubscriber(Context context, OnResponseListener<List<T>> onResponseListener, ReplyCommand replyCommand) {
        super(onResponseListener, replyCommand);
        this.context = context;
    }

    @Override // com.sandboxol.center.web.http.AuthTokenHttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }

    @Override // com.sandboxol.center.web.http.AuthTokenHttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber, rx.Observer
    public void onError(Throwable th) {
        if (this.isShowLoading) {
            DialogUtilsWrap.newsInstant().hideLoadingDialog();
        }
        super.onError(th);
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber, rx.Subscriber
    public void onStart() {
        if (this.isShowLoading) {
            DialogUtilsWrap.newsInstant().showLoadingDialog(this.context);
        }
        super.onStart();
    }

    @Override // com.sandboxol.common.base.web.BaseSubscriber, rx.Observer
    public void onNext(R r) {
        if (this.isShowLoading) {
            DialogUtilsWrap.newsInstant().hideLoadingDialog();
        }
        switch (r.getCode()) {
            case 1004:
                Log.e("onNext", "");
                break;
            case 1005:
                Log.e("onNext", "");
                break;
            case HttpCode.PASSWORD_NOT_SET /* 1006 */:
                Log.e("onNext", "");
                break;
            case HttpCode.THIRD_PART_ACCOUNT_ALREADY_BIND_OTHER_USER /* 1007 */:
                Log.e("onNext", "");
                break;
            default:
                super.onNext(r);
                break;
        }
    }

    public LoadingHttpListSubscriber(Context context, OnResponseListener<List<T>> onResponseListener, ReplyCommand replyCommand, boolean z) {
        super(onResponseListener, replyCommand);
        this.context = context;
        this.isShowLoading = z;
    }
}
