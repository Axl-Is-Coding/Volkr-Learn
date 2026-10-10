package com.sandboxol.center.web.http;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AuthTokenHttpListSubscriber<T, R extends HttpResponse<List<T>>> extends AuthTokenHttpSubscriber<List<T>, R> {
    public AuthTokenHttpListSubscriber(OnResponseListener<List<T>> onResponseListener, ReplyCommand replyCommand) {
        super(onResponseListener, replyCommand);
    }

    @Override // com.sandboxol.center.web.http.AuthTokenHttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
    public boolean isCheckNetwork() {
        return false;
    }
}
