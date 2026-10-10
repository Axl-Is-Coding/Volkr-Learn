package com.sandboxol.center.web.http;

import android.content.Context;
import com.sandboxol.center.utils.DialogUtilsWrap;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class LoadingHttpSubscriber<T, R extends HttpResponse<T>> extends AuthTokenHttpSubscriber<T, R> {
    private Context context;
    private boolean isShowLoading;

    public LoadingHttpSubscriber(Context context, OnResponseListener<T> onResponseListener, ReplyCommand replyCommand) {
        super(onResponseListener, replyCommand);
        this.context = context;
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
        super.onNext((HttpResponse) r);
    }

    public LoadingHttpSubscriber(Context context, OnResponseListener<T> onResponseListener, ReplyCommand replyCommand, boolean z) {
        super(onResponseListener, replyCommand);
        this.context = context;
        this.isShowLoading = z;
    }
}
