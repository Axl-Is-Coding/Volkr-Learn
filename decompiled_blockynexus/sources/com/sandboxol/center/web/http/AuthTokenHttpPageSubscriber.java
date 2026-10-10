package com.sandboxol.center.web.http;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: loaded from: classes3.dex */
public class AuthTokenHttpPageSubscriber<T, R extends HttpResponse<PageData<T>>> extends AuthTokenHttpSubscriber<PageData<T>, R> {
    public AuthTokenHttpPageSubscriber(OnResponseListener<PageData<T>> onResponseListener, ReplyCommand replyCommand) {
        super(onResponseListener, replyCommand);
    }

    @Override // com.sandboxol.center.web.http.AuthTokenHttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }
}
