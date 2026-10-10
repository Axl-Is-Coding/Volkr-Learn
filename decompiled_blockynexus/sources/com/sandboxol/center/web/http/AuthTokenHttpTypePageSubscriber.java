package com.sandboxol.center.web.http;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.TypePageData;

/* JADX INFO: loaded from: classes3.dex */
public class AuthTokenHttpTypePageSubscriber<T, R extends HttpResponse<TypePageData<T>>> extends AuthTokenHttpSubscriber<TypePageData<T>, R> {
    public AuthTokenHttpTypePageSubscriber(OnResponseListener<TypePageData<T>> onResponseListener, ReplyCommand replyCommand) {
        super(onResponseListener, replyCommand);
    }

    @Override // com.sandboxol.center.web.http.AuthTokenHttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }
}
